package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.TermInfoTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.TermInfoTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.TermInfoCollectionType;
import sif.dd.au30.model.TermInfoType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.TermInfoTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TermInfoConsumerTest extends BaseTest<TermInfoType, TermInfoCollectionType> {
	private ConsumerTest<TermInfoType, TermInfoCollectionType> termInfoTester = null;
	private TermInfoTestData testData = new TermInfoTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		termInfoTester = new ConsumerTest<>(TermInfoType.class, "TermInfo", TermInfoCollectionType.class, "TermInfos");
		termInfoTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<TermInfoType, TermInfoCollectionType> getTester() {
		return termInfoTester;
	}

	@Override
	public TermInfoTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(TermInfoType object) {
		return object.getRefId();
	}

	@Override
	public int getCollectionSize(TermInfoCollectionType collection) {
		return Optional.ofNullable(collection).map(TermInfoCollectionType::getTermInfo).map(List::size).orElse(-1);
	}

	@Override
	public List<TermInfoType> getCollectionList(TermInfoCollectionType collection) {
		return Optional.ofNullable(collection).map(TermInfoCollectionType::getTermInfo).orElse(new ArrayList<>());
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
	public void testQBES() {
		super.testQBES();
	}

	@Test
	@Category(IntegrationTest.class)
	public void testServicePaths() {
		super.testServicePaths();
	}
}
