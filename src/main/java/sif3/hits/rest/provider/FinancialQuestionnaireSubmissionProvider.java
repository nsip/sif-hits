package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sif.dd.au30.model.FinancialQuestionnaireSubmissionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireSubmissionType;
import sif3.hits.domain.model.FinancialQuestionnaireSubmission;
import sif3.hits.service.FinancialQuestionnaireSubmissionService;

public class FinancialQuestionnaireSubmissionProvider extends HitsBaseProvider<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmissionCollectionType, FinancialQuestionnaireSubmission, FinancialQuestionnaireSubmissionService> {

    protected static final Logger L = LoggerFactory.getLogger(FinancialQuestionnaireSubmissionProvider.class);

    /**
     * @param providerID
     *          The ID of the provider.
     * @param serviceProperties
     *          values of provider property file.
     */
    public FinancialQuestionnaireSubmissionProvider() {
        super(FinancialQuestionnaireSubmissionType.class, "FinancialQuestionnaireSubmission", FinancialQuestionnaireSubmissionCollectionType.class, "FinancialQuestionnaireSubmissions", FinancialQuestionnaireSubmissionService.class);
    }
}
