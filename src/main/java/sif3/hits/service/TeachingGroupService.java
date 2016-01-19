package sif3.hits.service;

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
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;
import sif3.hits.domain.model.TimeTableCell;
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
  protected void deleteChildObjects(TeachingGroup hitsObject) {
    teachingGroupTeacherDAO.deleteAllWithTeachingGroup(hitsObject);
  }

  @Override
  protected TeachingGroup preSave(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto, String zoneId, boolean create) {
    // Populate list of Students
    Set<StudentPersonal> teachingGroupStudents = new HashSet<StudentPersonal>();
    if (hitsObject.getStudentPersonals() != null) {
      for (StudentPersonal studentPersonal : hitsObject.getStudentPersonals()) {
        StudentPersonal teachingGroupStudent = getTeachingGroupStudent(studentPersonal, zoneId);
        if (teachingGroupStudent != null) {
          teachingGroupStudents.add(teachingGroupStudent);
        }
      }
    }
    hitsObject.setStudentPersonals(teachingGroupStudents);

    // Populate School
    hitsObject.setSchoolInfo(getSchoolInfo(hitsObject.getSchoolInfo(), zoneId));

    // Save and/or find TimeTableCells
    HashSet<TimeTableCell> timeTableCells = new HashSet<TimeTableCell>();
    if (hitsObject.getTimeTablePeriods() != null) {
      for (TimeTableCell timeTablePeriod : hitsObject.getTimeTablePeriods()) {
        TimeTableCell timeTableCell = getTimeTableCell(timeTablePeriod, zoneId);
        if (timeTableCell != null) {
          timeTableCells.add(timeTableCell);
        }
      }
    }
    hitsObject.setTimeTablePeriods(timeTableCells);
    return null;
  }

  private StudentPersonal getTeachingGroupStudent(StudentPersonal studentPersonal, String zoneId) {
    StudentPersonal result = null;
    if (studentPersonal != null) {
      result = studentPersonalFilterDAO.findOneWithZone(studentPersonal.getRefId(), zoneId);
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

  private TimeTableCell getTimeTableCell(TimeTableCell timeTableCell, String zoneId) {
    TimeTableCell result = null;
    if (timeTableCell != null) {
      result = timeTableCellFilterDAO.findOneWithZone(timeTableCell.getRefId(), zoneId);
    }
    return result;
  }

  @Override
  protected boolean hasChildObjects(TeachingGroup hitsObject) {
    return hitsObject != null & hitsObject.getTeachingGroupTeachers() != null && !hitsObject.getTeachingGroupTeachers().isEmpty();
  }

  @Override
  protected TeachingGroup saveWithChildObjects(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto, String zoneId, boolean create) {
    TeachingGroup result = null;
    Set<TeachingGroupTeacher> teachers = new HashSet<TeachingGroupTeacher>();
    teachers.addAll(hitsObject.getTeachingGroupTeachers());
    hitsObject.getTeachingGroupTeachers().clear();
    result = super.save(hitsObject, dto, zoneId, create);
    for (TeachingGroupTeacher teacher : teachers) {
      StaffPersonal staffPersonal = getTeachingGroupTeacher(teacher.getStaffPersonal(), zoneId);
      if (staffPersonal != null) {
        teacher.setTeachingGroup(hitsObject);
        teacher.setStaffPersonal(staffPersonal);
        teachingGroupTeacherDAO.save(teacher);
        result.getTeachingGroupTeachers().add(teacher);
      }
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
}
