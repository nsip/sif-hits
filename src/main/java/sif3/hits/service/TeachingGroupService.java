package sif3.hits.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.SchoolInfoType;
import sif.dd.au30.model.StaffPersonalType;
import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.PersonInfoConverter;
import sif3.hits.domain.converter.SchoolInfoConverter;
import sif3.hits.domain.converter.StaffPersonalConverter;
import sif3.hits.domain.converter.StudentPersonalConverter;
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
import sif3.hits.rest.dto.ResponseDTO;
import sif3.hits.utils.RefIdGenerator;

@Service
public class TeachingGroupService extends BaseService<TeachingGroupType, TeachingGroupCollectionType, TeachingGroup> {

  @Autowired
  private PersonInfoConverter personInfoConverter;
  
  @Autowired
  private StaffPersonalService staffPersonalService;

  @Autowired
  private StaffPersonalConverter staffPersonalConverter;

  @Autowired
  private StaffPersonalDAO staffPersonalDAO;

  @Autowired
  private StudentPersonalService studentPersonalService;

  @Autowired
  private StudentPersonalConverter studentPersonalConverter;

  @Autowired
  private StudentPersonalDAO studentPersonalDAO;

  @Autowired
  private SchoolInfoService schoolInfoService;
  
  @Autowired
  private SchoolInfoConverter schoolInfoConverter;
  
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
  @Transactional
  protected TeachingGroup save(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto, String zoneId)
      throws PersistenceException {
    
    // Save and/or find list of Teachers
    HashMap<String, StaffPersonal> teachingGroupTeachers = new HashMap<String, StaffPersonal>();
    if (hitsObject.getStaffPersonals() != null) {
      for (StaffPersonal staffPersonal : hitsObject.getStaffPersonals()) {
        String key = staffPersonal.getRefId();
        StaffPersonal teachingGroupTeacher = saveTeachingGroupTeacher(staffPersonal, dto, zoneId);
        teachingGroupTeachers.put(key, teachingGroupTeacher);
      }
    }
    hitsObject.setStaffPersonals(new HashSet<StaffPersonal>(teachingGroupTeachers.values()));

    // Save and/or find list of Students
    HashSet<StudentPersonal> teachingGroupStudents = new HashSet<StudentPersonal>();
    if (hitsObject.getStudentPersonals() != null) {
      for (StudentPersonal studentPersonal : hitsObject.getStudentPersonals()) {
        StudentPersonal teachingGroupStudent = saveTeachingGroupStudent(studentPersonal, dto, zoneId);
        teachingGroupStudents.add(teachingGroupStudent);
      }
    }
    hitsObject.setStudentPersonals(teachingGroupStudents);
    
    // Save and/or find School
    hitsObject.setSchoolInfo(saveSchoolInfo(hitsObject.getSchoolInfo(), dto, zoneId));

    // Save and/or find TimeTableCells
    HashSet<TimeTableCell> timeTablePeriods = new HashSet<TimeTableCell>();
    if (hitsObject.getTimeTablePeriods() != null) {
      for (TimeTableCell timeTableCell : hitsObject.getTimeTablePeriods()) {
        TimeTableCell timeTablePeriod = saveTimeTablePeriod(timeTableCell, teachingGroupTeachers, dto, zoneId);
        timeTablePeriods.add(timeTablePeriod);
      }
    }
    hitsObject.setTimeTablePeriods(timeTablePeriods);
    
    return super.save(hitsObject, dto, zoneId);
  }

  private StaffPersonal saveTeachingGroupTeacher(StaffPersonal staffPersonal, RequestDTO<TeachingGroupType> dto,
      String zoneId) throws PersistenceException {
    StaffPersonal result = null;
    if (staffPersonal != null) {
      StaffPersonalType existingTeacher = null;
      if (staffPersonal.getRefId() != null) {
        existingTeacher = staffPersonalService.getSingle(staffPersonal.getRefId(), zoneId);
      }
      ResponseDTO<StaffPersonalType> response = null;
      if (existingTeacher != null) {
        // We only want to copy fields from "staffPersonal" onto "existingTeacher" that are supplied in the
        // TeachingGroup calls. Does this need another "converter"?
        existingTeacher.setRefId(staffPersonal.getRefId());
        existingTeacher.setLocalId(staffPersonal.getLocalId());
        if (existingTeacher.getPersonInfo() != null) {
          personInfoConverter.toSifModel(staffPersonal, existingTeacher.getPersonInfo());
        } else {
          existingTeacher.setPersonInfo(personInfoConverter.toSifModel(staffPersonal));
        }
        RequestDTO<StaffPersonalType> staffPersonalDTO = RequestDTO.getInstance(existingTeacher,
            StaffPersonalType.class);
        response = staffPersonalService.updateSingle(staffPersonalDTO, zoneId);
      } else {
        StaffPersonalType newStaffPersonal = staffPersonalConverter.toSifModel(staffPersonal);
        RequestDTO<StaffPersonalType> staffPersonalDTO = RequestDTO.getInstance(newStaffPersonal, dto.getUseAdvisory(),
            StaffPersonalType.class);
        response = staffPersonalService.createSingle(staffPersonalDTO, zoneId);
      }
      if (response != null && response.getSifObject() != null) {
        String refId = response.getSifObject().getRefId();
        result = staffPersonalDAO.findOne(refId);
      }
    }
    return result;
  }

  private StudentPersonal saveTeachingGroupStudent(StudentPersonal studentPersonal, RequestDTO<TeachingGroupType> dto,
      String zoneId) throws PersistenceException {
    StudentPersonal result = null;
    if (studentPersonal != null) {
      StudentPersonalType existingStudent = null;
      if (studentPersonal.getRefId() != null) {
        existingStudent = studentPersonalService.getSingle(studentPersonal.getRefId(), zoneId);
      }
      ResponseDTO<StudentPersonalType> response = null;
      if (existingStudent != null) {
        // We only want to copy fields from "studentPersonal" onto "existingStudent" that are supplied in the
        // TeachingGroup calls. Does this need another "converter"?
        existingStudent.setRefId(studentPersonal.getRefId());
        existingStudent.setLocalId(studentPersonal.getLocalId());
        if (existingStudent.getPersonInfo() != null) {
          personInfoConverter.toSifModel(studentPersonal, existingStudent.getPersonInfo());
        } else {
          existingStudent.setPersonInfo(personInfoConverter.toSifModel(studentPersonal));
        }
        RequestDTO<StudentPersonalType> studentPersonalDTO = RequestDTO.getInstance(existingStudent,
            StudentPersonalType.class);
        response = studentPersonalService.updateSingle(studentPersonalDTO, zoneId);
      } else {
        StudentPersonalType newStudentPersonal = studentPersonalConverter.toSifModel(studentPersonal);
        RequestDTO<StudentPersonalType> studentPersonalDTO = RequestDTO.getInstance(newStudentPersonal,
            dto.getUseAdvisory(), StudentPersonalType.class);
        response = studentPersonalService.createSingle(studentPersonalDTO, zoneId);
      }
      if (response != null && response.getSifObject() != null) {
        String refId = response.getSifObject().getRefId();
        result = studentPersonalDAO.findOne(refId);
      }
    }
    return result;
  }
  
  private SchoolInfo saveSchoolInfo(SchoolInfo schoolInfo, RequestDTO<TeachingGroupType> dto, String zoneId) throws PersistenceException {
    SchoolInfo result = null;
    if (schoolInfo != null) {
      SchoolInfoType existingSchool = null;
      if (schoolInfo.getRefId() != null) {
        existingSchool = schoolInfoService.getSingle(schoolInfo.getRefId(), zoneId);
      }
      ResponseDTO<SchoolInfoType> response = null;
      if (existingSchool != null) {
        // We only want to copy fields from "schoolInfo" onto "existingSchool" that are supplied in the
        // TeachingGroup calls. Does this need another "converter"?
        ObjectFactory objectFactory = new ObjectFactory();
        existingSchool.setRefId(schoolInfo.getRefId());
        existingSchool.setLocalId(objectFactory.createSchoolInfoTypeLocalId(schoolInfo.getLocalId()));
        RequestDTO<SchoolInfoType> schoolInfoDTO = RequestDTO.getInstance(existingSchool,
            SchoolInfoType.class);
        response = schoolInfoService.updateSingle(schoolInfoDTO, zoneId);
      } else {
        SchoolInfoType newSchoolInfo = schoolInfoConverter.toSifModel(schoolInfo);
        RequestDTO<SchoolInfoType> schoolInfoDTO = RequestDTO.getInstance(newSchoolInfo, dto.getUseAdvisory(),
            SchoolInfoType.class);
        response = schoolInfoService.createSingle(schoolInfoDTO, zoneId);
      }
      if (response != null && response.getSifObject() != null) {
        String refId = response.getSifObject().getRefId();
        result = schoolInfoDAO.findOne(refId);
      }
    }
    return result;
  }
  
  private TimeTableCell saveTimeTablePeriod(TimeTableCell timeTableCell, HashMap<String, StaffPersonal> teachingGroupTeachers, RequestDTO<TeachingGroupType> dto,
      String zoneId) {
    TimeTableCell result = null;
    if (timeTableCell != null) {
      TimeTableCell existingCell = null;
      if (timeTableCell.getRefId() != null) {
        existingCell = timeTableCellDAO.findOne(timeTableCell.getRefId());
      }
      if (existingCell == null) {
        existingCell = timeTableCell;
      } else {
        // We only want to copy fields from "timeTableCell" onto "existingCell" that are supplied in the
        // TeachingGroup calls. Does this need another "converter"?
        existingCell.setCellType(timeTableCell.getCellType());
        existingCell.setDayId(timeTableCell.getDayId());
        existingCell.setPeriodId(timeTableCell.getPeriodId());
        existingCell.setRefId(timeTableCell.getRefId());
      }
      StaffPersonal teacher = null;
      if (timeTableCell.getStaffPersonal() != null && timeTableCell.getStaffPersonal().getRefId() != null) {
        teacher = teachingGroupTeachers.get(timeTableCell.getStaffPersonal().getRefId());
      }
      existingCell.setStaffPersonal(teacher);
      
      // Only RoomNumber supplied.
      if (existingCell.getRoomInfo() != null && existingCell.getRoomInfo().getRoomNumber() != null && timeTableCell.getRoomInfo() != null && !existingCell.getRoomInfo().getRoomNumber().equals(timeTableCell.getRoomInfo().getRoomNumber())) {
        timeTableCell.getRoomInfo().setRefId(RefIdGenerator.getRefId());
        existingCell.setRoomInfo(roomInfoDAO.save(timeTableCell.getRoomInfo()));
      }
      result = timeTableCellDAO.save(existingCell);
    }
    return result;
  }
  
  @Override
  protected boolean assignZoneId(TeachingGroup hitsObject, String zoneId) {
    boolean result = false;
    if (hitsObject != null && hitsObject.getSchoolInfo() != null && hitsObject.getSchoolInfo().getRefId() != null) {
      SchoolInfo schoolInfo = schoolInfoDAO.findOne(hitsObject.getSchoolInfo().getRefId());
      hitsObject.setSchoolInfo(schoolInfo);
      result = hitsObject.getSchoolInfo() != null && hitsObject.getSchoolInfo().getZoneId() != null && hitsObject.getSchoolInfo().getZoneId().equals(zoneId);
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
