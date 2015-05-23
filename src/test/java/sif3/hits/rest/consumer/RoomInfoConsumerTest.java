package sif3.hits.rest.consumer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.RoomInfoCollectionType;
import sif.dd.au30.model.RoomInfoType;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.infra.rest.consumer.ConsumerLoader;

public class RoomInfoConsumerTest extends BaseTest {
  private ConsumerTest<RoomInfoType, RoomInfoCollectionType> roomInfoTester = null;
  
  public static final String REF_ID = "C5CBD0BC100548A3868699D6E7A68095";
  public static final String ROOM_NUMBER = "Room 6";
  private final String REF_ID_1 = "DCAFC510C27F45F7B8F518BA612571A8";
  private final String REF_ID_2 = "68B15630CF6E4D0FBCC7FF1E3E3AC87F";
  private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

  @Test
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

    roomInfo.setRefId("3CDB9D5C0EB1459999D45DBB507B6AE1");
    roomInfoTester.doCreateOne(roomInfo);

    roomInfo.setRefId("75DE482EE8BF4E4AB25F24D04BD486D4");
    roomInfoTester.doCreateOne(roomInfo);

    roomInfo.setRefId("1455A267B6204501A123697C0D5718EE");
    roomInfoTester.doCreateOne(roomInfo);

    roomInfo.setRefId("12C679AFADCA451CB2C32EA4B0E10E99");
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
    roomInfoTester = new ConsumerTest<RoomInfoType, RoomInfoCollectionType>(RoomInfoType.class, "RoomInfo",
        RoomInfoCollectionType.class, "RoomInfos");
    roomInfoTester.testDeleteMany(REF_IDS);
  }

  @Test
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
