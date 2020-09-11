package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.JournalTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.JournalTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.JournalCollectionType;
import sif.dd.au30.model.JournalType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.JournalTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class JournalConsumerTest extends BaseTest<JournalType, JournalCollectionType> {
	private ConsumerTest<JournalType, JournalCollectionType> journalTester = null;
	private JournalTestData testData = new JournalTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		journalTester = new ConsumerTest<>(JournalType.class, "Journal", JournalCollectionType.class, "Journals");
		journalTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<JournalType, JournalCollectionType> getTester() {
		return journalTester;
	}

	@Override
	public JournalTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(JournalType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(JournalType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<JournalType> getCollectionList(JournalCollectionType collection) {
		return Optional.ofNullable(collection).map(JournalCollectionType::getJournal).orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(JournalCollectionType collection) {
		return Optional.ofNullable(collection).map(JournalCollectionType::getJournal).map(List::size).orElse(-1);
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