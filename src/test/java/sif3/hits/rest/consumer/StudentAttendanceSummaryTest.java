package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentAttendanceSummaryCollectionType;
import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentAttendanceSummaryTest extends BaseTest {
  private ConsumerTest<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType> studentAttendanceSummaryTest = null;
  
  public static final String REF_ID = "9A6F7AC869494F338407ED6FDBD08564";
  private final String REF_ID_1 = "3DE3AEFB96B54D029F44BA579CDBC7B5";
  private final String REF_ID_2 = "1382A1E55AE44622B3B0D23EA52B1117";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    StudentAttendanceSummaryType studentAttendanceSummary = new StudentAttendanceSummaryType();
    studentAttendanceSummary.setStudentAttendanceSummaryRefId(objectFactory.createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId(REF_ID));
    studentAttendanceSummary.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    studentAttendanceSummary.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
    studentAttendanceSummary.setSchoolYear(getDate("2014"));
    studentAttendanceSummary.setStartDate(getDate("2014-09-01"));
    studentAttendanceSummary.setEndDate(getDate("2014-09-05"));
    studentAttendanceSummary.setStartDay(objectFactory.createStudentAttendanceSummaryTypeStartDay(1L));
    studentAttendanceSummary.setEndDay(objectFactory.createStudentAttendanceSummaryTypeEndDay(5L));
    studentAttendanceSummary.setFTE(objectFactory.createStudentAttendanceSummaryTypeFTE(new BigDecimal("1.0")));
    studentAttendanceSummary.setDaysAttended(new BigDecimal("4.5"));
    studentAttendanceSummary.setExcusedAbsences(BigDecimal.ZERO);
    studentAttendanceSummary.setUnexcusedAbsences(new BigDecimal("0.5"));
    studentAttendanceSummary.setDaysTardy(objectFactory.createStudentAttendanceSummaryTypeDaysTardy(new BigDecimal("2")));
    studentAttendanceSummary.setDaysInMembership(new BigDecimal("5"));
    studentAttendanceSummaryTest.doCreateOne(studentAttendanceSummary);
    String xmlExpectedTo = studentAttendanceSummaryTest.getXML(studentAttendanceSummary);
    
    studentAttendanceSummary.setStudentAttendanceSummaryRefId(objectFactory.createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId("61D0EE014C3C471092FEBCBFD4764912"));
    studentAttendanceSummary.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
    studentAttendanceSummaryTest.doCreateOne(studentAttendanceSummary);

    studentAttendanceSummary.setStudentAttendanceSummaryRefId(objectFactory.createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId("4BECA256C88047FE98875DF45FD71E41"));
    studentAttendanceSummary.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
    studentAttendanceSummaryTest.doCreateOne(studentAttendanceSummary);

    studentAttendanceSummary.setStudentAttendanceSummaryRefId(objectFactory.createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId("9651425CB9E9427B89B655D64A07D375"));
    studentAttendanceSummary.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
    studentAttendanceSummaryTest.doCreateOne(studentAttendanceSummary);

    studentAttendanceSummary.setStudentAttendanceSummaryRefId(objectFactory.createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId("D708A61B2FAD4A84A298D5ED23F88747"));
    studentAttendanceSummary.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5);
    studentAttendanceSummaryTest.doCreateOne(studentAttendanceSummary);
    
    
    StudentAttendanceSummaryType getResult = studentAttendanceSummaryTest.doGetOne(REF_ID);
    String xmlExpectedFrom = studentAttendanceSummaryTest.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentAttendanceSummaryTest = new ConsumerTest<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType>(
        StudentAttendanceSummaryType.class, "StudentAttendanceSummary", StudentAttendanceSummaryCollectionType.class, "StudentAttendanceSummarys");
    studentAttendanceSummaryTest.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    
    List<Response> responses = studentAttendanceSummaryTest.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentAttendanceSummaryType studentDailyAttendance = (StudentAttendanceSummaryType) response.getDataObject();
    Assert.assertNotNull(studentDailyAttendance.getStudentAttendanceSummaryRefId());
    Assert.assertEquals(REF_ID, studentDailyAttendance.getStudentAttendanceSummaryRefId().getValue());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = studentAttendanceSummaryTest.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentAttendanceSummaryCollectionType studentAttendanceSummarys = (StudentAttendanceSummaryCollectionType) response.getDataObject();
    Assert.assertNotNull(studentAttendanceSummarys.getStudentAttendanceSummary());
    Assert.assertEquals(5, studentAttendanceSummarys.getStudentAttendanceSummary().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = studentAttendanceSummaryTest.testCreateOne("studentattendancesummary.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentAttendanceSummaryType timeTable = (StudentAttendanceSummaryType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTable.getStudentAttendanceSummaryRefId().getValue());
    
    List<Response> deleteResponses = studentAttendanceSummaryTest.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentAttendanceSummaryTest.testCreateMany("studentattendancesummarys.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentAttendanceSummaryTest.testDeleteMany(REF_IDS);
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
