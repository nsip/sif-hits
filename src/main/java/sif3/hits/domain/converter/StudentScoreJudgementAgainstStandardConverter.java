package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.LearningStandardListType;
import sif.dd.au30.model.LearningStandardType;
import sif.dd.au30.model.StudentScoreJudgementAgainstStandardType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LearningStandard;
import sif3.hits.domain.model.StudentScoreJudgementAgainstStandard;

@Component
public class StudentScoreJudgementAgainstStandardConverter
		extends HitsConverter<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandard> {

	@Autowired
	private LearningStandardConverter learningStandardConverter;

	public StudentScoreJudgementAgainstStandardConverter() {
		super(StudentScoreJudgementAgainstStandardType.class, StudentScoreJudgementAgainstStandard.class);
	}

	@Override
	public void toSifModel(StudentScoreJudgementAgainstStandard source,
			StudentScoreJudgementAgainstStandardType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setSchoolYear(getYearValue(source.getSchoolYear()));
			target.setTermInfoRefId(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeTermInfoRefId(source.getTermInfoRefId()));
			target.setLocalTermCode(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeLocalTermCode(source.getLocalTermCode()));
			target.setStudentPersonalRefId(
					objectFactory.createStudentScoreJudgementAgainstStandardTypeStudentPersonalRefId(
							source.getStudentPersonalRefId()));
			target.setStudentStateProvinceId(
					objectFactory.createStudentScoreJudgementAgainstStandardTypeStudentStateProvinceId(
							source.getStudentStateProvinceId()));
			target.setStudentLocalId(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeStudentLocalId(source.getStudentLocalId()));

			if (StringUtils.isNotBlank(source.getYearLevel())) {
				YearLevelType yearLevel = objectFactory.createYearLevelType();
				yearLevel.setCode(getEnumValue(source.getYearLevel(), AUCodeSetsYearLevelCodeType.class));
				target.setYearLevel(yearLevel);
			}

			target.setTeachingGroupRefId(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeTeachingGroupRefId(source.getTeachingGroupRefId()));
			target.setClassLocalId(
					objectFactory.createStudentScoreJudgementAgainstStandardTypeClassLocalId(source.getClassLocalId()));
			target.setStaffPersonalRefId(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeStaffPersonalRefId(source.getStaffPersonalRefId()));
			target.setStaffLocalId(
					objectFactory.createStudentScoreJudgementAgainstStandardTypeStaffLocalId(source.getStaffLocalId()));
			target.setCurriculumCode(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeCurriculumCode(source.getCurriculumCode()));
			target.setCurriculumNodeCode(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeCurriculumNodeCode(source.getCurriculumNodeCode()));
			target.setScore(source.getScore());
			target.setSpecialCircumstanceLocalCode(
					objectFactory.createStudentScoreJudgementAgainstStandardTypeSpecialCircumstanceLocalCode(
							source.getSpecialCircumstanceLocalCode()));
			target.setManagedPathwayLocalCode(
					objectFactory.createStudentScoreJudgementAgainstStandardTypeManagedPathwayLocalCode(
							source.getManagedPathwayLocalCode()));
			target.setSchoolInfoRefId(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
			target.setSchoolLocalId(objectFactory
					.createStudentScoreJudgementAgainstStandardTypeSchoolLocalId(source.getSchoolLocalId()));
			target.setSchoolCommonwealthId(
					objectFactory.createStudentScoreJudgementAgainstStandardTypeSchoolCommonwealthId(
							source.getSchoolCommonwealthId()));

			List<LearningStandardType> learningStandards = learningStandardConverter
					.toSifModelList(source.getLearningStandardList());
			if (!learningStandards.isEmpty()) {
				LearningStandardListType learningStandardListType = objectFactory.createLearningStandardListType();
				learningStandardListType.getLearningStandard().addAll(learningStandards);
				target.setLearningStandardList(objectFactory
						.createStudentScoreJudgementAgainstStandardTypeLearningStandardList(learningStandardListType));
			}
		}
	}

	@Override
	public void toHitsModel(StudentScoreJudgementAgainstStandardType source,
			StudentScoreJudgementAgainstStandard target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setSchoolYear(getYearValue(source.getSchoolYear()));
			target.setTermInfoRefId(getJAXBValue(source.getTermInfoRefId()));
			target.setLocalTermCode(getJAXBValue(source.getLocalTermCode()));
			target.setStudentPersonalRefId(getJAXBValue(source.getStudentPersonalRefId()));
			target.setStudentStateProvinceId(getJAXBValue(source.getStudentStateProvinceId()));
			target.setStudentLocalId(getJAXBValue(source.getStudentLocalId()));

			target.setYearLevel(null);
			YearLevelType yearLevel = source.getYearLevel();
			if (yearLevel != null) {
				target.setYearLevel(getEnumValue(yearLevel.getCode()));
			}
			target.setTeachingGroupRefId(getJAXBValue(source.getTeachingGroupRefId()));
			target.setClassLocalId(getJAXBValue(source.getClassLocalId()));
			target.setStaffPersonalRefId(getJAXBValue(source.getStaffPersonalRefId()));
			target.setStaffLocalId(getJAXBValue(source.getStaffLocalId()));
			target.setCurriculumCode(getJAXBValue(source.getCurriculumCode()));
			target.setCurriculumNodeCode(getJAXBValue(source.getCurriculumNodeCode()));
			target.setScore(source.getScore());
			target.setSpecialCircumstanceLocalCode(getJAXBValue(source.getSpecialCircumstanceLocalCode()));
			target.setManagedPathwayLocalCode(getJAXBValue(source.getManagedPathwayLocalCode()));
			target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
			target.setSchoolLocalId(getJAXBValue(source.getSchoolLocalId()));
			target.setSchoolCommonwealthId(getJAXBValue(source.getSchoolCommonwealthId()));

			if (target.getLearningStandardList() == null) {
				target.setLearningStandardList(new ArrayList<>());
			}
			target.getLearningStandardList().clear();
			LearningStandardListType learningStandardListType = getJAXBValue(source.getLearningStandardList());
			if (learningStandardListType != null) {
				List<LearningStandard> learningStandards = learningStandardConverter
						.toHitsModelList(learningStandardListType.getLearningStandard());
				for (LearningStandard learningStandard : learningStandards) {
					learningStandard.setStudentScoreJudgementAgainstStandard(target);
					target.getLearningStandardList().add(learningStandard);
				}
			}
		}
	}

}
