package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.FinancialClassificationCollectionType;
import sif.dd.au30.model.FinancialClassificationType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class FinancialClassificationConsumerTest extends BaseTest {
  private ConsumerTest<FinancialClassificationType, FinancialClassificationCollectionType> financialTester = null;

  public static class FinancialClassificationRefIds {
    public static final String REF_ID_1 = "2e21897b-0aa6-4c34-9465-b98807044d2b";
    public static final String REF_ID_2 = "415af77b-be03-42c9-b9f7-5d7399ccf580";
    public static final String REF_ID_3 = "27a71eb5-1e33-4f3c-a037-cc8c1e294d9a";
    public static final String REF_ID_4 = "73cf1c79-ef05-4351-9217-0f4ece426127";
    public static final String REF_ID_5 = "a0f48527-3aa7-4300-b277-e2208aa9904d";
  }
  
  private static final String REF_ID_1 = "d1a99c4e-afa1-4aa3-8e6b-d93870f9c1b3"; 
  private static final String REF_ID_2 = "ec5a392e-54bc-4d5e-9f2b-d638fb4400d3";
  private static final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    FinancialClassificationType financialClassification = new FinancialClassificationType();
    financialClassification.setRefId(FinancialClassificationRefIds.REF_ID_1);
    financialClassification.setClassificationType("Asset");
    financialClassification.setDescription(objectFactory.createFinancialClassificationTypeDescription("Financial Classification Description"));
    financialClassification.setName("The Name");

    financialTester.doCreateOne(financialClassification);
    String xmlExpectedTo = financialTester.getXML(financialClassification);

    financialClassification.setRefId(FinancialClassificationRefIds.REF_ID_2);
    financialTester.doCreateOne(financialClassification);
    financialClassification.setRefId(FinancialClassificationRefIds.REF_ID_3);
    financialTester.doCreateOne(financialClassification);
    financialClassification.setRefId(FinancialClassificationRefIds.REF_ID_4);
    financialTester.doCreateOne(financialClassification);
    financialClassification.setRefId(FinancialClassificationRefIds.REF_ID_5);
    financialTester.doCreateOne(financialClassification);

    FinancialClassificationType getResult = financialTester.doGetOne(FinancialClassificationRefIds.REF_ID_1);
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
    financialTester = new ConsumerTest<FinancialClassificationType, FinancialClassificationCollectionType>(
        FinancialClassificationType.class, "FinancialClassification", FinancialClassificationCollectionType.class,
        "FinancialClassifications");
    financialTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = financialTester.testGetSingle(FinancialClassificationRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    FinancialClassificationType studentPersonal = (FinancialClassificationType) response.getDataObject();
    Assert.assertEquals(FinancialClassificationRefIds.REF_ID_1, studentPersonal.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = financialTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    FinancialClassificationCollectionType studentCollection = (FinancialClassificationCollectionType) response.getDataObject();
    Assert.assertNotNull(studentCollection.getFinancialClassification());
    Assert.assertEquals(5, studentCollection.getFinancialClassification().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = financialTester.testCreateOne("financialclassification.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    FinancialClassificationType studentPersonal = (FinancialClassificationType) createResponse.getDataObject();
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

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = financialTester.testCreateMany("financialclassifications.xml");
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
