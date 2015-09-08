package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsScheduledActivityTypeType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverCreditType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverSupervisionType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.ScheduledActivityCollectionType;
import sif.dd.au30.model.ScheduledActivityType;
import sif.dd.au30.model.ScheduledActivityType.Override;
import sif.dd.au30.model.ScheduledActivityType.RoomList;
import sif.dd.au30.model.ScheduledActivityType.StudentList;
import sif.dd.au30.model.ScheduledActivityType.TeacherList;
import sif.dd.au30.model.ScheduledActivityType.TeacherList.TeacherCover;
import sif.dd.au30.model.ScheduledActivityType.TeachingGroupList;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class ScheduledActivityConsumerTest extends BaseTest {
  private ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType> scheduledActivityTester = null;
  
  public static final String REF_ID = "af7d1111-419b-4ff5-a3e8-d49bcb8456e5";
  private final String REF_ID_1 = "596bd118-14cb-485a-84d3-593fc5703958";
  private final String REF_ID_2 = "df54713a-db1c-4428-a418-d8a5964d893a";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    ScheduledActivityType scheduledActivity = new ScheduledActivityType();
    scheduledActivity.setRefId(REF_ID);
    scheduledActivity.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    scheduledActivity.setTimeTableCellRefId(objectFactory.createScheduledActivityTypeTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID));
    scheduledActivity.setTimeTableSubjectRefId(objectFactory.createScheduledActivityTypeTimeTableSubjectRefId(TimeTableSubjectConsumerTest.REF_ID));
    scheduledActivity.setTimeTableRefId(objectFactory.createScheduledActivityTypeTimeTableRefId(TimeTableConsumerTest.REF_ID));
    scheduledActivity.setDayId(objectFactory.createScheduledActivityTypeDayId(TimeTableCellConsumerTest.DAY_ID));
    scheduledActivity.setPeriodId(objectFactory.createScheduledActivityTypePeriodId(TimeTableCellConsumerTest.PERIOD_ID));
    scheduledActivity.setActivityDate(getDate("2014-09-01"));
    scheduledActivity.setStartTime(getDate("09:30:00"));
    scheduledActivity.setFinishTime(getDate("13:30:00"));
    scheduledActivity.setCellType(objectFactory.createScheduledActivityTypeCellType("Teaching"));
    scheduledActivity.setLocation(objectFactory.createScheduledActivityTypeLocation("Location"));
    scheduledActivity.setActivityType(objectFactory.createScheduledActivityTypeActivityType(AUCodeSetsScheduledActivityTypeType.EXAM));
    scheduledActivity.setActivityName(objectFactory.createScheduledActivityTypeActivityName("The Exam"));
    scheduledActivity.setActivityComment(objectFactory.createScheduledActivityTypeActivityComment("The Comment"));
    
    YearLevelsType yearLevelsType = new YearLevelsType();
    YearLevelType yearLevel = new YearLevelType();
    yearLevel.setCode("9");
    yearLevelsType.getYearLevel().add(yearLevel);
    scheduledActivity.setYearLevels(objectFactory.createScheduledActivityTypeYearLevels(yearLevelsType));
    
    Override override = new Override();
    override.setValue("Y");
    override.setDateOfOverride(getDate("2014-09-02"));
    scheduledActivity.setOverride(objectFactory.createScheduledActivityTypeOverride(override));
    
    RoomList roomList = new RoomList();
    roomList.getRoomInfoRefId().add(RoomInfoConsumerTest.REF_ID);
    scheduledActivity.setRoomList(objectFactory.createScheduledActivityTypeRoomList(roomList));
    
    TeacherList teacherList = new TeacherList();
    TeacherCover teacherCover = new TeacherCover();
    teacherCover.setStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1);
    teacherCover.setStaffLocalId(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
    teacherCover.setStartTime(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverStartTime(getDate("09:30:00")));
    teacherCover.setFinishTime(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverFinishTime(getDate("13:30:00")));
    teacherCover.setCredit(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverCredit(AUCodeSetsTeacherCoverCreditType.EXTRA));
    teacherCover.setSupervision(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverSupervision(AUCodeSetsTeacherCoverSupervisionType.NORMAL));
    teacherCover.setWeighting(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverWeighting(new BigDecimal("1.0")));
    teacherList.getTeacherCover().add(teacherCover);
    scheduledActivity.setTeacherList(objectFactory.createScheduledActivityTypeTeacherList(teacherList));
    
    StudentList studentList = new StudentList();
    studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_1);
    studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_2);
    studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_3);
    studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_4);
    studentList.getStudentPersonalRefId().add(StudentPersonalRefIds.REF_ID_5);
    scheduledActivity.setStudentList(objectFactory.createScheduledActivityTypeStudentList(studentList));
    
    TeachingGroupList teachingGroupList = new TeachingGroupList();
    teachingGroupList.getTeachingGroupRefId().add(TeachingGroupConsumerTest.REF_ID);
    scheduledActivity.setTeachingGroupList(objectFactory.createScheduledActivityTypeTeachingGroupList(teachingGroupList));
    
    scheduledActivityTester.doCreateOne(scheduledActivity);
    String xmlExpectedTo = scheduledActivityTester.getXML(scheduledActivity);

    scheduledActivity.setRefId("9c884119-d4eb-4624-93c4-f3bbac8c7c72");
    scheduledActivityTester.doCreateOne(scheduledActivity);

    scheduledActivity.setRefId("48c1b75c-fc5e-4155-a2f4-b1cd57c29bb5");
    scheduledActivityTester.doCreateOne(scheduledActivity);

    scheduledActivity.setRefId("44db9710-5f26-43c2-b3db-0e4168e8d0db");
    scheduledActivityTester.doCreateOne(scheduledActivity);

    scheduledActivity.setRefId("78748f1f-474a-461d-a7d4-4e1f1d7a4b90");
    scheduledActivityTester.doCreateOne(scheduledActivity);

    ScheduledActivityType getResult = scheduledActivityTester.doGetOne(REF_ID);
    String xmlExpectedFrom = scheduledActivityTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    scheduledActivityTester = new ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType>(
        ScheduledActivityType.class, "ScheduledActivity", ScheduledActivityCollectionType.class, "ScheduledActivitys");
    scheduledActivityTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    List<Response> responses = scheduledActivityTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    ScheduledActivityType scheduledActivity = (ScheduledActivityType) response.getDataObject();
    Assert.assertEquals(REF_ID, scheduledActivity.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = scheduledActivityTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    ScheduledActivityCollectionType scheduledActivityCollection = (ScheduledActivityCollectionType) response.getDataObject();
    Assert.assertNotNull(scheduledActivityCollection.getScheduledActivity());
    Assert.assertEquals(5, scheduledActivityCollection.getScheduledActivity().size());
  }
  
  @Test
  public void testCreateDelete() {
    List<Response> createResponses = scheduledActivityTester.testCreateOne("scheduledactivity.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    ScheduledActivityType scheduledActivity = (ScheduledActivityType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, scheduledActivity.getRefId());
    
    List<Response> deleteResponses = scheduledActivityTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = scheduledActivityTester.testCreateMany("scheduledactivities.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = scheduledActivityTester.testDeleteMany(REF_IDS);
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
