package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.StudentDailyAttendanceCollectionType;
import sif.dd.au30.model.StudentDailyAttendanceType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentDailyAttendanceTest {
  private ConsumerTest<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType> studentDailyAttendanceTester = null;
  
  private final String REF_ID_1 = "96C40BB240B549FA8549E744698828C4";
  private final String REF_ID_2 = "3F8280E485264CD88708BF4032BD740A";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentDailyAttendanceTester = new ConsumerTest<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType>(
        StudentDailyAttendanceType.class, "StudentDailyAttendance", StudentDailyAttendanceCollectionType.class, "StudentDailyAttendances");
    studentDailyAttendanceTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "EA816A8591D3412CA85E7E4A20C97189";
    List<Response> responses = studentDailyAttendanceTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentDailyAttendanceType studentDailyAttendance = (StudentDailyAttendanceType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentDailyAttendance.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = studentDailyAttendanceTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentDailyAttendanceCollectionType studentDailyAttendances = (StudentDailyAttendanceCollectionType) response.getDataObject();
    Assert.assertNotNull(studentDailyAttendances.getStudentDailyAttendance());
    Assert.assertEquals(5, studentDailyAttendances.getStudentDailyAttendance().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = studentDailyAttendanceTester.testCreateOne("studentdailyattendance.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentDailyAttendanceType timeTable = (StudentDailyAttendanceType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTable.getRefId());
    
    List<Response> deleteResponses = studentDailyAttendanceTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentDailyAttendanceTester.testCreateMany("studentdailyattendances.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentDailyAttendanceTester.testDeleteMany(REF_IDS);
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
