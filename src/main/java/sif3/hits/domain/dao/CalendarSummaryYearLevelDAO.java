package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.CalendarSummary;
import sif3.hits.domain.model.CalendarSummaryYearLevel;
import sif3.hits.domain.model.CalendarSummaryYearLevelId;

public interface CalendarSummaryYearLevelDAO extends JpaRepository<CalendarSummaryYearLevel, CalendarSummaryYearLevelId> {
  @Query("delete from CalendarSummaryYearLevel c where c.calendarSummaryYearLevelId.calendarSummary = :calendarSummary")
  @Modifying
  public void deleteAllWithCalendarSummary(@Param("calendarSummary") CalendarSummary calendarSummary);
}
