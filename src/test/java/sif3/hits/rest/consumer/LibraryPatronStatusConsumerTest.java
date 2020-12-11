package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.LibraryPatronStatusTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.LibraryPatronStatusTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.LibraryPatronStatusCollectionType;
import sif.dd.au30.model.LibraryPatronStatusType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.LibraryPatronStatusTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class LibraryPatronStatusConsumerTest
		extends BaseTest<LibraryPatronStatusType, LibraryPatronStatusCollectionType> {
	private ConsumerTest<LibraryPatronStatusType, LibraryPatronStatusCollectionType> libraryPatronStatusTester = null;
	private LibraryPatronStatusTestData testData = new LibraryPatronStatusTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		libraryPatronStatusTester = new ConsumerTest<>(LibraryPatronStatusType.class, "LibraryPatronStatus",
				LibraryPatronStatusCollectionType.class, "LibraryPatronStatuss");
		libraryPatronStatusTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<LibraryPatronStatusType, LibraryPatronStatusCollectionType> getTester() {
		return libraryPatronStatusTester;
	}

	@Override
	public LibraryPatronStatusTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(LibraryPatronStatusType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(LibraryPatronStatusType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(LibraryPatronStatusCollectionType collection) {
		return Optional.ofNullable(collection).map(LibraryPatronStatusCollectionType::getLibraryPatronStatus)
				.map(List::size).orElse(-1);
	}

	@Override
	public List<LibraryPatronStatusType> getCollectionList(LibraryPatronStatusCollectionType collection) {
		return Optional.ofNullable(collection).map(LibraryPatronStatusCollectionType::getLibraryPatronStatus)
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
