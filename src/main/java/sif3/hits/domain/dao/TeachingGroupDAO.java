package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.TeachingGroup;

public interface TeachingGroupDAO extends JpaRepository<TeachingGroup, String>, ZoneFilterableRepository<TeachingGroup> {

  @Query("select t from TeachingGroup t where t.schoolInfo.refId in :schoolRefIds")
  @Override
  public Page<TeachingGroup> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

}
