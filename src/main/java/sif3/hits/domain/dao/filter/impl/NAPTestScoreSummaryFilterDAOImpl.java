package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.NAPTestScoreSummaryFilterDAO;
import sif3.hits.domain.model.NAPTestScoreSummary;

@Repository
public class NAPTestScoreSummaryFilterDAOImpl extends BaseFilterableRepository<NAPTestScoreSummary> implements NAPTestScoreSummaryFilterDAO {
  public NAPTestScoreSummaryFilterDAOImpl() {
    super(NAPTestScoreSummary.class);
  }
}
