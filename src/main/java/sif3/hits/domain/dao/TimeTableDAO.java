package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TimeTable;

public interface TimeTableDAO extends JpaRepository<TimeTable, String>, ZoneFilterableRepository<TimeTable> {

  @Query("select t from TimeTable t where t.schoolInfo.refId in :schoolRefIds")
  @Override
  public Page<TimeTable> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select t from TimeTable t where t.refId = :refId and t.schoolInfo.refId in :schoolRefIds")
  @Override
  public TimeTable findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);

}
