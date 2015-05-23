package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsStaffStatusType;
import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.EmailListType.Email;
import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberListType.PhoneNumber;
import sif.dd.au30.model.StaffCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif.dd.au30.model.StaffPersonalType.OtherIdList;
import sif.dd.au30.model.StaffPersonalType.OtherIdList.OtherId;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StaffPersonalConsumerTest extends BaseTest {
  private ConsumerTest<StaffPersonalType, StaffCollectionType> staffTester = null;
  
  public static class StaffPersonalRefIds {
    public static String REF_ID_1 = "7D83555D24E94D4FBB3E21D7AD86B8D3";
    public static String REF_ID_2 = "40453960800E47D1AE1E8DEE599EAAF8";
    public static String REF_ID_3 = "4414F636F3CA4EB6889888810A7E3018";
    public static String REF_ID_4 = "46077B1371F64C109ED0275F16952F05";
    public static String REF_ID_5 = "9E62AE55ABA141A18F3ED09635B203F5";
    
    public static String LOCAL_ID = "ez7b7b7";
    
    public static NameOfRecordType getNameOfRecord(ObjectFactory objectFactory) {
      NameOfRecordType nameOfRecordType = new NameOfRecordType();
      nameOfRecordType.setFamilyName(objectFactory.createBaseNameTypeFamilyName("Tester"));
      nameOfRecordType.setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName("PTester"));
      nameOfRecordType.setGivenName(objectFactory.createBaseNameTypeGivenName("Gavin"));
      nameOfRecordType.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName("PGavin"));
      nameOfRecordType.setMiddleName(objectFactory.createBaseNameTypeMiddleName("Middle"));
      nameOfRecordType.setTitle(objectFactory.createBaseNameTypeTitle("Mr"));
      nameOfRecordType.setFullName(objectFactory.createBaseNameTypeFullName("Mr Full Name Gavin Tester"));
      return nameOfRecordType;
    }
  }
  
  private final String REF_ID_1 = "E9F19488026B11E3A5325DE06940ABA2";
  private final String REF_ID_2 = "E9F19488026B11E3A5325DE06940ABA4";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    StaffPersonalType staffPersonalType = new StaffPersonalType();
    staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_1);
    staffPersonalType.setLocalId(StaffPersonalRefIds.LOCAL_ID);
    
    PersonInfoType personInfo = new PersonInfoType();
    NameOfRecordType nameOfRecordType = StaffPersonalRefIds.getNameOfRecord(objectFactory);
    personInfo.setName(nameOfRecordType);
    
    DemographicsType demographics = new DemographicsType();
    demographics.setSex(objectFactory.createDemographicsTypeSex("1"));
    demographics.setBirthDate(objectFactory.createDemographicsTypeBirthDate(getDate("1984-12-20")));
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
    
    staffPersonalType.setPersonInfo(personInfo);
    
    staffPersonalType.setEmploymentStatus(objectFactory.createStaffPersonalTypeEmploymentStatus(AUCodeSetsStaffStatusType.A));
    staffPersonalType.setStateProvinceId(objectFactory.createStaffPersonalTypeStateProvinceId("WA"));
    
    OtherIdList otherIdList = new OtherIdList();
    OtherId otherId = new OtherId();
    otherId.setType("0004");
    otherId.setValue("identifier");
    otherIdList.getOtherId().add(otherId);
    otherId = new OtherId();
    otherId.setType("0003");
    otherId.setValue("otherid");
    otherIdList.getOtherId().add(otherId);
    staffPersonalType.setOtherIdList(objectFactory.createStaffPersonalTypeOtherIdList(otherIdList));
    
    staffTester.doCreateOne(staffPersonalType);
    String xmlExpectedTo = staffTester.getXML(staffPersonalType);
    
    staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_2);
    staffTester.doCreateOne(staffPersonalType);
    staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_3);
    staffTester.doCreateOne(staffPersonalType);
    staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_4);
    staffTester.doCreateOne(staffPersonalType);
    staffPersonalType.setRefId(StaffPersonalRefIds.REF_ID_5);
    staffPersonalType.setOtherIdList(null);
    staffTester.doCreateOne(staffPersonalType);

    StaffPersonalType getResult = staffTester.doGetOne(StaffPersonalRefIds.REF_ID_1);
    String xmlExpectedFrom = staffTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);  
    }
  }
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    staffTester = new ConsumerTest<StaffPersonalType, StaffCollectionType>(
        StaffPersonalType.class, "StaffPersonal", StaffCollectionType.class, "StaffPersonals");
    staffTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testGetSingle() {
    List<Response> responses = staffTester.testGetSingle(StaffPersonalRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffPersonalType staffPersonal = (StaffPersonalType) response.getDataObject();
    Assert.assertEquals(StaffPersonalRefIds.REF_ID_1, staffPersonal.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = staffTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    StaffCollectionType staffCollection = (StaffCollectionType) response.getDataObject();
    Assert.assertNotNull(staffCollection.getStaffPersonal());
    Assert.assertEquals(5, staffCollection.getStaffPersonal().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = staffTester.testCreateOne("staff.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    StaffPersonalType staffPersonal = (StaffPersonalType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, staffPersonal.getRefId());
    
    List<Response> deleteResponses = staffTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);
    
    List<BulkOperationResponse<CreateOperationStatus>> createResponses = staffTester.testCreateMany("staffs.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }
    
    List<BulkOperationResponse<OperationStatus>> deleteResponses = staffTester.testDeleteMany(REF_IDS);
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
