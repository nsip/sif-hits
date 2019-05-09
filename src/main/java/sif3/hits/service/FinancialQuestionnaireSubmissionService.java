package sif3.hits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sif.dd.au30.model.FinancialQuestionnaireSubmissionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireSubmissionType;
import sif3.hits.domain.converter.FinancialQuestionnaireSubmissionConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.FinancialQuestionnaireSubmissionDAO;
import sif3.hits.domain.dao.filter.FinancialQuestionnaireSubmissionFilterDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.FinancialQuestionnaireSubmission;

import java.util.List;

@Service
public class FinancialQuestionnaireSubmissionService extends BaseService<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmissionCollectionType, FinancialQuestionnaireSubmission> {

  @Autowired
  private FinancialQuestionnaireSubmissionConverter financialQuestionnaireSubmissionConverter;

  @Autowired
  private FinancialQuestionnaireSubmissionDAO financialQuestionnaireSubmissionDAO;

  @Autowired
  private FinancialQuestionnaireSubmissionFilterDAO financialQuestionnaireSubmissionFilterDAO;

  @Override
  protected FinancialQuestionnaireSubmissionCollectionType getCollection(List<FinancialQuestionnaireSubmissionType> items) {
    FinancialQuestionnaireSubmissionCollectionType result = new FinancialQuestionnaireSubmissionCollectionType();
    if (items != null) {
      result.getFinancialQuestionnaireSubmission().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmission> getConverter() {
    return financialQuestionnaireSubmissionConverter;
  }

  @Override
  protected JpaRepository<FinancialQuestionnaireSubmission, String> getDAO() {
    return financialQuestionnaireSubmissionDAO;
  }

  @Override
  protected FilterableRepository<FinancialQuestionnaireSubmission,FinancialQuestionnaireSubmissionType> getFilterableDAO() {
    return financialQuestionnaireSubmissionFilterDAO;
  }
}
