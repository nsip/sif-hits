package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.GradingAssignmentScoreFilterDAO;
import sif3.hits.domain.model.GradingAssignmentScore;

@Repository
public class GradingAssignmentScoreFilterDAOImpl extends BaseFilterableRepository<GradingAssignmentScore>implements GradingAssignmentScoreFilterDAO {
  public GradingAssignmentScoreFilterDAOImpl() {
    super(GradingAssignmentScore.class);
  }
}
