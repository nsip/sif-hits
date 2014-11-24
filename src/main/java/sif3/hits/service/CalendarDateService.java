package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.CalendarDateConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CalendarDateDAO;
import sif3.hits.domain.dao.CalendarDateOtherCodeDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.CalendarDate;
import sif3.hits.domain.model.CalendarDateTypeOtherCode;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class CalendarDateService extends
    BaseService<sif.dd.au30.model.CalendarDate, CalendarDateCollectionType, CalendarDate> {

  @Autowired
  private CalendarDateDAO calendarDateDAO;
  
  @Autowired
  private CalendarDateOtherCodeDAO calendarDateOtherCodeDAO;


  @Override
  public JpaRepository<CalendarDate, String> getDAO() {
    return calendarDateDAO;
  }

  @Override
  public ZoneFilterableRepository<CalendarDate> getZoneFilterableDAO() {
    return calendarDateDAO;
  }

  @Autowired
  private CalendarDateConverter calendarDateConverter;

  @Override
  public HitsConverter<sif.dd.au30.model.CalendarDate, CalendarDate> getConverter() {
    return calendarDateConverter;
  }

  @Override
  protected CalendarDateCollectionType getCollection(List<sif.dd.au30.model.CalendarDate> items) {
    CalendarDateCollectionType result = new CalendarDateCollectionType();
    if (items != null) {
      result.getCalendarDate().addAll(items);
    }
    return result;
  }

  @Override
  protected CalendarDate getFiltered(String refId, java.util.List<String> schoolRefIds) {
    CalendarDate result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = calendarDateDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
  
  @Override
  protected void delete(CalendarDate hitsObject, RequestDTO<sif.dd.au30.model.CalendarDate> dto) {
    deleteOtherCodes(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteOtherCodes(CalendarDate hitsObject) {
    calendarDateOtherCodeDAO.deleteAllWithCalendarDate(hitsObject);
  }

  @Override
  protected CalendarDate save(CalendarDate hitsObject, RequestDTO<sif.dd.au30.model.CalendarDate> dto, String zoneId,
      boolean create) throws PersistenceException {
    CalendarDate result = null;
    if (!create) {
      deleteOtherCodes(hitsObject);
    }
    if (hitsObject.getCalendarDateTypeOtherCodes() != null && hitsObject.getCalendarDateTypeOtherCodes().size() > 0) {
      Set<CalendarDateTypeOtherCode> otherCodes = new HashSet<CalendarDateTypeOtherCode>();
      otherCodes.addAll(hitsObject.getCalendarDateTypeOtherCodes());
      hitsObject.getCalendarDateTypeOtherCodes().clear();
      result = super.save(hitsObject, dto, zoneId, create);
      for (CalendarDateTypeOtherCode otherCode : otherCodes) {
        calendarDateOtherCodeDAO.save(otherCode);
      }
      result.setCalendarDateTypeOtherCodes(otherCodes);
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }
}
