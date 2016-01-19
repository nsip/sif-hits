package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsOperationalStatusType;
import sif.dd.au30.model.AUCodeSetsSchoolLevelType;
import sif.dd.au30.model.AUCodeSetsSchoolSectorCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.AddressType.Street;
import sif.dd.au30.model.GridLocationType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif.dd.au30.model.SchoolInfoType.Campus;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class SchoolInfoConsumerTest extends BaseTest {
  private ConsumerTest<SchoolInfoType, SchoolInfoCollectionType> schoolInfoTester = null;

  public final static String REF_ID = "6dafb630-c439-41e3-9aa0-81f4dbd909ab";
  public static final String LOCAL_ID = "4001";
  public static final String SCHOOL_NAME = "Bens Test State High School";

  private final String REF_ID_1 = "830c3bcb-0bfc-4adc-96b2-f08318ff8627";
  private final String REF_ID_2 = "58a322e4-a353-4198-8602-25f124c5836c";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    SchoolInfoType schoolInfo = objectFactory.createSchoolInfoType();
    schoolInfo.setRefId(REF_ID);
    schoolInfo.setLocalId(objectFactory.createSchoolInfoTypeLocalId(LOCAL_ID));
    schoolInfo.setSchoolName(SCHOOL_NAME);
    schoolInfo.setStateProvinceId(objectFactory.createSchoolInfoTypeStateProvinceId("WA"));
    schoolInfo.setCommonwealthId(objectFactory.createSchoolInfoTypeCommonwealthId("cid"));

    Campus campus = objectFactory.createSchoolInfoTypeCampus();
    campus.setAdminStatus(AUCodeSetsYesOrNoCategoryType.N);
    campus.setSchoolCampusId("4001");
    campus.setCampusType(objectFactory.createSchoolInfoTypeCampusCampusType(AUCodeSetsSchoolLevelType.SEC));
    campus.setParentSchoolId(objectFactory.createSchoolInfoTypeCampusParentSchoolId("4001"));
    schoolInfo.setCampus(objectFactory.createSchoolInfoTypeCampus(campus));

    schoolInfo.setSchoolSector(AUCodeSetsSchoolSectorCodeType.GOV);
    schoolInfo
        .setOperationalStatus(objectFactory.createSchoolInfoTypeOperationalStatus(AUCodeSetsOperationalStatusType.O));
    schoolInfo
        .setIndependentSchool(objectFactory.createSchoolInfoTypeIndependentSchool(AUCodeSetsYesOrNoCategoryType.N));
    schoolInfo.setSchoolType(objectFactory.createSchoolInfoTypeSchoolType(AUCodeSetsSchoolLevelType.SEC));

    AddressListType addressList = objectFactory.createAddressListType();
    AddressType address = objectFactory.createAddressType();
    address.setStateProvince(objectFactory.createAddressTypeStateProvince("WA"));
    address.setCity("Bens Town");
    address.setPostalCode("6001");

    Street street = objectFactory.createAddressTypeStreet();
    street.setStreetNumber(objectFactory.createAddressTypeStreetStreetNumber("1"));
    street.setStreetName(objectFactory.createAddressTypeStreetStreetName("School Street"));
    address.setStreet(street);

    GridLocationType gridLocation = objectFactory.createGridLocationType();
    gridLocation.setLongitude(new BigDecimal("117.8918605"));
    gridLocation.setLatitude(new BigDecimal("-35.0197027"));
    address.setGridLocation(objectFactory.createAddressTypeGridLocation(gridLocation));

    addressList.getAddress().add(address);
    schoolInfo.setAddressList(objectFactory.createSchoolInfoTypeAddressList(addressList));
    schoolInfo.setSchoolGeographicLocation(objectFactory.createSchoolInfoTypeSchoolGeographicLocation("2"));
    schoolInfo.setARIA(objectFactory.createSchoolInfoTypeARIA(new BigDecimal("1")));
    schoolInfo.setEntityOpen(objectFactory.createSchoolInfoTypeEntityOpen(getDate("1990-02-01")));
    schoolInfo.setEntityClose(objectFactory.createSchoolInfoTypeEntityClose(getDate("2014-12-20")));

    schoolInfoTester.doCreateOne(schoolInfo);
    SchoolInfoType getResult = schoolInfoTester.doGetOne(REF_ID);

    String xmlExpectedTo = schoolInfoTester.getXML(schoolInfo);
    System.out.println("To:\n" + xmlExpectedTo);
    String xmlExpectedFrom = schoolInfoTester.getXML(getResult);
    System.out.println("From:\n" + xmlExpectedFrom);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    schoolInfoTester = new ConsumerTest<SchoolInfoType, SchoolInfoCollectionType>(SchoolInfoType.class, "SchoolInfo",
        SchoolInfoCollectionType.class, "SchoolInfos");
    schoolInfoTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = schoolInfoTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SchoolInfoType schoolInfoPersonal = (SchoolInfoType) response.getDataObject();
    Assert.assertEquals(REF_ID, schoolInfoPersonal.getRefId());

    String xmlExpectedFrom = schoolInfoTester.getXML(schoolInfoPersonal);

    List<Response> updateResponses = schoolInfoTester.doUpdateOne(schoolInfoPersonal, REF_ID);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = schoolInfoTester.testGetSingle(REF_ID);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    SchoolInfoType comparisonTo = (SchoolInfoType) getResponse.getDataObject();
    Assert.assertEquals(REF_ID, comparisonTo.getRefId());
    String xmlExpectedTo = schoolInfoTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = schoolInfoTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SchoolInfoType schoolInfoPersonal = (SchoolInfoType) response.getDataObject();
    Assert.assertEquals(REF_ID, schoolInfoPersonal.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = schoolInfoTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    SchoolInfoCollectionType schoolInfoCollection = (SchoolInfoCollectionType) response.getDataObject();
    Assert.assertNotNull(schoolInfoCollection.getSchoolInfo());
    Assert.assertEquals(1, schoolInfoCollection.getSchoolInfo().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = schoolInfoTester.testCreateOne("school.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    SchoolInfoType schoolInfoPersonal = (SchoolInfoType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, schoolInfoPersonal.getRefId());

    List<Response> deleteResponses = schoolInfoTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = schoolInfoTester.testCreateMany("schools.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = schoolInfoTester.testDeleteMany(REF_IDS);
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
