package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentContactPersonalTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentContactPersonalTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StudentContactPersonalCollectionType;
import sif.dd.au30.model.StudentContactPersonalType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentContactPersonalTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentContactPersonalConsumerTest
		extends BaseTest<StudentContactPersonalType, StudentContactPersonalCollectionType> {
	private ConsumerTest<StudentContactPersonalType, StudentContactPersonalCollectionType> studentContactPersonalTester = null;
	private StudentContactPersonalTestData testData = new StudentContactPersonalTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentContactPersonalTester = new ConsumerTest<>(StudentContactPersonalType.class, "StudentContactPersonal",
				StudentContactPersonalCollectionType.class, "StudentContactPersonals");
		studentContactPersonalTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentContactPersonalType, StudentContactPersonalCollectionType> getTester() {
		return studentContactPersonalTester;
	}

	@Override
	public StudentContactPersonalTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentContactPersonalType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StudentContactPersonalType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StudentContactPersonalType> getCollectionList(StudentContactPersonalCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentContactPersonalCollectionType::getStudentContactPersonal)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentContactPersonalCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentContactPersonalCollectionType::getStudentContactPersonal)
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
