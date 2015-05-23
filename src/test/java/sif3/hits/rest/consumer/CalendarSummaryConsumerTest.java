package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CalendarSummaryConsumerTest extends BaseTest {
  private ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType> calendarSummaryTester = null;
  
  public static final String REF_ID = "FCCC615A828841488934424AE2DA69CA";
  private final String REF_ID_1 = "F9B62C7FFEFD44BEBC0F42389AB226D4";
  private final String REF_ID_2 = "F0A8EEA4D0024EF69164EF430E3E77F0";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    CalendarSummaryType calendarSummary = new CalendarSummaryType();
    calendarSummary.setRefId(REF_ID);
    calendarSummary.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    calendarSummary.setSchoolYear(getDate("2014"));
    calendarSummary.setLocalId("Local Id");
    calendarSummary.setDaysInSession(75L);
    calendarSummary.setStartDate(objectFactory.createCalendarSummaryTypeStartDate(getDate("2014-07-02")));
    calendarSummary.setEndDate(objectFactory.createCalendarSummaryTypeEndDate(getDate("2014-11-02")));
    calendarSummary.setFirstInstructionDate(objectFactory.createCalendarSummaryTypeFirstInstructionDate(getDate("2014-07-12")));
    calendarSummary.setLastInstructionDate(objectFactory.createCalendarSummaryTypeLastInstructionDate(getDate("2014-10-12")));
    calendarSummary.setInstructionalMinutes(objectFactory.createCalendarSummaryTypeInstructionalMinutes(999L));
    calendarSummary.setMinutesPerDay(objectFactory.createCalendarSummaryTypeMinutesPerDay(450L));
    
    YearLevelsType yearLevels = new YearLevelsType();
    YearLevelType yearLevel = new YearLevelType();
    yearLevel.setCode("4");
    yearLevels.getYearLevel().add(yearLevel);
    yearLevel = new YearLevelType();
    yearLevel.setCode("5");
    yearLevels.getYearLevel().add(yearLevel);
    calendarSummary.setYearLevels(objectFactory.createCalendarSummaryTypeYearLevels(yearLevels));
    
    calendarSummaryTester.doCreateOne(calendarSummary);
    String xmlExpectedTo = calendarSummaryTester.getXML(calendarSummary);
    
    calendarSummary.setRefId("0CE39BE7F574445AA2103303AE5E3642");
    calendarSummaryTester.doCreateOne(calendarSummary);

    calendarSummary.setRefId("5A0BC81D3E964B4894C58E25A0562998");
    calendarSummaryTester.doCreateOne(calendarSummary);

    calendarSummary.setRefId("7E947C78E69D4D0F8CADC46E4AF91B9B");
    calendarSummaryTester.doCreateOne(calendarSummary);

    calendarSummary.setYearLevels(null);
    calendarSummaryTester.doUpdateOne(calendarSummary, calendarSummary.getRefId());

    calendarSummary.setRefId("24DD6830126A4A8FAA4EC7045E68F8F0");
    calendarSummaryTester.doCreateOne(calendarSummary);

    CalendarSummaryType getResult = calendarSummaryTester.doGetOne(REF_ID);
    String xmlExpectedFrom = calendarSummaryTester.getXML(getResult);
    
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);  
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    calendarSummaryTester = new ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType>(
        CalendarSummaryType.class, "CalendarSummary", CalendarSummaryCollectionType.class, "CalendarSummarys");
    calendarSummaryTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
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

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = calendarSummaryTester
        .testCreateMany("calendarsummarys.xml");
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
