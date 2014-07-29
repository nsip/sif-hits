package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ScheduledActivityCollectionType;
import sif.dd.au30.model.ScheduledActivityType;
import sif.dd.au30.model.SchoolCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class ScheduledActivityTest {
  private ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType> scheduledActivityTester = null;
  
  private final String REF_ID_1 = "596BD11814CB485A84D3593FC5703958";
  private final String REF_ID_2 = "DF54713ADB1C4428A418D8A5964D893A";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    scheduledActivityTester = new ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType>(
        ScheduledActivityType.class, "ScheduledActivity", ScheduledActivityCollectionType.class, "ScheduledActivities");
    scheduledActivityTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "9830F851B7534AECA0DCC0EC66649CA4";
    List<Response> responses = scheduledActivityTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    ScheduledActivityType scheduledActivity = (ScheduledActivityType) response.getDataObject();
    Assert.assertEquals(REF_ID, scheduledActivity.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = scheduledActivityTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    ScheduledActivityCollectionType scheduledActivityCollection = (ScheduledActivityCollectionType) response.getDataObject();
    Assert.assertNotNull(scheduledActivityCollection.getScheduledActivity());
    Assert.assertEquals(1, scheduledActivityCollection.getScheduledActivity().size());
  }
  
  @Test
  public void testCreateDelete() {
    List<Response> createResponses = scheduledActivityTester.testCreateOne("scheduledactivity.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    ScheduledActivityType scheduledActivity = (ScheduledActivityType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, scheduledActivity.getRefId());
    
    List<Response> deleteResponses = scheduledActivityTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = scheduledActivityTester.testCreateMany("scheduledactivities.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = scheduledActivityTester.testDeleteMany(REF_IDS);
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
