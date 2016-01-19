package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.GradingAssignmentFilterDAO;
import sif3.hits.domain.model.GradingAssignment;

@Repository
public class GradingAssignmentFilterDAOImpl extends BaseFilterableRepository<GradingAssignment>implements GradingAssignmentFilterDAO {
  public GradingAssignmentFilterDAOImpl() {
    super(GradingAssignment.class);
  }
}
