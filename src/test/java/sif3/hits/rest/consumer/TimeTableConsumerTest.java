package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableType;
import sif.dd.au30.model.TimeTableType.TimeTableDayList;
import sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay;
import sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList;
import sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableConsumerTest extends BaseTest {
  private ConsumerTest<TimeTableType, TimeTableCollectionType> timeTableTester = null;
  
  public final static String REF_ID = "4b4a6b5d-4f0a-4f84-88ba-15610caf092f";
  public final static String LOCAL_ID = "Term 4 2014";
  private final String REF_ID_1 = "68681573-638e-4aa7-abdc-4fe19788f772";
  private final String REF_ID_2 = "369d4b5d-95e5-4751-be88-84dd439c4c21";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    TimeTableType timeTable = new TimeTableType();
    timeTable.setRefId(REF_ID);
    timeTable.setSchoolInfoRefId(objectFactory.createTimeTableTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    timeTable.setSchoolLocalId(objectFactory.createTimeTableTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
    timeTable.setSchoolName(objectFactory.createTimeTableTypeSchoolName(SchoolInfoConsumerTest.SCHOOL_NAME));
    timeTable.setSchoolYear(getDate("2014"));
    timeTable.setLocalId(objectFactory.createTimeTableTypeLocalId(LOCAL_ID));
    timeTable.setTitle("TERM 4 2014");
    timeTable.setDaysPerCycle(5L);
    timeTable.setPeriodsPerDay(6L);
    timeTable.setTimeTableCreationDate(objectFactory.createTimeTableTypeTimeTableCreationDate(getDate("2014-06-01")));
    timeTable.setStartDate(objectFactory.createTimeTableTypeStartDate(getDate("2014-09-01")));
    timeTable.setEndDate(objectFactory.createTimeTableTypeEndDate(getDate("2014-12-21")));
    
    TimeTableDayList timeTableDayList = new TimeTableDayList();
    TimeTableDay timeTableDay = new TimeTableDay();
    timeTableDay.setDayId("1");
    timeTableDay.setDayTitle("Monday");
    timeTableDayList.getTimeTableDay().add(timeTableDay);
    timeTableDay = new TimeTableDay();
    timeTableDay.setDayId("2");
    timeTableDay.setDayTitle("Tuesday");
    timeTableDayList.getTimeTableDay().add(timeTableDay);
    timeTableDay = new TimeTableDay();
    timeTableDay.setDayId("3");
    timeTableDay.setDayTitle("Wednesday");
    timeTableDayList.getTimeTableDay().add(timeTableDay);
    timeTableDay = new TimeTableDay();
    timeTableDay.setDayId("4");
    timeTableDay.setDayTitle("Thursday");
    timeTableDayList.getTimeTableDay().add(timeTableDay);
    timeTableDay = new TimeTableDay();
    timeTableDay.setDayId("5");
    timeTableDay.setDayTitle("Friday");
    
    TimeTablePeriodList timeTablePeriodList = new TimeTablePeriodList();
    TimeTablePeriod timeTablePeriod = new TimeTablePeriod();
    timeTablePeriod.setPeriodId("1");
    timeTablePeriod.setPeriodTitle("Form");
    timeTablePeriod.setBellPeriod(objectFactory.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod("1"));
    timeTablePeriod.setStartTime(objectFactory.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(getDate("08:45:00")));
    timeTablePeriod.setEndTime(objectFactory.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(getDate("09:00:00")));
    timeTablePeriodList.getTimeTablePeriod().add(timeTablePeriod);
    timeTableDay.setTimeTablePeriodList(timeTablePeriodList);
    
    timeTableDayList.getTimeTableDay().add(timeTableDay);
    timeTable.setTimeTableDayList(timeTableDayList);
    timeTableTester.doCreateOne(timeTable);
    String xmlExpectedTo = timeTableTester.getXML(timeTable);
    
    timeTable.setRefId("52d3f540-b619-41a4-961c-27ab156c89dd");
    timeTableTester.doCreateOne(timeTable);
    
    timeTable.setRefId("09900c4f-1ac6-4581-a65e-10d978d98bb3");
    timeTableTester.doCreateOne(timeTable);

    timeTable.setRefId("4654dc21-e632-47f0-a604-e7ed7368f335");
    timeTableTester.doCreateOne(timeTable);
    timeTable.setTimeTableDayList(null);
    timeTableTester.doUpdateOne(timeTable, timeTable.getRefId());

    timeTable.setRefId("626e3e08-cab9-4ddd-80fa-26fbf325b8c9");
    timeTableTester.doCreateOne(timeTable);

    TimeTableType getResult = timeTableTester.doGetOne(REF_ID);
    String xmlExpectedFrom = timeTableTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    timeTableTester = new ConsumerTest<TimeTableType, TimeTableCollectionType>(
        TimeTableType.class, "TimeTable", TimeTableCollectionType.class, "TimeTables");
    timeTableTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    List<Response> responses = timeTableTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableType timeTable = (TimeTableType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTable.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = timeTableTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableCollectionType timeTables = (TimeTableCollectionType) response.getDataObject();
    Assert.assertNotNull(timeTables.getTimeTable());
    Assert.assertEquals(5, timeTables.getTimeTable().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = timeTableTester.testCreateOne("timetable.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    TimeTableType timeTable = (TimeTableType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTable.getRefId());
    
    List<Response> deleteResponses = timeTableTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = timeTableTester.testCreateMany("timetables.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = timeTableTester.testDeleteMany(REF_IDS);
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
