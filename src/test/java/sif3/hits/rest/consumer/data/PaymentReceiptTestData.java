package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import sif.dd.au30.model.AccountCodeListType;
import sif.dd.au30.model.DebitOrCreditAmountType;
import sif.dd.au30.model.FinancialAccountRefIdListType;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.PaymentReceiptCollectionType;
import sif.dd.au30.model.PaymentReceiptLineListType;
import sif.dd.au30.model.PaymentReceiptLineType;
import sif.dd.au30.model.PaymentReceiptType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class PaymentReceiptTestData extends TestData<PaymentReceiptType, PaymentReceiptCollectionType> {

	public static final String REF_ID_1 = "1b60f3d4-5a8b-43f1-b751-321fcc3fbebb";
	public static final String REF_ID_2 = "bd5d0e17-408b-449e-8027-11e96ca941e1";
	public static final String REF_ID_3 = "8898ee88-3078-4418-a9e5-7e13e766c9d7";
	public static final String REF_ID_4 = "0ccde4cf-6b0d-4a22-bb00-1376644d270b";
	public static final String REF_ID_5 = "25f39654-4ecc-4303-a3ab-e8ca77480e60";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "8ed689a8-1915-48b5-8abb-ba4d43941257";
	public static final String XML_REF_ID_2 = "02e0b66b-2ef4-4fd6-97df-b274d9372445";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public static final String PERIOD = "2015Q3";
	public static final String CHEQUE = "987865434";
	public static final String VALUE = "33.00";
	public static final String TYPE = "Debit";
	public static final String TRANSACTION_ID = "3429104";
	public static final String TAX_VALUE = "3.00";
	public static final String TAX_PERCENT = "0.10";
	public static final String TRANSACTION_DATE = "2015-06-23";
	public static final String DESCRIPTION = "Transaction Description";
	public static final String METHOD = "Cash";
	public static final String NOTE = "Transaction Notes";
	public static final String TRANSACTION_TYPE = "Creditor Payment";

	public PaymentReceiptLineType getPaymentReceiptLine(String refId, int index) {
		IObjectFactory objectFactory = getObjectFactory();
		PaymentReceiptLineType result = objectFactory.createPaymentReceiptLineType();
		String prefix = StringUtils.defaultString(StringUtils.substring(refId, 0, 8), "prefix");
		String id = prefix + "-" + index;

		result.setInvoiceRefId(objectFactory.createPaymentReceiptLineTypeInvoiceRefId(InvoiceTestData.REF_ID_1));
		result.setLocalId(objectFactory.createPaymentReceiptLineTypeLocalId("local-id-" + id));
		result.setLocalPaymentReceiptLineId(
				objectFactory.createPaymentReceiptLineTypeLocalPaymentReceiptLineId("local-prl-id-" + id));

		DebitOrCreditAmountType transactionAmount = objectFactory.createDebitOrCreditAmountType();
		transactionAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
		transactionAmount.setType(TYPE);
		transactionAmount.setValue(new BigDecimal("11.00"));
		result.setTransactionAmount(transactionAmount);

		result.setFinancialAccountRefId(
				objectFactory.createPaymentReceiptLineTypeFinancialAccountRefId(FinancialAccountTestData.REF_ID_1));
		result.setAccountCode(objectFactory.createPaymentReceiptLineTypeAccountCode("account-code-" + id));
		result.setTransactionDescription(objectFactory.createPaymentReceiptLineTypeTransactionDescription(
				"transaction description " + id + " : " + refId + " " + index));
		result.setTaxRate(objectFactory.createPaymentReceiptLineTypeTaxRate(new BigDecimal(TAX_PERCENT)));

		MonetaryAmountType taxAmount = objectFactory.createMonetaryAmountType();
		taxAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
		taxAmount.setValue(new BigDecimal("1.00"));
		result.setTaxAmount(objectFactory.createPaymentReceiptLineTypeTaxAmount(taxAmount));
		return result;
	}

	public PaymentReceiptType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		PaymentReceiptType paymentReceiptType = new PaymentReceiptType();
		paymentReceiptType.setRefId(refId);
		paymentReceiptType.setLocalId(objectFactory.createPaymentReceiptTypeLocalId("local-id"));
		paymentReceiptType.setAccountingPeriod(objectFactory.createPaymentReceiptTypeAccountingPeriod(PERIOD));
		paymentReceiptType.setChargedLocationInfoRefId(
				objectFactory.createPaymentReceiptTypeChargedLocationInfoRefId(ChargedLocationInfoTestData.REF_ID_1));
		paymentReceiptType.setChequeNumber(objectFactory.createPaymentReceiptTypeChequeNumber(CHEQUE));
		paymentReceiptType.setDebtorRefId(objectFactory.createPaymentReceiptTypeDebtorRefId(DebtorTestData.REF_ID_1));

		FinancialAccountRefIdListType financialAccountRefIdList = objectFactory.createFinancialAccountRefIdListType();
		financialAccountRefIdList.getFinancialAccountRefId().add(FinancialAccountTestData.REF_ID_1);
		financialAccountRefIdList.getFinancialAccountRefId().add(FinancialAccountTestData.REF_ID_2);
		paymentReceiptType.setFinancialAccountRefIdList(
				objectFactory.createPaymentReceiptTypeFinancialAccountRefIdList(financialAccountRefIdList));

		AccountCodeListType accountCodeList = objectFactory.createAccountCodeListType();
		accountCodeList.getAccountCode().add("account-code-1");
		accountCodeList.getAccountCode().add("account-code-2");
		paymentReceiptType.setAccountCodeList(objectFactory.createPaymentReceiptTypeAccountCodeList(accountCodeList));

		if (!XML_REF_ID_2.contentEquals(refId)) {
			PaymentReceiptLineListType paymentReceiptLineListType = objectFactory.createPaymentReceiptLineListType();
			for (int i = 0; i < 2; i++) {
				paymentReceiptLineListType.getPaymentReceiptLine().add(getPaymentReceiptLine(refId, i));
			}
			paymentReceiptType.setPaymentReceiptLineList(
					objectFactory.createPaymentReceiptTypePaymentReceiptLineList(paymentReceiptLineListType));
		}

		paymentReceiptType
				.setInvoiceRefId(objectFactory.createPaymentReceiptTypeInvoiceRefId(InvoiceTestData.REF_ID_1));

		DebitOrCreditAmountType receivedAmount = new DebitOrCreditAmountType();
		receivedAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
		receivedAmount.setValue(new BigDecimal(VALUE));
		receivedAmount.setType(TYPE);
		paymentReceiptType.setTransactionAmount(receivedAmount);

		paymentReceiptType.setReceivedTransactionId(TRANSACTION_ID);
		MonetaryAmountType monetaryAmountType = new MonetaryAmountType();
		monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
		monetaryAmountType.setValue(new BigDecimal(TAX_VALUE));
		paymentReceiptType.setTaxAmount(objectFactory.createPaymentReceiptTypeTaxAmount(monetaryAmountType));
		paymentReceiptType.setTaxRate(objectFactory.createPaymentReceiptTypeTaxRate(new BigDecimal(TAX_PERCENT)));
		paymentReceiptType.setTransactionDate(getDate(TRANSACTION_DATE));
		paymentReceiptType
				.setTransactionDescription(objectFactory.createPaymentReceiptTypeTransactionDescription(DESCRIPTION));

		paymentReceiptType.setTransactionMethod(objectFactory.createPaymentReceiptTypeTransactionMethod(METHOD));
		paymentReceiptType.setTransactionNote(objectFactory.createPaymentReceiptTypeTransactionNote(NOTE));
		paymentReceiptType.setTransactionType(TRANSACTION_TYPE);
		paymentReceiptType
				.setVendorInfoRefId(objectFactory.createPaymentReceiptTypeVendorInfoRefId(VendorInfoTestData.REF_ID_1));
		return paymentReceiptType;
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

	public PaymentReceiptCollectionType getTestCollection(String... refIds) {
		PaymentReceiptCollectionType result = new PaymentReceiptCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getPaymentReceipt().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "PaymentReceipt.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "PaymentReceipts.xml";
	}

}
