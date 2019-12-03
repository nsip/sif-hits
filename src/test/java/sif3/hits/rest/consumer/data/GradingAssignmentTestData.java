package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.GradingAssignmentCollectionType;
import sif.dd.au30.model.GradingAssignmentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class GradingAssignmentTestData extends TestData<GradingAssignmentType,GradingAssignmentCollectionType> {

    public static final String REF_ID_1 = "c9961596-f51c-409a-987e-30a89071759f";
    public static final String REF_ID_2 = "e8808b68-f7d5-430d-be9c-563155aec8de";
    public static final String REF_ID_3 = "c1511276-7365-41a7-99af-f88710415fac";
    public static final String REF_ID_4 = "bd39c5ed-166a-43ca-9cfd-81c5e9f557de";
    public static final String REF_ID_5 = "2080c879-c08c-4675-b6c1-1826438ec5ec";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "c3d5af99-a550-4e57-a3ed-8608b172bf30";
    public static final String XML_REF_ID_2 = "d841dbd5-c4cc-4b20-bbaf-1cfd38b3f8e2";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String CATEGORY = "GC";
    public static final String DESCRIPTION = "Description";
    public static final Long POINTS = 80L;
    public static final String CREATE_DATE = "2015-07-01";
    public static final String DUE_DATE = "2015-10-01";
    public static final String WEIGHTING = "75";
    public static final BigInteger ATTEMPTS = BigInteger.ONE;
    public static final String DESCRIPTION_URL = "http://www.nsip.edu.au";


    public GradingAssignmentType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        GradingAssignmentType gradingAssignment = new GradingAssignmentType();
        gradingAssignment.setRefId(refId);
        gradingAssignment.setTeachingGroupRefId(objectFactory.createGradingAssignmentTypeTeachingGroupRefId(TeachingGroupTestData.REF_ID_1));
        gradingAssignment.setSchoolInfoRefId(objectFactory.createGradingAssignmentTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        gradingAssignment.setGradingCategory(objectFactory.createGradingAssignmentTypeGradingCategory(CATEGORY));
        gradingAssignment.setDescription(DESCRIPTION);
        gradingAssignment.setPointsPossible(POINTS);
        gradingAssignment.setCreateDate(objectFactory.createGradingAssignmentTypeCreateDate(getDate(CREATE_DATE)));
        gradingAssignment.setDueDate(objectFactory.createGradingAssignmentTypeDueDate(getDate(DUE_DATE)));
        gradingAssignment.setWeight(objectFactory.createGradingAssignmentTypeWeight(new BigDecimal(WEIGHTING)));
        gradingAssignment.setMaxAttemptsAllowed(objectFactory.createGradingAssignmentTypeMaxAttemptsAllowed(ATTEMPTS));
        gradingAssignment.setDetailedDescriptionURL(objectFactory.createGradingAssignmentTypeDetailedDescriptionURL(DESCRIPTION_URL));
        return gradingAssignment;
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

    public GradingAssignmentCollectionType getTestCollection(String... refIds) {
        GradingAssignmentCollectionType result = new GradingAssignmentCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getGradingAssignment().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "GradingAssignment.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "GradingAssignments.xml";
    }

}

