package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AttendanceCodeType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.StudentAttendanceTimeListCollectionType;
import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif.dd.au30.model.StudentAttendanceTimeListType.AttendanceTimes;
import sif.dd.au30.model.StudentAttendanceTimeListType.AttendanceTimes.AttendanceTime;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentAttendanceTimeListConsumerTest extends BaseTest {
  private ConsumerTest<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType> studentAttendanceTimeListTester = null;

  public static final String REF_ID = "A761755C380747D3B7B4BFDD147685F4";
  private final String REF_ID_1 = "2205C3E4089C4CFB98A5FB0121FA12E1";
  private final String REF_ID_2 = "3EC79D15B5E840A8BE56587AE099015B";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  private AttendanceTime getAttendanceTime(String startTime, String endTime, String status, String absence,
      String note, String code, String... otherCodes) throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    AttendanceTime attendanceTime = new AttendanceTime();
    if (StringUtils.isNotBlank(absence)) {
      attendanceTime.setAbsenceValue(objectFactory
          .createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTimeAbsenceValue(new BigDecimal(absence)));
    }
    if (StringUtils.isNotBlank(note)) {
      attendanceTime.setAttendanceNote(objectFactory
          .createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTimeAttendanceNote(note));
    }
    attendanceTime.setAttendanceStatus(status);
    attendanceTime.setStartTime(getDate(startTime));
    attendanceTime.setEndTime(getDate(endTime));

    AttendanceCodeType attendanceCodeType = new AttendanceCodeType();
    attendanceTime.setAttendanceCode(attendanceCodeType);
    attendanceCodeType.setCode(code);
    if (otherCodes != null && otherCodes.length > 1) {
      OtherCodeListType otherCodeListType = new OtherCodeListType();
      for (int i = 0; i < otherCodes.length; i += 2) {
        OtherCode otherCode = new OtherCode();
        otherCode.setValue(otherCodes[i]);
        otherCode.setCodeset(otherCodes[i + 1]);
        otherCodeListType.getOtherCode().add(otherCode);
      }
      attendanceCodeType.setOtherCodeList(objectFactory.createAttendanceCodeTypeOtherCodeList(otherCodeListType));
    }
    return attendanceTime;
  }

  @Test
  public void initialiseData() throws Exception {
    StudentAttendanceTimeListType studentAttendanceTimeList = new StudentAttendanceTimeListType();
    studentAttendanceTimeList.setRefId(REF_ID);
    studentAttendanceTimeList.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
    studentAttendanceTimeList.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    studentAttendanceTimeList.setDate(getDate("2014-11-11"));
    studentAttendanceTimeList.setSchoolYear(getDate("2014"));

    AttendanceTimes attendanceTimes = new AttendanceTimes();
    studentAttendanceTimeList.setAttendanceTimes(attendanceTimes);
    attendanceTimes.getAttendanceTime().add(getAttendanceTime("09:00:00", "11:00:00", "01", null, null, "100"));
    attendanceTimes.getAttendanceTime().add(
        getAttendanceTime("11:00:00", "13:00:00", "01", "0.2", "Orthodontist Appt, returned to school.", "200", "S",
            "Local", "C", "Text"));
    attendanceTimes.getAttendanceTime().add(
        getAttendanceTime("13:00:00", "15:30:00", "01", null, null, "100", "C", "Text"));

    studentAttendanceTimeListTester.doCreateOne(studentAttendanceTimeList);
    String xmlExpectedTo = studentAttendanceTimeListTester.getXML(studentAttendanceTimeList);

    studentAttendanceTimeList.setRefId("DA9C1EE245244C378BF1ED638FEDDDC2");
    studentAttendanceTimeList.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
    studentAttendanceTimeListTester.doCreateOne(studentAttendanceTimeList);

    studentAttendanceTimeList.setRefId("E74E140DDA2A461DBB35ABA58DE630DA");
    studentAttendanceTimeList.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
    studentAttendanceTimeListTester.doCreateOne(studentAttendanceTimeList);

    studentAttendanceTimeList.setRefId("38B861A598A1484387F4806147E6A26B");
    studentAttendanceTimeList.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
    studentAttendanceTimeListTester.doCreateOne(studentAttendanceTimeList);

    studentAttendanceTimeList.setRefId("6F3E12C90D604A2C8FED4F1ACE185F4F");
    studentAttendanceTimeList.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5);
    studentAttendanceTimeListTester.doCreateOne(studentAttendanceTimeList);

    StudentAttendanceTimeListType getResult = studentAttendanceTimeListTester.doGetOne(REF_ID);
    String xmlExpectedFrom = studentAttendanceTimeListTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentAttendanceTimeListTester = new ConsumerTest<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType>(
        StudentAttendanceTimeListType.class, "StudentAttendanceTimeList",
        StudentAttendanceTimeListCollectionType.class, "StudentAttendanceTimeLists");
    studentAttendanceTimeListTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = studentAttendanceTimeListTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentAttendanceTimeListType studentAttendanceTimeList = (StudentAttendanceTimeListType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentAttendanceTimeList.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = studentAttendanceTimeListTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentAttendanceTimeListCollectionType studentAttendanceTimeLists = (StudentAttendanceTimeListCollectionType) response
        .getDataObject();
    Assert.assertNotNull(studentAttendanceTimeLists.getStudentAttendanceTimeList());
    Assert.assertEquals(5, studentAttendanceTimeLists.getStudentAttendanceTimeList().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = studentAttendanceTimeListTester.testCreateOne("studentattendancetimelist.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentAttendanceTimeListType timeTable = (StudentAttendanceTimeListType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTable.getRefId());

    List<Response> deleteResponses = studentAttendanceTimeListTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateUpdate() {
    List<Response> createResponses = studentAttendanceTimeListTester.testCreateOne("studentattendancetimelist.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentAttendanceTimeListType studentAttendanceTimeList = (StudentAttendanceTimeListType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, studentAttendanceTimeList.getRefId());
    Assert.assertEquals(3, studentAttendanceTimeList.getAttendanceTimes().getAttendanceTime().size());
    
    List<Response> updateResponses = studentAttendanceTimeListTester.testUpdateOne("studentattendancetimelistupdate.xml", REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Response updateResponse = updateResponses.get(0);
    Assert.assertNull(updateResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), updateResponse.getStatus());
    
    List<Response> responses = studentAttendanceTimeListTester.testGetSingle(REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentAttendanceTimeListType studentAttendanceTimeListUpdated = (StudentAttendanceTimeListType) response.getDataObject();
    Assert.assertEquals(REF_ID_1, studentAttendanceTimeListUpdated.getRefId());
    Assert.assertEquals(4, studentAttendanceTimeListUpdated.getAttendanceTimes().getAttendanceTime().size());

    studentAttendanceTimeListTester.testDeleteOne(REF_ID_1);
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentAttendanceTimeListTester
        .testCreateMany("studentattendancetimelists.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentAttendanceTimeListTester
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