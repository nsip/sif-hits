package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NAPEventStudentLinkTestData extends TestData<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> {

    public static final String REF_ID_1 = "bcbf2753-7a93-4e38-b522-430dc0afae5c";
    public static final String REF_ID_2 = "2c706f8f-09de-4fb1-9a80-c0e61547ff00";
    public static final String REF_ID_3 = "d92bd55e-b15a-4664-a722-6bd87cfe15b3";
    public static final String REF_ID_4 = "cdf547a4-c951-4b0a-9166-dac116e67a8a";
    public static final String REF_ID_5 = "8f2286f8-9379-4e8b-b93e-3ff5df68ec36";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "dfc934fa-5758-414b-bdd5-081be23ee28d";
    public static final String XML_REF_ID_2 = "18fa5add-0d35-4fdc-98de-5a23d61aa2f4";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String EXEMPTION = "Did not attend";
    public static final String PARTICIPATION_CODE = "P";
    public static final String PARTICIPATION_TEXT = "Participated";
    public static final String LOCATION_TYPE = "2";
    public static final String SECTOR = "Gov";

    public static final String DISRUPTION_EVENT = "Test centre on fire";
    public static final String BOOKLET_TYPE = "Braille";
    public static final String[] PNP_CODES = {"AIA", "AIM"};

    public NAPEventStudentLinkType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        NAPEventStudentLinkType napEventStudentLinkType = new NAPEventStudentLinkType();
        napEventStudentLinkType.setRefId(refId);
        napEventStudentLinkType.setExemptionReason(objectFactory.createNAPEventStudentLinkTypeExemptionReason(EXEMPTION));
        napEventStudentLinkType.setNAPTestLocalId(NAPTestTestData.LOCAL_ID_1);
        napEventStudentLinkType.setNAPTestRefId(objectFactory.createNAPEventStudentLinkTypeNAPTestRefId(NAPTestTestData.REF_ID_1));
        napEventStudentLinkType.setParticipationCode(AUCodeSetsNAPParticipationCodeType.fromValue(PARTICIPATION_CODE));
        napEventStudentLinkType.setParticipationText(PARTICIPATION_TEXT);
        napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalTestData.PSI_ID_5);
        napEventStudentLinkType.setSchoolACARAId(SchoolInfoTestData.ACARA_ID);
        napEventStudentLinkType.setSchoolGeolocation(objectFactory.createNAPEventStudentLinkTypeSchoolGeolocation(AUCodeSetsSchoolLocationType.fromValue(LOCATION_TYPE)));
        napEventStudentLinkType.setSchoolSector(AUCodeSetsSchoolSectorCodeType.fromValue(SECTOR));
        napEventStudentLinkType.setReportingSchoolName(objectFactory.createNAPEventStudentLinkTypeReportingSchoolName(SchoolInfoTestData.SCHOOL_NAME));
        napEventStudentLinkType.setSchoolInfoRefId(objectFactory.createNAPEventStudentLinkTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_5));

        TestDisruptionListType testDisruptionListType = new TestDisruptionListType();
        TestDisruptionType testDisruptionType = new TestDisruptionType();
        testDisruptionType.setEvent(DISRUPTION_EVENT);
        testDisruptionListType.getTestDisruption().add(testDisruptionType);

        AdjustmentContainerType adjustmentType = new AdjustmentContainerType();
        adjustmentType.setBookletType(objectFactory.createAdjustmentContainerTypeBookletType(BOOKLET_TYPE));

        PNPCodeListType pnpCodeListType = new PNPCodeListType();
        for (String code : PNP_CODES) {
            pnpCodeListType.getPNPCode().add(AUCodeSetsPNPCodeType.fromValue(code));
        }
        adjustmentType.setPNPCodeList(pnpCodeListType);

        napEventStudentLinkType.setAdjustment(objectFactory.createNAPEventStudentLinkTypeAdjustment(adjustmentType));
        napEventStudentLinkType.setTestDisruptionList(objectFactory.createNAPEventStudentLinkTypeTestDisruptionList(testDisruptionListType));
        if (REF_ID_1.equals(refId)) {
            napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_1));
            napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalTestData.PSI_ID_1);
        } else if (REF_ID_2.equals(refId)) {
            napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_2));
            napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalTestData.PSI_ID_2);
        } else if (REF_ID_3.equals(refId)) {
            napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_3));
            napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalTestData.PSI_ID_3);
        } else if (REF_ID_4.equals(refId)) {
            napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_4));
            napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalTestData.PSI_ID_4);
        }

        return napEventStudentLinkType;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        List<QueryCriteria> servicePathQueries = new ArrayList<>();
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
            servicePathQueries.add(queryCriteria);
        }
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalTestData.REF_ID_1));
            servicePathQueries.add(queryCriteria);
        }
        return servicePathQueries;
    }

    @Override
    public boolean isServicePathObject(NAPEventStudentLinkType object, int index) {
        if (index == 0) {
            return object != null && SchoolInfoTestData.REF_ID_1.equals(object.getSchoolInfoRefId());
        } else if (index == 1) {
            return object != null && StudentPersonalTestData.REF_ID_1.equals(object.getStudentPersonalRefId());
        }
        return false;
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

    public NAPEventStudentLinkCollectionType getTestCollection(String... refIds) {
        NAPEventStudentLinkCollectionType result = new NAPEventStudentLinkCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getNAPEventStudentLink().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "NAPEventStudentLink.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "NAPEventStudentLinks.xml";
    }

}

