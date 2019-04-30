package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.WellbeingAlertCollectionType;
import sif.dd.au30.model.WellbeingAlertType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.WellbeingAlertTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.WellbeingAlertTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.WellbeingAlertTestData.XML_REF_ID_RA;

public class WellbeingAlertConsumerTest extends BaseTest<WellbeingAlertType, WellbeingAlertCollectionType> {
    private ConsumerTest<WellbeingAlertType, WellbeingAlertCollectionType> wellbeingAlertTester = null;
    private WellbeingAlertTestData testData = new WellbeingAlertTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        wellbeingAlertTester = new ConsumerTest<>(WellbeingAlertType.class, "WellbeingAlert", WellbeingAlertCollectionType.class, "WellbeingAlerts");
        wellbeingAlertTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<WellbeingAlertType, WellbeingAlertCollectionType> getTester() {
        return wellbeingAlertTester;
    }

    @Override
    public WellbeingAlertTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(WellbeingAlertType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(WellbeingAlertCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingAlertCollectionType::getWellbeingAlert).map(List::size).orElse(-1);
    }

    @Override
    public List<WellbeingAlertType> getCollectionList(WellbeingAlertCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingAlertCollectionType::getWellbeingAlert).orElse(new ArrayList<>());
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
