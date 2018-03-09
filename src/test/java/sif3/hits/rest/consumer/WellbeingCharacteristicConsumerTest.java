package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsWellbeingCharacteristicClassificationType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.MedicationListType;
import sif.dd.au30.model.MedicationType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.WellbeingCharacteristicCollectionType;
import sif.dd.au30.model.WellbeingCharacteristicType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class WellbeingCharacteristicConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType> wellbeingCharacteristicTester = null;

    public static class WellbeingCharacteristicRefIds {
        public static String REF_ID_1 = "30141b4e-e18a-4a29-99f9-78be308ebcc8";
        public static String REF_ID_2 = "a64e57bc-73a7-4fcd-9a57-3e65f8c5d06c";
        public static String REF_ID_3 = "2ebfb6b5-f03d-4c73-86c4-a41ae112e64c";
        public static String REF_ID_4 = "180f2995-69d5-4710-a20d-9501f39489dc";
        public static String REF_ID_5 = "5868d44d-d39c-4614-9e15-e4a3bfea6ffe";
    }

    private final String REF_ID_1 = "d6ceec38-0ae0-4cec-81a7-f13cd7a44491";
    private final String REF_ID_2 = "b15a3efa-39a2-4ed4-b2cc-373be1b79906";

    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        WellbeingCharacteristicType wellbeingCharacteristicType = objectFactory.createWellbeingCharacteristicType();
        wellbeingCharacteristicType.setRefId(WellbeingCharacteristicRefIds.REF_ID_1);
        wellbeingCharacteristicType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        wellbeingCharacteristicType.setSchoolInfoRefId(objectFactory.createWellbeingCharacteristicTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
        wellbeingCharacteristicType.setWellbeingCharacteristicClassification(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicClassification(AUCodeSetsWellbeingCharacteristicClassificationType.D));
        wellbeingCharacteristicType.setWellbeingCharacteristicStartDate(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicStartDate(getDate("2018-03-23")));
        wellbeingCharacteristicType.setWellbeingCharacteristicEndDate(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicEndDate(getDate("2018-04-01")));
        wellbeingCharacteristicType.setWellbeingCharacteristicReviewDate(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicReviewDate(getDate("2018-03-29")));
        wellbeingCharacteristicType.setWellbeingCharacteristicNotes(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicNotes("Notes go Here"));
        wellbeingCharacteristicType.setWellbeingCharacteristicCategory(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicCategory("Cat"));
        wellbeingCharacteristicType.setWellbeingCharacteristicSubCategory(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicSubCategory("SubCat"));
        wellbeingCharacteristicType.setLocalCharacteristicCode(objectFactory.createWellbeingCharacteristicTypeLocalCharacteristicCode("LocalCode"));
        wellbeingCharacteristicType.setCharacteristicSeverity(objectFactory.createWellbeingCharacteristicTypeCharacteristicSeverity("Severe"));
        wellbeingCharacteristicType.setDailyManagement(objectFactory.createWellbeingCharacteristicTypeDailyManagement("Y"));
        wellbeingCharacteristicType.setEmergencyManagement(objectFactory.createWellbeingCharacteristicTypeEmergencyManagement("N"));
        wellbeingCharacteristicType.setEmergencyResponsePlan(objectFactory.createWellbeingCharacteristicTypeEmergencyResponsePlan("ERP"));
        wellbeingCharacteristicType.setTrigger(objectFactory.createWellbeingCharacteristicTypeTrigger("Trigger"));
        wellbeingCharacteristicType.setConfidentialFlag(objectFactory.createWellbeingCharacteristicTypeConfidentialFlag(AUCodeSetsYesOrNoCategoryType.N));
        wellbeingCharacteristicType.setAlert(objectFactory.createWellbeingCharacteristicTypeAlert(AUCodeSetsYesOrNoCategoryType.N));
        
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
        wellbeingCharacteristicType.setDocumentList(objectFactory.createWellbeingCharacteristicTypeDocumentList(wellbeingDocumentListType));
        
        MedicationType medicationType1 = objectFactory.createMedicationType();
        medicationType1.setMedicationName(objectFactory.createMedicationTypeMedicationName("SomeMeds"));
        medicationType1.setDosage(objectFactory.createMedicationTypeDosage("40mg"));
        medicationType1.setFrequency(objectFactory.createMedicationTypeFrequency("Daily"));
        medicationType1.setAdministrationInformation(objectFactory.createMedicationTypeAdministrationInformation("Take some pills"));
        medicationType1.setMethod(objectFactory.createMedicationTypeMethod("Oral"));
        
        MedicationType medicationType2 = objectFactory.createMedicationType();
        medicationType2.setMedicationName(objectFactory.createMedicationTypeMedicationName("DifferentMeds"));
        medicationType2.setDosage(objectFactory.createMedicationTypeDosage("10mg"));
        medicationType2.setFrequency(objectFactory.createMedicationTypeFrequency("Twice Daily"));
        medicationType2.setAdministrationInformation(objectFactory.createMedicationTypeAdministrationInformation("Take some smaller pills"));
        medicationType2.setMethod(objectFactory.createMedicationTypeMethod("Oral"));
        
        MedicationListType medicationListType = objectFactory.createMedicationListType();
        medicationListType.getMedication().add(medicationType1);
        medicationListType.getMedication().add(medicationType2);
        wellbeingCharacteristicType.setMedicationList(objectFactory.createWellbeingCharacteristicTypeMedicationList(medicationListType));

        wellbeingCharacteristicTester.doCreateOne(wellbeingCharacteristicType);
        String xmlExpectedTo1 = wellbeingCharacteristicTester.getXML(wellbeingCharacteristicType);
        System.out.println(xmlExpectedTo1);

        wellbeingCharacteristicType.setRefId(WellbeingCharacteristicRefIds.REF_ID_2);
        wellbeingCharacteristicTester.doCreateOne(wellbeingCharacteristicType);

        wellbeingCharacteristicType.setRefId(WellbeingCharacteristicRefIds.REF_ID_3);
        wellbeingCharacteristicTester.doCreateOne(wellbeingCharacteristicType);

        wellbeingCharacteristicType.setRefId(WellbeingCharacteristicRefIds.REF_ID_4);
        wellbeingCharacteristicTester.doCreateOne(wellbeingCharacteristicType);

        wellbeingCharacteristicType.setRefId(WellbeingCharacteristicRefIds.REF_ID_5);
        wellbeingCharacteristicTester.doCreateOne(wellbeingCharacteristicType);

        verify(WellbeingCharacteristicRefIds.REF_ID_1, xmlExpectedTo1);
    }

    private void verify(String refId, String xmlExpectedTo) throws Exception {
        WellbeingCharacteristicType getResult = wellbeingCharacteristicTester.doGetOne(refId);
        String xmlExpectedFrom = wellbeingCharacteristicTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        wellbeingCharacteristicTester = new ConsumerTest<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType>(WellbeingCharacteristicType.class,
                "WellbeingCharacteristic", WellbeingCharacteristicCollectionType.class, "WellbeingCharacteristics");
        wellbeingCharacteristicTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = wellbeingCharacteristicTester.testGetSingle(WellbeingCharacteristicRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingCharacteristicType wellbeingCharacteristic = (WellbeingCharacteristicType) response.getDataObject();
        Assert.assertEquals(WellbeingCharacteristicRefIds.REF_ID_1, wellbeingCharacteristic.getRefId());

        String xmlExpectedFrom = wellbeingCharacteristicTester.getXML(wellbeingCharacteristic);

        List<Response> updateResponses = wellbeingCharacteristicTester.doUpdateOne(wellbeingCharacteristic, WellbeingCharacteristicRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = wellbeingCharacteristicTester.testGetSingle(WellbeingCharacteristicRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        WellbeingCharacteristicType comparisonTo = (WellbeingCharacteristicType) getResponse.getDataObject();
        Assert.assertEquals(WellbeingCharacteristicRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = wellbeingCharacteristicTester.getXML(comparisonTo);

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
        List<Response> responses = wellbeingCharacteristicTester.testGetSingle(WellbeingCharacteristicRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingCharacteristicType wellbeingCharacteristic = (WellbeingCharacteristicType) response.getDataObject();
        Assert.assertEquals(WellbeingCharacteristicRefIds.REF_ID_1, wellbeingCharacteristic.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = wellbeingCharacteristicTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        WellbeingCharacteristicCollectionType wellbeingCharacteristicCollection = (WellbeingCharacteristicCollectionType) response.getDataObject();
        Assert.assertNotNull(wellbeingCharacteristicCollection.getWellbeingCharacteristic());
        Assert.assertEquals(5, wellbeingCharacteristicCollection.getWellbeingCharacteristic().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = wellbeingCharacteristicTester.testCreateOne("wellbeingcharacteristic.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        WellbeingCharacteristicType wellbeingCharacteristic = (WellbeingCharacteristicType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, wellbeingCharacteristic.getRefId());

        List<Response> deleteResponses = wellbeingCharacteristicTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = wellbeingCharacteristicTester.testCreateMany("wellbeingcharacteristics.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = wellbeingCharacteristicTester.testDeleteMany(REF_IDS);
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
