package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableDayListType;
import sif.dd.au30.model.TimeTableDayType;
import sif.dd.au30.model.TimeTablePeriodListType;
import sif.dd.au30.model.TimeTablePeriodType;
import sif.dd.au30.model.TimeTableType;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableConsumerTest extends BaseTest {
    private ConsumerTest<TimeTableType, TimeTableCollectionType> timeTableTester = null;

    public final static String REF_ID = "4b4a6b5d-4f0a-4f84-88ba-15610caf092f";
    public final static String LOCAL_ID = "Term 4 2014";
    private final String REF_ID_1 = "68681573-638e-4aa7-abdc-4fe19788f772";
    private final String REF_ID_2 = "369d4b5d-95e5-4751-be88-84dd439c4c21";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        TimeTableType timeTable = new TimeTableType();
        timeTable.setRefId(REF_ID);
        timeTable.setSchoolInfoRefId(objectFactory.createTimeTableTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
        timeTable.setSchoolLocalId(objectFactory.createTimeTableTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
        timeTable.setSchoolName(objectFactory.createTimeTableTypeSchoolName(SchoolInfoConsumerTest.SCHOOL_NAME));
        timeTable.setSchoolYear(getDate("2014"));
        timeTable.setLocalId(objectFactory.createTimeTableTypeLocalId(LOCAL_ID));
        timeTable.setTitle("TERM 4 2014");
        timeTable.setDaysPerCycle(5L);
        timeTable.setPeriodsPerDay(6L);
        timeTable.setTimeTableCreationDate(objectFactory.createTimeTableTypeTimeTableCreationDate(getDate("2014-06-01")));
        timeTable.setStartDate(objectFactory.createTimeTableTypeStartDate(getDate("2014-09-01")));
        timeTable.setEndDate(objectFactory.createTimeTableTypeEndDate(getDate("2014-12-21")));

        TimeTableDayListType timeTableDayList = new TimeTableDayListType();
        TimeTableDayType timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("1");
        timeTableDay.setDayTitle("Monday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("2");
        timeTableDay.setDayTitle("Tuesday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("3");
        timeTableDay.setDayTitle("Wednesday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("4");
        timeTableDay.setDayTitle("Thursday");
        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTableDay = new TimeTableDayType();
        timeTableDay.setDayId("5");
        timeTableDay.setDayTitle("Friday");

        TimeTablePeriodListType timeTablePeriodList = new TimeTablePeriodListType();
        TimeTablePeriodType timeTablePeriod = new TimeTablePeriodType();
        timeTablePeriod.setPeriodId("1");
        timeTablePeriod.setPeriodTitle("Form");
        timeTablePeriod.setBellPeriod(objectFactory.createTimeTablePeriodTypeBellPeriod("1"));
        timeTablePeriod.setStartTime(objectFactory.createTimeTablePeriodTypeStartTime(getDate("08:45:00")));
        timeTablePeriod.setEndTime(objectFactory.createTimeTablePeriodTypeEndTime(getDate("09:00:00")));
        timeTablePeriodList.getTimeTablePeriod().add(timeTablePeriod);
        timeTableDay.setTimeTablePeriodList(timeTablePeriodList);

        timeTableDayList.getTimeTableDay().add(timeTableDay);
        timeTable.setTimeTableDayList(timeTableDayList);
        timeTableTester.doCreateOne(timeTable);
        String xmlExpectedTo = timeTableTester.getXML(timeTable);

        timeTable.setRefId("52d3f540-b619-41a4-961c-27ab156c89dd");
        timeTableTester.doCreateOne(timeTable);

        timeTable.setRefId("09900c4f-1ac6-4581-a65e-10d978d98bb3");
        timeTableTester.doCreateOne(timeTable);

        timeTable.setRefId("4654dc21-e632-47f0-a604-e7ed7368f335");
        timeTableTester.doCreateOne(timeTable);
        timeTable.setTimeTableDayList(null);
        timeTableTester.doUpdateOne(timeTable, timeTable.getRefId());

        timeTable.setRefId("626e3e08-cab9-4ddd-80fa-26fbf325b8c9");
        timeTableTester.doCreateOne(timeTable);

        TimeTableType getResult = timeTableTester.doGetOne(REF_ID);
        String xmlExpectedFrom = timeTableTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        timeTableTester = new ConsumerTest<TimeTableType, TimeTableCollectionType>(TimeTableType.class, "TimeTable", TimeTableCollectionType.class, "TimeTables");
        timeTableTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePathSchoolInfo() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoConsumerTest.REF_ID));

        List<Response> responses = timeTableTester.testServicePath(queryCriteria, 10000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        TimeTableCollectionType timeTableCollectionType = (TimeTableCollectionType) response.getDataObject();
        Assert.assertNotNull(timeTableCollectionType.getTimeTable());
        Assert.assertFalse(timeTableCollectionType.getTimeTable().isEmpty());
        boolean found = false;
        for (TimeTableType timeTableType : timeTableCollectionType.getTimeTable()) {
            found = found || REF_ID.equals(timeTableType.getRefId());
            Assert.assertNotNull(timeTableType.getSchoolInfoRefId());
            Assert.assertEquals(SchoolInfoConsumerTest.REF_ID, timeTableType.getSchoolInfoRefId().getValue());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = timeTableTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        TimeTableType timeTable = (TimeTableType) response.getDataObject();
        Assert.assertEquals(REF_ID, timeTable.getRefId());

        String xmlExpectedFrom = timeTableTester.getXML(timeTable);

        List<Response> updateResponses = timeTableTester.doUpdateOne(timeTable, REF_ID);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = timeTableTester.testGetSingle(REF_ID);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        TimeTableType comparisonTo = (TimeTableType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID, comparisonTo.getRefId());
        String xmlExpectedTo = timeTableTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateEmptyDays() throws UnmarshalException, UnsupportedMediaTypeExcpetion, MarshalException {
        String contents = timeTableTester.getFileContents("timetable.xml");
        TimeTableType timeTable = timeTableTester.fromXML(contents);
        timeTable.getTimeTableDayList().getTimeTableDay().clear();
        String xmlExpectedFrom = timeTableTester.getXML(timeTable);

        List<Response> createResponses = timeTableTester.doCreateOne(timeTable);
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        TimeTableType createdTimeTable = (TimeTableType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, createdTimeTable.getRefId());

        String xmlExpectedCreate = timeTableTester.getXML(createdTimeTable);

        List<Response> updateResponses = timeTableTester.doUpdateOne(timeTable, REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = timeTableTester.testGetSingle(REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        TimeTableType comparisonTo = (TimeTableType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = timeTableTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        boolean semiEqualsTwo = semiEquals(xmlExpectedFrom, xmlExpectedCreate);
        if (!semiEquals || !semiEqualsTwo) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nCreate:\n" + xmlExpectedCreate);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateFullDays() throws UnmarshalException, UnsupportedMediaTypeExcpetion, MarshalException {
        String contents = timeTableTester.getFileContents("timetable.xml");
        TimeTableType timeTable = timeTableTester.fromXML(contents);
        String xmlExpectedFrom = timeTableTester.getXML(timeTable);

        List<Response> createResponses = timeTableTester.doCreateOne(timeTable);
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        TimeTableType createdTimeTable = (TimeTableType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, createdTimeTable.getRefId());
        String xmlExpectedCreate = timeTableTester.getXML(createdTimeTable);

        timeTable.getTimeTableDayList().getTimeTableDay().clear();
        String xmlExpectedUpdate = timeTableTester.getXML(timeTable);

        List<Response> updateResponses = timeTableTester.doUpdateOne(timeTable, REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = timeTableTester.testGetSingle(REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        TimeTableType comparisonTo = (TimeTableType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = timeTableTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedUpdate, xmlExpectedTo);
        boolean semiEqualsTwo = semiEquals(xmlExpectedFrom, xmlExpectedCreate);
        if (!semiEqualsTwo) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nCreate:\n" + xmlExpectedCreate);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedCreate);
        }
        if (!semiEquals) {
            System.out.println("Update:\n" + xmlExpectedUpdate);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedUpdate, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = timeTableTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        TimeTableType timeTable = (TimeTableType) response.getDataObject();
        Assert.assertEquals(REF_ID, timeTable.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = timeTableTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        TimeTableCollectionType timeTables = (TimeTableCollectionType) response.getDataObject();
        Assert.assertNotNull(timeTables.getTimeTable());
        Assert.assertEquals(5, timeTables.getTimeTable().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = timeTableTester.testCreateOne("timetable.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        TimeTableType timeTable = (TimeTableType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, timeTable.getRefId());

        List<Response> deleteResponses = timeTableTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testDeleteFailsConstraint() {
        List<Response> responses = timeTableTester.testDeleteOne(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response deleteResponse = responses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), deleteResponse.getStatus());
        Assert.assertTrue(deleteResponse.getError().getMessage().contains("Cannot delete object because it has child objects"));
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = timeTableTester.testCreateMany("timetables.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = timeTableTester.testDeleteMany(REF_IDS);
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
