package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.CalendarSummaryCollectionType;
import sif.dd.au30.model.CalendarSummaryType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.CalendarSummaryTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.CalendarSummaryTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.CalendarSummaryTestData.XML_REF_ID_RA;

public class CalendarSummaryConsumerTest extends BaseTest<CalendarSummaryType, CalendarSummaryCollectionType> {
    private ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType> calendarSummaryTester = null;
    private CalendarSummaryTestData testData = new CalendarSummaryTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        calendarSummaryTester = new ConsumerTest<>(CalendarSummaryType.class, "CalendarSummary", CalendarSummaryCollectionType.class, "CalendarSummarys");
        calendarSummaryTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<CalendarSummaryType, CalendarSummaryCollectionType> getTester() {
        return calendarSummaryTester;
    }

    @Override
    public CalendarSummaryTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(CalendarSummaryType object) {
        return object.getRefId();
    }

    @Override
    public List<CalendarSummaryType> getCollectionList(CalendarSummaryCollectionType collection) {
        return Optional.ofNullable(collection).map(CalendarSummaryCollectionType::getCalendarSummary).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(CalendarSummaryCollectionType collection) {
        return Optional.ofNullable(collection).map(CalendarSummaryCollectionType::getCalendarSummary).map(List::size).orElse(-1);
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
    public void testUpdateSingleYearLevels() {
        CalendarSummaryType initialObject = getSingleObjectFromXML(calendarSummaryTester.getFileContents(testData.getSingleObjectXMLFilename()));
        CalendarSummaryType updatedObject = getSingleObjectFromXML(calendarSummaryTester.getFileContents(testData.getSingleObjectXMLFilename()));
        updatedObject.setYearLevels(null);
        testCreateUpdateDeleteSingle(initialObject, updatedObject);
        testCreateUpdateDeleteSingle(updatedObject, initialObject);
    }
}
