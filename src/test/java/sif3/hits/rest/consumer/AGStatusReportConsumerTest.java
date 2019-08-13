package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.AGStatusReportCollectionType;
import sif.dd.au30.model.AGStatusReportType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.AGStatusReportTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.AGStatusReportTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.AGStatusReportTestData.XML_REF_ID_RA;

public class AGStatusReportConsumerTest extends BaseTest<AGStatusReportType, AGStatusReportCollectionType> {
    private ConsumerTest<AGStatusReportType, AGStatusReportCollectionType> agStatusReportTester = null;
    private AGStatusReportTestData testData = new AGStatusReportTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        agStatusReportTester = new ConsumerTest<>(AGStatusReportType.class, "AGStatusReport", AGStatusReportCollectionType.class, "AGStatusReports");
        agStatusReportTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<AGStatusReportType, AGStatusReportCollectionType> getTester() {
        return agStatusReportTester;
    }

    @Override
    public AGStatusReportTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(AGStatusReportType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(AGStatusReportCollectionType collection) {
        return Optional.ofNullable(collection).map(AGStatusReportCollectionType::getAGStatusReport).map(List::size).orElse(-1);
    }

    @Override
    public List<AGStatusReportType> getCollectionList(AGStatusReportCollectionType collection) {
        return Optional.ofNullable(collection).map(AGStatusReportCollectionType::getAGStatusReport).orElse(new ArrayList<>());
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
