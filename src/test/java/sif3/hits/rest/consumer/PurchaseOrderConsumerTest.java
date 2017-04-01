package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ExpenseAccountType;
import sif.dd.au30.model.ExpenseAccountsType;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PurchaseOrderCollectionType;
import sif.dd.au30.model.PurchaseOrderType;
import sif.dd.au30.model.PurchasingItemType;
import sif.dd.au30.model.PurchasingItemsType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.FinancialAccountConsumerTest.FinancialAccountRefIds;
import sif3.hits.rest.consumer.LocationInfoConsumerTest.LocationInfoRefIds;
import sif3.hits.rest.consumer.StaffPersonalConsumerTest.StaffPersonalRefIds;
import sif3.hits.rest.consumer.VendorInfoConsumerTest.VendorInfoRefIds;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class PurchaseOrderConsumerTest extends BaseTest implements UsesConstants {
  private ConsumerTest<PurchaseOrderType, PurchaseOrderCollectionType> purchaseOrderTester = null;

  public static class PurchaseOrderRefIds {
    public static String REF_ID_1 = "d80e5793-afed-4731-9219-3a317822ac59";
    public static String REF_ID_2 = "1037d5d0-1fc7-4e7c-8c6c-535d78ae3c25";
    public static String REF_ID_3 = "f6888528-bc56-4635-94ec-78f7dee305a3";
    public static String REF_ID_4 = "cfb250d7-5189-4a43-b2a4-605eb0c1782d";
    public static String REF_ID_5 = "be73d4bf-26c8-4dbd-8f26-75a79d5880fa";
  }

  private final String REF_ID_1 = "812217e0-9ad7-4517-b3c0-612a5d97cb39";
  private final String REF_ID_2 = "72abf49f-05de-43e8-ac47-ed78245235eb";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  private PurchasingItemType getPurchasingItem(ObjectFactory objectFactory, String amount, String description, String itemNumber, String quantity, String delivered, String unitCost) {
    PurchasingItemType purchasingItem = new PurchasingItemType();

    ExpenseAccountsType expenseAccounts = objectFactory.createExpenseAccountsType();
    ExpenseAccountType expenseAccount = objectFactory.createExpenseAccountType();
    expenseAccount.setAccountCode("Code");
    expenseAccount.setAccountingPeriod(objectFactory.createExpenseAccountTypeAccountingPeriod("201504"));

    MonetaryAmountType monetaryAmount = objectFactory.createMonetaryAmountType();
    monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
    monetaryAmount.setValue(new BigDecimal(amount));
    expenseAccount.setAmount(monetaryAmount);

    expenseAccount.setFinancialAccountRefId(objectFactory.createExpenseAccountTypeFinancialAccountRefId(FinancialAccountRefIds.REF_ID_1));
    expenseAccounts.getExpenseAccount().add(expenseAccount);
    purchasingItem.setExpenseAccounts(objectFactory.createPurchasingItemTypeExpenseAccounts(expenseAccounts));

    purchasingItem.setItemDescription(description);
    purchasingItem.setItemNumber(objectFactory.createPurchasingItemTypeItemNumber(itemNumber));
    purchasingItem.setQuantity(objectFactory.createPurchasingItemTypeQuantity(quantity));
    purchasingItem.setQuantityDelivered(objectFactory.createPurchasingItemTypeQuantityDelivered(delivered));

    MonetaryAmountType monetaryAmountType = new MonetaryAmountType();
    monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
    monetaryAmountType.setValue(new BigDecimal(unitCost));
    purchasingItem.setUnitCost(objectFactory.createPurchasingItemTypeUnitCost(monetaryAmountType));
    return purchasingItem;
  }

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    PurchaseOrderType purchaseOrderType = new PurchaseOrderType();
    purchaseOrderType.setRefId(PurchaseOrderRefIds.REF_ID_1);

    purchaseOrderType.setChargedLocationInfoRefId(objectFactory.createPurchaseOrderTypeChargedLocationInfoRefId(LocationInfoRefIds.REF_ID_1));
    purchaseOrderType.setCreationDate(objectFactory.createPurchaseOrderTypeCreationDate(getDate("2015-02-23")));
    purchaseOrderType.setEmployeePersonalRefId(objectFactory.createPurchaseOrderTypeEmployeePersonalRefId(StaffPersonalRefIds.REF_ID_1));
    purchaseOrderType.setFormNumber("3");
    purchaseOrderType.setFullyDelivered(objectFactory.createPurchaseOrderTypeFullyDelivered(AUCodeSetsYesOrNoCategoryType.Y));

    PurchasingItemsType purchasingItems = new PurchasingItemsType();
    purchasingItems.getPurchasingItem().add(getPurchasingItem(objectFactory, "20.00", "Description", "123456", "2", "2", "10.00"));
    purchasingItems.getPurchasingItem().add(getPurchasingItem(objectFactory, "60.00", "Description", "123156", "3", "3", "20.00"));
    purchaseOrderType.setPurchasingItems(purchasingItems);

    MonetaryAmountType monetaryAmountType = new MonetaryAmountType();
    monetaryAmountType.setValue(new BigDecimal("8.00"));
    monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
    purchaseOrderType.setTaxAmount(objectFactory.createPurchaseOrderTypeTaxAmount(monetaryAmountType));

    purchaseOrderType.setTaxRate(objectFactory.createPurchaseOrderTypeTaxRate(new BigDecimal("0.1")));
    purchaseOrderType.setUpdateDate(objectFactory.createPurchaseOrderTypeUpdateDate(getDate("2015-09-01")));
    purchaseOrderType.setVendorInfoRefId(VendorInfoRefIds.REF_ID_1);

    purchaseOrderTester.doCreateOne(purchaseOrderType);

    String xmlExpectedTo = purchaseOrderTester.getXML(purchaseOrderType);

    purchaseOrderType.setRefId(PurchaseOrderRefIds.REF_ID_2);
    purchaseOrderTester.doCreateOne(purchaseOrderType);
    purchaseOrderType.setRefId(PurchaseOrderRefIds.REF_ID_3);
    purchaseOrderTester.doCreateOne(purchaseOrderType);
    purchaseOrderType.setRefId(PurchaseOrderRefIds.REF_ID_4);
    purchaseOrderTester.doCreateOne(purchaseOrderType);
    purchaseOrderType.setRefId(PurchaseOrderRefIds.REF_ID_5);
    purchaseOrderTester.doCreateOne(purchaseOrderType);

    PurchaseOrderType getResult = purchaseOrderTester.doGetOne(PurchaseOrderRefIds.REF_ID_1);
    String xmlExpectedFrom = purchaseOrderTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }

  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    purchaseOrderTester = new ConsumerTest<PurchaseOrderType, PurchaseOrderCollectionType>(PurchaseOrderType.class, "PurchaseOrder", PurchaseOrderCollectionType.class, "PurchaseOrders");
    purchaseOrderTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = purchaseOrderTester.testGetSingle(PurchaseOrderRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    PurchaseOrderType purchaseOrder = (PurchaseOrderType) response.getDataObject();
    Assert.assertEquals(PurchaseOrderRefIds.REF_ID_1, purchaseOrder.getRefId());

    String xmlExpectedFrom = purchaseOrderTester.getXML(purchaseOrder);

    List<Response> updateResponses = purchaseOrderTester.doUpdateOne(purchaseOrder, PurchaseOrderRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = purchaseOrderTester.testGetSingle(PurchaseOrderRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    PurchaseOrderType comparisonTo = (PurchaseOrderType) getResponse.getDataObject();
    Assert.assertEquals(PurchaseOrderRefIds.REF_ID_1, comparisonTo.getRefId());
    String xmlExpectedTo = purchaseOrderTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = purchaseOrderTester.testGetSingle(PurchaseOrderRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    PurchaseOrderType purchaseOrder = (PurchaseOrderType) response.getDataObject();
    Assert.assertEquals(PurchaseOrderRefIds.REF_ID_1, purchaseOrder.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = purchaseOrderTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    PurchaseOrderCollectionType purchaseOrderCollection = (PurchaseOrderCollectionType) response.getDataObject();
    Assert.assertNotNull(purchaseOrderCollection.getPurchaseOrder());
    Assert.assertEquals(5, purchaseOrderCollection.getPurchaseOrder().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = purchaseOrderTester.testCreateOne("purchaseorder.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    PurchaseOrderType purchaseOrder = (PurchaseOrderType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, purchaseOrder.getRefId());

    List<Response> deleteResponses = purchaseOrderTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = purchaseOrderTester.testCreateMany("purchaseorders.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = purchaseOrderTester.testDeleteMany(REF_IDS);
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
