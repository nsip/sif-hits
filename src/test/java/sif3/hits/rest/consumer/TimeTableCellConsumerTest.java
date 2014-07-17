package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.TimeTableCellCollectionType;
import sif.dd.au30.model.TimeTableCellType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableCellConsumerTest {
  private ConsumerTest<TimeTableCellType, TimeTableCellCollectionType> timeTableCellTester = null;

  private final String REF_ID_1 = "2D108D351AB946CDB2E9480AAA3F58B8";
  private final String REF_ID_2 = "02721649360240E9BE341427424B87B2";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    timeTableCellTester = new ConsumerTest<TimeTableCellType, TimeTableCellCollectionType>(TimeTableCellType.class,
        "TimeTableCell", TimeTableCellCollectionType.class, "TimeTableCells");
    timeTableCellTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
    final String REF_ID = "69C059F450854EA992FFFF87040C7461";
    List<Response> responses = timeTableCellTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableCellType timeTable = (TimeTableCellType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTable.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = timeTableCellTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableCellCollectionType timeTableCells = (TimeTableCellCollectionType) response.getDataObject();
    Assert.assertNotNull(timeTableCells.getTimeTableCell());
    Assert.assertEquals(5, timeTableCells.getTimeTableCell().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = timeTableCellTester.testCreateOne("timetablecell.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    TimeTableCellType timeTableCell = (TimeTableCellType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTableCell.getRefId());

    List<Response> deleteResponses = timeTableCellTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = timeTableCellTester.testCreateMany("timetablecells.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = timeTableCellTester.testDeleteMany(REF_IDS);
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
