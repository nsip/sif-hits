package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentScoreJudgementAgainstStandardCollectionType;
import sif.dd.au30.model.StudentScoreJudgementAgainstStandardType;
import sif3.hits.domain.model.StudentScoreJudgementAgainstStandard;
import sif3.hits.service.StudentScoreJudgementAgainstStandardService;

public class StudentScoreJudgementAgainstStandardProvider extends
		HitsBaseProvider<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandardCollectionType, StudentScoreJudgementAgainstStandard, StudentScoreJudgementAgainstStandardService> {

	protected static final Logger L = LoggerFactory.getLogger(StudentScoreJudgementAgainstStandardProvider.class);

	/**
	 * @param providerID        The ID of the provider.
	 * @param serviceProperties values of provider property file.
	 */
	public StudentScoreJudgementAgainstStandardProvider() {
		super(StudentScoreJudgementAgainstStandardType.class, "StudentScoreJudgementAgainstStandard",
				StudentScoreJudgementAgainstStandardCollectionType.class, "StudentScoreJudgementAgainstStandards",
				StudentScoreJudgementAgainstStandardService.class);
	}
}
