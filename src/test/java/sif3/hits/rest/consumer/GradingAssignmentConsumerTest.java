package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.GradingAssignmentCollectionType;
import sif.dd.au30.model.GradingAssignmentType;
import sif.dd.au30.model.ObjectFactory;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class GradingAssignmentConsumerTest extends BaseTest {
  private ConsumerTest<GradingAssignmentType, GradingAssignmentCollectionType> gradingTester = null;

  public static class GradingAssignmentRefIds {
    public static String REF_ID_1 = "c70b9b36-c418-4c94-8f1b-fa1488b44607";
    public static String REF_ID_2 = "74460bde-48fe-4a99-b54a-31bba5d947d0";
    public static String REF_ID_3 = "fec29cd5-cd4d-49bc-ab6d-e86907bc99ff";
    public static String REF_ID_4 = "63bc98b2-763c-47ff-9651-afedc89c981d";
    public static String REF_ID_5 = "cfcb9882-a382-44d5-a393-cb76fe740acb";
  }
  
  private final String REF_ID_1 = "ec238a11-bf0b-461c-8647-9e5b6408d7d9";
  private final String REF_ID_2 = "f1c51ca1-ad84-4b03-b385-ba958cdedebd";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    GradingAssignmentType gradingAssignment = new GradingAssignmentType();
    gradingAssignment.setRefId(GradingAssignmentRefIds.REF_ID_1);
    gradingAssignment.setTeachingGroupRefId(objectFactory.createGradingAssignmentTypeTeachingGroupRefId(TeachingGroupConsumerTest.REF_ID));
    gradingAssignment.setSchoolInfoRefId(objectFactory.createGradingAssignmentTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    gradingAssignment.setGradingCategory(objectFactory.createGradingAssignmentTypeGradingCategory("GC"));
    gradingAssignment.setDescription("Description");
    gradingAssignment.setPointsPossible(80L);
    gradingAssignment.setCreateDate(objectFactory.createGradingAssignmentTypeCreateDate(DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-07-01")));
    gradingAssignment.setDueDate(objectFactory.createGradingAssignmentTypeDueDate(DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-01")));
    gradingAssignment.setWeight(objectFactory.createGradingAssignmentTypeWeight(new BigDecimal("75")));
    gradingAssignment.setMaxAttemptsAllowed(objectFactory.createGradingAssignmentTypeMaxAttemptsAllowed(BigInteger.ONE));
    gradingAssignment.setDetailedDescriptionURL(objectFactory.createGradingAssignmentTypeDetailedDescriptionURL("http://www.google.com"));

    gradingTester.doCreateOne(gradingAssignment);
    String xmlExpectedTo = gradingTester.getXML(gradingAssignment);

    gradingAssignment.setRefId(GradingAssignmentRefIds.REF_ID_2);
    gradingTester.doCreateOne(gradingAssignment);
    gradingAssignment.setRefId(GradingAssignmentRefIds.REF_ID_3);
    gradingTester.doCreateOne(gradingAssignment);
    gradingAssignment.setRefId(GradingAssignmentRefIds.REF_ID_4);
    gradingTester.doCreateOne(gradingAssignment);
    gradingAssignment.setRefId(GradingAssignmentRefIds.REF_ID_5);
    gradingTester.doCreateOne(gradingAssignment);

    GradingAssignmentType getResult = gradingTester.doGetOne(GradingAssignmentRefIds.REF_ID_1);
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
    gradingTester = new ConsumerTest<GradingAssignmentType, GradingAssignmentCollectionType>(
        GradingAssignmentType.class, "GradingAssignment", GradingAssignmentCollectionType.class,
        "GradingAssignments");
    gradingTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = gradingTester.testGetSingle(GradingAssignmentRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    GradingAssignmentType gradingAssignment = (GradingAssignmentType) response.getDataObject();
    Assert.assertEquals(GradingAssignmentRefIds.REF_ID_1, gradingAssignment.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = gradingTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    GradingAssignmentCollectionType gradingCollection = (GradingAssignmentCollectionType) response.getDataObject();
    Assert.assertNotNull(gradingCollection.getGradingAssignment());
    Assert.assertEquals(5, gradingCollection.getGradingAssignment().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = gradingTester.testCreateOne("gradingassignment.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    GradingAssignmentType gradingAssignment = (GradingAssignmentType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, gradingAssignment.getRefId());

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

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = gradingTester.testCreateMany("gradingassignments.xml");
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
