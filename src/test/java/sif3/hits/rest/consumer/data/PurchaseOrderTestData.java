package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class PurchaseOrderTestData extends TestData<PurchaseOrderType, PurchaseOrderCollectionType> {

    public static final String REF_ID_1 = "190d0be2-5944-4453-8005-3bf91cd79a55";
    public static final String REF_ID_2 = "344a4226-4502-48b1-92fa-1fcdf3ae3a85";
    public static final String REF_ID_3 = "b48c4b95-d254-4108-b5a4-6e8056a1a30d";
    public static final String REF_ID_4 = "dfc8f8ef-c372-404c-9cac-252fc63439ea";
    public static final String REF_ID_5 = "582d3ef1-e53d-47a4-a854-a17a27fe8c11";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "14ef0b45-037a-4135-9977-d4aab5422ce5";
    public static final String XML_REF_ID_2 = "33da4bbf-32fe-4743-8d6c-f0be61d1c7c1";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String ACCOUNT_CODE = "AC";
    public static final String PERIOD = "2015Q4";
    public static final String CREATION_DATE = "2015-02-03";
    public static final String FORM_NUMBER = "3";
    public static final String FULLY_DELIVERED = "Y";
    public static final BigDecimal BASE_AMOUNT = new BigDecimal("10.00");
    public static final String DESCRIPTION_PREFIX = "Description #";
    public static final BigInteger ITEM_NUMBER = new BigInteger("123456");

    public static final String TAX_AMOUNT = "23.00";
    public static final String TAX_RATE = "0.10";
    public static final String UPDATE_DATE = "2015-09-01";

    public PurchaseOrderType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        PurchaseOrderType purchaseOrderType = new PurchaseOrderType();
        purchaseOrderType.setRefId(refId);

        purchaseOrderType.setChargedLocationInfoRefId(objectFactory.createPurchaseOrderTypeChargedLocationInfoRefId(ChargedLocationInfoTestData.REF_ID_1));
        purchaseOrderType.setCreationDate(objectFactory.createPurchaseOrderTypeCreationDate(getDate(CREATION_DATE)));
        purchaseOrderType.setEmployeePersonalRefId(objectFactory.createPurchaseOrderTypeEmployeePersonalRefId(StaffPersonalTestData.REF_ID_1));
        purchaseOrderType.setFormNumber(FORM_NUMBER);
        purchaseOrderType.setFullyDelivered(objectFactory.createPurchaseOrderTypeFullyDelivered(AUCodeSetsYesOrNoCategoryType.fromValue(FULLY_DELIVERED)));

        PurchasingItemsType purchasingItems = new PurchasingItemsType();
        purchasingItems.getPurchasingItem().add(getPurchasingItem(1));
        purchasingItems.getPurchasingItem().add(getPurchasingItem(2));
        purchaseOrderType.setPurchasingItems(purchasingItems);

        MonetaryAmountType monetaryAmountType = new MonetaryAmountType();
        monetaryAmountType.setValue(new BigDecimal(TAX_AMOUNT));
        monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
        purchaseOrderType.setTaxAmount(objectFactory.createPurchaseOrderTypeTaxAmount(monetaryAmountType));

        purchaseOrderType.setTaxRate(objectFactory.createPurchaseOrderTypeTaxRate(new BigDecimal(TAX_RATE)));
        purchaseOrderType.setUpdateDate(objectFactory.createPurchaseOrderTypeUpdateDate(getDate(UPDATE_DATE)));
        purchaseOrderType.setVendorInfoRefId(VendorInfoTestData.REF_ID_1);
        return purchaseOrderType;
    }

    private PurchasingItemType getPurchasingItem(int index) {
        IObjectFactory objectFactory = getObjectFactory();
        PurchasingItemType purchasingItem = new PurchasingItemType();

        String strIndex = "" + index;
        BigInteger intIndex = new BigInteger(strIndex, 10);
        BigDecimal decIndex = new BigDecimal(strIndex);

        ExpenseAccountsType expenseAccounts = objectFactory.createExpenseAccountsType();
        ExpenseAccountType expenseAccount = objectFactory.createExpenseAccountType();
        expenseAccount.setAccountCode(ACCOUNT_CODE);
        expenseAccount.setAccountingPeriod(objectFactory.createExpenseAccountTypeAccountingPeriod(PERIOD));

        MonetaryAmountType monetaryAmount = objectFactory.createMonetaryAmountType();
        monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmount.setValue(BASE_AMOUNT.multiply(decIndex));
        expenseAccount.setAmount(monetaryAmount);

        expenseAccount.setFinancialAccountRefId(objectFactory.createExpenseAccountTypeFinancialAccountRefId(FinancialAccountTestData.REF_ID_1));
        expenseAccounts.getExpenseAccount().add(expenseAccount);
        purchasingItem.setExpenseAccounts(objectFactory.createPurchasingItemTypeExpenseAccounts(expenseAccounts));

        purchasingItem.setItemDescription(DESCRIPTION_PREFIX + strIndex);
        purchasingItem.setItemNumber(objectFactory.createPurchasingItemTypeItemNumber(ITEM_NUMBER.multiply(intIndex).toString()));
        purchasingItem.setQuantity(objectFactory.createPurchasingItemTypeQuantity(strIndex));
        purchasingItem.setQuantityDelivered(objectFactory.createPurchasingItemTypeQuantityDelivered(strIndex));

        MonetaryAmountType monetaryAmountType = new MonetaryAmountType();
        monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmountType.setValue(BASE_AMOUNT);
        purchasingItem.setUnitCost(objectFactory.createPurchasingItemTypeUnitCost(monetaryAmountType));
        return purchasingItem;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(PurchaseOrderType object, int index) {
        // this object is linked via charged location info.
        return object != null && index == 0;
    }

    public String getRefId(int index) {
        String result = null;
        if (index >= 0 && index < REF_ID_RA.length) {
            result = REF_ID_RA[index];
        } else {
            result = RefIdGenerator.getRefId();
        }
        return result;
    }

    public PurchaseOrderCollectionType getTestCollection(String... refIds) {
        PurchaseOrderCollectionType result = new PurchaseOrderCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getPurchaseOrder().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "PurchaseOrder.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "PurchaseOrders.xml";
    }

}

