package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.FinancialAccountType;
import sif.dd.au30.model.FinancialAccountCollectionType;

import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.*;

public class FinancialAccountTestData extends TestData<FinancialAccountType, FinancialAccountCollectionType> {

	public static final String REF_ID_1 = "14db367d-cf52-4e87-b6d8-cab692c5c319";
	public static final String REF_ID_2 = "b1970375-c24b-452f-b0c4-4cd0869fd389";
	public static final String REF_ID_3 = "e70d438d-7c71-4de5-a307-1f3dfec7f216";
	public static final String REF_ID_4 = "266ffb41-db3d-47de-bf4c-567082c41402";
	public static final String REF_ID_5 = "0780ebf2-5c83-4ae1-ae10-daefef9ec09f";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "52788794-3af4-4638-8e74-b1364c244771";
	public static final String XML_REF_ID_2 = "9c03b1e9-c8ee-45a3-a0ff-9c53b238ec55";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public static final String ACCOUNT_NUMBER_1 = "98765432101";
	public static final String ACCOUNT_NUMBER_2 = "98765432102";
	public static final String ACCOUNT_NUMBER_3 = "98765432103";
	public static final String ACCOUNT_NUMBER_4 = "98765432104";
	public static final String ACCOUNT_NUMBER_5 = "98765432105";
	public static final String ACCOUNT_NUMBER_6 = "98765432106";
	public static final String ACCOUNT_NUMBER_7 = "98765432107";
	public static final String ACCOUNT_NUMBER_X = "98765432109";

	public static final Map<String, String> ACCOUNT_NUMBER_MAP = new HashMap<>();
	static {
		ACCOUNT_NUMBER_MAP.put(REF_ID_1, ACCOUNT_NUMBER_1);
		ACCOUNT_NUMBER_MAP.put(REF_ID_2, ACCOUNT_NUMBER_2);
		ACCOUNT_NUMBER_MAP.put(REF_ID_3, ACCOUNT_NUMBER_3);
		ACCOUNT_NUMBER_MAP.put(REF_ID_4, ACCOUNT_NUMBER_4);
		ACCOUNT_NUMBER_MAP.put(REF_ID_5, ACCOUNT_NUMBER_5);
		ACCOUNT_NUMBER_MAP.put(XML_REF_ID_1, ACCOUNT_NUMBER_6);
		ACCOUNT_NUMBER_MAP.put(XML_REF_ID_2, ACCOUNT_NUMBER_7);
	}

	public static final String CREATE_DATE = "2015-06-21";
	public static final String CREATE_TIME = "11:32:13";
	public static final String DESCRIPTION = "Account Description : ";
	public static final String NAME = "Account Name";
	public static final String ASSET_CLASS = "Asset";
	public static final String EXPENSE_CLASS = "Expense";

	public FinancialAccountType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		FinancialAccountType financialAccount = new FinancialAccountType();
		financialAccount.setRefId(refId);
		financialAccount.setLocalId(objectFactory.createFinancialAccountTypeLocalId("local-id"));
		financialAccount.setAccountNumber(ACCOUNT_NUMBER_MAP.getOrDefault(refId, ACCOUNT_NUMBER_X));
		financialAccount.setChargedLocationInfoRefId(
				objectFactory.createFinancialAccountTypeChargedLocationInfoRefId(ChargedLocationInfoTestData.REF_ID_1));
		financialAccount.setCreationDate(getDate(CREATE_DATE));
		financialAccount.setCreationTime(getDate(CREATE_TIME));
		financialAccount.setDescription(
				objectFactory.createFinancialAccountTypeDescription(DESCRIPTION + financialAccount.getAccountNumber()));
		financialAccount.setName(NAME);
		financialAccount.setClassType(ASSET_CLASS);
		financialAccount.setAccountCode(objectFactory.createFinancialAccountTypeAccountCode("account-code"));
		if (REF_ID_5.equals(refId)) {
			financialAccount.setClassType(EXPENSE_CLASS);
		} else if (REF_ID_4.equals(refId)) {
			financialAccount
					.setParentAccountRefId(objectFactory.createFinancialAccountTypeParentAccountRefId(REF_ID_3));
		}
		return financialAccount;
	}

	@Override
	public List<FinancialAccountType> getExamplesForQuery() {
		FinancialAccountType financialAccount = new FinancialAccountType();
		financialAccount.setClassType(EXPENSE_CLASS);
		return Arrays.asList(financialAccount);
	}

	@Override
	public boolean isExampleObject(FinancialAccountType object, int index) {
		return object != null && EXPENSE_CLASS.equals(object.getClassType());
	}

	@Override
	public List<QueryCriteria> getServicePathQueries() {
		QueryCriteria queryCriteria = new QueryCriteria();
		queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
		return Arrays.asList(queryCriteria);
	}

	@Override
	public boolean isServicePathObject(FinancialAccountType object, int index) {
		// link to school is via charged location info no way to really check if it's
		// the right school this way.
		return object != null && object.getChargedLocationInfoRefId() != null
				&& object.getChargedLocationInfoRefId().getValue() != null;
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

	public FinancialAccountCollectionType getTestCollection(String... refIds) {
		FinancialAccountCollectionType result = new FinancialAccountCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getFinancialAccount().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "FinancialAccount.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "FinancialAccounts.xml";
	}

}
