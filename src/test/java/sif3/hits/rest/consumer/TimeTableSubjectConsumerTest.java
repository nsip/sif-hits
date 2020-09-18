package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.TimeTableSubjectTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.TimeTableSubjectTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.TimeTableSubjectTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableSubjectConsumerTest extends BaseTest<TimeTableSubjectType, TimeTableSubjectCollectionType> {
	private ConsumerTest<TimeTableSubjectType, TimeTableSubjectCollectionType> timeTableSubjectTester = null;
	private TimeTableSubjectTestData testData = new TimeTableSubjectTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		timeTableSubjectTester = new ConsumerTest<>(TimeTableSubjectType.class, "TimeTableSubject",
				TimeTableSubjectCollectionType.class, "TimeTableSubjects");
		timeTableSubjectTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<TimeTableSubjectType, TimeTableSubjectCollectionType> getTester() {
		return timeTableSubjectTester;
	}

	@Override
	public TimeTableSubjectTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(TimeTableSubjectType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(TimeTableSubjectType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(TimeTableSubjectCollectionType collection) {
		return Optional.ofNullable(collection).map(TimeTableSubjectCollectionType::getTimeTableSubject).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<TimeTableSubjectType> getCollectionList(TimeTableSubjectCollectionType collection) {
		return Optional.ofNullable(collection).map(TimeTableSubjectCollectionType::getTimeTableSubject)
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
		super.testFullUpdate(false);
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
	public void testUpdateCodes() {
		logTestName("testUpdateCodes");
		TimeTableSubjectType initialObject = getSingleObjectFromXML(
				timeTableSubjectTester.getFileContents(testData.getSingleObjectXMLFilename()));
		TimeTableSubjectType updatedObject = getSingleObjectFromXML(
				timeTableSubjectTester.getFileContents(testData.getSingleObjectXMLFilename()));
		updatedObject.setOtherCodeList(null);
		testCreateUpdateDeleteSingle(initialObject, updatedObject);
		testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}

}
