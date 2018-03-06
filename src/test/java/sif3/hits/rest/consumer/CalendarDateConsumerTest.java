package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsCalendarEventType;
import sif.dd.au30.model.AttendanceInfoType;
import sif.dd.au30.model.CalendarDateCollectionType;
import sif.dd.au30.model.CalendarDateInfoType;
import sif.dd.au30.model.CalendarDateType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CalendarDateConsumerTest extends BaseTest {
    private ConsumerTest<CalendarDateType, CalendarDateCollectionType> calendarDateTester = null;

    private static final String REF_ID = "4756760b-0748-4471-ba78-ce0f62e70ebf";
    private final String REF_ID_1 = "d283db7b-1716-4b82-ae90-51155b5def0d";
    private final String REF_ID_2 = "40df4ccf-a69b-4b47-9daf-0acd722e1942";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        CalendarDateType calendarDate = new CalendarDateType();
        calendarDate.setDate(getDate("2014-10-11"));
        calendarDate.setCalendarDateRefId(REF_ID);
        calendarDate.setCalendarSummaryRefId(objectFactory.createCalendarDateTypeCalendarSummaryRefId(CalendarSummaryConsumerTest.REF_ID));
        calendarDate.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        calendarDate.setSchoolYear(getDate("2014"));

        CalendarDateInfoType calendarDateType = new CalendarDateInfoType();
        calendarDateType.setCode(AUCodeSetsCalendarEventType.fromValue("INST"));

        OtherCodeListType otherCodeList = new OtherCodeListType();
        OtherCode otherCode = new OtherCode();
        otherCode.setCodeset("Local");
        otherCode.setValue("Normal");
        otherCodeList.getOtherCode().add(otherCode);
        otherCode = new OtherCode();
        otherCode.setCodeset("Local");
        otherCode.setValue("Students");
        otherCodeList.getOtherCode().add(otherCode);
        calendarDateType.setOtherCodeList(objectFactory.createCalendarDateInfoTypeOtherCodeList(otherCodeList));
        calendarDate.setCalendarDateType(calendarDateType);

        calendarDate.setCalendarDateNumber(objectFactory.createCalendarDateTypeCalendarDateNumber(44L));
        AttendanceInfoType studentAttendance = new AttendanceInfoType();
        studentAttendance.setAttendanceValue(new BigDecimal("234"));
        studentAttendance.setCountsTowardAttendance("Yes");
        calendarDate.setStudentAttendance(objectFactory.createCalendarDateTypeStudentAttendance(studentAttendance));

        calendarDateTester.doCreateOne(calendarDate);
        calendarDateTester.doUpdateOne(calendarDate, REF_ID);
        String xmlExpectedTo = calendarDateTester.getXML(calendarDate);

        calendarDate.setCalendarDateRefId("2d647ff7-2091-445b-b4c0-2ee5527277ed");
        calendarDateTester.doCreateOne(calendarDate);

        calendarDate.setCalendarDateRefId("16e97f11-747e-42b6-8a4f-a68b5ede6f1d");
        calendarDateTester.doCreateOne(calendarDate);

        calendarDate.setCalendarDateRefId("abf46d83-aed0-4fb8-98f5-39fbf022e17f");
        calendarDateTester.doCreateOne(calendarDate);
        calendarDate.getCalendarDateType().setOtherCodeList(null);
        calendarDateTester.doUpdateOne(calendarDate, calendarDate.getCalendarDateRefId());

        calendarDate.setCalendarDateRefId("0553c842-df31-4a80-96a1-fa1b3608b52a");
        calendarDateTester.doCreateOne(calendarDate);

        CalendarDateType getResult = calendarDateTester.doGetOne(REF_ID);
        String xmlExpectedFrom = calendarDateTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        calendarDateTester = new ConsumerTest<CalendarDateType, CalendarDateCollectionType>(CalendarDateType.class, "CalendarDate", CalendarDateCollectionType.class,
                "CalendarDates");
        calendarDateTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = calendarDateTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarDateType calendarDate = (CalendarDateType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarDate.getCalendarDateRefId());
        String xmlExpectedFrom = calendarDateTester.getXML(calendarDate);

        List<Response> updateResponses = calendarDateTester.doUpdateOne(calendarDate, REF_ID);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = calendarDateTester.testGetSingle(REF_ID);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        CalendarDateType calendarDateTo = (CalendarDateType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID, calendarDateTo.getCalendarDateRefId());
        String xmlExpectedTo = calendarDateTester.getXML(calendarDateTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingleOtherCodes() throws Exception {
        List<Response> responses = calendarDateTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarDateType calendarDate = (CalendarDateType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarDate.getCalendarDateRefId());
        Assert.assertEquals(2, calendarDate.getCalendarDateType().getOtherCodeList().getValue().getOtherCode().size());

        JAXBElement<OtherCodeListType> otherCodes = calendarDate.getCalendarDateType().getOtherCodeList();
        calendarDate.getCalendarDateType().setOtherCodeList(null);
        calendarDateTester.doUpdateOne(calendarDate, calendarDate.getCalendarDateRefId());

        responses = calendarDateTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        calendarDate = (CalendarDateType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarDate.getCalendarDateRefId());
        Assert.assertNull(calendarDate.getCalendarDateType().getOtherCodeList());

        calendarDate.getCalendarDateType().setOtherCodeList(otherCodes);
        calendarDateTester.doUpdateOne(calendarDate, calendarDate.getCalendarDateRefId());

        responses = calendarDateTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        calendarDate = (CalendarDateType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarDate.getCalendarDateRefId());
        Assert.assertEquals(2, calendarDate.getCalendarDateType().getOtherCodeList().getValue().getOtherCode().size());

        calendarDate.getCalendarDateType().setOtherCodeList(otherCodes);
        calendarDateTester.doUpdateOne(calendarDate, calendarDate.getCalendarDateRefId());

        responses = calendarDateTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        calendarDate = (CalendarDateType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarDate.getCalendarDateRefId());
        Assert.assertEquals(2, calendarDate.getCalendarDateType().getOtherCodeList().getValue().getOtherCode().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = calendarDateTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarDateType calendarDate = (CalendarDateType) response.getDataObject();
        Assert.assertEquals(REF_ID, calendarDate.getCalendarDateRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = calendarDateTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        CalendarDateCollectionType calendarDates = (CalendarDateCollectionType) response.getDataObject();
        Assert.assertNotNull(calendarDates.getCalendarDate());
        Assert.assertEquals(5, calendarDates.getCalendarDate().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = calendarDateTester.testCreateOne("calendardate.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        CalendarDateType calendarDate = (CalendarDateType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, calendarDate.getCalendarDateRefId());

        List<Response> deleteResponses = calendarDateTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = calendarDateTester.testCreateMany("calendardates.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = calendarDateTester.testDeleteMany(REF_IDS);
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
