package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.GradingAssignmentScoreCollectionType;
import sif.dd.au30.model.GradingAssignmentScoreType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.GradingAssignmentConsumerTest.GradingAssignmentRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class GradingAssignmentScoreConsumerTest extends BaseTest {
  private ConsumerTest<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType> gradingTester = null;

  public static class GradingAssignmentScoreRefIds {
    public static String REF_ID_1 = "b770facf-db70-4be7-a2f5-b344db82c7bc";
    public static String REF_ID_2 = "6b48076a-0f94-44b0-aebe-d6d97ca57358";
    public static String REF_ID_3 = "4bdd8dac-c9c1-4411-8145-a23aef928985";
    public static String REF_ID_4 = "2e814c91-6157-47fe-a45f-3800f8ae3c92";
    public static String REF_ID_5 = "40951f69-3e2a-46d8-bff0-b3dd8d2653c2";
  }
  
  private final String REF_ID_1 = "7d803875-37d1-4ba8-bf6b-11a6819db870";
  private final String REF_ID_2 = "09f942b6-e080-487b-8ba6-23d892420a0e";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    GradingAssignmentScoreType gradingAssignmentScore = new GradingAssignmentScoreType();
    gradingAssignmentScore.setRefId(GradingAssignmentScoreRefIds.REF_ID_1);
    gradingAssignmentScore.setGradingAssignmentRefId(GradingAssignmentRefIds.REF_ID_1);
    gradingAssignmentScore.setTeachingGroupRefId(objectFactory.createGradingAssignmentScoreTypeTeachingGroupRefId(TeachingGroupConsumerTest.REF_ID));
    gradingAssignmentScore.setSchoolInfoRefId(objectFactory.createGradingAssignmentScoreTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    gradingAssignmentScore.setStudentPersonalRefId(objectFactory.createGradingAssignmentScoreTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1));
    gradingAssignmentScore.setStudentPersonalLocalId(StudentPersonalRefIds.LOCAL_ID);
    gradingAssignmentScore.setScorePoints(objectFactory.createGradingAssignmentScoreTypeScorePoints(24L));
    gradingAssignmentScore.setScorePercent(objectFactory.createGradingAssignmentScoreTypeScorePercent(new BigDecimal("0.96")));
    gradingAssignmentScore.setScoreLetter(objectFactory.createGradingAssignmentScoreTypeScoreLetter("A+"));
    gradingAssignmentScore.setScoreDescription(objectFactory.createGradingAssignmentScoreTypeScoreDescription("Aced It!"));
    
    gradingTester.doCreateOne(gradingAssignmentScore);
    String xmlExpectedTo = gradingTester.getXML(gradingAssignmentScore);

    gradingAssignmentScore.setRefId(GradingAssignmentScoreRefIds.REF_ID_2);
    gradingAssignmentScore.setStudentPersonalRefId(objectFactory.createGradingAssignmentScoreTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2));
    gradingTester.doCreateOne(gradingAssignmentScore);
    gradingAssignmentScore.setRefId(GradingAssignmentScoreRefIds.REF_ID_3);
    gradingAssignmentScore.setStudentPersonalRefId(objectFactory.createGradingAssignmentScoreTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3));
    gradingTester.doCreateOne(gradingAssignmentScore);
    gradingAssignmentScore.setRefId(GradingAssignmentScoreRefIds.REF_ID_4);
    gradingAssignmentScore.setStudentPersonalRefId(objectFactory.createGradingAssignmentScoreTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4));
    gradingTester.doCreateOne(gradingAssignmentScore);
    gradingAssignmentScore.setRefId(GradingAssignmentScoreRefIds.REF_ID_5);
    gradingAssignmentScore.setStudentPersonalRefId(objectFactory.createGradingAssignmentScoreTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5));
    gradingTester.doCreateOne(gradingAssignmentScore);

    GradingAssignmentScoreType getResult = gradingTester.doGetOne(GradingAssignmentScoreRefIds.REF_ID_1);
    String xmlExpectedFrom = gradingTester.getXML(getResult);
    Assert.assertNotNull("XML Expected From isNull", xmlExpectedFrom);
    Assert.assertNotNull("XML Expected To isNull", xmlExpectedTo);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    gradingTester = new ConsumerTest<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType>(
        GradingAssignmentScoreType.class, "GradingAssignmentScore", GradingAssignmentScoreCollectionType.class,
        "GradingAssignmentScores");
    gradingTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = gradingTester.testGetSingle(GradingAssignmentScoreRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    GradingAssignmentScoreType gradingAssignmentScore = (GradingAssignmentScoreType) response.getDataObject();
    Assert.assertEquals(GradingAssignmentScoreRefIds.REF_ID_1, gradingAssignmentScore.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = gradingTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    GradingAssignmentScoreCollectionType gradingCollection = (GradingAssignmentScoreCollectionType) response.getDataObject();
    Assert.assertNotNull(gradingCollection.getGradingAssignmentScore());
    Assert.assertEquals(5, gradingCollection.getGradingAssignmentScore().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = gradingTester.testCreateOne("gradingassignmentscore.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    GradingAssignmentScoreType gradingAssignmentScore = (GradingAssignmentScoreType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, gradingAssignmentScore.getRefId());

    List<Response> deleteResponses = gradingTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = gradingTester.testCreateMany("gradingassignmentscores.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = gradingTester.testDeleteMany(REF_IDS);
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
