package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class PersonalisedPlanTestData extends TestData<PersonalisedPlanType, PersonalisedPlanCollectionType> {

    public static final String REF_ID_1 = "6cd86be7-71ce-4625-8c58-ff2278665d49";
    public static final String REF_ID_2 = "640b496e-558d-4336-add2-d70b986035a8";
    public static final String REF_ID_3 = "7dcff490-fdfb-48dc-a2fc-dadee5658eeb";
    public static final String REF_ID_4 = "04a9a3f9-8f8a-4a2a-b0de-8e0bea85710f";
    public static final String REF_ID_5 = "dc87cb19-984a-4bbd-be4c-a0658e44dfc0";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "af288cb1-ddc4-447d-8be6-40c64820c190";
    public static final String XML_REF_ID_2 = "7915f8ed-618c-48f9-8348-c14ecbcf2e67";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String PLAN_TYPE = "Ac";
    public static final String START_DATE = "2018-03-01";
    public static final String END_DATE = "2018-05-09";
    public static final String REVIEW_DATE = "2018-04-03";
    public static final String NOTES = "Student plan notes are recorded here.";
    public static final String ATTACHMENT = "attachment.docx";

    public PersonalisedPlanType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        PersonalisedPlanType personalisedPlanType = objectFactory.createPersonalisedPlanType();
        personalisedPlanType.setRefId(refId);
        personalisedPlanType.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_1);
        personalisedPlanType.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        personalisedPlanType.setPersonalisedPlanCategory(AUCodeSetsPersonalisedPlanType.fromValue(PLAN_TYPE));
        personalisedPlanType.setPersonalisedPlanStartDate(getDate(START_DATE));
        personalisedPlanType.setPersonalisedPlanEndDate(objectFactory.createPersonalisedPlanTypePersonalisedPlanEndDate(getDate(END_DATE)));
        personalisedPlanType.setPersonalisedPlanReviewDate(objectFactory.createPersonalisedPlanTypePersonalisedPlanReviewDate(getDate(REVIEW_DATE)));
        personalisedPlanType.setPersonalisedPlanNotes(objectFactory.createPersonalisedPlanTypePersonalisedPlanNotes(NOTES));
        personalisedPlanType.setAssociatedAttachment(objectFactory.createPersonalisedPlanTypeAssociatedAttachment(ATTACHMENT));

        WellbeingDocumentListType wellbeingDocumentListType = objectFactory.createWellbeingDocumentListType();
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(1));
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(2));
        personalisedPlanType.setDocumentList(objectFactory.createPersonalisedPlanTypeDocumentList(wellbeingDocumentListType));
        return personalisedPlanType;
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

    public PersonalisedPlanCollectionType getTestCollection(String... refIds) {
        PersonalisedPlanCollectionType result = new PersonalisedPlanCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getPersonalisedPlan().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "PersonalisedPlan.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "PersonalisedPlans.xml";
    }

}

