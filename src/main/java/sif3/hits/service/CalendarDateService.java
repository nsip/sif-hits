package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif.dd.au30.model.CalendarDateType;
import sif3.hits.domain.converter.CalendarDateConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CalendarDateDAO;
import sif3.hits.domain.dao.CalendarDateOtherCodeDAO;
import sif3.hits.domain.dao.filter.CalendarDateFilterDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.CalendarDate;
import sif3.hits.domain.model.CalendarDateTypeOtherCode;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class CalendarDateService extends BaseService<CalendarDateType, CalendarDateCollectionType, CalendarDate> {

  @Autowired
  private CalendarDateConverter calendarDateConverter;

  @Autowired
  private CalendarDateDAO calendarDateDAO;

  @Autowired
  private CalendarDateFilterDAO calendarDateFilterDAO;

  @Autowired
  private CalendarDateOtherCodeDAO calendarDateOtherCodeDAO;

  @Override
  protected CalendarDateCollectionType getCollection(List<CalendarDateType> items) {
    CalendarDateCollectionType result = new CalendarDateCollectionType();
    if (items != null) {
      result.getCalendarDate().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<CalendarDateType, CalendarDate> getConverter() {
    return calendarDateConverter;
  }

  @Override
  protected JpaRepository<CalendarDate, String> getDAO() {
    return calendarDateDAO;
  }

  @Override
  protected FilterableRepository<CalendarDate> getFilterableDAO() {
    return calendarDateFilterDAO;
  }

  @Override
  protected void deleteChildObjects(CalendarDate hitsObject) {
    calendarDateOtherCodeDAO.deleteAllWithCalendarDate(hitsObject);
  }

  @Override
  protected boolean hasChildObjects(CalendarDate hitsObject) {
    return hitsObject != null && hitsObject.getCalendarDateTypeOtherCodes() != null && !hitsObject.getCalendarDateTypeOtherCodes().isEmpty();
  }

  @Override
  protected CalendarDate saveWithChildObjects(CalendarDate hitsObject, RequestDTO<CalendarDateType> dto, String zoneId, boolean create) {
    CalendarDate result = null;
    Set<CalendarDateTypeOtherCode> otherCodes = new HashSet<CalendarDateTypeOtherCode>();
    otherCodes.addAll(hitsObject.getCalendarDateTypeOtherCodes());
    hitsObject.getCalendarDateTypeOtherCodes().clear();
    result = super.saveWithChildObjects(hitsObject, dto, zoneId, create);
    for (CalendarDateTypeOtherCode otherCode : otherCodes) {
      otherCode.setCalendarDate(hitsObject);
      calendarDateOtherCodeDAO.save(otherCode);
    }
    result.setCalendarDateTypeOtherCodes(otherCodes);
    return result;
  }
}
