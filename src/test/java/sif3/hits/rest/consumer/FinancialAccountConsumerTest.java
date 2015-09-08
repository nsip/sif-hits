package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.FinancialAccountCollectionType;
import sif.dd.au30.model.FinancialAccountType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.FinancialClassificationConsumerTest.FinancialClassificationRefIds;
import sif3.hits.rest.consumer.LocationInfoConsumerTest.LocationInfoRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class FinancialAccountConsumerTest extends BaseTest {
  private ConsumerTest<FinancialAccountType, FinancialAccountCollectionType> financialTester = null;

  public static class FinancialAccountRefIds {
    public static String REF_ID_1 = "d7230685-a578-4eb5-a5e4-c19b096a3d0c";
    public static String REF_ID_2 = "c03b27f4-b0f8-4e46-93fb-4f0dc3b930e9";
    public static String REF_ID_3 = "6f542af3-817a-4245-a1dc-46f41dfdc8d3";
    public static String REF_ID_4 = "37387e1d-68fa-4dbf-b77a-704edd32a53d";
    public static String REF_ID_5 = "0cb34d33-bbf8-43b9-8383-21f2bcd06844";
  }

  private final String REF_ID_1 = "d747f069-e911-4bf3-b899-109b053915c3";
  private final String REF_ID_2 = "0b7127ee-9e52-4f3e-923c-f2389404e32f";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    
    FinancialAccountType financialAccount = new FinancialAccountType();
    financialAccount.setRefId(FinancialAccountRefIds.REF_ID_2);
    financialAccount.setAccountNumber("43242244L");
    financialAccount.setChargedLocationInfoRefId(objectFactory.createFinancialAccountTypeChargedLocationInfoRefId(LocationInfoRefIds.REF_ID_1));
    financialAccount.setCreationDate(getDate("2015-06-21"));
    financialAccount.setCreationTime(getDate("11:32:00"));
    financialAccount.setDescription(objectFactory.createFinancialAccountTypeDescription("Account Description"));
    financialAccount.setFinancialClassificationRefId(FinancialClassificationRefIds.REF_ID_1);
    financialAccount.setName("Account Name");
    financialTester.doCreateOne(financialAccount);

    financialAccount.setRefId(FinancialAccountRefIds.REF_ID_1);
    financialAccount.setSubAccountRefId(objectFactory.createFinancialAccountTypeSubAccountRefId(FinancialAccountRefIds.REF_ID_2));
    financialTester.doCreateOne(financialAccount);
    String xmlExpectedTo = financialTester.getXML(financialAccount);
    
    financialAccount.setRefId(FinancialAccountRefIds.REF_ID_3);
    financialTester.doCreateOne(financialAccount);
    financialAccount.setRefId(FinancialAccountRefIds.REF_ID_4);
    financialTester.doCreateOne(financialAccount);
    financialAccount.setRefId(FinancialAccountRefIds.REF_ID_5);
    financialTester.doCreateOne(financialAccount);

    FinancialAccountType getResult = financialTester.doGetOne(FinancialAccountRefIds.REF_ID_1);
    String xmlExpectedFrom = financialTester.getXML(getResult);
    Assert.assertNotNull("XML Expected From isNull", xmlExpectedFrom);
    Assert.assertNotNull("XML Expected To isNull", xmlExpectedTo);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    financialTester = new ConsumerTest<FinancialAccountType, FinancialAccountCollectionType>(
        FinancialAccountType.class, "FinancialAccount", FinancialAccountCollectionType.class,
        "FinancialAccounts");
    financialTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = financialTester.testGetSingle(FinancialAccountRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    FinancialAccountType studentPersonal = (FinancialAccountType) response.getDataObject();
    Assert.assertEquals(FinancialAccountRefIds.REF_ID_1, studentPersonal.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = financialTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    FinancialAccountCollectionType studentCollection = (FinancialAccountCollectionType) response.getDataObject();
    Assert.assertNotNull(studentCollection.getFinancialAccount());
    Assert.assertEquals(5, studentCollection.getFinancialAccount().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = financialTester.testCreateOne("financialaccount.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    FinancialAccountType studentPersonal = (FinancialAccountType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, studentPersonal.getRefId());

    List<Response> deleteResponses = financialTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = financialTester.testCreateMany("financialaccounts.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = financialTester.testDeleteMany(REF_IDS);
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
