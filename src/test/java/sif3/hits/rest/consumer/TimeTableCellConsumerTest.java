package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.TimeTableCellTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.TimeTableCellTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.TimeTableCellCollectionType;
import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.TimeTableCellTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableCellConsumerTest extends BaseTest<TimeTableCellType, TimeTableCellCollectionType> {
	private ConsumerTest<TimeTableCellType, TimeTableCellCollectionType> timeTableCellTester = null;
	private TimeTableCellTestData testData = new TimeTableCellTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		timeTableCellTester = new ConsumerTest<>(TimeTableCellType.class, "TimeTableCell",
				TimeTableCellCollectionType.class, "TimeTableCells");
		timeTableCellTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<TimeTableCellType, TimeTableCellCollectionType> getTester() {
		return timeTableCellTester;
	}

	@Override
	public TimeTableCellTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(TimeTableCellType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(TimeTableCellType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(TimeTableCellCollectionType collection) {
		return Optional.ofNullable(collection).map(TimeTableCellCollectionType::getTimeTableCell).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<TimeTableCellType> getCollectionList(TimeTableCellCollectionType collection) {
		return Optional.ofNullable(collection).map(TimeTableCellCollectionType::getTimeTableCell)
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
	public void testUpdateTeacherCover() {
		TimeTableCellType initialObject = getSingleObjectFromXML(
				timeTableCellTester.getFileContents(testData.getSingleObjectXMLFilename()));
		TimeTableCellType updatedObject = getSingleObjectFromXML(
				timeTableCellTester.getFileContents(testData.getSingleObjectXMLFilename()));
		updatedObject.setTeacherList(null);
		testCreateUpdateDeleteSingle(initialObject, updatedObject);
		testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}
}
