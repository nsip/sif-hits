package sif3.hits.rest.consumer.data;

import org.apache.commons.lang3.text.WordUtils;
import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class NAPTestTestData extends TestData<NAPTestType, NAPTestCollectionType> {

    public static final String REF_ID_1 = "e425c70d-2b25-4687-988e-986cad395f9c";
    public static final String REF_ID_2 = "65101395-1ace-4e41-b1af-a60b20b7f71f";
    public static final String REF_ID_3 = "5d5ac836-0e87-47c9-a316-8ae1fbfed5e8";
    public static final String REF_ID_4 = "c31020ef-21aa-421b-a4e8-243afe95ba10";
    public static final String REF_ID_5 = "a2a24ebd-c397-4a71-973d-a7a94b171694";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "990192cc-bc2e-47a0-8dba-2ea897757d03";
    public static final String XML_REF_ID_2 = "c0a7feea-865c-4add-8462-a2142650b7c8";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String LOCAL_ID_1 = "local-id-1";
    public static final String LOCAL_ID_2 = "local-id-2";
    public static final String LOCAL_ID_3 = "local-id-3";
    public static final String LOCAL_ID_4 = "local-id-4";
    public static final String LOCAL_ID_5 = "local-id-5";
    public static final String LOCAL_ID_6 = "local-id-6";
    public static final String LOCAL_ID_7 = "local-id-7";
    public static final String LOCAL_ID_X = "local-id-X";

    public static final String YEAR_3 = "3";
    public static final String YEAR_5 = "5";
    public static final String YEAR_7 = "7";
    public static final String YEAR_9 = "9";

    public static final String READING = "Reading";
    public static final String NUMERACY = "Numeracy";

    public static final String TYPE = "Normal";
    public static final String YEAR = "2015";

    public NAPTestType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        NAPTestType napTest = objectFactory.createNAPTestType();
        napTest.setRefId(refId);
        if (REF_ID_1.equals(refId)) {
            napTest.setTestContent(getTestContent(LOCAL_ID_1, YEAR_3, READING));
        } else if (REF_ID_2.equals(refId)) {
            napTest.setTestContent(getTestContent(LOCAL_ID_2, YEAR_5, READING));
        } else if (REF_ID_2.equals(refId)) {
            napTest.setTestContent(getTestContent(LOCAL_ID_3, YEAR_7, READING));
        } else if (REF_ID_2.equals(refId)) {
            napTest.setTestContent(getTestContent(LOCAL_ID_4, YEAR_9, READING));
        } else if (REF_ID_2.equals(refId)) {
            napTest.setTestContent(getTestContent(LOCAL_ID_5, YEAR_3, NUMERACY));
        } else if (REF_ID_2.equals(refId)) {
            napTest.setTestContent(getTestContent(LOCAL_ID_6, YEAR_5, NUMERACY));
        } else if (REF_ID_2.equals(refId)) {
            napTest.setTestContent(getTestContent(LOCAL_ID_7, YEAR_7, NUMERACY));
        } else {
            napTest.setTestContent(getTestContent(LOCAL_ID_X, YEAR_9, NUMERACY));
        }
        return napTest;
    }

    private NAPTestContentType getTestContent(String localId, String yearLevel, String domain) {
        NAPTestContentType napTestContent = new NAPTestContentType();
        IObjectFactory objectFactory = getObjectFactory();
        napTestContent.setNAPTestLocalId(localId);
        napTestContent.setTestName("NAPLAN " + WordUtils.capitalizeFully(domain) + " Year " + yearLevel + ", " + YEAR);
        YearLevelType yearLevelType = objectFactory.createYearLevelType();
        yearLevelType.setCode(AUCodeSetsYearLevelCodeType.fromValue(yearLevel));
        napTestContent.setTestLevel(yearLevelType);
        napTestContent.setTestType(AUCodeSetsNAPTestTypeType.fromValue(TYPE));
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.fromValue(domain));
        napTestContent.setTestYear(getDate(YEAR));
        return napTestContent;
    }

    @Override
    public List<NAPTestType> getExamplesForQuery() {
        NAPTestType napTest = new NAPTestType();
        NAPTestContentType napTestContent = new NAPTestContentType();
        napTestContent.setDomain(AUCodeSetsNAPTestDomainType.fromValue(NUMERACY));
        napTest.setTestContent(napTestContent);
        return Arrays.asList(napTest);
    }

    @Override
    public boolean isExampleObject(NAPTestType object, int index) {
        return object != null && object.getTestContent() != null && object.getTestContent().getDomain() != null && NUMERACY.equals(object.getTestContent().getDomain().value());
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

    public NAPTestCollectionType getTestCollection(String... refIds) {
        NAPTestCollectionType result = new NAPTestCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getNAPTest().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "NAPTest.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "NAPTests.xml";
    }

}

