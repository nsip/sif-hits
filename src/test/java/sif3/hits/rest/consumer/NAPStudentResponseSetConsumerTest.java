package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.NAPStudentResponseSetTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.NAPStudentResponseSetTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.NAPStudentResponseSetTestData.XML_REF_ID_RA;

public class NAPStudentResponseSetConsumerTest extends BaseTest<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> {
    private ConsumerTest<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> nAPStudentResponseSetTester = null;
    private NAPStudentResponseSetTestData testData = new NAPStudentResponseSetTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        nAPStudentResponseSetTester = new ConsumerTest<>(NAPStudentResponseSetType.class, "NAPStudentResponseSet", NAPStudentResponseSetCollectionType.class, "NAPStudentResponseSets");
        nAPStudentResponseSetTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType> getTester() {
        return nAPStudentResponseSetTester;
    }

    @Override
    public NAPStudentResponseSetTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(NAPStudentResponseSetType object) {
        return object.getRefId();
    }

    @Override
    public List<NAPStudentResponseSetType> getCollectionList(NAPStudentResponseSetCollectionType collection) {
        return Optional.ofNullable(collection).map(NAPStudentResponseSetCollectionType::getNAPStudentResponseSet).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(NAPStudentResponseSetCollectionType collection) {
        return Optional.ofNullable(collection).map(NAPStudentResponseSetCollectionType::getNAPStudentResponseSet).map(List::size).orElse(-1);
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