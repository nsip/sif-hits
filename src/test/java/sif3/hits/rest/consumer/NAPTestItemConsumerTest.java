package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsNAPTestItemMarkingTypeType;
import sif.dd.au30.model.AUCodeSetsNAPTestItemTypeType;
import sif.dd.au30.model.AUCodeSetsNAPWritingGenreType;
import sif.dd.au30.model.AUCodeSetsPNPCodeType;
import sif.dd.au30.model.ContentDescriptionListType;
import sif.dd.au30.model.NAPTestItemCollectionType;
import sif.dd.au30.model.NAPTestItemContentType;
import sif.dd.au30.model.NAPTestItemType;
import sif.dd.au30.model.NAPWritingRubricListType;
import sif.dd.au30.model.NAPWritingRubricType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.PNPCodeListType;
import sif.dd.au30.model.ScoreDescriptionListType;
import sif.dd.au30.model.ScoreDescriptionType;
import sif.dd.au30.model.ScoreListType;
import sif.dd.au30.model.ScoreType;
import sif.dd.au30.model.StimulusListType;
import sif.dd.au30.model.StimulusType;
import sif.dd.au30.model.SubstituteItemListType;
import sif.dd.au30.model.SubstituteItemType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPTestItemConsumerTest extends BaseTest {
  private ConsumerTest<NAPTestItemType, NAPTestItemCollectionType> napTestItemTester = null;

  private static final String REF_ID_1 = "ba116707-005a-4388-864d-864c96aebeed";
  private static final String REF_ID_2 = "99529a93-acfb-4ca9-b38d-38c3e8617329";

  public static class NAPTestItemRefIds {
    public static final String REF_ID_1 = "dc1ec31f-3ba4-483c-912c-caccf6cf750f";
    public static final String REF_ID_2 = "98f2f4ba-437c-4235-b2ad-c0aae82833d8";
    public static final String REF_ID_3 = "161e1638-9807-4a00-8a48-67e3b28d86c0";
    public static final String REF_ID_4 = "f1d202ad-c400-4445-9617-fa8f0f64e0b3";
    public static final String REF_ID_5 = "97cc38d1-c42a-42f5-acd8-7bac81a667bc";

    public static final String LOCAL_ID_1 = "R-3-1-1";
    public static final String LOCAL_ID_2 = "R-3-1-2";
    public static final String LOCAL_ID_3 = "R-3-1-3";
    public static final String LOCAL_ID_4 = "R-3-1-4";
    public static final String LOCAL_ID_5 = "R-3-1-5";
  }

  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    NAPTestItemType napTestItemType = new NAPTestItemType();
    napTestItemType.setRefId(NAPTestItemRefIds.REF_ID_1);

    NAPTestItemContentType napTestItemContentType = new NAPTestItemContentType();

    napTestItemContentType.setNAPTestItemLocalId(NAPTestItemRefIds.LOCAL_ID_1);
    napTestItemContentType.setSubdomain("1");
    napTestItemContentType.setItemDescriptor("Descriptor #140524360699280");
    napTestItemContentType.setReleasedStatus(true);
    napTestItemContentType.setCorrectAnswer(objectFactory.createNAPTestItemContentTypeCorrectAnswer("7"));
    napTestItemContentType.setMaximumScore(new BigDecimal("10"));
    napTestItemContentType.setItemDifficulty(new BigDecimal("3"));
    napTestItemContentType.setItemProficiencyBand(new BigInteger("32"));
    napTestItemContentType.setExemplarURL(objectFactory.createNAPTestItemContentTypeExemplarURL("http://example.com/n3.xml"));
    napTestItemContentType.setMarkingType(AUCodeSetsNAPTestItemMarkingTypeType.AS);
    napTestItemContentType.setWritingGenre(objectFactory.createNAPTestItemContentTypeWritingGenre(AUCodeSetsNAPWritingGenreType.NARRATIVE));
    napTestItemContentType.setItemType(AUCodeSetsNAPTestItemTypeType.IC);
    
    ContentDescriptionListType contentDescriptionListType = new ContentDescriptionListType();
    contentDescriptionListType.getContentDescription().add("MNA32");
    contentDescriptionListType.getContentDescription().add("MNA37");
    napTestItemContentType.setContentDescriptionList(objectFactory.createNAPTestItemContentTypeContentDescriptionList(contentDescriptionListType));

    SubstituteItemListType substituteItemListType = new SubstituteItemListType();
    SubstituteItemType substituteItemType = new SubstituteItemType();
    PNPCodeListType pnpCodeListType = new PNPCodeListType();
    pnpCodeListType.getPNPCode().add(AUCodeSetsPNPCodeType.AAM);
    substituteItemType.setPNPCodeList(pnpCodeListType);
    substituteItemType.setSubstituteItemRefId(NAPTestItemRefIds.REF_ID_1);

    StimulusListType stimulusListType = new StimulusListType();
    stimulusListType.getStimulus().add(getStimulus(0));
    stimulusListType.getStimulus().add(getStimulus(1));
    napTestItemContentType.setStimulusList(objectFactory.createNAPTestItemContentTypeStimulusList(stimulusListType));

    NAPWritingRubricListType napWritingRubricListType = new NAPWritingRubricListType();
    napWritingRubricListType.getNAPWritingRubric().add(getWritingRubric(0));
    napWritingRubricListType.getNAPWritingRubric().add(getWritingRubric(1));
    napTestItemContentType.setNAPWritingRubricList(objectFactory.createNAPTestItemContentTypeNAPWritingRubricList(napWritingRubricListType));
    napTestItemType.setTestItemContent(napTestItemContentType);
    
    napTestItemTester.doCreateOne(napTestItemType);
    napTestItemTester.doUpdateOne(napTestItemType, NAPTestItemRefIds.REF_ID_1);
    String xmlExpectedTo = napTestItemTester.getXML(napTestItemType);

    napTestItemType.setRefId(NAPTestItemRefIds.REF_ID_2);
    napTestItemContentType.setNAPTestItemLocalId(NAPTestItemRefIds.LOCAL_ID_2);
    napTestItemContentType.setItemSubstitutedForList(objectFactory.createNAPTestItemContentTypeItemSubstitutedForList(substituteItemListType));
    napTestItemTester.doCreateOne(napTestItemType);

    napTestItemType.setRefId(NAPTestItemRefIds.REF_ID_3);
    napTestItemContentType.setNAPTestItemLocalId(NAPTestItemRefIds.LOCAL_ID_3);
    napTestItemTester.doCreateOne(napTestItemType);

    napTestItemType.setRefId(NAPTestItemRefIds.REF_ID_4);
    napTestItemContentType.setNAPTestItemLocalId(NAPTestItemRefIds.LOCAL_ID_4);
    napTestItemTester.doCreateOne(napTestItemType);

    napTestItemType.setRefId(NAPTestItemRefIds.REF_ID_5);
    napTestItemContentType.setNAPTestItemLocalId(NAPTestItemRefIds.LOCAL_ID_5);
    napTestItemTester.doCreateOne(napTestItemType);

    NAPTestItemType getResult = napTestItemTester.doGetOne(NAPTestItemRefIds.REF_ID_1);
    String xmlExpectedFrom = napTestItemTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  private NAPWritingRubricType getWritingRubric(int index) {
    ObjectFactory objectFactory = new ObjectFactory();
    NAPWritingRubricType napWritingRubricType = new NAPWritingRubricType();
    napWritingRubricType.setRubricType("CS");
    napWritingRubricType.setDescriptor(objectFactory.createNAPWritingRubricTypeDescriptor("Descriptor " + index));

    ScoreListType scoreList = new ScoreListType();
    scoreList.getScore().add(getScore(index, 0));
    scoreList.getScore().add(getScore(index, 1));
    napWritingRubricType.setScoreList(scoreList);

    return napWritingRubricType;
  }

  private ScoreType getScore(int indexParent, int index) {
    ScoreType scoreType = new ScoreType();
    scoreType.setMaxScoreValue(new BigDecimal("11" + indexParent + "" + index));
    ScoreDescriptionListType scoreDescriptionListType = new ScoreDescriptionListType();
    scoreDescriptionListType.getScoreDescription().add(getScoreDescription(indexParent, index, 0));
    scoreDescriptionListType.getScoreDescription().add(getScoreDescription(indexParent, index, 1));
    scoreType.setScoreDescriptionList(scoreDescriptionListType);
    return scoreType;
  }

  private ScoreDescriptionType getScoreDescription(int indexParent, int indexScore, int index) {
    ScoreDescriptionType scoreDescriptionType = new ScoreDescriptionType();
    scoreDescriptionType.setDescriptor("Descriptor " + indexParent + "-" + indexScore + "-" + index);
    scoreDescriptionType.setScoreValue(new BigDecimal("1" + indexParent + "" + indexScore + "" + index));
    return scoreDescriptionType;
  }

  private StimulusType getStimulus(int index) {
    ObjectFactory objectFactory = new ObjectFactory();
    StimulusType stimulusType = new StimulusType();
    stimulusType.setContent("Stiumlus Content " + index);
    stimulusType.setTextDescriptor("Stimulus Descriptor " + index);
    stimulusType.setStimulusLocalId("S-1-1-" + index);
    stimulusType.setTextGenre(objectFactory.createStimulusTypeTextGenre("Text Genre " + index));
    stimulusType.setTextType(objectFactory.createStimulusTypeTextType("Text Type " + index));
    stimulusType.setWordCount(objectFactory.createStimulusTypeWordCount(new BigInteger("234" + index)));
    return stimulusType;
  }

  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    napTestItemTester = new ConsumerTest<NAPTestItemType, NAPTestItemCollectionType>(NAPTestItemType.class, "NAPTestItem", NAPTestItemCollectionType.class, "NAPTestItems");
    napTestItemTester.testDeleteMany(REF_IDS);
  }

  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = napTestItemTester.testGetSingle(NAPTestItemRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    NAPTestItemType napTestItem = (NAPTestItemType) response.getDataObject();
    Assert.assertEquals(NAPTestItemRefIds.REF_ID_1, napTestItem.getRefId());

    String xmlExpectedFrom = napTestItemTester.getXML(napTestItem);

    List<Response> updateResponses = napTestItemTester.doUpdateOne(napTestItem, NAPTestItemRefIds.REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

    List<Response> getResponses = napTestItemTester.testGetSingle(NAPTestItemRefIds.REF_ID_1);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    NAPTestItemType comparisonTo = (NAPTestItemType) getResponse.getDataObject();
    Assert.assertEquals(NAPTestItemRefIds.REF_ID_1, comparisonTo.getRefId());
    String xmlExpectedTo = napTestItemTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

  @Test
  public void testGetSingle() {
    List<Response> responses = napTestItemTester.testGetSingle(NAPTestItemRefIds.REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    NAPTestItemType napTestItem = (NAPTestItemType) response.getDataObject();
    Assert.assertEquals(NAPTestItemRefIds.REF_ID_1, napTestItem.getRefId());
  }

  @Test
  public void testGetMany() {
    List<Response> responses = napTestItemTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    NAPTestItemCollectionType napTestItems = (NAPTestItemCollectionType) response.getDataObject();
    Assert.assertNotNull(napTestItems.getNAPTestItem());
    Assert.assertEquals(5, napTestItems.getNAPTestItem().size());
  }

  @Test
  public void testCreateDelete() {
    List<Response> createResponses = napTestItemTester.testCreateOne("naptestitem.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    NAPTestItemType napTestItem = (NAPTestItemType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, napTestItem.getRefId());

    List<Response> deleteResponses = napTestItemTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }

  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = napTestItemTester.testCreateMany("naptestitems.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = napTestItemTester.testDeleteMany(REF_IDS);
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
