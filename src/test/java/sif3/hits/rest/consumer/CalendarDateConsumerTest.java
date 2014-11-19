package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif.dd.au30.model.CalendarDate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CalendarDateConsumerTest {
  private ConsumerTest<CalendarDate, CalendarDateCollectionType> calendarDateTester = null;
  
  private final String REF_ID_1 = "D283DB7B17164B82AE9051155B5DEF0D";
  private final String REF_ID_2 = "40DF4CCFA69B4B479DAF0ACD722E1942";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    calendarDateTester = new ConsumerTest<CalendarDate, CalendarDateCollectionType>(
        CalendarDate.class, "CalendarDate", CalendarDateCollectionType.class, "CalendarDates");
    calendarDateTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "4756760B07484471BA78CE0F62E70EBF";
    List<Response> responses = calendarDateTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    CalendarDate calendarDate = (CalendarDate) response.getDataObject();
    Assert.assertEquals(REF_ID, calendarDate.getCalendarDateRefId().getValue());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = calendarDateTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    CalendarDateCollectionType calendarDates = (CalendarDateCollectionType) response.getDataObject();
    Assert.assertNotNull(calendarDates.getCalendarDate());
    Assert.assertEquals(5, calendarDates.getCalendarDate().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = calendarDateTester.testCreateOne("calendardate.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    CalendarDate calendarDate = (CalendarDate) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, calendarDate.getCalendarDateRefId().getValue());
    
    List<Response> deleteResponses = calendarDateTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = calendarDateTester.testCreateMany("calendardates.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = calendarDateTester.testDeleteMany(REF_IDS);
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
