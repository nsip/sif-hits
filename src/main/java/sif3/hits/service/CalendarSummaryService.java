package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.CalendarSummaryConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CalendarSummaryDAO;
import sif3.hits.domain.dao.CalendarSummaryYearLevelDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.CalendarSummary;
import sif3.hits.domain.model.CalendarSummaryYearLevel;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class CalendarSummaryService extends
    BaseService<CalendarSummaryType, CalendarSummaryCollectionType, CalendarSummary> {

  @Autowired
  private CalendarSummaryDAO calendarSummaryDAO;

  @Autowired
  private CalendarSummaryYearLevelDAO calendarSummaryYearLevelDAO;

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
  public HitsConverter<sif.dd.au30.model.CalendarSummaryType, CalendarSummary> getConverter() {
    return calendarSummaryConverter;
  }

  @Override
  protected CalendarSummaryCollectionType getCollection(List<sif.dd.au30.model.CalendarSummaryType> items) {
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

  @Override
  protected void delete(CalendarSummary hitsObject, RequestDTO<sif.dd.au30.model.CalendarSummaryType> dto) {
    deleteYearLevels(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteYearLevels(CalendarSummary hitsObject) {
    calendarSummaryYearLevelDAO.deleteAllWithCalendarSummary(hitsObject);
  }

  @Override
  protected CalendarSummary save(CalendarSummary hitsObject, RequestDTO<sif.dd.au30.model.CalendarSummaryType> dto,
      String zoneId, boolean create) throws PersistenceException {
    CalendarSummary result = null;
    if (!create) {
      deleteYearLevels(hitsObject);
    }
    if (hitsObject.getCalendarSummaryYearLevels() != null && !hitsObject.getCalendarSummaryYearLevels().isEmpty()) {
      Set<CalendarSummaryYearLevel> yearLevels = new HashSet<CalendarSummaryYearLevel>();
      yearLevels.addAll(hitsObject.getCalendarSummaryYearLevels());
      hitsObject.getCalendarSummaryYearLevels().clear();
      result = super.save(hitsObject, dto, zoneId, create);
      for (CalendarSummaryYearLevel yearLevel : yearLevels) {
        calendarSummaryYearLevelDAO.save(yearLevel);
      }
      result.setCalendarSummaryYearLevels(yearLevels);
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }
}
