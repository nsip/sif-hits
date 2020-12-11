package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentAttendanceSummaryTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentAttendanceSummaryTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StudentAttendanceSummaryCollectionType;
import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentAttendanceSummaryTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentAttendanceSummaryConsumerTest
		extends BaseTest<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType> {
	private ConsumerTest<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType> studentAttendanceSummaryTester = null;
	private StudentAttendanceSummaryTestData testData = new StudentAttendanceSummaryTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentAttendanceSummaryTester = new ConsumerTest<>(StudentAttendanceSummaryType.class,
				"StudentAttendanceSummary", StudentAttendanceSummaryCollectionType.class, "StudentAttendanceSummarys");
		studentAttendanceSummaryTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType> getTester() {
		return studentAttendanceSummaryTester;
	}

	@Override
	public StudentAttendanceSummaryTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentAttendanceSummaryType object) {
		return object.getStudentAttendanceSummaryRefId();
	}

	@Override
	public void setRefId(StudentAttendanceSummaryType object, String refId) {
		object.setStudentAttendanceSummaryRefId(refId);
	}

	@Override
	public List<StudentAttendanceSummaryType> getCollectionList(StudentAttendanceSummaryCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentAttendanceSummaryCollectionType::getStudentAttendanceSummary)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentAttendanceSummaryCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentAttendanceSummaryCollectionType::getStudentAttendanceSummary)
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
