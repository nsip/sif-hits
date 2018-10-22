package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.JournalCollectionType;
import sif.dd.au30.model.JournalType;
import sif.dd.au30.model.JournalType.OriginatingTransactionRefId;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.FinancialAccountConsumerTest.FinancialAccountRefIds;
import sif3.hits.rest.consumer.InvoiceConsumerTest.InvoiceRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class JournalConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<JournalType, JournalCollectionType> journalTester = null;

    public static class JournalRefIds {
        public static String REF_ID_1 = "437418e7-f776-4667-9868-01b7b40df7ba";
        public static String REF_ID_2 = "77a4d8f2-1749-42c3-90fc-9ad8867e04e6";
        public static String REF_ID_3 = "99849535-3d68-448e-a56d-7e704d9cde79";
        public static String REF_ID_4 = "4b294d80-c6a7-4c7a-88e4-38beda1600a5";
        public static String REF_ID_5 = "2b55c0fc-1e61-43de-b840-3909806ca784";
    }

    private final String REF_ID_1 = "56557dd7-1367-43ea-b0c6-be91131c1bff";
    private final String REF_ID_2 = "b5c793a7-d693-4bbc-8274-55d680f5b100";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        JournalType journalType = new JournalType();
        journalType.setRefId(JournalRefIds.REF_ID_1);

        MonetaryAmountType monetaryAmount = new MonetaryAmountType();
        monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmount.setValue(new BigDecimal("400.00"));
        journalType.setAmount(monetaryAmount);

        journalType.setApprovedBy(objectFactory.createJournalTypeApprovedBy("John Smith"));
        journalType.setApprovedDate(objectFactory.createJournalTypeApprovedDate(getDate("2015-06-22")));
        journalType.setCreatedBy(objectFactory.createJournalTypeCreatedBy("James Smith"));
        journalType.setCreatedDate(objectFactory.createJournalTypeCreatedDate(getDate("2015-04-20")));
        journalType.setCreditFinancialAccountRefId(FinancialAccountRefIds.REF_ID_1);
        journalType.setDebitFinancialAccountRefId(FinancialAccountRefIds.REF_ID_2);
        journalType.setGSTCodeOriginal(objectFactory.createJournalTypeGSTCodeOriginal("G6"));
        journalType.setGSTCodeReplacement(objectFactory.createJournalTypeGSTCodeReplacement("G6"));
        journalType.setNote(objectFactory.createJournalTypeNote("Journal Note"));

        OriginatingTransactionRefId originatingTransactionRefId = new OriginatingTransactionRefId();
        originatingTransactionRefId.setValue(InvoiceRefIds.REF_ID_1);
        originatingTransactionRefId.setSIFRefObject("Invoice");
        journalType.setOriginatingTransactionRefId(objectFactory.createJournalTypeOriginatingTransactionRefId(originatingTransactionRefId));

        journalTester.doCreateOne(journalType);
        String xmlExpectedTo = journalTester.getXML(journalType);

        journalType.setRefId(JournalRefIds.REF_ID_2);
        journalTester.doCreateOne(journalType);
        journalType.setRefId(JournalRefIds.REF_ID_3);
        journalTester.doCreateOne(journalType);
        journalType.setRefId(JournalRefIds.REF_ID_4);
        journalTester.doCreateOne(journalType);
        journalType.setRefId(JournalRefIds.REF_ID_5);
        journalTester.doCreateOne(journalType);

        JournalType getResult = journalTester.doGetOne(JournalRefIds.REF_ID_1);
        String xmlExpectedFrom = journalTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        journalTester = new ConsumerTest<JournalType, JournalCollectionType>(JournalType.class, "Journal", JournalCollectionType.class, "Journals");
        journalTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = journalTester.testGetSingle(JournalRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        JournalType journal = (JournalType) response.getDataObject();
        Assert.assertEquals(JournalRefIds.REF_ID_1, journal.getRefId());

        String xmlExpectedFrom = journalTester.getXML(journal);

        List<Response> updateResponses = journalTester.doUpdateOne(journal, JournalRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = journalTester.testGetSingle(JournalRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        JournalType comparisonTo = (JournalType) getResponse.getDataObject();
        Assert.assertEquals(JournalRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = journalTester.getXML(comparisonTo);

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
        List<Response> responses = journalTester.testGetSingle(JournalRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        JournalType journal = (JournalType) response.getDataObject();
        Assert.assertEquals(JournalRefIds.REF_ID_1, journal.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = journalTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        JournalCollectionType journalCollection = (JournalCollectionType) response.getDataObject();
        Assert.assertNotNull(journalCollection.getJournal());
        Assert.assertEquals(5, journalCollection.getJournal().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = journalTester.testCreateOne("journal.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        JournalType journal = (JournalType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, journal.getRefId());

        List<Response> deleteResponses = journalTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = journalTester.testCreateMany("journals.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = journalTester.testDeleteMany(REF_IDS);
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

        List<Response> responses = journalTester.testServicePath(queryCriteria, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);

        JournalCollectionType journalCollection = (JournalCollectionType) response.getDataObject();
        Assert.assertNotNull(journalCollection.getJournal());
        Assert.assertFalse(journalCollection.getJournal().isEmpty());
        boolean found = false;
        for (JournalType journalType : journalCollection.getJournal()) {
            found = found || JournalRefIds.REF_ID_1.equals(journalType.getRefId());
        }
        Assert.assertTrue(found);
    }
}
