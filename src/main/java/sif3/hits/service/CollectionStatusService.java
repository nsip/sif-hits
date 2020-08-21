package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.CollectionStatusCollectionType;
import sif.dd.au30.model.CollectionStatusType;
import sif3.hits.domain.converter.CollectionStatusConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.CollectionStatusDAO;
import sif3.hits.domain.dao.filter.CollectionStatusFilterDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.CollectionStatus;

@Service
public class CollectionStatusService extends BaseService<CollectionStatusType, CollectionStatusCollectionType, CollectionStatus> {

  @Autowired
  private CollectionStatusConverter collectionStatusConverter;

  @Autowired
  private CollectionStatusDAO collectionStatusDAO;

  @Autowired
  private CollectionStatusFilterDAO collectionStatusFilterDAO;

  @Override
  protected CollectionStatusCollectionType getCollection(List<CollectionStatusType> items) {
    CollectionStatusCollectionType result = new CollectionStatusCollectionType();
    if (items != null) {
      result.getCollectionStatus().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<CollectionStatusType, CollectionStatus> getConverter() {
    return collectionStatusConverter;
  }

  @Override
  protected JpaRepository<CollectionStatus, String> getDAO() {
    return collectionStatusDAO;
  }

  @Override
  protected FilterableRepository<CollectionStatus,CollectionStatusType> getFilterableDAO() {
    return collectionStatusFilterDAO;
  }
}
