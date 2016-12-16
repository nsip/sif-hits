package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.DebitOrCreditAmountType;
import sif.dd.au30.model.FinancialAccountRefIdListType;
import sif.dd.au30.model.ISO4217CurrencyNamesAndCodeElementsType;
import sif.dd.au30.model.InvoiceCollectionType;
import sif.dd.au30.model.InvoiceType;
import sif.dd.au30.model.InvoiceType.InvoicedEntity;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.FinancialAccountConsumerTest.FinancialAccountRefIds;
import sif3.hits.rest.consumer.LocationInfoConsumerTest.LocationInfoRefIds;
import sif3.hits.rest.consumer.PurchaseOrderConsumerTest.PurchaseOrderRefIds;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class InvoiceConsumerTest extends BaseTest implements UsesConstants {
  private ConsumerTest<InvoiceType, InvoiceCollectionType> invoiceTester = null;

  public static class InvoiceRefIds {
    public static String REF_ID_1 = "22a05683-186c-40d5-b7ac-f1b707227310";
    public static String REF_ID_2 = "7e7d5724-531e-42d9-b665-ac153b72e747";
    public static String REF_ID_3 = "a321cfe1-2acf-48a4-961b-fd4400edce22";
    public static String REF_ID_4 = "2010df5f-8424-43bd-a364-cd262a68341a";
    public static String REF_ID_5 = "b7462c82-6f6f-405e-875d-209673b53d55";
  }

  private final String REF_ID_1 = "0e3ead1c-3e79-42a7-bfc7-bb5e4d5efb77";
  private final String REF_ID_2 = "914675bc-3521-4647-b770-58018dacb4b3";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    InvoiceType invoiceType = new InvoiceType();
    invoiceType.setRefId(InvoiceRefIds.REF_ID_1);

    InvoicedEntity invoicedEntity = objectFactory.createInvoiceTypeInvoicedEntity();
    invoicedEntity.setValue("BA497254965FDA48965ABCE4589EA421");
    invoicedEntity.setSIFRefObject("Debtor");
    invoiceType.setInvoicedEntity(invoicedEntity);

    invoiceType.setBillingDate(getDate("2015-07-01"));
    invoiceType.setTransactionDescription("Textbooks");

    DebitOrCreditAmountType billedAmount = objectFactory.createDebitOrCreditAmountType();
    billedAmount.setValue("320.00");
    billedAmount.setType("Debit");
    billedAmount.setCurrency(ISO4217CurrencyNamesAndCodeElementsType.AUD);
    invoiceType.setBilledAmount(billedAmount);

    invoiceType.setLedger("Sundry");
    invoiceType.setChargedLocationInfoRefId(objectFactory.createInvoiceTypeChargedLocationInfoRefId(LocationInfoRefIds.REF_ID_1));
    invoiceType.setTaxRate(objectFactory.createInvoiceTypeTaxRate(new BigDecimal("0.10")));
    invoiceType.setTaxType(objectFactory.createInvoiceTypeTaxType("GST"));

    MonetaryAmountType monetaryAmountType = objectFactory.createMonetaryAmountType();
    monetaryAmountType.setValue("29.09");
    monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
    invoiceType.setTaxAmount(objectFactory.createInvoiceTypeTaxAmount(monetaryAmountType));

    invoiceType.setCreatedBy(objectFactory.createInvoiceTypeCreatedBy("Created By"));
    invoiceType.setApprovedBy(objectFactory.createInvoiceTypeApprovedBy("Approved By"));
    invoiceType.setItemDetail(objectFactory.createInvoiceTypeItemDetail("4 Textbooks"));
    invoiceType.setDueDate(objectFactory.createInvoiceTypeDueDate(getDate("2015-10-22")));
    invoiceType.setAccountingPeriod(objectFactory.createInvoiceTypeAccountingPeriod("2015Q3"));
    invoiceType.setRelatedPurchaseOrderRefId(objectFactory.createInvoiceTypeRelatedPurchaseOrderRefId(PurchaseOrderRefIds.REF_ID_1));
    invoiceType.setVoluntary(objectFactory.createInvoiceTypeVoluntary(AUCodeSetsYesOrNoCategoryType.N));

    FinancialAccountRefIdListType financialAccountRefIdList = objectFactory.createFinancialAccountRefIdListType();
    financialAccountRefIdList.getFinancialAccountRefId().addAll(Arrays.asList(FinancialAccountRefIds.REF_ID_1, FinancialAccountRefIds.REF_ID_2));
    invoiceType.setFinancialAccountRefIdList(objectFactory.createInvoiceTypeFinancialAccountRefIdList(financialAccountRefIdList));

    invoiceTester.doCreateOne(invoiceType);
    String xmlExpectedTo = invoiceTester.getXML(invoiceType);

    invoiceType.setRefId(InvoiceRefIds.REF_ID_2);
    invoiceTester.doCreateOne(invoiceType);
    invoiceType.setRefId(InvoiceRefIds.REF_ID_3);
    invoiceTester.doCreateOne(invoiceType);
    invoiceType.setRefId(InvoiceRefIds.REF_ID_4);
    invoiceTester.doCreateOne(invoiceType);
    invoiceType.setRefId(InvoiceRefIds.REF_ID_5);
    invoiceTester.doCreateOne(invoiceType);

    InvoiceType getResult = invoiceTester.doGetOne(InvoiceRefIds.REF_ID_1);
    String xmlExpectedFrom = invoiceTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    invoiceTester = new ConsumerTest<InvoiceType, InvoiceCollectionType>(InvoiceType.class, "Invoice", InvoiceCollectionType.class, "Invoices");
    invoiceTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = invoiceTester.testGetSingle(InvoiceRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    InvoiceType invoice = (InvoiceType) response.getDataObject();
    Assert.assertEquals(InvoiceRefIds.REF_ID_1, invoice.getRefId());

    String xmlExpectedFrom = invoiceTester.getXML(invoice);

    List<Response> updateResponses = invoiceTester.doUpdateOne(invoice, InvoiceRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = invoiceTester.testGetSingle(InvoiceRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    InvoiceType comparisonTo = (InvoiceType) getResponse.getDataObject();
    Assert.assertEquals(InvoiceRefIds.REF_ID_1, comparisonTo.getRefId());
    String xmlExpectedTo = invoiceTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = invoiceTester.testGetSingle(InvoiceRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    InvoiceType invoice = (InvoiceType) response.getDataObject();
    Assert.assertEquals(InvoiceRefIds.REF_ID_1, invoice.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = invoiceTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    InvoiceCollectionType invoiceCollection = (InvoiceCollectionType) response.getDataObject();
    Assert.assertNotNull(invoiceCollection.getInvoice());
    Assert.assertEquals(5, invoiceCollection.getInvoice().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = invoiceTester.testCreateOne("invoice.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    InvoiceType invoice = (InvoiceType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, invoice.getRefId());

    List<Response> deleteResponses = invoiceTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = invoiceTester.testCreateMany("invoices.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = invoiceTester.testDeleteMany(REF_IDS);
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
