package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.NAPTestItemFilterDAO;
import sif3.hits.domain.model.NAPTestItem;

@Repository
public class NAPTestItemFilterDAOImpl extends BaseFilterableRepository<NAPTestItem> implements NAPTestItemFilterDAO {
  public NAPTestItemFilterDAOImpl() {
    super(NAPTestItem.class);
  }
}
