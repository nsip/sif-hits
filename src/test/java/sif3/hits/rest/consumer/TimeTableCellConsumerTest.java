package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.TimeTableCellCollectionType;
import sif.dd.au30.model.TimeTableCellType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableCellConsumerTest extends BaseTest {
  private ConsumerTest<TimeTableCellType, TimeTableCellCollectionType> timeTableCellTester = null;
  
  public static final String REF_ID = "301C949D376945FC9C827119C1F9DF03";
  public static final String CELL_TYPE = "Teaching";
  public static final String DAY_ID = "1";
  public static final String PERIOD_ID = "1";
  
  private final String REF_ID_1 = "2D108D351AB946CDB2E9480AAA3F58B8";
  private final String REF_ID_2 = "02721649360240E9BE341427424B87B2";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    TimeTableCellType timeTableCell = new TimeTableCellType();
    timeTableCell.setRefId(REF_ID);
    timeTableCell.setSchoolInfoRefId(objectFactory.createTimeTableCellTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    timeTableCell.setSchoolLocalId(objectFactory.createTimeTableCellTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
    timeTableCell.setTimeTableRefId(TimeTableConsumerTest.REF_ID);
    timeTableCell.setTimeTableLocalId(objectFactory.createTimeTableCellTypeTimeTableLocalId(TimeTableConsumerTest.LOCAL_ID));
    timeTableCell.setTimeTableSubjectRefId(TimeTableSubjectConsumerTest.REF_ID);
    timeTableCell.setSubjectLocalId(objectFactory.createTimeTableCellTypeSubjectLocalId(TimeTableSubjectConsumerTest.LOCAL_ID));
    timeTableCell.setTeachingGroupRefId(TeachingGroupConsumerTest.REF_ID);
    timeTableCell.setTeachingGroupLocalId(objectFactory.createTimeTableCellTypeTeachingGroupLocalId(TeachingGroupConsumerTest.LOCAL_ID));
    timeTableCell.setRoomInfoRefId(RoomInfoConsumerTest.REF_ID);
    timeTableCell.setRoomNumber(objectFactory.createTimeTableCellTypeRoomNumber(RoomInfoConsumerTest.ROOM_NUMBER));
    timeTableCell.setStaffPersonalRefId(objectFactory.createTimeTableCellTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1));
    timeTableCell.setStaffLocalId(objectFactory.createTimeTableCellTypeStaffLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
    timeTableCell.setDayId(DAY_ID);
    timeTableCell.setPeriodId(PERIOD_ID);
    timeTableCell.setCellType(CELL_TYPE);
    
    timeTableCellTester.doCreateOne(timeTableCell);
    String xmlExpectedTo = timeTableCellTester.getXML(timeTableCell);
    
    timeTableCell.setRefId("400D6EF07BCF4513A45A3DD9003ADBBF");
    timeTableCell.setTeachingGroupRefId("6CD60385006E426892EFF69FFC8C5C9F");
    timeTableCell.setDayId("2");
    timeTableCellTester.doCreateOne(timeTableCell);
    
    timeTableCell.setRefId("1039BDD33D084F988904C20856605C0B");
    timeTableCell.setDayId("3");
    timeTableCellTester.doCreateOne(timeTableCell);
    
    timeTableCell.setRefId("3BFC9BEDAAB147A5BD5780ECB3789CAC");
    timeTableCell.setDayId("4");
    timeTableCellTester.doCreateOne(timeTableCell);
    
    timeTableCell.setRefId("5ABE4FA8572C40F197A6D363A62508F1");
    timeTableCell.setDayId("5");
    timeTableCellTester.doCreateOne(timeTableCell);
    
    TimeTableCellType getResult = timeTableCellTester.doGetOne(REF_ID);
    String xmlExpectedFrom = timeTableCellTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    timeTableCellTester = new ConsumerTest<TimeTableCellType, TimeTableCellCollectionType>(TimeTableCellType.class,
        "TimeTableCell", TimeTableCellCollectionType.class, "TimeTableCells");
    timeTableCellTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {

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

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = timeTableCellTester
        .testCreateMany("timetablecells.xml");
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
