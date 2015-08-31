package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.GradingAssignment;

public interface GradingAssignmentDAO extends JpaRepository<GradingAssignment, String>, ZoneFilterableRepository<GradingAssignment> {

  @Query("select distinct g from GradingAssignment g where g.teachingGroup.schoolInfo.refId in :schoolRefIds")
  @Override
  public Page<GradingAssignment> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct g from GradingAssignment g where g.refId = :refId and g.teachingGroup.schoolInfo.refId in :schoolRefIds")
  @Override
  public GradingAssignment findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
