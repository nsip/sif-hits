package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.SessionInfoCollectionType;
import sif.dd.au30.model.SessionInfoType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class SessionInfoConsumerTest {
  private ConsumerTest<SessionInfoType, SessionInfoCollectionType> sessionInfoTester = null;
  
  private final String REF_ID_1 = "5F18D34A4B9B49599AF55C991378DE99";
  private final String REF_ID_2 = "D66F4094F23044F68B3376EEB11E2DFF";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    sessionInfoTester = new ConsumerTest<SessionInfoType, SessionInfoCollectionType>(
        SessionInfoType.class, "SessionInfo", SessionInfoCollectionType.class, "SessionInfos");
    sessionInfoTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "44966A710876465A82A2BF08B3DD1115";
    List<Response> responses = sessionInfoTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SessionInfoType sessionInfoPersonal = (SessionInfoType) response.getDataObject();
    Assert.assertEquals(REF_ID, sessionInfoPersonal.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = sessionInfoTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SessionInfoCollectionType sessionInfoCollection = (SessionInfoCollectionType) response.getDataObject();
    Assert.assertNotNull(sessionInfoCollection.getSessionInfo());
    Assert.assertEquals(1, sessionInfoCollection.getSessionInfo().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = sessionInfoTester.testCreateOne("session.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    SessionInfoType sessionInfoPersonal = (SessionInfoType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, sessionInfoPersonal.getRefId());
    
    List<Response> deleteResponses = sessionInfoTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = sessionInfoTester.testCreateMany("sessions.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = sessionInfoTester.testDeleteMany(REF_IDS);
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
