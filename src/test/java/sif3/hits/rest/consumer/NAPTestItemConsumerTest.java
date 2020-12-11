package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.NAPTestItemTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.NAPTestItemTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.NAPTestItemCollectionType;
import sif.dd.au30.model.NAPTestItemType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.NAPTestItemTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPTestItemConsumerTest extends BaseTest<NAPTestItemType, NAPTestItemCollectionType> {
	private ConsumerTest<NAPTestItemType, NAPTestItemCollectionType> nAPTestItemTester = null;
	private NAPTestItemTestData testData = new NAPTestItemTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		nAPTestItemTester = new ConsumerTest<>(NAPTestItemType.class, "NAPTestItem", NAPTestItemCollectionType.class,
				"NAPTestItems");
		nAPTestItemTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<NAPTestItemType, NAPTestItemCollectionType> getTester() {
		return nAPTestItemTester;
	}

	@Override
	public NAPTestItemTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(NAPTestItemType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(NAPTestItemType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<NAPTestItemType> getCollectionList(NAPTestItemCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPTestItemCollectionType::getNAPTestItem).orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(NAPTestItemCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPTestItemCollectionType::getNAPTestItem).map(List::size)
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