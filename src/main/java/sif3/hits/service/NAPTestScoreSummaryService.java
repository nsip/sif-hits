package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.NAPTestScoreSummaryConverter;
import sif3.hits.domain.dao.NAPTestScoreSummaryDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.NAPTestScoreSummaryFilterDAO;
import sif3.hits.domain.model.NAPTestScoreSummary;

@Service
public class NAPTestScoreSummaryService extends BaseService<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType, NAPTestScoreSummary> {
  @Autowired
  private NAPTestScoreSummaryConverter napTestScoreSummaryConverter;

  @Autowired
  private NAPTestScoreSummaryDAO napTestScoreSummaryDAO;

  @Autowired
  private NAPTestScoreSummaryFilterDAO napTestScoreSummaryFilterDAO;

  @Override
  protected NAPTestScoreSummaryCollectionType getCollection(List<NAPTestScoreSummaryType> items) {
    NAPTestScoreSummaryCollectionType result = new NAPTestScoreSummaryCollectionType();
    if (items != null) {
      result.getNAPTestScoreSummary().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<NAPTestScoreSummaryType, NAPTestScoreSummary> getConverter() {
    return napTestScoreSummaryConverter;
  }

  @Override
  protected JpaRepository<NAPTestScoreSummary, String> getDAO() {
    return napTestScoreSummaryDAO;
  }

  @Override
  protected FilterableRepository<NAPTestScoreSummary> getFilterableDAO() {
    return napTestScoreSummaryFilterDAO;
  }
}
