package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsEnrollmentTimeFrameType;
import sif.dd.au30.model.AUCodeSetsSchoolEnrollmentTypeType;
import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentSchoolEnrollmentCollectionType;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif.dd.au30.model.YearLevelType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentSchoolEnrollmentConsumerTest extends BaseTest {
  private ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> studentSchoolEnrollmentTester = null;

  private final String REF_ID = "c59fcfb8-a1f7-4c97-8f72-822e59cda292";
  private final String REF_ID_1 = "eccdbcbf-9681-4791-a825-3cdbf8cd138f";
  private final String REF_ID_2 = "dccec317-2371-465e-854a-e1af585da93a";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    StudentSchoolEnrollmentType studentEnrollment = new StudentSchoolEnrollmentType();
    studentEnrollment.setRefId(REF_ID);
    studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
    studentEnrollment.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
    studentEnrollment.setMembershipType(AUCodeSetsSchoolEnrollmentTypeType.fromValue("01"));
    studentEnrollment.setSchoolYear(getDate("2014"));
    studentEnrollment.setTimeFrame(AUCodeSetsEnrollmentTimeFrameType.C);

    YearLevelType yearLevel = new YearLevelType();
    yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("4"));
    studentEnrollment.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yearLevel));
    studentEnrollment.setFTE(objectFactory.createStudentSchoolEnrollmentTypeFTE(new BigDecimal("1.0")));
    studentEnrollment.setEntryDate(getDate("2012-01-20"));
    studentEnrollment.setExitDate(objectFactory.createStudentSchoolEnrollmentTypeExitDate(getDate("2014-12-20")));

    String xmlExpectedTo = studentSchoolEnrollmentTester.getXML(studentEnrollment);
    studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);

    studentEnrollment.setRefId("609d6b13-73bc-44a7-b251-73d910b28b6a");
    studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2);
    studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);

    studentEnrollment.setRefId("5d2eeecb-71ed-459b-a238-4b8297844693");
    studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3);
    studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);

    studentEnrollment.setRefId("c45ebe7e-e3d3-43bb-90f6-6c3275a87dbc");
    studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4);
    studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);

    studentEnrollment.setRefId("d81a5263-ca14-46eb-96c3-a47d37152b39");
    studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5);
    studentSchoolEnrollmentTester.doCreateOne(studentEnrollment);

    StudentSchoolEnrollmentType getResult = studentSchoolEnrollmentTester.doGetOne(REF_ID);

    String xmlExpectedFrom = studentSchoolEnrollmentTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    studentSchoolEnrollmentTester = new ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType>(
        StudentSchoolEnrollmentType.class, "StudentSchoolEnrollment", StudentSchoolEnrollmentCollectionType.class,
        "StudentSchoolEnrollments");
    studentSchoolEnrollmentTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = studentSchoolEnrollmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentSchoolEnrollment.getRefId());

    String xmlExpectedFrom = studentSchoolEnrollmentTester.getXML(studentSchoolEnrollment);

    List<Response> updateResponses = studentSchoolEnrollmentTester.doUpdateOne(studentSchoolEnrollment, REF_ID);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = studentSchoolEnrollmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    StudentSchoolEnrollmentType comparisonTo = (StudentSchoolEnrollmentType) getResponse.getDataObject();
    Assert.assertEquals(REF_ID, comparisonTo.getRefId());
    String xmlExpectedTo = studentSchoolEnrollmentTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = studentSchoolEnrollmentTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) response.getDataObject();
    Assert.assertEquals(REF_ID, studentSchoolEnrollment.getRefId());
  }
  
  @Test
  public void testQBE() {
    StudentSchoolEnrollmentType studentEnrollment = new StudentSchoolEnrollmentType();
    studentEnrollment.setStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1);
    List<Response> responses = studentSchoolEnrollmentTester.testQBE(studentEnrollment, 10000, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    StudentSchoolEnrollmentCollectionType studentSchoolEnrollmentCollectionType = (StudentSchoolEnrollmentCollectionType) response
        .getDataObject();
    Assert.assertNotNull(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment());
    Assert.assertFalse(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment().isEmpty());
    boolean found = false;
    for (StudentSchoolEnrollmentType studentSchoolEnrollmentType : studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment()) {
      found = found || REF_ID.equals(studentSchoolEnrollmentType.getRefId());
      Assert.assertEquals(StudentPersonalRefIds.REF_ID_1, studentSchoolEnrollmentType.getStudentPersonalRefId());
    }
    Assert.assertTrue(found);
  }

  @Test
  public void testGetMany() {
    List<Response> responses = studentSchoolEnrollmentTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentSchoolEnrollmentCollectionType studentSchoolEnrollmentCollectionType = (StudentSchoolEnrollmentCollectionType) response
        .getDataObject();
    Assert.assertNotNull(studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment());
    Assert.assertEquals(5, studentSchoolEnrollmentCollectionType.getStudentSchoolEnrollment().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = studentSchoolEnrollmentTester.testCreateOne("studentschoolenrollment.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentSchoolEnrollmentType studentSchoolEnrollment = (StudentSchoolEnrollmentType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, studentSchoolEnrollment.getRefId());

    List<Response> deleteResponses = studentSchoolEnrollmentTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentSchoolEnrollmentTester
        .testCreateMany("studentschoolenrollments.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentSchoolEnrollmentTester
        .testDeleteMany(REF_IDS);
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
