package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.RoomInfoCollectionType;
import sif.dd.au30.model.RoomInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class RoomInfoTestData extends TestData<RoomInfoType, RoomInfoCollectionType> {

    public static final String REF_ID_1 = "ec19f8a1-f4f8-43b9-9640-ad8486accfbe";
    public static final String REF_ID_2 = "89fc6e98-2a2d-4bf8-89b5-fba4c02c7c48";
    public static final String REF_ID_3 = "4b59c33c-4e64-49a4-8be5-31fe3888289e";
    public static final String REF_ID_4 = "7d172e08-0169-4229-9343-14fe28970e27";
    public static final String REF_ID_5 = "ab63b702-ffb4-4953-9cbf-ebb3125619bb";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "bb89d236-87c6-45cd-9dd1-db1278f5fe4d";
    public static final String XML_REF_ID_2 = "ae006427-d7bd-4f8e-9564-24b93787e7eb";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String ROOM_NUMBER = "R43";
    public static final String DESCRIPTION = "Room Description";
    public static final Long CAPACITY = 20L;
    public static final String SIZE = "29.8";
    public static final String TYPE = "C";
    public static final String LOCAL_ID = "local-id-ri";

    public RoomInfoType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        RoomInfoType roomInfo = new RoomInfoType();
        roomInfo.setRefId(refId);
        roomInfo.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        roomInfo.setRoomNumber(ROOM_NUMBER);
        roomInfo.setDescription(objectFactory.createRoomInfoTypeDescription(DESCRIPTION));
        roomInfo.setCapacity(objectFactory.createRoomInfoTypeCapacity(CAPACITY));
        roomInfo.setSize(objectFactory.createRoomInfoTypeSize(new BigDecimal(SIZE)));
        roomInfo.setRoomType(objectFactory.createRoomInfoTypeRoomType(TYPE));
        roomInfo.setLocalId(objectFactory.createRoomInfoTypeLocalId(LOCAL_ID));
        return roomInfo;
    }

    @Override
    public List<RoomInfoType> getExamplesForQuery() {
        RoomInfoType roomInfo = new RoomInfoType();
        roomInfo.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        return Arrays.asList(roomInfo);
    }

    @Override
    public boolean isExampleObject(RoomInfoType object, int index) {
        return object != null && SchoolInfoTestData.REF_ID_1.equals(object.getSchoolInfoRefId());
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

    public RoomInfoCollectionType getTestCollection(String... refIds) {
        RoomInfoCollectionType result = new RoomInfoCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getRoomInfo().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "RoomInfo.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "RoomInfos.xml";
    }

}

