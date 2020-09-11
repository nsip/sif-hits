package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.SchoolCourseInfoTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.SchoolCourseInfoTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.SchoolCourseInfoCollectionType;
import sif.dd.au30.model.SchoolCourseInfoType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.SchoolCourseInfoTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class SchoolCourseInfoConsumerTest extends BaseTest<SchoolCourseInfoType, SchoolCourseInfoCollectionType> {
	private ConsumerTest<SchoolCourseInfoType, SchoolCourseInfoCollectionType> schoolCourseInfoTester = null;
	private SchoolCourseInfoTestData testData = new SchoolCourseInfoTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		schoolCourseInfoTester = new ConsumerTest<>(SchoolCourseInfoType.class, "SchoolCourseInfo",
				SchoolCourseInfoCollectionType.class, "SchoolCourseInfos");
		schoolCourseInfoTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<SchoolCourseInfoType, SchoolCourseInfoCollectionType> getTester() {
		return schoolCourseInfoTester;
	}

	@Override
	public SchoolCourseInfoTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(SchoolCourseInfoType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(SchoolCourseInfoType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<SchoolCourseInfoType> getCollectionList(SchoolCourseInfoCollectionType collection) {
		return Optional.ofNullable(collection).map(SchoolCourseInfoCollectionType::getSchoolCourseInfo)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(SchoolCourseInfoCollectionType collection) {
		return Optional.ofNullable(collection).map(SchoolCourseInfoCollectionType::getSchoolCourseInfo).map(List::size)
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
