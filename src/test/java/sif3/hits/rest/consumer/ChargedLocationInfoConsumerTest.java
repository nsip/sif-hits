package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.ChargedLocationInfoCollectionType;
import sif.dd.au30.model.ChargedLocationInfoType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.ChargedLocationInfoTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.ChargedLocationInfoTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.ChargedLocationInfoTestData.XML_REF_ID_RA;

public class ChargedLocationInfoConsumerTest extends BaseTest<ChargedLocationInfoType, ChargedLocationInfoCollectionType> {
    private ConsumerTest<ChargedLocationInfoType, ChargedLocationInfoCollectionType> chargedLocationInfoTester = null;
    private ChargedLocationInfoTestData testData = new ChargedLocationInfoTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        chargedLocationInfoTester = new ConsumerTest<>(ChargedLocationInfoType.class, "ChargedLocationInfo", ChargedLocationInfoCollectionType.class, "ChargedLocationInfos");
        chargedLocationInfoTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<ChargedLocationInfoType, ChargedLocationInfoCollectionType> getTester() {
        return chargedLocationInfoTester;
    }

    @Override
    public ChargedLocationInfoTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(ChargedLocationInfoType object) {
        return object.getRefId();
    }

    @Override
    public List<ChargedLocationInfoType> getCollectionList(ChargedLocationInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(ChargedLocationInfoCollectionType::getChargedLocationInfo).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(ChargedLocationInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(ChargedLocationInfoCollectionType::getChargedLocationInfo).map(List::size).orElse(-1);
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
