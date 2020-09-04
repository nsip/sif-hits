package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.FinancialQuestionnaireCollectionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireCollectionType;
import sif3.hits.domain.model.FinancialQuestionnaireCollection;
import sif3.hits.service.FinancialQuestionnaireCollectionService;

public class FinancialQuestionnaireCollectionProvider extends
		HitsBaseProvider<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollectionCollectionType, FinancialQuestionnaireCollection, FinancialQuestionnaireCollectionService> {

	protected static final Logger L = LoggerFactory.getLogger(FinancialQuestionnaireCollectionProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public FinancialQuestionnaireCollectionProvider() {
		super(FinancialQuestionnaireCollectionType.class, "FinancialQuestionnaireCollection", FinancialQuestionnaireCollectionCollectionType.class,
				"FinancialQuestionnaireCollections", FinancialQuestionnaireCollectionService.class);
	}
}
