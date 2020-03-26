package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.LearningStandardListType;
import sif.dd.au30.model.LearningStandardType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentScoreJudgementAgainstStandardCollectionType;
import sif.dd.au30.model.StudentScoreJudgementAgainstStandardType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class StudentScoreJudgementAgainstStandardTestData
		extends TestData<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandardCollectionType> {

	public static final String REF_ID_1 = "2ec6cdf4-aaa9-46c9-b613-d293f6c77754";
	public static final String REF_ID_2 = "8e942ce7-bc69-478b-a0b5-66e67a179cab";
	public static final String REF_ID_3 = "8e36d583-8fbb-4893-af25-5b19f2652ba9";
	public static final String REF_ID_4 = "079fb957-1940-4c0d-a25e-e36987e2eb70";
	public static final String REF_ID_5 = "4cc60865-cd64-4c40-99b2-0e57ef60399f";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "29f5fbcd-bc67-4980-8b1c-2340693a3bcf";
	public static final String XML_REF_ID_2 = "8ae40e19-3f56-48b2-9a45-d4816c387cd9";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);
	
	

	public StudentScoreJudgementAgainstStandardType getTestObject(String refId) {
		ObjectFactory objectFactory = new ObjectFactory();

		StudentScoreJudgementAgainstStandardType studentScoreJudgementAgainstStandard = objectFactory
				.createStudentScoreJudgementAgainstStandardType();
		studentScoreJudgementAgainstStandard.setRefId(refId);

		studentScoreJudgementAgainstStandard.setSchoolYear(getDate("2020"));
		studentScoreJudgementAgainstStandard.setTermInfoRefId(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeTermInfoRefId(TermInfoTestData.REF_ID_1));
		studentScoreJudgementAgainstStandard.setLocalTermCode(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeLocalTermCode("local-term-code"));
		studentScoreJudgementAgainstStandard.setStudentPersonalRefId(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_1));
		studentScoreJudgementAgainstStandard.setStudentStateProvinceId(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeStudentStateProvinceId("student-sp-id"));
		studentScoreJudgementAgainstStandard.setStudentLocalId(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeStudentLocalId(StudentPersonalTestData.LOCAL_ID));

		YearLevelType yearLevel = objectFactory.createYearLevelType();
		yearLevel.setCode(AUCodeSetsYearLevelCodeType.VALUE_9);
		studentScoreJudgementAgainstStandard.setYearLevel(yearLevel);

		studentScoreJudgementAgainstStandard.setTeachingGroupRefId(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeTeachingGroupRefId(TeachingGroupTestData.REF_ID_1));
		studentScoreJudgementAgainstStandard.setClassLocalId(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeClassLocalId("class-local-id"));
		studentScoreJudgementAgainstStandard.setStaffPersonalRefId(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeStaffPersonalRefId(StaffPersonalTestData.REF_ID_1));
		studentScoreJudgementAgainstStandard.setStaffLocalId(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeStaffLocalId(StaffPersonalTestData.LOCAL_ID));
		studentScoreJudgementAgainstStandard.setCurriculumCode(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeCurriculumCode("curr-code"));
		studentScoreJudgementAgainstStandard.setCurriculumNodeCode(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeCurriculumNodeCode("curr-node-code"));
		studentScoreJudgementAgainstStandard.setScore("77.87");
		studentScoreJudgementAgainstStandard.setSpecialCircumstanceLocalCode(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeSpecialCircumstanceLocalCode("sc-lc"));
		studentScoreJudgementAgainstStandard.setManagedPathwayLocalCode(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeManagedPathwayLocalCode("mp-lc"));
		studentScoreJudgementAgainstStandard.setSchoolInfoRefId(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
		studentScoreJudgementAgainstStandard.setSchoolLocalId(
				objectFactory.createStudentScoreJudgementAgainstStandardTypeSchoolLocalId(SchoolInfoTestData.LOCAL_ID));
		studentScoreJudgementAgainstStandard.setSchoolCommonwealthId(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeSchoolCommonwealthId(SchoolInfoTestData.ACARA_ID));

		LearningStandardListType learningStandardListType = objectFactory.createLearningStandardListType();
		learningStandardListType.getLearningStandard().add(getLearningStandard(1));
		learningStandardListType.getLearningStandard().add(getLearningStandard(2));
		learningStandardListType.getLearningStandard().add(getLearningStandard(3));
		studentScoreJudgementAgainstStandard.setLearningStandardList(objectFactory
				.createStudentScoreJudgementAgainstStandardTypeLearningStandardList(learningStandardListType));

		return studentScoreJudgementAgainstStandard;
	}

	public LearningStandardType getLearningStandard(int index) {
		IObjectFactory objectFactory = getObjectFactory();
		LearningStandardType learningStandard = objectFactory.createLearningStandardType();

		learningStandard
				.setLearningStandardItemRefId(objectFactory.createLearningStandardTypeLearningStandardItemRefId(
						LearningStandardItemTestData.getSharedRefId(index)));
		learningStandard.setLearningStandardURL(objectFactory.createLearningStandardTypeLearningStandardURL(
				"https://some-domain-not-real/learning-standard-" + index + ".html"));
		learningStandard.setLearningStandardLocalId(
				objectFactory.createLearningStandardTypeLearningStandardLocalId("local-id-" + index));
		return learningStandard;
	}

	@Override
	public boolean verifyAllInitialObjects() {
		return true;
	}

	public String getRefId(int index) {
		String result = null;
		if (index >= 0 && index < REF_ID_RA.length) {
			result = REF_ID_RA[index];
		} else {
			result = RefIdGenerator.getRefId();
		}
		return result;
	}

	public StudentScoreJudgementAgainstStandardCollectionType getTestCollection(String... refIds) {
		StudentScoreJudgementAgainstStandardCollectionType result = new StudentScoreJudgementAgainstStandardCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getStudentScoreJudgementAgainstStandard().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "StudentScoreJudgementAgainstStandard.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "StudentScoreJudgementAgainstStandards.xml";
	}

}
