package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.TermInfoCollectionType;
import sif.dd.au30.model.TermInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class TermInfoTestData extends TestData<TermInfoType, TermInfoCollectionType> {

	public static final String REF_ID_1 = "0bee8b07-f190-43f4-918c-a37ac9fd3db0";
	public static final String REF_ID_2 = "574b5137-7cba-4600-925a-8d0be6cfa66b";
	public static final String REF_ID_3 = "66b6be22-a1c2-4fc4-ac57-ec1dd1d59a5a";
	public static final String REF_ID_4 = "18925529-507c-4837-ba98-eb954d2733bd";
	public static final String REF_ID_5 = "d7807bdb-ac6a-45a8-8f22-f13cd881eee6";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "041a790e-bf57-4cbb-825c-dd48923769a7";
	public static final String XML_REF_ID_2 = "3479e2fc-46e6-49e2-a044-8b37e19c28b1";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	@Override
	public TermInfoType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();

		TermInfoType termInfoType = objectFactory.createTermInfoType();
		// TODO: Not Yet Implemented
		return termInfoType;
	}

	@Override
	public boolean verifyAllInitialObjects() {
		return true;
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

	public TermInfoCollectionType getTestCollection(String... refIds) {
		TermInfoCollectionType result = new TermInfoCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getTermInfo().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "TermInfo.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "TermInfos.xml";
	}
}
