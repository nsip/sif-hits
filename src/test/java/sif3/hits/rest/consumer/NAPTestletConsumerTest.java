package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.NAPTestletTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.NAPTestletTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.NAPTestletCollectionType;
import sif.dd.au30.model.NAPTestletType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.NAPTestletTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPTestletConsumerTest extends BaseTest<NAPTestletType, NAPTestletCollectionType> {
	private ConsumerTest<NAPTestletType, NAPTestletCollectionType> nAPTestletTester = null;
	private NAPTestletTestData testData = new NAPTestletTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		nAPTestletTester = new ConsumerTest<>(NAPTestletType.class, "NAPTestlet", NAPTestletCollectionType.class,
				"NAPTestlets");
		nAPTestletTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<NAPTestletType, NAPTestletCollectionType> getTester() {
		return nAPTestletTester;
	}

	@Override
	public NAPTestletTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(NAPTestletType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(NAPTestletType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<NAPTestletType> getCollectionList(NAPTestletCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPTestletCollectionType::getNAPTestlet).orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(NAPTestletCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPTestletCollectionType::getNAPTestlet).map(List::size).orElse(-1);
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