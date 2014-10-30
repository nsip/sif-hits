package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.CalendarDate;

public interface CalendarDateDAO extends JpaRepository<CalendarDate, String>, ZoneFilterableRepository<CalendarDate> {

  @Query("select distinct d from CalendarDate d where d.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<CalendarDate> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Override
  @Query("select distinct d from CalendarDate d where d.schoolInfoRefId in :schoolRefIds and d.refId = :refId")
  public CalendarDate findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
