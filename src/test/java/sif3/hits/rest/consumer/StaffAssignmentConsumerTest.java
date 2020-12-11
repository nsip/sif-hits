package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StaffAssignmentTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StaffAssignmentTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.StaffAssignmentCollectionType;
import sif.dd.au30.model.StaffAssignmentType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StaffAssignmentTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StaffAssignmentConsumerTest extends BaseTest<StaffAssignmentType, StaffAssignmentCollectionType> {
	private ConsumerTest<StaffAssignmentType, StaffAssignmentCollectionType> staffAssignmentTester = null;
	private StaffAssignmentTestData testData = new StaffAssignmentTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		staffAssignmentTester = new ConsumerTest<>(StaffAssignmentType.class, "StaffAssignment",
				StaffAssignmentCollectionType.class, "StaffAssignments");
		staffAssignmentTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StaffAssignmentType, StaffAssignmentCollectionType> getTester() {
		return staffAssignmentTester;
	}

	@Override
	public StaffAssignmentTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StaffAssignmentType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StaffAssignmentType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StaffAssignmentType> getCollectionList(StaffAssignmentCollectionType collection) {
		return Optional.ofNullable(collection).map(StaffAssignmentCollectionType::getStaffAssignment)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StaffAssignmentCollectionType collection) {
		return Optional.ofNullable(collection).map(StaffAssignmentCollectionType::getStaffAssignment).map(List::size)
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
}