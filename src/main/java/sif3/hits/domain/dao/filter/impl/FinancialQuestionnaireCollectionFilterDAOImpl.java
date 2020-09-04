package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.FinancialQuestionnaireCollectionType;
import sif3.hits.domain.dao.filter.FinancialQuestionnaireCollectionFilterDAO;
import sif3.hits.domain.model.FinancialQuestionnaireCollection;

@Repository
public class FinancialQuestionnaireCollectionFilterDAOImpl
		extends BaseFilterableRepository<FinancialQuestionnaireCollection, FinancialQuestionnaireCollectionType>
		implements FinancialQuestionnaireCollectionFilterDAO {
	public FinancialQuestionnaireCollectionFilterDAOImpl() {
		super(FinancialQuestionnaireCollection.class, FinancialQuestionnaireCollectionType.class);
	}
}
