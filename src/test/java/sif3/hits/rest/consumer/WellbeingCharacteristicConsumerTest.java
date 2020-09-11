package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.WellbeingCharacteristicTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.WellbeingCharacteristicTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.WellbeingCharacteristicCollectionType;
import sif.dd.au30.model.WellbeingCharacteristicType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.WellbeingCharacteristicTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class WellbeingCharacteristicConsumerTest
		extends BaseTest<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType> {
	private ConsumerTest<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType> wellbeingCharacteristicTester = null;
	private WellbeingCharacteristicTestData testData = new WellbeingCharacteristicTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		wellbeingCharacteristicTester = new ConsumerTest<>(WellbeingCharacteristicType.class, "WellbeingCharacteristic",
				WellbeingCharacteristicCollectionType.class, "WellbeingCharacteristics");
		wellbeingCharacteristicTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType> getTester() {
		return wellbeingCharacteristicTester;
	}

	@Override
	public WellbeingCharacteristicTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(WellbeingCharacteristicType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(WellbeingCharacteristicType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(WellbeingCharacteristicCollectionType collection) {
		return Optional.ofNullable(collection).map(WellbeingCharacteristicCollectionType::getWellbeingCharacteristic)
				.map(List::size).orElse(-1);
	}

	@Override
	public List<WellbeingCharacteristicType> getCollectionList(WellbeingCharacteristicCollectionType collection) {
		return Optional.ofNullable(collection).map(WellbeingCharacteristicCollectionType::getWellbeingCharacteristic)
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
