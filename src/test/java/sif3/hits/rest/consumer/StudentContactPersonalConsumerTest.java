package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailType;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberType;
import sif.dd.au30.model.StudentContactPersonalCollectionType;
import sif.dd.au30.model.StudentContactPersonalType;
import sif.dd.au30.model.StudentPersonalCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentContactPersonalConsumerTest extends BaseTest {
  private ConsumerTest<StudentContactPersonalType, StudentContactPersonalCollectionType> studentTester = null;

  public static class StudentContactPersonalRefIds {
    public static String REF_ID_1 = "281bc155-8598-4873-933e-7a9ef336b98d";
    public static String REF_ID_2 = "f53c639f-87e0-4b17-8285-e625c210af74";
    public static String REF_ID_3 = "1cd40a27-6a63-4210-b3a4-bdf6be4d7de4";
    public static String REF_ID_4 = "92483a4b-a25a-4e55-a0cb-998adf0b1161";
    public static String REF_ID_5 = "c0e550ad-3eb2-4a8c-8ca6-f5ab0fd547b2";
  }

  private final String REF_ID_1 = "884fafd9-2feb-4770-827d-a5121bd85e41";
  private final String REF_ID_2 = "73eee225-9636-4c17-be1b-67de6cc73237";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    StudentContactPersonalType studentContactPersonal = new StudentContactPersonalType();
    studentContactPersonal.setRefId(StudentContactPersonalRefIds.REF_ID_1);
    studentContactPersonal.setEmploymentType(objectFactory.createStudentContactPersonalTypeEmploymentType("1"));
    studentContactPersonal.setLocalId(objectFactory.createStudentContactPersonalTypeLocalId("LocalId"));
    studentContactPersonal.setNonSchoolEducation(objectFactory.createStudentContactPersonalTypeNonSchoolEducation("7"));
    studentContactPersonal
        .setSchoolEducationalLevel(objectFactory.createStudentContactPersonalTypeSchoolEducationalLevel("4"));

    PersonInfoType personInfo = new PersonInfoType();

    NameOfRecordType nameOfRecord = new NameOfRecordType();
    nameOfRecord.setType("LGL");
    nameOfRecord.setTitle(objectFactory.createBaseNameTypeTitle("Mr"));
    nameOfRecord.setFamilyName(objectFactory.createBaseNameTypeFamilyName("Tester"));
    nameOfRecord.setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName("PTester"));
    nameOfRecord.setGivenName(objectFactory.createBaseNameTypeGivenName("Fred"));
    nameOfRecord.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName("PFred"));
    nameOfRecord.setMiddleName(objectFactory.createBaseNameTypeMiddleName("Middle"));
    personInfo.setName(nameOfRecord);

    DemographicsType demographics = new DemographicsType();
    demographics.setSex(objectFactory.createDemographicsTypeSex("1"));
    personInfo.setDemographics(objectFactory.createPersonInfoTypeDemographics(demographics));
    
    PhoneNumberListType phoneNumberList = new PhoneNumberListType();
    PhoneNumberType phoneNumber = new PhoneNumberType();
    phoneNumber.setType("0096");
    phoneNumber.setNumber("+61400000000");
    phoneNumberList.getPhoneNumber().add(phoneNumber);
    personInfo.setPhoneNumberList(objectFactory.createPersonInfoTypePhoneNumberList(phoneNumberList));

    EmailListType emailList = new EmailListType();
    EmailType email = new EmailType();
    email.setType("06"); // AUCodeSetsEmailTypeType.WORK
    email.setValue("the.email@not.a.real.domain");
    emailList.getEmail().add(email);
    personInfo.setEmailList(objectFactory.createPersonInfoTypeEmailList(emailList));

    AddressListType addresses = objectFactory.createAddressListType();
    addresses.getAddress()
        .add(StudentPersonalRefIds.getAddress(objectFactory, "123 Address Line One", "Address Line Two"));
    addresses.getAddress().add(StudentPersonalRefIds.getAddress(objectFactory, "234 Address Line One", null));
    personInfo.setAddressList(objectFactory.createPersonInfoTypeAddressList(addresses));

    studentContactPersonal.setPersonInfo(personInfo);

    studentTester.doCreateOne(studentContactPersonal);
    String xmlExpectedTo = studentTester.getXML(studentContactPersonal);

    studentContactPersonal.setRefId(StudentContactPersonalRefIds.REF_ID_2);
    studentTester.doCreateOne(studentContactPersonal);
    studentContactPersonal.setRefId(StudentContactPersonalRefIds.REF_ID_3);
    studentTester.doCreateOne(studentContactPersonal);
    studentContactPersonal.setRefId(StudentContactPersonalRefIds.REF_ID_4);
    studentTester.doCreateOne(studentContactPersonal);
    studentContactPersonal.setRefId(StudentContactPersonalRefIds.REF_ID_5);
    studentTester.doCreateOne(studentContactPersonal);

    StudentContactPersonalType getResult = studentTester.doGetOne(StudentContactPersonalRefIds.REF_ID_1);
    String xmlExpectedFrom = studentTester.getXML(getResult);
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
    studentTester = new ConsumerTest<StudentContactPersonalType, StudentContactPersonalCollectionType>(
        StudentContactPersonalType.class, "StudentContactPersonal", StudentContactPersonalCollectionType.class,
        "StudentContactPersonals");
    studentTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = studentTester.testGetSingle(StudentContactPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentContactPersonalType studentPersonal = (StudentContactPersonalType) response.getDataObject();
    Assert.assertEquals(StudentContactPersonalRefIds.REF_ID_1, studentPersonal.getRefId());

    String xmlExpectedFrom = studentTester.getXML(studentPersonal);

    List<Response> updateResponses = studentTester.doUpdateOne(studentPersonal, StudentContactPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = studentTester.testGetSingle(StudentContactPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    StudentContactPersonalType comparisonTo = (StudentContactPersonalType) getResponse.getDataObject();
    Assert.assertEquals(StudentContactPersonalRefIds.REF_ID_1, comparisonTo.getRefId());
    String xmlExpectedTo = studentTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = studentTester.testGetSingle(StudentContactPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentContactPersonalType studentPersonal = (StudentContactPersonalType) response.getDataObject();
    Assert.assertEquals(StudentContactPersonalRefIds.REF_ID_1, studentPersonal.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = studentTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentContactPersonalCollectionType studentCollection = (StudentContactPersonalCollectionType) response.getDataObject();
    Assert.assertNotNull(studentCollection.getStudentContactPersonal());
    Assert.assertEquals(5, studentCollection.getStudentContactPersonal().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = studentTester.testCreateOne("studentcontactpersonal.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentContactPersonalType studentPersonal = (StudentContactPersonalType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, studentPersonal.getRefId());

    List<Response> deleteResponses = studentTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentTester.testCreateMany("studentcontactpersonals.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = studentTester.testDeleteMany(REF_IDS);
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
  

  @Test
  public void testServicePathStudentPersonal() {
    QueryCriteria queryCriteria = new QueryCriteria();
    queryCriteria.addPredicate(new QueryPredicate("StudentPersonals", QueryOperator.EQUAL, StudentPersonalRefIds.REF_ID_1));

    List<Response> responses = studentTester.testServicePath(queryCriteria, 10000, 0);

    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);

    StudentContactPersonalCollectionType studentContactPersonalCollectionType = (StudentContactPersonalCollectionType) response.getDataObject();
    Assert.assertNotNull(studentContactPersonalCollectionType.getStudentContactPersonal());
    Assert.assertFalse(studentContactPersonalCollectionType.getStudentContactPersonal().isEmpty());
    boolean found = false;
    for (StudentContactPersonalType studentContactPersonal : studentContactPersonalCollectionType.getStudentContactPersonal()) {
      found = found || StudentContactPersonalRefIds.REF_ID_1.equals(studentContactPersonal.getRefId());
    }
    Assert.assertTrue(found);
  }
}
