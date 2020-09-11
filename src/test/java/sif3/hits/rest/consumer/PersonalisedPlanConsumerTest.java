package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.PersonalisedPlanTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.PersonalisedPlanTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.PersonalisedPlanCollectionType;
import sif.dd.au30.model.PersonalisedPlanType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.PersonalisedPlanTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class PersonalisedPlanConsumerTest extends BaseTest<PersonalisedPlanType, PersonalisedPlanCollectionType> {
	private ConsumerTest<PersonalisedPlanType, PersonalisedPlanCollectionType> personalisedPlanTester = null;
	private PersonalisedPlanTestData testData = new PersonalisedPlanTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		personalisedPlanTester = new ConsumerTest<>(PersonalisedPlanType.class, "PersonalisedPlan",
				PersonalisedPlanCollectionType.class, "PersonalisedPlans");
		personalisedPlanTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<PersonalisedPlanType, PersonalisedPlanCollectionType> getTester() {
		return personalisedPlanTester;
	}

	@Override
	public PersonalisedPlanTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(PersonalisedPlanType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(PersonalisedPlanType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(PersonalisedPlanCollectionType collection) {
		return Optional.ofNullable(collection).map(PersonalisedPlanCollectionType::getPersonalisedPlan).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<PersonalisedPlanType> getCollectionList(PersonalisedPlanCollectionType collection) {
		return Optional.ofNullable(collection).map(PersonalisedPlanCollectionType::getPersonalisedPlan)
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
