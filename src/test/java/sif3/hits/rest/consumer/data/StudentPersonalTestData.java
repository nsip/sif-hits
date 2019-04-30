package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.service.PersonalStudentIdService;
import sif3.hits.utils.RefIdGenerator;

import java.util.*;

public class StudentPersonalTestData extends TestData<StudentPersonalType, StudentPersonalCollectionType> {

    public static final String REF_ID_1 = "c1deee9b-53ce-4c8f-9101-31bedf9c4836";
    public static final String REF_ID_2 = "e651310e-2427-45d3-80b7-0003e36001c4";
    public static final String REF_ID_3 = "3b7f7763-f63f-4c7d-a434-765913940a5c";
    public static final String REF_ID_4 = "bf9ddb87-f610-4c02-94a3-1f42c1d2ce95";
    public static final String REF_ID_5 = "a0fca96f-fb9a-4db1-8954-4a0ad0068a57";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "f62ba997-988f-494c-a78a-4e1b2acadc5c";
    public static final String XML_REF_ID_2 = "d01d3ed4-7566-464c-be5f-cb0108b29680";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);
    public static final String LOCAL_ID = "student-local-id";

    public static final String PSI_ID_1 = "R10000001E";
    public static final String PSI_ID_2 = "R10000002D";
    public static final String PSI_ID_3 = "R10000003S";
    public static final String PSI_ID_4 = "R10000004R";
    public static final String PSI_ID_5 = "R10000005G";

    public static final Map<String, String> PSI_MAP = new HashMap<>();
    static {
        PSI_MAP.put(REF_ID_1, PSI_ID_1);
        PSI_MAP.put(REF_ID_2, PSI_ID_2);
        PSI_MAP.put(REF_ID_3, PSI_ID_3);
        PSI_MAP.put(REF_ID_4, PSI_ID_4);
        PSI_MAP.put(REF_ID_5, PSI_ID_5);
    }

    public static NameOfRecordType getNameOfRecord() {
        return getNameOfRecord(null, "Jenny", "Test", "Smith");
    }

    public StudentPersonalType getTestObject(String refId) {
        ObjectFactory objectFactory = new ObjectFactory();
        StudentPersonalType studentPersonalType = new StudentPersonalType();
        studentPersonalType.setRefId(refId);
        studentPersonalType.setLocalId(LOCAL_ID);

        StudentMostRecentContainerType mostRecent = new StudentMostRecentContainerType();
        YearLevelType yearLevel = new YearLevelType();
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("3"));
        mostRecent.setYearLevel(objectFactory.createStudentMostRecentContainerTypeYearLevel(yearLevel));
        mostRecent.setParent1Language(
                objectFactory.createStudentMostRecentContainerTypeParent1Language(AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType.fromValue("1201")));
        mostRecent.setParent2Language(
                objectFactory.createStudentMostRecentContainerTypeParent2Language(AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType.fromValue("2303")));
        mostRecent.setParent1SchoolEducationLevel(
                objectFactory.createStudentMostRecentContainerTypeParent1SchoolEducationLevel(AUCodeSetsSchoolEducationLevelTypeType.fromValue("4")));
        mostRecent.setParent2SchoolEducationLevel(
                objectFactory.createStudentMostRecentContainerTypeParent2SchoolEducationLevel(AUCodeSetsSchoolEducationLevelTypeType.fromValue("0")));
        mostRecent.setParent1NonSchoolEducation(objectFactory.createStudentMostRecentContainerTypeParent1NonSchoolEducation(AUCodeSetsNonSchoolEducationType.fromValue("7")));
        mostRecent.setParent2NonSchoolEducation(objectFactory.createStudentMostRecentContainerTypeParent2NonSchoolEducation(AUCodeSetsNonSchoolEducationType.fromValue("0")));
        mostRecent.setParent1EmploymentType(objectFactory.createStudentMostRecentContainerTypeParent1EmploymentType(AUCodeSetsEmploymentTypeType.fromValue("1")));
        mostRecent.setParent2EmploymentType(objectFactory.createStudentMostRecentContainerTypeParent2EmploymentType(AUCodeSetsEmploymentTypeType.fromValue("2")));
        mostRecent.setFFPOS(objectFactory.createStudentMostRecentContainerTypeFFPOS(AUCodeSetsFFPOSStatusCodeType.fromValue("2")));
        mostRecent.setTestLevel(objectFactory.createStudentMostRecentContainerTypeTestLevel(yearLevel));
        studentPersonalType.setMostRecent(objectFactory.createStudentPersonalTypeMostRecent(mostRecent));

        PersonInfoType personInfo = new PersonInfoType();
        personInfo.setName(getNameOfRecord());

        DemographicsType demographics = new DemographicsType();
        demographics.setSex(objectFactory.createDemographicsTypeSex(AUCodeSetsSexCodeType.fromValue("1")));
        demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDate("1984-12-20")));
        demographics.setIndigenousStatus(objectFactory.createDemographicsTypeIndigenousStatus(AUCodeSetsIndigenousStatusType.fromValue("9")));
        demographics.setCountryOfBirth(objectFactory.createDemographicsTypeCountryOfBirth(AUCodeSetsStandardAustralianClassificationOfCountriesSACCType.fromValue("1101")));

        LanguageListType languageListType = new LanguageListType();
        LanguageBaseType languageBaseType = new LanguageBaseType();
        languageBaseType.setCode(AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType.fromValue("1201"));
        languageBaseType.setLanguageType(objectFactory.createLanguageBaseTypeLanguageType(AUCodeSetsLanguageTypeType.fromValue("1")));
        languageBaseType.setDialect(objectFactory.createLanguageBaseTypeDialect("West Australian"));
        languageListType.getLanguage().add(languageBaseType);
        demographics.setLanguageList(objectFactory.createDemographicsTypeLanguageList(languageListType));

        ReligionType religion = new ReligionType();
        religion.setCode(AUCodeSetsAustralianStandardClassificationOfReligiousGroupsASCRGType.fromValue("0001"));
        demographics.setReligion(objectFactory.createDemographicsTypeReligion(religion));
        personInfo.setDemographics(objectFactory.createPersonInfoTypeDemographics(demographics));

        PhoneNumberListType phoneNumberList = new PhoneNumberListType();
        phoneNumberList.getPhoneNumber().add(getPhoneNumber("+61893215432"));
        personInfo.setPhoneNumberList(objectFactory.createPersonInfoTypePhoneNumberList(phoneNumberList));

        EmailListType emailList = new EmailListType();
        emailList.getEmail().add(getEmail("jenny.smith@not.a.real.domain"));
        personInfo.setEmailList(objectFactory.createPersonInfoTypeEmailList(emailList));

        AddressListType addresses = objectFactory.createAddressListType();
        addresses.getAddress().add(getAddress("123 Address Line One", "Address Line Two"));
        addresses.getAddress().add(getAddress("234 Address Line One", null));
        personInfo.setAddressList(objectFactory.createPersonInfoTypeAddressList(addresses));
        studentPersonalType.setPersonInfo(personInfo);
        studentPersonalType.setStateProvinceId(objectFactory.createStudentPersonalTypeStateProvinceId("W123456789"));

        OtherIdListType otherIdList = new OtherIdListType();
        OtherIdType otherId = new OtherIdType();
        otherId.setType("0004");
        otherId.setValue("identifier");
        otherIdList.getOtherId().add(otherId);
        otherId = new OtherIdType();
        otherId.setType("0003");
        otherId.setValue("otherid");
        otherIdList.getOtherId().add(otherId);
        otherId = new OtherIdType();
        otherId.setType(PersonalStudentIdService.PERSONAL_STUDENT_IDENTIFIER_TYPE);
        otherId.setValue(PSI_MAP.getOrDefault(refId, PSI_ID_1));
        otherIdList.getOtherId().add(otherId);
        studentPersonalType.setOtherIdList(objectFactory.createStudentPersonalTypeOtherIdList(otherIdList));
        return studentPersonalType;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        List<QueryCriteria> servicePaths = new ArrayList<>();
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("TeachingGroups", QueryOperator.EQUAL, TeachingGroupTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        return servicePaths;
    }

    @Override
    public boolean isServicePathObject(StudentPersonalType object, int index) {
        // link happens behind the scenes, unable to determine if this student is correct here.
        return object != null && index < 2;
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

    public StudentPersonalCollectionType getTestCollection(String... refIds) {
        StudentPersonalCollectionType result = new StudentPersonalCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentPersonal().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentPersonal.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentPersonals.xml";
    }

}

