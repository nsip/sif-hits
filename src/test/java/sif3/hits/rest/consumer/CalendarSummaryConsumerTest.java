package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CalendarSummaryConsumerTest extends BaseTest {
    private ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType> calendarSummaryTester = null;

    public static final String REF_ID = "fccc615a-8288-4148-8934-424ae2da69ca";
    private final String REF_ID_1 = "f9b62c7f-fefd-44be-bc0f-42389ab226d4";
    private final String REF_ID_2 = "f0a8eea4-d002-4ef6-9164-ef430e3e77f0";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        CalendarSummaryType calendarSummary = new CalendarSummaryType();
        calendarSummary.setRefId(REF_ID);
        calendarSummary.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        calendarSummary.setSchoolYear(getDate("2014"));
        calendarSummary.setLocalId("Local Id");
        calendarSummary.setDaysInSession(75L);
        calendarSummary.setStartDate(objectFactory.createCalendarSummaryTypeStartDate(getDate("2014-07-02")));
        calendarSummary.setEndDate(objectFactory.createCalendarSummaryTypeEndDate(getDate("2014-11-02")));
        calendarSummary.setFirstInstructionDate(objectFactory.createCalendarSummaryTypeFirstInstructionDate(getDate("2014-07-12")));
        calendarSummary.setLastInstructionDate(objectFactory.createCalendarSummaryTypeLastInstructionDate(getDate("2014-10-12")));
        calendarSummary.setInstructionalMinutes(objectFactory.createCalendarSummaryTypeInstructionalMinutes(999L));
        calendarSummary.setMinutesPerDay(objectFactory.createCalendarSummaryTypeMinutesPerDay(450L));

        YearLevelsType yearLevels = new YearLevelsType();
        YearLevelType yearLevel = new YearLevelType();
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("4"));
        yearLevels.getYearLevel().add(yearLevel);
        yearLevel = new YearLevelType();
        yearLevel.setCode(AUCodeSetsYearLevelCodeType.fromValue("5"));
        yearLevels.getYearLevel().add(yearLevel);
        calendarSummary.setYearLevels(objectFactory.createCalendarSummaryTypeYearLevels(yearLevels));

        calendarSummaryTester.doCreateOne(calendarSummary);
        String xmlExpectedTo = calendarSummaryTester.getXML(calendarSummary);

        calendarSummary.setRefId("0ce39be7-f574-445a-a210-3303ae5e3642");
        calendarSummaryTester.doCreateOne(calendarSummary);

        calendarSummary.setRefId("5a0bc81d-3e96-4b48-94c5-8e25a0562998");
        calendarSummaryTester.doCreateOne(calendarSummary);

        calendarSummary.setRefId("7e947c78-e69d-4d0f-8cad-c46e4af91b9b");
        calendarSummaryTester.doCreateOne(calendarSummary);

        calendarSummary.setYearLevels(null);
        calendarSummaryTester.doUpdateOne(calendarSummary, calendarSummary.getRefId());

        calendarSummary.setRefId("24dd6830-126a-4a8f-aa4e-c7045e68f8f0");
        calendarSummaryTester.doCreateOne(calendarSummary);

        CalendarSummaryType getResult = calendarSummaryTester.doGetOne(REF_ID);
        String xmlExpectedFrom = calendarSummaryTester.getXML(getResult);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        calendarSummaryTester = new ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType>(CalendarSummaryType.class, "CalendarSummary",
                CalendarSummaryCollectionType.class, "CalendarSummarys");
        calendarSummaryTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        CalendarSummaryType calendarSummary = new CalendarSummaryType();
        calendarSummary.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        calendarSummary.setDaysInSession(75L);
        List<Response> responses = calendarSummaryTester.testQBE(calendarSummary, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        CalendarSummaryCollectionType calendarSummaryCollectionType = (CalendarSummaryCollectionType) response.getDataObject();
        Assert.assertNotNull(calendarSummaryCollectionType.getCalendarSummary());
        Assert.assertFalse(calendarSummaryCollectionType.getCalendarSummary().isEmpty());
        boolean found = false;
        for (CalendarSummaryType calendarSummaryType : calendarSummaryCollectionType.getCalendarSummary()) {
            found = found || REF_ID.equals(calendarSummaryType.getRefId());
            Assert.assertEquals(SchoolInfoConsumerTest.REF_ID, calendarSummaryType.getSchoolInfoRefId());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = calendarSummaryTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarSummaryType calendarSummary = (CalendarSummaryType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarSummary.getRefId());
        String xmlExpectedFrom = calendarSummaryTester.getXML(calendarSummary);

        List<Response> updateResponses = calendarSummaryTester.doUpdateOne(calendarSummary, REF_ID);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = calendarSummaryTester.testGetSingle(REF_ID);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        CalendarSummaryType calendarSummaryTo = (CalendarSummaryType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID, calendarSummaryTo.getRefId());
        String xmlExpectedTo = calendarSummaryTester.getXML(calendarSummaryTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingleYearLevels() throws Exception {
        List<Response> responses = calendarSummaryTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarSummaryType calendarSummary = (CalendarSummaryType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarSummary.getRefId());
        Assert.assertEquals(2, calendarSummary.getYearLevels().getValue().getYearLevel().size());

        JAXBElement<YearLevelsType> yearLevels = calendarSummary.getYearLevels();
        calendarSummary.setYearLevels(null);
        calendarSummaryTester.doUpdateOne(calendarSummary, calendarSummary.getRefId());

        responses = calendarSummaryTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        calendarSummary = (CalendarSummaryType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarSummary.getRefId());
        Assert.assertNull(calendarSummary.getYearLevels());

        calendarSummary.setYearLevels(yearLevels);
        calendarSummaryTester.doUpdateOne(calendarSummary, calendarSummary.getRefId());

        responses = calendarSummaryTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        calendarSummary = (CalendarSummaryType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarSummary.getRefId());
        Assert.assertEquals(2, calendarSummary.getYearLevels().getValue().getYearLevel().size());

        calendarSummary.setYearLevels(yearLevels);
        calendarSummaryTester.doUpdateOne(calendarSummary, calendarSummary.getRefId());

        responses = calendarSummaryTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        calendarSummary = (CalendarSummaryType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarSummary.getRefId());
        Assert.assertEquals(2, calendarSummary.getYearLevels().getValue().getYearLevel().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = calendarSummaryTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarSummaryType calendarSummary = (CalendarSummaryType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarSummary.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = calendarSummaryTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarSummaryCollectionType calendarSummarys = (CalendarSummaryCollectionType) response.getDataObject();
        Assert.assertNotNull(calendarSummarys.getCalendarSummary());
        Assert.assertEquals(5, calendarSummarys.getCalendarSummary().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = calendarSummaryTester.testCreateOne("calendarsummary.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        CalendarSummaryType calendarSummary = (CalendarSummaryType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, calendarSummary.getRefId());

        List<Response> deleteResponses = calendarSummaryTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = calendarSummaryTester.testCreateMany("calendarsummarys.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = calendarSummaryTester.testDeleteMany(REF_IDS);
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
