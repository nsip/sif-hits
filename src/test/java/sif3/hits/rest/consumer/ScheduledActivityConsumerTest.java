package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsScheduledActivityTypeType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverCreditType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverSupervisionType;
import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.RoomListType;
import sif.dd.au30.model.ScheduledActivityCollectionType;
import sif.dd.au30.model.ScheduledActivityOverrideType;
import sif.dd.au30.model.ScheduledActivityType;
import sif.dd.au30.model.ScheduledTeacherListType;
import sif.dd.au30.model.StudentsType;
import sif.dd.au30.model.TeacherCoverType;
import sif.dd.au30.model.TeachingGroupListType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class ScheduledActivityConsumerTest extends BaseTest {
    private ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType> scheduledActivityTester = null;

    public static final String REF_ID = "af7d1111-419b-4ff5-a3e8-d49bcb8456e5";
    public static final String REF_ID_5 = "78748f1f-474a-461d-a7d4-4e1f1d7a4b90";
    private final String REF_ID_1 = "596bd118-14cb-485a-84d3-593fc5703958";
    private final String REF_ID_2 = "df54713a-db1c-4428-a418-d8a5964d893a";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        ScheduledActivityType scheduledActivity = new ScheduledActivityType();
        scheduledActivity.setRefId(REF_ID);
        scheduledActivity.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        scheduledActivity.setTimeTableCellRefId(objectFactory.createScheduledActivityTypeTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID));
        scheduledActivity.setTimeTableSubjectRefId(objectFactory.createScheduledActivityTypeTimeTableSubjectRefId(TimeTableSubjectConsumerTest.REF_ID));
        scheduledActivity.setTimeTableRefId(objectFactory.createScheduledActivityTypeTimeTableRefId(TimeTableConsumerTest.REF_ID));
        scheduledActivity.setDayId(objectFactory.createScheduledActivityTypeDayId(TimeTableCellConsumerTest.DAY_ID));
        scheduledActivity.setPeriodId(objectFactory.createScheduledActivityTypePeriodId(TimeTableCellConsumerTest.PERIOD_ID));
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
        override.setValue(AUCodeSetsYesOrNoCategoryType.Y.name());
        override.setDateOfOverride(getDate("2014-09-02"));
        scheduledActivity.setOverride(objectFactory.createScheduledActivityTypeOverride(override));

        RoomListType roomList = new RoomListType();
        roomList.getRoomInfoRefId().add(RoomInfoConsumerTest.REF_ID);
        scheduledActivity.setRoomList(objectFactory.createScheduledActivityTypeRoomList(roomList));

        ScheduledTeacherListType teacherList = new ScheduledTeacherListType();
        TeacherCoverType teacherCover = new TeacherCoverType();
        teacherCover.setStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1);
        teacherCover.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
        teacherCover.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getDate("09:30:00")));
        teacherCover.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getDate("13:30:00")));
        teacherCover.setCredit(objectFactory.createTeacherCoverTypeCredit(AUCodeSetsTeacherCoverCreditType.EXTRA));
        teacherCover.setSupervision(objectFactory.createTeacherCoverTypeSupervision(AUCodeSetsTeacherCoverSupervisionType.NORMAL));
        teacherCover.setWeighting(objectFactory.createTeacherCoverTypeWeighting(new BigDecimal("1.0")));
        teacherList.getTeacherCover().add(teacherCover);
        scheduledActivity.setTeacherList(objectFactory.createScheduledActivityTypeTeacherList(teacherList));

        StudentsType studentList = new StudentsType();
        studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_1);
        studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_2);
        studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_3);
        studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_4);
        studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_5);
        scheduledActivity.setStudentList(objectFactory.createScheduledActivityTypeStudentList(studentList));

        TeachingGroupListType teachingGroupList = new TeachingGroupListType();
        teachingGroupList.getTeachingGroupRefId().add(TeachingGroupConsumerTest.REF_ID);
        scheduledActivity.setTeachingGroupList(objectFactory.createScheduledActivityTypeTeachingGroupList(teachingGroupList));

        scheduledActivityTester.doCreateOne(scheduledActivity);
        String xmlExpectedTo = scheduledActivityTester.getXML(scheduledActivity);

        scheduledActivity.setRefId("9c884119-d4eb-4624-93c4-f3bbac8c7c72");
        scheduledActivityTester.doCreateOne(scheduledActivity);

        scheduledActivity.setRefId("48c1b75c-fc5e-4155-a2f4-b1cd57c29bb5");
        scheduledActivityTester.doCreateOne(scheduledActivity);

        scheduledActivity.setRefId("44db9710-5f26-43c2-b3db-0e4168e8d0db");
        scheduledActivityTester.doCreateOne(scheduledActivity);

        scheduledActivity.setRefId(REF_ID_5);
        scheduledActivityTester.doCreateOne(scheduledActivity);

        ScheduledActivityType getResult = scheduledActivityTester.doGetOne(REF_ID);
        String xmlExpectedFrom = scheduledActivityTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        ScheduledActivityType scheduledActivity = new ScheduledActivityType();
        scheduledActivity.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        List<Response> responses = scheduledActivityTester.testQBE(scheduledActivity, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        ScheduledActivityCollectionType scheduledActivityCollectionType = (ScheduledActivityCollectionType) response.getDataObject();
        Assert.assertNotNull(scheduledActivityCollectionType.getScheduledActivity());
        Assert.assertFalse(scheduledActivityCollectionType.getScheduledActivity().isEmpty());
        boolean found = false;
        for (ScheduledActivityType scheduledActivityType : scheduledActivityCollectionType.getScheduledActivity()) {
            found = found || REF_ID.equals(scheduledActivityType.getRefId());
            Assert.assertEquals(SchoolInfoConsumerTest.REF_ID, scheduledActivityType.getSchoolInfoRefId());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePathStaffPersonal() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("StaffPersonals", QueryOperator.EQUAL, StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1));

        List<Response> responses = scheduledActivityTester.testServicePath(queryCriteria, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        ScheduledActivityCollectionType scheduledActivityCollectionType = (ScheduledActivityCollectionType) response.getDataObject();
        Assert.assertNotNull(scheduledActivityCollectionType);
        Assert.assertNotNull(scheduledActivityCollectionType.getScheduledActivity());
        Assert.assertFalse(scheduledActivityCollectionType.getScheduledActivity().isEmpty());
        boolean found = false;
        for (ScheduledActivityType scheduledActivityType : scheduledActivityCollectionType.getScheduledActivity()) {
            found = found || REF_ID.equals(scheduledActivityType.getRefId());
            Assert.assertNotNull(scheduledActivityType.getTeacherList());
            Assert.assertNotNull(scheduledActivityType.getTeacherList().getValue());
            Assert.assertNotNull(scheduledActivityType.getTeacherList().getValue().getTeacherCover());
            Assert.assertFalse(scheduledActivityType.getTeacherList().getValue().getTeacherCover().isEmpty());
            boolean staffFound = false;
            for (TeacherCoverType teacherCover : scheduledActivityType.getTeacherList().getValue().getTeacherCover()) {
                staffFound = staffFound || StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1.equals(teacherCover.getStaffPersonalRefId());
            }
            Assert.assertTrue(staffFound);
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePathStudentPersonal() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalRefIds.REF_ID_1));

        List<Response> responses = scheduledActivityTester.testServicePath(queryCriteria, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        ScheduledActivityCollectionType scheduledActivityCollectionType = (ScheduledActivityCollectionType) response.getDataObject();
        Assert.assertNotNull(scheduledActivityCollectionType);
        Assert.assertNotNull(scheduledActivityCollectionType.getScheduledActivity());
        Assert.assertFalse(scheduledActivityCollectionType.getScheduledActivity().isEmpty());
        boolean found = false;
        for (ScheduledActivityType scheduledActivityType : scheduledActivityCollectionType.getScheduledActivity()) {
            found = found || REF_ID.equals(scheduledActivityType.getRefId());
            Assert.assertNotNull(scheduledActivityType.getStudentList());
            Assert.assertNotNull(scheduledActivityType.getStudentList().getValue());
            Assert.assertNotNull(scheduledActivityType.getStudentList().getValue().getStudentPersonalRefId());
            Assert.assertTrue(scheduledActivityType.getStudentList().getValue().getStudentPersonalRefId().contains(StudentPersonalRefIds.REF_ID_1));
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePathTeachingGroup() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("TeachingGroups", QueryOperator.EQUAL, TeachingGroupConsumerTest.REF_ID));

        List<Response> responses = scheduledActivityTester.testServicePath(queryCriteria, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        ScheduledActivityCollectionType scheduledActivityCollectionType = (ScheduledActivityCollectionType) response.getDataObject();
        Assert.assertNotNull(scheduledActivityCollectionType);
        Assert.assertNotNull(scheduledActivityCollectionType.getScheduledActivity());
        Assert.assertFalse(scheduledActivityCollectionType.getScheduledActivity().isEmpty());
        boolean found = false;
        for (ScheduledActivityType scheduledActivityType : scheduledActivityCollectionType.getScheduledActivity()) {
            found = found || REF_ID.equals(scheduledActivityType.getRefId());
            Assert.assertNotNull(scheduledActivityType.getTeachingGroupList());
            Assert.assertNotNull(scheduledActivityType.getTeachingGroupList().getValue());
            Assert.assertNotNull(scheduledActivityType.getTeachingGroupList().getValue().getTeachingGroupRefId());
            Assert.assertTrue(scheduledActivityType.getTeachingGroupList().getValue().getTeachingGroupRefId().contains(TeachingGroupConsumerTest.REF_ID));
        }
        Assert.assertTrue(found);
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        scheduledActivityTester = new ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType>(ScheduledActivityType.class, "ScheduledActivity",
                ScheduledActivityCollectionType.class, "ScheduledActivitys");
        scheduledActivityTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = scheduledActivityTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        ScheduledActivityType scheduledActivity = (ScheduledActivityType) response.getDataObject();
        Assert.assertEquals(REF_ID, scheduledActivity.getRefId());

        String xmlExpectedFrom = scheduledActivityTester.getXML(scheduledActivity);

        List<Response> updateResponses = scheduledActivityTester.doUpdateOne(scheduledActivity, REF_ID);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = scheduledActivityTester.testGetSingle(REF_ID);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        ScheduledActivityType comparisonTo = (ScheduledActivityType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID, comparisonTo.getRefId());
        String xmlExpectedTo = scheduledActivityTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateEmptyTeachers() throws UnmarshalException, UnsupportedMediaTypeExcpetion, MarshalException {
        String contents = scheduledActivityTester.getFileContents("scheduledactivity.xml");
        ScheduledActivityType scheduledActivity = scheduledActivityTester.fromXML(contents);
        scheduledActivity.getTeacherList().getValue().getTeacherCover().clear();
        String xmlExpectedFrom = scheduledActivityTester.getXML(scheduledActivity);

        List<Response> createResponses = scheduledActivityTester.doCreateOne(scheduledActivity);
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        ScheduledActivityType createdScheduledActivity = (ScheduledActivityType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, createdScheduledActivity.getRefId());

        String xmlExpectedCreate = scheduledActivityTester.getXML(createdScheduledActivity);

        List<Response> updateResponses = scheduledActivityTester.doUpdateOne(scheduledActivity, REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = scheduledActivityTester.testGetSingle(REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        ScheduledActivityType comparisonTo = (ScheduledActivityType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = scheduledActivityTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        boolean semiEqualsTwo = semiEquals(xmlExpectedFrom, xmlExpectedCreate);
        if (!semiEquals || !semiEqualsTwo) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nCreate:\n" + xmlExpectedCreate);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateFullTeachers() throws UnmarshalException, UnsupportedMediaTypeExcpetion, MarshalException {
        String contents = scheduledActivityTester.getFileContents("scheduledactivity.xml");
        ScheduledActivityType scheduledActivity = scheduledActivityTester.fromXML(contents);
        String xmlExpectedFrom = scheduledActivityTester.getXML(scheduledActivity);

        List<Response> createResponses = scheduledActivityTester.doCreateOne(scheduledActivity);
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        ScheduledActivityType createdScheduledActivity = (ScheduledActivityType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, createdScheduledActivity.getRefId());
        String xmlExpectedCreate = scheduledActivityTester.getXML(createdScheduledActivity);

        scheduledActivity.getTeacherList().getValue().getTeacherCover().clear();
        String xmlExpectedUpdate = scheduledActivityTester.getXML(scheduledActivity);

        List<Response> updateResponses = scheduledActivityTester.doUpdateOne(scheduledActivity, REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = scheduledActivityTester.testGetSingle(REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        ScheduledActivityType comparisonTo = (ScheduledActivityType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = scheduledActivityTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedUpdate, xmlExpectedTo);
        boolean semiEqualsTwo = semiEquals(xmlExpectedFrom, xmlExpectedCreate);
        if (!semiEqualsTwo) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nCreate:\n" + xmlExpectedCreate);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedCreate);
        }
        if (!semiEquals) {
            System.out.println("Update:\n" + xmlExpectedUpdate);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedUpdate, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = scheduledActivityTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        ScheduledActivityType scheduledActivity = (ScheduledActivityType) response.getDataObject();
        Assert.assertEquals(REF_ID, scheduledActivity.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = scheduledActivityTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        ScheduledActivityCollectionType scheduledActivityCollection = (ScheduledActivityCollectionType) response.getDataObject();
        Assert.assertNotNull(scheduledActivityCollection.getScheduledActivity());
        Assert.assertEquals(5, scheduledActivityCollection.getScheduledActivity().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = scheduledActivityTester.testCreateOne("scheduledactivity.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        ScheduledActivityType scheduledActivity = (ScheduledActivityType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, scheduledActivity.getRefId());

        List<Response> deleteResponses = scheduledActivityTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = scheduledActivityTester.testCreateMany("scheduledactivities.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = scheduledActivityTester.testDeleteMany(REF_IDS);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        BulkOperationResponse<OperationStatus> deleteResponse = deleteResponses.get(0);
        Assert.assertNotNull(deleteResponse.getOperationStatuses());
        Assert.assertEquals(2, deleteResponse.getOperationStatuses().size());
        for (OperationStatus operationStatus : deleteResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getResourceID()));
            Assert.assertEquals(HttpStatus.OK.value(), operationStatus.getStatus());
        }
    }
}
