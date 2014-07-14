package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TeachingGroupConsumerTest {
  private ConsumerTest<TeachingGroupType, TeachingGroupCollectionType> teachingGroupTester = null;

  private final String REF_ID_1 = "b2ae74f2-faa5-45b8-8bbd-2b545781846c";
  private final String REF_ID_2 = "36e5b3ee-7c41-49fa-86cc-a0a888178e77";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    teachingGroupTester = new ConsumerTest<TeachingGroupType, TeachingGroupCollectionType>(TeachingGroupType.class,
        "TeachingGroup", TeachingGroupCollectionType.class, "TeachingGroups");
    teachingGroupTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
    final String REF_ID = "45616492-03ac-44a7-a274-6d4b59688198";
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
