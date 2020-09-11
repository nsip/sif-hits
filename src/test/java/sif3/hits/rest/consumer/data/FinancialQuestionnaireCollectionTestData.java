package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AGRuleListType;
import sif.dd.au30.model.AGRuleType;
import sif.dd.au30.model.FQContextualQuestionListType;
import sif.dd.au30.model.FQContextualQuestionType;
import sif.dd.au30.model.FQItemListType;
import sif.dd.au30.model.FQItemType;
import sif.dd.au30.model.FQReportingListType;
import sif.dd.au30.model.FQReportingType;
import sif.dd.au30.model.FinancialQuestionnaireCollectionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireCollectionType;
import sif.dd.au30.model.LocalCodeListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class FinancialQuestionnaireCollectionTestData
		extends TestData<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollectionCollectionType> {

	public static final String REF_ID_1 = "6a6db355-8f30-4e54-87a5-7eaf9f762b92";
	public static final String REF_ID_2 = "0d16c8e8-7534-4bc1-a074-a253e3b125c8";
	public static final String REF_ID_3 = "751a4a76-f514-4a9f-8067-d403a0278b19";
	public static final String REF_ID_4 = "e83c09d4-5787-42ef-ab3a-d2fd07f2e245";
	public static final String REF_ID_5 = "59eaca77-a4b9-419a-8cd7-2863776f42e5";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "d9743b6b-881b-4441-b82e-65b55b1ac3be";
	public static final String XML_REF_ID_2 = "de60e300-7259-4909-bd69-a3bcee3c7159";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public FinancialQuestionnaireCollectionType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		FinancialQuestionnaireCollectionType financialQuestionnaire = objectFactory
				.createFinancialQuestionnaireCollectionType();
		financialQuestionnaire.setRefId(refId);

		financialQuestionnaire.setFQYear(getDate("2020"));
		financialQuestionnaire.setRoundCode("RC");
		financialQuestionnaire.setReportingAuthorityCommonwealthId("RACID");
		financialQuestionnaire.setSoftwareVendorInfo(getSoftwareVendorInfo("SoftwareProduct", "2.12.0r1234"));

		LocalCodeListType localCodeListType = objectFactory.createLocalCodeListType();
		for (int i = 1; i < 3; i++) {
			localCodeListType.getLocalCode().add(getLocalCode(i));
		}
		financialQuestionnaire
				.setLocalCodeList(objectFactory.createAddressCollectionTypeLocalCodeList(localCodeListType));

		FQReportingListType fqReportingListType = objectFactory.createFQReportingListType();
		for (int i = 1; i < 5; i++) {
			fqReportingListType.getFQReporting().add(getFQReporting(i));
		}
		financialQuestionnaire.setFQReportingList(
				objectFactory.createFinancialQuestionnaireCollectionTypeFQReportingList(fqReportingListType));

		return financialQuestionnaire;
	}

	private FQReportingType getFQReporting(int i) {
		IObjectFactory objectFactory = getObjectFactory();
		FQReportingType fqReportingType = objectFactory.createFQReportingType();
		fqReportingType.setEntityLevel("System");
		fqReportingType
				.setSchoolInfoRefId(objectFactory.createFQReportingTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
		fqReportingType.setLocalId(objectFactory.createFQReportingTypeLocalId("LocalId"));
		fqReportingType.setStateProvinceId(objectFactory.createFQReportingTypeStateProvinceId("SPID"));
		fqReportingType.setCommonwealthId(SchoolInfoTestData.LOCAL_ID);
		fqReportingType.setACARAId(objectFactory.createFQReportingTypeACARAId(SchoolInfoTestData.ACARA_ID));
		fqReportingType.setEntityName(objectFactory.createFQReportingTypeEntityName(SchoolInfoTestData.SCHOOL_NAME));
		fqReportingType.setEntityContact(getEntityContact());

		FQContextualQuestionListType fqContextualQuestionListType = objectFactory.createFQContextualQuestionListType();
		for (int j = 1; j < 6; j++) {
			fqContextualQuestionListType.getFQContextualQuestion().add(getContextualQuestion(i, j));
		}
		fqReportingType.setFQContextualQuestionList(
				objectFactory.createFQReportingTypeFQContextualQuestionList(fqContextualQuestionListType));

		FQItemListType fqItemListType = objectFactory.createFQItemListType();
		for (int j = 1; j < 6; j++) {
			fqItemListType.getFQItem().add(getFQItem(i, j));
		}
		fqReportingType.setFQItemList(fqItemListType);

		AGRuleListType agRuleListType = objectFactory.createAGRuleListType();
		for (int j = 1; j < 6; j++) {
			agRuleListType.getAGRule().add(getAGRule(i, j));
		}
		fqReportingType.setAGRuleList(objectFactory.createFQReportingTypeAGRuleList(agRuleListType));
		return fqReportingType;
	}

	private AGRuleType getAGRule(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		AGRuleType agRuleType = objectFactory.createAGRuleType();
		agRuleType.setAGRuleCode(objectFactory.createAGRuleTypeAGRuleCode("Code-" + i + "-" + j));
		agRuleType.setAGRuleComment(objectFactory.createAGRuleTypeAGRuleComment("Comment + " + i + "-" + j));
		agRuleType.setAGRuleResponse(objectFactory.createAGRuleTypeAGRuleResponse("Response"));
		agRuleType.setAGRuleStatus(objectFactory.createAGRuleTypeAGRuleStatus("OK"));
		return agRuleType;
	}

	private FQContextualQuestionType getContextualQuestion(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		FQContextualQuestionType fqContextualQuestionType = objectFactory.createFQContextualQuestionType();
		fqContextualQuestionType.setFQContext("Context-" + i + "-" + j);
		fqContextualQuestionType.setFQAnswer("Answer " + i + " " + j);
		return fqContextualQuestionType;
	}

	private FQItemType getFQItem(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		FQItemType fqItemType = objectFactory.createFQItemType();
		fqItemType.setFQItemCode("IC-" + i + j + "." + j);
		fqItemType.setTuitionAmount(objectFactory.createFQItemTypeTuitionAmount(new BigDecimal("1" + i + j + ".23")));
		fqItemType.setBoardingAmount(objectFactory.createFQItemTypeBoardingAmount(BigDecimal.ZERO));
		fqItemType.setSystemAmount(
				objectFactory.createFQItemTypeSystemAmount(new BigDecimal("" + j + i + "." + i + "0")));
		fqItemType.setDioceseAmount(objectFactory.createFQItemTypeDioceseAmount(BigDecimal.ZERO));
		fqItemType.setFQComments(objectFactory.createFQItemTypeFQComments("Comments"));
		return fqItemType;
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

	public FinancialQuestionnaireCollectionCollectionType getTestCollection(String... refIds) {
		FinancialQuestionnaireCollectionCollectionType result = new FinancialQuestionnaireCollectionCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getFinancialQuestionnaireCollection().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "FinancialQuestionnaireCollection.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "FinancialQuestionnaireCollections.xml";
	}

}
