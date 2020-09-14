package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentContactRelationshipTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentContactRelationshipTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StudentContactRelationshipCollectionType;
import sif.dd.au30.model.StudentContactRelationshipType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentContactRelationshipTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentContactRelationshipConsumerTest
		extends BaseTest<StudentContactRelationshipType, StudentContactRelationshipCollectionType> {
	private ConsumerTest<StudentContactRelationshipType, StudentContactRelationshipCollectionType> studentContactRelationshipTester = null;
	private StudentContactRelationshipTestData testData = new StudentContactRelationshipTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentContactRelationshipTester = new ConsumerTest<>(StudentContactRelationshipType.class,
				"StudentContactRelationship", StudentContactRelationshipCollectionType.class,
				"StudentContactRelationships");
		studentContactRelationshipTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentContactRelationshipType, StudentContactRelationshipCollectionType> getTester() {
		return studentContactRelationshipTester;
	}

	@Override
	public StudentContactRelationshipTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentContactRelationshipType object) {
		return object.getStudentContactRelationshipRefId();
	}

	@Override
	public void setRefId(StudentContactRelationshipType object, String refId) {
		object.setStudentContactRelationshipRefId(refId);
	}

	@Override
	public List<StudentContactRelationshipType> getCollectionList(StudentContactRelationshipCollectionType collection) {
		return Optional.ofNullable(collection)
				.map(StudentContactRelationshipCollectionType::getStudentContactRelationship).orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentContactRelationshipCollectionType collection) {
		return Optional.ofNullable(collection)
				.map(StudentContactRelationshipCollectionType::getStudentContactRelationship).map(List::size)
				.orElse(-1);
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
