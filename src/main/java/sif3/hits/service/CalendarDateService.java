package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif3.hits.domain.converter.CalendarDateConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CalendarDateDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.CalendarDate;

@Service
public class CalendarDateService extends
    BaseService<sif.dd.au30.model.CalendarDate, CalendarDateCollectionType, CalendarDate> {

  @Autowired
  private CalendarDateDAO calendarDateDAO;

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
}
