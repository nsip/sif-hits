package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif3.hits.domain.converter.CalendarSummaryConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CalendarSummaryDAO;
import sif3.hits.domain.dao.CalendarSummaryYearLevelDAO;
import sif3.hits.domain.dao.filter.CalendarSummaryFilterDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.CalendarSummary;
import sif3.hits.domain.model.CalendarSummaryYearLevel;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class CalendarSummaryService extends BaseService<CalendarSummaryType, CalendarSummaryCollectionType, CalendarSummary> {

  @Autowired
  private CalendarSummaryConverter calendarSummaryConverter;

  @Autowired
  private CalendarSummaryDAO calendarSummaryDAO;

  @Autowired
  private CalendarSummaryFilterDAO calendarSummaryFilterDAO;

  @Autowired
  private CalendarSummaryYearLevelDAO calendarSummaryYearLevelDAO;

  @Override
  protected CalendarSummaryCollectionType getCollection(List<CalendarSummaryType> items) {
    CalendarSummaryCollectionType result = new CalendarSummaryCollectionType();
    if (items != null) {
      result.getCalendarSummary().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<CalendarSummaryType, CalendarSummary> getConverter() {
    return calendarSummaryConverter;
  }

  @Override
  protected JpaRepository<CalendarSummary, String> getDAO() {
    return calendarSummaryDAO;
  }

  @Override
  protected FilterableRepository<CalendarSummary> getFilterableDAO() {
    return calendarSummaryFilterDAO;
  }

  @Override
  protected boolean hasChildObjects(CalendarSummary hitsObject) {
    return hitsObject != null && hitsObject.getCalendarSummaryYearLevels() != null && !hitsObject.getCalendarSummaryYearLevels().isEmpty();
  }

  @Override
  protected CalendarSummary saveWithChildObjects(CalendarSummary hitsObject, RequestDTO<CalendarSummaryType> dto, String zoneId, boolean create) {
    CalendarSummary result = null;
    Set<CalendarSummaryYearLevel> yearLevels = new HashSet<CalendarSummaryYearLevel>();
    yearLevels.addAll(hitsObject.getCalendarSummaryYearLevels());
    hitsObject.getCalendarSummaryYearLevels().clear();
    result = super.save(hitsObject, dto, zoneId, create);
    for (CalendarSummaryYearLevel yearLevel : yearLevels) {
      yearLevel.setCalendarSummary(hitsObject);
      calendarSummaryYearLevelDAO.save(yearLevel);
    }
    result.setCalendarSummaryYearLevels(yearLevels);
    return result;
  }
}