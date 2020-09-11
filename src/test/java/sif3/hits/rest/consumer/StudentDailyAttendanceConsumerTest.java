package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentDailyAttendanceTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentDailyAttendanceTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StudentDailyAttendanceCollectionType;
import sif.dd.au30.model.StudentDailyAttendanceType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentDailyAttendanceTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentDailyAttendanceConsumerTest
		extends BaseTest<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType> {
	private ConsumerTest<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType> studentDailyAttendanceTester = null;
	private StudentDailyAttendanceTestData testData = new StudentDailyAttendanceTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentDailyAttendanceTester = new ConsumerTest<>(StudentDailyAttendanceType.class, "StudentDailyAttendance",
				StudentDailyAttendanceCollectionType.class, "StudentDailyAttendances");
		studentDailyAttendanceTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType> getTester() {
		return studentDailyAttendanceTester;
	}

	@Override
	public StudentDailyAttendanceTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentDailyAttendanceType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StudentDailyAttendanceType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StudentDailyAttendanceType> getCollectionList(StudentDailyAttendanceCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentDailyAttendanceCollectionType::getStudentDailyAttendance)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentDailyAttendanceCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentDailyAttendanceCollectionType::getStudentDailyAttendance)
				.map(List::size).orElse(-1);
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
}
