package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StaffPersonalTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StaffPersonalTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.StaffPersonalCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StaffPersonalTestData;
import sif3.hits.rest.consumer.data.TestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StaffPersonalConsumerTest extends BaseTest<StaffPersonalType, StaffPersonalCollectionType> {
	private ConsumerTest<StaffPersonalType, StaffPersonalCollectionType> staffPersonalTester = null;
	private StaffPersonalTestData testData = new StaffPersonalTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		staffPersonalTester = new ConsumerTest<>(StaffPersonalType.class, "StaffPersonal",
				StaffPersonalCollectionType.class, "StaffPersonals");
		staffPersonalTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StaffPersonalType, StaffPersonalCollectionType> getTester() {
		return staffPersonalTester;
	}

	@Override
	public StaffPersonalTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StaffPersonalType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StaffPersonalType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StaffPersonalType> getCollectionList(StaffPersonalCollectionType collection) {
		return Optional.ofNullable(collection).map(StaffPersonalCollectionType::getStaffPersonal)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StaffPersonalCollectionType collection) {
		return Optional.ofNullable(collection).map(StaffPersonalCollectionType::getStaffPersonal).map(List::size)
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

	@Test
	@Category(IntegrationTest.class)
	public void testDoubleByteName() {
		StaffPersonalType initialObject = getSingleObjectFromXML(
				staffPersonalTester.getFileContents(testData.getSingleObjectXMLFilename()));
		StaffPersonalType updatedObject = getSingleObjectFromXML(
				staffPersonalTester.getFileContents(testData.getSingleObjectXMLFilename()));
		PersonInfoType personInfo = updatedObject.getPersonInfo();
		personInfo.setName(TestData.getNameOfRecord("Mr", "Jöerg", "Test", "Hüber"));
		testCreateUpdateDeleteSingle(initialObject, updatedObject);
		testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}
}
