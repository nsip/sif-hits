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
import sif.dd.au30.model.EmailListType.Email;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberListType.PhoneNumber;
import sif.dd.au30.model.StudentContactCollectionType;
import sif.dd.au30.model.StudentContactPersonalType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentContactPersonalConsumerTest extends BaseTest {
  private ConsumerTest<StudentContactPersonalType, StudentContactCollectionType> studentTester = null;

  public static class StudentContactPersonalRefIds {
    public static String REF_ID_1 = "281BC15585984873933E7A9EF336B98D";
    public static String REF_ID_2 = "F53C639F87E04B178285E625C210AF74";
    public static String REF_ID_3 = "1CD40A276A634210B3A4BDF6BE4D7DE4";
    public static String REF_ID_4 = "92483A4BA25A4E55A0CB998ADF0B1161";
    public static String REF_ID_5 = "C0E550AD3EB24A8C8CA6F5AB0FD547B2";
  }

  private final String REF_ID_1 = "884FAFD92FEB4770827DA5121BD85E41";
  private final String REF_ID_2 = "73EEE22596364C17BE1B67DE6CC73237";
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
    PhoneNumber phoneNumber = new PhoneNumber();
    phoneNumber.setNumber("+61400000000");
    phoneNumberList.getPhoneNumber().add(phoneNumber);
    personInfo.setPhoneNumberList(objectFactory.createPhoneNumberList(phoneNumberList));

    EmailListType emailList = new EmailListType();
    Email email = new Email();
    email.setType("06"); // AUCodeSetsEmailTypeType.WORK
    email.setValue("the.email@not.a.real.domain");
    emailList.getEmail().add(email);
    personInfo.setEmailList(objectFactory.createEmailList(emailList));

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
    studentTester = new ConsumerTest<StudentContactPersonalType, StudentContactCollectionType>(
        StudentContactPersonalType.class, "StudentContactPersonal", StudentContactCollectionType.class,
        "StudentContactPersonals");
    studentTester.testDeleteMany(REF_IDS);
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
    StudentContactCollectionType studentCollection = (StudentContactCollectionType) response.getDataObject();
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
}
