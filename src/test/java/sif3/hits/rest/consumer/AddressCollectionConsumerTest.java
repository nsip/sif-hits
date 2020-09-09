package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.AddressCollectionCollectionType;
import sif.dd.au30.model.AddressCollectionType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.AddressCollectionTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.AddressCollectionTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.AddressCollectionTestData.XML_REF_ID_RA;

public class AddressCollectionConsumerTest extends BaseTest<AddressCollectionType, AddressCollectionCollectionType> {
    private ConsumerTest<AddressCollectionType, AddressCollectionCollectionType> addressCollectionTester = null;
    private AddressCollectionTestData testData = new AddressCollectionTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        addressCollectionTester = new ConsumerTest<>(AddressCollectionType.class, "AddressCollection", AddressCollectionCollectionType.class, "AddressCollections");
        addressCollectionTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<AddressCollectionType, AddressCollectionCollectionType> getTester() {
        return addressCollectionTester;
    }

    @Override
    public AddressCollectionTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(AddressCollectionType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(AddressCollectionCollectionType collection) {
        return Optional.ofNullable(collection).map(AddressCollectionCollectionType::getAddressCollection).map(List::size).orElse(-1);
    }

    @Override
    public List<AddressCollectionType> getCollectionList(AddressCollectionCollectionType collection) {
        return Optional.ofNullable(collection).map(AddressCollectionCollectionType::getAddressCollection).orElse(new ArrayList<>());
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
