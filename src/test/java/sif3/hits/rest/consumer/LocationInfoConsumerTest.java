package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.ChargedLocationInfoCollectionType;
import sif.dd.au30.model.ChargedLocationInfoType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.PhoneNumberListType.PhoneNumber;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.utils.UsesConstants;
import sif3.infra.rest.consumer.ConsumerLoader;

public class LocationInfoConsumerTest extends BaseTest implements UsesConstants {
  private ConsumerTest<ChargedLocationInfoType, ChargedLocationInfoCollectionType> locationTester = null;

  public static class LocationInfoRefIds {
    public static String REF_ID_1 = "5a34535f-9521-43ca-8038-de8250acb3ab";
    public static String REF_ID_2 = "e3540245-a2cc-4aec-8b1e-7c46a663d436";
    public static String REF_ID_3 = "0bad2bbe-1054-4db6-9f41-fbbee5c74c7f";
    public static String REF_ID_4 = "ef55fda1-3ea3-4a5b-86cd-e338557855e1";
    public static String REF_ID_5 = "941ec0a5-ed00-4f81-b6c9-46135621f77a";
  }

  private final String REF_ID_1 = "bc33ad46-3992-4b07-90d7-cadc1992fe02";
  private final String REF_ID_2 = "c73864fe-ba42-4f7a-891b-1afecb94cb9e";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    ChargedLocationInfoType locationInfo = new ChargedLocationInfoType();
    locationInfo.setRefId(LocationInfoRefIds.REF_ID_2);
    locationInfo.setDescription(objectFactory.createChargedLocationInfoTypeDescription("Description"));
    locationInfo.setLocalId(objectFactory.createChargedLocationInfoTypeLocalId("localId"));
    locationInfo.setLocationType("School");
    locationInfo.setName("Main Campus");
    
    PhoneNumberListType phoneNumberList = objectFactory.createPhoneNumberListType();
    PhoneNumber phoneNumber = objectFactory.createPhoneNumberListTypePhoneNumber();
    phoneNumber.setNumber("0894463125");
    phoneNumber.setType(DEFAULT_PHONE_TYPE);
    phoneNumberList.getPhoneNumber().add(phoneNumber);
    locationInfo.setPhoneNumberList(objectFactory.createChargedLocationInfoTypePhoneNumberList(phoneNumberList));
    
    locationInfo.setSchoolInfoRefId(objectFactory.createChargedLocationInfoTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    locationInfo.setSiteCategory("Campus");
    locationInfo.setStateProvinceId(objectFactory.createChargedLocationInfoTypeStateProvinceId("WA"));

    AddressListType addressList = objectFactory.createAddressListType();
    addressList.getAddress().add(StudentPersonalRefIds.getAddress(objectFactory, "1 Address Street", null));
    locationInfo.setAddressList(objectFactory.createDebtorTypeAddressList(addressList));

    locationTester.doCreateOne(locationInfo);
    locationInfo.setRefId(LocationInfoRefIds.REF_ID_1);
    locationInfo.setParentChargedLocationInfoRefId(objectFactory.createChargedLocationInfoTypeParentChargedLocationInfoRefId(LocationInfoRefIds.REF_ID_2));
    locationTester.doCreateOne(locationInfo);
    String xmlExpectedTo = locationTester.getXML(locationInfo);
    
    locationInfo.setRefId(LocationInfoRefIds.REF_ID_3);
    locationTester.doCreateOne(locationInfo);
    locationInfo.setRefId(LocationInfoRefIds.REF_ID_4);
    locationTester.doCreateOne(locationInfo);
    locationInfo.setRefId(LocationInfoRefIds.REF_ID_5);
    locationTester.doCreateOne(locationInfo);

    ChargedLocationInfoType getResult = locationTester.doGetOne(LocationInfoRefIds.REF_ID_1);
    String xmlExpectedFrom = locationTester.getXML(getResult);
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
    locationTester = new ConsumerTest<ChargedLocationInfoType, ChargedLocationInfoCollectionType>(
        ChargedLocationInfoType.class, "ChargedLocationInfo", ChargedLocationInfoCollectionType.class,
        "ChargedLocationInfos");
    locationTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = locationTester.testGetSingle(LocationInfoRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    ChargedLocationInfoType locationInfo = (ChargedLocationInfoType) response.getDataObject();
    Assert.assertEquals(LocationInfoRefIds.REF_ID_1, locationInfo.getRefId());
    
    String xmlExpectedFrom = locationTester.getXML(locationInfo);
    
    List<Response> updateResponses = locationTester.doUpdateOne(locationInfo, LocationInfoRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());
    
    List<Response> getResponses = locationTester.testGetSingle(LocationInfoRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    ChargedLocationInfoType comparisonTo = (ChargedLocationInfoType) getResponse.getDataObject();
    Assert.assertEquals(LocationInfoRefIds.REF_ID_1, comparisonTo.getRefId());
    String xmlExpectedTo = locationTester.getXML(comparisonTo);
    
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = locationTester.testGetSingle(LocationInfoRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    ChargedLocationInfoType locationInfo = (ChargedLocationInfoType) response.getDataObject();
    Assert.assertEquals(LocationInfoRefIds.REF_ID_1, locationInfo.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = locationTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    ChargedLocationInfoCollectionType studentCollection = (ChargedLocationInfoCollectionType) response.getDataObject();
    Assert.assertNotNull(studentCollection.getChargedLocationInfo());
    Assert.assertEquals(5, studentCollection.getChargedLocationInfo().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = locationTester.testCreateOne("locationinfo.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    ChargedLocationInfoType locationInfo = (ChargedLocationInfoType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, locationInfo.getRefId());

    List<Response> deleteResponses = locationTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = locationTester.testCreateMany("locationinfos.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = locationTester.testDeleteMany(REF_IDS);
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
