package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import sif3.hits.domain.dao.TimeTableDayDAO;
import sif3.hits.domain.dao.TimeTablePeriodDAO;
import sif3.hits.domain.dao.ZoneDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.domain.model.TimeTableDay;
import sif3.hits.domain.model.TimeTablePeriod;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TimeTableService extends BaseService<TimeTableType, TimeTableCollectionType, TimeTable> {

  @Autowired
  private TimeTableDAO timeTableDAO;
  
  @Autowired
  private TimeTableDayDAO timeTableDayDAO;
  
  @Autowired
  private TimeTablePeriodDAO timeTablePeriodDAO;
  
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
    
    TimeTable result = null;
    if (hitsObject.getTimeTableDays() != null) {
      deleteTimeTablePeriods(hitsObject);
      deleteTimeTableDays(hitsObject);
      Set<TimeTableDay> days = new HashSet<TimeTableDay>();
      days.addAll(hitsObject.getTimeTableDays());
      hitsObject.getTimeTableDays().clear();
      result = super.save(hitsObject, dto, zoneId);
      for (TimeTableDay day : days) {
        Set<TimeTablePeriod> periods = new HashSet<TimeTablePeriod>();
        if (day.getPeriods() != null) {
          periods.addAll(day.getPeriods());
          day.getPeriods().clear();
        }
        day.setTimeTable(hitsObject);
        timeTableDayDAO.save(day);
        for (TimeTablePeriod period : periods) {
          period.setTimeTableDay(day);
          timeTablePeriodDAO.save(period);
        }
        day.setPeriods(periods);
      }
      result.setTimeTableDays(days);
    } else {
      result = super.save(hitsObject, dto, zoneId); 
    }
    return result;
  }
  
  
    
  private void deleteTimeTablePeriods(TimeTable hitsObject) {
    timeTablePeriodDAO.deleteAllWithTimeTable(hitsObject);
  }

  private void deleteTimeTableDays(TimeTable hitsObject) {
    timeTableDayDAO.deleteAllWithTimeTable(hitsObject);    
  }

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
    deleteTimeTablePeriods(hitsObject);
    deleteTimeTableDays(hitsObject);
    super.delete(hitsObject, dto);
  }
}
