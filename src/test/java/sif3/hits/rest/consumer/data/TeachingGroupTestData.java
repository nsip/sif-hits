package sif3.hits.rest.consumer.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.bind.JAXBElement;

import sif.dd.au30.model.AUCodeSetsACStrandType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentListType;
import sif.dd.au30.model.TeacherListType;
import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupPeriodListType;
import sif.dd.au30.model.TeachingGroupPeriodType;
import sif.dd.au30.model.TeachingGroupStudentType;
import sif.dd.au30.model.TeachingGroupTeacherType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.utils.RefIdGenerator;

public class TeachingGroupTestData extends TestData<TeachingGroupType, TeachingGroupCollectionType> {

	public static final String REF_ID_1 = "8feeb970-94be-4b69-91b5-bf36188ed100";
	public static final String REF_ID_2 = "cf8d2444-a96f-4e81-b50e-40d3463ad213";
	public static final String REF_ID_3 = "e2394da1-cfaa-4b01-b75e-48e3a500039e";
	public static final String REF_ID_4 = "3f437191-ddf2-4874-a13c-231d1b8825cd";
	public static final String REF_ID_5 = "ddca0ff3-11b6-4175-b54b-4ac6e71d5b78";
	
    public static final String PU_REF_ID_1 = "132e7dc4-de18-46e9-8cac-0f80c2c66c13";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "0b1ea840-8b09-4ad9-a649-cc54d945d102";
	public static final String XML_REF_ID_2 = "bd6c8a0b-52c5-40c1-8b2e-eb47cc76d34a";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public static final Map<String, String> STAFF_MAP = new HashMap<>();

	static {
		STAFF_MAP.put(REF_ID_1, StaffPersonalTestData.REF_ID_1);
		STAFF_MAP.put(REF_ID_2, StaffPersonalTestData.REF_ID_2);
		STAFF_MAP.put(REF_ID_3, StaffPersonalTestData.REF_ID_3);
		STAFF_MAP.put(REF_ID_4, StaffPersonalTestData.REF_ID_4);
		STAFF_MAP.put(REF_ID_5, StaffPersonalTestData.REF_ID_5);
		STAFF_MAP.put(XML_REF_ID_1, StaffPersonalTestData.REF_ID_1);
		STAFF_MAP.put(XML_REF_ID_2, StaffPersonalTestData.REF_ID_2);
	}

	public static final String LOCAL_ID = "local-id-tg";

	public TeachingGroupType getTestObject(String refId) {
		ObjectFactory objectFactory = new ObjectFactory();
		TeachingGroupType teachingGroup = new TeachingGroupType();
		teachingGroup.setRefId(refId);
		teachingGroup
				.setSchoolInfoRefId(objectFactory.createTeachingGroupTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
		teachingGroup.setSchoolCourseLocalId(
				objectFactory.createTeachingGroupTypeSchoolLocalId(SchoolInfoTestData.LOCAL_ID));
		teachingGroup.setShortName("Short Name");
		teachingGroup.setLongName(objectFactory.createTeachingGroupTypeLongName("Long Name"));
		teachingGroup.setLocalId(LOCAL_ID);
		teachingGroup.setTimeTableSubjectRefId(
				objectFactory.createTeachingGroupTypeTimeTableSubjectRefId(TimeTableSubjectTestData.REF_ID_1));
		teachingGroup.setTimeTableSubjectLocalId(
				objectFactory.createTeachingGroupTypeTimeTableSubjectLocalId(TimeTableSubjectTestData.LOCAL_ID));
		teachingGroup.setSchoolYear(getDate("2014"));
		teachingGroup
				.setKeyLearningArea(objectFactory.createTeachingGroupTypeKeyLearningArea(AUCodeSetsACStrandType.A));

		TeacherListType teacherList = new TeacherListType();
		TeachingGroupTeacherType teacher = new TeachingGroupTeacherType();
		teacher.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(
				STAFF_MAP.getOrDefault(refId, StaffPersonalTestData.REF_ID_5)));
		teacher.setStaffLocalId(
				objectFactory.createTeachingGroupTeacherTypeStaffLocalId(StaffPersonalTestData.LOCAL_ID));
		teacher.setAssociation("Class Teacher");
		teacher.setName(objectFactory.createTeachingGroupStudentTypeName(StaffPersonalTestData.getNameOfRecord()));
		teacherList.getTeachingGroupTeacher().add(teacher);
		teachingGroup.setTeacherList(objectFactory.createTeachingGroupTypeTeacherList(teacherList));

		StudentListType studentList = getFullStudentList();

		teachingGroup.setStudentList(objectFactory.createTeachingGroupTypeStudentList(studentList));

		String timeTableCellRefId = TimeTableCellTestData.REF_ID_1;
		if (PU_REF_ID_1.equals(refId)) {
			timeTableCellRefId = TimeTableCellTestData.REF_ID_5;
		}
		if (!XML_REF_ID_LIST.contains(refId)) {
			// Need to add TeachingGroupPeriods!
			TeachingGroupPeriodListType periodList = new TeachingGroupPeriodListType();
			TeachingGroupPeriodType period = new TeachingGroupPeriodType();
			period.setTimeTableCellRefId(
					objectFactory.createTeachingGroupPeriodTypeTimeTableCellRefId(timeTableCellRefId));
			period.setRoomNumber(objectFactory.createTeachingGroupPeriodTypeRoomNumber(RoomInfoTestData.ROOM_NUMBER));
			period.setCellType(objectFactory.createTeachingGroupPeriodTypeCellType(TimeTableCellTestData.CELL_TYPE));
			period.setStaffLocalId(
					objectFactory.createTeachingGroupPeriodTypeStaffLocalId(StaffPersonalTestData.LOCAL_ID));
			period.setDayId(TimeTableCellTestData.DAY_ID_MAP.get(timeTableCellRefId));
			period.setPeriodId(objectFactory.createTeachingGroupPeriodTypePeriodId(TimeTableCellTestData.PERIOD_ID));
			periodList.getTeachingGroupPeriod().add(period);
			teachingGroup.setTeachingGroupPeriodList(
					objectFactory.createTeachingGroupTypeTeachingGroupPeriodList(periodList));
		}
		return teachingGroup;
	}

	public StudentListType getFullStudentList() {
		StudentListType result = new StudentListType();
		ObjectFactory objectFactory = new ObjectFactory();
		for (String studentPersonalRefId : StudentPersonalTestData.REF_ID_LIST) {
			TeachingGroupStudentType student = new TeachingGroupStudentType();
			student.setStudentPersonalRefId(
					objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(studentPersonalRefId));
			student.setName(
					objectFactory.createTeachingGroupStudentTypeName(StudentPersonalTestData.getNameOfRecord()));
			student.setStudentLocalId(
					objectFactory.createTeachingGroupStudentTypeStudentLocalId(StudentPersonalTestData.LOCAL_ID));
			result.getTeachingGroupStudent().add(student);
		}
		return result;
	}

	@Override
	public List<TeachingGroupType> getExamplesForQuery() {
		ObjectFactory objectFactory = new ObjectFactory();
		TeachingGroupType teachingGroup = new TeachingGroupType();
		teachingGroup
				.setSchoolInfoRefId(objectFactory.createTeachingGroupTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
		return Arrays.asList(teachingGroup);
	}

	@Override
	public boolean isExampleObject(TeachingGroupType object, int index) {
		return object != null && object.getSchoolInfoRefId() != null
				&& SchoolInfoTestData.REF_ID_1.equals(object.getSchoolInfoRefId().getValue());
	}

	@Override
	public List<QueryCriteria> getServicePathQueries() {
		List<QueryCriteria> servicePaths = new ArrayList<>();
		{
			QueryCriteria queryCriteria = new QueryCriteria();
			queryCriteria.addPredicate(
					new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalTestData.REF_ID_4));
			servicePaths.add(queryCriteria);
		}
		{
			QueryCriteria queryCriteria = new QueryCriteria();
			queryCriteria.addPredicate(
					new QueryPredicate("StaffPersonals", QueryOperator.EQUAL, StaffPersonalTestData.REF_ID_4));
			servicePaths.add(queryCriteria);
		}
		return servicePaths;
	}

	@Override
	public boolean isServicePathObject(TeachingGroupType object, int index) {
		if (index == 0) {
			return Optional.ofNullable(object).map(TeachingGroupType::getStudentList).map(JAXBElement::getValue)
					.map(StudentListType::getTeachingGroupStudent).orElse(new ArrayList<>()).stream()
					.map(TeachingGroupStudentType::getStudentPersonalRefId).map(JAXBElement::getValue)
					.anyMatch(g -> StudentPersonalTestData.REF_ID_4.equals(g));
		} else if (index == 1) {
			return Optional.ofNullable(object).map(TeachingGroupType::getTeacherList).map(JAXBElement::getValue)
					.map(TeacherListType::getTeachingGroupTeacher).orElse(new ArrayList<>()).stream()
					.map(TeachingGroupTeacherType::getStaffPersonalRefId).map(JAXBElement::getValue)
					.anyMatch(g -> StaffPersonalTestData.REF_ID_4.equals(g));
		}
		return false;
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

	public TeachingGroupCollectionType getTestCollection(String... refIds) {
		TeachingGroupCollectionType result = new TeachingGroupCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getTeachingGroup().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "TeachingGroup.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "TeachingGroups.xml";
	}

}
