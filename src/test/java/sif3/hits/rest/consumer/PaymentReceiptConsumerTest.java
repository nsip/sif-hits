package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PaymentReceiptCollectionType;
import sif.dd.au30.model.PaymentReceiptType;
import sif.dd.au30.model.PaymentReceiptType.FinancialAccountRefIdList;
import sif.dd.au30.model.PaymentReceiptType.TransactionAmount;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.DebtorConsumerTest.DebtorRefIds;
import sif3.hits.rest.consumer.FinancialAccountConsumerTest.FinancialAccountRefIds;
import sif3.hits.rest.consumer.InvoiceConsumerTest.InvoiceRefIds;
import sif3.hits.rest.consumer.LocationInfoConsumerTest.LocationInfoRefIds;
import sif3.hits.rest.consumer.VendorInfoConsumerTest.VendorInfoRefIds;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class PaymentReceiptConsumerTest extends BaseTest implements UsesConstants {
  private ConsumerTest<PaymentReceiptType, PaymentReceiptCollectionType> paymentReceiptTester = null;

  public static class PaymentReceiptRefIds {
    public static String REF_ID_1 = "682bd5d8-5a2c-4cd4-b274-fcdb6c018bea";
    public static String REF_ID_2 = "e309d41f-7812-4818-a835-c271a29e56ed";
    public static String REF_ID_3 = "29b26897-7b6d-49f1-bc4d-2a8f1d034001";
    public static String REF_ID_4 = "09f93bd9-dc9f-4743-90c1-47b8f585d76e";
    public static String REF_ID_5 = "aa6b380b-47c5-4f03-bb0d-da53f9b5347d";
  }

  private final String REF_ID_1 = "65e49126-a787-4d6d-ad5d-21353c3c8bf0";
  private final String REF_ID_2 = "3aefa7e2-d8cc-443f-bd41-41d73f394093";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    PaymentReceiptType paymentReceiptType = new PaymentReceiptType();
    paymentReceiptType.setRefId(PaymentReceiptRefIds.REF_ID_1);
    paymentReceiptType.setAccountingPeriod(objectFactory.createPaymentReceiptTypeAccountingPeriod("2015Q3"));
    paymentReceiptType.setChargedLocationInfoRefId(
        objectFactory.createPaymentReceiptTypeChargedLocationInfoRefId(LocationInfoRefIds.REF_ID_1));
    paymentReceiptType.setChequeNumber(objectFactory.createPaymentReceiptTypeChequeNumber("23593032"));
    paymentReceiptType.setDebtorRefId(objectFactory.createPaymentReceiptTypeDebtorRefId(DebtorRefIds.REF_ID_1));

    FinancialAccountRefIdList financialAccountRefIdList = new FinancialAccountRefIdList();
    financialAccountRefIdList.getFinancialAccountRefId().add(FinancialAccountRefIds.REF_ID_1);
    financialAccountRefIdList.getFinancialAccountRefId().add(FinancialAccountRefIds.REF_ID_2);
    paymentReceiptType.setFinancialAccountRefIdList(
        objectFactory.createPaymentReceiptTypeFinancialAccountRefIdList(financialAccountRefIdList));

    paymentReceiptType.setInvoiceRefId(objectFactory.createPaymentReceiptTypeInvoiceRefId(InvoiceRefIds.REF_ID_1));

    TransactionAmount receivedAmount = new TransactionAmount();
    receivedAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
    receivedAmount.setValue("25.00");
    receivedAmount.setType("Debit");
    paymentReceiptType.setTransactionAmount(receivedAmount);

    paymentReceiptType.setReceivedTransactionId("201546");
    MonetaryAmountType monetaryAmountType = new MonetaryAmountType();
    monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
    monetaryAmountType.setValue("2.50");
    paymentReceiptType.setTaxAmount(objectFactory.createPaymentReceiptTypeTaxAmount(monetaryAmountType));
    paymentReceiptType.setTaxRate(objectFactory.createPaymentReceiptTypeTaxRate(new BigDecimal("0.10")));
    paymentReceiptType.setTransactionDate(getDate("2015-06-23"));
    paymentReceiptType
        .setTransactionDescription(objectFactory.createPaymentReceiptTypeTransactionDescription("Some description"));

    paymentReceiptType.setTransactionMethod(objectFactory.createPaymentReceiptTypeTransactionMethod("Cash"));
    paymentReceiptType
        .setTransactionNote(objectFactory.createPaymentReceiptTypeTransactionNote("Transaction note goes here"));
    paymentReceiptType.setTransactionType("Creditor payment");
    paymentReceiptType
        .setVendorInfoRefId(objectFactory.createPaymentReceiptTypeVendorInfoRefId(VendorInfoRefIds.REF_ID_1));

    paymentReceiptTester.doCreateOne(paymentReceiptType);
    String xmlExpectedTo = paymentReceiptTester.getXML(paymentReceiptType);

    paymentReceiptType.setRefId(PaymentReceiptRefIds.REF_ID_2);
    paymentReceiptTester.doCreateOne(paymentReceiptType);
    paymentReceiptType.setRefId(PaymentReceiptRefIds.REF_ID_3);
    paymentReceiptTester.doCreateOne(paymentReceiptType);
    paymentReceiptType.setRefId(PaymentReceiptRefIds.REF_ID_4);
    paymentReceiptTester.doCreateOne(paymentReceiptType);
    paymentReceiptType.setRefId(PaymentReceiptRefIds.REF_ID_5);
    paymentReceiptTester.doCreateOne(paymentReceiptType);

    PaymentReceiptType getResult = paymentReceiptTester.doGetOne(PaymentReceiptRefIds.REF_ID_1);
    String xmlExpectedFrom = paymentReceiptTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    paymentReceiptTester = new ConsumerTest<PaymentReceiptType, PaymentReceiptCollectionType>(PaymentReceiptType.class,
        "PaymentReceipt", PaymentReceiptCollectionType.class, "PaymentReceipts");
    paymentReceiptTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = paymentReceiptTester.testGetSingle(PaymentReceiptRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    PaymentReceiptType paymentReceipt = (PaymentReceiptType) response.getDataObject();
    Assert.assertEquals(PaymentReceiptRefIds.REF_ID_1, paymentReceipt.getRefId());
    
    String xmlExpectedFrom = paymentReceiptTester.getXML(paymentReceipt);
    
    List<Response> updateResponses = paymentReceiptTester.doUpdateOne(paymentReceipt, PaymentReceiptRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());
    
    List<Response> getResponses = paymentReceiptTester.testGetSingle(PaymentReceiptRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    PaymentReceiptType comparisonTo = (PaymentReceiptType) getResponse.getDataObject();
    Assert.assertEquals(PaymentReceiptRefIds.REF_ID_1, comparisonTo.getRefId());
    String xmlExpectedTo = paymentReceiptTester.getXML(comparisonTo);
    
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = paymentReceiptTester.testGetSingle(PaymentReceiptRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    PaymentReceiptType paymentReceipt = (PaymentReceiptType) response.getDataObject();
    Assert.assertEquals(PaymentReceiptRefIds.REF_ID_1, paymentReceipt.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = paymentReceiptTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    PaymentReceiptCollectionType paymentReceiptCollection = (PaymentReceiptCollectionType) response.getDataObject();
    Assert.assertNotNull(paymentReceiptCollection.getPaymentReceipt());
    Assert.assertEquals(5, paymentReceiptCollection.getPaymentReceipt().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = paymentReceiptTester.testCreateOne("paymentreceipt.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    PaymentReceiptType paymentReceipt = (PaymentReceiptType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, paymentReceipt.getRefId());

    List<Response> deleteResponses = paymentReceiptTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = paymentReceiptTester
        .testCreateMany("paymentreceipts.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = paymentReceiptTester.testDeleteMany(REF_IDS);
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
