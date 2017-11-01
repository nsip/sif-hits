package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentListType;
import sif.dd.au30.model.TeacherListType;
import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupPeriodListType;
import sif.dd.au30.model.TeachingGroupPeriodType;
import sif.dd.au30.model.TeachingGroupStudentType;
import sif.dd.au30.model.TeachingGroupTeacherType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
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
    teachingGroup.setSchoolInfoRefId(objectFactory.createTeachingGroupTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    teachingGroup.setSchoolCourseLocalId(objectFactory.createTeachingGroupTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
    teachingGroup.setShortName("Short Name");
    teachingGroup.setLongName(objectFactory.createTeachingGroupTypeLongName("Long Name"));
    teachingGroup.setLocalId(LOCAL_ID);
    teachingGroup.setTimeTableSubjectRefId(objectFactory.createTeachingGroupTypeTimeTableSubjectRefId(TimeTableSubjectConsumerTest.REF_ID));
    teachingGroup.setTimeTableSubjectLocalId(objectFactory.createTeachingGroupTypeTimeTableSubjectLocalId(TimeTableSubjectConsumerTest.LOCAL_ID));
    teachingGroup.setSchoolYear(getDate("2014"));

    TeacherListType teacherList = new TeacherListType();
    TeachingGroupTeacherType teacher = new TeachingGroupTeacherType();
    teacher.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1));
    teacher.setStaffLocalId(objectFactory.createTeachingGroupTeacherTypeStaffLocalId(StaffPersonalRefIds.LOCAL_ID));
    teacher.setAssociation("Class Teacher");
    teacher.setName(objectFactory.createTeachingGroupStudentTypeName(StaffPersonalRefIds.getNameOfRecord(objectFactory)));
    teacherList.getTeachingGroupTeacher().add(teacher);
    teachingGroup.setTeacherList(objectFactory.createTeachingGroupTypeTeacherList(teacherList));

    StudentListType studentList = getFullStudentList();

    teachingGroup.setStudentList(objectFactory.createTeachingGroupTypeStudentList(studentList));

    // Need to add TeachingGroupPeriods!
    TeachingGroupPeriodListType periodList = new TeachingGroupPeriodListType();
    TeachingGroupPeriodType period = new TeachingGroupPeriodType();
    period.setTimeTableCellRefId(objectFactory.createTeachingGroupPeriodTypeTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID));
    period.setRoomNumber(objectFactory.createTeachingGroupPeriodTypeRoomNumber(RoomInfoConsumerTest.ROOM_NUMBER));
    period.setCellType(objectFactory.createTeachingGroupPeriodTypeCellType(TimeTableCellConsumerTest.CELL_TYPE));
    period.setStaffLocalId(objectFactory.createTeachingGroupPeriodTypeStaffLocalId(StaffPersonalRefIds.LOCAL_ID));
    period.setDayId(TimeTableCellConsumerTest.DAY_ID);
    period.setPeriodId(objectFactory.createTeachingGroupPeriodTypePeriodId(TimeTableCellConsumerTest.PERIOD_ID));
    periodList.getTeachingGroupPeriod().add(period);
    teachingGroup.setTeachingGroupPeriodList(objectFactory.createTeachingGroupTypeTeachingGroupPeriodList(periodList));

    teachingGroupTester.doCreateOne(teachingGroup);
    teachingGroupTester.doUpdateOne(teachingGroup, teachingGroup.getRefId());
    String xmlExpectedTo = teachingGroupTester.getXML(teachingGroup);

    teachingGroup.setRefId("6cd60385-006e-4268-92ef-f69ffc8c5c9f");
    teacher.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_2));
    teachingGroupTester.doCreateOne(teachingGroup);

    teachingGroup.setRefId("ef3a3fab-ba19-4974-b1d0-ec2ceb9d9ff6");
    teacher.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_3));
    teachingGroupTester.doCreateOne(teachingGroup);

    teachingGroup.setRefId("af76418f-fcaf-45d3-b0cf-416abac3a810");
    teacher.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_4));
    teachingGroupTester.doCreateOne(teachingGroup);

    teachingGroup.setRefId("e22faf89-f4a6-4ba6-ba3b-95474f259232");
    teacher.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_5));
    teachingGroupTester.doCreateOne(teachingGroup);

    TeachingGroupType getResult = teachingGroupTester.doGetOne(REF_ID);
    String xmlExpectedFrom = teachingGroupTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }

  }

  private StudentListType getFullStudentList() {
    StudentListType result = new StudentListType();
    ObjectFactory objectFactory = new ObjectFactory();
    TeachingGroupStudentType student = new TeachingGroupStudentType();
    student.setStudentPersonalRefId(objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1));
    student.setName(objectFactory.createTeachingGroupStudentTypeName(StudentPersonalRefIds.getNameOfRecord(objectFactory)));
    student.setStudentLocalId(objectFactory.createTeachingGroupStudentTypeStudentLocalId(StudentPersonalRefIds.LOCAL_ID));
    result.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudentType();
    student.setStudentPersonalRefId(objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2));
    student.setName(objectFactory.createTeachingGroupStudentTypeName(StudentPersonalRefIds.getNameOfRecord(objectFactory)));
    student.setStudentLocalId(objectFactory.createTeachingGroupStudentTypeStudentLocalId(StudentPersonalRefIds.LOCAL_ID));
    result.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudentType();
    student.setStudentPersonalRefId(objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3));
    student.setName(objectFactory.createTeachingGroupStudentTypeName(StudentPersonalRefIds.getNameOfRecord(objectFactory)));
    student.setStudentLocalId(objectFactory.createTeachingGroupStudentTypeStudentLocalId(StudentPersonalRefIds.LOCAL_ID));
    result.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudentType();
    student.setStudentPersonalRefId(objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4));
    student.setName(objectFactory.createTeachingGroupStudentTypeName(StudentPersonalRefIds.getNameOfRecord(objectFactory)));
    student.setStudentLocalId(objectFactory.createTeachingGroupStudentTypeStudentLocalId(StudentPersonalRefIds.LOCAL_ID));
    result.getTeachingGroupStudent().add(student);

    student = new TeachingGroupStudentType();
    student.setStudentPersonalRefId(objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5));
    student.setName(objectFactory.createTeachingGroupStudentTypeName(StudentPersonalRefIds.getNameOfRecord(objectFactory)));
    student.setStudentLocalId(objectFactory.createTeachingGroupStudentTypeStudentLocalId(StudentPersonalRefIds.LOCAL_ID));
    result.getTeachingGroupStudent().add(student);
    return result;
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    teachingGroupTester = new ConsumerTest<TeachingGroupType, TeachingGroupCollectionType>(TeachingGroupType.class, "TeachingGroup", TeachingGroupCollectionType.class, "TeachingGroups");
    teachingGroupTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testQBE() {
    ObjectFactory objectFactory = new ObjectFactory();
    TeachingGroupType teachingGroup = new TeachingGroupType();
    teachingGroup.setSchoolInfoRefId(objectFactory.createTeachingGroupTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    List<Response> responses = teachingGroupTester.testQBE(teachingGroup, 10000, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    TeachingGroupCollectionType teachingGroupCollectionType = (TeachingGroupCollectionType) response.getDataObject();
    Assert.assertNotNull(teachingGroupCollectionType.getTeachingGroup());
    Assert.assertFalse(teachingGroupCollectionType.getTeachingGroup().isEmpty());
    boolean found = false;
    for (TeachingGroupType teachingGroupType : teachingGroupCollectionType.getTeachingGroup()) {
      found = found || REF_ID.equals(teachingGroupType.getRefId());
      Assert.assertNotNull(teachingGroupType.getSchoolInfoRefId());
      Assert.assertEquals(SchoolInfoConsumerTest.REF_ID, teachingGroupType.getSchoolInfoRefId().getValue());
    }
    Assert.assertTrue(found);
  }

  @Test
  public void testServicePathStudentPersonal() {
    QueryCriteria queryCriteria = new QueryCriteria();
    queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalRefIds.REF_ID_1));

    List<Response> responses = teachingGroupTester.testServicePath(queryCriteria, 10000, 0);

    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    TeachingGroupCollectionType teachingGroupCollectionType = (TeachingGroupCollectionType) response.getDataObject();
    Assert.assertNotNull(teachingGroupCollectionType.getTeachingGroup());
    Assert.assertFalse(teachingGroupCollectionType.getTeachingGroup().isEmpty());
    boolean found = false;
    for (TeachingGroupType teachingGroupType : teachingGroupCollectionType.getTeachingGroup()) {
      found = found || REF_ID.equals(teachingGroupType.getRefId());
      Assert.assertNotNull(teachingGroupType.getSchoolInfoRefId());
      Assert.assertNotNull(teachingGroupType.getStudentList());
      Assert.assertNotNull(teachingGroupType.getStudentList().getValue());
      Assert.assertNotNull(teachingGroupType.getStudentList().getValue().getTeachingGroupStudent());
      Assert.assertFalse(teachingGroupType.getStudentList().getValue().getTeachingGroupStudent().isEmpty());
      boolean studentFound = false;
      for (TeachingGroupStudentType teachingGroupStudent : teachingGroupType.getStudentList().getValue().getTeachingGroupStudent()) {
        if (teachingGroupStudent.getStudentPersonalRefId() != null) {
          studentFound = studentFound || StudentPersonalRefIds.REF_ID_1.equals(teachingGroupStudent.getStudentPersonalRefId().getValue());
        }
      }
      Assert.assertTrue(studentFound);
    }
    Assert.assertTrue(found);
  }

  @Test
  public void testServicePathStaffPersonal() {
    QueryCriteria queryCriteria = new QueryCriteria();
    queryCriteria.addPredicate(new QueryPredicate("StaffPersonals", QueryOperator.EQUAL, StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1));

    List<Response> responses = teachingGroupTester.testServicePath(queryCriteria, 10000, 0);

    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    TeachingGroupCollectionType teachingGroupCollectionType = (TeachingGroupCollectionType) response.getDataObject();
    Assert.assertNotNull(teachingGroupCollectionType.getTeachingGroup());
    Assert.assertFalse(teachingGroupCollectionType.getTeachingGroup().isEmpty());
    boolean found = false;
    for (TeachingGroupType teachingGroupType : teachingGroupCollectionType.getTeachingGroup()) {
      found = found || REF_ID.equals(teachingGroupType.getRefId());
      Assert.assertNotNull(teachingGroupType.getSchoolInfoRefId());
      Assert.assertNotNull(teachingGroupType.getTeacherList());
      Assert.assertNotNull(teachingGroupType.getTeacherList().getValue());
      Assert.assertNotNull(teachingGroupType.getTeacherList().getValue().getTeachingGroupTeacher());
      Assert.assertFalse(teachingGroupType.getTeacherList().getValue().getTeachingGroupTeacher().isEmpty());
      boolean staffFound = false;
      for (TeachingGroupTeacherType teachingGroupTeacher : teachingGroupType.getTeacherList().getValue().getTeachingGroupTeacher()) {
        if (teachingGroupTeacher.getStaffPersonalRefId() != null) {
          staffFound = staffFound || StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1.equals(teachingGroupTeacher.getStaffPersonalRefId().getValue());
        }
      }
      Assert.assertTrue(staffFound);
    }
    Assert.assertTrue(found);
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
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), updateResponses.get(0).getStatus());

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
  public void testUpdateSingleStudents() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    List<Response> responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TeachingGroupType teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getStudentList());
    Assert.assertNotNull(teachingGroup.getStudentList().getValue());
    Assert.assertEquals(5, teachingGroup.getStudentList().getValue().getTeachingGroupStudent().size());

    teachingGroup.getStudentList().getValue().getTeachingGroupStudent().clear();
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNull(teachingGroup.getStudentList());

    TeachingGroupStudentType newStudent = new TeachingGroupStudentType();
    newStudent.setStudentPersonalRefId(objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2));
    newStudent.setName(objectFactory.createTeachingGroupStudentTypeName(StudentPersonalRefIds.getNameOfRecord(objectFactory)));
    newStudent.setStudentLocalId(objectFactory.createTeachingGroupStudentTypeStudentLocalId(StudentPersonalRefIds.LOCAL_ID));
    StudentListType studentList = new StudentListType();
    studentList.getTeachingGroupStudent().add(newStudent);
    teachingGroup.setStudentList(objectFactory.createTeachingGroupTypeStudentList(studentList));
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getStudentList());
    Assert.assertNotNull(teachingGroup.getStudentList().getValue());
    Assert.assertEquals(1, teachingGroup.getStudentList().getValue().getTeachingGroupStudent().size());
    Assert.assertEquals(StudentPersonalRefIds.REF_ID_2, teachingGroup.getStudentList().getValue().getTeachingGroupStudent().get(0).getStudentPersonalRefId().getValue());

    studentList = getFullStudentList();
    teachingGroup.setStudentList(objectFactory.createTeachingGroupTypeStudentList(studentList));
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getStudentList());
    Assert.assertNotNull(teachingGroup.getStudentList().getValue());
    Assert.assertEquals(5, teachingGroup.getStudentList().getValue().getTeachingGroupStudent().size());

    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getStudentList());
    Assert.assertNotNull(teachingGroup.getStudentList().getValue());
    Assert.assertEquals(5, teachingGroup.getStudentList().getValue().getTeachingGroupStudent().size());
  }
  
  @Test
  public void testUpdateSingleTeachers() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    List<Response> responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TeachingGroupType teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeacherList());
    Assert.assertNotNull(teachingGroup.getTeacherList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().size());
    Assert.assertEquals(StaffPersonalRefIds.REF_ID_1, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().get(0).getStaffPersonalRefId().getValue());
    
    teachingGroup.setTeacherList(null);
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNull(teachingGroup.getTeacherList());

    TeacherListType teacherList = new TeacherListType();
    TeachingGroupTeacherType teacher = new TeachingGroupTeacherType();
    teacher.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_2));
    teacher.setStaffLocalId(objectFactory.createTeachingGroupTeacherTypeStaffLocalId(StaffPersonalRefIds.LOCAL_ID));
    teacher.setAssociation("Class Teacher");
    teacher.setName(objectFactory.createTeachingGroupStudentTypeName(StaffPersonalRefIds.getNameOfRecord(objectFactory)));
    teacherList.getTeachingGroupTeacher().add(teacher);
    teachingGroup.setTeacherList(objectFactory.createTeachingGroupTypeTeacherList(teacherList));
    
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeacherList());
    Assert.assertNotNull(teachingGroup.getTeacherList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().size());
    Assert.assertEquals(StaffPersonalRefIds.REF_ID_2, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().get(0).getStaffPersonalRefId().getValue());

    
    teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().get(0).setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(StaffPersonalRefIds.REF_ID_1));
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeacherList());
    Assert.assertNotNull(teachingGroup.getTeacherList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().size());
    Assert.assertEquals(StaffPersonalRefIds.REF_ID_1, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().get(0).getStaffPersonalRefId().getValue());

    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeacherList());
    Assert.assertNotNull(teachingGroup.getTeacherList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().size());
    Assert.assertEquals(StaffPersonalRefIds.REF_ID_1, teachingGroup.getTeacherList().getValue().getTeachingGroupTeacher().get(0).getStaffPersonalRefId().getValue());
  }
  
  @Test
  public void testUpdateSinglePeriods() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    List<Response> responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TeachingGroupType teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().size());
    Assert.assertEquals(TimeTableCellConsumerTest.REF_ID, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().get(0).getTimeTableCellRefId().getValue());

    TeachingGroupPeriodType period = new TeachingGroupPeriodType();
    period.setTimeTableCellRefId(objectFactory.createTeachingGroupPeriodTypeTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID_OTHER));
    teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().add(period);
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertEquals(2, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().size());
    
    teachingGroup.setTeachingGroupPeriodList(null);
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNull(teachingGroup.getTeachingGroupPeriodList());

    TeachingGroupPeriodListType periodList = new TeachingGroupPeriodListType();
    periodList.getTeachingGroupPeriod().add(period);
    teachingGroup.setTeachingGroupPeriodList(objectFactory.createTeachingGroupTypeTeachingGroupPeriodList(periodList));
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().size());
    Assert.assertEquals(TimeTableCellConsumerTest.REF_ID_OTHER, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().get(0).getTimeTableCellRefId().getValue());


    teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().get(0).setTimeTableCellRefId(objectFactory.createTeachingGroupPeriodTypeTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID));
    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().size());
    Assert.assertEquals(TimeTableCellConsumerTest.REF_ID, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().get(0).getTimeTableCellRefId().getValue());

    teachingGroupTester.doUpdateOne(teachingGroup, REF_ID);
    responses = teachingGroupTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    teachingGroup = (TeachingGroupType) response.getDataObject();
    Assert.assertEquals(REF_ID, teachingGroup.getRefId());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList());
    Assert.assertNotNull(teachingGroup.getTeachingGroupPeriodList().getValue());
    Assert.assertEquals(1, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().size());
    Assert.assertEquals(TimeTableCellConsumerTest.REF_ID, teachingGroup.getTeachingGroupPeriodList().getValue().getTeachingGroupPeriod().get(0).getTimeTableCellRefId().getValue());
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

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = teachingGroupTester.testCreateMany("teachinggroups.xml");
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
