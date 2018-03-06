package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsRelationshipToStudentType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ContactFlagsType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.RelationshipType;
import sif.dd.au30.model.StudentContactRelationshipCollectionType;
import sif.dd.au30.model.StudentContactRelationshipType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentContactPersonalConsumerTest.StudentContactPersonalRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentContactRelationshipConsumerTest extends BaseTest {
    private ConsumerTest<StudentContactRelationshipType, StudentContactRelationshipCollectionType> studentTester = null;

    public static class StudentContactRelationshipRefIds {
        public static String REF_ID_1 = "94aa4e71-b143-4dfb-b8ff-a605538da4a4";
        public static String REF_ID_2 = "5e7b95c3-ea95-46b0-b2e5-e70096cf02ba";
        public static String REF_ID_3 = "70e7fd0b-f3d2-4a0e-b2a9-ceaa59526cba";
        public static String REF_ID_4 = "292c3f3a-2a0a-4607-b02e-02ead900e7a1";
        public static String REF_ID_5 = "afc1f6e7-7edf-4f98-8cb4-badd646cf92d";
    }

    private final String REF_ID_1 = "5eede4c3-f468-4ee3-b64b-8fe37e2b82b7";
    private final String REF_ID_2 = "559ea81b-62c7-4e51-ade2-74d42e1084b1";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        StudentContactRelationshipType studentContactRelationshipType = new StudentContactRelationshipType();

        studentContactRelationshipType.setStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_1);
        studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
        studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_1);

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
        studentTester.doCreateOne(studentContactRelationshipType);
        String xmlExpectedTo = studentTester.getXML(studentContactRelationshipType);

        studentContactRelationshipType.setStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_2);
        studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
        studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_2);
        studentTester.doCreateOne(studentContactRelationshipType);

        studentContactRelationshipType.setStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_3);
        studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
        studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_3);
        studentTester.doCreateOne(studentContactRelationshipType);

        studentContactRelationshipType.setStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_4);
        studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
        studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_4);
        studentTester.doCreateOne(studentContactRelationshipType);

        studentContactRelationshipType.setStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_5);
        studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5);
        studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_5);
        studentTester.doCreateOne(studentContactRelationshipType);

        StudentContactRelationshipType getResult = studentTester.doGetOne(StudentContactRelationshipRefIds.REF_ID_1);
        String xmlExpectedFrom = studentTester.getXML(getResult);
        Assert.assertNotNull("XML Expected From isNull", xmlExpectedFrom);
        Assert.assertNotNull("XML Expected To isNull", xmlExpectedTo);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        studentTester = new ConsumerTest<StudentContactRelationshipType, StudentContactRelationshipCollectionType>(StudentContactRelationshipType.class,
                "StudentContactRelationship", StudentContactRelationshipCollectionType.class, "StudentContactRelationships");
        studentTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = studentTester.testGetSingle(StudentContactRelationshipRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StudentContactRelationshipType studentContactRelationship = (StudentContactRelationshipType) response.getDataObject();
        Assert.assertEquals(StudentContactRelationshipRefIds.REF_ID_1, studentContactRelationship.getStudentContactRelationshipRefId());

        String xmlExpectedFrom = studentTester.getXML(studentContactRelationship);

        List<Response> updateResponses = studentTester.doUpdateOne(studentContactRelationship, StudentContactRelationshipRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = studentTester.testGetSingle(StudentContactRelationshipRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        StudentContactRelationshipType comparisonTo = (StudentContactRelationshipType) getResponse.getDataObject();
        Assert.assertEquals(StudentContactRelationshipRefIds.REF_ID_1, comparisonTo.getStudentContactRelationshipRefId());
        String xmlExpectedTo = studentTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = studentTester.testGetSingle(StudentContactRelationshipRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StudentContactRelationshipType studentContactRelationship = (StudentContactRelationshipType) response.getDataObject();
        Assert.assertEquals(StudentContactRelationshipRefIds.REF_ID_1, studentContactRelationship.getStudentContactRelationshipRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = studentTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        StudentContactRelationshipCollectionType studentCollection = (StudentContactRelationshipCollectionType) response.getDataObject();
        Assert.assertNotNull(studentCollection.getStudentContactRelationship());
        Assert.assertEquals(5, studentCollection.getStudentContactRelationship().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = studentTester.testCreateOne("studentcontactrelationship.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        StudentContactRelationshipType studentContactRelationship = (StudentContactRelationshipType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, studentContactRelationship.getStudentContactRelationshipRefId());

        List<Response> deleteResponses = studentTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentTester.testCreateMany("studentcontactrelationships.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = studentTester.testDeleteMany(REF_IDS);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        BulkOperationResponse<OperationStatus> deleteResponse = deleteResponses.get(0);
        Assert.assertNotNull(deleteResponse.getOperationStatuses());
        Assert.assertEquals(2, deleteResponse.getOperationStatuses().size());
        for (OperationStatus operationStatus : deleteResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getResourceID()));
            Assert.assertEquals(HttpStatus.OK.value(), operationStatus.getStatus());
        }
    }
}
