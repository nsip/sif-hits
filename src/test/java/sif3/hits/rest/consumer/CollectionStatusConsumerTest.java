package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.CollectionStatusTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.CollectionStatusTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.CollectionStatusCollectionType;
import sif.dd.au30.model.CollectionStatusType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.CollectionStatusTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class CollectionStatusConsumerTest extends BaseTest<CollectionStatusType, CollectionStatusCollectionType> {
	private ConsumerTest<CollectionStatusType, CollectionStatusCollectionType> collectionStatusTester = null;
	private CollectionStatusTestData testData = new CollectionStatusTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		collectionStatusTester = new ConsumerTest<>(CollectionStatusType.class, "CollectionStatus",
				CollectionStatusCollectionType.class, "CollectionStatuss");
		collectionStatusTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<CollectionStatusType, CollectionStatusCollectionType> getTester() {
		return collectionStatusTester;
	}

	@Override
	public CollectionStatusTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(CollectionStatusType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(CollectionStatusType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(CollectionStatusCollectionType collection) {
		return Optional.ofNullable(collection).map(CollectionStatusCollectionType::getCollectionStatus).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<CollectionStatusType> getCollectionList(CollectionStatusCollectionType collection) {
		return Optional.ofNullable(collection).map(CollectionStatusCollectionType::getCollectionStatus)
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
