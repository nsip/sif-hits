package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.SessionInfoCollectionType;
import sif.dd.au30.model.SessionInfoType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class SessionInfoConsumerTest extends BaseTest {
  private ConsumerTest<SessionInfoType, SessionInfoCollectionType> sessionInfoTester = null;
  
  public static final String REF_ID = "07686cce-c916-45e5-8741-b42aadbc4bdb";
  private final String REF_ID_1 = "5f18d34a-4b9b-4959-9af5-5c991378de99";
  private final String REF_ID_2 = "d66f4094-f230-44f6-8b33-76eeb11e2dff";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    SessionInfoType sessionInfo = new SessionInfoType();
    sessionInfo.setRefId(REF_ID);
    sessionInfo.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    sessionInfo.setTimeTableCellRefId(TimeTableCellConsumerTest.REF_ID);
    sessionInfo.setSchoolYear(getDate("2014"));
    sessionInfo.setLocalId("session local id");
    sessionInfo.setTimeTableSubjectLocalId(TimeTableSubjectConsumerTest.LOCAL_ID);
    sessionInfo.setTeachingGroupLocalId(TeachingGroupConsumerTest.LOCAL_ID);
    sessionInfo.setSchoolLocalId(objectFactory.createSessionInfoTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
    sessionInfo.setStaffPersonalLocalId(objectFactory.createSessionInfoTypeStaffPersonalLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
    sessionInfo.setRoomNumber(objectFactory.createSessionInfoTypeRoomNumber(RoomInfoConsumerTest.ROOM_NUMBER));
    sessionInfo.setDayId(TimeTableCellConsumerTest.DAY_ID);
    sessionInfo.setPeriodId(TimeTableCellConsumerTest.PERIOD_ID);
    sessionInfo.setSessionDate(getDate("2014-10-22"));
    sessionInfo.setStartTime(objectFactory.createSessionInfoTypeStartTime(getDate("10:00:00")));
    sessionInfo.setFinishTime(objectFactory.createSessionInfoTypeFinishTime(getDate("14:00:00")));
    sessionInfo.setRollMarked(objectFactory.createSessionInfoTypeRollMarked(AUCodeSetsYesOrNoCategoryType.Y));
    sessionInfoTester.doCreateOne(sessionInfo);
    String xmlExpectedTo = sessionInfoTester.getXML(sessionInfo);
    
    sessionInfo.setRefId("a544e240-8dba-475a-8865-05ede06aa89b");
    sessionInfoTester.doCreateOne(sessionInfo);
    
    sessionInfo.setRefId("b62c8e48-f294-4cb4-b81d-50994edbf4ae");
    sessionInfoTester.doCreateOne(sessionInfo);

    sessionInfo.setRefId("8c9eb910-863e-4b4e-b2f2-a383c8b8180c");
    sessionInfoTester.doCreateOne(sessionInfo);

    sessionInfo.setRefId("2343b754-bbae-472f-a92e-5e876cbe60b0");
    sessionInfoTester.doCreateOne(sessionInfo);

    SessionInfoType getResult = sessionInfoTester.doGetOne(REF_ID);
    String xmlExpectedFrom = sessionInfoTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    sessionInfoTester = new ConsumerTest<SessionInfoType, SessionInfoCollectionType>(
        SessionInfoType.class, "SessionInfo", SessionInfoCollectionType.class, "SessionInfos");
    sessionInfoTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    List<Response> responses = sessionInfoTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SessionInfoType sessionInfoPersonal = (SessionInfoType) response.getDataObject();
    Assert.assertEquals(REF_ID, sessionInfoPersonal.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = sessionInfoTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SessionInfoCollectionType sessionInfoCollection = (SessionInfoCollectionType) response.getDataObject();
    Assert.assertNotNull(sessionInfoCollection.getSessionInfo());
    Assert.assertEquals(5, sessionInfoCollection.getSessionInfo().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = sessionInfoTester.testCreateOne("session.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    SessionInfoType sessionInfoPersonal = (SessionInfoType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, sessionInfoPersonal.getRefId());
    
    List<Response> deleteResponses = sessionInfoTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = sessionInfoTester.testCreateMany("sessions.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = sessionInfoTester.testDeleteMany(REF_IDS);
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
