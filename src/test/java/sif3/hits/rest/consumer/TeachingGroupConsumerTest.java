package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupType;
import sif.dd.au30.model.TeachingGroupType.StudentList;
import sif.dd.au30.model.TeachingGroupType.StudentList.TeachingGroupStudent;
import sif.dd.au30.model.TeachingGroupType.TeacherList;
import sif.dd.au30.model.TeachingGroupType.TeacherList.TeachingGroupTeacher;
import sif.dd.au30.model.TeachingGroupType.TeachingGroupPeriodList;
import sif.dd.au30.model.TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StaffPersonalConsumerTest.StaffPersonalRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TeachingGroupConsumerTest extends BaseTest {
  private ConsumerTest<TeachingGroupType, TeachingGroupCollectionType> teachingGroupTester = null;

  public static final String REF_ID = "597ad3fe-47e7-4b2c-b919-a93c564d19d0";
  public static final String LOCAL_ID = "Local Id";
  private final String REF_ID_1 = "1be77e87-467f-4f9d-8800-be64cb678e0e";
  private final String REF_ID_2 = "04446653-933e-44b5-8fa7-963bd8d64587";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    TeachingGroupType teachingGroup = new TeachingGroupType();
    teachingGroup.setRefId(REF_ID);
    teachingGroup.setSchoolInfoRefId(objectFactory
        .createTeachingGroupTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    teachingGroup.setSchoolCourseLocalId(objectFactory
        .createTeachingGroupTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
    teachingGroup.setShortName("Short Name");
    teachingGroup.setLongName(objectFactory.createTeachingGroupTypeLongName("Long Name"));
    teachingGroup.setLocalId(LOCAL_ID);
    teachingGroup.setSchoolYear(getDate("2014"));

    TeacherList teacherList = new TeacherList();
    TeachingGroupTeacher teacher = new TeachingGroupTeacher();
    teacher
        .setStaffPersonalRefId(objectFactory
            .createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1));
    teacher.setStaffLocalId("ez7b7b7");
    teacher.setAssociation("Class Teacher");
    teacher.setName(StaffPersonalRefIds.getNameOfRecord(objectFactory));
    teacherList.getTeachingGroupTeacher().add(teacher);
    teachingGroup.setTeacherList(objectFactory.createTeachingGroupTypeTeacherList(teacherList));

    StudentList studentList = new StudentList();
    TeachingGroupStudent student = new TeachingGroupStudent();
    student.setStudentPersonalRefId(objectFactory
        .createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1));
    student.setName(StudentPersonalRefIds.getNameOfRecord(objectFactory));
    student.setStudentLocalId(StudentPersonalRefIds.LOCAL_ID);
    studentList.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudent();
    student.setStudentPersonalRefId(objectFactory
        .createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2));
    student.setName(StudentPersonalRefIds.getNameOfRecord(objectFactory));
    student.setStudentLocalId(StudentPersonalRefIds.LOCAL_ID);
    studentList.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudent();
    student.setStudentPersonalRefId(objectFactory
        .createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3));
    student.setName(StudentPersonalRefIds.getNameOfRecord(objectFactory));
    student.setStudentLocalId(StudentPersonalRefIds.LOCAL_ID);
    studentList.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudent();
    student.setStudentPersonalRefId(objectFactory
        .createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4));
    student.setName(StudentPersonalRefIds.getNameOfRecord(objectFactory));
    student.setStudentLocalId(StudentPersonalRefIds.LOCAL_ID);
    studentList.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudent();
    student.setStudentPersonalRefId(objectFactory
        .createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5));
    student.setName(StudentPersonalRefIds.getNameOfRecord(objectFactory));
    student.setStudentLocalId(StudentPersonalRefIds.LOCAL_ID);
    studentList.getTeachingGroupStudent().add(student);

    teachingGroup.setStudentList(objectFactory.createTeachingGroupTypeStudentList(studentList));

    // Need to add TeachingGroupPeriods!
    TeachingGroupPeriodList periodList = new TeachingGroupPeriodList();
    TeachingGroupPeriod period = new TeachingGroupPeriod();
    period.setTimeTableCellRefId(objectFactory.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID));
    period.setRoomNumber(objectFactory.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(RoomInfoConsumerTest.ROOM_NUMBER));
    period.setCellType(objectFactory.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(TimeTableCellConsumerTest.CELL_TYPE));
    period.setStaffLocalId(objectFactory.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(StaffPersonalRefIds.LOCAL_ID));
    period.setDayId(TimeTableCellConsumerTest.DAY_ID);
    period.setPeriodId(objectFactory.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(TimeTableCellConsumerTest.PERIOD_ID));
    periodList.getTeachingGroupPeriod().add(period);
    teachingGroup.setTeachingGroupPeriodList(objectFactory.createTeachingGroupTypeTeachingGroupPeriodList(periodList));
    
    teachingGroupTester.doCreateOne(teachingGroup);
    String xmlExpectedTo = teachingGroupTester.getXML(teachingGroup);

    teachingGroup.setRefId("6cd60385-006e-4268-92ef-f69ffc8c5c9f");
    teacher
        .setStaffPersonalRefId(objectFactory
            .createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_2));
    teachingGroupTester.doCreateOne(teachingGroup);

    teachingGroup.setRefId("ef3a3fab-ba19-4974-b1d0-ec2ceb9d9ff6");
    teacher
        .setStaffPersonalRefId(objectFactory
            .createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_3));
    teachingGroupTester.doCreateOne(teachingGroup);

    teachingGroup.setRefId("af76418f-fcaf-45d3-b0cf-416abac3a810");
    teacher
        .setStaffPersonalRefId(objectFactory
            .createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_4));
    teachingGroupTester.doCreateOne(teachingGroup);

    teachingGroup.setRefId("e22faf89-f4a6-4ba6-ba3b-95474f259232");
    teacher
        .setStaffPersonalRefId(objectFactory
            .createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_5));
    teachingGroupTester.doCreateOne(teachingGroup);
    
    TeachingGroupType getResult = teachingGroupTester.doGetOne(REF_ID);
    String xmlExpectedFrom = teachingGroupTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }

  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    teachingGroupTester = new ConsumerTest<TeachingGroupType, TeachingGroupCollectionType>(TeachingGroupType.class,
        "TeachingGroup", TeachingGroupCollectionType.class, "TeachingGroups");
    teachingGroupTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TeachingGroupType teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());

    String xmlExpectedFrom = teachingGroupTester.getXML(teachingGroup);

    List<Response> updateResponses = teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    TeachingGroupType comparisonTo = (TeachingGroupType) getResponse.getDataObject();
    Assert.assertEquals(REF_ID, comparisonTo.getRefId());
    String xmlExpectedTo = teachingGroupTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TeachingGroupType teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = teachingGroupTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TeachingGroupCollectionType teachingGroupCollection = (TeachingGroupCollectionType) response.getDataObject();
    Assert.assertNotNull(teachingGroupCollection.getTeachingGroup());
    Assert.assertEquals(5, teachingGroupCollection.getTeachingGroup().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = teachingGroupTester.testCreateOne("teachinggroup.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    TeachingGroupType teachingGroup = (TeachingGroupType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, teachingGroup.getRefId());

    List<Response> deleteResponses = teachingGroupTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = teachingGroupTester
        .testCreateMany("teachinggroups.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = teachingGroupTester.testDeleteMany(REF_IDS);
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
