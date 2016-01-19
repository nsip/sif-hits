package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StaffAssignmentFilterDAO;
import sif3.hits.domain.model.StaffAssignment;

@Repository
public class StaffAssignmentFilterDAOImpl extends BaseFilterableRepository<StaffAssignment>implements StaffAssignmentFilterDAO {
  public StaffAssignmentFilterDAOImpl() {
    super(StaffAssignment.class);
  }
}
