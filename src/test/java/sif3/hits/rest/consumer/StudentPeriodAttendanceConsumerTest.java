package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentPeriodAttendanceTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentPeriodAttendanceTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StudentPeriodAttendanceCollectionType;
import sif.dd.au30.model.StudentPeriodAttendanceType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentPeriodAttendanceTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentPeriodAttendanceConsumerTest
		extends BaseTest<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType> {
	private ConsumerTest<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType> studentPeriodAttendanceTester = null;
	private StudentPeriodAttendanceTestData testData = new StudentPeriodAttendanceTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentPeriodAttendanceTester = new ConsumerTest<>(StudentPeriodAttendanceType.class, "StudentPeriodAttendance",
				StudentPeriodAttendanceCollectionType.class, "StudentPeriodAttendances");
		studentPeriodAttendanceTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType> getTester() {
		return studentPeriodAttendanceTester;
	}

	@Override
	public StudentPeriodAttendanceTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentPeriodAttendanceType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StudentPeriodAttendanceType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StudentPeriodAttendanceType> getCollectionList(StudentPeriodAttendanceCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentPeriodAttendanceCollectionType::getStudentPeriodAttendance)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentPeriodAttendanceCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentPeriodAttendanceCollectionType::getStudentPeriodAttendance)
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
