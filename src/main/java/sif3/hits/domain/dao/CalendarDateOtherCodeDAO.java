package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.CalendarDate;
import sif3.hits.domain.model.CalendarDateTypeOtherCode;
import sif3.hits.domain.model.CalendarDateTypeOtherCodeId;

public interface CalendarDateOtherCodeDAO extends JpaRepository<CalendarDateTypeOtherCode, CalendarDateTypeOtherCodeId> {
  @Query("delete from CalendarDateTypeOtherCode c where c.calendarDateTypeOtherCodeId.calendarDate = :calendarDate")
  @Modifying
  public void deleteAllWithCalendarDate(@Param("calendarDate") CalendarDate calendarDate);
}
