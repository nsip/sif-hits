package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.CalendarSummary;

public interface CalendarSummaryDAO extends JpaRepository<CalendarSummary, String>,
    ZoneFilterableRepository<CalendarSummary> {

  @Query("select distinct s from CalendarSummary s where s.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<CalendarSummary> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);
  
  @Override
  @Query("select distinct s from CalendarSummary s where s.schoolInfoRefId in :schoolRefIds and s.refId = :refId")
  public CalendarSummary findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
