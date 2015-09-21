package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentPeriodAttendanceCollectionType;
import sif.dd.au30.model.StudentPeriodAttendanceType;
import sif.dd.au30.model.StudentPeriodAttendanceType.AuditInfo;
import sif.dd.au30.model.StudentPeriodAttendanceType.AuditInfo.CreationUser;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentPeriodAttendanceConsumerTest extends BaseTest {
  private ConsumerTest<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType> studentPeriodAttendanceTester = null;

  public static final String REF_ID = "33ca9a7c-131f-4058-8f04-e96abddf29cd";
  private final String REF_ID_1 = "14bb2fe7-0a99-4858-bedf-635b24cff18c";
  private final String REF_ID_2 = "30f645ff-9ad4-4a21-9120-87ce2efcccd6";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    StudentPeriodAttendanceType studentPeriodAttendance = new StudentPeriodAttendanceType();
    studentPeriodAttendance.setRefId(REF_ID);
    studentPeriodAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
    studentPeriodAttendance.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    studentPeriodAttendance.setDate(getDate("2014-11-11"));
    studentPeriodAttendance.setSessionInfoRefId(objectFactory
        .createStudentPeriodAttendanceTypeSessionInfoRefId(SessionInfoConsumerTest.REF_ID));
    studentPeriodAttendance.setTimetablePeriod(objectFactory.createStudentPeriodAttendanceTypeTimetablePeriod("P6"));
    studentPeriodAttendance.setTimeIn(objectFactory.createStudentPeriodAttendanceTypeTimeIn(getDate("09:00:00")));
    studentPeriodAttendance.setTimeOut(objectFactory.createStudentPeriodAttendanceTypeTimeOut(getDate("15:30:00")));
    AttendanceCodeType attendanceCode = new AttendanceCodeType();
    attendanceCode.setCode("802");
    studentPeriodAttendance.setAttendanceCode(attendanceCode);
    studentPeriodAttendance.setAttendanceStatus("01");
    studentPeriodAttendance.setSchoolYear(objectFactory.createStudentPeriodAttendanceTypeSchoolYear(getDate("2014")));
    studentPeriodAttendance.setAttendanceComment(objectFactory
        .createStudentPeriodAttendanceTypeAttendanceComment("The Comments"));
    AuditInfo auditInfo = new AuditInfo();
    Calendar calendar = Calendar.getInstance();
    calendar.set(2014, 12, 20, 15, 17, 54);
    calendar.set(Calendar.MILLISECOND, 444);
    auditInfo.setCreationDateTime(calendar);
    CreationUser creationUser = new CreationUser();
    creationUser.setType("Teacher");
    creationUser.setUserId("ez204ff0");
    auditInfo.setCreationUser(creationUser);
    studentPeriodAttendance.setAuditInfo(objectFactory.createStudentPeriodAttendanceTypeAuditInfo(auditInfo));

    studentPeriodAttendanceTester.doCreateOne(studentPeriodAttendance);
    String xmlExpectedTo = studentPeriodAttendanceTester.getXML(studentPeriodAttendance);

    studentPeriodAttendance.setRefId("3636bd1e-0821-4785-9c71-63b9add400ad");
    studentPeriodAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
    studentPeriodAttendanceTester.doCreateOne(studentPeriodAttendance);

    studentPeriodAttendance.setRefId("ebb0c804-d4b7-45e4-bdb0-d5b06157aed9");
    studentPeriodAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
    studentPeriodAttendanceTester.doCreateOne(studentPeriodAttendance);

    studentPeriodAttendance.setRefId("34a1cdcd-86eb-4928-bcaf-41ab90c0dafc");
    studentPeriodAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
    studentPeriodAttendanceTester.doCreateOne(studentPeriodAttendance);

    studentPeriodAttendance.setRefId("6e24c6dc-371a-4c7d-9a0b-cd160c1fd267");
    studentPeriodAttendance.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5);
    studentPeriodAttendanceTester.doCreateOne(studentPeriodAttendance);

    StudentPeriodAttendanceType getResult = studentPeriodAttendanceTester.doGetOne(REF_ID);
    String xmlExpectedFrom = studentPeriodAttendanceTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentPeriodAttendanceTester = new ConsumerTest<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType>(
        StudentPeriodAttendanceType.class, "StudentPeriodAttendance", StudentPeriodAttendanceCollectionType.class,
        "StudentPeriodAttendances");
    studentPeriodAttendanceTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = studentPeriodAttendanceTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPeriodAttendanceType studentPeriodAttendance = (StudentPeriodAttendanceType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentPeriodAttendance.getRefId());

    String xmlExpectedFrom = studentPeriodAttendanceTester.getXML(studentPeriodAttendance);

    List<Response> updateResponses = studentPeriodAttendanceTester.doUpdateOne(studentPeriodAttendance, REF_ID);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = studentPeriodAttendanceTester.testGetSingle(REF_ID);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    StudentPeriodAttendanceType comparisonTo = (StudentPeriodAttendanceType) getResponse.getDataObject();
    Assert.assertEquals(REF_ID, comparisonTo.getRefId());
    String xmlExpectedTo = studentPeriodAttendanceTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = studentPeriodAttendanceTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPeriodAttendanceType studentPeriodAttendance = (StudentPeriodAttendanceType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentPeriodAttendance.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = studentPeriodAttendanceTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPeriodAttendanceCollectionType studentPeriodAttendances = (StudentPeriodAttendanceCollectionType) response
        .getDataObject();
    Assert.assertNotNull(studentPeriodAttendances.getStudentPeriodAttendance());
    Assert.assertEquals(5, studentPeriodAttendances.getStudentPeriodAttendance().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = studentPeriodAttendanceTester.testCreateOne("studentperiodattendance.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentPeriodAttendanceType timeTable = (StudentPeriodAttendanceType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTable.getRefId());

    List<Response> deleteResponses = studentPeriodAttendanceTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentPeriodAttendanceTester
        .testCreateMany("studentperiodattendances.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentPeriodAttendanceTester
        .testDeleteMany(REF_IDS);
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
