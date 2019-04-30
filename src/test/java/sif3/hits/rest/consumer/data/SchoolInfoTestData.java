package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;

import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SchoolInfoTestData extends TestData<SchoolInfoType,SchoolInfoCollectionType> {

    public static final String REF_ID_1 = "252159ce-e385-4dea-8440-26d300282781";
    public static final String REF_ID_2 = "7e323e7f-bc78-41dd-962a-b77457010be8";
    public static final String REF_ID_3 = "81b421bb-1d3c-4607-ba8b-67cba67b5447";
    public static final String REF_ID_4 = "1aa2866c-318c-49e6-9f53-731f6ba53912";
    public static final String REF_ID_5 = "7b01437a-a723-4b89-9a86-1872516ca817";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "19b819d8-c1a4-4d7c-92f6-58072defee14";
    public static final String XML_REF_ID_2 = "f02d47be-65f5-4bc9-b615-9894a09419d8";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String ACARA_ID = "48116";
    public static final String LOCAL_ID = "4001";
    public static final String SCHOOL_NAME = "Bens Test State High School";

    public SchoolInfoType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        SchoolInfoType schoolInfo = objectFactory.createSchoolInfoType();
        schoolInfo.setRefId(refId);
        schoolInfo.setACARAId(objectFactory.createSchoolInfoTypeACARAId(ACARA_ID));
        schoolInfo.setLocalId(objectFactory.createSchoolInfoTypeLocalId(LOCAL_ID));
        schoolInfo.setSchoolName(SCHOOL_NAME);
        schoolInfo.setStateProvinceId(objectFactory.createSchoolInfoTypeStateProvinceId(DEFAULT_STATE));
        schoolInfo.setCommonwealthId(objectFactory.createSchoolInfoTypeCommonwealthId("cid"));

        CampusContainerType campus = objectFactory.createCampusContainerType();
        campus.setAdminStatus(AUCodeSetsYesOrNoCategoryType.N);
        campus.setSchoolCampusId(LOCAL_ID);
        campus.setCampusType(objectFactory.createCampusContainerTypeCampusType(AUCodeSetsSchoolLevelType.SEC));
        campus.setParentSchoolId(objectFactory.createCampusContainerTypeParentSchoolId(LOCAL_ID));
        schoolInfo.setCampus(objectFactory.createSchoolInfoTypeCampus(campus));

        schoolInfo.setSchoolSector(AUCodeSetsSchoolSectorCodeType.GOV);
        schoolInfo.setOperationalStatus(objectFactory.createSchoolInfoTypeOperationalStatus(AUCodeSetsOperationalStatusType.O));
        schoolInfo.setIndependentSchool(objectFactory.createSchoolInfoTypeIndependentSchool(AUCodeSetsYesOrNoCategoryType.N));
        schoolInfo.setSchoolType(objectFactory.createSchoolInfoTypeSchoolType(AUCodeSetsSchoolLevelType.SEC));

        AddressListType addressList = objectFactory.createAddressListType();
        AddressType address = getSchoolAddress("1","School Street");
        addressList.getAddress().add(address);
        schoolInfo.setAddressList(objectFactory.createSchoolInfoTypeAddressList(addressList));

        schoolInfo.setSchoolGeographicLocation(objectFactory.createSchoolInfoTypeSchoolGeographicLocation(AUCodeSetsSchoolLocationType.fromValue("2")));
        schoolInfo.setARIA(objectFactory.createSchoolInfoTypeARIA(new BigDecimal("1")));
        schoolInfo.setEntityOpen(objectFactory.createSchoolInfoTypeEntityOpen(getDate("1990-02-01")));
        schoolInfo.setEntityClose(objectFactory.createSchoolInfoTypeEntityClose(getDate("2014-12-20")));
        return schoolInfo;
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

    public SchoolInfoCollectionType getTestCollection(String... refIds) {
        SchoolInfoCollectionType result = new SchoolInfoCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getSchoolInfo().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "SchoolInfo.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "SchoolInfos.xml";
    }

}

