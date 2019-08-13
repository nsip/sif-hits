package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class ChargedLocationInfoTestData extends TestData<ChargedLocationInfoType,ChargedLocationInfoCollectionType> {

    public static final String REF_ID_1 = "b5918074-f965-49b7-80b9-cec3270eda48";
    public static final String REF_ID_2 = "fcc9d907-51fe-40e8-a185-0598ce6eef6e";
    public static final String REF_ID_3 = "05ad470f-c47f-44d0-a719-06d1e328239f";
    public static final String REF_ID_4 = "46a2452a-4fcc-4d98-ab43-e426195e97d5";
    public static final String REF_ID_5 = "8e3e09b6-0af9-4bd6-9a64-1586486b7a6f";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "db4d6cdc-7e6e-403e-b501-ad02cab89d4f";
    public static final String XML_REF_ID_2 = "7f2165ba-413c-4959-85fe-6ba5fce623e5";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String DESCRIPTION = "charged location description";
    public static final String LOCAL_ID = "cl-local-id";
    public static final String LOCATION_TYPE = "School";
    public static final String NAME = "Main Campus";
    public static final String SITE_CATEGORY = "Campus";
    public static final String PHONE_NUMBER = "0891231234";
    public static final String ADDRESS = "1 Some Street";

    public ChargedLocationInfoType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        ChargedLocationInfoType locationInfo = new ChargedLocationInfoType();
        locationInfo.setRefId(refId);
        locationInfo.setDescription(objectFactory.createChargedLocationInfoTypeDescription(DESCRIPTION));
        locationInfo.setLocalId(objectFactory.createChargedLocationInfoTypeLocalId(LOCAL_ID));
        locationInfo.setLocationType(LOCATION_TYPE);
        locationInfo.setName(NAME);

        PhoneNumberListType phoneNumberList = objectFactory.createPhoneNumberListType();
        phoneNumberList.getPhoneNumber().add(getPhoneNumber(PHONE_NUMBER));
        locationInfo.setPhoneNumberList(objectFactory.createChargedLocationInfoTypePhoneNumberList(phoneNumberList));

        locationInfo.setSchoolInfoRefId(objectFactory.createChargedLocationInfoTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        locationInfo.setSiteCategory(SITE_CATEGORY);
        locationInfo.setStateProvinceId(objectFactory.createChargedLocationInfoTypeStateProvinceId(DEFAULT_STATE));

        AddressListType addressList = objectFactory.createAddressListType();
        addressList.getAddress().add(getAddress(ADDRESS, null));
        locationInfo.setAddressList(objectFactory.createDebtorTypeAddressList(addressList));
        return locationInfo;
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

    public ChargedLocationInfoCollectionType getTestCollection(String... refIds) {
        ChargedLocationInfoCollectionType result = new ChargedLocationInfoCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getChargedLocationInfo().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "ChargedLocationInfo.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "ChargedLocationInfos.xml";
    }

}

