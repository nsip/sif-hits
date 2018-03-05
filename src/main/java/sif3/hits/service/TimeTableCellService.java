package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TimeTableCellCollectionType;
import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableCellConverter;
import sif3.hits.domain.dao.TimeTableCellDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.RoomInfoFilterDAO;
import sif3.hits.domain.dao.filter.StaffPersonalFilterDAO;
import sif3.hits.domain.dao.filter.TeachingGroupFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableCellFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableSubjectFilterDAO;
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
  private TimeTableCellConverter timeTableCellConverter;

  @Autowired
  private TimeTableCellDAO timeTableCellDAO;

  @Autowired
  private TimeTableCellFilterDAO timeTableCellFilterDAO;

  @Autowired
  private RoomInfoFilterDAO roomInfoFilterDAO;

  @Autowired
  private StaffPersonalFilterDAO staffPersonalFilterDAO;

  @Autowired
  private TeachingGroupFilterDAO teachingGroupFilterDAO;

  @Autowired
  private TimeTableFilterDAO timeTableFilterDAO;

  @Autowired
  private TimeTableSubjectFilterDAO timeTableSubjectFilterDAO;

  @Override
  protected TimeTableCellCollectionType getCollection(List<TimeTableCellType> items) {
    TimeTableCellCollectionType result = new TimeTableCellCollectionType();
    if (items != null) {
      result.getTimeTableCell().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<TimeTableCellType, TimeTableCell> getConverter() {
    return timeTableCellConverter;
  }

  @Override
  protected JpaRepository<TimeTableCell, String> getDAO() {
    return timeTableCellDAO;
  }

  @Override
  protected FilterableRepository<TimeTableCell,TimeTableCellType> getFilterableDAO() {
    return timeTableCellFilterDAO;
  }

  @Override
  protected boolean hasChildObjects(TimeTableCell hitsObject) {
    return true;
  }

  @Override
  protected TimeTableCell saveWithChildObjects(TimeTableCell hitsObject, RequestDTO<TimeTableCellType> dto, String zoneId, boolean create) {
    // need to populate foreign keys
    hitsObject.setStaffPersonal(getStaffPersonal(hitsObject.getStaffPersonal(), zoneId));
    hitsObject.setRoomInfo(getRoomInfo(hitsObject.getRoomInfo(), zoneId));
    hitsObject.setTimeTable(getTimeTable(hitsObject.getTimeTable(), zoneId));
    hitsObject.setTimeTableSubject(getTimeTableSubject(hitsObject.getTimeTableSubject(), zoneId));
    hitsObject.setTeachingGroup(getTeachingGroup(hitsObject.getTeachingGroup(), zoneId));
    return super.saveWithChildObjects(hitsObject, dto, zoneId, create);
  }

  private RoomInfo getRoomInfo(RoomInfo roomInfo, String zoneId) {
    RoomInfo result = null;
    if (roomInfo != null && roomInfo.getRefId() != null) {
      result = roomInfoFilterDAO.findOneWithZone(roomInfo.getRefId(), zoneId);
    }
    return result;
  }

  private StaffPersonal getStaffPersonal(StaffPersonal staffPersonal, String zoneId) {
    StaffPersonal result = null;
    if (staffPersonal != null && staffPersonal.getRefId() != null) {
      result = staffPersonalFilterDAO.findOneWithZone(staffPersonal.getRefId(), zoneId);
    }
    return result;
  }

  private TeachingGroup getTeachingGroup(TeachingGroup teachingGroup, String zoneId) {
    TeachingGroup result = null;
    if (teachingGroup != null && teachingGroup.getRefId() != null) {
      result = teachingGroupFilterDAO.findOneWithZone(teachingGroup.getRefId(), zoneId);
    }
    return result;
  }

  private TimeTable getTimeTable(TimeTable timeTable, String zoneId) {
    TimeTable result = null;
    if (timeTable != null && timeTable.getRefId() != null) {
      result = timeTableFilterDAO.findOneWithZone(timeTable.getRefId(), zoneId);
    }
    return result;
  }

  private TimeTableSubject getTimeTableSubject(TimeTableSubject timeTableSubject, String zoneId) {
    TimeTableSubject result = null;
    if (timeTableSubject != null && timeTableSubject.getRefId() != null) {
      result = timeTableSubjectFilterDAO.findOneWithZone(timeTableSubject.getRefId(), zoneId);
    }
    return result;
  }

}
