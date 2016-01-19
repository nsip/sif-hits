package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TimeTable;
import sif3.hits.domain.model.TimeTableDay;
import sif3.hits.domain.model.TimeTableDayId;

public interface TimeTableDayDAO extends JpaRepository<TimeTableDay, TimeTableDayId> {
  @Query("delete from TimeTableDay t where t.timeTableDayId.timeTable = :timeTable")
  @Modifying
  public void deleteAllWithTimeTable(@Param("timeTable") TimeTable timeTable);
}
