package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.AddressType.Street;
import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.DemographicsType.Religion;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailType;
import sif.dd.au30.model.GridLocationType;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberType;
import sif.dd.au30.model.StudentPersonalCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.StudentPersonalType.MostRecent;
import sif.dd.au30.model.StudentPersonalType.OtherIdList;
import sif.dd.au30.model.StudentPersonalType.OtherIdList.OtherId;
import sif.dd.au30.model.YearLevelType;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentPersonalConsumerTest extends BaseTest {
  private ConsumerTest<StudentPersonalType, StudentPersonalCollectionType> studentTester = null;

  public static class StudentPersonalRefIds {
    public static String REF_ID_1 = "f7dd788e-3cef-40eb-9cb4-af90a2fa3147";
    public static String REF_ID_2 = "125db961-4475-4820-b9a3-8ce90e37c006";
    public static String REF_ID_3 = "b3270c8a-7a1e-4360-9336-8733728bab44";
    public static String REF_ID_4 = "17998aa6-3a07-4763-a2c5-1fabbd966039";
    public static String REF_ID_5 = "1f631f1d-8832-4775-b199-5eb9650e8ebb";
    
    public static String LOCAL_ID = "s0004432";
    
    public static NameOfRecordType getNameOfRecord(ObjectFactory objectFactory) {
      NameOfRecordType nameOfRecordType = new NameOfRecordType();
      nameOfRecordType.setType("LGL");
      nameOfRecordType.setFamilyName(objectFactory.createBaseNameTypeFamilyName("Tester"));
      nameOfRecordType.setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName("PTester"));
      nameOfRecordType.setGivenName(objectFactory.createBaseNameTypeGivenName("Gavin"));
      nameOfRecordType.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName("PGavin"));
      nameOfRecordType.setMiddleName(objectFactory.createBaseNameTypeMiddleName("Middle"));
      nameOfRecordType.setFullName(objectFactory.createBaseNameTypeFullName("Mr Full Name Gavin Tester"));
      return nameOfRecordType;
    }
    
    public static AddressType getAddress(ObjectFactory objectFactory, String addressLineOne, String addressLineTwo) {
      AddressType address = new AddressType();
      getAddress(objectFactory, address, addressLineOne, addressLineTwo);
      return address;
    }
    
    public static AddressType getAddressType(ObjectFactory objectFactory, String addressLineOne, String addressLineTwo) {
      AddressType address = new AddressType();
      getAddress(objectFactory, address, addressLineOne, addressLineTwo);
      return address;
    }
    
    public static void getAddress(ObjectFactory objectFactory, AddressType address, String addressLineOne, String addressLineTwo) {
      address.setCity("Perth");
      address.setStateProvince(objectFactory.createAddressTypeStateProvince("WA"));
      address.setType("0123");
      address.setRole("012B");
      address.setPostalCode("6000");
      
      Street street = objectFactory.createAddressTypeStreet();
      street.setLine1(addressLineOne);
      if (StringUtils.isNotBlank(addressLineTwo)) {
        street.setLine2(objectFactory.createAddressTypeStreetLine2(addressLineTwo));
      }
      address.setStreet(street);
      
      GridLocationType gridLocation = objectFactory.createGridLocationType();
      gridLocation.setLatitude(new BigDecimal("-31.952693"));
      gridLocation.setLongitude(new BigDecimal("115.871971"));
      address.setGridLocation(objectFactory.createAddressTypeGridLocation(gridLocation));
    }
  }

  private final String REF_ID_1 = "6bb0c404-c029-49bd-9956-d6be93b7b128";
  private final String REF_ID_2 = "6bb0c404-c029-49bd-9956-d6be93b7b124";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    StudentPersonalType studentPersonalType = new StudentPersonalType();
    studentPersonalType.setRefId(StudentPersonalRefIds.REF_ID_1);
    studentPersonalType.setLocalId(StudentPersonalRefIds.LOCAL_ID);

    MostRecent mostRecent = new MostRecent();
    YearLevelType yearLevel = new YearLevelType();
    yearLevel.setCode("4");
    mostRecent.setYearLevel(objectFactory.createStudentPersonalTypeMostRecentYearLevel(yearLevel));
    mostRecent.setParent1Language(objectFactory.createStudentPersonalTypeMostRecentParent1Language("English"));
    mostRecent.setParent2Language(objectFactory.createStudentPersonalTypeMostRecentParent2Language("French"));
    mostRecent.setParent1SchoolEducationLevel(objectFactory
        .createStudentPersonalTypeMostRecentParent1SchoolEducationLevel("High School"));
    mostRecent.setParent2SchoolEducationLevel(objectFactory
        .createStudentPersonalTypeMostRecentParent2SchoolEducationLevel("High School"));
    mostRecent.setParent1NonSchoolEducation(objectFactory
        .createStudentPersonalTypeMostRecentParent1NonSchoolEducation("Tafe"));
    mostRecent.setParent2NonSchoolEducation(objectFactory
        .createStudentPersonalTypeMostRecentParent2NonSchoolEducation("College"));
    mostRecent.setParent1EmploymentType(objectFactory
        .createStudentPersonalTypeMostRecentParent1EmploymentType("Self Employed"));
    mostRecent.setParent2EmploymentType(objectFactory
        .createStudentPersonalTypeMostRecentParent2EmploymentType("Full Time"));
    studentPersonalType.setMostRecent(objectFactory.createStudentPersonalTypeMostRecent(mostRecent));

    PersonInfoType personInfo = new PersonInfoType();
    NameOfRecordType nameOfRecordType = StudentPersonalRefIds.getNameOfRecord(objectFactory);
    personInfo.setName(nameOfRecordType);

    DemographicsType demographics = new DemographicsType();
    demographics.setSex(objectFactory.createDemographicsTypeSex("1"));
    demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDate("1984-12-20")));
    demographics.setIndigenousStatus(objectFactory.createDemographicsTypeIndigenousStatus("9"));
    demographics.setCountryOfBirth(objectFactory.createDemographicsTypeCountryOfBirth("AUS"));

    Religion religion = new Religion();
    religion.setCode("0001");
    demographics.setReligion(objectFactory.createDemographicsTypeReligion(religion));
    personInfo.setDemographics(objectFactory.createPersonInfoTypeDemographics(demographics));

    PhoneNumberListType phoneNumberList = new PhoneNumberListType();
    PhoneNumberType phoneNumber = new PhoneNumberType();
    phoneNumber.setType("0096");
    phoneNumber.setNumber("+61400000000");
    phoneNumberList.getPhoneNumber().add(phoneNumber);
    personInfo.setPhoneNumberList(objectFactory.createPhoneNumberList(phoneNumberList));

    EmailListType emailList = new EmailListType();
    EmailType email = new EmailType();
    email.setType("06"); // AUCodeSetsEmailTypeType.WORK
    email.setValue("the.email@not.a.real.domain");
    emailList.getEmail().add(email);
    personInfo.setEmailList(objectFactory.createEmailList(emailList));
    
    AddressListType addresses = objectFactory.createAddressListType();
    addresses.getAddress().add(StudentPersonalRefIds.getAddress(objectFactory, "123 Address Line One", "Address Line Two"));
    addresses.getAddress().add(StudentPersonalRefIds.getAddress(objectFactory, "234 Address Line One", null));
    personInfo.setAddressList(objectFactory.createPersonInfoTypeAddressList(addresses));
    studentPersonalType.setPersonInfo(personInfo);
    studentPersonalType.setStateProvinceId(objectFactory.createStudentPersonalTypeStateProvinceId("WA"));

    OtherIdList otherIdList = new OtherIdList();
    OtherId otherId = new OtherId();
    otherId.setType("0004");
    otherId.setValue("identifier");
    otherIdList.getOtherId().add(otherId);
    otherId = new OtherId();
    otherId.setType("0003");
    otherId.setValue("otherid");
    otherIdList.getOtherId().add(otherId);
    studentPersonalType.setOtherIdList(objectFactory.createStudentPersonalTypeOtherIdList(otherIdList));

    studentTester.doCreateOne(studentPersonalType);
    String xmlExpectedTo = studentTester.getXML(studentPersonalType);

    studentPersonalType.setRefId(StudentPersonalRefIds.REF_ID_2);
    studentTester.doCreateOne(studentPersonalType);
    studentPersonalType.setRefId(StudentPersonalRefIds.REF_ID_3);
    studentTester.doCreateOne(studentPersonalType);
    studentPersonalType.setRefId(StudentPersonalRefIds.REF_ID_4);
    studentTester.doCreateOne(studentPersonalType);
    studentPersonalType.setRefId(StudentPersonalRefIds.REF_ID_5);
    studentPersonalType.setOtherIdList(null);
    studentTester.doCreateOne(studentPersonalType);

    StudentPersonalType getResult = studentTester.doGetOne(StudentPersonalRefIds.REF_ID_1);
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
    studentTester = new ConsumerTest<StudentPersonalType, StudentPersonalCollectionType>(StudentPersonalType.class,
        "StudentPersonal", StudentPersonalCollectionType.class, "StudentPersonals");
    studentTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = studentTester.testGetSingle(StudentPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPersonalType studentPersonal = (StudentPersonalType) response.getDataObject();
    Assert.assertEquals(StudentPersonalRefIds.REF_ID_1, studentPersonal.getRefId());

    String xmlExpectedFrom = studentTester.getXML(studentPersonal);

    List<Response> updateResponses = studentTester.doUpdateOne(studentPersonal, StudentPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = studentTester.testGetSingle(StudentPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    StudentPersonalType comparisonTo = (StudentPersonalType) getResponse.getDataObject();
    Assert.assertEquals(StudentPersonalRefIds.REF_ID_1, comparisonTo.getRefId());
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
    List<Response> responses = studentTester.testGetSingle(StudentPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPersonalType studentPersonal = (StudentPersonalType) response.getDataObject();
    Assert.assertEquals(StudentPersonalRefIds.REF_ID_1, studentPersonal.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = studentTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPersonalCollectionType studentCollection = (StudentPersonalCollectionType) response.getDataObject();
    Assert.assertNotNull(studentCollection.getStudentPersonal());
    Assert.assertEquals(5, studentCollection.getStudentPersonal().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = studentTester.testCreateOne("student.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentPersonalType studentPersonal = (StudentPersonalType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, studentPersonal.getRefId());

    List<Response> deleteResponses = studentTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateUpdateDelete() {
    List<Response> createResponses = studentTester.testCreateOne("student.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StudentPersonalType studentPersonal = (StudentPersonalType) createResponse.getDataObject();
    try {
      System.out.println(studentTester.getXML(studentPersonal));
    } catch (MarshalException | UnsupportedMediaTypeExcpetion e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Assert.assertEquals(REF_ID_1, studentPersonal.getRefId());
    Assert.assertEquals(2, studentPersonal.getOtherIdList().getValue().getOtherId().size());
    Assert.assertEquals(2, studentPersonal.getPersonInfo().getAddressList().getValue().getAddress().size());
    
    studentPersonal.getPersonInfo().getAddressList().getValue().getAddress().remove(1);
    studentPersonal.getOtherIdList().getValue().getOtherId().remove(1);
    
    List<Response> updateResponses = studentTester.doUpdateOne(studentPersonal, REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Response updateResponse = updateResponses.get(0);
    Assert.assertNull(updateResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), updateResponse.getStatus());
    
//    StudentSchoolEnrollmentType enrollmentType = new StudentSchoolEnrollmentType();
//    enrollmentType.setRefId(REF_ID_2);
//    enrollmentType.setStudentPersonalRefId(REF_ID_1);
//    enrollmentType.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
//    studentSchoolEnrollmentTester.doCreateOne(enrollmentType);
      
    List<Response> responses = studentTester.testGetSingle(REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StudentPersonalType updatedStudentPersonal = (StudentPersonalType) response.getDataObject();
    Assert.assertEquals(REF_ID_1, updatedStudentPersonal.getRefId());
    Assert.assertEquals(1, updatedStudentPersonal.getOtherIdList().getValue().getOtherId().size());
    Assert.assertEquals(1, updatedStudentPersonal.getPersonInfo().getAddressList().getValue().getAddress().size());
    
//    studentSchoolEnrollmentTester.testDeleteOne(REF_ID_2);
//    studentTester.testDeleteOne(REF_ID_1);
  }
  
  @Test
  public void testServicePathTeachingGroup() {
    QueryCriteria queryCriteria = new QueryCriteria();
    queryCriteria.addPredicate(new QueryPredicate("TeachingGroups", QueryOperator.EQUAL, TeachingGroupConsumerTest.REF_ID));

    List<Response> responses = studentTester.testServicePath(queryCriteria, 10000, 0);
    
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    
    StudentPersonalCollectionType studentPersonalCollectionType = (StudentPersonalCollectionType) response.getDataObject();
    Assert.assertNotNull(studentPersonalCollectionType.getStudentPersonal());
    Assert.assertFalse(studentPersonalCollectionType.getStudentPersonal().isEmpty());
    boolean found = false;
    for (StudentPersonalType studentPersonal : studentPersonalCollectionType.getStudentPersonal()) {
      found = found || StudentPersonalRefIds.REF_ID_1.equals(studentPersonal.getRefId());
    }
    Assert.assertTrue(found);
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = studentTester.testCreateMany("students.xml");
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