package sif3.hits.rest.consumer;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sif.dd.au30.model.StudentSchoolEnrollmentCollectionType;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentSchoolEnrollmentConsumerTest {
  private ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> studentSchoolEnrollmentTester = null;
  
//  private final String REF_ID_1 = "6BB0C404C02949BD9956D6BE93B7B128";
//  private final String REF_ID_2 = "6BB0C404C02949BD9956D6BE93B7B124";
//  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentSchoolEnrollmentTester = new ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType>(
        StudentSchoolEnrollmentType.class, "StudentSchoolEnrollment", StudentSchoolEnrollmentCollectionType.class, "StudentSchoolEnrollments");
//    studentSchoolEnrollmentTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "00093e7a-5ab7-472c-b761-15bd4625d034";
    List<Response> responses = studentSchoolEnrollmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentSchoolEnrollment.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = studentSchoolEnrollmentTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentSchoolEnrollmentCollectionType studentSchoolEnrollmentCollectionType = (StudentSchoolEnrollmentCollectionType) response.getDataObject();
    Assert.assertNotNull(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment());
    Assert.assertEquals(5, studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment().size());
  }
  
  @Test
  public void testCreateDelete() {   
//    List<Response> createResponses = studentTester.testCreateOne("student.xml");
//    Assert.assertNotNull(createResponses);
//    Assert.assertEquals(1, createResponses.size());
//    Response createResponse = createResponses.get(0);
//    Assert.assertNotNull(createResponse.getDataObject());
//    StudentPersonalType studentPersonal = (StudentPersonalType) createResponse.getDataObject();
//    Assert.assertEquals(REF_ID_1, studentPersonal.getRefId());
//    
//    List<Response> deleteResponses = studentTester.testDeleteOne(REF_ID_1);
//    Assert.assertNotNull(deleteResponses);
//    Assert.assertEquals(1, deleteResponses.size());
//    Response deleteResponse = deleteResponses.get(0);
//    Assert.assertNull(deleteResponse.getDataObject());
//    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
//    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
//    
//    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentTester.testCreateMany("students.xml");
//    Assert.assertNotNull(createResponses);
//    Assert.assertEquals(1, createResponses.size());
//    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
//    Assert.assertNotNull(createResponse.getOperationStatuses());
//    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
//    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
//      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
//      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
//    }
//    
//    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentTester.testDeleteMany(REF_IDS);
//    Assert.assertNotNull(deleteResponses);
//    Assert.assertEquals(1, deleteResponses.size());
//    BulkOperationResponse<OperationStatus> deleteResponse = deleteResponses.get(0);
//    Assert.assertNotNull(deleteResponse.getOperationStatuses());
//    Assert.assertEquals(2, deleteResponse.getOperationStatuses().size());
//    for (OperationStatus operationStatus : deleteResponse.getOperationStatuses()) {
//      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getResourceID()));
//      Assert.assertEquals(HttpStatus.OK.value(), operationStatus.getStatus());
//    }
  }
}
