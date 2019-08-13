package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.utils.RefIdGenerator;

import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ScheduledActivityTestData extends TestData<ScheduledActivityType, ScheduledActivityCollectionType> {

    public static final String REF_ID_1 = "a71c3e74-d6e2-4bb8-ad45-e857c563ea36";
    public static final String REF_ID_2 = "039297ec-7d29-4cdc-9861-a6a13fa6d322";
    public static final String REF_ID_3 = "81f283e9-baa6-492c-aba5-aa7a81c12e3b";
    public static final String REF_ID_4 = "b1babc7f-699c-4ef4-9fae-f1cb130b329e";
    public static final String REF_ID_5 = "9e1340d9-0eb0-497a-9b57-e3f830baa371";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "77aa6df4-55c0-49e7-9ada-ab73059de532";
    public static final String XML_REF_ID_2 = "6446fa9b-9a56-41a7-b472-c37228e70bd3";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public ScheduledActivityType getTestObject(String refId) {
        ObjectFactory objectFactory = new ObjectFactory();

        ScheduledActivityType scheduledActivity = new ScheduledActivityType();
        scheduledActivity.setRefId(refId);
        scheduledActivity.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        scheduledActivity.setTimeTableCellRefId(objectFactory.createScheduledActivityTypeTimeTableCellRefId(TimeTableCellTestData.REF_ID_1));
        scheduledActivity.setTimeTableSubjectRefId(objectFactory.createScheduledActivityTypeTimeTableSubjectRefId(TimeTableSubjectTestData.REF_ID_1));
        scheduledActivity.setTimeTableRefId(objectFactory.createScheduledActivityTypeTimeTableRefId(TimeTableTestData.REF_ID_1));
        scheduledActivity.setDayId(objectFactory.createScheduledActivityTypeDayId(TimeTableCellTestData.DAY_ID));
        scheduledActivity.setPeriodId(objectFactory.createScheduledActivityTypePeriodId(TimeTableCellTestData.PERIOD_ID));
        scheduledActivity.setActivityDate(getDate("2014-09-01"));
        scheduledActivity.setStartTime(getDate("09:30:00"));
        scheduledActivity.setFinishTime(getDate("13:30:00"));
        scheduledActivity.setCellType(objectFactory.createScheduledActivityTypeCellType("Teaching"));
        scheduledActivity.setLocation(objectFactory.createScheduledActivityTypeLocation("Location"));
        scheduledActivity.setActivityType(objectFactory.createScheduledActivityTypeActivityType(AUCodeSetsScheduledActivityTypeType.EXAM));
        scheduledActivity.setActivityName(objectFactory.createScheduledActivityTypeActivityName("The Exam"));
        scheduledActivity.setActivityComment(objectFactory.createScheduledActivityTypeActivityComment("The Comment"));

        YearLevelsType yearLevelsType = new YearLevelsType();
        YearLevelType yearLevel = new YearLevelType();
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("9"));
        yearLevelsType.getYearLevel().add(yearLevel);
        scheduledActivity.setYearLevels(objectFactory.createScheduledActivityTypeYearLevels(yearLevelsType));

        ScheduledActivityOverrideType override = new ScheduledActivityOverrideType();
        override.setValue(AUCodeSetsYesOrNoCategoryType.Y);
        override.setDateOfOverride(getDate("2014-09-02"));
        scheduledActivity.setOverride(objectFactory.createScheduledActivityTypeOverride(override));

        RoomListType roomList = new RoomListType();
        roomList.getRoomInfoRefId().add(RoomInfoTestData.REF_ID_1);
        scheduledActivity.setRoomList(objectFactory.createScheduledActivityTypeRoomList(roomList));

        ScheduledTeacherListType teacherList = new ScheduledTeacherListType();
        TeacherCoverType teacherCover = new TeacherCoverType();
        teacherCover.setStaffPersonalRefId(StaffPersonalTestData.REF_ID_1);
        teacherCover.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(StaffPersonalTestData.LOCAL_ID));
        teacherCover.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getDate("09:30:00")));
        teacherCover.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getDate("13:30:00")));
        teacherCover.setCredit(objectFactory.createTeacherCoverTypeCredit(AUCodeSetsTeacherCoverCreditType.EXTRA));
        teacherCover.setSupervision(objectFactory.createTeacherCoverTypeSupervision(AUCodeSetsTeacherCoverSupervisionType.NORMAL));
        teacherCover.setWeighting(objectFactory.createTeacherCoverTypeWeighting(new BigDecimal("1.0")));
        teacherList.getTeacherCover().add(teacherCover);
        scheduledActivity.setTeacherList(objectFactory.createScheduledActivityTypeTeacherList(teacherList));

        StudentsType studentList = new StudentsType();
        studentList.getStudentPersonalRefId().addAll(StudentPersonalTestData.REF_ID_LIST);
        scheduledActivity.setStudentList(objectFactory.createScheduledActivityTypeStudentList(studentList));

        TeachingGroupListType teachingGroupList = new TeachingGroupListType();
        teachingGroupList.getTeachingGroupRefId().add(TeachingGroupTestData.REF_ID_1);
        scheduledActivity.setTeachingGroupList(objectFactory.createScheduledActivityTypeTeachingGroupList(teachingGroupList));
        return scheduledActivity;
    }

    @Override
    public List<ScheduledActivityType> getExamplesForQuery() {
        ScheduledActivityType example = new ScheduledActivityType();
        example.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        return Arrays.asList(example);
    }

    @Override
    public boolean isExampleObject(ScheduledActivityType object, int index) {
        return object != null && SchoolInfoTestData.REF_ID_1.equals(object.getSchoolInfoRefId());
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        List<QueryCriteria> servicePaths = new ArrayList<>();
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("StaffPersonals", QueryOperator.EQUAL, StaffPersonalTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("TeachingGroups", QueryOperator.EQUAL, TeachingGroupTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        return servicePaths;
    }

    @Override
    public boolean isServicePathObject(ScheduledActivityType object, int index) {
        boolean result = false;
        if (index == 0) {
            result = Optional.ofNullable(object).map(ScheduledActivityType::getTeacherList).map(JAXBElement::getValue).map(ScheduledTeacherListType::getTeacherCover).orElse(new ArrayList<>()).stream().anyMatch(t -> StaffPersonalTestData.REF_ID_1.equals(t.getStaffPersonalRefId()));
        } else if (index == 1) {
            result = Optional.ofNullable(object).map(ScheduledActivityType::getTeachingGroupList).map(JAXBElement::getValue).map(TeachingGroupListType::getTeachingGroupRefId).orElse(new ArrayList<>()).stream().anyMatch(s -> TeachingGroupTestData.REF_ID_1.equals(s));
        } else if (index == 2) {
            result = Optional.ofNullable(object).map(ScheduledActivityType::getStudentList).map(JAXBElement::getValue).map(StudentsType::getStudentPersonalRefId).orElse(new ArrayList<>()).stream().anyMatch(s -> StudentPersonalTestData.REF_ID_1.equals(s));
        }
        return result;
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

    public ScheduledActivityCollectionType getTestCollection(String... refIds) {
        ScheduledActivityCollectionType result = new ScheduledActivityCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getScheduledActivity().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "ScheduledActivity.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "ScheduledActivitys.xml";
    }

}

