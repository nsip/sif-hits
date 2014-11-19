package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CalendarSummaryConsumerTest {
  private ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType> calendarSummaryTester = null;
  
  private final String REF_ID_1 = "F9B62C7FFEFD44BEBC0F42389AB226D4";
  private final String REF_ID_2 = "F0A8EEA4D0024EF69164EF430E3E77F0";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    calendarSummaryTester = new ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType>(
        CalendarSummaryType.class, "CalendarSummary", CalendarSummaryCollectionType.class, "CalendarSummarys");
    calendarSummaryTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "FCCC615A828841488934424AE2DA69CA";
    List<Response> responses = calendarSummaryTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    CalendarSummaryType calendarSummary = (CalendarSummaryType) response.getDataObject();
    Assert.assertEquals(REF_ID, calendarSummary.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = calendarSummaryTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    CalendarSummaryCollectionType calendarSummarys = (CalendarSummaryCollectionType) response.getDataObject();
    Assert.assertNotNull(calendarSummarys.getCalendarSummary());
    Assert.assertEquals(5, calendarSummarys.getCalendarSummary().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = calendarSummaryTester.testCreateOne("calendarsummary.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    CalendarSummaryType calendarSummary = (CalendarSummaryType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, calendarSummary.getRefId());
    
    List<Response> deleteResponses = calendarSummaryTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = calendarSummaryTester.testCreateMany("calendarsummarys.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = calendarSummaryTester.testDeleteMany(REF_IDS);
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
