package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearRangeType;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableSubjectConsumerTest extends BaseTest {
  private ConsumerTest<TimeTableSubjectType, TimeTableSubjectCollectionType> timeTableSubjectTester = null;
  
  public static final String REF_ID = "47b8518b-a430-4848-bd01-dd5d2ea2c617";
  public static final String LOCAL_ID = "Subject 1";
  private final String REF_ID_1 = "4609142f-63e4-43f4-a384-cb81d309438f";
  private final String REF_ID_2 = "6bb0c404-c029-49bd-9956-d6be93b7b124";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };
  
  @Test
  public void initialiseData() throws Exception {
    ObjectFactory objectFactory = new ObjectFactory();

    TimeTableSubjectType timeTableSubject = new TimeTableSubjectType();
    timeTableSubject.setRefId(REF_ID);
    timeTableSubject.setSchoolInfoRefId(objectFactory.createTimeTableSubjectTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
    timeTableSubject.setSchoolLocalId(objectFactory.createTimeTableSubjectTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
    timeTableSubject.setSubjectLocalId(LOCAL_ID);
    YearLevelType yearLevel = new YearLevelType();
    yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("4"));
    timeTableSubject.setAcademicYear(objectFactory.createTimeTableSubjectTypeAcademicYear(yearLevel));
    timeTableSubject.setFaculty(objectFactory.createTimeTableSubjectTypeFaculty("Science"));
    timeTableSubject.setSubjectShortName(objectFactory.createTimeTableSubjectTypeSubjectShortName("Computing"));
    timeTableSubject.setSubjectLongName("Introduction to Computing");
    timeTableSubject.setSubjectType(objectFactory.createTimeTableSubjectTypeSubjectType("Elective"));
    timeTableSubject.setProposedMinClassSize(objectFactory.createTimeTableSubjectTypeProposedMinClassSize(new BigDecimal("12")));
    timeTableSubject.setProposedMaxClassSize(objectFactory.createTimeTableSubjectTypeProposedMaxClassSize(new BigDecimal("25")));
    timeTableSubject.setSemester(objectFactory.createTimeTableSubjectTypeSemester(2L));
    timeTableSubject.setSchoolYear(objectFactory.createTimeTableSubjectTypeSchoolYear(getDate("2014")));
    
    
    OtherCodeListType otherCodeList = new OtherCodeListType();
    OtherCode otherCode = new OtherCode();
    otherCode.setCodeset("Local");
    otherCode.setValue("ITC");
    otherCodeList.getOtherCode().add(otherCode);
    otherCode = new OtherCode();
    otherCode.setCodeset("Local");
    otherCode.setValue("Computing");
    otherCodeList.getOtherCode().add(otherCode);
    timeTableSubject.setOtherCodeList(objectFactory.createTimeTableSubjectTypeOtherCodeList(otherCodeList));
    
    timeTableSubjectTester.doCreateOne(timeTableSubject);
    timeTableSubjectTester.doUpdateOne(timeTableSubject, REF_ID);
    String xmlExpectedTo = timeTableSubjectTester.getXML(timeTableSubject);
    
    timeTableSubject.setRefId("c390d8b1-0f1f-4f23-aec1-880401248512");
    timeTableSubjectTester.doCreateOne(timeTableSubject);
    
    timeTableSubject.setRefId("db9dcfa4-0ecb-4bb2-86e0-a62070907b32");
    timeTableSubjectTester.doCreateOne(timeTableSubject);

    timeTableSubject.setRefId("d4fca448-c173-49a9-89e8-97b4c0344a81");
    timeTableSubjectTester.doCreateOne(timeTableSubject);
    timeTableSubject.setOtherCodeList(null);
    timeTableSubjectTester.doUpdateOne(timeTableSubject, timeTableSubject.getRefId());

    timeTableSubject.setRefId("c3401c3b-994f-4d10-b3d0-6423556b6f39");
    timeTableSubject.setAcademicYear(null);
    YearRangeType yearRange = new YearRangeType();
    YearLevelType startYear = new YearLevelType();
    startYear.setCode(AUCodeSetsYearLevelCodeType.fromValue("K4"));
    YearLevelType endYear = new YearLevelType();
    endYear.setCode(AUCodeSetsYearLevelCodeType.fromValue("6"));
    yearRange.setStart(startYear);
    yearRange.setEnd(endYear);
    timeTableSubject.setAcademicYearRange(objectFactory.createTimeTableSubjectTypeAcademicYearRange(yearRange));
    String xmlExpectedToRange = timeTableSubjectTester.getXML(timeTableSubject);
    timeTableSubjectTester.doCreateOne(timeTableSubject);
    timeTableSubjectTester.doUpdateOne(timeTableSubject, timeTableSubject.getRefId());

    TimeTableSubjectType getResult = timeTableSubjectTester.doGetOne(REF_ID);
    String xmlExpectedFrom = timeTableSubjectTester.getXML(getResult);
    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
    
    getResult = timeTableSubjectTester.doGetOne("c3401c3b-994f-4d10-b3d0-6423556b6f39");
    String xmlExpectedFromRange = timeTableSubjectTester.getXML(getResult);
    boolean semiEqualsRange = semiEquals(xmlExpectedFromRange, xmlExpectedToRange);
    if (!semiEqualsRange) {
      Assert.assertEquals("XML Differs", xmlExpectedFromRange, xmlExpectedToRange);
    }
  }
  
  @Before
  public void setup() {
    ConsumerLoader.initialise("TestConsumer");
    timeTableSubjectTester = new ConsumerTest<TimeTableSubjectType, TimeTableSubjectCollectionType>(
        TimeTableSubjectType.class, "TimeTableSubject", TimeTableSubjectCollectionType.class, "TimeTableSubjects");
    timeTableSubjectTester.testDeleteMany(REF_IDS);
  }
  
  @Test
  public void testServicePathSchoolInfo() {
    QueryCriteria queryCriteria = new QueryCriteria();
    queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoConsumerTest.REF_ID));

    List<Response> responses = timeTableSubjectTester.testServicePath(queryCriteria, 10000, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    TimeTableSubjectCollectionType timeTableSubjectCollectionType = (TimeTableSubjectCollectionType) response.getDataObject();
    Assert.assertNotNull(timeTableSubjectCollectionType.getTimeTableSubject());
    Assert.assertFalse(timeTableSubjectCollectionType.getTimeTableSubject().isEmpty());
    boolean found = false;
    for (TimeTableSubjectType timeTableSubjectType : timeTableSubjectCollectionType.getTimeTableSubject()) {
      found = found || REF_ID.equals(timeTableSubjectType.getRefId());
      Assert.assertNotNull(timeTableSubjectType.getSchoolInfoRefId());
      Assert.assertEquals(SchoolInfoConsumerTest.REF_ID, timeTableSubjectType.getSchoolInfoRefId().getValue());
    }
    Assert.assertTrue(found);
  }
  
  @Test
  public void testUpdateSingle() throws Exception {
    List<Response> responses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTableSubject.getRefId());

    String xmlExpectedFrom = timeTableSubjectTester.getXML(timeTableSubject);

    List<Response> updateResponses = timeTableSubjectTester.doUpdateOne(timeTableSubject, REF_ID);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), updateResponses.get(0).getStatus());

    List<Response> getResponses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(getResponses);
    Assert.assertEquals(1, getResponses.size());
    Response getResponse = getResponses.get(0);
    Assert.assertNotNull(getResponse.getDataObject());
    TimeTableSubjectType comparisonTo = (TimeTableSubjectType) getResponse.getDataObject();
    Assert.assertEquals(REF_ID, comparisonTo.getRefId());
    String xmlExpectedTo = timeTableSubjectTester.getXML(comparisonTo);

    boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
    if (!semiEquals) {
      System.out.println("From:\n" + xmlExpectedFrom);
      System.out.println("\nTo:\n" + xmlExpectedTo);
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }
  
  @Test
  public void testUpdateSingleOtherCodes() throws Exception {
    List<Response> responses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTableSubject.getRefId());
    Assert.assertEquals(2, timeTableSubject.getOtherCodeList().getValue().getOtherCode().size());
    
    JAXBElement<OtherCodeListType> otherCodes = timeTableSubject.getOtherCodeList();
    timeTableSubject.setOtherCodeList(null);
    timeTableSubjectTester.doUpdateOne(timeTableSubject, timeTableSubject.getRefId());
    
    responses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    timeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTableSubject.getRefId());
    Assert.assertNull(timeTableSubject.getOtherCodeList());
    
    timeTableSubject.setOtherCodeList(otherCodes);
    timeTableSubjectTester.doUpdateOne(timeTableSubject, timeTableSubject.getRefId());
    
    responses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    timeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTableSubject.getRefId());
    Assert.assertEquals(2, timeTableSubject.getOtherCodeList().getValue().getOtherCode().size());
    
    timeTableSubject.setOtherCodeList(otherCodes);
    timeTableSubjectTester.doUpdateOne(timeTableSubject, timeTableSubject.getRefId());
    
    responses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    timeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTableSubject.getRefId());
    Assert.assertEquals(2, timeTableSubject.getOtherCodeList().getValue().getOtherCode().size());
  }
  
  
  @Test
  public void testGetSingle() {
    List<Response> responses = timeTableSubjectTester.testGetSingle(REF_ID);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID, timeTableSubject.getRefId());
  }
  
  @Test
  public void testGetMany() {
    List<Response> responses = timeTableSubjectTester.testGetMany(5, 0);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectCollectionType timeTableSubjects = (TimeTableSubjectCollectionType) response.getDataObject();
    Assert.assertNotNull(timeTableSubjects.getTimeTableSubject());
    Assert.assertEquals(5, timeTableSubjects.getTimeTableSubject().size());
  }
  
  @Test
  public void testCreateDelete() {   
    List<Response> createResponses = timeTableSubjectTester.testCreateOne("timetablesubject.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTableSubject.getRefId());
    
    List<Response> deleteResponses = timeTableSubjectTester.testDeleteOne(REF_ID_1);
    Assert.assertNotNull(deleteResponses);
    Assert.assertEquals(1, deleteResponses.size());
    Response deleteResponse = deleteResponses.get(0);
    Assert.assertNull(deleteResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
  }
  
  @Test
  public void testCreateUpdate() {
    List<Response> createResponses = timeTableSubjectTester.testCreateOne("timetablesubject.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    Response createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getDataObject());
    TimeTableSubjectType timeTableSubject = (TimeTableSubjectType) createResponse.getDataObject();
    Assert.assertEquals(REF_ID_1, timeTableSubject.getRefId());
    Assert.assertEquals(2, timeTableSubject.getOtherCodeList().getValue().getOtherCode().size());
    
    List<Response> updateResponses = timeTableSubjectTester.testUpdateOne("timetablesubjectupdate.xml", REF_ID_1);
    Assert.assertNotNull(updateResponses);
    Assert.assertEquals(1, updateResponses.size());
    Response updateResponse = updateResponses.get(0);
    Assert.assertNull(updateResponse.getDataObject());
    Assert.assertEquals(HttpStatus.NO_CONTENT.value(), updateResponse.getStatus());
    
    List<Response> responses = timeTableSubjectTester.testGetSingle(REF_ID_1);
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    Response response = responses.get(0);
    Assert.assertNotNull(response.getDataObject());
    TimeTableSubjectType updatedTimeTableSubject = (TimeTableSubjectType) response.getDataObject();
    Assert.assertEquals(REF_ID_1, updatedTimeTableSubject.getRefId());
    Assert.assertEquals(3, updatedTimeTableSubject.getOtherCodeList().getValue().getOtherCode().size());
    
    timeTableSubjectTester.testDeleteOne(REF_ID_1);
  }
  
  @Test
  public void testCreateDeleteMany() {
    final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

    List<BulkOperationResponse<CreateOperationStatus>> createResponses = timeTableSubjectTester.testCreateMany("timetablesubjects.xml");
    Assert.assertNotNull(createResponses);
    Assert.assertEquals(1, createResponses.size());
    BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
    Assert.assertNotNull(createResponse.getOperationStatuses());
    Assert.assertEquals(2, createResponse.getOperationStatuses().size());
    for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
      Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
      Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
    }

    List<BulkOperationResponse<OperationStatus>> deleteResponses = timeTableSubjectTester.testDeleteMany(REF_IDS);
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
