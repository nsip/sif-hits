package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.StudentPeriodAttendanceCollectionType;
import sif.dd.au30.model.StudentPeriodAttendanceType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentPeriodAttendanceTest {
  private ConsumerTest<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType> studentPeriodAttendanceTester = null;
  
  private final String REF_ID_1 = "14BB2FE70A994858BEDF635B24CFF18C";
  private final String REF_ID_2 = "30F645FF9AD44A21912087CE2EFCCCD6";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentPeriodAttendanceTester = new ConsumerTest<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType>(
        StudentPeriodAttendanceType.class, "StudentPeriodAttendance", StudentPeriodAttendanceCollectionType.class, "StudentPeriodAttendances");
    studentPeriodAttendanceTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "6C1EB23B383A4A289864F656B9630835";
    List<Response> responses = studentPeriodAttendanceTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPeriodAttendanceType studentPeriodAttendance = (StudentPeriodAttendanceType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentPeriodAttendance.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = studentPeriodAttendanceTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPeriodAttendanceCollectionType studentPeriodAttendances = (StudentPeriodAttendanceCollectionType) response.getDataObject();
    Assert.assertNotNull(studentPeriodAttendances.getStudentPeriodAttendance());
    Assert.assertEquals(5, studentPeriodAttendances.getStudentPeriodAttendance().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = studentPeriodAttendanceTester.testCreateOne("studentperiodattendance.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentPeriodAttendanceType timeTable = (StudentPeriodAttendanceType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTable.getRefId());
    
    List<Response> deleteResponses = studentPeriodAttendanceTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentPeriodAttendanceTester.testCreateMany("studentperiodattendances.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentPeriodAttendanceTester.testDeleteMany(REF_IDS);
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
