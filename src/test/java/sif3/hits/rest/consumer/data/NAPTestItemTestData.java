package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NAPTestItemTestData extends TestData<NAPTestItemType, NAPTestItemCollectionType> {

    public static final String REF_ID_1 = "93fb8237-6e27-4dd6-aed9-03d53bc87b9a";
    public static final String REF_ID_2 = "826f8a2d-9d49-45f3-b5c6-7e1898ad4ea5";
    public static final String REF_ID_3 = "5d8c5dff-5cfa-4d5a-bbeb-c1c6badf07cb";
    public static final String REF_ID_4 = "4a7c981c-921f-410f-8535-18e484c456ec";
    public static final String REF_ID_5 = "b6d7db50-7aed-411a-b7cb-b06b0e6b9caf";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "72fbb478-2555-4d88-8e24-d9be4ee22d23";
    public static final String XML_REF_ID_2 = "24fb7e23-60b9-4bed-aa27-39e8f1fab114";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String LOCAL_ID_1 = "local-id-nti-1";
    public static final String LOCAL_ID_2 = "local-id-nti-2";
    public static final String LOCAL_ID_3 = "local-id-nti-3";
    public static final String LOCAL_ID_4 = "local-id-nti-4";
    public static final String LOCAL_ID_5 = "local-id-nti-5";
    public static final String LOCAL_ID_6 = "local-id-nti-6";
    public static final String LOCAL_ID_7 = "local-id-nti-7";
    public static final String LOCAL_ID_X = "local-id-nti-X";

    public static final Map<String, String> LOCAL_ID_MAP = new HashMap<>();


    static {
        LOCAL_ID_MAP.put(REF_ID_1, LOCAL_ID_1);
        LOCAL_ID_MAP.put(REF_ID_2, LOCAL_ID_2);
        LOCAL_ID_MAP.put(REF_ID_3, LOCAL_ID_3);
        LOCAL_ID_MAP.put(REF_ID_4, LOCAL_ID_4);
        LOCAL_ID_MAP.put(REF_ID_5, LOCAL_ID_5);
        LOCAL_ID_MAP.put(XML_REF_ID_1, LOCAL_ID_6);
        LOCAL_ID_MAP.put(XML_REF_ID_2, LOCAL_ID_7);
    }

    public static final String SUBDOMAIN = "1";
    public static final String DESCRIPTOR = "Descriptor #140524360699280";
    public static final boolean RELEASED = true;
    public static final String CORRECT_ANSWER = "7";
    public static final String MAX_SCORE = "10";
    public static final String DIFFICULTY = "3";
    public static final String PROFICIENCY = "32";
    public static final String URL = "https://www.nsip.edu.au";
    public static final String MARKING_TYPE = "AS";
    public static final String GENRE = "Narrative";
    public static final String ITEM_TYPE = "IC";
    public static final String[] CONTENTS = {"MNA32", "MNA37"};
    public static final String PNP_CODE = "AAM";
    public static final String RUBRIC_TYPE = "CS";
    public static final String RUBRIC_DESCRIPTOR = "Descriptor #";
    public static final String SCORE_PREFIX = "1";

    public static final String STIMULUS_CONTENT = "Stimulus Content #";
    public static final String STIMULUS_LOCAL_ID = "Stimulus #";
    public static final String TEXT_GENRE = "Genre #";
    public static final String TEXT_TYPE = "Type #";
    public static final String WORD_COUNT = "123";

    public NAPTestItemType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        NAPTestItemType napTestItemType = new NAPTestItemType();
        napTestItemType.setRefId(refId);

        NAPTestItemContentType napTestItemContentType = new NAPTestItemContentType();
        napTestItemContentType.setNAPTestItemLocalId(LOCAL_ID_MAP.getOrDefault(refId, LOCAL_ID_X));
        napTestItemContentType.setSubdomain(SUBDOMAIN);
        napTestItemContentType.setItemDescriptor(DESCRIPTOR);
        napTestItemContentType.setReleasedStatus(RELEASED);
        napTestItemContentType.setCorrectAnswer(objectFactory.createNAPTestItemContentTypeCorrectAnswer(CORRECT_ANSWER));
        napTestItemContentType.setMaximumScore(new BigDecimal(MAX_SCORE));
        napTestItemContentType.setItemDifficulty(new BigDecimal(DIFFICULTY));
        napTestItemContentType.setItemProficiencyBand(new BigInteger(PROFICIENCY));
        napTestItemContentType.setExemplarURL(objectFactory.createNAPTestItemContentTypeExemplarURL(URL));
        napTestItemContentType.setMarkingType(AUCodeSetsNAPTestItemMarkingTypeType.fromValue(MARKING_TYPE));
        napTestItemContentType.setWritingGenre(objectFactory.createNAPTestItemContentTypeWritingGenre(AUCodeSetsNAPWritingGenreType.fromValue(GENRE)));
        napTestItemContentType.setItemType(AUCodeSetsNAPTestItemTypeType.fromValue(ITEM_TYPE));

        ContentDescriptionListType contentDescriptionListType = new ContentDescriptionListType();
        contentDescriptionListType.getContentDescription().addAll(Arrays.asList(CONTENTS));
        napTestItemContentType.setContentDescriptionList(objectFactory.createNAPTestItemContentTypeContentDescriptionList(contentDescriptionListType));

        SubstituteItemListType substituteItemListType = objectFactory.createSubstituteItemListType();
        SubstituteItemType substituteItemType = objectFactory.createSubstituteItemType();
        PNPCodeListType pnpCodeListType = objectFactory.createPNPCodeListType();
        pnpCodeListType.getPNPCode().add(AUCodeSetsPNPCodeType.fromValue(PNP_CODE));
        substituteItemType.setPNPCodeList(pnpCodeListType);
        if (!REF_ID_1.equals(refId)) {
            substituteItemType.setSubstituteItemRefId(REF_ID_1);
            substituteItemListType.getSubstituteItem().add(substituteItemType);
            napTestItemContentType.setItemSubstitutedForList(objectFactory.createNAPTestItemContentTypeItemSubstitutedForList(substituteItemListType));
        }

        StimulusListType stimulusListType = new StimulusListType();
        stimulusListType.getStimulus().add(getStimulus(0));
        stimulusListType.getStimulus().add(getStimulus(1));
        napTestItemContentType.setStimulusList(objectFactory.createNAPTestItemContentTypeStimulusList(stimulusListType));

        NAPWritingRubricListType napWritingRubricListType = new NAPWritingRubricListType();
        napWritingRubricListType.getNAPWritingRubric().add(getWritingRubric(0));
        napWritingRubricListType.getNAPWritingRubric().add(getWritingRubric(1));
        napTestItemContentType.setNAPWritingRubricList(objectFactory.createNAPTestItemContentTypeNAPWritingRubricList(napWritingRubricListType));
        napTestItemType.setTestItemContent(napTestItemContentType);
        return napTestItemType;
    }

    private NAPWritingRubricType getWritingRubric(int index) {
        ObjectFactory objectFactory = new ObjectFactory();
        NAPWritingRubricType napWritingRubricType = new NAPWritingRubricType();
        napWritingRubricType.setRubricType(RUBRIC_TYPE);
        napWritingRubricType.setDescriptor(objectFactory.createNAPWritingRubricTypeDescriptor(RUBRIC_DESCRIPTOR + index));

        ScoreListType scoreList = new ScoreListType();
        scoreList.getScore().add(getScore(index, 0));
        scoreList.getScore().add(getScore(index, 1));
        napWritingRubricType.setScoreList(scoreList);

        return napWritingRubricType;
    }

    private ScoreType getScore(int indexParent, int index) {
        ScoreType scoreType = new ScoreType();
        scoreType.setMaxScoreValue(new BigDecimal(SCORE_PREFIX + indexParent + "" + index));
        ScoreDescriptionListType scoreDescriptionListType = new ScoreDescriptionListType();
        scoreDescriptionListType.getScoreDescription().add(getScoreDescription(indexParent, index, 0));
        scoreDescriptionListType.getScoreDescription().add(getScoreDescription(indexParent, index, 1));
        scoreType.setScoreDescriptionList(scoreDescriptionListType);
        return scoreType;
    }

    private ScoreDescriptionType getScoreDescription(int indexParent, int indexScore, int index) {
        ObjectFactory objectFactory = new ObjectFactory();
        ScoreDescriptionType scoreDescriptionType = new ScoreDescriptionType();
        scoreDescriptionType.setDescriptor(objectFactory.createScoreDescriptionTypeDescriptor(RUBRIC_DESCRIPTOR + indexParent + "" + indexScore + "" + index));
        scoreDescriptionType.setScoreValue(new BigDecimal(SCORE_PREFIX + indexParent + "" + indexScore + "" + index));
        return scoreDescriptionType;
    }

    private StimulusType getStimulus(int index) {
        ObjectFactory objectFactory = new ObjectFactory();
        StimulusType stimulusType = new StimulusType();
        stimulusType.setContent(STIMULUS_CONTENT + index);
        stimulusType.setTextDescriptor(objectFactory.createStimulusTypeTextDescriptor(RUBRIC_DESCRIPTOR + index));
        stimulusType.setStimulusLocalId(STIMULUS_LOCAL_ID + index);
        stimulusType.setTextGenre(objectFactory.createStimulusTypeTextGenre(TEXT_GENRE + index));
        stimulusType.setTextType(objectFactory.createStimulusTypeTextType(TEXT_TYPE + index));
        stimulusType.setWordCount(objectFactory.createStimulusTypeWordCount(new BigInteger(WORD_COUNT + index)));
        return stimulusType;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("NAPTests", QueryOperator.EQUAL, NAPTestTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(NAPTestItemType object, int index) {
        // No way to tell if this object is linked to the test this way.
        return object != null && index == 0;
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

    public NAPTestItemCollectionType getTestCollection(String... refIds) {
        NAPTestItemCollectionType result = new NAPTestItemCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getNAPTestItem().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "NAPTestItem.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "NAPTestItems.xml";
    }

}

