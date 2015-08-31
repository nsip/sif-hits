package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.RelationshipType;
import sif.dd.au30.model.StudentContactRelationshipCollectionType;
import sif.dd.au30.model.StudentContactRelationshipType;
import sif.dd.au30.model.StudentContactRelationshipType.ContactFlags;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentContactPersonalConsumerTest.StudentContactPersonalRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentContactRelationshipConsumerTest extends BaseTest {
  private ConsumerTest<StudentContactRelationshipType, StudentContactRelationshipCollectionType> studentTester = null;

  public static class StudentContactRelationshipRefIds {
    public static String REF_ID_1 = "94AA4E71B1434DFBB8FFA605538DA4A4";
    public static String REF_ID_2 = "5E7B95C3EA9546B0B2E5E70096CF02BA";
    public static String REF_ID_3 = "70E7FD0BF3D24A0EB2A9CEAA59526CBA";
    public static String REF_ID_4 = "292C3F3A2A0A4607B02E02EAD900E7A1";
    public static String REF_ID_5 = "AFC1F6E77EDF4F988CB4BADD646CF92D";
  }
  
  private final String REF_ID_1 = "5EEDE4C3F4684EE3B64B8FE37E2B82B7";
  private final String REF_ID_2 = "559EA81B62C74E51ADE274D42E1084B1";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {    
    ObjectFactory objectFactory = new ObjectFactory();
    StudentContactRelationshipType studentContactRelationshipType = new StudentContactRelationshipType();
    
    studentContactRelationshipType.setStudentContactRelationshipRefId(
        objectFactory.createStudentContactRelationshipTypeStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_1));
    studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
    studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_1);
    
    RelationshipType relationshipType = new RelationshipType();
    relationshipType.setCode("01");
    studentContactRelationshipType.setRelationship(relationshipType);
    
    ContactFlags contactFlags = new ContactFlags();
    contactFlags.setParentLegalGuardian(objectFactory.createStudentContactRelationshipTypeContactFlagsParentLegalGuardian(AUCodeSetsYesOrNoCategoryType.Y));
    contactFlags.setPickupRights(objectFactory.createStudentContactRelationshipTypeContactFlagsPickupRights(AUCodeSetsYesOrNoCategoryType.N));
    contactFlags.setLivesWith(objectFactory.createStudentContactRelationshipTypeContactFlagsLivesWith(AUCodeSetsYesOrNoCategoryType.U));
    contactFlags.setAccessToRecords(objectFactory.createStudentContactRelationshipTypeContactFlagsAccessToRecords(AUCodeSetsYesOrNoCategoryType.X));
    contactFlags.setEmergencyContact(objectFactory.createStudentContactRelationshipTypeContactFlagsEmergencyContact(AUCodeSetsYesOrNoCategoryType.Y));
    contactFlags.setHasCustody(objectFactory.createStudentContactRelationshipTypeContactFlagsHasCustody(AUCodeSetsYesOrNoCategoryType.N));
    contactFlags.setDisciplinaryContact(objectFactory.createStudentContactRelationshipTypeContactFlagsDisciplinaryContact(AUCodeSetsYesOrNoCategoryType.U));
    contactFlags.setPrimaryCareProvider(objectFactory.createStudentContactRelationshipTypeContactFlagsPrimaryCareProvider(AUCodeSetsYesOrNoCategoryType.X));
    contactFlags.setFeesBilling(objectFactory.createStudentContactRelationshipTypeContactFlagsFeesBilling(AUCodeSetsYesOrNoCategoryType.Y));
    contactFlags.setFamilyMail(objectFactory.createStudentContactRelationshipTypeContactFlagsFamilyMail(AUCodeSetsYesOrNoCategoryType.N));
    contactFlags.setInterventionOrder(objectFactory.createStudentContactRelationshipTypeContactFlagsInterventionOrder(AUCodeSetsYesOrNoCategoryType.U));
    studentContactRelationshipType.setContactFlags(objectFactory.createStudentContactRelationshipTypeContactFlags(contactFlags));
    studentTester.doCreateOne(studentContactRelationshipType);
    String xmlExpectedTo = studentTester.getXML(studentContactRelationshipType);
    
    studentContactRelationshipType.setStudentContactRelationshipRefId(
        objectFactory.createStudentContactRelationshipTypeStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_2));
    studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
    studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_2);
    studentTester.doCreateOne(studentContactRelationshipType);

    studentContactRelationshipType.setStudentContactRelationshipRefId(
        objectFactory.createStudentContactRelationshipTypeStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_3));
    studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
    studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_3);
    studentTester.doCreateOne(studentContactRelationshipType);
    
    studentContactRelationshipType.setStudentContactRelationshipRefId(
        objectFactory.createStudentContactRelationshipTypeStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_4));
    studentContactRelationshipType.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
    studentContactRelationshipType.setStudentContactPersonalRefId(StudentContactPersonalRefIds.REF_ID_4);    
    studentTester.doCreateOne(studentContactRelationshipType);
    
    studentContactRelationshipType.setStudentContactRelationshipRefId(
        objectFactory.createStudentContactRelationshipTypeStudentContactRelationshipRefId(StudentContactRelationshipRefIds.REF_ID_5));
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
  public void testGetSingle() {
    List<Response> responses = studentTester.testGetSingle(StudentContactRelationshipRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentContactRelationshipType studentContactRelationship = (StudentContactRelationshipType) response.getDataObject();
    Assert.assertEquals(StudentContactRelationshipRefIds.REF_ID_1, studentContactRelationship.getStudentContactRelationshipRefId().getValue());
  }

  @Test
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
  public void testCreateDelete() {
    List<Response> createResponses = studentTester.testCreateOne("studentcontactrelationship.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentContactRelationshipType studentContactRelationship = (StudentContactRelationshipType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, studentContactRelationship.getStudentContactRelationshipRefId().getValue());

    List<Response> deleteResponses = studentTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
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
