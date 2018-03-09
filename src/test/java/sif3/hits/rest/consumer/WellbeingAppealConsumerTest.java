package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsWellbeingAppealStatusType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.WellbeingAppealCollectionType;
import sif.dd.au30.model.WellbeingAppealType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.WellbeingResponseConsumerTest.WellbeingResponseRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class WellbeingAppealConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<WellbeingAppealType, WellbeingAppealCollectionType> wellbeingAppealTester = null;

    public static class WellbeingAppealRefIds {
        public static String REF_ID_1 = "48775598-7bd7-49bf-9f94-c719c67987a9";
        public static String REF_ID_2 = "b62afa3b-cad4-4e65-9c5a-79b2833487d9";
        public static String REF_ID_3 = "9db2f5f5-bc73-414b-a87f-c5ab59d6731d";
        public static String REF_ID_4 = "2235d387-fa0a-440e-bbcb-33b0ee55825a";
        public static String REF_ID_5 = "082fa421-e8e8-428b-8cb5-0caa54e3a033";
    }

    private final String REF_ID_1 = "0773313d-a42f-4c62-be38-e0aaaa2aa389";
    private final String REF_ID_2 = "c77ae64b-e539-454c-83aa-9af2bf4faa4d";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        WellbeingAppealType wellbeingAppealType = objectFactory.createWellbeingAppealType();
        wellbeingAppealType.setRefId(WellbeingAppealRefIds.REF_ID_1);
        wellbeingAppealType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        wellbeingAppealType.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        wellbeingAppealType.setWellbeingResponseRefId(WellbeingResponseRefIds.REF_ID_1);
        wellbeingAppealType.setLocalAppealId(objectFactory.createWellbeingAppealTypeLocalAppealId("AP-0324411"));
        wellbeingAppealType.setAppealStatusCode(objectFactory.createWellbeingAppealTypeAppealStatusCode(AUCodeSetsWellbeingAppealStatusType.N));
        wellbeingAppealType.setDate(objectFactory.createWellbeingAppealTypeDate(getDate("2018-02-22")));
        wellbeingAppealType.setAppealNotes(objectFactory.createWellbeingAppealTypeAppealNotes("Notes Not Notes"));
        wellbeingAppealType.setAppealOutcome(objectFactory.createWellbeingAppealTypeAppealOutcome("What Happened?"));

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
        wellbeingAppealType.setDocumentList(objectFactory.createWellbeingAppealTypeDocumentList(wellbeingDocumentListType));

        wellbeingAppealTester.doCreateOne(wellbeingAppealType);
        String xmlExpectedTo1 = wellbeingAppealTester.getXML(wellbeingAppealType);
        System.out.println(xmlExpectedTo1);

        wellbeingAppealType.setRefId(WellbeingAppealRefIds.REF_ID_2);
        wellbeingAppealTester.doCreateOne(wellbeingAppealType);

        wellbeingAppealType.setRefId(WellbeingAppealRefIds.REF_ID_3);
        wellbeingAppealTester.doCreateOne(wellbeingAppealType);

        wellbeingAppealType.setRefId(WellbeingAppealRefIds.REF_ID_4);
        wellbeingAppealTester.doCreateOne(wellbeingAppealType);

        wellbeingAppealType.setRefId(WellbeingAppealRefIds.REF_ID_5);
        wellbeingAppealTester.doCreateOne(wellbeingAppealType);

        verify(WellbeingAppealRefIds.REF_ID_1, xmlExpectedTo1);
    }

    private void verify(String refId, String xmlExpectedTo) throws Exception {
        WellbeingAppealType getResult = wellbeingAppealTester.doGetOne(refId);
        String xmlExpectedFrom = wellbeingAppealTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        wellbeingAppealTester = new ConsumerTest<WellbeingAppealType, WellbeingAppealCollectionType>(WellbeingAppealType.class, "WellbeingAppeal",
                WellbeingAppealCollectionType.class, "WellbeingAppeals");
        wellbeingAppealTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = wellbeingAppealTester.testGetSingle(WellbeingAppealRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingAppealType wellbeingAppeal = (WellbeingAppealType) response.getDataObject();
        Assert.assertEquals(WellbeingAppealRefIds.REF_ID_1, wellbeingAppeal.getRefId());

        String xmlExpectedFrom = wellbeingAppealTester.getXML(wellbeingAppeal);

        List<Response> updateResponses = wellbeingAppealTester.doUpdateOne(wellbeingAppeal, WellbeingAppealRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = wellbeingAppealTester.testGetSingle(WellbeingAppealRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        WellbeingAppealType comparisonTo = (WellbeingAppealType) getResponse.getDataObject();
        Assert.assertEquals(WellbeingAppealRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = wellbeingAppealTester.getXML(comparisonTo);

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
        List<Response> responses = wellbeingAppealTester.testGetSingle(WellbeingAppealRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingAppealType wellbeingAppeal = (WellbeingAppealType) response.getDataObject();
        Assert.assertEquals(WellbeingAppealRefIds.REF_ID_1, wellbeingAppeal.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = wellbeingAppealTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingAppealCollectionType wellbeingAppealCollection = (WellbeingAppealCollectionType) response.getDataObject();
        Assert.assertNotNull(wellbeingAppealCollection.getWellbeingAppeal());
        Assert.assertEquals(5, wellbeingAppealCollection.getWellbeingAppeal().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = wellbeingAppealTester.testCreateOne("wellbeingappeal.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        WellbeingAppealType wellbeingAppeal = (WellbeingAppealType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, wellbeingAppeal.getRefId());

        List<Response> deleteResponses = wellbeingAppealTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = wellbeingAppealTester.testCreateMany("wellbeingappeals.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = wellbeingAppealTester.testDeleteMany(REF_IDS);
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
