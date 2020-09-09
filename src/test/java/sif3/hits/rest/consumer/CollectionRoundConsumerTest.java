package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.CollectionRoundCollectionType;
import sif.dd.au30.model.CollectionRoundType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.CollectionRoundTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.CollectionRoundTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.CollectionRoundTestData.XML_REF_ID_RA;

public class CollectionRoundConsumerTest extends BaseTest<CollectionRoundType, CollectionRoundCollectionType> {
    private ConsumerTest<CollectionRoundType, CollectionRoundCollectionType> collectionRoundTester = null;
    private CollectionRoundTestData testData = new CollectionRoundTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        collectionRoundTester = new ConsumerTest<>(CollectionRoundType.class, "CollectionRound", CollectionRoundCollectionType.class, "CollectionRounds");
        collectionRoundTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<CollectionRoundType, CollectionRoundCollectionType> getTester() {
        return collectionRoundTester;
    }

    @Override
    public CollectionRoundTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(CollectionRoundType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(CollectionRoundCollectionType collection) {
        return Optional.ofNullable(collection).map(CollectionRoundCollectionType::getCollectionRound).map(List::size).orElse(-1);
    }

    @Override
    public List<CollectionRoundType> getCollectionList(CollectionRoundCollectionType collection) {
        return Optional.ofNullable(collection).map(CollectionRoundCollectionType::getCollectionRound).orElse(new ArrayList<>());
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
