package sif3.hits.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TeachingGroupConverter;
import sif3.hits.domain.dao.TeachingGroupDAO;
import sif3.hits.domain.dao.TeachingGroupTeacherDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.SchoolInfoFilterDAO;
import sif3.hits.domain.dao.filter.StaffPersonalFilterDAO;
import sif3.hits.domain.dao.filter.StudentPersonalFilterDAO;
import sif3.hits.domain.dao.filter.TeachingGroupFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableCellFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableSubjectFilterDAO;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;
import sif3.hits.domain.model.TimeTableCell;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TeachingGroupService extends BaseService<TeachingGroupType, TeachingGroupCollectionType, TeachingGroup> {

  @Autowired
  private TeachingGroupConverter teachingGroupConverter;

  @Autowired
  private TeachingGroupDAO teachingGroupDAO;

  @Autowired
  private TeachingGroupFilterDAO teachingGroupFilterDAO;

  @Autowired
  private StudentPersonalFilterDAO studentPersonalFilterDAO;

  @Autowired
  private SchoolInfoFilterDAO schoolInfoFilterDAO;

  @Autowired
  private TimeTableSubjectFilterDAO timeTableSubjectFilterDAO;

  @Autowired
  private TimeTableCellFilterDAO timeTableCellFilterDAO;

  @Autowired
  private StaffPersonalFilterDAO staffPersonalFilterDAO;

  @Autowired
  private TeachingGroupTeacherDAO teachingGroupTeacherDAO;

  @Override
  protected TeachingGroupCollectionType getCollection(List<TeachingGroupType> items) {
    TeachingGroupCollectionType result = new TeachingGroupCollectionType();
    if (items != null) {
      result.getTeachingGroup().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<TeachingGroupType, TeachingGroup> getConverter() {
    return teachingGroupConverter;
  }

  @Override
  protected JpaRepository<TeachingGroup, String> getDAO() {
    return teachingGroupDAO;
  }

  @Override
  protected FilterableRepository<TeachingGroup> getFilterableDAO() {
    return teachingGroupFilterDAO;
  }

  @Override
  protected TeachingGroup preSave(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto, String zoneId, boolean create) {
    // Save and/or find TimeTableCells
    List<TimeTableCell> finalPeriods = new ArrayList<>();
    List<String> timeTableCells = new ArrayList<>();
    for (TimeTableCell timeTablePeriod : hitsObject.getTimeTablePeriods()) {
      if (timeTablePeriod.isTemporary()) {
        timeTableCells.add(timeTablePeriod.getRefId());
      } else {
        finalPeriods.add(timeTablePeriod);
      }
    }
    hitsObject.getTimeTablePeriods().clear();
    for (String refId : timeTableCells) {
      TimeTableCell period = getTimeTableCell(refId, zoneId);
      if (period != null) {
        finalPeriods.add(period);
      }
    }
    
    // Populate list of Students
    List<StudentPersonal> finalStudents = new ArrayList<>();
    for (StudentPersonal studentPersonal : hitsObject.getStudentPersonals()) {
      if (studentPersonal.isTemporary()) {
        StudentPersonal teachingGroupStudent = getTeachingGroupStudent(studentPersonal, zoneId);
        if (teachingGroupStudent != null) {
          finalStudents.add(teachingGroupStudent);
        }
      } else {
        finalStudents.add(studentPersonal);
      }
    }
    hitsObject.getStudentPersonals().clear();
    hitsObject.getStudentPersonals().addAll(finalStudents);

    for (TeachingGroupTeacher teachingGroupTeacher : hitsObject.getTeachingGroupTeachers()) {
      if (teachingGroupTeacher.getTeachingGroup() == null) {
        StaffPersonal staffPersonal = getTeachingGroupTeacher(teachingGroupTeacher.getStaffPersonal(), zoneId);
        if (staffPersonal != null) {
          teachingGroupTeacher.setStaffPersonal(staffPersonal);
          teachingGroupTeacher.setTeachingGroup(hitsObject);
        }
      }
    }


    
    // Populate Subject
    hitsObject.setTimeTableSubject(getTimeTableSubject(hitsObject.getTimeTableSubject(), zoneId));

    // Populate School
    hitsObject.setSchoolInfo(getSchoolInfo(hitsObject.getSchoolInfo(), zoneId));
    
    getDAO().save(hitsObject);
    for (TimeTableCell cell : finalPeriods) {
      cell.setTeachingGroup(hitsObject);
      hitsObject.getTimeTablePeriods().add(cell);
    }
    
    return hitsObject;
  }


  private StudentPersonal getTeachingGroupStudent(StudentPersonal studentPersonal, String zoneId) {
    StudentPersonal result = null;
    if (studentPersonal != null) {
      result = studentPersonalFilterDAO.findOneWithZone(studentPersonal.getRefId(), zoneId);
    }
    return result;
  }

  private StaffPersonal getTeachingGroupTeacher(StaffPersonal staffPersonal, String zoneId) {
    StaffPersonal result = null;
    if (staffPersonal != null) {
      result = staffPersonalFilterDAO.findOneWithZone(staffPersonal.getRefId(), zoneId);
    }
    return result;
  }

  private SchoolInfo getSchoolInfo(SchoolInfo schoolInfo, String zoneId) {
    SchoolInfo result = null;
    if (schoolInfo != null) {
      result = schoolInfoFilterDAO.findOneWithZone(schoolInfo.getRefId(), zoneId);
    }
    return result;
  }

  private TimeTableSubject getTimeTableSubject(TimeTableSubject subject, String zoneId) {
    TimeTableSubject result = null;
    if (subject != null) {
      result = timeTableSubjectFilterDAO.findOneWithZone(subject.getRefId(), zoneId);
    }
    return result;
  }

  private TimeTableCell getTimeTableCell(String refId, String zoneId) {
    TimeTableCell result = null;
    if (refId != null) {
      result = timeTableCellFilterDAO.findOneWithZone(refId, zoneId);
    }
    return result;
  }
}
