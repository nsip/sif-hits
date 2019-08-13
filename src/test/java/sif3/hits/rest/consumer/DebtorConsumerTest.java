package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.DebtorCollectionType;
import sif.dd.au30.model.DebtorType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.DebtorTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.DebtorTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.DebtorTestData.XML_REF_ID_RA;

public class DebtorConsumerTest extends BaseTest<DebtorType, DebtorCollectionType> {
    private ConsumerTest<DebtorType, DebtorCollectionType> debtorTester = null;
    private DebtorTestData testData = new DebtorTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        debtorTester = new ConsumerTest<>(DebtorType.class, "Debtor", DebtorCollectionType.class, "Debtors");
        debtorTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<DebtorType, DebtorCollectionType> getTester() {
        return debtorTester;
    }

    @Override
    public DebtorTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(DebtorType object) {
        return object.getRefId();
    }

    @Override
    public List<DebtorType> getCollectionList(DebtorCollectionType collection) {
        return Optional.ofNullable(collection).map(DebtorCollectionType::getDebtor).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(DebtorCollectionType collection) {
        return Optional.ofNullable(collection).map(DebtorCollectionType::getDebtor).map(List::size).orElse(-1);
    }

    @Test
    @Category({IntegrationTest.class, InitialiseData.class})
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
