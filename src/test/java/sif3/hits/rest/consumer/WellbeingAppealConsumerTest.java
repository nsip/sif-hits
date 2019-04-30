package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.WellbeingAppealCollectionType;
import sif.dd.au30.model.WellbeingAppealType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.WellbeingAppealTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.WellbeingAppealTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.WellbeingAppealTestData.XML_REF_ID_RA;

public class WellbeingAppealConsumerTest extends BaseTest<WellbeingAppealType, WellbeingAppealCollectionType> {
    private ConsumerTest<WellbeingAppealType, WellbeingAppealCollectionType> wellbeingAppealTester = null;
    private WellbeingAppealTestData testData = new WellbeingAppealTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        wellbeingAppealTester = new ConsumerTest<>(WellbeingAppealType.class, "WellbeingAppeal", WellbeingAppealCollectionType.class, "WellbeingAppeals");
        wellbeingAppealTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<WellbeingAppealType, WellbeingAppealCollectionType> getTester() {
        return wellbeingAppealTester;
    }

    @Override
    public WellbeingAppealTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(WellbeingAppealType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(WellbeingAppealCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingAppealCollectionType::getWellbeingAppeal).map(List::size).orElse(-1);
    }

    @Override
    public List<WellbeingAppealType> getCollectionList(WellbeingAppealCollectionType collection) {
        return Optional.ofNullable(collection).map(WellbeingAppealCollectionType::getWellbeingAppeal).orElse(new ArrayList<>());
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
