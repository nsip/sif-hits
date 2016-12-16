package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.NAPTestFilterDAO;
import sif3.hits.domain.model.NAPTest;

@Repository
public class NAPTestFilterDAOImpl extends BaseFilterableRepository<NAPTest> implements NAPTestFilterDAO {
  public NAPTestFilterDAOImpl() {
    super(NAPTest.class);
  }
}
