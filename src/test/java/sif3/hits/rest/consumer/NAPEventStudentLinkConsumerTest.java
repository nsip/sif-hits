package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.NAPEventStudentLinkTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.NAPEventStudentLinkTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.NAPEventStudentLinkTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPEventStudentLinkConsumerTest
		extends BaseTest<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> {
	private ConsumerTest<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> napEventStudentLinkTester = null;
	private NAPEventStudentLinkTestData testData = new NAPEventStudentLinkTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		napEventStudentLinkTester = new ConsumerTest<>(NAPEventStudentLinkType.class, "NAPEventStudentLink",
				NAPEventStudentLinkCollectionType.class, "NAPEventStudentLinks");
		napEventStudentLinkTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType> getTester() {
		return napEventStudentLinkTester;
	}

	@Override
	public NAPEventStudentLinkTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(NAPEventStudentLinkType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(NAPEventStudentLinkType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<NAPEventStudentLinkType> getCollectionList(NAPEventStudentLinkCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPEventStudentLinkCollectionType::getNAPEventStudentLink)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(NAPEventStudentLinkCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPEventStudentLinkCollectionType::getNAPEventStudentLink)
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