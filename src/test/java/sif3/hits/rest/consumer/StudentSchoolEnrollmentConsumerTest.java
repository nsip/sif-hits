package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentSchoolEnrollmentTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentSchoolEnrollmentTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StudentSchoolEnrollmentCollectionType;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentSchoolEnrollmentTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentSchoolEnrollmentConsumerTest
		extends BaseTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> {
	private ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> studentSchoolEnrollmentTester = null;
	private StudentSchoolEnrollmentTestData testData = new StudentSchoolEnrollmentTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentSchoolEnrollmentTester = new ConsumerTest<>(StudentSchoolEnrollmentType.class, "StudentSchoolEnrollment",
				StudentSchoolEnrollmentCollectionType.class, "StudentSchoolEnrollments");
		studentSchoolEnrollmentTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType> getTester() {
		return studentSchoolEnrollmentTester;
	}

	@Override
	public StudentSchoolEnrollmentTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentSchoolEnrollmentType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StudentSchoolEnrollmentType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StudentSchoolEnrollmentType> getCollectionList(StudentSchoolEnrollmentCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentSchoolEnrollmentCollectionType::getStudentSchoolEnrollment)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentSchoolEnrollmentCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentSchoolEnrollmentCollectionType::getStudentSchoolEnrollment)
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
