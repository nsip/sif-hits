package sif3.hits.rest.consumer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;
import sif.dd.au30.model.*;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

import javax.xml.datatype.DatatypeConfigurationException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StudentSchoolEnrollmentConsumerTest extends BaseTest {
    private ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> studentSchoolEnrollmentTester = null;

    private final String REF_ID_1 = "eccdbcbf-9681-4791-a825-3cdbf8cd138f";
    private final String REF_ID_2 = "dccec317-2371-465e-854a-e1af585da93a";
    private final String[] REF_IDS = {REF_ID_1, REF_ID_2};
    private static ObjectFactory objectFactory = new ObjectFactory();

    public static class StudentSchoolEnrollmentRefIds {
        public static String REF_ID_1 = "cb638e09-8bcf-4792-ac53-2dc05e221418";
        public static String REF_ID_2 = "8450bf11-cebb-41d3-8e1a-97614a880dad";
        public static String REF_ID_3 = "b1fea68c-a917-40fb-b616-1e7a3f369238";
        public static String REF_ID_4 = "34edd6bd-4d22-4fea-bfe3-018cfe842013";
        public static String REF_ID_5 = "fd0b13d1-b126-41a3-b7c7-895ac39ec312";
    }

    public static class StudentSchoolEnrollmentTestData {
        public static String YEAR_LEVEL = "6";
        public static String SCHOOL_YEAR = "2018";
    }

    private void populateTestObject(StudentSchoolEnrollmentType target) {
        target.setMembershipType(AUCodeSetsSchoolEnrollmentTypeType.fromValue("01"));
        target.setLocalId(objectFactory.createStudentSchoolEnrollmentTypeLocalId("a-new-local-id"));
        target.setTimeFrame(AUCodeSetsEnrollmentTimeFrameType.fromValue("H"));
        target.setSchoolYear(getDate(StudentSchoolEnrollmentTestData.SCHOOL_YEAR));
        target.setEntryDate(getDate("2018-01-01"));
        target.setHomegroup(objectFactory.createStudentSchoolEnrollmentTypeHomegroup("home-group"));
        target.setACARASchoolId(objectFactory.createStudentSchoolEnrollmentTypeACARASchoolId(SchoolInfoConsumerTest.ACARA_ID));
        target.setClassCode(objectFactory.createStudentSchoolEnrollmentTypeClassCode("class-code"));
        target.setReportingSchool(objectFactory.createStudentSchoolEnrollmentTypeReportingSchool(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
        target.setHouse(objectFactory.createStudentSchoolEnrollmentTypeHouse("the-house"));
        target.setIndividualLearningPlan(objectFactory.createStudentSchoolEnrollmentTypeIndividualLearningPlan(AUCodeSetsYesOrNoCategoryType.fromValue("N")));
        target.setExitDate(objectFactory.createStudentSchoolEnrollmentTypeExitDate(getDate("2018-12-31")));
        target.setFTE(objectFactory.createStudentSchoolEnrollmentTypeFTE(new BigDecimal("1.0")));
        target.setFTPTStatus(objectFactory.createStudentSchoolEnrollmentTypeFTPTStatus(AUCodeSetsFTPTStatusCodeType.fromValue("01")));
        target.setFFPOS(objectFactory.createStudentSchoolEnrollmentTypeFFPOS(AUCodeSetsFFPOSStatusCodeType.fromValue("2")));
        target.setRecordClosureReason(objectFactory.createStudentSchoolEnrollmentTypeRecordClosureReason("end-of-year"));
        target.setPreviousSchool(objectFactory.createStudentSchoolEnrollmentTypePreviousSchool("77b444bb-fe0a-48bb-971b-f510a4e76e48"));
        target.setPreviousSchoolName(objectFactory.createStudentSchoolEnrollmentTypePreviousSchoolName("Previous Primary School"));
        target.setDestinationSchool(objectFactory.createStudentSchoolEnrollmentTypeDestinationSchool("570eeaef-41a7-4686-bec4-0a87b080e2c4"));
        target.setDestinationSchoolName(objectFactory.createStudentSchoolEnrollmentTypeDestinationSchoolName("Destination High School"));
        target.setStartedAtSchoolDate(objectFactory.createStudentSchoolEnrollmentTypeStartedAtSchoolDate(getDate("2014-02-15")));

        StudentEntryContainerType entryTypeContainer = objectFactory.createStudentEntryContainerType();
        entryTypeContainer.setCode(AUCodeSetsEntryTypeType.fromValue("1821"));
        target.setEntryType(objectFactory.createStudentSchoolEnrollmentTypeEntryType(entryTypeContainer));

        YearLevelType yearLevelType = objectFactory.createYearLevelType();
        yearLevelType.setCode(AUCodeSetsYearLevelCodeType.fromValue(StudentSchoolEnrollmentTestData.YEAR_LEVEL));
        target.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yearLevelType));

        StudentSchoolEnrollmentType.Homeroom homeroom = objectFactory.createStudentSchoolEnrollmentTypeHomeroom();
        homeroom.setSIFRefObject("RoomInfo");
        homeroom.setValue(RoomInfoConsumerTest.REF_ID);
        target.setHomeroom(objectFactory.createStudentSchoolEnrollmentTypeHomeroom(homeroom));

        StudentSchoolEnrollmentType.Advisor advisor = objectFactory.createStudentSchoolEnrollmentTypeAdvisor();
        advisor.setSIFRefObject("StaffPersonal");
        advisor.setValue(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1);
        target.setAdvisor(objectFactory.createStudentSchoolEnrollmentTypeAdvisor(advisor));

        StudentSchoolEnrollmentType.Counselor counselor = objectFactory.createStudentSchoolEnrollmentTypeCounselor();
        counselor.setSIFRefObject("StaffPersonal");
        counselor.setValue(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_4);
        target.setCounselor(objectFactory.createStudentSchoolEnrollmentTypeCounselor(counselor));

        YearLevelType testLevelType = objectFactory.createYearLevelType();
        testLevelType.setCode(AUCodeSetsYearLevelCodeType.fromValue("6"));
        target.setTestLevel(objectFactory.createStudentSchoolEnrollmentTypeTestLevel(testLevelType));

        StudentSchoolEnrollmentType.Calendar calendar = objectFactory.createStudentSchoolEnrollmentTypeCalendar();
        calendar.setSIFRefObject("CalendarSummary");
        calendar.setValue(CalendarSummaryConsumerTest.REF_ID);
        target.setCalendar(objectFactory.createStudentSchoolEnrollmentTypeCalendar(calendar));

        StudentExitStatusContainerType exitStatusContainer = objectFactory.createStudentExitStatusContainerType();
        exitStatusContainer.setCode(AUCodeSetsExitWithdrawalStatusType.fromValue("1905"));
        target.setExitStatus(objectFactory.createStudentSchoolEnrollmentTypeExitStatus(exitStatusContainer));


        StudentExitContainerType exitTypeContainer = objectFactory.createStudentExitContainerType();
        exitTypeContainer.setCode(AUCodeSetsExitWithdrawalTypeType.fromValue("1907"));
        target.setExitType(objectFactory.createStudentSchoolEnrollmentTypeExitType(exitTypeContainer));

        CatchmentStatusContainerType catchmentStatusContainer = objectFactory.createCatchmentStatusContainerType();
        catchmentStatusContainer.setCode(AUCodeSetsPublicSchoolCatchmentStatusType.fromValue("1652"));
        target.setCatchmentStatus(objectFactory.createStudentSchoolEnrollmentTypeCatchmentStatus(catchmentStatusContainer));

        PromotionInfoType promotionInfo = objectFactory.createPromotionInfoType();
        promotionInfo.setPromotionStatus(objectFactory.createPromotionInfoTypePromotionStatus("promotion-status"));
        target.setPromotionInfo(objectFactory.createStudentSchoolEnrollmentTypePromotionInfo(promotionInfo));

        StudentSubjectChoiceListType studentSubjectChoiceListType = objectFactory.createStudentSubjectChoiceListType();
        for (int i = 0; i < 5; i++) {
            StudentSubjectChoiceType studentSubjectChoiceType = objectFactory.createStudentSubjectChoiceType();
            studentSubjectChoiceType.setSubjectLocalId("subject-local-id-" + i);
            studentSubjectChoiceType.setOtherSchoolLocalId(objectFactory.createStudentSubjectChoiceTypeOtherSchoolLocalId("other-school-id-" + i));
            studentSubjectChoiceType.setPreferenceNumber(objectFactory.createStudentSubjectChoiceTypePreferenceNumber(Long.parseLong("" + (i + 1), 10)));
            SubjectAreaType subjectAreaType = objectFactory.createSubjectAreaType();
            subjectAreaType.setCode("study-description-" + i);
            studentSubjectChoiceType.setStudyDescription(objectFactory.createStudentSubjectChoiceTypeStudyDescription(subjectAreaType));
            studentSubjectChoiceListType.getStudentSubjectChoice().add(studentSubjectChoiceType);
        }
        target.setStudentSubjectChoiceList(objectFactory.createStudentSchoolEnrollmentTypeStudentSubjectChoiceList(studentSubjectChoiceListType));

        StudentGroupListType studentGroupListType = objectFactory.createStudentGroupListType();
        for (int i = 0; i < 5; i++) {
            StudentGroupType studentGroup = objectFactory.createStudentGroupType();
            studentGroup.setGroupLocalId("group-local-id-" + i);
            studentGroup.setGroupCategory(AUCodeSetsGroupCategoryCodeType.fromValue("OtherGroup"));
            studentGroup.setGroupDescription(objectFactory.createStudentGroupTypeGroupDescription("group-description-" + i));
            studentGroupListType.getStudentGroup().add(studentGroup);
        }
        target.setStudentGroupList(objectFactory.createStudentSchoolEnrollmentTypeStudentGroupList(studentGroupListType));

        PublishingPermissionListType publishingPermissionListType = objectFactory.createPublishingPermissionListType();
        for (int i = 0; i < 5; i++) {
            PublishingPermissionType publishingPermission = objectFactory.createPublishingPermissionType();
            publishingPermission.setPermissionValue(AUCodeSetsYesOrNoCategoryType.fromValue("Y"));
            publishingPermission.setPermissionCategory(AUCodeSetsPermissionCategoryCodeType.fromValue("OKPublishInfo"));
            publishingPermissionListType.getPublishingPermission().add(publishingPermission);
        }
        target.setPublishingPermissionList(objectFactory.createStudentSchoolEnrollmentTypePublishingPermissionList(publishingPermissionListType));
    }

    @Test
    @Category({IntegrationTest.class, InitialiseData.class})
    public void initialiseData() throws Exception {

        StudentSchoolEnrollmentType studentEnrollment = new StudentSchoolEnrollmentType();
        studentEnrollment.setRefId(StudentSchoolEnrollmentRefIds.REF_ID_1);
        studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        studentEnrollment.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        populateTestObject(studentEnrollment);

        String xmlExpectedTo = studentSchoolEnrollmentTester.getXML(studentEnrollment);
        studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);
        studentSchoolEnrollmentTester.doUpdateOne(studentEnrollment, studentEnrollment.getRefId());

        studentEnrollment.setRefId(StudentSchoolEnrollmentRefIds.REF_ID_2);
        studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
        studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);
        studentSchoolEnrollmentTester.doUpdateOne(studentEnrollment, studentEnrollment.getRefId());

        studentEnrollment.setRefId(StudentSchoolEnrollmentRefIds.REF_ID_3);
        studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
        studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);
        studentSchoolEnrollmentTester.doUpdateOne(studentEnrollment, studentEnrollment.getRefId());

        studentEnrollment.setRefId(StudentSchoolEnrollmentRefIds.REF_ID_4);
        studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
        studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);
        studentSchoolEnrollmentTester.doUpdateOne(studentEnrollment, studentEnrollment.getRefId());

        studentEnrollment.setRefId(StudentSchoolEnrollmentRefIds.REF_ID_5);
        studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5);
        studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);
        studentSchoolEnrollmentTester.doUpdateOne(studentEnrollment, studentEnrollment.getRefId());

        StudentSchoolEnrollmentType getResult = studentSchoolEnrollmentTester.doGetOne(StudentSchoolEnrollmentRefIds.REF_ID_1);

        String xmlExpectedFrom = studentSchoolEnrollmentTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        studentSchoolEnrollmentTester = new ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType>(StudentSchoolEnrollmentType.class,
                "StudentSchoolEnrollment", StudentSchoolEnrollmentCollectionType.class, "StudentSchoolEnrollments");
        studentSchoolEnrollmentTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = studentSchoolEnrollmentTester.testGetSingle(StudentSchoolEnrollmentRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) response.getDataObject();
        Assert.assertEquals(StudentSchoolEnrollmentRefIds.REF_ID_1, studentSchoolEnrollment.getRefId());

        String xmlExpectedFrom = studentSchoolEnrollmentTester.getXML(studentSchoolEnrollment);

        List<Response> updateResponses = studentSchoolEnrollmentTester.doUpdateOne(studentSchoolEnrollment, StudentSchoolEnrollmentRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = studentSchoolEnrollmentTester.testGetSingle(StudentSchoolEnrollmentRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        StudentSchoolEnrollmentType comparisonTo = (StudentSchoolEnrollmentType) getResponse.getDataObject();
        Assert.assertEquals(StudentSchoolEnrollmentRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = studentSchoolEnrollmentTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = studentSchoolEnrollmentTester.testGetSingle(StudentSchoolEnrollmentRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) response.getDataObject();
        Assert.assertEquals(StudentSchoolEnrollmentRefIds.REF_ID_1, studentSchoolEnrollment.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        StudentSchoolEnrollmentType studentEnrollment = new StudentSchoolEnrollmentType();
        studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        List<Response> responses = studentSchoolEnrollmentTester.testQBE(studentEnrollment, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        StudentSchoolEnrollmentCollectionType studentSchoolEnrollmentCollectionType = (StudentSchoolEnrollmentCollectionType) response.getDataObject();
        Assert.assertNotNull(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment());
        Assert.assertFalse(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment().isEmpty());
        boolean found = false;
        for (StudentSchoolEnrollmentType studentSchoolEnrollmentType : studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment()) {
            found = found || StudentSchoolEnrollmentRefIds.REF_ID_1.equals(studentSchoolEnrollmentType.getRefId());
            Assert.assertEquals(StudentPersonalRefIds.REF_ID_1, studentSchoolEnrollmentType.getStudentPersonalRefId());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBEYearLevel() throws DatatypeConfigurationException {
        ObjectFactory objectFactory = new ObjectFactory();
        StudentSchoolEnrollmentType studentEnrollment = new StudentSchoolEnrollmentType();
        studentEnrollment.setSchoolYear(getDate(StudentSchoolEnrollmentTestData.SCHOOL_YEAR));
        YearLevelType yly = new YearLevelType();
        yly.setCode(AUCodeSetsYearLevelCodeType.fromValue(StudentSchoolEnrollmentTestData.YEAR_LEVEL));
        studentEnrollment.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yly));
        List<Response> responses = studentSchoolEnrollmentTester.testQBE(studentEnrollment, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        StudentSchoolEnrollmentCollectionType studentSchoolEnrollmentCollectionType = (StudentSchoolEnrollmentCollectionType) response.getDataObject();
        Assert.assertNotNull(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment());
        Assert.assertFalse(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment().isEmpty());
        boolean found = false;
        for (StudentSchoolEnrollmentType studentSchoolEnrollmentType : studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment()) {
            found = found || StudentSchoolEnrollmentRefIds.REF_ID_1.equals(studentSchoolEnrollmentType.getRefId());
            Assert.assertEquals(StudentSchoolEnrollmentTestData.SCHOOL_YEAR, studentSchoolEnrollmentType.getSchoolYear().getYear() + "");
            Assert.assertEquals(StudentSchoolEnrollmentTestData.YEAR_LEVEL, studentSchoolEnrollmentType.getYearLevel().getValue().getCode().value());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = studentSchoolEnrollmentTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StudentSchoolEnrollmentCollectionType studentSchoolEnrollmentCollectionType = (StudentSchoolEnrollmentCollectionType) response.getDataObject();
        Assert.assertNotNull(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment());
        Assert.assertEquals(5, studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = studentSchoolEnrollmentTester.testCreateOne("studentschoolenrollment.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, studentSchoolEnrollment.getRefId());

        List<Response> deleteResponses = studentSchoolEnrollmentTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentSchoolEnrollmentTester.testCreateMany("studentschoolenrollments.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = studentSchoolEnrollmentTester.testDeleteMany(REF_IDS);
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
