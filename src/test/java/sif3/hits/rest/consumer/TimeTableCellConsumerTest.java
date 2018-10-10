package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.AUCodeSetsTeacherCoverCreditType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverSupervisionType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.ScheduledTeacherListType;
import sif.dd.au30.model.TeacherCoverType;
import sif.dd.au30.model.TimeTableCellCollectionType;
import sif.dd.au30.model.TimeTableCellType;
import sif3.common.exception.MarshalException;
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
import sif3.hits.utils.RefIdGenerator;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableCellConsumerTest extends BaseTest {
    private ConsumerTest<TimeTableCellType, TimeTableCellCollectionType> timeTableCellTester = null;

    public static final String REF_ID = "301c949d-3769-45fc-9c82-7119c1f9df03";
    public static final String REF_ID_OTHER = "5c6ff7c3-d20d-4fba-a785-b69fccdfbad3";
    public static final String CELL_TYPE = "Teaching";
    public static final String DAY_ID = "1";
    public static final String PERIOD_ID = "1";

    private final String REF_ID_1 = "2d108d35-1ab9-46cd-b2e9-480aaa3f58b8";
    private final String REF_ID_2 = "02721649-3602-40e9-be34-1427424b87b2";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        TimeTableCellType timeTableCell = new TimeTableCellType();
        timeTableCell.setRefId(REF_ID);
        timeTableCell.setSchoolInfoRefId(objectFactory.createTimeTableCellTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
        timeTableCell.setSchoolLocalId(objectFactory.createTimeTableCellTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
        timeTableCell.setTimeTableRefId(TimeTableConsumerTest.REF_ID);
        timeTableCell.setTimeTableLocalId(objectFactory.createTimeTableCellTypeTimeTableLocalId(TimeTableConsumerTest.LOCAL_ID));
        timeTableCell.setTimeTableSubjectRefId(objectFactory.createTimeTableCellTypeTimeTableSubjectRefId(TimeTableSubjectConsumerTest.REF_ID));
        timeTableCell.setSubjectLocalId(objectFactory.createTimeTableCellTypeSubjectLocalId(TimeTableSubjectConsumerTest.LOCAL_ID));
        timeTableCell.setTeachingGroupRefId(TeachingGroupConsumerTest.REF_ID);
        timeTableCell.setTeachingGroupLocalId(objectFactory.createTimeTableCellTypeTeachingGroupLocalId(TeachingGroupConsumerTest.LOCAL_ID));
        timeTableCell.setRoomInfoRefId(objectFactory.createTimeTableCellTypeRoomInfoRefId(RoomInfoConsumerTest.REF_ID));
        timeTableCell.setRoomNumber(objectFactory.createTimeTableCellTypeRoomNumber(RoomInfoConsumerTest.ROOM_NUMBER));
        timeTableCell.setStaffPersonalRefId(objectFactory.createTimeTableCellTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1));
        timeTableCell.setStaffLocalId(objectFactory.createTimeTableCellTypeStaffLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
        timeTableCell.setDayId(DAY_ID);
        timeTableCell.setPeriodId(PERIOD_ID);
        timeTableCell.setCellType(CELL_TYPE);

        timeTableCellTester.doCreateOne(timeTableCell);
        String xmlExpectedTo = timeTableCellTester.getXML(timeTableCell);

        timeTableCell.setRefId(REF_ID_OTHER);
        timeTableCell.setTeachingGroupRefId(null);
        timeTableCellTester.doCreateOne(timeTableCell);

        timeTableCell.setRefId("400d6ef0-7bcf-4513-a45a-3dd9003adbbf");
        timeTableCell.setTeachingGroupRefId("6cd60385-006e-4268-92ef-f69ffc8c5c9f");
        timeTableCell.setDayId("2");
        timeTableCellTester.doCreateOne(timeTableCell);

        timeTableCell.setRefId("1039bdd3-3d08-4f98-8904-c20856605c0b");
        timeTableCell.setDayId("3");
        timeTableCellTester.doCreateOne(timeTableCell);

        timeTableCell.setRefId("3bfc9bed-aab1-47a5-bd57-80ecb3789cac");
        timeTableCell.setDayId("4");
        timeTableCellTester.doCreateOne(timeTableCell);

        timeTableCell.setRefId("5abe4fa8-572c-40f1-97a6-d363a62508f1");
        timeTableCell.setDayId("5");
        timeTableCellTester.doCreateOne(timeTableCell);

        timeTableCell.setRefId("65a9dafb-6361-4b0d-89a8-12e8b195b4fb");
        timeTableCell.setDayId("1");
        timeTableCellTester.doCreateOne(timeTableCell);
        timeTableCell.setStaffPersonalRefId(null);
        timeTableCell.setRoomInfoRefId(null);

        List<Response> extraRsponse = timeTableCellTester.doUpdateOne(timeTableCell, timeTableCell.getRefId());
        Assert.assertEquals("Invalid response status", 204, extraRsponse.get(0).getStatus());
        System.out.println(extraRsponse.get(0).getStatus());

        TimeTableCellType getResult = timeTableCellTester.doGetOne(REF_ID);
        String xmlExpectedFrom = timeTableCellTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        timeTableCellTester = new ConsumerTest<TimeTableCellType, TimeTableCellCollectionType>(TimeTableCellType.class, "TimeTableCell", TimeTableCellCollectionType.class,
                "TimeTableCells");
        timeTableCellTester.testDeleteMany(REF_IDS);
    }
    
    @Test
    @Category(IntegrationTest.class)
    public void testTeacherCover() throws Exception {
        String refId = RefIdGenerator.getRefId();
        ObjectFactory objectFactory = new ObjectFactory();
        TimeTableCellType timeTableCell = new TimeTableCellType();
        timeTableCell.setRefId(refId);
        timeTableCell.setSchoolInfoRefId(objectFactory.createTimeTableCellTypeSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID));
        timeTableCell.setSchoolLocalId(objectFactory.createTimeTableCellTypeSchoolLocalId(SchoolInfoConsumerTest.LOCAL_ID));
        timeTableCell.setTimeTableRefId(TimeTableConsumerTest.REF_ID);
        timeTableCell.setTimeTableLocalId(objectFactory.createTimeTableCellTypeTimeTableLocalId(TimeTableConsumerTest.LOCAL_ID));
        timeTableCell.setTimeTableSubjectRefId(objectFactory.createTimeTableCellTypeTimeTableSubjectRefId(TimeTableSubjectConsumerTest.REF_ID));
        timeTableCell.setSubjectLocalId(objectFactory.createTimeTableCellTypeSubjectLocalId(TimeTableSubjectConsumerTest.LOCAL_ID));
        timeTableCell.setTeachingGroupRefId(TeachingGroupConsumerTest.REF_ID);
        timeTableCell.setTeachingGroupLocalId(objectFactory.createTimeTableCellTypeTeachingGroupLocalId(TeachingGroupConsumerTest.LOCAL_ID));
        timeTableCell.setRoomInfoRefId(objectFactory.createTimeTableCellTypeRoomInfoRefId(RoomInfoConsumerTest.REF_ID));
        timeTableCell.setRoomNumber(objectFactory.createTimeTableCellTypeRoomNumber(RoomInfoConsumerTest.ROOM_NUMBER));
        timeTableCell.setStaffPersonalRefId(objectFactory.createTimeTableCellTypeStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1));
        timeTableCell.setStaffLocalId(objectFactory.createTimeTableCellTypeStaffLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
        timeTableCell.setDayId(DAY_ID);
        timeTableCell.setPeriodId(PERIOD_ID);
        timeTableCell.setCellType(CELL_TYPE);
        
        TeacherCoverType teacherCover1 = new TeacherCoverType();
        teacherCover1.setStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_1);
        teacherCover1.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
        teacherCover1.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getDate("09:00:00")));
        teacherCover1.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getDate("10:00:00")));
        teacherCover1.setCredit(objectFactory.createTeacherCoverTypeCredit(AUCodeSetsTeacherCoverCreditType.CASUAL));
        teacherCover1.setSupervision(objectFactory.createTeacherCoverTypeSupervision(AUCodeSetsTeacherCoverSupervisionType.NORMAL));
        teacherCover1.setWeighting(objectFactory.createTeacherCoverTypeWeighting(new BigDecimal("0.5")));

        TeacherCoverType teacherCover2 = new TeacherCoverType();
        teacherCover2.setStaffPersonalRefId(StaffPersonalConsumerTest.StaffPersonalRefIds.REF_ID_2);
        teacherCover2.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(StaffPersonalConsumerTest.StaffPersonalRefIds.LOCAL_ID));
        teacherCover2.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getDate("09:00:00")));
        teacherCover2.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getDate("10:00:00")));
        teacherCover2.setCredit(objectFactory.createTeacherCoverTypeCredit(AUCodeSetsTeacherCoverCreditType.CASUAL));
        teacherCover2.setSupervision(objectFactory.createTeacherCoverTypeSupervision(AUCodeSetsTeacherCoverSupervisionType.NORMAL));
        teacherCover2.setWeighting(objectFactory.createTeacherCoverTypeWeighting(new BigDecimal("0.5")));

        ScheduledTeacherListType teacherList = new ScheduledTeacherListType();
        teacherList.getTeacherCover().add(teacherCover1);
        teacherList.getTeacherCover().add(teacherCover2);
        timeTableCell.setTeacherList(objectFactory.createTimeTableCellTypeTeacherList((teacherList)));
        
        String xmlFrom = timeTableCellTester.getXML(timeTableCell);
        List<Response> createResponse = timeTableCellTester.doCreateOne(timeTableCell);

        // Validate Response.
        Assert.assertNotNull("Create response not null", createResponse);
        Assert.assertEquals("One create response body", createResponse.size(), 1);
        Assert.assertNotNull("Create response contains body", createResponse.get(0).getDataObject());
        Assert.assertEquals("Object created with correct refId", ((TimeTableCellType) createResponse.get(0).getDataObject()).getRefId(), refId);
        Assert.assertNotNull("Create response contains teacher cover", ((TimeTableCellType) createResponse.get(0).getDataObject()).getTeacherList());
        Assert.assertNotNull("Create response contains teacher cover list", ((TimeTableCellType) createResponse.get(0).getDataObject()).getTeacherList().getValue());
        Assert.assertEquals("Object created with teacher covers", ((TimeTableCellType) createResponse.get(0).getDataObject()).getTeacherList().getValue().getTeacherCover().size(), 2);
        
        TimeTableCellType getResult = timeTableCellTester.doGetOne(refId);
        String xmlTo = timeTableCellTester.getXML(getResult);
        // Validate Body.
        Assert.assertTrue("Object is the same before and after create", semiEquals(xmlFrom, xmlTo));
        
        timeTableCell.setTeacherList(null);
        xmlFrom = timeTableCellTester.getXML(timeTableCell);
        List<Response> updateResponse = timeTableCellTester.doUpdateOne(timeTableCell, refId);
        // Validate Response.
        Assert.assertNotNull("Update response not null", updateResponse);
        Assert.assertEquals("One update response body", updateResponse.size(), 1);
        Assert.assertEquals("No Content response status", updateResponse.get(0).getStatus(), HttpStatus.NO_CONTENT.value());
        
        getResult = timeTableCellTester.doGetOne(refId);
        xmlTo = timeTableCellTester.getXML(getResult);
        // Validate Body
        Assert.assertTrue("Object is the same before and after update", semiEquals(xmlFrom, xmlTo));
        
        timeTableCell.setTeacherList(objectFactory.createTimeTableCellTypeTeacherList((teacherList)));
        xmlFrom = timeTableCellTester.getXML(timeTableCell);
        updateResponse = timeTableCellTester.doUpdateOne(timeTableCell, refId);
        // Validate Response.
        Assert.assertNotNull("Update response not null", updateResponse);
        Assert.assertEquals("One update response body", updateResponse.size(), 1);
        Assert.assertEquals("No Content response status", updateResponse.get(0).getStatus(), HttpStatus.NO_CONTENT.value());
        
        getResult = timeTableCellTester.doGetOne(refId);
        xmlTo = timeTableCellTester.getXML(getResult);
        // Validate Body
        Assert.assertTrue("Object is the same before and after update", semiEquals(xmlFrom, xmlTo));
        
        List<Response> deleteResponse = timeTableCellTester.testDeleteOne(refId);
        // Validate Response.
        Assert.assertNotNull("Delete response not null", deleteResponse);
        Assert.assertEquals("One delete response body", deleteResponse.size(), 1);
        Assert.assertNull("No object in delete response", deleteResponse.get(0).getDataObject());
        Assert.assertEquals("No Content response status", HttpStatus.NO_CONTENT.value(), deleteResponse.get(0).getStatus());
    }
    

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        TimeTableCellType timeTableCell = new TimeTableCellType();
        timeTableCell.setTimeTableRefId(TimeTableConsumerTest.REF_ID);
        List<Response> responses = timeTableCellTester.testQBE(timeTableCell, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        TimeTableCellCollectionType timeTableCellCollectionType = (TimeTableCellCollectionType) response.getDataObject();
        Assert.assertNotNull(timeTableCellCollectionType.getTimeTableCell());
        Assert.assertFalse(timeTableCellCollectionType.getTimeTableCell().isEmpty());
        boolean found = false;
        for (TimeTableCellType timeTableCellType : timeTableCellCollectionType.getTimeTableCell()) {
            found = found || REF_ID.equals(timeTableCellType.getRefId());
            Assert.assertEquals(TimeTableConsumerTest.REF_ID, timeTableCellType.getTimeTableRefId());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePathSchoolInfo() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("SchoolInfos", QueryOperator.EQUAL, SchoolInfoConsumerTest.REF_ID));

        List<Response> responses = timeTableCellTester.testServicePath(queryCriteria, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        TimeTableCellCollectionType timeTableCellCollectionType = (TimeTableCellCollectionType) response.getDataObject();
        Assert.assertNotNull(timeTableCellCollectionType.getTimeTableCell());
        Assert.assertFalse(timeTableCellCollectionType.getTimeTableCell().isEmpty());
        boolean found = false;
        for (TimeTableCellType timeTableCellType : timeTableCellCollectionType.getTimeTableCell()) {
            found = found || REF_ID.equals(timeTableCellType.getRefId());
            Assert.assertNotNull(timeTableCellType.getSchoolInfoRefId());
            Assert.assertEquals(SchoolInfoConsumerTest.REF_ID, timeTableCellType.getSchoolInfoRefId().getValue());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = timeTableCellTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        TimeTableCellType timeTable = (TimeTableCellType) response.getDataObject();
        Assert.assertEquals(REF_ID, timeTable.getRefId());

        String xmlExpectedFrom = timeTableCellTester.getXML(timeTable);

        List<Response> updateResponses = timeTableCellTester.doUpdateOne(timeTable, REF_ID);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = timeTableCellTester.testGetSingle(REF_ID);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        TimeTableCellType comparisonTo = (TimeTableCellType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID, comparisonTo.getRefId());
        String xmlExpectedTo = timeTableCellTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = timeTableCellTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        TimeTableCellType timeTable = (TimeTableCellType) response.getDataObject();
        Assert.assertEquals(REF_ID, timeTable.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = timeTableCellTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        TimeTableCellCollectionType timeTableCells = (TimeTableCellCollectionType) response.getDataObject();
        Assert.assertNotNull(timeTableCells.getTimeTableCell());
        Assert.assertEquals(5, timeTableCells.getTimeTableCell().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = timeTableCellTester.testCreateOne("timetablecell.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        TimeTableCellType timeTableCell = (TimeTableCellType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, timeTableCell.getRefId());

        List<Response> deleteResponses = timeTableCellTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = timeTableCellTester.testCreateMany("timetablecells.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = timeTableCellTester.testDeleteMany(REF_IDS);
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
