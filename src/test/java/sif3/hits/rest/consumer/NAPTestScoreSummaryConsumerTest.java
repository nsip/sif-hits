package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.NAPTestScoreSummaryCollectionType;
import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.NAPTestScoreSummaryTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.NAPTestScoreSummaryTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.NAPTestScoreSummaryTestData.XML_REF_ID_RA;

public class NAPTestScoreSummaryConsumerTest extends BaseTest<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> {
    private ConsumerTest<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> napTestScoreSummaryTester = null;
    private NAPTestScoreSummaryTestData testData = new NAPTestScoreSummaryTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        napTestScoreSummaryTester = new ConsumerTest<>(NAPTestScoreSummaryType.class, "NAPTestScoreSummary", NAPTestScoreSummaryCollectionType.class, "NAPTestScoreSummarys");
        napTestScoreSummaryTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<NAPTestScoreSummaryType, NAPTestScoreSummaryCollectionType> getTester() {
        return napTestScoreSummaryTester;
    }

    @Override
    public NAPTestScoreSummaryTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(NAPTestScoreSummaryType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(NAPTestScoreSummaryCollectionType collection) {
        return Optional.ofNullable(collection).map(NAPTestScoreSummaryCollectionType::getNAPTestScoreSummary).map(List::size).orElse(-1);
    }

    @Override
    public List<NAPTestScoreSummaryType> getCollectionList(NAPTestScoreSummaryCollectionType collection) {
        return Optional.ofNullable(collection).map(NAPTestScoreSummaryCollectionType::getNAPTestScoreSummary).orElse(new ArrayList<>());
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
