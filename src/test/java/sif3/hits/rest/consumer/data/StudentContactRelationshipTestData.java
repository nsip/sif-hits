package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.utils.RefIdGenerator;

import java.util.*;

public class StudentContactRelationshipTestData extends TestData<StudentContactRelationshipType, StudentContactRelationshipCollectionType> {

    public static final String REF_ID_1 = "a023c4e6-6cd7-4498-969a-55ed95feaddc";
    public static final String REF_ID_2 = "b1d6bc06-50a2-49eb-b1b6-55deb7d43f50";
    public static final String REF_ID_3 = "924e2575-04f5-4a49-af24-56e08cf24222";
    public static final String REF_ID_4 = "0a97a30f-f8db-420e-9932-369255c99c76";
    public static final String REF_ID_5 = "3532fddc-0731-4728-959d-dafd8bb3a037";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "78043df9-3072-4b1e-a576-3ee17721c84b";
    public static final String XML_REF_ID_2 = "b25c26ff-8390-4365-90c8-15032dca87c6";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final Map<String, String> STUDENT_MAP = new HashMap<>();
    public static final Map<String, String> CONTACT_MAP = new HashMap<>();

    static {
        STUDENT_MAP.put(REF_ID_1, StudentPersonalTestData.REF_ID_1);
        STUDENT_MAP.put(REF_ID_2, StudentPersonalTestData.REF_ID_2);
        STUDENT_MAP.put(REF_ID_3, StudentPersonalTestData.REF_ID_3);
        STUDENT_MAP.put(REF_ID_4, StudentPersonalTestData.REF_ID_4);
        STUDENT_MAP.put(REF_ID_5, StudentPersonalTestData.REF_ID_5);
        STUDENT_MAP.put(XML_REF_ID_1, StudentPersonalTestData.REF_ID_1);
        STUDENT_MAP.put(XML_REF_ID_2, StudentPersonalTestData.REF_ID_2);
        CONTACT_MAP.put(REF_ID_1, StudentContactPersonalTestData.REF_ID_1);
        CONTACT_MAP.put(REF_ID_2, StudentContactPersonalTestData.REF_ID_2);
        CONTACT_MAP.put(REF_ID_3, StudentContactPersonalTestData.REF_ID_3);
        CONTACT_MAP.put(REF_ID_4, StudentContactPersonalTestData.REF_ID_4);
        CONTACT_MAP.put(REF_ID_5, StudentContactPersonalTestData.REF_ID_5);
        CONTACT_MAP.put(XML_REF_ID_1, StudentContactPersonalTestData.REF_ID_1);
        CONTACT_MAP.put(XML_REF_ID_2, StudentContactPersonalTestData.REF_ID_2);
    }

    public StudentContactRelationshipType getTestObject(String refId) {
        ObjectFactory objectFactory = new ObjectFactory();
        StudentContactRelationshipType studentContactRelationshipType = new StudentContactRelationshipType();

        studentContactRelationshipType.setStudentContactRelationshipRefId(refId);
        studentContactRelationshipType.setStudentPersonalRefId(STUDENT_MAP.getOrDefault(refId,StudentPersonalTestData.REF_ID_5));
        studentContactRelationshipType.setStudentContactPersonalRefId(CONTACT_MAP.getOrDefault(refId,StudentContactPersonalTestData.REF_ID_5));

        RelationshipType relationshipType = new RelationshipType();
        relationshipType.setCode(AUCodeSetsRelationshipToStudentType.fromValue("01"));
        studentContactRelationshipType.setRelationship(relationshipType);

        ContactFlagsType contactFlags = new ContactFlagsType();
        contactFlags.setParentLegalGuardian(objectFactory.createContactFlagsTypeParentLegalGuardian(AUCodeSetsYesOrNoCategoryType.Y));
        contactFlags.setPickupRights(objectFactory.createContactFlagsTypePickupRights(AUCodeSetsYesOrNoCategoryType.N));
        contactFlags.setLivesWith(objectFactory.createContactFlagsTypeLivesWith(AUCodeSetsYesOrNoCategoryType.U));
        contactFlags.setAccessToRecords(objectFactory.createContactFlagsTypeAccessToRecords(AUCodeSetsYesOrNoCategoryType.X));
        contactFlags.setEmergencyContact(objectFactory.createContactFlagsTypeEmergencyContact(AUCodeSetsYesOrNoCategoryType.Y));
        contactFlags.setHasCustody(objectFactory.createContactFlagsTypeHasCustody(AUCodeSetsYesOrNoCategoryType.N));
        contactFlags.setDisciplinaryContact(objectFactory.createContactFlagsTypeDisciplinaryContact(AUCodeSetsYesOrNoCategoryType.U));
        contactFlags.setPrimaryCareProvider(objectFactory.createContactFlagsTypePrimaryCareProvider(AUCodeSetsYesOrNoCategoryType.X));
        contactFlags.setFeesBilling(objectFactory.createContactFlagsTypeFeesBilling(AUCodeSetsYesOrNoCategoryType.Y));
        contactFlags.setFamilyMail(objectFactory.createContactFlagsTypeFamilyMail(AUCodeSetsYesOrNoCategoryType.N));
        contactFlags.setInterventionOrder(objectFactory.createContactFlagsTypeInterventionOrder(AUCodeSetsYesOrNoCategoryType.U));
        studentContactRelationshipType.setContactFlags(objectFactory.createStudentContactRelationshipTypeContactFlags(contactFlags));
        return studentContactRelationshipType;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(StudentContactRelationshipType object, int index) {
        return object != null && StudentPersonalTestData.REF_ID_1.equals(object.getStudentPersonalRefId());
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

    public StudentContactRelationshipCollectionType getTestCollection(String... refIds) {
        StudentContactRelationshipCollectionType result = new StudentContactRelationshipCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentContactRelationship().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentContactRelationship.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentContactRelationships.xml";
    }

}

