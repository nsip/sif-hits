package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.JournalAdjustmentListType;
import sif.dd.au30.model.JournalAdjustmentType;
import sif.dd.au30.model.JournalCollectionType;
import sif.dd.au30.model.JournalType;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class JournalTestData extends TestData<JournalType, JournalCollectionType> {

	public static final String REF_ID_1 = "c5c30b9f-dc1d-486a-bcd6-509a8b776808";
	public static final String REF_ID_2 = "6e678e76-0b3c-4ec6-bc6d-44990691e003";
	public static final String REF_ID_3 = "c4111bdf-3ea9-4507-97f3-f2133877dd3c";
	public static final String REF_ID_4 = "83f58075-88ab-467c-851e-3f6ea6af1919";
	public static final String REF_ID_5 = "9bebd601-f1d2-4ac1-8d49-1987a02f67c8";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "b5a60365-0e4b-4938-87fc-bb91f1f5500f";
	public static final String XML_REF_ID_2 = "3cb7602e-9cae-4f4a-807f-bc939ddf2ee5";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public static final String APPROVED_BY = "Mike Approver";
	public static final String APPROVED_DATE = "2015-06-22";
	public static final String CREATED_BY = "John Creator";
	public static final String CREATED_DATE = "2015-05-31";
	public static final String GST_CODE = "G6";
	public static final String NOTE = "Notes about this Journal entry.";
	public static final String AMOUNT = "400.00";

	public static final String ORIGINATING_TRANSACTION = "Invoice";

	public JournalType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		JournalType journalType = objectFactory.createJournalType();
		journalType.setRefId(refId);
		journalType.setLocalId(objectFactory.createJournalTypeLocalId("local-id"));

		MonetaryAmountType monetaryAmount = new MonetaryAmountType();
		monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
		monetaryAmount.setValue(new BigDecimal(AMOUNT));
		journalType.setAmount(monetaryAmount);

		journalType.setApprovedBy(objectFactory.createJournalTypeApprovedBy(APPROVED_BY));
		journalType.setApprovedDate(objectFactory.createJournalTypeApprovedDate(getDate(APPROVED_DATE)));
		journalType.setCreatedBy(objectFactory.createJournalTypeCreatedBy(CREATED_BY));
		journalType.setCreatedDate(objectFactory.createJournalTypeCreatedDate(getDate(CREATED_DATE)));
		journalType.setCreditFinancialAccountRefId(
				objectFactory.createJournalTypeCreditFinancialAccountRefId(FinancialAccountTestData.REF_ID_1));
		journalType.setCreditAccountCode(objectFactory.createJournalTypeCreditAccountCode("credit-ac"));
		journalType.setDebitFinancialAccountRefId(
				objectFactory.createJournalTypeDebitFinancialAccountRefId(FinancialAccountTestData.REF_ID_2));
		journalType.setDebitAccountCode(objectFactory.createJournalTypeDebitAccountCode("debit-ac"));
		journalType.setGSTCodeOriginal(objectFactory.createJournalTypeGSTCodeOriginal(GST_CODE));
		journalType.setGSTCodeReplacement(objectFactory.createJournalTypeGSTCodeReplacement(GST_CODE));
		journalType.setNote(objectFactory.createJournalTypeNote(NOTE));

		JournalType.OriginatingTransactionRefId originatingTransactionRefId = new JournalType.OriginatingTransactionRefId();
		originatingTransactionRefId.setValue(InvoiceTestData.REF_ID_1);
		originatingTransactionRefId.setSIFRefObject(ORIGINATING_TRANSACTION);
		journalType.setOriginatingTransactionRefId(
				objectFactory.createJournalTypeOriginatingTransactionRefId(originatingTransactionRefId));

		JournalAdjustmentListType journalAdjustmentListType = objectFactory.createJournalAdjustmentListType();
		journalAdjustmentListType.getJournalAdjustment().add(getJournalAdjustment(1));
		journalAdjustmentListType.getJournalAdjustment().add(getJournalAdjustment(2));
		journalType.setJournalAdjustmentList(
				objectFactory.createJournalTypeJournalAdjustmentList(journalAdjustmentListType));
		return journalType;
	}

	public JournalAdjustmentType getJournalAdjustment(int index) {
		IObjectFactory objectFactory = getObjectFactory();
		JournalAdjustmentType journalAdjustmentType = objectFactory.createJournalAdjustmentType();

		journalAdjustmentType.setDebitFinancialAccountRefId(
				objectFactory.createJournalAdjustmentTypeDebitFinancialAccountRefId(FinancialAccountTestData.REF_ID_2));
		journalAdjustmentType.setCreditFinancialAccountRefId(objectFactory
				.createJournalAdjustmentTypeCreditFinancialAccountRefId(FinancialAccountTestData.REF_ID_1));
		journalAdjustmentType
				.setDebitAccountCode(objectFactory.createJournalAdjustmentTypeDebitAccountCode("debit-ac-" + index));
		journalAdjustmentType
				.setCreditAccountCode(objectFactory.createJournalAdjustmentTypeCreditAccountCode("credit-ac-" + index));
		journalAdjustmentType
				.setGSTCodeOriginal(objectFactory.createJournalAdjustmentTypeGSTCodeOriginal("gst-orig-" + index));
		journalAdjustmentType.setGSTCodeReplacement(
				objectFactory.createJournalAdjustmentTypeGSTCodeReplacement("gst-repl-" + index));

		MonetaryAmountType lineAdjustmentAmount = objectFactory.createMonetaryAmountType();
		lineAdjustmentAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
		lineAdjustmentAmount.setValue(new BigDecimal("1" + index + "0.00"));
		journalAdjustmentType.setLineAdjustmentAmount(lineAdjustmentAmount);

		return journalAdjustmentType;
	}

	@Override
	public List<QueryCriteria> getServicePathQueries() {
		QueryCriteria queryCriteria = new QueryCriteria();
		queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
		return Arrays.asList(queryCriteria);
	}

	@Override
	public boolean isServicePathObject(JournalType object, int index) {
		// link to school is via account and then via charged location info no way to
		// really check if it's the right school this way.
		return object != null
				&& (object.getCreditFinancialAccountRefId() != null || object.getDebitFinancialAccountRefId() != null);
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

	public JournalCollectionType getTestCollection(String... refIds) {
		JournalCollectionType result = new JournalCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getJournal().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "Journal.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "Journals.xml";
	}

}
