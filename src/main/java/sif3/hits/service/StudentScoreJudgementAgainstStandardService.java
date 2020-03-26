package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentScoreJudgementAgainstStandardCollectionType;
import sif.dd.au30.model.StudentScoreJudgementAgainstStandardType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentScoreJudgementAgainstStandardConverter;
import sif3.hits.domain.dao.StudentScoreJudgementAgainstStandardDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentScoreJudgementAgainstStandardFilterDAO;
import sif3.hits.domain.model.StudentScoreJudgementAgainstStandard;

@Service
public class StudentScoreJudgementAgainstStandardService extends
		BaseService<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandardCollectionType, StudentScoreJudgementAgainstStandard> {

	@Autowired
	private StudentScoreJudgementAgainstStandardConverter studentScoreJudgementAgainstStandardConverter;

	@Autowired
	private StudentScoreJudgementAgainstStandardDAO studentScoreJudgementAgainstStandardDAO;

	@Autowired
	private StudentScoreJudgementAgainstStandardFilterDAO studentScoreJudgementAgainstStandardFilterDAO;

	@Override
	protected StudentScoreJudgementAgainstStandardCollectionType getCollection(
			List<StudentScoreJudgementAgainstStandardType> items) {
		StudentScoreJudgementAgainstStandardCollectionType result = new StudentScoreJudgementAgainstStandardCollectionType();
		if (items != null) {
			result.getStudentScoreJudgementAgainstStandard().addAll(items);
		}
		return result;
	}

	@Override
	protected HitsConverter<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandard> getConverter() {
		return studentScoreJudgementAgainstStandardConverter;
	}

	@Override
	protected JpaRepository<StudentScoreJudgementAgainstStandard, String> getDAO() {
		return studentScoreJudgementAgainstStandardDAO;
	}

	@Override
	protected FilterableRepository<StudentScoreJudgementAgainstStandard, StudentScoreJudgementAgainstStandardType> getFilterableDAO() {
		return studentScoreJudgementAgainstStandardFilterDAO;
	}
}
