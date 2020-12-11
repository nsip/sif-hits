package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.FinancialQuestionnaireCollectionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireCollectionType;
import sif3.hits.domain.converter.FinancialQuestionnaireCollectionConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.FinancialQuestionnaireCollectionDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.FinancialQuestionnaireCollectionFilterDAO;
import sif3.hits.domain.model.FinancialQuestionnaireCollection;

@Service
public class FinancialQuestionnaireCollectionService extends
		BaseService<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollectionCollectionType, FinancialQuestionnaireCollection> {

	@Autowired
	private FinancialQuestionnaireCollectionConverter financialQuestionnaireCollectionConverter;

	@Autowired
	private FinancialQuestionnaireCollectionDAO financialQuestionnaireCollectionDAO;

	@Autowired
	private FinancialQuestionnaireCollectionFilterDAO financialQuestionnaireCollectionFilterDAO;

	@Override
	protected FinancialQuestionnaireCollectionCollectionType getCollection(
			List<FinancialQuestionnaireCollectionType> items) {
		FinancialQuestionnaireCollectionCollectionType result = new FinancialQuestionnaireCollectionCollectionType();
		if (items != null) {
			result.getFinancialQuestionnaireCollection().addAll(items);
		}
		return result;
	}

	@Override
	protected HitsConverter<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollection> getConverter() {
		return financialQuestionnaireCollectionConverter;
	}

	@Override
	protected JpaRepository<FinancialQuestionnaireCollection, String> getDAO() {
		return financialQuestionnaireCollectionDAO;
	}

	@Override
	protected FilterableRepository<FinancialQuestionnaireCollection, FinancialQuestionnaireCollectionType> getFilterableDAO() {
		return financialQuestionnaireCollectionFilterDAO;
	}
}
