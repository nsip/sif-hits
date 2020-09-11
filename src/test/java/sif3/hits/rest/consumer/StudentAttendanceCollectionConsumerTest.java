package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentAttendanceCollectionTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentAttendanceCollectionTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StudentAttendanceCollectionCollectionType;
import sif.dd.au30.model.StudentAttendanceCollectionType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentAttendanceCollectionTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentAttendanceCollectionConsumerTest
		extends BaseTest<StudentAttendanceCollectionType, StudentAttendanceCollectionCollectionType> {
	private ConsumerTest<StudentAttendanceCollectionType, StudentAttendanceCollectionCollectionType> studentAttendanceCollectionTester = null;
	private StudentAttendanceCollectionTestData testData = new StudentAttendanceCollectionTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentAttendanceCollectionTester = new ConsumerTest<>(StudentAttendanceCollectionType.class,
				"StudentAttendanceCollection", StudentAttendanceCollectionCollectionType.class,
				"StudentAttendanceCollections");
		studentAttendanceCollectionTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentAttendanceCollectionType, StudentAttendanceCollectionCollectionType> getTester() {
		return studentAttendanceCollectionTester;
	}

	@Override
	public StudentAttendanceCollectionTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentAttendanceCollectionType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StudentAttendanceCollectionType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(StudentAttendanceCollectionCollectionType collection) {
		return Optional.ofNullable(collection)
				.map(StudentAttendanceCollectionCollectionType::getStudentAttendanceCollection).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<StudentAttendanceCollectionType> getCollectionList(
			StudentAttendanceCollectionCollectionType collection) {
		return Optional.ofNullable(collection)
				.map(StudentAttendanceCollectionCollectionType::getStudentAttendanceCollection)
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

}
