package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.StaffCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StaffPersonalConsumerTest {
  private ConsumerTest<StaffPersonalType, StaffCollectionType> staffTester = null;
  
  private final String REF_ID_1 = "E9F19488026B11E3A5325DE06940ABA2";
  private final String REF_ID_2 = "E9F19488026B11E3A5325DE06940ABA4";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    staffTester = new ConsumerTest<StaffPersonalType, StaffCollectionType>(
        StaffPersonalType.class, "StaffPersonal", StaffCollectionType.class, "StaffPersonals");
    staffTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "eae6c11f-ebb6-4fd7-92de-331105744683";
    List<Response> responses = staffTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffPersonalType staffPersonal = (StaffPersonalType) response.getDataObject();
    Assert.assertEquals(REF_ID, staffPersonal.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = staffTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffCollectionType staffCollection = (StaffCollectionType) response.getDataObject();
    Assert.assertNotNull(staffCollection.getStaffPersonal());
    Assert.assertEquals(3, staffCollection.getStaffPersonal().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = staffTester.testCreateOne("staff.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StaffPersonalType staffPersonal = (StaffPersonalType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, staffPersonal.getRefId());
    
    List<Response> deleteResponses = staffTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = staffTester.testCreateMany("staffs.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = staffTester.testDeleteMany(REF_IDS);
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
