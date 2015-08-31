package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TeachingGroupConverter;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.dao.StaffPersonalDAO;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.dao.TeachingGroupDAO;
import sif3.hits.domain.dao.TeachingGroupTeacherDAO;
import sif3.hits.domain.dao.TimeTableCellDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
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
  private StaffPersonalDAO staffPersonalDAO;

  @Autowired
  private StudentPersonalDAO studentPersonalDAO;

  @Autowired
  private SchoolInfoDAO schoolInfoDAO;

  @Autowired
  private TeachingGroupDAO teachingGroupDAO;
  
  @Autowired
  private TeachingGroupTeacherDAO teachingGroupTeacherDAO;

  @Autowired
  private TimeTableCellDAO timeTableCellDAO;

  @Override
  public JpaRepository<TeachingGroup, String> getDAO() {
    return teachingGroupDAO;
  }

  @Override
  public ZoneFilterableRepository<TeachingGroup> getZoneFilterableDAO() {
    return teachingGroupDAO;
  }

  @Autowired
  private TeachingGroupConverter teachingGroupConverter;

  @Override
  public HitsConverter<TeachingGroupType, TeachingGroup> getConverter() {
    return teachingGroupConverter;
  }

  @Override
  protected TeachingGroupCollectionType getCollection(List<TeachingGroupType> items) {
    TeachingGroupCollectionType result = new TeachingGroupCollectionType();
    if (items != null) {
      result.getTeachingGroup().addAll(items);
    }
    return result;
  }

  @Override
  protected TeachingGroup getFiltered(String refId, java.util.List<String> schoolRefIds) {
    TeachingGroup result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = teachingGroupDAO.findOne(refId);
      if (result != null && result.getSchoolInfo() != null) {
        if (!schoolRefIds.contains(result.getSchoolInfo().getRefId())) {
          result = null;
        }
      }
    }
    return result;
  }
  
  private void deleteTeachingGroupTeachers(TeachingGroup hitsObject) {
    teachingGroupTeacherDAO.deleteAllWithTeachingGroup(hitsObject);
  }

  @Override
  @Transactional(value = "transactionManager")
  protected TeachingGroup save(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto, String zoneId,
      boolean create) {
    
    TeachingGroup result = null;
    
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
    HashSet<TimeTableCell> timeTablePeriods = new HashSet<TimeTableCell>();
    if (hitsObject.getTimeTablePeriods() != null) {
      for (TimeTableCell timeTableCell : hitsObject.getTimeTablePeriods()) {
        TimeTableCell timeTablePeriod = getTimeTablePeriod(timeTableCell, zoneId);
        if (timeTablePeriod != null) {
          timeTablePeriods.add(timeTablePeriod);
        }
      }
    }
    hitsObject.setTimeTablePeriods(timeTablePeriods);
    
    if (!create) {
      deleteTeachingGroupTeachers(hitsObject);
    }
    if (hitsObject.getTeachingGroupTeachers() != null && !hitsObject.getTeachingGroupTeachers().isEmpty()) {
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
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }

  private StaffPersonal getTeachingGroupTeacher(StaffPersonal staffPersonal, String zoneId) {
    StaffPersonal result = null;
    if (staffPersonal != null) {
      result = staffPersonalDAO.findOneWithFilter(staffPersonal.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }

  private StudentPersonal getTeachingGroupStudent(StudentPersonal studentPersonal, String zoneId) {
    StudentPersonal result = null;
    if (studentPersonal != null) {
      result = studentPersonalDAO.findOneWithFilter(studentPersonal.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }

  private SchoolInfo getSchoolInfo(SchoolInfo schoolInfo, String zoneId) {
    SchoolInfo result = null;
    if (schoolInfo != null) {
      result = schoolInfoDAO.findOneWithFilter(schoolInfo.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }

  private TimeTableCell getTimeTablePeriod(TimeTableCell timeTableCell, String zoneId) {
    TimeTableCell result = null;
    if (timeTableCell != null) {
      result = timeTableCellDAO.findOneWithFilter(timeTableCell.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }
}
