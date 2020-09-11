package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.CalendarDateTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.CalendarDateTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.CalendarDateCollectionType;
import sif.dd.au30.model.CalendarDateType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.CalendarDateTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CalendarDateConsumerTest extends BaseTest<CalendarDateType, CalendarDateCollectionType> {
	private ConsumerTest<CalendarDateType, CalendarDateCollectionType> calendarDateTester = null;
	private CalendarDateTestData testData = new CalendarDateTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		calendarDateTester = new ConsumerTest<>(CalendarDateType.class, "CalendarDate",
				CalendarDateCollectionType.class, "CalendarDates");
		calendarDateTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<CalendarDateType, CalendarDateCollectionType> getTester() {
		return calendarDateTester;
	}

	@Override
	public CalendarDateTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(CalendarDateType object) {
		return object.getCalendarDateRefId();
	}

	@Override
	public void setRefId(CalendarDateType object, String refId) {
		object.setCalendarDateRefId(refId);
	}

	@Override
	public int getCollectionSize(CalendarDateCollectionType collection) {
		return Optional.ofNullable(collection).map(CalendarDateCollectionType::getCalendarDate).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<CalendarDateType> getCollectionList(CalendarDateCollectionType collection) {
		return Optional.ofNullable(collection).map(CalendarDateCollectionType::getCalendarDate)
				.orElse(new ArrayList<>());
	}

	@Test
	@Category({ IntegrationTest.class, InitialiseData.class })
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
	public void testFullUpdate() {
		super.testFullUpdate();
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

	@Test
	@Category(IntegrationTest.class)
	public void testUpdateSingleOtherCodes() {
		CalendarDateType initialObject = getSingleObjectFromXML(
				calendarDateTester.getFileContents(testData.getSingleObjectXMLFilename()));
		CalendarDateType updatedObject = getSingleObjectFromXML(
				calendarDateTester.getFileContents(testData.getSingleObjectXMLFilename()));
		updatedObject.getCalendarDateType().setOtherCodeList(null);
		testCreateUpdateDeleteSingle(initialObject, updatedObject);
		testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}
}
