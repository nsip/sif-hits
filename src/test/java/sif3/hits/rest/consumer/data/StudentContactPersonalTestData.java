package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.utils.RefIdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentContactPersonalTestData extends TestData<StudentContactPersonalType, StudentContactPersonalCollectionType> {

    public static final String REF_ID_1 = "66d49813-1b5c-4361-bfe2-8775dfc87c3d";
    public static final String REF_ID_2 = "600608fe-6aba-4f5b-a962-8536f172e34d";
    public static final String REF_ID_3 = "47d878ae-19c1-4f45-a013-84c6bf2948ed";
    public static final String REF_ID_4 = "ecaa2dac-e549-4a69-bf64-287a6f82e365";
    public static final String REF_ID_5 = "129d6dc2-811b-43d3-b0b1-fe9fd1850e51";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "e317d9cb-e506-4b6f-8992-c046792b06c3";
    public static final String XML_REF_ID_2 = "2405a32d-49d2-49c7-8af1-5f5b838dce35";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public StudentContactPersonalType getTestObject(String refId) {
        ObjectFactory objectFactory = new ObjectFactory();

        StudentContactPersonalType studentContactPersonal = new StudentContactPersonalType();
        studentContactPersonal.setRefId(refId);
        studentContactPersonal.setEmploymentType(objectFactory.createStudentContactPersonalTypeEmploymentType(AUCodeSetsEmploymentTypeType.fromValue("1")));
        studentContactPersonal.setLocalId(objectFactory.createStudentContactPersonalTypeLocalId("local-id-scp"));
        studentContactPersonal.setNonSchoolEducation(objectFactory.createStudentContactPersonalTypeNonSchoolEducation(AUCodeSetsNonSchoolEducationType.fromValue("7")));
        studentContactPersonal
                .setSchoolEducationalLevel(objectFactory.createStudentContactPersonalTypeSchoolEducationalLevel(AUCodeSetsSchoolEducationLevelTypeType.fromValue("4")));

        PersonInfoType personInfo = new PersonInfoType();
        personInfo.setName(getNameOfRecord("Ms", "Jane", "Test", "Smith", false));

        DemographicsType demographics = new DemographicsType();
        demographics.setSex(objectFactory.createDemographicsTypeSex(AUCodeSetsSexCodeType.fromValue("2")));
        personInfo.setDemographics(objectFactory.createPersonInfoTypeDemographics(demographics));

        PhoneNumberListType phoneNumberList = new PhoneNumberListType();
        phoneNumberList.getPhoneNumber().add(getPhoneNumber("+61891234321"));
        personInfo.setPhoneNumberList(objectFactory.createPersonInfoTypePhoneNumberList(phoneNumberList));

        EmailListType emailList = new EmailListType();
        emailList.getEmail().add(getEmail("jane.smith@not.a.real.domain"));
        personInfo.setEmailList(objectFactory.createPersonInfoTypeEmailList(emailList));

        AddressListType addresses = objectFactory.createAddressListType();
        addresses.getAddress().add(getAddress("123 Address Line One", "Address Line Two"));
        addresses.getAddress().add(getAddress("234 Address Line One", null));
        personInfo.setAddressList(objectFactory.createPersonInfoTypeAddressList(addresses));

        studentContactPersonal.setPersonInfo(personInfo);
        return studentContactPersonal;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        List<QueryCriteria> servicePaths = new ArrayList<>();
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
            queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        return servicePaths;
    }

    @Override
    public boolean isServicePathObject(StudentContactPersonalType object, int index) {
        // these links happen via student contact relationship no way to tell if this is the right object here.
        return object != null && index < 3;
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

    public StudentContactPersonalCollectionType getTestCollection(String... refIds) {
        StudentContactPersonalCollectionType result = new StudentContactPersonalCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentContactPersonal().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentContactPersonal.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentContactPersonals.xml";
    }

}

