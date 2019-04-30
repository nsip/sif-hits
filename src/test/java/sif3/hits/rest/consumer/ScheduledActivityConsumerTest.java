package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.ScheduledActivityCollectionType;
import sif.dd.au30.model.ScheduledActivityType;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.ScheduledActivityTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.ScheduledActivityTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.ScheduledActivityTestData.XML_REF_ID_RA;

public class ScheduledActivityConsumerTest extends BaseTest<ScheduledActivityType, ScheduledActivityCollectionType> {
    private ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType> scheduledActivityTester = null;
    private ScheduledActivityTestData testData = new ScheduledActivityTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        scheduledActivityTester = new ConsumerTest<>(ScheduledActivityType.class, "ScheduledActivity", ScheduledActivityCollectionType.class, "ScheduledActivitys");
        scheduledActivityTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<ScheduledActivityType, ScheduledActivityCollectionType> getTester() {
        return scheduledActivityTester;
    }

    @Override
    public ScheduledActivityTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(ScheduledActivityType object) {
        return object.getRefId();
    }

    @Override
    public List<ScheduledActivityType> getCollectionList(ScheduledActivityCollectionType collection) {
        return Optional.ofNullable(collection).map(ScheduledActivityCollectionType::getScheduledActivity).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(ScheduledActivityCollectionType collection) {
        return Optional.ofNullable(collection).map(ScheduledActivityCollectionType::getScheduledActivity).map(List::size).orElse(-1);
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

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateTeachers() throws UnmarshalException, UnsupportedMediaTypeExcpetion, MarshalException {
        ScheduledActivityType initialObject = getSingleObjectFromXML(scheduledActivityTester.getFileContents(testData.getSingleObjectXMLFilename()));
        ScheduledActivityType updatedObject = getSingleObjectFromXML(scheduledActivityTester.getFileContents(testData.getSingleObjectXMLFilename()));
        updatedObject.setTeacherList(null);
        testCreateUpdateDeleteSingle(initialObject, updatedObject);
        testCreateUpdateDeleteSingle(updatedObject, initialObject);
    }
}