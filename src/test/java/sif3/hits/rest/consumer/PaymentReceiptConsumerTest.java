package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.PaymentReceiptTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.PaymentReceiptTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.PaymentReceiptCollectionType;
import sif.dd.au30.model.PaymentReceiptType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.PaymentReceiptTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class PaymentReceiptConsumerTest extends BaseTest<PaymentReceiptType, PaymentReceiptCollectionType> {
	private ConsumerTest<PaymentReceiptType, PaymentReceiptCollectionType> paymentReceiptTester = null;
	private PaymentReceiptTestData testData = new PaymentReceiptTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		paymentReceiptTester = new ConsumerTest<>(PaymentReceiptType.class, "PaymentReceipt",
				PaymentReceiptCollectionType.class, "PaymentReceipts");
		paymentReceiptTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<PaymentReceiptType, PaymentReceiptCollectionType> getTester() {
		return paymentReceiptTester;
	}

	@Override
	public PaymentReceiptTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(PaymentReceiptType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(PaymentReceiptType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public int getCollectionSize(PaymentReceiptCollectionType collection) {
		return Optional.ofNullable(collection).map(PaymentReceiptCollectionType::getPaymentReceipt).map(List::size)
				.orElse(-1);
	}

	@Override
	public List<PaymentReceiptType> getCollectionList(PaymentReceiptCollectionType collection) {
		return Optional.ofNullable(collection).map(PaymentReceiptCollectionType::getPaymentReceipt)
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
