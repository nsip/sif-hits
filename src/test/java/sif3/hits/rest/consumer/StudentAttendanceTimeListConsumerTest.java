package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentAttendanceTimeListTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentAttendanceTimeListTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.StudentAttendanceTimeListCollectionType;
import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentAttendanceTimeListTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentAttendanceTimeListConsumerTest
		extends BaseTest<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType> {
	private ConsumerTest<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType> studentAttendanceTimeListTester = null;
	private StudentAttendanceTimeListTestData testData = new StudentAttendanceTimeListTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentAttendanceTimeListTester = new ConsumerTest<>(StudentAttendanceTimeListType.class,
				"StudentAttendanceTimeList", StudentAttendanceTimeListCollectionType.class,
				"StudentAttendanceTimeLists");
		studentAttendanceTimeListTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType> getTester() {
		return studentAttendanceTimeListTester;
	}

	@Override
	public StudentAttendanceTimeListTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentAttendanceTimeListType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StudentAttendanceTimeListType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StudentAttendanceTimeListType> getCollectionList(StudentAttendanceTimeListCollectionType collection) {
		return Optional.ofNullable(collection)
				.map(StudentAttendanceTimeListCollectionType::getStudentAttendanceTimeList).orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentAttendanceTimeListCollectionType collection) {
		return Optional.ofNullable(collection)
				.map(StudentAttendanceTimeListCollectionType::getStudentAttendanceTimeList).map(List::size).orElse(-1);
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
	public void testCreateConstraintError() {
		List<Response> responses = studentAttendanceTimeListTester
				.testGetSingle(StudentAttendanceTimeListTestData.REF_ID_1);
		StudentAttendanceTimeListType studentAttendanceTimeList = getSingleObject(responses);
		Assert.assertEquals(StudentAttendanceTimeListTestData.REF_ID_1, studentAttendanceTimeList.getRefId());

		studentAttendanceTimeList.setRefId(testData.getRefId(20));
		studentAttendanceTimeList.setStudentPersonalRefId("xxx");
		responses = studentAttendanceTimeListTester.doCreateOne(studentAttendanceTimeList);
		Assert.assertNotNull("Responses null", responses);
		Assert.assertEquals("Responses size not 1", 1, responses.size());
		Response createResponse = responses.get(0);
		Assert.assertNull("Create response not null", createResponse.getDataObject());
		Assert.assertEquals("No Error 500 received", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				createResponse.getStatus());
		Assert.assertTrue("Message different from expected", createResponse.getError().getMessage()
				.contains("Cannot create object because we are unable to find referenced child objects"));
	}

	@Test
	@Category(IntegrationTest.class)
	public void testUpdateConstraintError() throws Exception {
		StudentAttendanceTimeListType initialObject = getSingleObjectFromXML(
				studentAttendanceTimeListTester.getFileContents(testData.getSingleObjectXMLFilename()));
		List<Response> createResponse = studentAttendanceTimeListTester.doCreateOne(initialObject);
		StudentAttendanceTimeListType createdObject = getSingleObject(createResponse);
		createdObject.setStudentPersonalRefId("xxx");

		List<Response> responses = studentAttendanceTimeListTester.doUpdateOne(createdObject, createdObject.getRefId());
		Assert.assertNotNull("Responses null", responses);
		Assert.assertEquals("Responses size not 1", 1, responses.size());
		Response updateResponse = responses.get(0);
		Assert.assertNull("Update response not null", updateResponse.getDataObject());
		Assert.assertEquals("No Error 500 received", HttpStatus.INTERNAL_SERVER_ERROR.value(),
				updateResponse.getStatus());
		Assert.assertTrue("Message different from expected", updateResponse.getError().getMessage()
				.contains("Cannot update object because we are unable to find referenced child objects"));
	}
}
