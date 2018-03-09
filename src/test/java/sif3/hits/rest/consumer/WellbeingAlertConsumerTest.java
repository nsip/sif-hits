package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsWellbeingAlertCategoryType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.WellbeingAlertCollectionType;
import sif.dd.au30.model.WellbeingAlertType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class WellbeingAlertConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<WellbeingAlertType, WellbeingAlertCollectionType> wellbeingAlertTester = null;

    public static class WellbeingAlertRefIds {
        public static String REF_ID_1 = "9272a566-00dc-40ec-adb5-261d0c87daab";
        public static String REF_ID_2 = "22650d5d-0d9f-4745-8b8c-c2c2a7a2fcf5";
        public static String REF_ID_3 = "727d4c26-b676-46b6-befa-98617cd07a9e";
        public static String REF_ID_4 = "fddb95af-656d-4900-bfc7-928112d5c8f8";
        public static String REF_ID_5 = "8c2950da-6835-47bc-a47b-c5717a8bfaa4";
    }

    private final String REF_ID_1 = "faae58a3-5cc7-4867-99f8-b69f1fdb6543";
    private final String REF_ID_2 = "2c9f9e8e-6e30-4be9-a130-733ccec4e56c";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        WellbeingAlertType wellbeingAlertType = objectFactory.createWellbeingAlertType();
        wellbeingAlertType.setRefId(WellbeingAlertRefIds.REF_ID_1);
        wellbeingAlertType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        wellbeingAlertType.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        wellbeingAlertType.setDate(getDate("2018-03-23"));
        wellbeingAlertType.setWellbeingAlertStartDate(getDate("2018-03-24"));
        wellbeingAlertType.setWellbeingAlertEndDate(objectFactory.createWellbeingAlertTypeWellbeingAlertEndDate(getDate("2018-04-22")));
        wellbeingAlertType.setWellbeingAlertCategory(objectFactory.createWellbeingAlertTypeWellbeingAlertCategory(AUCodeSetsWellbeingAlertCategoryType.D));
        wellbeingAlertType.setWellbeingAlertDescription(objectFactory.createWellbeingAlertTypeWellbeingAlertDescription("Danger Danger"));
        wellbeingAlertType.setEnrolmentRestricted(objectFactory.createWellbeingAlertTypeEnrolmentRestricted(AUCodeSetsYesOrNoCategoryType.N));
        wellbeingAlertType.setAlertAudience(objectFactory.createWellbeingAlertTypeAlertAudience("People"));
        wellbeingAlertType.setAlertSeverity(objectFactory.createWellbeingAlertTypeAlertSeverity("Severe"));
        wellbeingAlertType.setAlertKeyContact(objectFactory.createWellbeingAlertTypeAlertKeyContact("James Smith"));

        wellbeingAlertTester.doCreateOne(wellbeingAlertType);
        String xmlExpectedTo1 = wellbeingAlertTester.getXML(wellbeingAlertType);
        System.out.println(xmlExpectedTo1);

        wellbeingAlertType.setRefId(WellbeingAlertRefIds.REF_ID_2);
        wellbeingAlertTester.doCreateOne(wellbeingAlertType);

        wellbeingAlertType.setRefId(WellbeingAlertRefIds.REF_ID_3);
        wellbeingAlertTester.doCreateOne(wellbeingAlertType);

        wellbeingAlertType.setRefId(WellbeingAlertRefIds.REF_ID_4);
        wellbeingAlertTester.doCreateOne(wellbeingAlertType);

        wellbeingAlertType.setRefId(WellbeingAlertRefIds.REF_ID_5);
        wellbeingAlertTester.doCreateOne(wellbeingAlertType);

        verify(WellbeingAlertRefIds.REF_ID_1, xmlExpectedTo1);
    }

    private void verify(String refId, String xmlExpectedTo) throws Exception {
        WellbeingAlertType getResult = wellbeingAlertTester.doGetOne(refId);
        String xmlExpectedFrom = wellbeingAlertTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        wellbeingAlertTester = new ConsumerTest<WellbeingAlertType, WellbeingAlertCollectionType>(WellbeingAlertType.class, "WellbeingAlert", WellbeingAlertCollectionType.class,
                "WellbeingAlerts");
        wellbeingAlertTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = wellbeingAlertTester.testGetSingle(WellbeingAlertRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingAlertType wellbeingAlert = (WellbeingAlertType) response.getDataObject();
        Assert.assertEquals(WellbeingAlertRefIds.REF_ID_1, wellbeingAlert.getRefId());

        String xmlExpectedFrom = wellbeingAlertTester.getXML(wellbeingAlert);

        List<Response> updateResponses = wellbeingAlertTester.doUpdateOne(wellbeingAlert, WellbeingAlertRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = wellbeingAlertTester.testGetSingle(WellbeingAlertRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        WellbeingAlertType comparisonTo = (WellbeingAlertType) getResponse.getDataObject();
        Assert.assertEquals(WellbeingAlertRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = wellbeingAlertTester.getXML(comparisonTo);

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
        List<Response> responses = wellbeingAlertTester.testGetSingle(WellbeingAlertRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingAlertType wellbeingAlert = (WellbeingAlertType) response.getDataObject();
        Assert.assertEquals(WellbeingAlertRefIds.REF_ID_1, wellbeingAlert.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = wellbeingAlertTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingAlertCollectionType wellbeingAlertCollection = (WellbeingAlertCollectionType) response.getDataObject();
        Assert.assertNotNull(wellbeingAlertCollection.getWellbeingAlert());
        Assert.assertEquals(5, wellbeingAlertCollection.getWellbeingAlert().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = wellbeingAlertTester.testCreateOne("wellbeingalert.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        WellbeingAlertType wellbeingAlert = (WellbeingAlertType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, wellbeingAlert.getRefId());

        List<Response> deleteResponses = wellbeingAlertTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = wellbeingAlertTester.testCreateMany("wellbeingalerts.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = wellbeingAlertTester.testDeleteMany(REF_IDS);
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
