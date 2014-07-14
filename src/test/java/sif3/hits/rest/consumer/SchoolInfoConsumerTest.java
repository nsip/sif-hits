package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.SchoolCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class SchoolInfoConsumerTest {
  private ConsumerTest<SchoolInfoType, SchoolCollectionType> schoolInfoTester = null;
  
  private final String REF_ID_1 = "830c3bcb-0bfc-4adc-96b2-f08318ff8627";
  private final String REF_ID_2 = "58a322e4-a353-4198-8602-25f124c5836c";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    schoolInfoTester = new ConsumerTest<SchoolInfoType, SchoolCollectionType>(
        SchoolInfoType.class, "SchoolInfo", SchoolCollectionType.class, "SchoolInfos");
    schoolInfoTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    final String REF_ID = "6DAFB630-C439-11E3-9AA0-81F4DBD909AB";
    List<Response> responses = schoolInfoTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SchoolInfoType schoolInfoPersonal = (SchoolInfoType) response.getDataObject();
    Assert.assertEquals(REF_ID, schoolInfoPersonal.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = schoolInfoTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SchoolCollectionType schoolInfoCollection = (SchoolCollectionType) response.getDataObject();
    Assert.assertNotNull(schoolInfoCollection.getSchoolInfo());
    Assert.assertEquals(1, schoolInfoCollection.getSchoolInfo().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = schoolInfoTester.testCreateOne("school.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    SchoolInfoType schoolInfoPersonal = (SchoolInfoType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, schoolInfoPersonal.getRefId());
    
    List<Response> deleteResponses = schoolInfoTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = schoolInfoTester.testCreateMany("schools.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = schoolInfoTester.testDeleteMany(REF_IDS);
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
