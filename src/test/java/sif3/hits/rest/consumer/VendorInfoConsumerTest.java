package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.VendorInfoCollectionType;
import sif.dd.au30.model.VendorInfoType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.VendorInfoTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.VendorInfoTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.VendorInfoTestData.XML_REF_ID_RA;

public class VendorInfoConsumerTest extends BaseTest<VendorInfoType, VendorInfoCollectionType> {
    private ConsumerTest<VendorInfoType, VendorInfoCollectionType> vendorInfoTester = null;
    private VendorInfoTestData testData = new VendorInfoTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        vendorInfoTester = new ConsumerTest<>(VendorInfoType.class, "VendorInfo", VendorInfoCollectionType.class, "VendorInfos");
        vendorInfoTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<VendorInfoType, VendorInfoCollectionType> getTester() {
        return vendorInfoTester;
    }

    @Override
    public VendorInfoTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(VendorInfoType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(VendorInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(VendorInfoCollectionType::getVendorInfo).map(List::size).orElse(-1);
    }

    @Override
    public List<VendorInfoType> getCollectionList(VendorInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(VendorInfoCollectionType::getVendorInfo).orElse(new ArrayList<>());
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
