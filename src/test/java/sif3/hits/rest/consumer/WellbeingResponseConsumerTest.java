package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.WellbeingResponseCollectionType;
import sif.dd.au30.model.WellbeingResponseType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.WellbeingResponseTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.WellbeingResponseTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.WellbeingResponseTestData.XML_REF_ID_RA;

public class WellbeingResponseConsumerTest extends BaseTest<WellbeingResponseType, WellbeingResponseCollectionType> {
    private ConsumerTest<WellbeingResponseType, WellbeingResponseCollectionType> wellbeingResponseTester = null;
    private WellbeingResponseTestData testData = new WellbeingResponseTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        wellbeingResponseTester = new ConsumerTest<>(WellbeingResponseType.class, "WellbeingResponse", WellbeingResponseCollectionType.class, "WellbeingResponses");
        wellbeingResponseTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<WellbeingResponseType, WellbeingResponseCollectionType> getTester() {
        return wellbeingResponseTester;
    }

    @Override
    public WellbeingResponseTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(WellbeingResponseType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(WellbeingResponseCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingResponseCollectionType::getWellbeingResponse).map(List::size).orElse(-1);
    }

    @Override
    public List<WellbeingResponseType> getCollectionList(WellbeingResponseCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingResponseCollectionType::getWellbeingResponse).orElse(new ArrayList<>());
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
    public void testQBES() {
        super.testQBES();
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePaths() {
        super.testServicePaths();
    }

}
