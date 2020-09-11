package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.CensusCollectionTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.CensusCollectionTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.CensusCollectionCollectionType;
import sif.dd.au30.model.CensusCollectionType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.CensusCollectionTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CensusCollectionConsumerTest extends BaseTest<CensusCollectionType, CensusCollectionCollectionType> {
	private ConsumerTest<CensusCollectionType, CensusCollectionCollectionType> censusCollectionTester = null;
	private CensusCollectionTestData testData = new CensusCollectionTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		censusCollectionTester = new ConsumerTest<>(CensusCollectionType.class, "CensusCollection",
				CensusCollectionCollectionType.class, "CensusCollections");
		censusCollectionTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<CensusCollectionType, CensusCollectionCollectionType> getTester() {
		return censusCollectionTester;
	}

	@Override
	public CensusCollectionTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(CensusCollectionType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(CensusCollectionType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(CensusCollectionCollectionType collection) {
		return Optional.ofNullable(collection).map(CensusCollectionCollectionType::getCensusCollection).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<CensusCollectionType> getCollectionList(CensusCollectionCollectionType collection) {
		return Optional.ofNullable(collection).map(CensusCollectionCollectionType::getCensusCollection)
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
