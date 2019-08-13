package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.RoomInfoCollectionType;
import sif.dd.au30.model.RoomInfoType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.RoomInfoTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.RoomInfoTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.RoomInfoTestData.XML_REF_ID_RA;

public class RoomInfoConsumerTest extends BaseTest<RoomInfoType, RoomInfoCollectionType> {
    private ConsumerTest<RoomInfoType, RoomInfoCollectionType> roomInfoTester = null;
    private RoomInfoTestData testData = new RoomInfoTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        roomInfoTester = new ConsumerTest<>(RoomInfoType.class, "RoomInfo", RoomInfoCollectionType.class, "RoomInfos");
        roomInfoTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<RoomInfoType, RoomInfoCollectionType> getTester() {
        return roomInfoTester;
    }

    @Override
    public RoomInfoTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(RoomInfoType object) {
        return object.getRefId();
    }

    @Override
    public List<RoomInfoType> getCollectionList(RoomInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(RoomInfoCollectionType::getRoomInfo).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(RoomInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(RoomInfoCollectionType::getRoomInfo).map(List::size).orElse(-1);
    }

    @Test
    @Category({IntegrationTest.class, InitialiseData.class})
    public void initialiseData() {
        super.initialiseData();
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() {
        super.testUpdateSingle();
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        super.testGetSingle();
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        super.testGetMany();
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        super.testCreateDelete(XML_REF_ID_1);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        super.testCreateDeleteMany(XML_REF_ID_RA);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBES() {
        super.testQBES();
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePaths() {
        super.testServicePaths();
    }

}
