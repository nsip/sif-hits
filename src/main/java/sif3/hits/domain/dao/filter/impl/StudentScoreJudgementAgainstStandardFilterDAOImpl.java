package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.StudentScoreJudgementAgainstStandardType;
import sif3.hits.domain.dao.filter.StudentScoreJudgementAgainstStandardFilterDAO;
import sif3.hits.domain.model.StudentScoreJudgementAgainstStandard;

@Repository
public class StudentScoreJudgementAgainstStandardFilterDAOImpl
		extends BaseFilterableRepository<StudentScoreJudgementAgainstStandard, StudentScoreJudgementAgainstStandardType>
		implements StudentScoreJudgementAgainstStandardFilterDAO {
	public StudentScoreJudgementAgainstStandardFilterDAOImpl() {
		super(StudentScoreJudgementAgainstStandard.class, StudentScoreJudgementAgainstStandardType.class);
	}
}
