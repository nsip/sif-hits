package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsNAPParticipationCodeType;
import sif.dd.au30.model.AUCodeSetsPNPCodeType;
import sif.dd.au30.model.AUCodeSetsSchoolSectorCodeType;
import sif.dd.au30.model.AdjustmentContainerType;
import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PNPCodeListType;
import sif.dd.au30.model.TestDisruptionListType;
import sif.dd.au30.model.TestDisruptionType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.NAPTestConsumerTest.NAPTestRefIds;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPEventStudentLinkConsumerTest extends BaseTest {
  private ConsumerTest<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> napEventStudentLinkTester = null;

  private static final String REF_ID_1 = "1adc0ede-bfbd-4b7d-83ac-b29fb4fb5e08";
  private static final String REF_ID_2 = "c43f1f2b-eee8-4cc9-8658-1ea77d13af55";

  public static class NAPEventStudentLinkRefIds {
    public static final String REF_ID_1 = "abd6c386-2a6d-4643-abd9-a2b9f3f3f4d4";
    public static final String REF_ID_2 = "bede48b1-b93c-4d06-bbb6-2b91aa0f6a2f";
    public static final String REF_ID_3 = "4d1b49b4-e271-46a1-a3c7-12da80a01ca6";
    public static final String REF_ID_4 = "a7cbc970-a8fa-4554-b820-7328fd98f2cc";
    public static final String REF_ID_5 = "0196063e-6f09-414a-82fe-857c97d43f16";
  }

  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();
    
    NAPEventStudentLinkType napEventStudentLinkType = new NAPEventStudentLinkType();
    napEventStudentLinkType.setRefId(NAPEventStudentLinkRefIds.REF_ID_1);
    napEventStudentLinkType.setExemptionReason(objectFactory.createNAPEventStudentLinkTypeExemptionReason("Did not attend"));
    napEventStudentLinkType.setNAPTestLocalId(NAPTestRefIds.LOCAL_ID_1);
    napEventStudentLinkType.setNAPTestRefId(objectFactory.createNAPEventStudentLinkTypeNAPTestRefId(NAPTestRefIds.REF_ID_1));
    napEventStudentLinkType.setParticipationCode(AUCodeSetsNAPParticipationCodeType.P);
    napEventStudentLinkType.setParticipationText("Participated");
    napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalRefIds.PSI_ID_1);
    napEventStudentLinkType.setSchoolACARAId(SchoolInfoConsumerTest.ACARA_ID);
    napEventStudentLinkType.setSchoolGeolocation(objectFactory.createNAPEventStudentLinkTypeSchoolGeolocation("2"));
    napEventStudentLinkType.setSchoolSector(AUCodeSetsSchoolSectorCodeType.GOV);
    napEventStudentLinkType.setReportingSchoolName(objectFactory.createNAPEventStudentLinkTypeReportingSchoolName("Bens Test State High School"));
    napEventStudentLinkType.setSchoolInfoRefId(objectFactory.createNAPEventStudentLinkTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_1));
    
    TestDisruptionListType testDisruptionListType = new TestDisruptionListType();
    TestDisruptionType testDisruptionType = new TestDisruptionType();
    testDisruptionType.setEvent("Test centre on fire");
    testDisruptionListType.getTestDisruption().add(testDisruptionType);
    
    AdjustmentContainerType adjustmentType = new AdjustmentContainerType();
    adjustmentType.setBookletType(objectFactory.createAdjustmentContainerTypeBookletType("Braille"));
    
    PNPCodeListType pnpCodeListType = new PNPCodeListType();
    pnpCodeListType.getPNPCode().add(AUCodeSetsPNPCodeType.AIA);
    pnpCodeListType.getPNPCode().add(AUCodeSetsPNPCodeType.AIM);
        
    adjustmentType.setPNPCodeList(pnpCodeListType);
    
    napEventStudentLinkType.setAdjustment(objectFactory.createNAPEventStudentLinkTypeAdjustment(adjustmentType));
    napEventStudentLinkType.setTestDisruptionList(objectFactory.createNAPEventStudentLinkTypeTestDisruptionList(testDisruptionListType));
    
    String xmlExpectedTo = napEventStudentLinkTester.getXML(napEventStudentLinkType);
    napEventStudentLinkTester.doCreateOne(napEventStudentLinkType);
    
    napEventStudentLinkType.setRefId(NAPEventStudentLinkRefIds.REF_ID_2);
    napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalRefIds.PSI_ID_2);
    napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_2));
    napEventStudentLinkTester.doCreateOne(napEventStudentLinkType);
    
    napEventStudentLinkType.setRefId(NAPEventStudentLinkRefIds.REF_ID_3);
    napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalRefIds.PSI_ID_3);
    napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_3));
    napEventStudentLinkTester.doCreateOne(napEventStudentLinkType);

    napEventStudentLinkType.setRefId(NAPEventStudentLinkRefIds.REF_ID_4);
    napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalRefIds.PSI_ID_4);
    napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_4));
    napEventStudentLinkTester.doCreateOne(napEventStudentLinkType);
    
    napEventStudentLinkType.setRefId(NAPEventStudentLinkRefIds.REF_ID_5);
    napEventStudentLinkType.setPlatformStudentIdentifier(StudentPersonalRefIds.PSI_ID_5);
    napEventStudentLinkType.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(StudentPersonalRefIds.REF_ID_5));
    napEventStudentLinkTester.doCreateOne(napEventStudentLinkType);
    
    NAPEventStudentLinkType getResult = napEventStudentLinkTester.doGetOne(NAPEventStudentLinkRefIds.REF_ID_1);
    String xmlExpectedFrom = napEventStudentLinkTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    napEventStudentLinkTester = new ConsumerTest<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType>(NAPEventStudentLinkType.class, "NAPEventStudentLink", NAPEventStudentLinkCollectionType.class, "NAPEventStudentLinks");
    napEventStudentLinkTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = napEventStudentLinkTester.testGetSingle(NAPEventStudentLinkRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    NAPEventStudentLinkType napEventStudentLinkType = (NAPEventStudentLinkType) response.getDataObject();
    Assert.assertEquals(NAPEventStudentLinkRefIds.REF_ID_1, napEventStudentLinkType.getRefId());

    String xmlExpectedFrom = napEventStudentLinkTester.getXML(napEventStudentLinkType);

    List<Response> updateResponses = napEventStudentLinkTester.doUpdateOne(napEventStudentLinkType, NAPEventStudentLinkRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = napEventStudentLinkTester.testGetSingle(NAPEventStudentLinkRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    NAPEventStudentLinkType comparisonTo = (NAPEventStudentLinkType) getResponse.getDataObject();
    Assert.assertEquals(NAPEventStudentLinkRefIds.REF_ID_1, comparisonTo.getRefId());
    String xmlExpectedTo = napEventStudentLinkTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = napEventStudentLinkTester.testGetSingle(NAPEventStudentLinkRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    NAPEventStudentLinkType napTest = (NAPEventStudentLinkType) response.getDataObject();
    Assert.assertEquals(NAPEventStudentLinkRefIds.REF_ID_1, napTest.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = napEventStudentLinkTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    NAPEventStudentLinkCollectionType napEventStudentLinks = (NAPEventStudentLinkCollectionType) response.getDataObject();
    Assert.assertNotNull(napEventStudentLinks.getNAPEventStudentLink());
    Assert.assertEquals(5, napEventStudentLinks.getNAPEventStudentLink().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = napEventStudentLinkTester.testCreateOne("napeventstudentlink.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    NAPEventStudentLinkType napTest = (NAPEventStudentLinkType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, napTest.getRefId());

    List<Response> deleteResponses = napEventStudentLinkTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = napEventStudentLinkTester.testCreateMany("napeventstudentlinks.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = napEventStudentLinkTester.testDeleteMany(REF_IDS);
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
