package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.NAPTestTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.NAPTestTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.NAPTestTestData.XML_REF_ID_RA;

public class NAPTestConsumerTest extends BaseTest<NAPTestType, NAPTestCollectionType> {
    private ConsumerTest<NAPTestType, NAPTestCollectionType> napTestTester = null;
    private NAPTestTestData testData = new NAPTestTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        napTestTester = new ConsumerTest<>(NAPTestType.class, "NAPTest", NAPTestCollectionType.class, "NAPTests");
        napTestTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<NAPTestType, NAPTestCollectionType> getTester() {
        return napTestTester;
    }

    @Override
    public NAPTestTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(NAPTestType object) {
        return object.getRefId();
    }

    @Override
    public List<NAPTestType> getCollectionList(NAPTestCollectionType collection) {
        return Optional.ofNullable(collection).map(NAPTestCollectionType::getNAPTest).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(NAPTestCollectionType collection) {
        return Optional.ofNullable(collection).map(NAPTestCollectionType::getNAPTest).map(List::size).orElse(-1);
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