package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.NAPTestConverter;
import sif3.hits.domain.dao.NAPTestDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.NAPTestFilterDAO;
import sif3.hits.domain.model.NAPTest;

@Service
public class NAPTestService extends BaseService<NAPTestType, NAPTestCollectionType, NAPTest> {
  @Autowired
  private NAPTestConverter napTestConverter;

  @Autowired
  private NAPTestDAO napTestDAO;

  @Autowired
  private NAPTestFilterDAO napTestFilterDAO;

  @Override
  protected NAPTestCollectionType getCollection(List<NAPTestType> items) {
    NAPTestCollectionType result = new NAPTestCollectionType();
    if (items != null) {
      result.getNAPTest().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<NAPTestType, NAPTest> getConverter() {
    return napTestConverter;
  }

  @Override
  protected JpaRepository<NAPTest, String> getDAO() {
    return napTestDAO;
  }

  @Override
  protected FilterableRepository<NAPTest,NAPTestType> getFilterableDAO() {
    return napTestFilterDAO;
  }
}
