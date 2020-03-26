package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.LearningStandardItemCollectionType;
import sif.dd.au30.model.LearningStandardItemType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class LearningStandardItemTestData
		extends TestData<LearningStandardItemType, LearningStandardItemCollectionType> {

	public static final String REF_ID_1 = "d4ed839a-5445-4b34-8189-a8aaab598e33";
	public static final String REF_ID_2 = "c11a5f65-2b2f-4b1a-a76e-8795a9f4e710";
	public static final String REF_ID_3 = "0dbbfef6-95fd-42f8-a01f-2e5e0b7c2f52";
	public static final String REF_ID_4 = "a26bbf7f-2afa-4584-92c9-e9e58f804576";
	public static final String REF_ID_5 = "698be0bc-a881-4673-bca3-89159c97f779";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "c7750374-724c-426b-999a-8499835eb999";
	public static final String XML_REF_ID_2 = "edd33589-bad7-4f1f-97a8-1a755cdecfdd";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	@Override
	public LearningStandardItemType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();

		LearningStandardItemType learningStandardItemType = objectFactory.createLearningStandardItemType();
		// TODO: Not Yet Implemented
		return learningStandardItemType;
	}

	@Override
	public boolean verifyAllInitialObjects() {
		return true;
	}

	public static String getSharedRefId(int index) {
		String result = null;
		if (index >= 0 && index < REF_ID_RA.length) {
			result = REF_ID_RA[index];
		} else {
			result = RefIdGenerator.getRefId();
		}
		return result;
	}

	public String getRefId(int index) {
		return LearningStandardItemTestData.getSharedRefId(index);
	}

	public LearningStandardItemCollectionType getTestCollection(String... refIds) {
		LearningStandardItemCollectionType result = new LearningStandardItemCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getLearningStandardItem().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "LearningStandardItem.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "LearningStandardItems.xml";
	}
}
