package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.StaffAssignmentCollectionType;
import sif.dd.au30.model.StaffAssignmentType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StaffAssignmentConsumerTest {
  private ConsumerTest<StaffAssignmentType, StaffAssignmentCollectionType> staffAssignmentTester = null;
  
  private final String REF_ID_1 = "1eeb7b74-c8ef-4812-aff1-cb4dc8071d7a";
  private final String REF_ID_2 = "1df85509-a5b4-4d2f-9013-8dbc9e14defc";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    staffAssignmentTester = new ConsumerTest<StaffAssignmentType, StaffAssignmentCollectionType>(
        StaffAssignmentType.class, "StaffAssignment", StaffAssignmentCollectionType.class, "StaffAssignments");
    staffAssignmentTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "FEB9F24C198048EB9015FF804C36BB68";
    List<Response> responses = staffAssignmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffAssignmentType staffAssignmentPersonal = (StaffAssignmentType) response.getDataObject();
    Assert.assertEquals(REF_ID, staffAssignmentPersonal.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = staffAssignmentTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffAssignmentCollectionType staffAssignmentCollection = (StaffAssignmentCollectionType) response.getDataObject();
    Assert.assertNotNull(staffAssignmentCollection.getStaffAssignment());
    Assert.assertEquals(5, staffAssignmentCollection.getStaffAssignment().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = staffAssignmentTester.testCreateOne("staffassignment.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StaffAssignmentType staffAssignmentPersonal = (StaffAssignmentType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, staffAssignmentPersonal.getRefId());
    
    List<Response> deleteResponses = staffAssignmentTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = staffAssignmentTester.testCreateMany("staffassignments.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = staffAssignmentTester.testDeleteMany(REF_IDS);
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
