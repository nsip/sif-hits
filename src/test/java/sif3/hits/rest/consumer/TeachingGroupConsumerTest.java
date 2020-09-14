package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.TeachingGroupTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.TeachingGroupTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.TeachingGroupTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class TeachingGroupConsumerTest extends BaseTest<TeachingGroupType, TeachingGroupCollectionType> {
	private ConsumerTest<TeachingGroupType, TeachingGroupCollectionType> teachingGroupTester = null;
	private TeachingGroupTestData testData = new TeachingGroupTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		teachingGroupTester = new ConsumerTest<>(TeachingGroupType.class, "TeachingGroup",
				TeachingGroupCollectionType.class, "TeachingGroups");
		teachingGroupTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<TeachingGroupType, TeachingGroupCollectionType> getTester() {
		return teachingGroupTester;
	}

	@Override
	public TeachingGroupTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(TeachingGroupType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(TeachingGroupType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<TeachingGroupType> getCollectionList(TeachingGroupCollectionType collection) {
		return Optional.ofNullable(collection).map(TeachingGroupCollectionType::getTeachingGroup)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(TeachingGroupCollectionType collection) {
		return Optional.ofNullable(collection).map(TeachingGroupCollectionType::getTeachingGroup).map(List::size)
				.orElse(-1);
	}

	@Test
	@Category({ InitialiseData.class })
	public void initialInitialiseData() {
		// Teaching groups are special because of circular dependency with TimeTableCell
		for (String refId : TeachingGroupTestData.REF_ID_LIST) {
			TeachingGroupType singleObject = testData.getTestObject(refId);
			teachingGroupTester.doCreateOne(singleObject);
			teachingGroupTester.doUpdateOne(singleObject, getRefId(singleObject));
		}
	}

	@Test
	@Category(IntegrationTest.class)
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
		super.testFullUpdate(false);
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
	public void testUpdateTeachers() {
		TeachingGroupType initialObject = getSingleObjectFromXML(
				teachingGroupTester.getFileContents(testData.getSingleObjectXMLFilename()));
		TeachingGroupType updatedObject = getSingleObjectFromXML(
				teachingGroupTester.getFileContents(testData.getSingleObjectXMLFilename()));
		updatedObject.setTeacherList(null);
		testCreateUpdateDeleteSingle(initialObject, updatedObject);
		testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}

	@Test
	@Category(IntegrationTest.class)
	public void testUpdateStudents() {
		TeachingGroupType initialObject = getSingleObjectFromXML(
				teachingGroupTester.getFileContents(testData.getSingleObjectXMLFilename()));
		TeachingGroupType updatedObject = getSingleObjectFromXML(
				teachingGroupTester.getFileContents(testData.getSingleObjectXMLFilename()));
		updatedObject.setStudentList(null);
		testCreateUpdateDeleteSingle(initialObject, updatedObject);
		testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}

	@Test
	@Category(IntegrationTest.class)
	public void testUpdatePeriods() {
//        TeachingGroupType initialObject = testData.getTestObject(TeachingGroupTestData.PU_REF_ID_1);
//        TeachingGroupType updatedObject = testData.getTestObject(TeachingGroupTestData.PU_REF_ID_1);
//        updatedObject.setTeachingGroupPeriodList(null);
//        getTester().testDeleteOne(TeachingGroupTestData.PU_REF_ID_1);
//        testCreateUpdateDeleteSingle(initialObject, updatedObject);
//        testCreateUpdateDeleteSingle(updatedObject, initialObject);
	}
}
