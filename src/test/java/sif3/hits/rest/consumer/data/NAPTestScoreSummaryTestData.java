package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class NAPTestScoreSummaryTestData extends TestData<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> {

    public static final String REF_ID_1 = "803b4ff2-34ce-44af-9675-2c2b0a2d5b7a";
    public static final String REF_ID_2 = "502cfed1-747f-42b5-86cf-8da17d308436";
    public static final String REF_ID_3 = "0b8370e6-73fa-4301-b04f-57d927a019a2";
    public static final String REF_ID_4 = "a930ddc4-b465-469b-bb5e-a530c00281c7";
    public static final String REF_ID_5 = "f5173807-c0d5-453a-9fac-1d1f74072656";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "24578b97-e3b9-4829-80d7-147feacfadf8";
    public static final String XML_REF_ID_2 = "8303c9ff-87bf-4589-87f3-157cb4a11bf0";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String NATIONAL_AVERAGE = "60.4";
    public static final String SCHOOL_AVERAGE = "55.6";
    public static final String JURISDICTION_AVERAGE = "57.6";
    public static final String TOP_60 = "75.2";
    public static final String BOTTOM_60 = "65.3";

    public NAPTestScoreSummaryType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        NAPTestScoreSummaryType napTestScoreSummaryType = new NAPTestScoreSummaryType();
        napTestScoreSummaryType.setRefId(refId);
        napTestScoreSummaryType.setSchoolInfoRefId(objectFactory.createNAPTestScoreSummaryTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        napTestScoreSummaryType.setSchoolACARAId(SchoolInfoTestData.ACARA_ID);
        napTestScoreSummaryType.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(NAPTestTestData.REF_ID_1));
        napTestScoreSummaryType.setNAPTestLocalId(NAPTestTestData.LOCAL_ID_1);
        napTestScoreSummaryType.setDomainNationalAverage(objectFactory.createNAPTestScoreSummaryTypeDomainNationalAverage(new BigDecimal(NATIONAL_AVERAGE)));
        napTestScoreSummaryType.setDomainSchoolAverage(objectFactory.createNAPTestScoreSummaryTypeDomainSchoolAverage(new BigDecimal(SCHOOL_AVERAGE)));
        napTestScoreSummaryType.setDomainJurisdictionAverage(objectFactory.createNAPTestScoreSummaryTypeDomainJurisdictionAverage(new BigDecimal(JURISDICTION_AVERAGE)));
        napTestScoreSummaryType.setDomainTopNational60Percent(objectFactory.createNAPTestScoreSummaryTypeDomainTopNational60Percent(new BigDecimal(TOP_60)));
        napTestScoreSummaryType.setDomainBottomNational60Percent(objectFactory.createNAPTestScoreSummaryTypeDomainBottomNational60Percent(new BigDecimal(BOTTOM_60)));
        return napTestScoreSummaryType;
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

    public NAPTestScoreSummaryCollectionType getTestCollection(String... refIds) {
        NAPTestScoreSummaryCollectionType result = new NAPTestScoreSummaryCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getNAPTestScoreSummary().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "NAPTestScoreSummary.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "NAPTestScoreSummarys.xml";
    }

}

