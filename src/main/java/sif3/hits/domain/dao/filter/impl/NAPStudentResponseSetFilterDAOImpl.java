package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.NAPStudentResponseSetFilterDAO;
import sif3.hits.domain.model.NAPStudentResponseSet;

@Repository
public class NAPStudentResponseSetFilterDAOImpl extends BaseFilterableRepository<NAPStudentResponseSet> implements NAPStudentResponseSetFilterDAO {
  public NAPStudentResponseSetFilterDAOImpl() {
    super(NAPStudentResponseSet.class);
  }
}
