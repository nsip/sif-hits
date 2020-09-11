package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.FinancialAccountTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.FinancialAccountTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.FinancialAccountCollectionType;
import sif.dd.au30.model.FinancialAccountType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.FinancialAccountTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class FinancialAccountConsumerTest extends BaseTest<FinancialAccountType, FinancialAccountCollectionType> {
	private ConsumerTest<FinancialAccountType, FinancialAccountCollectionType> financialAccountTester = null;
	private FinancialAccountTestData testData = new FinancialAccountTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		financialAccountTester = new ConsumerTest<>(FinancialAccountType.class, "FinancialAccount",
				FinancialAccountCollectionType.class, "FinancialAccounts");
		financialAccountTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<FinancialAccountType, FinancialAccountCollectionType> getTester() {
		return financialAccountTester;
	}

	@Override
	public FinancialAccountTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(FinancialAccountType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(FinancialAccountType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<FinancialAccountType> getCollectionList(FinancialAccountCollectionType collection) {
		return Optional.ofNullable(collection).map(FinancialAccountCollectionType::getFinancialAccount)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(FinancialAccountCollectionType collection) {
		return Optional.ofNullable(collection).map(FinancialAccountCollectionType::getFinancialAccount).map(List::size)
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