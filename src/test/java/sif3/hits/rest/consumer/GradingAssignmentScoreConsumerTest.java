package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.GradingAssignmentScoreTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.GradingAssignmentScoreTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.GradingAssignmentScoreCollectionType;
import sif.dd.au30.model.GradingAssignmentScoreType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.GradingAssignmentScoreTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class GradingAssignmentScoreConsumerTest
		extends BaseTest<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType> {
	private ConsumerTest<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType> gradingAssignmentScoreTester = null;
	private GradingAssignmentScoreTestData testData = new GradingAssignmentScoreTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		gradingAssignmentScoreTester = new ConsumerTest<>(GradingAssignmentScoreType.class, "GradingAssignmentScore",
				GradingAssignmentScoreCollectionType.class, "GradingAssignmentScores");
		gradingAssignmentScoreTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<GradingAssignmentScoreType, GradingAssignmentScoreCollectionType> getTester() {
		return gradingAssignmentScoreTester;
	}

	@Override
	public GradingAssignmentScoreTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(GradingAssignmentScoreType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(GradingAssignmentScoreType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<GradingAssignmentScoreType> getCollectionList(GradingAssignmentScoreCollectionType collection) {
		return Optional.ofNullable(collection).map(GradingAssignmentScoreCollectionType::getGradingAssignmentScore)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(GradingAssignmentScoreCollectionType collection) {
		return Optional.ofNullable(collection).map(GradingAssignmentScoreCollectionType::getGradingAssignmentScore)
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