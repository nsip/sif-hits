package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsWellbeingAlertCategoryType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.WellbeingAlertCollectionType;
import sif.dd.au30.model.WellbeingAlertType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class WellbeingAlertTestData extends TestData<WellbeingAlertType,WellbeingAlertCollectionType> {

    public static final String REF_ID_1 = "175a74bb-d05e-4d50-818d-19dba2758664";
    public static final String REF_ID_2 = "16c9fbbf-4d12-4b78-86f5-aa625424147d";
    public static final String REF_ID_3 = "c30fadbd-e998-427b-aa00-2a91511973d6";
    public static final String REF_ID_4 = "bf893e10-6707-46c8-99ea-fae3d5a8934d";
    public static final String REF_ID_5 = "13b5e1cb-f4f9-4b57-a0f0-06d54dfc867f";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "659a1f1e-752b-4e4e-817b-380a3448d199";
    public static final String XML_REF_ID_2 = "a6ffe381-c2fd-4de8-aac9-af5cec8d73b2";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public WellbeingAlertType getTestObject(String refId){
        IObjectFactory objectFactory = getObjectFactory();
        WellbeingAlertType wellbeingAlertType = objectFactory.createWellbeingAlertType();
        wellbeingAlertType.setRefId(refId);
        wellbeingAlertType.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_1);
        wellbeingAlertType.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        wellbeingAlertType.setDate(getDate("2018-03-23"));
        wellbeingAlertType.setWellbeingAlertStartDate(objectFactory.createWellbeingAlertTypeWellbeingAlertStartDate(getDate("2018-03-24")));
        wellbeingAlertType.setWellbeingAlertEndDate(objectFactory.createWellbeingAlertTypeWellbeingAlertEndDate(getDate("2018-04-22")));
        wellbeingAlertType.setWellbeingAlertCategory(objectFactory.createWellbeingAlertTypeWellbeingAlertCategory(AUCodeSetsWellbeingAlertCategoryType.D));
        wellbeingAlertType.setWellbeingAlertDescription(objectFactory.createWellbeingAlertTypeWellbeingAlertDescription("Danger Danger"));
        wellbeingAlertType.setEnrolmentRestricted(objectFactory.createWellbeingAlertTypeEnrolmentRestricted(AUCodeSetsYesOrNoCategoryType.N));
        wellbeingAlertType.setAlertAudience(objectFactory.createWellbeingAlertTypeAlertAudience("People"));
        wellbeingAlertType.setAlertSeverity(objectFactory.createWellbeingAlertTypeAlertSeverity("Severe"));
        wellbeingAlertType.setAlertKeyContact(objectFactory.createWellbeingAlertTypeAlertKeyContact("James Smith"));
        return wellbeingAlertType;
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

    public WellbeingAlertCollectionType getTestCollection(String... refIds) {
        WellbeingAlertCollectionType result = new WellbeingAlertCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getWellbeingAlert().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "WellbeingAlert.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "WellbeingAlerts.xml";
    }

}

