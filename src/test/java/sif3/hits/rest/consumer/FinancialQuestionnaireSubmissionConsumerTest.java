package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.FinancialQuestionnaireSubmissionCollectionType;
import sif.dd.au30.model.FinancialQuestionnaireSubmissionType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.FinancialQuestionnaireSubmissionTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.FinancialQuestionnaireSubmissionTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.FinancialQuestionnaireSubmissionTestData.XML_REF_ID_RA;

public class FinancialQuestionnaireSubmissionConsumerTest extends BaseTest<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmissionCollectionType> {
    private ConsumerTest<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmissionCollectionType> financialQuestionnaireSubmissionTester = null;
    private FinancialQuestionnaireSubmissionTestData testData = new FinancialQuestionnaireSubmissionTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        financialQuestionnaireSubmissionTester = new ConsumerTest<>(FinancialQuestionnaireSubmissionType.class, "FinancialQuestionnaireSubmission", FinancialQuestionnaireSubmissionCollectionType.class, "FinancialQuestionnaireSubmissions");
        financialQuestionnaireSubmissionTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmissionCollectionType> getTester() {
        return financialQuestionnaireSubmissionTester;
    }

    @Override
    public FinancialQuestionnaireSubmissionTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(FinancialQuestionnaireSubmissionType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(FinancialQuestionnaireSubmissionCollectionType collection) {
        return Optional.ofNullable(collection).map(FinancialQuestionnaireSubmissionCollectionType::getFinancialQuestionnaireSubmission).map(List::size).orElse(-1);
    }

    @Override
    public List<FinancialQuestionnaireSubmissionType> getCollectionList(FinancialQuestionnaireSubmissionCollectionType collection) {
        return Optional.ofNullable(collection).map(FinancialQuestionnaireSubmissionCollectionType::getFinancialQuestionnaireSubmission).orElse(new ArrayList<>());
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
