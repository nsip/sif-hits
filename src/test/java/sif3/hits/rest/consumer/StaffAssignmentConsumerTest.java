package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsStaffActivityType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StaffActivityExtensionType;
import sif.dd.au30.model.StaffAssignmentCollectionType;
import sif.dd.au30.model.StaffAssignmentType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StaffPersonalConsumerTest.StaffPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StaffAssignmentConsumerTest extends BaseTest {
  private ConsumerTest<StaffAssignmentType, StaffAssignmentCollectionType> staffAssignmentTester = null;

  private final String REF_ID = "7bd6ec92-af9b-4f9f-bcfe-78424adb570e";
  private final String REF_ID_1 = "1eeb7b74-c8ef-4812-aff1-cb4dc8071d7a";
  private final String REF_ID_2 = "1df85509-a5b4-4d2f-9013-8dbc9e14defc";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    StaffAssignmentType staffAssignment = new StaffAssignmentType();
    staffAssignment.setRefId(REF_ID);
    staffAssignment.setStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1);
    staffAssignment.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    staffAssignment.setSchoolYear(objectFactory.createStaffAssignmentTypeSchoolYear(getDate("2014")));
    staffAssignment.setDescription(objectFactory.createStaffAssignmentTypeDescription("Description"));
    staffAssignment.setPrimaryAssignment(AUCodeSetsYesOrNoCategoryType.Y);
    staffAssignment.setJobStartDate(objectFactory.createStaffAssignmentTypeJobStartDate(getDate("2012-01-20")));
    staffAssignment.setJobEndDate(objectFactory.createStaffAssignmentTypeJobEndDate(getDate("2014-12-20")));
    staffAssignment.setJobFunction(objectFactory.createStaffAssignmentTypeJobFunction("Teacher"));

    StaffActivityExtensionType staffActivity = new StaffActivityExtensionType();
    staffActivity.setCode(AUCodeSetsStaffActivityType.fromValue("1102"));
    staffAssignment.setStaffActivity(objectFactory.createStaffAssignmentTypeStaffActivity(staffActivity));

    staffAssignmentTester.doCreateOne(staffAssignment);
    String xmlExpectedTo = staffAssignmentTester.getXML(staffAssignment);

    staffAssignment.setRefId("c60fe125-ad63-4b28-b227-efc08d936891");
    staffAssignment.setStaffPersonalRefId(StaffPersonalRefIds.REF_ID_2);
    staffAssignmentTester.doCreateOne(staffAssignment);

    staffAssignment.setRefId("9ee3f538-c0e3-4bc5-a7ee-c64a957221db");
    staffAssignment.setStaffPersonalRefId(StaffPersonalRefIds.REF_ID_3);
    staffAssignmentTester.doCreateOne(staffAssignment);

    staffAssignment.setRefId("909f0ea1-e4cb-48fb-b3b8-a5dae0260cd2");
    staffAssignment.setStaffPersonalRefId(StaffPersonalRefIds.REF_ID_4);
    staffAssignmentTester.doCreateOne(staffAssignment);

    staffAssignment.setRefId("903ca5e7-eefe-45e0-92ac-7eb0ee2e14a3");
    staffAssignment.setStaffPersonalRefId(StaffPersonalRefIds.REF_ID_5);
    staffAssignmentTester.doCreateOne(staffAssignment);

    StaffAssignmentType getResult = staffAssignmentTester.doGetOne(REF_ID);

    String xmlExpectedFrom = staffAssignmentTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    staffAssignmentTester = new ConsumerTest<StaffAssignmentType, StaffAssignmentCollectionType>(StaffAssignmentType.class, "StaffAssignment", StaffAssignmentCollectionType.class, "StaffAssignments");
    staffAssignmentTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testQBE() {
    StaffAssignmentType staffAssignment = new StaffAssignmentType();
    staffAssignment.setStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1);
    List<Response> responses = staffAssignmentTester.testQBE(staffAssignment, 10000, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    StaffAssignmentCollectionType staffAssignmentCollectionType = (StaffAssignmentCollectionType) response.getDataObject();
    Assert.assertNotNull(staffAssignmentCollectionType.getStaffAssignment());
    Assert.assertFalse(staffAssignmentCollectionType.getStaffAssignment().isEmpty());
    boolean found = false;
    for (StaffAssignmentType staffAssignmentType : staffAssignmentCollectionType.getStaffAssignment()) {
      found = found || REF_ID.equals(staffAssignmentType.getRefId());
      Assert.assertEquals(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1, staffAssignmentType.getStaffPersonalRefId());
    }
    Assert.assertTrue(found);
  }

  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = staffAssignmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffAssignmentType staffAssignment = (StaffAssignmentType) response.getDataObject();
    Assert.assertEquals(REF_ID, staffAssignment.getRefId());

    String xmlExpectedFrom = staffAssignmentTester.getXML(staffAssignment);

    List<Response> updateResponses = staffAssignmentTester.doUpdateOne(staffAssignment, REF_ID);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = staffAssignmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    StaffAssignmentType comparisonTo = (StaffAssignmentType) getResponse.getDataObject();
    Assert.assertEquals(REF_ID, comparisonTo.getRefId());
    String xmlExpectedTo = staffAssignmentTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = staffAssignmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffAssignmentType staffAssignment = (StaffAssignmentType) response.getDataObject();
    Assert.assertEquals(REF_ID, staffAssignment.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = staffAssignmentTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffAssignmentCollectionType staffAssignmentCollection = (StaffAssignmentCollectionType) response.getDataObject();
    Assert.assertNotNull(staffAssignmentCollection.getStaffAssignment());
    Assert.assertEquals(5, staffAssignmentCollection.getStaffAssignment().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = staffAssignmentTester.testCreateOne("staffassignment.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StaffAssignmentType staffAssignment = (StaffAssignmentType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, staffAssignment.getRefId());

    List<Response> deleteResponses = staffAssignmentTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = staffAssignmentTester.testCreateMany("staffassignments.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = staffAssignmentTester.testDeleteMany(REF_IDS);
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
