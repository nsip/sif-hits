package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.NAPTestItem2Type;
import sif.dd.au30.model.NAPTestItemListType;
import sif.dd.au30.model.NAPTestletCollectionType;
import sif.dd.au30.model.NAPTestletContentType;
import sif.dd.au30.model.NAPTestletType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.NAPTestConsumerTest.NAPTestRefIds;
import sif3.hits.rest.consumer.NAPTestItemConsumerTest.NAPTestItemRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPTestletConsumerTest extends BaseTest {
    private ConsumerTest<NAPTestletType, NAPTestletCollectionType> napTestletTester = null;

    private static final String REF_ID_1 = "627cbefe-2b31-4fd1-9284-5aacfcf395b5";
    private static final String REF_ID_2 = "0cc1a042-7888-4300-af5d-10ec80f76a25";

    public static class NAPTestletRefIds {
        public static final String REF_ID_1 = "cfe94174-447d-4494-8e4f-594041680dbc";
        public static final String REF_ID_2 = "6378a20b-3a6d-4663-a83c-e9245f0aba0e";
        public static final String REF_ID_3 = "79f088a3-4fac-4f94-aef1-b73d34e6c2ac";
        public static final String REF_ID_4 = "8e13526a-751c-483c-9992-85bdcccfdb9f";
        public static final String REF_ID_5 = "b2f9d9f8-4e3c-4dc5-9319-c38df2a4cd61";

        public static final String LOCAL_ID_1 = "R-3-1";
        public static final String LOCAL_ID_2 = "R-3-2";
        public static final String LOCAL_ID_3 = "R-3-3";
        public static final String LOCAL_ID_4 = "R-3-4";
        public static final String LOCAL_ID_5 = "R-3-5";
    }

    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    private String doInitialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        NAPTestletType napTestletType = new NAPTestletType();
        napTestletType.setRefId(NAPTestletRefIds.REF_ID_1);
        napTestletType.setNAPTestRefId(objectFactory.createNAPTestletTypeNAPTestRefId(NAPTestRefIds.REF_ID_1));
        napTestletType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_1);

        NAPTestletContentType napTestletContent = new NAPTestletContentType();
        napTestletContent.setTestletName(objectFactory.createNAPTestletContentTypeTestletName("Yr3 Reading Testlet 1"));
        napTestletContent.setNode(objectFactory.createNAPTestletContentTypeNode("A"));
        napTestletContent.setTestletMaximumScore(new BigDecimal("32"));
        napTestletContent.setLocationInStage(objectFactory.createNAPTestletContentTypeLocationInStage(new BigInteger("1")));
        napTestletContent.setNAPTestletLocalId(NAPTestletRefIds.LOCAL_ID_1);
        napTestletType.setTestletContent(napTestletContent);

        NAPTestItemListType napTestItemListType = new NAPTestItemListType();
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemRefIds.REF_ID_1, NAPTestItemRefIds.LOCAL_ID_1, 0));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemRefIds.REF_ID_2, NAPTestItemRefIds.LOCAL_ID_2, 1));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemRefIds.REF_ID_3, NAPTestItemRefIds.LOCAL_ID_3, 2));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemRefIds.REF_ID_4, NAPTestItemRefIds.LOCAL_ID_4, 3));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemRefIds.REF_ID_5, NAPTestItemRefIds.LOCAL_ID_5, 4));
        napTestletType.setTestItemList(napTestItemListType);

        String xmlExpectedTo = napTestletTester.getXML(napTestletType);
        napTestletTester.doCreateOne(napTestletType);
        napTestletTester.doUpdateOne(napTestletType, NAPTestletRefIds.REF_ID_1);

        napTestletType.setRefId(NAPTestletRefIds.REF_ID_2);
        napTestletContent.setTestletName(objectFactory.createNAPTestletContentTypeTestletName("Yr3 Reading Testlet 2"));
        napTestletContent.setNAPTestletLocalId(NAPTestletRefIds.LOCAL_ID_2);
        napTestletTester.doCreateOne(napTestletType);

        napTestletType.setRefId(NAPTestletRefIds.REF_ID_3);
        napTestletContent.setTestletName(objectFactory.createNAPTestletContentTypeTestletName("Yr3 Reading Testlet 3"));
        napTestletContent.setNAPTestletLocalId(NAPTestletRefIds.LOCAL_ID_3);
        napTestletTester.doCreateOne(napTestletType);

        napTestletType.setRefId(NAPTestletRefIds.REF_ID_4);
        napTestletContent.setTestletName(objectFactory.createNAPTestletContentTypeTestletName("Yr3 Reading Testlet 4"));
        napTestletContent.setNAPTestletLocalId(NAPTestletRefIds.LOCAL_ID_4);
        napTestletTester.doCreateOne(napTestletType);

        napTestletType.setRefId(NAPTestletRefIds.REF_ID_5);
        napTestletContent.setTestletName(objectFactory.createNAPTestletContentTypeTestletName("Yr3 Reading Testlet 5"));
        napTestletContent.setNAPTestletLocalId(NAPTestletRefIds.LOCAL_ID_5);
        napTestletTester.doCreateOne(napTestletType);

        return xmlExpectedTo;
    }
    
    @Test
    @Category({ IntegrationTest.class })
    public void initialiseData() throws Exception {
        String xmlExpectedTo = doInitialiseData();

        NAPTestletType getResult = napTestletTester.doGetOne(NAPTestletRefIds.REF_ID_1);
        String xmlExpectedFrom = napTestletTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }
    
    @Test
    @Category({ InitialiseData.class })
    public void initialInitialiseData() throws Exception {
        doInitialiseData();
    }

    private NAPTestItem2Type getTestItem(String refId, String localId, int sequence) {
        NAPTestItem2Type testItem = new NAPTestItem2Type();
        testItem.setSequenceNumber(new BigInteger(Integer.toString(sequence)));
        testItem.setTestItemRefId(refId);
        testItem.setTestItemLocalId(localId);
        return testItem;
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        napTestletTester = new ConsumerTest<NAPTestletType, NAPTestletCollectionType>(NAPTestletType.class, "NAPTestlet", NAPTestletCollectionType.class, "NAPTestlets");
        napTestletTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = napTestletTester.testGetSingle(NAPTestletRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestletType napTestlet = (NAPTestletType) response.getDataObject();
        Assert.assertEquals(NAPTestletRefIds.REF_ID_1, napTestlet.getRefId());

        String xmlExpectedFrom = napTestletTester.getXML(napTestlet);

        List<Response> updateResponses = napTestletTester.doUpdateOne(napTestlet, NAPTestletRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = napTestletTester.testGetSingle(NAPTestletRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        NAPTestletType comparisonTo = (NAPTestletType) getResponse.getDataObject();
        Assert.assertEquals(NAPTestletRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = napTestletTester.getXML(comparisonTo);

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
        List<Response> responses = napTestletTester.testGetSingle(NAPTestletRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestletType napTestlet = (NAPTestletType) response.getDataObject();
        Assert.assertEquals(NAPTestletRefIds.REF_ID_1, napTestlet.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = napTestletTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPTestletCollectionType napTestlets = (NAPTestletCollectionType) response.getDataObject();
        Assert.assertNotNull(napTestlets.getNAPTestlet());
        Assert.assertEquals(5, napTestlets.getNAPTestlet().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = napTestletTester.testCreateOne("naptestlet.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        NAPTestletType napTestlet = (NAPTestletType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, napTestlet.getRefId());

        List<Response> deleteResponses = napTestletTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = napTestletTester.testCreateMany("naptestlets.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = napTestletTester.testDeleteMany(REF_IDS);
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
    
    @Test
    @Category(IntegrationTest.class)
    public void testServicePathNAPTest() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("NAPTests", QueryOperator.EQUAL, NAPTestRefIds.REF_ID_1));

        List<Response> responses = napTestletTester.testServicePath(queryCriteria, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);

        NAPTestletCollectionType napTestletCollectionType = (NAPTestletCollectionType) response.getDataObject();
        Assert.assertNotNull(napTestletCollectionType.getNAPTestlet());
        Assert.assertFalse(napTestletCollectionType.getNAPTestlet().isEmpty());
        boolean found = false;
        for (NAPTestletType napTestlet : napTestletCollectionType.getNAPTestlet()) {
            found = found || NAPTestletRefIds.REF_ID_1.equals(napTestlet.getRefId());
        }
        Assert.assertTrue(found);
    }
}
