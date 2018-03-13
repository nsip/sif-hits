package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsDetentionCategoryType;
import sif.dd.au30.model.AUCodeSetsSuspensionCategoryType;
import sif.dd.au30.model.AUCodeSetsWellbeingResponseCategoryType;
import sif.dd.au30.model.AUCodeSetsWellbeingStatusType;
import sif.dd.au30.model.AwardContainerType;
import sif.dd.au30.model.DetentionContainerType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.OtherWellbeingResponseContainerType;
import sif.dd.au30.model.PersonInvolvementListType;
import sif.dd.au30.model.PersonInvolvementType;
import sif.dd.au30.model.PersonInvolvementType.PersonRefId;
import sif.dd.au30.model.PlanRequiredContainerType;
import sif.dd.au30.model.PlanRequiredListType;
import sif.dd.au30.model.SuspensionContainerType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif.dd.au30.model.WellbeingPlanType;
import sif.dd.au30.model.WellbeingResponseCollectionType;
import sif.dd.au30.model.WellbeingResponseType;
import sif.dd.au30.model.WithdrawalTimeListType;
import sif.dd.au30.model.WithdrawalType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.PersonalisedPlanConsumerTest.PersonalisedPlanRefIds;
import sif3.hits.rest.consumer.StaffPersonalConsumerTest.StaffPersonalRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class WellbeingResponseConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<WellbeingResponseType, WellbeingResponseCollectionType> wellbeingResponseTester = null;

    public static class WellbeingResponseRefIds {
        public static String REF_ID_1 = "f64ce01b-23ed-4213-bdc8-b27108664461";
        public static String REF_ID_2 = "ed39b12c-4c8d-4cd0-861a-99a246def2e8";
        public static String REF_ID_3 = "1123d234-e5ba-462a-9c53-497958dce118";
        public static String REF_ID_4 = "ba88a06d-7fdb-44d0-82be-8a06ce5c7031";
        public static String REF_ID_5 = "e67f5dc0-9199-4134-b87e-7ef3cfd8bb7b";
        public static String REF_ID_6 = "a76aaca8-e6e5-4b31-9574-93779478494a";
    }

    private final String REF_ID_1 = "026c6b32-2dcd-4f52-b802-a8f42c57e7f1";
    private final String REF_ID_2 = "190d6d28-5be9-44ac-9c99-5f556b0e0221";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        WellbeingResponseType wellbeingResponseType = objectFactory.createWellbeingResponseType();
        wellbeingResponseType.setRefId(WellbeingResponseRefIds.REF_ID_1);
        wellbeingResponseType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        wellbeingResponseType.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        wellbeingResponseType.setDate(getDate("2018-03-06"));
        wellbeingResponseType.setWellbeingResponseStartDate(getDate("2018-03-01"));
        wellbeingResponseType.setWellbeingResponseEndDate(objectFactory.createWellbeingResponseTypeWellbeingResponseEndDate(getDate("2018-05-09")));
        wellbeingResponseType.setWellbeingResponseNotes(objectFactory.createWellbeingResponseTypeWellbeingResponseNotes("Notes Notes Notes"));
        
        WellbeingDocumentType wellbeingDocument1 = objectFactory.createWellbeingDocumentType();
        wellbeingDocument1.setLocation("\\\\secure-share\\plan-documents\\st1234568\\plan.doc");
        wellbeingDocument1.setSensitivity(objectFactory.createWellbeingDocumentTypeSensitivity("SENSITIVE"));
        wellbeingDocument1.setURL(objectFactory.createWellbeingDocumentTypeURL("http://secure-document-server.edu/plan-documents/st12345678/plan.doc"));
        wellbeingDocument1.setDocumentType(objectFactory.createWellbeingDocumentTypeDocumentType("Plan"));
        wellbeingDocument1.setDocumentReviewDate(objectFactory.createWellbeingDocumentTypeDocumentReviewDate(getDate("2018-04-03")));
        wellbeingDocument1.setDocumentDescription(objectFactory.createWellbeingDocumentTypeDocumentDescription("Plan document for student 12345678."));

        WellbeingDocumentType wellbeingDocument2 = objectFactory.createWellbeingDocumentType();
        wellbeingDocument2.setLocation("\\\\secure-share\\plan-documents\\st1234568\\plan2.doc");
        wellbeingDocument2.setSensitivity(objectFactory.createWellbeingDocumentTypeSensitivity("SENSITIVE"));
        wellbeingDocument2.setURL(objectFactory.createWellbeingDocumentTypeURL("http://secure-document-server.edu/plan-documents/st12345678/plan2.doc"));
        wellbeingDocument2.setDocumentType(objectFactory.createWellbeingDocumentTypeDocumentType("Plan"));
        wellbeingDocument2.setDocumentReviewDate(objectFactory.createWellbeingDocumentTypeDocumentReviewDate(getDate("2018-04-05")));
        wellbeingDocument2.setDocumentDescription(objectFactory.createWellbeingDocumentTypeDocumentDescription("Plan 2 document for student 12345678."));

        WellbeingDocumentListType wellbeingDocumentListType = objectFactory.createWellbeingDocumentListType();
        wellbeingDocumentListType.getDocument().add(wellbeingDocument1);
        wellbeingDocumentListType.getDocument().add(wellbeingDocument2);
        wellbeingResponseType.setDocumentList(objectFactory.createWellbeingResponseTypeDocumentList(wellbeingDocumentListType));
        
        PersonInvolvementType personInvolvement1 = objectFactory.createPersonInvolvementType();
        personInvolvement1.setHowInvolved(objectFactory.createPersonInvolvementTypeHowInvolved("Instigator"));
        personInvolvement1.setShortName(objectFactory.createPersonInvolvementTypeShortName("John Smith Student"));
        PersonRefId personRefId1 = new PersonRefId();
        personRefId1.setValue(StudentPersonalRefIds.REF_ID_2);
        personRefId1.setSIFRefObject("StudentPersonal");
        personInvolvement1.setPersonRefId(objectFactory.createPersonInvolvementTypePersonRefId(personRefId1));

        PersonInvolvementType personInvolvement2 = objectFactory.createPersonInvolvementType();
        personInvolvement2.setHowInvolved(objectFactory.createPersonInvolvementTypeHowInvolved("Teacher"));
        personInvolvement2.setShortName(objectFactory.createPersonInvolvementTypeShortName("John Smith Teacher"));
        PersonRefId personRefId2 = new PersonRefId();
        personRefId2.setValue(StaffPersonalRefIds.REF_ID_2);
        personRefId2.setSIFRefObject("StaffPersonal");
        personInvolvement2.setPersonRefId(objectFactory.createPersonInvolvementTypePersonRefId(personRefId2));
        
        PersonInvolvementListType personInvolvementListType = objectFactory.createPersonInvolvementListType();
        personInvolvementListType.getPersonInvolvement().add(personInvolvement1);
        personInvolvementListType.getPersonInvolvement().add(personInvolvement2);
        wellbeingResponseType.setPersonInvolvementList(objectFactory.createWellbeingResponseTypePersonInvolvementList(personInvolvementListType));
        
        wellbeingResponseTester.doCreateOne(wellbeingResponseType);
        String xmlExpectedTo1 = wellbeingResponseTester.getXML(wellbeingResponseType);
        System.out.println(xmlExpectedTo1);

        wellbeingResponseType.setRefId(WellbeingResponseRefIds.REF_ID_2);
        wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.S));
        SuspensionContainerType suspensionType = objectFactory.createSuspensionContainerType();
        suspensionType.setSuspensionCategory(AUCodeSetsSuspensionCategoryType.S);
        suspensionType.setDuration(objectFactory.createSuspensionContainerTypeDuration(BigDecimal.ONE));
        suspensionType.setAdvisementDate(objectFactory.createSuspensionContainerTypeAdvisementDate(getDate("2018-03-06")));
        suspensionType.setResolutionMeetingTime(objectFactory.createSuspensionContainerTypeResolutionMeetingTime(getCalendar("2018-03-10T09:00:00Z")));
        suspensionType.setResolutionNotes(objectFactory.createSuspensionContainerTypeResolutionNotes("Suspended"));
        suspensionType.setEarlyReturnDate(objectFactory.createSuspensionContainerTypeEarlyReturnDate(getDate("2018-03-11")));
        suspensionType.setStatus(objectFactory.createSuspensionContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
        
        WithdrawalType withdrawalType1 = objectFactory.createWithdrawalType();
        withdrawalType1.setScheduledActivityRefId(objectFactory.createWithdrawalTypeScheduledActivityRefId(ScheduledActivityConsumerTest.REF_ID));
        withdrawalType1.setTimeTableCellRefId(objectFactory.createWithdrawalTypeTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID));
        withdrawalType1.setTimeTableSubjectRefId(objectFactory.createWithdrawalTypeTimeTableSubjectRefId(TimeTableSubjectConsumerTest.REF_ID));
        withdrawalType1.setWithdrawalDate(getDate("2018-03-09"));
        withdrawalType1.setWithdrawalStartTime(objectFactory.createWithdrawalTypeWithdrawalStartTime(getDate("09:00:00")));
        withdrawalType1.setWithdrawalEndTime(objectFactory.createWithdrawalTypeWithdrawalEndTime(getDate("15:30:00")));
        WithdrawalTimeListType withdrawalList = objectFactory.createWithdrawalTimeListType();
        withdrawalList.getWithdrawal().add(withdrawalType1);
        suspensionType.setWithdrawalTimeList(objectFactory.createSuspensionContainerTypeWithdrawalTimeList(withdrawalList));
        wellbeingResponseType.setSuspension(objectFactory.createWellbeingResponseTypeSuspension(suspensionType));
        wellbeingResponseTester.doCreateOne(wellbeingResponseType);
        String xmlExpectedTo2 = wellbeingResponseTester.getXML(wellbeingResponseType);
        
        wellbeingResponseType.setRefId(WellbeingResponseRefIds.REF_ID_3);
        wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.D));
        wellbeingResponseType.setSuspension(null);
        
        DetentionContainerType detentionType = objectFactory.createDetentionContainerType();
        detentionType.setDetentionCategory(AUCodeSetsDetentionCategoryType.A);
        detentionType.setDetentionDate(objectFactory.createDetentionContainerTypeDetentionDate(getDate("2018-03-01")));
        detentionType.setDetentionLocation(objectFactory.createDetentionContainerTypeDetentionLocation("The Naughty Corner"));
        detentionType.setDetentionNotes(objectFactory.createDetentionContainerTypeDetentionNotes("Some Detention Notes"));
        detentionType.setStatus(objectFactory.createDetentionContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
        wellbeingResponseType.setDetention(objectFactory.createWellbeingResponseTypeDetention(detentionType));
        wellbeingResponseTester.doCreateOne(wellbeingResponseType);
        String xmlExpectedTo3 = wellbeingResponseTester.getXML(wellbeingResponseType);
        
        wellbeingResponseType.setRefId(WellbeingResponseRefIds.REF_ID_4);
        wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.P));
        wellbeingResponseType.setDetention(null);
        
        PlanRequiredContainerType planRequiredType = objectFactory.createPlanRequiredContainerType();
        WellbeingPlanType wellbeingPlanType1 = objectFactory.createWellbeingPlanType();
        wellbeingPlanType1.setPersonalisedPlanRefId(objectFactory.createWellbeingPlanTypePersonalisedPlanRefId(PersonalisedPlanRefIds.REF_ID_1));
        wellbeingPlanType1.setPlanNotes(objectFactory.createWellbeingPlanTypePlanNotes("Personalised Plan Notes"));

        WellbeingPlanType wellbeingPlanType2 = objectFactory.createWellbeingPlanType();
        wellbeingPlanType1.setPersonalisedPlanRefId(objectFactory.createWellbeingPlanTypePersonalisedPlanRefId(PersonalisedPlanRefIds.REF_ID_2));
        wellbeingPlanType1.setPlanNotes(objectFactory.createWellbeingPlanTypePlanNotes("Personalised Plan Notes"));
        
        planRequiredType.setStatus(objectFactory.createPlanRequiredContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
        PlanRequiredListType planRequiredList = objectFactory.createPlanRequiredListType();
        planRequiredList.getPlan().add(wellbeingPlanType1);
        planRequiredList.getPlan().add(wellbeingPlanType2);
        wellbeingResponseType.setPlanRequired(objectFactory.createWellbeingResponseTypePlanRequired(planRequiredType));
        
        wellbeingResponseTester.doCreateOne(wellbeingResponseType);
        String xmlExpectedTo4 = wellbeingResponseTester.getXML(wellbeingResponseType);
        
        wellbeingResponseType.setRefId(WellbeingResponseRefIds.REF_ID_5);
        wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.A));
        wellbeingResponseType.setPlanRequired(null);
        
        AwardContainerType awardType = objectFactory.createAwardContainerType();
        awardType.setAwardDate(objectFactory.createAwardContainerTypeAwardDate(getDate("2018-04-02")));
        awardType.setAwardType(objectFactory.createAwardContainerTypeAwardType("Book Prize"));
        awardType.setAwardDescription(objectFactory.createAwardContainerTypeAwardDescription("Super duper best student in the world award"));
        awardType.setAwardNotes(objectFactory.createAwardContainerTypeAwardNotes("Student is definitely the best student"));
        awardType.setStatus(objectFactory.createAwardContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
        wellbeingResponseType.setAward(objectFactory.createWellbeingResponseTypeAward(awardType));
        
        wellbeingResponseTester.doCreateOne(wellbeingResponseType);
        String xmlExpectedTo5 = wellbeingResponseTester.getXML(wellbeingResponseType);
        
        wellbeingResponseType.setRefId(WellbeingResponseRefIds.REF_ID_6);
        wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.O));
        wellbeingResponseType.setAward(null);
        
        OtherWellbeingResponseContainerType otherType = objectFactory.createOtherWellbeingResponseContainerType();
        otherType.setOtherResponseDate(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseDate(getDate("2018-03-11")));
        otherType.setOtherResponseType(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseType("Other Response"));
        otherType.setOtherResponseDescription(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseDescription("Response Description"));
        otherType.setOtherResponseNotes(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseNotes("Response Notes"));
        otherType.setStatus(objectFactory.createOtherWellbeingResponseContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
        wellbeingResponseType.setOtherResponse(objectFactory.createWellbeingResponseTypeOtherResponse(otherType));
        
        wellbeingResponseTester.doCreateOne(wellbeingResponseType);
        String xmlExpectedTo6 = wellbeingResponseTester.getXML(wellbeingResponseType);

        verify(WellbeingResponseRefIds.REF_ID_1, xmlExpectedTo1);
        verify(WellbeingResponseRefIds.REF_ID_2, xmlExpectedTo2);
        verify(WellbeingResponseRefIds.REF_ID_3, xmlExpectedTo3);
        verify(WellbeingResponseRefIds.REF_ID_4, xmlExpectedTo4);
        verify(WellbeingResponseRefIds.REF_ID_5, xmlExpectedTo5);
        verify(WellbeingResponseRefIds.REF_ID_6, xmlExpectedTo6);
    }
    
    private void verify(String refId, String xmlExpectedTo) throws Exception {
        WellbeingResponseType getResult = wellbeingResponseTester.doGetOne(refId);
        String xmlExpectedFrom = wellbeingResponseTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        } 
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        wellbeingResponseTester = new ConsumerTest<WellbeingResponseType, WellbeingResponseCollectionType>(WellbeingResponseType.class, "WellbeingResponse",
                WellbeingResponseCollectionType.class, "WellbeingResponses");
        wellbeingResponseTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = wellbeingResponseTester.testGetSingle(WellbeingResponseRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingResponseType wellbeingResponse = (WellbeingResponseType) response.getDataObject();
        Assert.assertEquals(WellbeingResponseRefIds.REF_ID_1, wellbeingResponse.getRefId());

        String xmlExpectedFrom = wellbeingResponseTester.getXML(wellbeingResponse);

        List<Response> updateResponses = wellbeingResponseTester.doUpdateOne(wellbeingResponse, WellbeingResponseRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = wellbeingResponseTester.testGetSingle(WellbeingResponseRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        WellbeingResponseType comparisonTo = (WellbeingResponseType) getResponse.getDataObject();
        Assert.assertEquals(WellbeingResponseRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = wellbeingResponseTester.getXML(comparisonTo);

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
        List<Response> responses = wellbeingResponseTester.testGetSingle(WellbeingResponseRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingResponseType wellbeingResponse = (WellbeingResponseType) response.getDataObject();
        Assert.assertEquals(WellbeingResponseRefIds.REF_ID_1, wellbeingResponse.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = wellbeingResponseTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingResponseCollectionType wellbeingResponseCollection = (WellbeingResponseCollectionType) response.getDataObject();
        Assert.assertNotNull(wellbeingResponseCollection.getWellbeingResponse());
        Assert.assertEquals(5, wellbeingResponseCollection.getWellbeingResponse().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = wellbeingResponseTester.testCreateOne("wellbeingresponse.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        WellbeingResponseType wellbeingResponse = (WellbeingResponseType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, wellbeingResponse.getRefId());

        List<Response> deleteResponses = wellbeingResponseTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = wellbeingResponseTester.testCreateMany("wellbeingresponses.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = wellbeingResponseTester.testDeleteMany(REF_IDS);
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
