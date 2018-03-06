package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.NAPTestConsumerTest.NAPTestRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPTestScoreSummaryConsumerTest extends BaseTest {
    private ConsumerTest<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> napTestScoreSummaryTester = null;

    private static final String REF_ID_1 = "0e99d081-a9ab-46e3-a5d5-a4864d35c3ca";
    private static final String REF_ID_2 = "82c077f0-8294-4586-b7ac-93774ff1fcc2";

    public static class NAPTestScoreSummaryRefIds {
        public static final String REF_ID_1 = "f3e4094d-5e13-4eb4-be17-26595aca243b";
        public static final String REF_ID_2 = "6ae472a8-f914-4937-8293-4b29b3c30b48";
        public static final String REF_ID_3 = "95fbc11c-64bf-4cdc-bc07-ad7bdd83eb75";
        public static final String REF_ID_4 = "930d5553-81ca-499f-aac2-91d63479b341";
        public static final String REF_ID_5 = "6f47d4bd-e40c-475b-a8d2-ea00d1407036";
    }

    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        NAPTestScoreSummaryType napTestScoreSummaryType = new NAPTestScoreSummaryType();
        napTestScoreSummaryType.setRefId(NAPTestScoreSummaryRefIds.REF_ID_1);
        napTestScoreSummaryType.setSchoolInfoRefId(objectFactory.createNAPTestScoreSummaryTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
        napTestScoreSummaryType.setSchoolACARAId(SchoolInfoConsumerTest.ACARA_ID);
        napTestScoreSummaryType.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(NAPTestRefIds.REF_ID_1));
        napTestScoreSummaryType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_1);
        napTestScoreSummaryType.setDomainNationalAverage(objectFactory.createNAPTestScoreSummaryTypeDomainNationalAverage(new BigDecimal("60.4")));
        napTestScoreSummaryType.setDomainSchoolAverage(objectFactory.createNAPTestScoreSummaryTypeDomainSchoolAverage(new BigDecimal("55.6")));
        napTestScoreSummaryType.setDomainJurisdictionAverage(objectFactory.createNAPTestScoreSummaryTypeDomainJurisdictionAverage(new BigDecimal("57.6")));
        napTestScoreSummaryType.setDomainTopNational60Percent(objectFactory.createNAPTestScoreSummaryTypeDomainTopNational60Percent(new BigDecimal("75.2")));
        napTestScoreSummaryType.setDomainBottomNational60Percent(objectFactory.createNAPTestScoreSummaryTypeDomainBottomNational60Percent(new BigDecimal("65.3")));

        String xmlExpectedTo = napTestScoreSummaryTester.getXML(napTestScoreSummaryType);
        napTestScoreSummaryTester.doCreateOne(napTestScoreSummaryType);

        napTestScoreSummaryType.setRefId(NAPTestScoreSummaryRefIds.REF_ID_2);
        napTestScoreSummaryType.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(NAPTestRefIds.REF_ID_2));
        napTestScoreSummaryType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_2);
        napTestScoreSummaryTester.doCreateOne(napTestScoreSummaryType);

        napTestScoreSummaryType.setRefId(NAPTestScoreSummaryRefIds.REF_ID_3);
        napTestScoreSummaryType.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(NAPTestRefIds.REF_ID_3));
        napTestScoreSummaryType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_3);
        napTestScoreSummaryTester.doCreateOne(napTestScoreSummaryType);

        napTestScoreSummaryType.setRefId(NAPTestScoreSummaryRefIds.REF_ID_4);
        napTestScoreSummaryType.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(NAPTestRefIds.REF_ID_4));
        napTestScoreSummaryType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_4);
        napTestScoreSummaryTester.doCreateOne(napTestScoreSummaryType);

        napTestScoreSummaryType.setRefId(NAPTestScoreSummaryRefIds.REF_ID_5);
        napTestScoreSummaryType.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(NAPTestRefIds.REF_ID_5));
        napTestScoreSummaryType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_5);
        napTestScoreSummaryTester.doCreateOne(napTestScoreSummaryType);

        NAPTestScoreSummaryType getResult = napTestScoreSummaryTester.doGetOne(NAPTestScoreSummaryRefIds.REF_ID_1);
        String xmlExpectedFrom = napTestScoreSummaryTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        napTestScoreSummaryTester = new ConsumerTest<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType>(NAPTestScoreSummaryType.class, "NAPTestScoreSummary",
                NAPTestScoreSummaryCollectionType.class, "NAPTestScoreSummarys");
        napTestScoreSummaryTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = napTestScoreSummaryTester.testGetSingle(NAPTestScoreSummaryRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestScoreSummaryType napEventStudentLinkType = (NAPTestScoreSummaryType) response.getDataObject();
        Assert.assertEquals(NAPTestScoreSummaryRefIds.REF_ID_1, napEventStudentLinkType.getRefId());

        String xmlExpectedFrom = napTestScoreSummaryTester.getXML(napEventStudentLinkType);

        List<Response> updateResponses = napTestScoreSummaryTester.doUpdateOne(napEventStudentLinkType, NAPTestScoreSummaryRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = napTestScoreSummaryTester.testGetSingle(NAPTestScoreSummaryRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        NAPTestScoreSummaryType comparisonTo = (NAPTestScoreSummaryType) getResponse.getDataObject();
        Assert.assertEquals(NAPTestScoreSummaryRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = napTestScoreSummaryTester.getXML(comparisonTo);

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
        List<Response> responses = napTestScoreSummaryTester.testGetSingle(NAPTestScoreSummaryRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestScoreSummaryType napTest = (NAPTestScoreSummaryType) response.getDataObject();
        Assert.assertEquals(NAPTestScoreSummaryRefIds.REF_ID_1, napTest.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = napTestScoreSummaryTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestScoreSummaryCollectionType napEventStudentLinks = (NAPTestScoreSummaryCollectionType) response.getDataObject();
        Assert.assertNotNull(napEventStudentLinks.getNAPTestScoreSummary());
        Assert.assertEquals(5, napEventStudentLinks.getNAPTestScoreSummary().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = napTestScoreSummaryTester.testCreateOne("naptestscoresummary.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        NAPTestScoreSummaryType napTest = (NAPTestScoreSummaryType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, napTest.getRefId());

        List<Response> deleteResponses = napTestScoreSummaryTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = napTestScoreSummaryTester.testCreateMany("naptestscoresummarys.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = napTestScoreSummaryTester.testDeleteMany(REF_IDS);
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
