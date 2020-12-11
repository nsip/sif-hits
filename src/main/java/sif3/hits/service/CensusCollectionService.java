package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CensusCollectionCollectionType;
import sif.dd.au30.model.CensusCollectionType;
import sif3.hits.domain.converter.CensusCollectionConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CensusCollectionDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.CensusCollection;
import sif3.hits.domain.dao.filter.CensusCollectionFilterDAO;

@Service
public class CensusCollectionService extends BaseService<CensusCollectionType, CensusCollectionCollectionType, CensusCollection> {

  @Autowired
  private CensusCollectionConverter censusCollectionConverter;

  @Autowired
  private CensusCollectionDAO censusCollectionDAO;

  @Autowired
  private CensusCollectionFilterDAO censusCollectionFilterDAO;

  @Override
  protected CensusCollectionCollectionType getCollection(List<CensusCollectionType> items) {
    CensusCollectionCollectionType result = new CensusCollectionCollectionType();
    if (items != null) {
      result.getCensusCollection().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<CensusCollectionType, CensusCollection> getConverter() {
    return censusCollectionConverter;
  }

  @Override
  protected JpaRepository<CensusCollection, String> getDAO() {
    return censusCollectionDAO;
  }

  @Override
  protected FilterableRepository<CensusCollection,CensusCollectionType> getFilterableDAO() {
    return censusCollectionFilterDAO;
  }
}
