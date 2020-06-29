package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.SchoolCourseInfoCollectionType;
import sif.dd.au30.model.SchoolCourseInfoType;
import sif.dd.au30.model.SubjectAreaListType;
import sif.dd.au30.model.SubjectAreaType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class SchoolCourseInfoTestData extends TestData<SchoolCourseInfoType, SchoolCourseInfoCollectionType> {

	public static final String REF_ID_1 = "d88570aa-099e-45cc-8cb8-23bd3c771eb3";
	public static final String REF_ID_2 = "ce08c686-8256-4c9f-b842-5c53c1040259";
	public static final String REF_ID_3 = "06e845b9-900d-4841-b838-7d009d3f2fa7";
	public static final String REF_ID_4 = "dea85c3d-5c68-4a38-93ca-299c73b0c925";
	public static final String REF_ID_5 = "e0ca11a3-787b-4ff0-9b98-dd5ef8f1e5e2";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "362a9ccf-642a-4e8a-93b0-08a16f415c61";
	public static final String XML_REF_ID_2 = "182df6dc-0037-4096-be81-c9b83c351427";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public SchoolCourseInfoType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		SchoolCourseInfoType schoolCourseInfo = new SchoolCourseInfoType();
		schoolCourseInfo.setRefId(refId);
		schoolCourseInfo.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
		schoolCourseInfo
				.setSchoolLocalId(objectFactory.createSchoolCourseInfoTypeSchoolLocalId(SchoolInfoTestData.LOCAL_ID));
		schoolCourseInfo.setSchoolYear(objectFactory.createSchoolCourseInfoTypeSchoolYear(getDate("2020")));
		schoolCourseInfo
				.setTermInfoRefId(objectFactory.createSchoolCourseInfoTypeTermInfoRefId(TermInfoTestData.REF_ID_1));
		schoolCourseInfo.setCourseCode("CourseCode");
		schoolCourseInfo.setStateCourseCode(objectFactory.createSchoolCourseInfoTypeStateCourseCode("StateCourseCode"));
		schoolCourseInfo.setDistrictCourseCode(
				objectFactory.createSchoolCourseInfoTypeDistrictCourseCode("DistrictCourseCode"));
		schoolCourseInfo.setCourseTitle("Course Title");
		schoolCourseInfo.setDescription(objectFactory.createSchoolCourseInfoTypeDescription("Course Description"));
		schoolCourseInfo.setInstructionalLevel(
				objectFactory.createSchoolCourseInfoTypeInstructionalLevel("Instructional Level"));
		schoolCourseInfo.setCourseCredits(objectFactory.createSchoolCourseInfoTypeCourseCredits("CourseCredits"));
		schoolCourseInfo.setCoreAcademicCourse(objectFactory
				.createSchoolCourseInfoTypeCoreAcademicCourse(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
		schoolCourseInfo.setGraduationRequirement(objectFactory
				.createSchoolCourseInfoTypeGraduationRequirement(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
		schoolCourseInfo.setDepartment(objectFactory.createSchoolCourseInfoTypeDepartment("Department"));
		schoolCourseInfo.setCourseContent(objectFactory.createSchoolCourseInfoTypeCourseContent("Course Content"));

		SubjectAreaListType subjectAreaListType = objectFactory.createSubjectAreaListType();
		subjectAreaListType.getSubjectArea().add(getSubjectArea(1));
		subjectAreaListType.getSubjectArea().add(getSubjectArea(2));
		subjectAreaListType.getSubjectArea().add(getSubjectArea(3));
		schoolCourseInfo
				.setSubjectAreaList(objectFactory.createSchoolCourseInfoTypeSubjectAreaList(subjectAreaListType));

		if (REF_ID_4.equals(refId)) {
			schoolCourseInfo.setSubjectAreaList(null);
		}

		return schoolCourseInfo;
	}

	private SubjectAreaType getSubjectArea(int index) {
		IObjectFactory objectFactory = getObjectFactory();
		SubjectAreaType subjectArea = objectFactory.createSubjectAreaType();
		subjectArea.setCode("Subject Area " + index);

		OtherCodeListType otherCodeList = objectFactory.createOtherCodeListType();
		otherCodeList.getOtherCode().add(getOtherCode(index, 1));
		otherCodeList.getOtherCode().add(getOtherCode(index, 2));
		otherCodeList.getOtherCode().add(getOtherCode(index, 3));
		subjectArea.setOtherCodeList(objectFactory.createSubjectAreaTypeOtherCodeList(otherCodeList));
		return subjectArea;
	}

	private OtherCode getOtherCode(int parentIndex, int index) {
		IObjectFactory objectFactory = getObjectFactory();
		OtherCode otherCode = objectFactory.createOtherCodeListTypeOtherCode();
		otherCode.setValue("Value " + parentIndex + " " + index);
		otherCode.setCodeset("Codeset " + parentIndex + " " + index);
		return otherCode;
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

	public SchoolCourseInfoCollectionType getTestCollection(String... refIds) {
		SchoolCourseInfoCollectionType result = new SchoolCourseInfoCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getSchoolCourseInfo().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "SchoolCourseInfo.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "SchoolCourseInfos.xml";
	}

}
