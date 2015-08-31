package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.GradingAssignmentScore;

public interface GradingAssignmentScoreDAO extends JpaRepository<GradingAssignmentScore, String>, ZoneFilterableRepository<GradingAssignmentScore> {

  @Query("select distinct g from GradingAssignmentScore g where g.teachingGroup.schoolInfo.refId in :schoolRefIds")
  @Override
  public Page<GradingAssignmentScore> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct g from GradingAssignmentScore g where g.refId = :refId and g.teachingGroup.schoolInfo.refId in :schoolRefIds")
  @Override
  public GradingAssignmentScore findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
