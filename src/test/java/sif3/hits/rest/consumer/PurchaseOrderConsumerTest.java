package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.PurchaseOrderCollectionType;
import sif.dd.au30.model.PurchaseOrderType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.PurchaseOrderTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.PurchaseOrderTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.PurchaseOrderTestData.XML_REF_ID_RA;

public class PurchaseOrderConsumerTest extends BaseTest<PurchaseOrderType, PurchaseOrderCollectionType> {
    private ConsumerTest<PurchaseOrderType, PurchaseOrderCollectionType> purchaseOrderTester = null;
    private PurchaseOrderTestData testData = new PurchaseOrderTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        purchaseOrderTester = new ConsumerTest<>(PurchaseOrderType.class, "PurchaseOrder", PurchaseOrderCollectionType.class, "PurchaseOrders");
        purchaseOrderTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<PurchaseOrderType, PurchaseOrderCollectionType> getTester() {
        return purchaseOrderTester;
    }

    @Override
    public PurchaseOrderTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(PurchaseOrderType object) {
        return object.getRefId();
    }

    @Override
    public List<PurchaseOrderType> getCollectionList(PurchaseOrderCollectionType collection) {
        return Optional.ofNullable(collection).map(PurchaseOrderCollectionType::getPurchaseOrder).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(PurchaseOrderCollectionType collection) {
        return Optional.ofNullable(collection).map(PurchaseOrderCollectionType::getPurchaseOrder).map(List::size).orElse(-1);
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
