package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.FinancialQuestionnaireCollectionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireCollectionType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.FinancialQuestionnaireCollectionTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.FinancialQuestionnaireCollectionTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.FinancialQuestionnaireCollectionTestData.XML_REF_ID_RA;

public class FinancialQuestionnaireCollectionConsumerTest extends BaseTest<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollectionCollectionType> {
    private ConsumerTest<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollectionCollectionType> financialQuestionnaireTester = null;
    private FinancialQuestionnaireCollectionTestData testData = new FinancialQuestionnaireCollectionTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        financialQuestionnaireTester = new ConsumerTest<>(FinancialQuestionnaireCollectionType.class, "FinancialQuestionnaireCollection", FinancialQuestionnaireCollectionCollectionType.class, "FinancialQuestionnaireCollections");
        financialQuestionnaireTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollectionCollectionType> getTester() {
        return financialQuestionnaireTester;
    }

    @Override
    public FinancialQuestionnaireCollectionTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(FinancialQuestionnaireCollectionType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(FinancialQuestionnaireCollectionCollectionType collection) {
        return Optional.ofNullable(collection).map(FinancialQuestionnaireCollectionCollectionType::getFinancialQuestionnaireCollection).map(List::size).orElse(-1);
    }

    @Override
    public List<FinancialQuestionnaireCollectionType> getCollectionList(FinancialQuestionnaireCollectionCollectionType collection) {
        return Optional.ofNullable(collection).map(FinancialQuestionnaireCollectionCollectionType::getFinancialQuestionnaireCollection).orElse(new ArrayList<>());
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
    public void testQBES() {
        super.testQBES();
    }

    @Test
    @Category(IntegrationTest.class)
    public void testServicePaths() {
        super.testServicePaths();
    }

}
