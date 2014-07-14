package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableConverter;
import sif3.hits.domain.dao.TimeTableDAO;
import sif3.hits.domain.dao.ZoneDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TimeTableService extends BaseService<TimeTableType, TimeTableCollectionType, TimeTable> {

  @Autowired
  private TimeTableDAO timeTableDAO;
  
  @Autowired
  private ZoneDAO zoneDAO;

  @Override
  public JpaRepository<TimeTable, String> getDAO() {
    return timeTableDAO;
  }

  @Override
  public ZoneFilterableRepository<TimeTable> getZoneFilterableDAO() {
    return timeTableDAO;
  }

  @Autowired
  private TimeTableConverter timeTableConverter;

  @Override
  public HitsConverter<TimeTableType, TimeTable> getConverter() {
    return timeTableConverter;
  }

  @Override
  protected TimeTableCollectionType getCollection(List<TimeTableType> items) {
    TimeTableCollectionType result = new TimeTableCollectionType();
    if (items != null) {
      result.getTimeTable().addAll(items);
    }
    return result;
  }

  @Override
  protected TimeTable getFiltered(String refId, java.util.List<String> schoolRefIds) {
    TimeTable result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = timeTableDAO.findOne(refId);
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
  protected TimeTable save(TimeTable hitsObject, RequestDTO<TimeTableType> dto, String zoneId)
      throws PersistenceException {
    
    // Save and/or find list of TimeTableCells
//    HashMap<String, StaffPersonal> teachingGroupTeachers = new HashMap<String, StaffPersonal>();
//    if (hitsObject.getStaffPersonals() != null) {
//      for (StaffPersonal staffPersonal : hitsObject.getStaffPersonals()) {
//        String key = staffPersonal.getRefId();
//        StaffPersonal teachingGroupTeacher = saveTeachingGroupTeacher(staffPersonal, dto, zoneId);
//        teachingGroupTeachers.put(key, teachingGroupTeacher);
//      }
//    }
//    hitsObject.setStaffPersonals(new HashSet<StaffPersonal>(teachingGroupTeachers.values()));

    return super.save(hitsObject, dto, zoneId);
  }
  
//  private TimeTableCell saveTimeTablePeriod(TimeTableCell timeTableCell, HashMap<String, StaffPersonal> teachingGroupTeachers, RequestDTO<TeachingGroupType> dto,
//      String zoneId) {
//    TimeTableCell result = null;
//    if (timeTableCell != null) {
//      TimeTableCell existingCell = null;
//      if (timeTableCell.getRefId() != null) {
//        existingCell = timeTableCellDAO.findOne(timeTableCell.getRefId());
//      }
//      if (existingCell == null) {
//        existingCell = timeTableCell;
//      } else {
//        // We only want to copy fields from "timeTableCell" onto "existingCell" that are supplied in the
//        // TeachingGroup calls. Does this need another "converter"?
//        existingCell.setCellType(timeTableCell.getCellType());
//        existingCell.setDayId(timeTableCell.getDayId());
//        existingCell.setPeriodId(timeTableCell.getPeriodId());
//        existingCell.setRefId(timeTableCell.getRefId());
//      }
//      StaffPersonal teacher = null;
//      if (timeTableCell.getStaffPersonal() != null && timeTableCell.getStaffPersonal().getRefId() != null) {
//        teacher = teachingGroupTeachers.get(timeTableCell.getStaffPersonal().getRefId());
//      }
//      existingCell.setStaffPersonal(teacher);
//      
//      // Only RoomNumber supplied.
//      if (existingCell.getRoomInfo() != null && existingCell.getRoomInfo().getRoomNumber() != null && timeTableCell.getRoomInfo() != null && !existingCell.getRoomInfo().getRoomNumber().equals(timeTableCell.getRoomInfo().getRoomNumber())) {
//        timeTableCell.getRoomInfo().setRefId(RefIdGenerator.getRefId());
//        existingCell.setRoomInfo(roomInfoDAO.save(timeTableCell.getRoomInfo()));
//      }
//      result = timeTableCellDAO.save(existingCell);
//    }
//    return result;
//  }
  
  @Override
  protected boolean assignZoneId(TimeTable hitsObject, String zoneId) {
    boolean result = false;
    if (hitsObject != null && hitsObject.getSchoolInfo() != null && hitsObject.getSchoolInfo().getRefId() != null) {
      SchoolInfo schoolInfo = zoneDAO.findByRefIdAndZoneId(hitsObject.getSchoolInfoRefId(), zoneId);
      hitsObject.setSchoolInfo(schoolInfo);
      result = hitsObject.getSchoolInfo() != null;
    }
    return result;
  }

  @Override
  protected void delete(TimeTable hitsObject, RequestDTO<TimeTableType> dto) {
    // Before deleting we need to make sure that all referential integrity jazz
    // is looked after...
    // May not need to do anything here.
    super.delete(hitsObject, dto);
  }
}
