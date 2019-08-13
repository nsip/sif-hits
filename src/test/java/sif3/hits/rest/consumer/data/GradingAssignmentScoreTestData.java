package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.GradingAssignmentScoreCollectionType;
import sif.dd.au30.model.GradingAssignmentScoreType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class GradingAssignmentScoreTestData extends TestData<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType> {

    public static final String REF_ID_1 = "bd23c337-32bd-43f1-83ef-2c1771cb066c";
    public static final String REF_ID_2 = "fcd34f55-8d51-4aec-86e4-63da2e14a31f";
    public static final String REF_ID_3 = "e15eb454-a677-4a69-885f-c4050f19c3ba";
    public static final String REF_ID_4 = "6740f582-b51f-45cf-b36c-6185206da0be";
    public static final String REF_ID_5 = "306892ef-2183-47ca-8a91-66bf8de0e8bc";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "e4ad7175-1c56-40dc-bbcd-1eb9c9da2956";
    public static final String XML_REF_ID_2 = "3d4e7e78-0f0a-4f7e-8665-4edec57144de";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final Long POINTS = 24L;
    public static final String PERCENT = "0.96";
    public static final String GRADE = "A";
    public static final String DESCRIPTION = "Well Done!";

    public GradingAssignmentScoreType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        GradingAssignmentScoreType gradingAssignmentScore = new GradingAssignmentScoreType();
        gradingAssignmentScore.setRefId(refId);
        gradingAssignmentScore.setGradingAssignmentRefId(GradingAssignmentTestData.REF_ID_1);
        gradingAssignmentScore.setTeachingGroupRefId(objectFactory.createGradingAssignmentScoreTypeTeachingGroupRefId(TeachingGroupTestData.REF_ID_1));
        gradingAssignmentScore.setSchoolInfoRefId(objectFactory.createGradingAssignmentScoreTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        gradingAssignmentScore.setStudentPersonalRefId(objectFactory.createGradingAssignmentScoreTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_1));
        gradingAssignmentScore.setStudentPersonalLocalId(StudentPersonalTestData.LOCAL_ID);
        gradingAssignmentScore.setScorePoints(objectFactory.createGradingAssignmentScoreTypeScorePoints(POINTS));
        gradingAssignmentScore.setScorePercent(objectFactory.createGradingAssignmentScoreTypeScorePercent(new BigDecimal(PERCENT)));
        gradingAssignmentScore.setScoreLetter(objectFactory.createGradingAssignmentScoreTypeScoreLetter(GRADE));
        gradingAssignmentScore.setScoreDescription(objectFactory.createGradingAssignmentScoreTypeScoreDescription(DESCRIPTION));
        return gradingAssignmentScore;
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

    public GradingAssignmentScoreCollectionType getTestCollection(String... refIds) {
        GradingAssignmentScoreCollectionType result = new GradingAssignmentScoreCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getGradingAssignmentScore().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "GradingAssignmentScore.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "GradingAssignmentScores.xml";
    }

}

