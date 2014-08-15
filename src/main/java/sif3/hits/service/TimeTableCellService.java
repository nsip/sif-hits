package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sif.dd.au30.model.TimeTableCellCollectionType;
import sif.dd.au30.model.TimeTableCellType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableCellConverter;
import sif3.hits.domain.dao.RoomInfoDAO;
import sif3.hits.domain.dao.StaffPersonalDAO;
import sif3.hits.domain.dao.TeachingGroupDAO;
import sif3.hits.domain.dao.TimeTableCellDAO;
import sif3.hits.domain.dao.TimeTableDAO;
import sif3.hits.domain.dao.TimeTableSubjectDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.RoomInfo;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.domain.model.TimeTableCell;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TimeTableCellService extends BaseService<TimeTableCellType, TimeTableCellCollectionType, TimeTableCell> {

  @Autowired
  private TimeTableCellDAO timeTableCellDAO;
  
  @Autowired
  private TimeTableSubjectDAO timeTableSubjectDAO;
  
  @Autowired
  private TimeTableDAO timeTableDAO;
  
  @Autowired
  private StaffPersonalDAO staffPersonalDAO;
  
  @Autowired
  private TeachingGroupDAO teachingGroupDAO;
  
  @Autowired
  private RoomInfoDAO roomInfoDAO;

  @Override
  public JpaRepository<TimeTableCell, String> getDAO() {
    return timeTableCellDAO;
  }

  @Override
  public ZoneFilterableRepository<TimeTableCell> getZoneFilterableDAO() {
    return timeTableCellDAO;
  }

  @Autowired
  private TimeTableCellConverter timeTableCellConverter;

  @Override
  public HitsConverter<TimeTableCellType, TimeTableCell> getConverter() {
    return timeTableCellConverter;
  }

  @Override
  protected TimeTableCellCollectionType getCollection(List<TimeTableCellType> items) {
    TimeTableCellCollectionType result = new TimeTableCellCollectionType();
    if (items != null) {
      result.getTimeTableCell().addAll(items);
    }
    return result;
  }

  @Override
  protected TimeTableCell getFiltered(String refId, java.util.List<String> schoolRefIds) {
    TimeTableCell result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = timeTableCellDAO.findOne(refId);
      if (result != null && result.getTimeTable() != null && result.getTimeTable().getSchoolInfo() != null) {
        if (!schoolRefIds.contains(result.getTimeTable().getSchoolInfo().getRefId())) {
          result = null;
        }
      }
    }
    return result;
  }

  @Override
  @Transactional(value = "transactionManager")
  protected TimeTableCell save(TimeTableCell hitsObject, RequestDTO<TimeTableCellType> dto, String zoneId, boolean create)
      throws PersistenceException {

    // need to populate foreign keys
    hitsObject.setRoomInfo(getRoomInfo(hitsObject.getRoomInfo(), zoneId));
    hitsObject.setTimeTable(getTimeTable(hitsObject.getTimeTable(), zoneId));
    hitsObject.setStaffPersonal(getStaffPersonal(hitsObject.getStaffPersonal(), zoneId));
    hitsObject.setTimeTableSubject(getTimeTableSubject(hitsObject.getTimeTableSubject(), zoneId));
    hitsObject.setTeachingGroup(getTeachingGroup(hitsObject.getTeachingGroup(), zoneId));
    return super.save(hitsObject, dto, zoneId, create);
  }

  private TeachingGroup getTeachingGroup(TeachingGroup teachingGroup, String zoneId) {
    TeachingGroup result = null;
    if (teachingGroup != null && teachingGroup.getRefId() != null) {
      result = teachingGroupDAO.findOneWithFilter(teachingGroup.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }

  private TimeTableSubject getTimeTableSubject(TimeTableSubject timeTableSubject, String zoneId) {
    TimeTableSubject result = null;
    if (timeTableSubject != null && timeTableSubject.getRefId() != null) {
      result = timeTableSubjectDAO.findOneWithFilter(timeTableSubject.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }

  private StaffPersonal getStaffPersonal(StaffPersonal staffPersonal, String zoneId) {
    StaffPersonal result = null;
    if (staffPersonal != null && staffPersonal.getRefId() != null) {
      result = staffPersonalDAO.findOneWithFilter(staffPersonal.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }

  private TimeTable getTimeTable(TimeTable timeTable, String zoneId) {
    TimeTable result = null;
    if (timeTable != null && timeTable.getRefId() != null) {
      result = timeTableDAO.findOneWithFilter(timeTable.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }

  private RoomInfo getRoomInfo(RoomInfo roomInfo, String zoneId) {
    RoomInfo result = null;
    if (roomInfo != null && roomInfo.getRefId() != null) {
      result = roomInfoDAO.findOneWithFilter(roomInfo.getRefId(), getSchoolRefIds(zoneId));
    }
    return result;
  }
}
