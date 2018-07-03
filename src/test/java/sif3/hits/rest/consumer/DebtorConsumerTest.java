package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.DebtorCollectionType;
import sif.dd.au30.model.DebtorType;
import sif.dd.au30.model.DebtorType.BilledEntity;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.VendorInfoConsumerTest.VendorInfoRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class DebtorConsumerTest extends BaseTest implements UsesConstants {
    private ConsumerTest<DebtorType, DebtorCollectionType> debtorTester = null;

    public static class DebtorRefIds {
        public static String REF_ID_1 = "fd559b14-42c1-4ff2-87c4-efe373005e83";
        public static String REF_ID_2 = "8320c209-c6ea-47a3-9e29-a685dc27de52";
        public static String REF_ID_3 = "902e606f-5a2d-42d2-9b75-6221cccf9658";
        public static String REF_ID_4 = "fcc509c7-bcd5-48bb-9eb5-fc7ce4d3d394";
        public static String REF_ID_5 = "bae2ad5f-a57f-44b6-90d3-7e069d78a7b0";
    }

    private final String REF_ID_1 = "83357168-8b57-40fa-a86d-eaefe70abc55";
    private final String REF_ID_2 = "3556358a-3960-4dd1-9d49-4e8ee2962645";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        DebtorType debtorType = new DebtorType();
        debtorType.setRefId(DebtorRefIds.REF_ID_1);

        BilledEntity billedEntity = objectFactory.createDebtorTypeBilledEntity();
        billedEntity.setValue(VendorInfoRefIds.REF_ID_1);
        billedEntity.setSIFRefObject("VendorInfo");
        debtorType.setBilledEntity(billedEntity);

        debtorType.setBillingName(objectFactory.createDebtorTypeBillingName("Billing Name"));
        debtorType.setBillingNote(objectFactory.createDebtorTypeBillingNote("Billing Note"));
        debtorType.setDiscount(objectFactory.createDebtorTypeDiscount("0.05"));

        AddressListType addressList = objectFactory.createAddressListType();
        addressList.getAddress().add(StudentPersonalRefIds.getAddress(objectFactory, "1 Billed Street", null));
        debtorType.setAddressList(objectFactory.createDebtorTypeAddressList(addressList));

        debtorTester.doCreateOne(debtorType);
        String xmlExpectedTo = debtorTester.getXML(debtorType);

        debtorType.setRefId(DebtorRefIds.REF_ID_2);
        debtorTester.doCreateOne(debtorType);
        debtorType.setRefId(DebtorRefIds.REF_ID_3);
        debtorTester.doCreateOne(debtorType);
        debtorType.setRefId(DebtorRefIds.REF_ID_4);
        debtorTester.doCreateOne(debtorType);
        debtorType.setRefId(DebtorRefIds.REF_ID_5);
        debtorTester.doCreateOne(debtorType);

        DebtorType getResult = debtorTester.doGetOne(DebtorRefIds.REF_ID_1);
        String xmlExpectedFrom = debtorTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        debtorTester = new ConsumerTest<DebtorType, DebtorCollectionType>(DebtorType.class, "Debtor", DebtorCollectionType.class, "Debtors");
        debtorTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = debtorTester.testGetSingle(DebtorRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        DebtorType debtor = (DebtorType) response.getDataObject();
        Assert.assertEquals(DebtorRefIds.REF_ID_1, debtor.getRefId());
        String xmlExpectedFrom = debtorTester.getXML(debtor);

        List<Response> updateResponses = debtorTester.doUpdateOne(debtor, DebtorRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = debtorTester.testGetSingle(DebtorRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        DebtorType debtorTo = (DebtorType) getResponse.getDataObject();
        Assert.assertEquals(DebtorRefIds.REF_ID_1, debtorTo.getRefId());
        String xmlExpectedTo = debtorTester.getXML(debtorTo);

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
        List<Response> responses = debtorTester.testGetSingle(DebtorRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        DebtorType debtor = (DebtorType) response.getDataObject();
        Assert.assertEquals(DebtorRefIds.REF_ID_1, debtor.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = debtorTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        DebtorCollectionType debtorCollection = (DebtorCollectionType) response.getDataObject();
        Assert.assertNotNull(debtorCollection.getDebtor());
        Assert.assertEquals(5, debtorCollection.getDebtor().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = debtorTester.testCreateOne("debtor.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        DebtorType debtor = (DebtorType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, debtor.getRefId());

        List<Response> deleteResponses = debtorTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = debtorTester.testCreateMany("debtors.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = debtorTester.testDeleteMany(REF_IDS);
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
    public void testQBE() {
        ObjectFactory objectFactory = new ObjectFactory();
        DebtorType debtorType = new DebtorType();
        BilledEntity billedEntity = objectFactory.createDebtorTypeBilledEntity();
        billedEntity.setSIFRefObject("VendorInfo");
        debtorType.setBilledEntity(billedEntity);
        List<Response> responses = debtorTester.testQBE(debtorType, 1000, 0);

        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        DebtorCollectionType debtorCollectionType = (DebtorCollectionType) response.getDataObject();
        Assert.assertNotNull(debtorCollectionType.getDebtor());
        Assert.assertFalse(debtorCollectionType.getDebtor().isEmpty());
        boolean found = false;
        for (DebtorType debtor : debtorCollectionType.getDebtor()) {
            found = found || DebtorRefIds.REF_ID_1.equals(debtor.getRefId());
        }
        Assert.assertTrue(found);
    }
}
