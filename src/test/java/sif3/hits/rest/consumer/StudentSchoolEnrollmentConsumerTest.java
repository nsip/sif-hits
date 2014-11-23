package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.StudentSchoolEnrollmentCollectionType;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentSchoolEnrollmentConsumerTest {
  private ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> studentSchoolEnrollmentTester = null;
  
  private final String REF_ID_1 = "ECCDBCBF96814791A8253CDBF8CD138F";
  private final String REF_ID_2 = "DCCEC3172371465E854AE1AF585DA93A";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentSchoolEnrollmentTester = new ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType>(
        StudentSchoolEnrollmentType.class, "StudentSchoolEnrollment", StudentSchoolEnrollmentCollectionType.class, "StudentSchoolEnrollments");
    studentSchoolEnrollmentTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "ed5aebc9-2b38-4044-93aa-35f976180271";
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
    List<Response> createResponses = studentSchoolEnrollmentTester.testCreateOne("studentschoolenrollment.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, studentSchoolEnrollment.getRefId());
    
    List<Response> deleteResponses = studentSchoolEnrollmentTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentSchoolEnrollmentTester.testCreateMany("studentschoolenrollments.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentSchoolEnrollmentTester.testDeleteMany(REF_IDS);
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
