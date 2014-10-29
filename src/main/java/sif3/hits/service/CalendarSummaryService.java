package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif3.hits.domain.converter.CalendarSummaryConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CalendarSummaryDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.CalendarSummary;

@Service
public class CalendarSummaryService extends BaseService<CalendarSummaryType, CalendarSummaryCollectionType, CalendarSummary> {

  @Autowired
  private CalendarSummaryDAO calendarSummaryDAO;

  @Override
  public JpaRepository<CalendarSummary, String> getDAO() {
    return calendarSummaryDAO;
  }

  @Override
  public ZoneFilterableRepository<CalendarSummary> getZoneFilterableDAO() {
    return calendarSummaryDAO;
  }

  @Autowired
  private CalendarSummaryConverter calendarSummaryConverter;

  @Override
  public HitsConverter<CalendarSummaryType, CalendarSummary> getConverter() {
    return calendarSummaryConverter;
  }

  @Override
  protected CalendarSummaryCollectionType getCollection(List<CalendarSummaryType> items) {
    CalendarSummaryCollectionType result = new CalendarSummaryCollectionType();
    if (items != null) {
      result.getCalendarSummary().addAll(items);
    }
    return result;
  }

  @Override
  protected CalendarSummary getFiltered(String refId, java.util.List<String> schoolRefIds) {
    CalendarSummary result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = calendarSummaryDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
