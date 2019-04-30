package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif.dd.au30.model.InvoiceType.InvoicedEntity;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InvoiceTestData extends TestData<InvoiceType, InvoiceCollectionType> {

    public static final String REF_ID_1 = "d21c2326-c868-47eb-8b0a-d19b74c0a5b9";
    public static final String REF_ID_2 = "b0440972-c253-4f3b-8fa7-6ad275e9e112";
    public static final String REF_ID_3 = "6792268e-db6b-497a-aa20-aae7712ed5b2";
    public static final String REF_ID_4 = "1e53f9ab-53bc-48ff-848a-688f565998cd";
    public static final String REF_ID_5 = "20fce13b-dbc1-4a78-8855-306deee279bb";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "3d283211-c59f-4b42-827e-12a8c7707d58";
    public static final String XML_REF_ID_2 = "d89a3506-890e-449d-8558-4772164560ea";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String INVOICED_ENTITY = "Debtor";
    public static final String BILLING_DATE = "2015-07-01";
    public static final String DESCRIPTION = "Textbooks";
    public static final String AMOUNT = "320.00";
    public static final String TYPE = "Debit";
    public static final String LEDGER = "Sundry";
    public static final String TAX_RATE = "0.10";
    public static final String TAX_TYPE = "GST";
    public static final String TAX_AMOUNT = "29.09";
    public static final String CREATED_BY = "Creator";
    public static final String APPROVED_BY = "Approver";
    public static final String DETAIL = "4 Textbooks";
    public static final String DUE_DATE = "2015-10-22";
    public static final String PERIOD = "2015Q3";
    public static final String VOLUNTARY = "N";
    public static final String FORM_NUMBER = "1234";
    public static final String FORM_NUMBER_QBE = "9876";

    public InvoiceType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        InvoiceType invoiceType = new InvoiceType();
        invoiceType.setRefId(refId);

        InvoicedEntity invoicedEntity = objectFactory.createInvoiceTypeInvoicedEntity();
        invoicedEntity.setValue(DebtorTestData.REF_ID_1);
        invoicedEntity.setSIFRefObject(INVOICED_ENTITY);
        invoiceType.setInvoicedEntity(invoicedEntity);

        invoiceType.setBillingDate(getDate(BILLING_DATE));
        invoiceType.setTransactionDescription(DESCRIPTION);

        DebitOrCreditAmountType billedAmount = objectFactory.createDebitOrCreditAmountType();
        billedAmount.setValue(new BigDecimal(AMOUNT));
        billedAmount.setType(TYPE);
        billedAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
        invoiceType.setBilledAmount(billedAmount);

        invoiceType.setLedger(LEDGER);
        invoiceType.setChargedLocationInfoRefId(objectFactory.createInvoiceTypeChargedLocationInfoRefId(ChargedLocationInfoTestData.REF_ID_1));
        invoiceType.setTaxRate(objectFactory.createInvoiceTypeTaxRate(new BigDecimal(TAX_RATE)));
        invoiceType.setTaxType(objectFactory.createInvoiceTypeTaxType(TAX_TYPE));

        MonetaryAmountType monetaryAmountType = objectFactory.createMonetaryAmountType();
        monetaryAmountType.setValue(new BigDecimal(TAX_AMOUNT));
        monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
        invoiceType.setTaxAmount(objectFactory.createInvoiceTypeTaxAmount(monetaryAmountType));

        invoiceType.setCreatedBy(objectFactory.createInvoiceTypeCreatedBy(CREATED_BY));
        invoiceType.setApprovedBy(objectFactory.createInvoiceTypeApprovedBy(APPROVED_BY));
        invoiceType.setItemDetail(objectFactory.createInvoiceTypeItemDetail(DETAIL));
        invoiceType.setDueDate(objectFactory.createInvoiceTypeDueDate(getDate(DUE_DATE)));
        invoiceType.setAccountingPeriod(objectFactory.createInvoiceTypeAccountingPeriod(PERIOD));
        invoiceType.setRelatedPurchaseOrderRefId(objectFactory.createInvoiceTypeRelatedPurchaseOrderRefId(PurchaseOrderTestData.REF_ID_1));
        invoiceType.setVoluntary(objectFactory.createInvoiceTypeVoluntary(AUCodeSetsYesOrNoCategoryType.fromValue(VOLUNTARY)));
        invoiceType.setFormNumber(objectFactory.createInvoiceTypeFormNumber(FORM_NUMBER));

        FinancialAccountRefIdListType financialAccountRefIdList = objectFactory.createFinancialAccountRefIdListType();
        financialAccountRefIdList.getFinancialAccountRefId().addAll(Arrays.asList(FinancialAccountTestData.REF_ID_1, FinancialAccountTestData.REF_ID_2));
        invoiceType.setFinancialAccountRefIdList(objectFactory.createInvoiceTypeFinancialAccountRefIdList(financialAccountRefIdList));

        if (REF_ID_4.equals(refId)) {
            invoiceType.setFormNumber(null);
        } else if (REF_ID_5.equals(refId)) {
            invoiceType.setFormNumber(objectFactory.createInvoiceTypeFormNumber(FORM_NUMBER_QBE));
        }
        return invoiceType;
    }

    @Override
    public List<InvoiceType> getExamplesForQuery() {
        IObjectFactory objectFactory = getObjectFactory();
        InvoiceType invoiceType = new InvoiceType();
        invoiceType.setFormNumber(objectFactory.createInvoiceTypeFormNumber(FORM_NUMBER_QBE));
        return Arrays.asList(invoiceType);
    }

    @Override
    public boolean isExampleObject(InvoiceType object, int index) {
        return object != null && object.getFormNumber() != null && FORM_NUMBER_QBE.equals(object.getFormNumber().getValue());
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

    public InvoiceCollectionType getTestCollection(String... refIds) {
        InvoiceCollectionType result = new InvoiceCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getInvoice().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "Invoice.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "Invoices.xml";
    }

}

