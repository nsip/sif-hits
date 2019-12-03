package sif3.hits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sif.dd.au30.model.AGAddressCollectionSubmissionCollectionType;
import sif.dd.au30.model.AGAddressCollectionSubmissionType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.AGAddressCollectionSubmissionConverter;
import sif3.hits.domain.dao.AGAddressCollectionSubmissionDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.AGAddressCollectionSubmissionFilterDAO;
import sif3.hits.domain.model.AGAddressCollectionSubmission;

import java.util.List;

@Service
public class AGAddressCollectionSubmissionService extends BaseService<AGAddressCollectionSubmissionType, AGAddressCollectionSubmissionCollectionType, AGAddressCollectionSubmission> {

  @Autowired
  private AGAddressCollectionSubmissionConverter agAddressCollectionSubmissionConverter;

  @Autowired
  private AGAddressCollectionSubmissionDAO agAddressCollectionSubmissionDAO;

  @Autowired
  private AGAddressCollectionSubmissionFilterDAO agAddressCollectionSubmissionFilterDAO;

  @Override
  protected AGAddressCollectionSubmissionCollectionType getCollection(List<AGAddressCollectionSubmissionType> items) {
    AGAddressCollectionSubmissionCollectionType result = new AGAddressCollectionSubmissionCollectionType();
    if (items != null) {
      result.getAGAddressCollectionSubmission().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<AGAddressCollectionSubmissionType, AGAddressCollectionSubmission> getConverter() {
    return agAddressCollectionSubmissionConverter;
  }

  @Override
  protected JpaRepository<AGAddressCollectionSubmission, String> getDAO() {
    return agAddressCollectionSubmissionDAO;
  }

  @Override
  protected FilterableRepository<AGAddressCollectionSubmission,AGAddressCollectionSubmissionType> getFilterableDAO() {
    return agAddressCollectionSubmissionFilterDAO;
  }
}
