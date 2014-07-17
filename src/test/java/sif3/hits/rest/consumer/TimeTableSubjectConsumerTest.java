package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableSubjectConsumerTest {
  private ConsumerTest<TimeTableSubjectType, TimeTableSubjectCollectionType> timeTableSubjectTester = null;
  
  private final String REF_ID_1 = "4609142F63E443F4A384CB81D309438F";
  private final String REF_ID_2 = "6BB0C404C02949BD9956D6BE93B7B124";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    timeTableSubjectTester = new ConsumerTest<TimeTableSubjectType, TimeTableSubjectCollectionType>(
        TimeTableSubjectType.class, "TimeTableSubject", TimeTableSubjectCollectionType.class, "TimeTableSubjects");
    timeTableSubjectTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "0d409bc9-048c-4057-94b3-3692e76dd2ed";
    List<Response> responses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTableSubject.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = timeTableSubjectTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectCollectionType timeTableSubjects = (TimeTableSubjectCollectionType) response.getDataObject();
    Assert.assertNotNull(timeTableSubjects.getTimeTableSubject());
    Assert.assertEquals(5, timeTableSubjects.getTimeTableSubject().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = timeTableSubjectTester.testCreateOne("timetablesubject.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTableSubject.getRefId());
    
    List<Response> deleteResponses = timeTableSubjectTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateUpdate() {
    List<Response> createResponses = timeTableSubjectTester.testCreateOne("timetablesubject.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTableSubject.getRefId());
    Assert.assertEquals(2, timeTableSubject.getOtherCodeList().getValue().getOtherCode().size());
    
    List<Response> updateResponses = timeTableSubjectTester.testUpdateOne("timetablesubjectupdate.xml", REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Response updateResponse = updateResponses.get(0);
    Assert.assertNull(updateResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), updateResponse.getStatus());
    
    List<Response> responses = timeTableSubjectTester.testGetSingle(REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectType updatedTimeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID_1, updatedTimeTableSubject.getRefId());
    Assert.assertEquals(3, updatedTimeTableSubject.getOtherCodeList().getValue().getOtherCode().size());
    
    timeTableSubjectTester.testDeleteOne(REF_ID_1);
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = timeTableSubjectTester.testCreateMany("timetablesubjects.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = timeTableSubjectTester.testDeleteMany(REF_IDS);
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
