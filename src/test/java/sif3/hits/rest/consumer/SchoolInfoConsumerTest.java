package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.SchoolInfoTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.SchoolInfoTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.SchoolInfoTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class SchoolInfoConsumerTest extends BaseTest<SchoolInfoType, SchoolInfoCollectionType> {
	private ConsumerTest<SchoolInfoType, SchoolInfoCollectionType> schoolInfoTester = null;
	private SchoolInfoTestData testData = new SchoolInfoTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		schoolInfoTester = new ConsumerTest<>(SchoolInfoType.class, "SchoolInfo", SchoolInfoCollectionType.class,
				"SchoolInfos");
		schoolInfoTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<SchoolInfoType, SchoolInfoCollectionType> getTester() {
		return schoolInfoTester;
	}

	@Override
	public SchoolInfoTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(SchoolInfoType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(SchoolInfoType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<SchoolInfoType> getCollectionList(SchoolInfoCollectionType collection) {
		return Optional.ofNullable(collection).map(SchoolInfoCollectionType::getSchoolInfo).orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(SchoolInfoCollectionType collection) {
		return Optional.ofNullable(collection).map(SchoolInfoCollectionType::getSchoolInfo).map(List::size).orElse(-1);
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
