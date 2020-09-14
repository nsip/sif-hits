package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.GradingAssignmentTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.GradingAssignmentTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.GradingAssignmentCollectionType;
import sif.dd.au30.model.GradingAssignmentType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.GradingAssignmentTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class GradingAssignmentConsumerTest extends BaseTest<GradingAssignmentType, GradingAssignmentCollectionType> {
	private ConsumerTest<GradingAssignmentType, GradingAssignmentCollectionType> gradingAssignmentTester = null;
	private GradingAssignmentTestData testData = new GradingAssignmentTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		gradingAssignmentTester = new ConsumerTest<>(GradingAssignmentType.class, "GradingAssignment",
				GradingAssignmentCollectionType.class, "GradingAssignments");
		gradingAssignmentTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<GradingAssignmentType, GradingAssignmentCollectionType> getTester() {
		return gradingAssignmentTester;
	}

	@Override
	public GradingAssignmentTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(GradingAssignmentType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(GradingAssignmentType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<GradingAssignmentType> getCollectionList(GradingAssignmentCollectionType collection) {
		return Optional.ofNullable(collection).map(GradingAssignmentCollectionType::getGradingAssignment)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(GradingAssignmentCollectionType collection) {
		return Optional.ofNullable(collection).map(GradingAssignmentCollectionType::getGradingAssignment)
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