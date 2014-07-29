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
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TeachingGroupConverter;
import sif3.hits.domain.dao.RoomInfoDAO;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.dao.StaffPersonalDAO;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.dao.TeachingGroupDAO;
import sif3.hits.domain.dao.TimeTableCellDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;
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
  private TimeTableCellDAO timeTableCellDAO;

  @Autowired
  private RoomInfoDAO roomInfoDAO;

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

  @Override
  @Transactional(value = "transactionManager")
  protected TeachingGroup save(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto, String zoneId, boolean create)
      throws PersistenceException {

    // Populate list of Teachers
    Set<StaffPersonal> teachingGroupTeachers = new HashSet<StaffPersonal>();
    if (hitsObject.getStaffPersonals() != null) {
      for (StaffPersonal staffPersonal : hitsObject.getStaffPersonals()) {
        StaffPersonal teachingGroupTeacher = getTeachingGroupTeacher(staffPersonal, zoneId);
        if (teachingGroupTeacher != null) {
          teachingGroupTeachers.add(teachingGroupTeacher);
        }
      }
    }
    hitsObject.setStaffPersonals(teachingGroupTeachers);

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

    return super.save(hitsObject, dto, zoneId, create);
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

  @Override
  protected boolean assignZoneId(TeachingGroup hitsObject, String zoneId) {
    boolean result = false;
    if (hitsObject != null && hitsObject.getSchoolInfo() != null && hitsObject.getSchoolInfo().getRefId() != null) {
      SchoolInfo schoolInfo = schoolInfoDAO.findOne(hitsObject.getSchoolInfo().getRefId());
      hitsObject.setSchoolInfo(schoolInfo);
      result = hitsObject.getSchoolInfo() != null && hitsObject.getSchoolInfo().getZoneId() != null
          && hitsObject.getSchoolInfo().getZoneId().equals(zoneId);
    }
    return result;
  }

  @Override
  protected void delete(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto) {
    // Before deleting we need to make sure that all referential integrity jazz
    // is looked after...
    // May not need to do anything here.
    super.delete(hitsObject, dto);
  }
}
