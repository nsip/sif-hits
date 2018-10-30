package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsNAPTestDomainType;
import sif.dd.au30.model.AUCodeSetsNAPTestTypeType;
import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestContentType;
import sif.dd.au30.model.NAPTestType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.YearLevelType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPTestConsumerTest extends BaseTest {
    private ConsumerTest<NAPTestType, NAPTestCollectionType> napTestTester = null;

    private static final String REF_ID_1 = "8d83dc30-7337-42cc-b427-e7a3ca8db655";
    private static final String REF_ID_2 = "d172a7fc-9c51-480c-b1ef-799808fb4652";

    public static class NAPTestRefIds {
        public static final String REF_ID_1 = "fe555ae0-2abe-474b-8dca-e8f97ec58b9e";
        public static final String REF_ID_2 = "3644e327-50c1-4770-990f-a2d019cd7a1a";
        public static final String REF_ID_3 = "aee98e86-d490-4cf5-9eb6-cc819661df0b";
        public static final String REF_ID_4 = "be0aad0f-c961-474e-9155-47d9c2b45365";
        public static final String REF_ID_5 = "d5ffc673-4077-4b79-bbba-fa00885893a7";

        public static final String LOCAL_ID_1 = "NAPLAN-Reading-Yr3-2015";
        public static final String LOCAL_ID_2 = "NAPLAN-Reading-Yr5-2015";
        public static final String LOCAL_ID_3 = "NAPLAN-Reading-Yr7-2015";
        public static final String LOCAL_ID_4 = "NAPLAN-Reading-Yr9-2015";
        public static final String LOCAL_ID_5 = "NAPLAN-Numeracy-Yr3-2015";
    }

    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        NAPTestType napTestType = new NAPTestType();
        napTestType.setRefId(NAPTestRefIds.REF_ID_1);

        NAPTestContentType napTestContent = new NAPTestContentType();
        napTestContent.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_1);
        napTestContent.setTestName("NAPLAN Reading Yr 3, 2015");
        YearLevelType yearLevel = objectFactory.createYearLevelType();
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("3"));
        napTestContent.setTestLevel(yearLevel);
        napTestContent.setTestType(AUCodeSetsNAPTestTypeType.NORMAL);
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.READING);
        napTestContent.setTestYear(getDate("2015"));
        napTestType.setTestContent(napTestContent);

        String xmlExpectedTo = napTestTester.getXML(napTestType);
        napTestTester.doCreateOne(napTestType);

        napTestType.setRefId(NAPTestRefIds.REF_ID_2);
        napTestContent.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_2);
        napTestContent.setTestName("NAPLAN Reading Yr 5, 2015");
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("5"));
        napTestContent.setTestType(AUCodeSetsNAPTestTypeType.NORMAL);
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.READING);
        napTestContent.setTestYear(getDate("2015"));
        napTestTester.doCreateOne(napTestType);

        napTestType.setRefId(NAPTestRefIds.REF_ID_3);
        napTestContent.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_3);
        napTestContent.setTestName("NAPLAN Reading Yr 7, 2015");
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("7"));
        napTestContent.setTestType(AUCodeSetsNAPTestTypeType.NORMAL);
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.READING);
        napTestContent.setTestYear(getDate("2015"));
        napTestTester.doCreateOne(napTestType);

        napTestType.setRefId(NAPTestRefIds.REF_ID_4);
        napTestContent.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_4);
        napTestContent.setTestName("NAPLAN Reading Yr 9, 2015");
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("9"));
        napTestContent.setTestType(AUCodeSetsNAPTestTypeType.NORMAL);
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.READING);
        napTestContent.setTestYear(getDate("2015"));
        napTestTester.doCreateOne(napTestType);

        napTestType.setRefId(NAPTestRefIds.REF_ID_5);
        napTestContent.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_5);
        napTestContent.setTestName("NAPLAN Numeracy Yr 3, 2015");
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("3"));
        napTestContent.setTestLevel(yearLevel);
        napTestContent.setTestType(AUCodeSetsNAPTestTypeType.NORMAL);
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.NUMERACY);
        napTestContent.setTestYear(getDate("2015"));
        napTestTester.doCreateOne(napTestType);
        napTestTester.doUpdateOne(napTestType, napTestType.getRefId());

        NAPTestType getResult = napTestTester.doGetOne(NAPTestRefIds.REF_ID_1);
        String xmlExpectedFrom = napTestTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        napTestTester = new ConsumerTest<NAPTestType, NAPTestCollectionType>(NAPTestType.class, "NAPTest", NAPTestCollectionType.class, "NAPTests");
        napTestTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        NAPTestType napTest = new NAPTestType();
        NAPTestContentType napTestContent = new NAPTestContentType();
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.NUMERACY);
        napTest.setTestContent(napTestContent);

        List<Response> responses = napTestTester.testQBE(napTest, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        NAPTestCollectionType napTestCollectionType = (NAPTestCollectionType) response.getDataObject();
        Assert.assertNotNull(napTestCollectionType.getNAPTest());
        Assert.assertFalse(napTestCollectionType.getNAPTest().isEmpty());
        boolean found = false;
        for (NAPTestType napTestType : napTestCollectionType.getNAPTest()) {
            found = found || NAPTestRefIds.REF_ID_5.equals(napTestType.getRefId());
            Assert.assertNotNull(napTestType);
            Assert.assertNotNull(napTestType.getTestContent());
            Assert.assertNotNull(napTestType.getTestContent().getDomain());
            Assert.assertEquals(AUCodeSetsNAPTestDomainType.NUMERACY, napTestType.getTestContent().getDomain());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = napTestTester.testGetSingle(NAPTestRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestType napTest = (NAPTestType) response.getDataObject();
        Assert.assertEquals(NAPTestRefIds.REF_ID_1, napTest.getRefId());

        String xmlExpectedFrom = napTestTester.getXML(napTest);

        List<Response> updateResponses = napTestTester.doUpdateOne(napTest, NAPTestRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = napTestTester.testGetSingle(NAPTestRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        NAPTestType comparisonTo = (NAPTestType) getResponse.getDataObject();
        Assert.assertEquals(NAPTestRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = napTestTester.getXML(comparisonTo);

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
        List<Response> responses = napTestTester.testGetSingle(NAPTestRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestType napTest = (NAPTestType) response.getDataObject();
        Assert.assertEquals(NAPTestRefIds.REF_ID_1, napTest.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = napTestTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestCollectionType napTests = (NAPTestCollectionType) response.getDataObject();
        Assert.assertNotNull(napTests.getNAPTest());
        Assert.assertEquals(5, napTests.getNAPTest().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = napTestTester.testCreateOne("naptest.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        NAPTestType napTest = (NAPTestType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, napTest.getRefId());

        List<Response> deleteResponses = napTestTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = napTestTester.testCreateMany("naptests.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = napTestTester.testDeleteMany(REF_IDS);
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
