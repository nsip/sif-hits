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

import sif.dd.au30.model.AUCodeSetsNAPResponseCorrectnessType;
import sif.dd.au30.model.DomainScoreType;
import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif.dd.au30.model.NAPStudentResponseTestletListType;
import sif.dd.au30.model.NAPSubscoreListType;
import sif.dd.au30.model.NAPSubscoreType;
import sif.dd.au30.model.NAPTestletItemResponseListType;
import sif.dd.au30.model.NAPTestletResponseItemType;
import sif.dd.au30.model.NAPTestletResponseType;
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
import sif3.hits.rest.consumer.NAPTestletConsumerTest.NAPTestletRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPStudentResponseSetConsumerTest extends BaseTest {
    private ConsumerTest<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> napStudentResponseSetTester = null;

    private static final String REF_ID_1 = "7d1b71e1-831d-4e3a-8a1d-ede0c999fff7";
    private static final String REF_ID_2 = "1531b15a-cf30-4b61-bb07-69a6bc709479";

    public static class NAPStudentResponseSetRefIds {
        public static final String REF_ID_1 = "ba7ca1ac-790a-41b9-be53-03febee138a2";
        public static final String REF_ID_2 = "7f12fd42-1013-4d3a-a500-e66f06d10d15";
        public static final String REF_ID_3 = "8660f68e-f338-40a7-975e-713c16916066";
        public static final String REF_ID_4 = "34498115-9961-4c03-80ed-755c53e71cbd";
        public static final String REF_ID_5 = "767621f7-e54d-49e2-8a58-e329b855eb9a";
    }

    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        NAPStudentResponseSetType napStudentResponseSetType = new NAPStudentResponseSetType();
        napStudentResponseSetType.setRefId(NAPStudentResponseSetRefIds.REF_ID_1);
        napStudentResponseSetType.setCalibrationSampleFlag(objectFactory.createNAPStudentResponseSetTypeCalibrationSampleFlag("false"));
        napStudentResponseSetType.setEquatingSampleFlag(objectFactory.createNAPStudentResponseSetTypeEquatingSampleFlag("false"));
        napStudentResponseSetType.setNAPTestRefId(objectFactory.createNAPStudentResponseSetTypeNAPTestRefId(NAPTestRefIds.REF_ID_1));
        napStudentResponseSetType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_1);
        napStudentResponseSetType.setPathTakenForDomain(objectFactory.createNAPStudentResponseSetTypePathTakenForDomain("A9-B0-C1-D1-E8-F6"));
        napStudentResponseSetType.setPlatformStudentIdentifier(StudentPersonalRefIds.PSI_ID_1);
        napStudentResponseSetType.setStudentPersonalRefId(objectFactory.createNAPStudentResponseSetTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1));
        napStudentResponseSetType.setReportExclusionFlag(false);
        napStudentResponseSetType.setDomainScore(objectFactory.createNAPStudentResponseSetTypeDomainScore(getDomainScore()));

        NAPStudentResponseTestletListType napTestletListType = new NAPStudentResponseTestletListType();
        napTestletListType.getTestlet().add(getTestlet(NAPTestletRefIds.REF_ID_1, NAPTestletRefIds.LOCAL_ID_1));
        napStudentResponseSetType.setTestletList(objectFactory.createNAPStudentResponseSetTypeTestletList(napTestletListType));

        String xmlExpectedTo = napStudentResponseSetTester.getXML(napStudentResponseSetType);
        napStudentResponseSetTester.doCreateOne(napStudentResponseSetType);
        napStudentResponseSetTester.doUpdateOne(napStudentResponseSetType, napStudentResponseSetType.getRefId());

        napStudentResponseSetType.setRefId(NAPStudentResponseSetRefIds.REF_ID_2);
        napStudentResponseSetTester.doCreateOne(napStudentResponseSetType);

        napStudentResponseSetType.setRefId(NAPStudentResponseSetRefIds.REF_ID_3);
        napStudentResponseSetTester.doCreateOne(napStudentResponseSetType);

        napStudentResponseSetType.setRefId(NAPStudentResponseSetRefIds.REF_ID_4);
        napStudentResponseSetTester.doCreateOne(napStudentResponseSetType);

        napStudentResponseSetType.setRefId(NAPStudentResponseSetRefIds.REF_ID_5);
        napStudentResponseSetTester.doCreateOne(napStudentResponseSetType);

        NAPStudentResponseSetType getResult = napStudentResponseSetTester.doGetOne(NAPStudentResponseSetRefIds.REF_ID_1);
        String xmlExpectedFrom = napStudentResponseSetTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    private NAPTestletResponseType getTestlet(String refId, String localId) {
        ObjectFactory objectFactory = new ObjectFactory();
        NAPTestletResponseType napTestletCommonType = new NAPTestletResponseType();
        napTestletCommonType.setNAPTestletLocalId(localId);
        napTestletCommonType.setNAPTestletRefId(objectFactory.createNAPTestletResponseTypeNAPTestletRefId(refId));
        napTestletCommonType.setTestletSubScore(objectFactory.createNAPTestletResponseTypeTestletSubScore(new BigDecimal("6")));

        NAPTestletItemResponseListType napTestletItemListType = new NAPTestletItemResponseListType();
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemRefIds.REF_ID_1, NAPTestItemRefIds.LOCAL_ID_1, 1));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemRefIds.REF_ID_2, NAPTestItemRefIds.LOCAL_ID_2, 2));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemRefIds.REF_ID_3, NAPTestItemRefIds.LOCAL_ID_3, 3));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemRefIds.REF_ID_4, NAPTestItemRefIds.LOCAL_ID_4, 4));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemRefIds.REF_ID_5, NAPTestItemRefIds.LOCAL_ID_5, 5));
        napTestletCommonType.setItemResponseList(napTestletItemListType);

        return napTestletCommonType;
    }

    private NAPTestletResponseItemType getNAPTestletItem(String refId, String localId, int index) {
        ObjectFactory objectFactory = new ObjectFactory();
        NAPTestletResponseItemType napTestletItemType = new NAPTestletResponseItemType();
        napTestletItemType.setItemWeight(new BigDecimal("1" + index));
        napTestletItemType.setNAPTestItemLocalId(localId);
        napTestletItemType.setNAPTestItemRefId(objectFactory.createNAPTestletResponseItemTypeNAPTestItemRefId(refId));
        napTestletItemType.setResponse(objectFactory.createNAPTestletResponseItemTypeResponse("ezSwZRTsWP" + index));
        napTestletItemType.setResponseCorrectness(AUCodeSetsNAPResponseCorrectnessType.CORRECT);
        napTestletItemType.setScore(objectFactory.createNAPTestletResponseItemTypeScore(new BigDecimal("20")));
        napTestletItemType.setSequenceNumber(new BigInteger("" + index));

        NAPSubscoreListType napSubscoreListType = new NAPSubscoreListType();
        napSubscoreListType.getSubscore().add(getSubscore(index, 1));
        napSubscoreListType.getSubscore().add(getSubscore(index, 2));
        napTestletItemType.setSubscoreList(objectFactory.createNAPTestletResponseItemTypeSubscoreList(napSubscoreListType));

        return napTestletItemType;
    }

    private NAPSubscoreType getSubscore(int index, int i) {
        NAPSubscoreType napSubscoreType = new NAPSubscoreType();
        napSubscoreType.setSubscoreType("PD");
        napSubscoreType.setSubscoreValue(new BigDecimal("1" + index + "" + i));
        return napSubscoreType;
    }

    private DomainScoreType getDomainScore() {
        ObjectFactory objectFactory = new ObjectFactory();
        DomainScoreType domainScoreType = new DomainScoreType();
        domainScoreType.setRawScore(new BigDecimal("3.91"));
        domainScoreType.setScaledScoreValue(new BigDecimal("48.27"));
        domainScoreType.setScaledScoreStandardError(new BigDecimal("7.95"));
        domainScoreType.setStudentDomainBand(new BigInteger("8"));
        domainScoreType.setStudentProficiency(objectFactory.createDomainScoreTypeStudentProficiency("Proficient"));
        return domainScoreType;
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        napStudentResponseSetTester = new ConsumerTest<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType>(NAPStudentResponseSetType.class, "NAPStudentResponseSet",
                NAPStudentResponseSetCollectionType.class, "NAPStudentResponseSets");
        napStudentResponseSetTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = napStudentResponseSetTester.testGetSingle(NAPStudentResponseSetRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPStudentResponseSetType napStudentResponseSet = (NAPStudentResponseSetType) response.getDataObject();
        Assert.assertEquals(NAPStudentResponseSetRefIds.REF_ID_1, napStudentResponseSet.getRefId());

        String xmlExpectedFrom = napStudentResponseSetTester.getXML(napStudentResponseSet);

        List<Response> updateResponses = napStudentResponseSetTester.doUpdateOne(napStudentResponseSet, NAPStudentResponseSetRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = napStudentResponseSetTester.testGetSingle(NAPStudentResponseSetRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        NAPStudentResponseSetType comparisonTo = (NAPStudentResponseSetType) getResponse.getDataObject();
        Assert.assertEquals(NAPStudentResponseSetRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = napStudentResponseSetTester.getXML(comparisonTo);

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
        List<Response> responses = napStudentResponseSetTester.testGetSingle(NAPStudentResponseSetRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPStudentResponseSetType napStudentResponseSet = (NAPStudentResponseSetType) response.getDataObject();
        Assert.assertEquals(NAPStudentResponseSetRefIds.REF_ID_1, napStudentResponseSet.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = napStudentResponseSetTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPStudentResponseSetCollectionType napStudentResponseSets = (NAPStudentResponseSetCollectionType) response.getDataObject();
        Assert.assertNotNull(napStudentResponseSets.getNAPStudentResponseSet());
        Assert.assertEquals(5, napStudentResponseSets.getNAPStudentResponseSet().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = napStudentResponseSetTester.testCreateOne("napstudentresponseset.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        NAPStudentResponseSetType napStudentResponseSet = (NAPStudentResponseSetType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, napStudentResponseSet.getRefId());

        List<Response> deleteResponses = napStudentResponseSetTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = napStudentResponseSetTester.testCreateMany("napstudentresponsesets.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = napStudentResponseSetTester.testDeleteMany(REF_IDS);
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
    public void testServicePathSchoolInfo() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoConsumerTest.REF_ID));

        List<Response> responses = napStudentResponseSetTester.testServicePath(queryCriteria, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);

        NAPStudentResponseSetCollectionType napStudentResponseSetCollection = (NAPStudentResponseSetCollectionType) response.getDataObject();
        Assert.assertNotNull(napStudentResponseSetCollection.getNAPStudentResponseSet());
        Assert.assertFalse(napStudentResponseSetCollection.getNAPStudentResponseSet().isEmpty());
        boolean found = false;
        for (NAPStudentResponseSetType napStudentResponseSetType : napStudentResponseSetCollection.getNAPStudentResponseSet()) {
            found = found || NAPStudentResponseSetRefIds.REF_ID_1.equals(napStudentResponseSetType.getRefId());
        }
        Assert.assertTrue(found);
    }
    
    @Test
    @Category(IntegrationTest.class)
    public void testServicePathStudentPersonals() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalConsumerTest.StudentPersonalRefIds.REF_ID_1));

        List<Response> responses = napStudentResponseSetTester.testServicePath(queryCriteria, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);

        NAPStudentResponseSetCollectionType napStudentResponseSetCollection = (NAPStudentResponseSetCollectionType) response.getDataObject();
        Assert.assertNotNull(napStudentResponseSetCollection.getNAPStudentResponseSet());
        Assert.assertFalse(napStudentResponseSetCollection.getNAPStudentResponseSet().isEmpty());
        boolean found = false;
        for (NAPStudentResponseSetType napStudentResponseSetType : napStudentResponseSetCollection.getNAPStudentResponseSet()) {
            found = found || NAPStudentResponseSetRefIds.REF_ID_1.equals(napStudentResponseSetType.getRefId());
        }
        Assert.assertTrue(found);
    }
}
