package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsWellbeingEventCategoryClassType;
import sif.dd.au30.model.AUCodeSetsWellbeingEventLocationType;
import sif.dd.au30.model.AUCodeSetsWellbeingEventTimePeriodType;
import sif.dd.au30.model.AUCodeSetsWellbeingStatusType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.FollowUpActionListType;
import sif.dd.au30.model.FollowUpActionType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PersonInvolvementListType;
import sif.dd.au30.model.PersonInvolvementType;
import sif.dd.au30.model.PersonInvolvementType.PersonRefId;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif.dd.au30.model.WellbeingEventCategoryListType;
import sif.dd.au30.model.WellbeingEventCategoryType;
import sif.dd.au30.model.WellbeingEventCollectionType;
import sif.dd.au30.model.WellbeingEventLocationDetailsType;
import sif.dd.au30.model.WellbeingEventSubCategoryListType;
import sif.dd.au30.model.WellbeingEventType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StaffPersonalConsumerTest.StaffPersonalRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.WellbeingResponseConsumerTest.WellbeingResponseRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class WellbeingEventConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<WellbeingEventType, WellbeingEventCollectionType> wellbeingEventTester = null;

    public static class WellbeingEventRefIds {
        public static String REF_ID_1 = "f005198c-c707-4c5e-bb70-5234450f046c";
        public static String REF_ID_2 = "f5238eac-642a-45a4-931a-6049b3889c4f";
        public static String REF_ID_3 = "722bd213-e7ec-4255-98db-3d114c92e8c6";
        public static String REF_ID_4 = "68391976-88f6-4afd-b65b-a875dec96751";
        public static String REF_ID_5 = "6d0b3f2b-2143-4564-b324-4812ec537d6c";
    }

    private final String REF_ID_1 = "26e9f032-1468-4d71-ae54-b5ca2a8be90b";
    private final String REF_ID_2 = "9467a3a3-bb87-4ee6-ba4e-8c22adb60109";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        WellbeingEventType wellbeingEventType = objectFactory.createWellbeingEventType();
        wellbeingEventType.setRefId(WellbeingEventRefIds.REF_ID_1);
        wellbeingEventType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        wellbeingEventType.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        wellbeingEventType.setEventId(objectFactory.createWellbeingEventTypeEventId("Event Id"));
        wellbeingEventType.setWellbeingEventNotes(objectFactory.createWellbeingEventTypeWellbeingEventNotes("Notes Notes Notes"));
        wellbeingEventType.setWellbeingEventCategoryClass(AUCodeSetsWellbeingEventCategoryClassType.N);
        wellbeingEventType.setReportingStaffRefId(objectFactory.createWellbeingEventTypeReportingStaffRefId(StaffPersonalRefIds.REF_ID_4));
        wellbeingEventType.setWellbeingEventCreationTimeStamp(objectFactory.createWellbeingEventTypeWellbeingEventCreationTimeStamp(getCalendar("2018-03-09T10:00:00")));
        wellbeingEventType.setWellbeingEventDate(getDate("2018-02-23"));
        wellbeingEventType.setWellbeingEventTime(objectFactory.createWellbeingEventTypeWellbeingEventTime(getDate("09:00:00")));
        wellbeingEventType.setWellbeingEventDescription(objectFactory.createWellbeingEventTypeWellbeingEventDescription("Event Description"));
        wellbeingEventType.setWellbeingEventTimePeriod(AUCodeSetsWellbeingEventTimePeriodType.B);

        WellbeingEventLocationDetailsType locationDetailsType = objectFactory.createWellbeingEventLocationDetailsType();
        locationDetailsType.setEventLocation(AUCodeSetsWellbeingEventLocationType.C);
        locationDetailsType.setClazz(objectFactory.createWellbeingEventLocationDetailsTypeClass("PPR01"));
        locationDetailsType.setFurtherLocationNotes(objectFactory.createWellbeingEventLocationDetailsTypeFurtherLocationNotes("Notes"));
        wellbeingEventType.setWellbeingEventLocationDetails(objectFactory.createWellbeingEventTypeWellbeingEventLocationDetails(locationDetailsType));
        wellbeingEventType.setConfidentialFlag(objectFactory.createWellbeingEventTypeConfidentialFlag(AUCodeSetsYesOrNoCategoryType.N));
        wellbeingEventType.setStatus(objectFactory.createWellbeingEventTypeStatus(AUCodeSetsWellbeingStatusType.R));

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
        wellbeingEventType.setDocumentList(objectFactory.createWellbeingEventTypeDocumentList(wellbeingDocumentListType));

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
        wellbeingEventType.setPersonInvolvementList(objectFactory.createWellbeingEventTypePersonInvolvementList(personInvolvementListType));

        FollowUpActionType followUpAction1 = objectFactory.createFollowUpActionType();
        followUpAction1.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails("The Deets"));
        followUpAction1.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory("Category 1"));
        followUpAction1.setWellbeingResponseRefId(objectFactory.createFollowUpActionTypeWellbeingResponseRefId(WellbeingResponseRefIds.REF_ID_1));

        FollowUpActionType followUpAction2 = objectFactory.createFollowUpActionType();
        followUpAction2.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails("The Deets 2"));
        followUpAction2.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory("Category 2"));
        followUpAction2.setWellbeingResponseRefId(objectFactory.createFollowUpActionTypeWellbeingResponseRefId(WellbeingResponseRefIds.REF_ID_2));

        FollowUpActionListType followUpActionListType = objectFactory.createFollowUpActionListType();
        followUpActionListType.getFollowUpAction().add(followUpAction1);
        followUpActionListType.getFollowUpAction().add(followUpAction2);
        wellbeingEventType.setFollowUpActionList(objectFactory.createWellbeingEventTypeFollowUpActionList(followUpActionListType));

        WellbeingEventCategoryType category1 = objectFactory.createWellbeingEventCategoryType();
        category1.setEventCategory("M8");
        WellbeingEventSubCategoryListType subcategory1 = objectFactory.createWellbeingEventSubCategoryListType();
        subcategory1.getWellbeingEventSubCategory().add("M8a");
        category1.setWellbeingEventSubCategoryList(objectFactory.createWellbeingEventCategoryTypeWellbeingEventSubCategoryList(subcategory1));

        WellbeingEventCategoryType category2 = objectFactory.createWellbeingEventCategoryType();
        category2.setEventCategory("M8");

        WellbeingEventCategoryType category3 = objectFactory.createWellbeingEventCategoryType();
        category3.setEventCategory("M7");
        WellbeingEventSubCategoryListType subcategory3 = objectFactory.createWellbeingEventSubCategoryListType();
        subcategory3.getWellbeingEventSubCategory().add("M7a");
        subcategory3.getWellbeingEventSubCategory().add("M7b");
        category3.setWellbeingEventSubCategoryList(objectFactory.createWellbeingEventCategoryTypeWellbeingEventSubCategoryList(subcategory3));

        WellbeingEventCategoryListType wellbeingEventCategoryListType = objectFactory.createWellbeingEventCategoryListType();
        wellbeingEventCategoryListType.getWellbeingEventCategory().add(category1);
        wellbeingEventCategoryListType.getWellbeingEventCategory().add(category2);
        wellbeingEventCategoryListType.getWellbeingEventCategory().add(category3);
        wellbeingEventType.setWellbeingEventCategoryList(objectFactory.createWellbeingEventTypeWellbeingEventCategoryList(wellbeingEventCategoryListType));

        wellbeingEventTester.doCreateOne(wellbeingEventType);
        String xmlExpectedTo1 = wellbeingEventTester.getXML(wellbeingEventType);
        System.out.println(xmlExpectedTo1);

        wellbeingEventType.setRefId(WellbeingEventRefIds.REF_ID_2);
        wellbeingEventTester.doCreateOne(wellbeingEventType);

        wellbeingEventType.setRefId(WellbeingEventRefIds.REF_ID_3);
        wellbeingEventTester.doCreateOne(wellbeingEventType);

        wellbeingEventType.setRefId(WellbeingEventRefIds.REF_ID_4);
        wellbeingEventTester.doCreateOne(wellbeingEventType);

        wellbeingEventType.setRefId(WellbeingEventRefIds.REF_ID_5);
        wellbeingEventTester.doCreateOne(wellbeingEventType);

        verify(WellbeingEventRefIds.REF_ID_1, xmlExpectedTo1);
    }

    private void verify(String refId, String xmlExpectedTo) throws Exception {
        WellbeingEventType getResult = wellbeingEventTester.doGetOne(refId);
        String xmlExpectedFrom = wellbeingEventTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        wellbeingEventTester = new ConsumerTest<WellbeingEventType, WellbeingEventCollectionType>(WellbeingEventType.class, "WellbeingEvent", WellbeingEventCollectionType.class,
                "WellbeingEvents");
        wellbeingEventTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = wellbeingEventTester.testGetSingle(WellbeingEventRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingEventType wellbeingEvent = (WellbeingEventType) response.getDataObject();
        Assert.assertEquals(WellbeingEventRefIds.REF_ID_1, wellbeingEvent.getRefId());

        String xmlExpectedFrom = wellbeingEventTester.getXML(wellbeingEvent);

        List<Response> updateResponses = wellbeingEventTester.doUpdateOne(wellbeingEvent, WellbeingEventRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = wellbeingEventTester.testGetSingle(WellbeingEventRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        WellbeingEventType comparisonTo = (WellbeingEventType) getResponse.getDataObject();
        Assert.assertEquals(WellbeingEventRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = wellbeingEventTester.getXML(comparisonTo);

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
        List<Response> responses = wellbeingEventTester.testGetSingle(WellbeingEventRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingEventType wellbeingEvent = (WellbeingEventType) response.getDataObject();
        Assert.assertEquals(WellbeingEventRefIds.REF_ID_1, wellbeingEvent.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = wellbeingEventTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingEventCollectionType wellbeingEventCollection = (WellbeingEventCollectionType) response.getDataObject();
        Assert.assertNotNull(wellbeingEventCollection.getWellbeingEvent());
        Assert.assertEquals(5, wellbeingEventCollection.getWellbeingEvent().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = wellbeingEventTester.testCreateOne("wellbeingevent.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        WellbeingEventType wellbeingEvent = (WellbeingEventType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, wellbeingEvent.getRefId());

        List<Response> deleteResponses = wellbeingEventTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = wellbeingEventTester.testCreateMany("wellbeingevents.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = wellbeingEventTester.testDeleteMany(REF_IDS);
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
