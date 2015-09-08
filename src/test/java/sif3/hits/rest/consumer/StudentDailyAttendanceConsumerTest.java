package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsDayValueCodeType;
import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentDailyAttendanceCollectionType;
import sif.dd.au30.model.StudentDailyAttendanceType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentDailyAttendanceConsumerTest extends BaseTest {
  private ConsumerTest<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType> studentDailyAttendanceTester = null;

  public static final String REF_ID = "ea816a85-91d3-412c-a85e-7e4a20c97189";
  private final String REF_ID_1 = "96c40bb2-40b5-49fa-8549-e744698828c4";
  private final String REF_ID_2 = "3f8280e4-8526-4cd8-8708-bf4032bd740a";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    
    StudentDailyAttendanceType studentDailyAttendance = new StudentDailyAttendanceType();
    studentDailyAttendance.setRefId(REF_ID);
    studentDailyAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
    studentDailyAttendance.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    studentDailyAttendance.setDate(getDate("2014-09-04"));
    studentDailyAttendance.setSchoolYear(getDate("2014"));
    studentDailyAttendance.setDayValue(objectFactory.createStudentDailyAttendanceTypeDayValue(AUCodeSetsDayValueCodeType.FULL));
    AttendanceCodeType attendanceCodeType = new AttendanceCodeType();
    attendanceCodeType.setCode("100");
    studentDailyAttendance.setAttendanceCode(attendanceCodeType);
    studentDailyAttendance.setAttendanceStatus("NA");
    studentDailyAttendance.setTimeIn(objectFactory.createStudentDailyAttendanceTypeTimeIn(getDate("08:30:00")));
    studentDailyAttendance.setTimeOut(objectFactory.createStudentDailyAttendanceTypeTimeOut(getDate("15:30:00")));
    studentDailyAttendance.setAbsenceValue(objectFactory.createStudentDailyAttendanceTypeAbsenceValue(BigDecimal.ZERO));
    studentDailyAttendance.setAttendanceNote(objectFactory.createStudentDailyAttendanceTypeAttendanceNote("Attendance Note"));
    studentDailyAttendanceTester.doCreateOne(studentDailyAttendance);
    String xmlExpectedTo= studentDailyAttendanceTester.getXML(studentDailyAttendance);
    
    studentDailyAttendance.setRefId("2b3728fa-0c62-4b04-a936-c9194791f79a");
    studentDailyAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
    studentDailyAttendanceTester.doCreateOne(studentDailyAttendance);

    studentDailyAttendance.setRefId("f807f15e-9568-48ce-aaaf-4b08cbae3ff4");
    studentDailyAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
    studentDailyAttendanceTester.doCreateOne(studentDailyAttendance);

    studentDailyAttendance.setRefId("9c337631-09f3-4bf6-a564-ce0068138db2");
    studentDailyAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
    studentDailyAttendanceTester.doCreateOne(studentDailyAttendance);

    studentDailyAttendance.setRefId("6c6109d8-3b7f-4fc8-aa8f-0c69359c3c8d");
    studentDailyAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5);
    studentDailyAttendanceTester.doCreateOne(studentDailyAttendance);
    
    StudentDailyAttendanceType getResult = studentDailyAttendanceTester.doGetOne(REF_ID);
    String xmlExpectedFrom = studentDailyAttendanceTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentDailyAttendanceTester = new ConsumerTest<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType>(
        StudentDailyAttendanceType.class, "StudentDailyAttendance", StudentDailyAttendanceCollectionType.class,
        "StudentDailyAttendances");
    studentDailyAttendanceTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {

    List<Response> responses = studentDailyAttendanceTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentDailyAttendanceType studentDailyAttendance = (StudentDailyAttendanceType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentDailyAttendance.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = studentDailyAttendanceTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentDailyAttendanceCollectionType studentDailyAttendances = (StudentDailyAttendanceCollectionType) response
        .getDataObject();
    Assert.assertNotNull(studentDailyAttendances.getStudentDailyAttendance());
    Assert.assertEquals(5, studentDailyAttendances.getStudentDailyAttendance().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = studentDailyAttendanceTester.testCreateOne("studentdailyattendance.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentDailyAttendanceType timeTable = (StudentDailyAttendanceType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTable.getRefId());

    List<Response> deleteResponses = studentDailyAttendanceTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentDailyAttendanceTester
        .testCreateMany("studentdailyattendances.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentDailyAttendanceTester.testDeleteMany(REF_IDS);
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
