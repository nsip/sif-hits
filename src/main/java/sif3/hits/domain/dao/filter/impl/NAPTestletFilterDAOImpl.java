package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.NAPTestletFilterDAO;
import sif3.hits.domain.model.NAPTestlet;

@Repository
public class NAPTestletFilterDAOImpl extends BaseFilterableRepository<NAPTestlet> implements NAPTestletFilterDAO {
  public NAPTestletFilterDAOImpl() {
    super(NAPTestlet.class);
  }
}
