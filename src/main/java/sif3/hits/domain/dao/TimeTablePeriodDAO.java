package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TimeTable;
import sif3.hits.domain.model.TimeTablePeriod;

public interface TimeTablePeriodDAO extends JpaRepository<TimeTablePeriod, String> {
  @Query("delete from TimeTablePeriod t where t.timeTablePeriodId.timeTableDay.timeTableDayId.timeTable = :timeTable")
  @Modifying
  public void deleteAllWithTimeTable(@Param("timeTable") TimeTable timeTable);
}
