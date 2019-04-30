package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.InvoiceCollectionType;
import sif.dd.au30.model.InvoiceType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.InvoiceTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.InvoiceTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.InvoiceTestData.XML_REF_ID_RA;

public class InvoiceConsumerTest extends BaseTest<InvoiceType, InvoiceCollectionType> {
    private ConsumerTest<InvoiceType, InvoiceCollectionType> invoiceTester = null;
    private InvoiceTestData testData = new InvoiceTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        invoiceTester = new ConsumerTest<>(InvoiceType.class, "Invoice", InvoiceCollectionType.class, "Invoices");
        invoiceTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<InvoiceType, InvoiceCollectionType> getTester() {
        return invoiceTester;
    }

    @Override
    public InvoiceTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(InvoiceType object) {
        return object.getRefId();
    }

    @Override
    public List<InvoiceType> getCollectionList(InvoiceCollectionType collection) {
        return Optional.ofNullable(collection).map(InvoiceCollectionType::getInvoice).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(InvoiceCollectionType collection) {
        return Optional.ofNullable(collection).map(InvoiceCollectionType::getInvoice).map(List::size).orElse(-1);
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
