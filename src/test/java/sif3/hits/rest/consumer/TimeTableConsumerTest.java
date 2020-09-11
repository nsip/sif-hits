package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.TimeTableTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.TimeTableTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableType;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.TimeTableTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TimeTableConsumerTest extends BaseTest<TimeTableType, TimeTableCollectionType> {
	private ConsumerTest<TimeTableType, TimeTableCollectionType> timeTableTester = null;
	private TimeTableTestData testData = new TimeTableTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		timeTableTester = new ConsumerTest<>(TimeTableType.class, "TimeTable", TimeTableCollectionType.class,
				"TimeTables");
		timeTableTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<TimeTableType, TimeTableCollectionType> getTester() {
		return timeTableTester;
	}

	@Override
	public TimeTableTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(TimeTableType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(TimeTableType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(TimeTableCollectionType collection) {
		return Optional.ofNullable(collection).map(TimeTableCollectionType::getTimeTable).map(List::size).orElse(-1);
	}

	@Override
	public List<TimeTableType> getCollectionList(TimeTableCollectionType collection) {
		return Optional.ofNullable(collection).map(TimeTableCollectionType::getTimeTable).orElse(new ArrayList<>());
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
	public void testUpdateDays() {
		TimeTableType initialObject = getSingleObjectFromXML(
				timeTableTester.getFileContents(testData.getSingleObjectXMLFilename()));
		TimeTableType updatedObject = getSingleObjectFromXML(
				timeTableTester.getFileContents(testData.getSingleObjectXMLFilename()));
		updatedObject.getTimeTableDayList().getTimeTableDay().clear();
		testCreateUpdateDeleteSingle(initialObject, updatedObject);
		testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}

	@Test
	@Category(IntegrationTest.class)
	public void testDeleteFailsConstraint() {
		List<Response> responses = timeTableTester.testDeleteOne(TimeTableTestData.REF_ID_1);
		Assert.assertNotNull("Responses null", responses);
		Assert.assertEquals("Response size not 1", 1, responses.size());
		Response deleteResponse = responses.get(0);
		Assert.assertNull("Delete response null", deleteResponse.getDataObject());
		Assert.assertEquals("HTTP Status Response not 500", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				deleteResponse.getStatus());
		Assert.assertTrue("Error message not as expected",
				deleteResponse.getError().getMessage().contains("Cannot delete object because it has child objects"));
	}
}
