package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TimeTableSubject;

public interface TimeTableSubjectDAO extends JpaRepository<TimeTableSubject, String>, ZoneFilterableRepository<TimeTableSubject> {

  @Query("select t from TimeTableSubject t where t.schoolInfoRefId in :schoolRefIds")
  @Override
  public Page<TimeTableSubject> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);
  
}
