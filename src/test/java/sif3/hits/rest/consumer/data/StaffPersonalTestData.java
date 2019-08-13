package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class StaffPersonalTestData extends TestData<StaffPersonalType, StaffPersonalCollectionType> {

    public static final String REF_ID_1 = "db065c11-e493-4a84-9ca6-c140b22e71f9";
    public static final String REF_ID_2 = "e326d2e6-ef77-4540-8933-106a3aec9c63";
    public static final String REF_ID_3 = "23354050-ceaf-4581-904d-4ff94be65afb";
    public static final String REF_ID_4 = "c7e28b89-1f3b-4d89-9dab-f12b743dae6c";
    public static final String REF_ID_5 = "2a0f3bb9-54a4-45da-a70f-c1364b9b973b";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "c25f3969-7c3d-4c9c-bb07-7a8f3749c87b";
    public static final String XML_REF_ID_2 = "fdf232e5-0078-44f6-99ee-6f587a0a0df5";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);
    public static final String LOCAL_ID = "local-id-sp";

    public static NameOfRecordType getNameOfRecord() {
        return getNameOfRecord("Mr", "John", "Test", "Smith");
    }


    public StaffPersonalType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        StaffPersonalType staffPersonalType = new StaffPersonalType();
        staffPersonalType.setRefId(refId);
        staffPersonalType.setLocalId(LOCAL_ID);

        PersonInfoType personInfo = new PersonInfoType();
        personInfo.setName(getNameOfRecord());

        DemographicsType demographics = new DemographicsType();
        demographics.setInterpreterRequired(objectFactory.createDemographicsTypeInterpreterRequired(AUCodeSetsYesOrNoCategoryType.fromValue("N")));
        demographics.setSex(objectFactory.createDemographicsTypeSex(AUCodeSetsSexCodeType.fromValue("1")));
        demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDate("1984-12-20")));
        personInfo.setDemographics(objectFactory.createPersonInfoTypeDemographics(demographics));

        PhoneNumberListType phoneNumberList = new PhoneNumberListType();
        phoneNumberList.getPhoneNumber().add(getPhoneNumber("+61891231234"));
        personInfo.setPhoneNumberList(objectFactory.createPersonInfoTypePhoneNumberList(phoneNumberList));

        EmailListType emailList = new EmailListType();
        emailList.getEmail().add(getEmail("john.smith@not.a.real.domain"));
        personInfo.setEmailList(objectFactory.createPersonInfoTypeEmailList(emailList));

        staffPersonalType.setPersonInfo(personInfo);

        staffPersonalType.setEmploymentStatus(objectFactory.createStaffPersonalTypeEmploymentStatus(AUCodeSetsStaffStatusType.A));
        staffPersonalType.setStateProvinceId(objectFactory.createStaffPersonalTypeStateProvinceId(DEFAULT_STATE));

        OtherIdListType otherIdList = new OtherIdListType();
        OtherIdType otherId = new OtherIdType();
        otherId.setType("0004");
        otherId.setValue("identifier");
        otherIdList.getOtherId().add(otherId);
        otherId = new OtherIdType();
        otherId.setType("0003");
        otherId.setValue("otherid");
        otherIdList.getOtherId().add(otherId);
        staffPersonalType.setOtherIdList(objectFactory.createStaffPersonalTypeOtherIdList(otherIdList));
        return staffPersonalType;
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

    public StaffPersonalCollectionType getTestCollection(String... refIds) {
        StaffPersonalCollectionType result = new StaffPersonalCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStaffPersonal().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StaffPersonal.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StaffPersonals.xml";
    }

}

