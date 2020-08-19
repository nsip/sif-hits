package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CollectionRoundCollectionType;
import sif.dd.au30.model.CollectionRoundType;
import sif3.hits.domain.converter.CollectionRoundConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CollectionRoundDAO;
import sif3.hits.domain.dao.filter.CollectionRoundFilterDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.CollectionRound;

@Service
public class CollectionRoundService extends BaseService<CollectionRoundType, CollectionRoundCollectionType, CollectionRound> {

  @Autowired
  private CollectionRoundConverter collectionRoundConverter;

  @Autowired
  private CollectionRoundDAO collectionRoundDAO;

  @Autowired
  private CollectionRoundFilterDAO collectionRoundFilterDAO;

  @Override
  protected CollectionRoundCollectionType getCollection(List<CollectionRoundType> items) {
    CollectionRoundCollectionType result = new CollectionRoundCollectionType();
    if (items != null) {
      result.getCollectionRound().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<CollectionRoundType, CollectionRound> getConverter() {
    return collectionRoundConverter;
  }

  @Override
  protected JpaRepository<CollectionRound, String> getDAO() {
    return collectionRoundDAO;
  }

  @Override
  protected FilterableRepository<CollectionRound,CollectionRoundType> getFilterableDAO() {
    return collectionRoundFilterDAO;
  }
}
