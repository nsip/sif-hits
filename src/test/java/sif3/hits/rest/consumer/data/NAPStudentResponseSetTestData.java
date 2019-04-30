package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NAPStudentResponseSetTestData extends TestData<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> {

    public static final String REF_ID_1 = "18688b5b-8766-49c7-96ac-0a381ef76f37";
    public static final String REF_ID_2 = "04806e5f-f99c-44f6-bd99-7554d8ead739";
    public static final String REF_ID_3 = "7ee2074d-368b-4873-84b3-d786162f819a";
    public static final String REF_ID_4 = "8bf5b50f-875d-4d7d-88e7-ff02288f357e";
    public static final String REF_ID_5 = "815c1fc1-7c22-402d-9eac-2bccd168bd1d";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "ffc5a44b-600c-4027-b083-ff3f97fc2e4b";
    public static final String XML_REF_ID_2 = "4ff111cb-da8e-4287-9bc7-98e3db468667";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String CALIBRATION_SAMPLE = "false";
    public static final String EQUATING_SAMPLE = "false";
    public static final String PATH_TAKEN = "A9-B0-C1-D1-E8-F6";
    public static final boolean EXCLUSION = false;
    public static final String SUB_SCORE = "6";
    public static final String WEIGHT = "1";
    public static final String RESPONSE = "ezSwZRTsWP";
    public static final String CORRECT = "Correct";
    public static final String SCORE = "20";
    public static final String SUBSCORE_TYPE = "PD";
    public static final String SUBSCORE_PREFIX = "1";

    public static final String RAW_SCORE = "3.91";
    public static final String SCALED_SCORE = "48.27";
    public static final String ERROR_SCORE = "7.95";
    public static final String BAND = "8";
    public static final String PROFICIENCY = "Proficient";

    public NAPStudentResponseSetType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        NAPStudentResponseSetType napStudentResponseSetType = new NAPStudentResponseSetType();
        napStudentResponseSetType.setRefId(refId);
        napStudentResponseSetType.setCalibrationSampleFlag(objectFactory.createNAPStudentResponseSetTypeCalibrationSampleFlag(CALIBRATION_SAMPLE));
        napStudentResponseSetType.setEquatingSampleFlag(objectFactory.createNAPStudentResponseSetTypeEquatingSampleFlag(EQUATING_SAMPLE));
        napStudentResponseSetType.setNAPTestRefId(objectFactory.createNAPStudentResponseSetTypeNAPTestRefId(NAPTestTestData.REF_ID_1));
        napStudentResponseSetType.setNAPTestLocalId(NAPTestTestData.LOCAL_ID_1);
        napStudentResponseSetType.setPathTakenForDomain(objectFactory.createNAPStudentResponseSetTypePathTakenForDomain(PATH_TAKEN));
        napStudentResponseSetType.setPlatformStudentIdentifier(StudentPersonalTestData.PSI_ID_1);
        napStudentResponseSetType.setStudentPersonalRefId(objectFactory.createNAPStudentResponseSetTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_1));
        napStudentResponseSetType.setReportExclusionFlag(EXCLUSION);
        napStudentResponseSetType.setDomainScore(objectFactory.createNAPStudentResponseSetTypeDomainScore(getDomainScore()));

        NAPStudentResponseTestletListType napTestletListType = new NAPStudentResponseTestletListType();
        napTestletListType.getTestlet().add(getTestlet(NAPTestletTestData.REF_ID_1, NAPTestletTestData.LOCAL_ID));
        napStudentResponseSetType.setTestletList(objectFactory.createNAPStudentResponseSetTypeTestletList(napTestletListType));
        return napStudentResponseSetType;
    }

    private NAPTestletResponseType getTestlet(String refId, String localId) {
        IObjectFactory objectFactory = getObjectFactory();
        NAPTestletResponseType napTestletCommonType = new NAPTestletResponseType();
        napTestletCommonType.setNAPTestletLocalId(localId);
        napTestletCommonType.setNAPTestletRefId(objectFactory.createNAPTestletResponseTypeNAPTestletRefId(refId));
        napTestletCommonType.setTestletSubScore(objectFactory.createNAPTestletResponseTypeTestletSubScore(new BigDecimal(SUB_SCORE)));

        NAPTestletItemResponseListType napTestletItemListType = new NAPTestletItemResponseListType();
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemTestData.REF_ID_1, NAPTestItemTestData.LOCAL_ID_1, 1));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemTestData.REF_ID_2, NAPTestItemTestData.LOCAL_ID_2, 2));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemTestData.REF_ID_3, NAPTestItemTestData.LOCAL_ID_3, 3));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemTestData.REF_ID_4, NAPTestItemTestData.LOCAL_ID_4, 4));
        napTestletItemListType.getItemResponse().add(getNAPTestletItem(NAPTestItemTestData.REF_ID_5, NAPTestItemTestData.LOCAL_ID_5, 5));
        napTestletCommonType.setItemResponseList(napTestletItemListType);

        return napTestletCommonType;
    }

    private NAPTestletResponseItemType getNAPTestletItem(String refId, String localId, int index) {
        IObjectFactory objectFactory = getObjectFactory();
        NAPTestletResponseItemType napTestletItemType = new NAPTestletResponseItemType();
        napTestletItemType.setItemWeight(new BigDecimal(WEIGHT + index));
        napTestletItemType.setNAPTestItemLocalId(localId);
        napTestletItemType.setNAPTestItemRefId(objectFactory.createNAPTestletResponseItemTypeNAPTestItemRefId(refId));
        napTestletItemType.setResponse(objectFactory.createNAPTestletResponseItemTypeResponse(RESPONSE + index));
        napTestletItemType.setResponseCorrectness(AUCodeSetsNAPResponseCorrectnessType.fromValue(CORRECT));
        napTestletItemType.setScore(objectFactory.createNAPTestletResponseItemTypeScore(new BigDecimal(SCORE)));
        napTestletItemType.setSequenceNumber(new BigInteger("" + index));

        NAPSubscoreListType napSubscoreListType = new NAPSubscoreListType();
        napSubscoreListType.getSubscore().add(getSubscore(index, 1));
        napSubscoreListType.getSubscore().add(getSubscore(index, 2));
        napTestletItemType.setSubscoreList(objectFactory.createNAPTestletResponseItemTypeSubscoreList(napSubscoreListType));

        return napTestletItemType;
    }

    private NAPSubscoreType getSubscore(int index, int i) {
        NAPSubscoreType napSubscoreType = new NAPSubscoreType();
        napSubscoreType.setSubscoreType(SUBSCORE_TYPE);
        napSubscoreType.setSubscoreValue(new BigDecimal(SUBSCORE_PREFIX + index + "" + i));
        return napSubscoreType;
    }

    private DomainScoreType getDomainScore() {
        ObjectFactory objectFactory = new ObjectFactory();
        DomainScoreType domainScoreType = new DomainScoreType();
        domainScoreType.setRawScore(new BigDecimal(RAW_SCORE));
        domainScoreType.setScaledScoreValue(new BigDecimal(SCALED_SCORE));
        domainScoreType.setScaledScoreStandardError(new BigDecimal(ERROR_SCORE));
        domainScoreType.setStudentDomainBand(new BigInteger(BAND));
        domainScoreType.setStudentProficiency(objectFactory.createDomainScoreTypeStudentProficiency(PROFICIENCY));
        return domainScoreType;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        List<QueryCriteria> servicePaths = new ArrayList<>();
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        {
            QueryCriteria queryCriteria = new QueryCriteria();
            queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalTestData.REF_ID_1));
            servicePaths.add(queryCriteria);
        }
        return servicePaths;
    }

    @Override
    public boolean isServicePathObject(NAPStudentResponseSetType object, int index) {
        if (index == 0) {
            // school linked through student no way to tell where that student is enrolled.
            return object != null && object.getStudentPersonalRefId() != null && object.getStudentPersonalRefId().getValue() != null;
        } else if (index == 1) {
            return object != null && object.getStudentPersonalRefId() != null && StudentPersonalTestData.REF_ID_1.equals(object.getStudentPersonalRefId().getValue());
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

    public NAPStudentResponseSetCollectionType getTestCollection(String... refIds) {
        NAPStudentResponseSetCollectionType result = new NAPStudentResponseSetCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getNAPStudentResponseSet().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "NAPStudentResponseSet.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "NAPStudentResponseSets.xml";
    }

}

