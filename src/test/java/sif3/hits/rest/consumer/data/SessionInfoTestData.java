package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.SessionInfoType;
import sif.dd.au30.model.SessionInfoCollectionType;

import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.rest.consumer.TeachingGroupConsumerTest;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class SessionInfoTestData extends TestData<SessionInfoType,SessionInfoCollectionType> {

    public static final String REF_ID_1 = "dc7e1520-f0f4-4a22-9ca8-48196a9d7c10";
    public static final String REF_ID_2 = "2e7e2326-1769-4131-ae68-c32d08706032";
    public static final String REF_ID_3 = "c01cf3d6-ebb1-4821-a7e0-d0f00b2ba192";
    public static final String REF_ID_4 = "d7b6f646-a712-4d94-8c75-df9d47282fe5";
    public static final String REF_ID_5 = "67271d02-ed64-4d26-86c1-461c90e43135";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "db37a040-770b-44f9-8ab6-2cffbd98204e";
    public static final String XML_REF_ID_2 = "d319fae9-ae0f-4923-a87d-447ecc594776";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public SessionInfoType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        SessionInfoType sessionInfo = new SessionInfoType();
        sessionInfo.setRefId(refId);
        sessionInfo.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        sessionInfo.setTimeTableCellRefId(TimeTableCellTestData.REF_ID_1);
        sessionInfo.setSchoolYear(getDate("2014"));
        sessionInfo.setLocalId("session local data");
        sessionInfo.setTimeTableSubjectLocalId(TimeTableSubjectTestData.LOCAL_ID);
        sessionInfo.setTeachingGroupLocalId(TeachingGroupTestData.LOCAL_ID);
        sessionInfo.setSchoolLocalId(objectFactory.createSessionInfoTypeSchoolLocalId(SchoolInfoTestData.LOCAL_ID));
        sessionInfo.setStaffPersonalLocalId(objectFactory.createSessionInfoTypeStaffPersonalLocalId(StaffPersonalTestData.LOCAL_ID));
        sessionInfo.setRoomNumber(objectFactory.createSessionInfoTypeRoomNumber(RoomInfoTestData.ROOM_NUMBER));
        sessionInfo.setDayId(TimeTableCellTestData.DAY_ID);
        sessionInfo.setPeriodId(TimeTableCellTestData.PERIOD_ID);
        sessionInfo.setSessionDate(getDate("2014-10-22"));
        sessionInfo.setStartTime(objectFactory.createSessionInfoTypeStartTime(getDate("10:00:00")));
        sessionInfo.setFinishTime(objectFactory.createSessionInfoTypeFinishTime(getDate("14:00:00")));
        sessionInfo.setRollMarked(objectFactory.createSessionInfoTypeRollMarked(AUCodeSetsYesOrNoCategoryType.Y));
        return sessionInfo;
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

    public SessionInfoCollectionType getTestCollection(String... refIds) {
        SessionInfoCollectionType result = new SessionInfoCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getSessionInfo().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "SessionInfo.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "SessionInfos.xml";
    }

}

