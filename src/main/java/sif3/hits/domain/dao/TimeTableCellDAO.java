package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TimeTableCell;

public interface TimeTableCellDAO extends JpaRepository<TimeTableCell, String>, ZoneFilterableRepository<TimeTableCell> {

  @Query("select t from TimeTableCell t where t.timeTable.schoolInfo.refId in :schoolRefIds")
  @Override
  public Page<TimeTableCell> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select t from TimeTableCell t where t.refId = :refId and t.timeTable.schoolInfo.refId in :schoolRefIds")
  @Override
  public TimeTableCell findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);

}
