package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.FinancialQuestionnaireCollectionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireCollectionType;
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
		FinancialQuestionnaireCollectionType financialQuestionnaire = new FinancialQuestionnaireCollectionType();
		financialQuestionnaire.setRefId(refId);
		
		return financialQuestionnaire;
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
