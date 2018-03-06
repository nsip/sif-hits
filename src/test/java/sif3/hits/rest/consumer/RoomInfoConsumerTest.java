package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.RoomInfoCollectionType;
import sif.dd.au30.model.RoomInfoType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class RoomInfoConsumerTest extends BaseTest {
    private ConsumerTest<RoomInfoType, RoomInfoCollectionType> roomInfoTester = null;

    public static final String REF_ID = "c5cbd0bc-1005-48a3-8686-99d6e7a68095";
    public static final String ROOM_NUMBER = "Room 6";
    private final String REF_ID_1 = "dcafc510-c27f-45f7-b8f5-18ba612571a8";
    private final String REF_ID_2 = "68b15630-cf6e-4d0f-bcc7-ff1e3e3ac87f";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        RoomInfoType roomInfo = new RoomInfoType();
        roomInfo.setRefId(REF_ID);
        roomInfo.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        roomInfo.setRoomNumber(ROOM_NUMBER);
        roomInfo.setDescription(objectFactory.createRoomInfoTypeDescription("Computing Lab"));
        roomInfo.setCapacity(objectFactory.createRoomInfoTypeCapacity(20L));
        roomInfo.setSize(objectFactory.createRoomInfoTypeSize(new BigDecimal("28.8")));
        roomInfo.setRoomType(objectFactory.createRoomInfoTypeRoomType("C"));
        roomInfo.setLocalId(objectFactory.createRoomInfoTypeLocalId("Room6"));
        roomInfoTester.doCreateOne(roomInfo);
        String xmlExpectedTo = roomInfoTester.getXML(roomInfo);

        roomInfo.setRefId("3cdb9d5c-0eb1-4599-99d4-5dbb507b6ae1");
        roomInfoTester.doCreateOne(roomInfo);

        roomInfo.setRefId("75de482e-e8bf-4e4a-b25f-24d04bd486d4");
        roomInfoTester.doCreateOne(roomInfo);

        roomInfo.setRefId("1455a267-b620-4501-a123-697c0d5718ee");
        roomInfoTester.doCreateOne(roomInfo);

        roomInfo.setRefId("12c679af-adca-451c-b2c3-2ea4b0e10e99");
        roomInfoTester.doCreateOne(roomInfo);

        RoomInfoType getResult = roomInfoTester.doGetOne(REF_ID);
        String xmlExpectedFrom = roomInfoTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        roomInfoTester = new ConsumerTest<RoomInfoType, RoomInfoCollectionType>(RoomInfoType.class, "RoomInfo", RoomInfoCollectionType.class, "RoomInfos");
        roomInfoTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        RoomInfoType roomInfo = new RoomInfoType();
        roomInfo.setSchoolInfoRefId(SchoolInfoConsumerTest.REF_ID);
        List<Response> responses = roomInfoTester.testQBE(roomInfo, 10000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        RoomInfoCollectionType roomInfoCollectionType = (RoomInfoCollectionType) response.getDataObject();
        Assert.assertNotNull(roomInfoCollectionType.getRoomInfo());
        Assert.assertFalse(roomInfoCollectionType.getRoomInfo().isEmpty());
        boolean found = false;
        for (RoomInfoType roomInfoType : roomInfoCollectionType.getRoomInfo()) {
            found = found || REF_ID.equals(roomInfoType.getRefId());
            Assert.assertEquals(SchoolInfoConsumerTest.REF_ID, roomInfoType.getSchoolInfoRefId());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = roomInfoTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        RoomInfoType roomInfo = (RoomInfoType) response.getDataObject();
        Assert.assertEquals(REF_ID, roomInfo.getRefId());

        String xmlExpectedFrom = roomInfoTester.getXML(roomInfo);

        List<Response> updateResponses = roomInfoTester.doUpdateOne(roomInfo, REF_ID);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = roomInfoTester.testGetSingle(REF_ID);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        RoomInfoType comparisonTo = (RoomInfoType) getResponse.getDataObject();
        Assert.assertEquals(REF_ID, comparisonTo.getRefId());
        String xmlExpectedTo = roomInfoTester.getXML(comparisonTo);

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
        List<Response> responses = roomInfoTester.testGetSingle(REF_ID);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        RoomInfoType roomInfo = (RoomInfoType) response.getDataObject();
        Assert.assertEquals(REF_ID, roomInfo.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = roomInfoTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        RoomInfoCollectionType roomInfos = (RoomInfoCollectionType) response.getDataObject();
        Assert.assertNotNull(roomInfos.getRoomInfo());
        Assert.assertEquals(5, roomInfos.getRoomInfo().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = roomInfoTester.testCreateOne("roominfo.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        RoomInfoType roomInfo = (RoomInfoType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, roomInfo.getRefId());

        List<Response> deleteResponses = roomInfoTester.testDeleteOne(REF_ID_1);
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

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = roomInfoTester.testCreateMany("roominfos.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = roomInfoTester.testDeleteMany(REF_IDS);
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
