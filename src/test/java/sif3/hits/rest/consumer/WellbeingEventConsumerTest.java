package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.WellbeingEventCollectionType;
import sif.dd.au30.model.WellbeingEventType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.WellbeingEventTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.WellbeingEventTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.WellbeingEventTestData.XML_REF_ID_RA;

public class WellbeingEventConsumerTest extends BaseTest<WellbeingEventType, WellbeingEventCollectionType> {
    private ConsumerTest<WellbeingEventType, WellbeingEventCollectionType> wellbeingEventTester = null;
    private WellbeingEventTestData testData = new WellbeingEventTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        wellbeingEventTester = new ConsumerTest<>(WellbeingEventType.class, "WellbeingEvent", WellbeingEventCollectionType.class, "WellbeingEvents");
        wellbeingEventTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<WellbeingEventType, WellbeingEventCollectionType> getTester() {
        return wellbeingEventTester;
    }

    @Override
    public WellbeingEventTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(WellbeingEventType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(WellbeingEventCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingEventCollectionType::getWellbeingEvent).map(List::size).orElse(-1);
    }

    @Override
    public List<WellbeingEventType> getCollectionList(WellbeingEventCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingEventCollectionType::getWellbeingEvent).orElse(new ArrayList<>());
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
