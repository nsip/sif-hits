package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AddressCollectionCollectionType;
import sif.dd.au30.model.AddressCollectionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class AddressCollectionTestData extends TestData<AddressCollectionType, AddressCollectionCollectionType> {

	public static final String REF_ID_1 = "abcde421-8fd0-4f4c-baac-7edb1fb3b324";
	public static final String REF_ID_2 = "440cc7b5-6fa6-4f72-823d-49ed189d7ae3";
	public static final String REF_ID_3 = "1ec7bd63-ddb0-42ce-b049-061dc7666571";
	public static final String REF_ID_4 = "c4808c07-1b72-490e-9a70-2056deeba7cd";
	public static final String REF_ID_5 = "9e7b31de-fc05-4b62-8566-7ad5005e3756";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "2939f015-4bd7-4762-b332-3456debebf0c";
	public static final String XML_REF_ID_2 = "034c4655-4645-43b9-a493-65cc341c7032";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public AddressCollectionType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();

		AddressCollectionType addressCollection = new AddressCollectionType();
		addressCollection.setRefId(refId);

		return addressCollection;
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

	public AddressCollectionCollectionType getTestCollection(String... refIds) {
		AddressCollectionCollectionType result = new AddressCollectionCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getAddressCollection().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "AddressCollection.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "AddressCollections.xml";
	}

}
