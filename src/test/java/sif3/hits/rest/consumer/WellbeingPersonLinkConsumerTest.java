package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.WellbeingPersonLinkCollectionType;
import sif.dd.au30.model.WellbeingPersonLinkType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.WellbeingPersonLinkTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.WellbeingPersonLinkTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.WellbeingPersonLinkTestData.XML_REF_ID_RA;

public class WellbeingPersonLinkConsumerTest extends BaseTest<WellbeingPersonLinkType, WellbeingPersonLinkCollectionType> {
    private ConsumerTest<WellbeingPersonLinkType, WellbeingPersonLinkCollectionType> wellbeingPersonLinkTester = null;
    private WellbeingPersonLinkTestData testData = new WellbeingPersonLinkTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        wellbeingPersonLinkTester = new ConsumerTest<>(WellbeingPersonLinkType.class, "WellbeingPersonLink", WellbeingPersonLinkCollectionType.class, "WellbeingPersonLinks");
        wellbeingPersonLinkTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<WellbeingPersonLinkType, WellbeingPersonLinkCollectionType> getTester() {
        return wellbeingPersonLinkTester;
    }

    @Override
    public WellbeingPersonLinkTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(WellbeingPersonLinkType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(WellbeingPersonLinkCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingPersonLinkCollectionType::getWellbeingPersonLink).map(List::size).orElse(-1);
    }

    @Override
    public List<WellbeingPersonLinkType> getCollectionList(WellbeingPersonLinkCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingPersonLinkCollectionType::getWellbeingPersonLink).orElse(new ArrayList<>());
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
