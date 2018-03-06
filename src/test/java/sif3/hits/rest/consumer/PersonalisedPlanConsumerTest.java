package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsPersonalisedPlanType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PersonalisedPlanCollectionType;
import sif.dd.au30.model.PersonalisedPlanType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class PersonalisedPlanConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<PersonalisedPlanType, PersonalisedPlanCollectionType> personalisedPlanTester = null;

    public static class PersonalisedPlanRefIds {
        public static String REF_ID_1 = "83d3f9c3-26ac-4d74-97d0-9137f42cf025";
        public static String REF_ID_2 = "9c5f2d92-55f7-47d4-8720-c07047dcca92";
        public static String REF_ID_3 = "ba188294-285f-4b92-89b0-7c6f1dfe6eab";
        public static String REF_ID_4 = "b36559ec-8120-4eea-bfe5-85451bc2e6e2";
        public static String REF_ID_5 = "d5641419-7db9-4bf6-bb73-6967e4970933";
    }

    private final String REF_ID_1 = "b8f042fc-5470-44bc-ab84-ccf2746feed3";
    private final String REF_ID_2 = "6c6ec4e7-855c-4e5c-b5b2-f3c89b7c4ae3";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        
        PersonalisedPlanType personalisedPlanType = objectFactory.createPersonalisedPlanType();
        personalisedPlanType.setRefId(PersonalisedPlanRefIds.REF_ID_1);
        personalisedPlanType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        personalisedPlanType.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        personalisedPlanType.setPersonalisedPlanCategory(AUCodeSetsPersonalisedPlanType.AC);
        personalisedPlanType.setPersonalisedPlanStartDate(getDate("2018-03-01"));
        personalisedPlanType.setPersonalisedPlanEndDate(objectFactory.createPersonalisedPlanTypePersonalisedPlanEndDate(getDate("2018-05-09")));
        personalisedPlanType.setPersonalisedPlanEndDate(objectFactory.createPersonalisedPlanTypePersonalisedPlanReviewDate(getDate("2018-04-03")));
        personalisedPlanType.setPersonalisedPlanNotes(objectFactory.createPersonalisedPlanTypePersonalisedPlanNotes("Notes Notes Notes"));
        personalisedPlanType.setAssociatedAttachment(objectFactory.createPersonalisedPlanTypeAssociatedAttachment("Attachment.doc"));
        
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
        personalisedPlanType.setDocumentList(objectFactory.createPersonalisedPlanTypeDocumentList(wellbeingDocumentListType));

        personalisedPlanTester.doCreateOne(personalisedPlanType);
        String xmlExpectedTo = personalisedPlanTester.getXML(personalisedPlanType);
        
        System.out.println(xmlExpectedTo);

        personalisedPlanType.setRefId(PersonalisedPlanRefIds.REF_ID_2);
        personalisedPlanTester.doCreateOne(personalisedPlanType);
        personalisedPlanType.setRefId(PersonalisedPlanRefIds.REF_ID_3);
        personalisedPlanTester.doCreateOne(personalisedPlanType);
        personalisedPlanType.setRefId(PersonalisedPlanRefIds.REF_ID_4);
        personalisedPlanTester.doCreateOne(personalisedPlanType);
        personalisedPlanType.setRefId(PersonalisedPlanRefIds.REF_ID_5);
        personalisedPlanTester.doCreateOne(personalisedPlanType);

        PersonalisedPlanType getResult = personalisedPlanTester.doGetOne(PersonalisedPlanRefIds.REF_ID_1);
        String xmlExpectedFrom = personalisedPlanTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        personalisedPlanTester = new ConsumerTest<PersonalisedPlanType, PersonalisedPlanCollectionType>(PersonalisedPlanType.class, "PersonalisedPlan",
                PersonalisedPlanCollectionType.class, "PersonalisedPlans");
        personalisedPlanTester.testDeleteMany(REF_IDS);
    }

    @Test
    public void testUpdateSingle() throws Exception {
        List<Response> responses = personalisedPlanTester.testGetSingle(PersonalisedPlanRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        PersonalisedPlanType personalisedPlan = (PersonalisedPlanType) response.getDataObject();
        Assert.assertEquals(PersonalisedPlanRefIds.REF_ID_1, personalisedPlan.getRefId());

        String xmlExpectedFrom = personalisedPlanTester.getXML(personalisedPlan);

        List<Response> updateResponses = personalisedPlanTester.doUpdateOne(personalisedPlan, PersonalisedPlanRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = personalisedPlanTester.testGetSingle(PersonalisedPlanRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        PersonalisedPlanType comparisonTo = (PersonalisedPlanType) getResponse.getDataObject();
        Assert.assertEquals(PersonalisedPlanRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = personalisedPlanTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    public void testGetSingle() {
        List<Response> responses = personalisedPlanTester.testGetSingle(PersonalisedPlanRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        PersonalisedPlanType personalisedPlan = (PersonalisedPlanType) response.getDataObject();
        Assert.assertEquals(PersonalisedPlanRefIds.REF_ID_1, personalisedPlan.getRefId());
    }

    @Test
    public void testGetMany() {
        List<Response> responses = personalisedPlanTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        PersonalisedPlanCollectionType personalisedPlanCollection = (PersonalisedPlanCollectionType) response.getDataObject();
        Assert.assertNotNull(personalisedPlanCollection.getPersonalisedPlan());
        Assert.assertEquals(5, personalisedPlanCollection.getPersonalisedPlan().size());
    }

    @Test
    public void testCreateDelete() {
        List<Response> createResponses = personalisedPlanTester.testCreateOne("personalisedplan.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        PersonalisedPlanType personalisedPlan = (PersonalisedPlanType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, personalisedPlan.getRefId());

        List<Response> deleteResponses = personalisedPlanTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }

    @Test
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = personalisedPlanTester.testCreateMany("personalisedplans.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = personalisedPlanTester.testDeleteMany(REF_IDS);
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
