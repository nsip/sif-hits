package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.StudentScoreJudgementAgainstStandardCollectionType;
import sif.dd.au30.model.StudentScoreJudgementAgainstStandardType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentScoreJudgementAgainstStandardTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.StudentScoreJudgementAgainstStandardTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentScoreJudgementAgainstStandardTestData.XML_REF_ID_RA;

public class StudentScoreJudgementAgainstStandardTest extends BaseTest<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandardCollectionType> {
    private ConsumerTest<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandardCollectionType> studentScoreJudgementAgainstStandardTester = null;
    private StudentScoreJudgementAgainstStandardTestData testData = new StudentScoreJudgementAgainstStandardTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        studentScoreJudgementAgainstStandardTester = new ConsumerTest<>(StudentScoreJudgementAgainstStandardType.class, "StudentScoreJudgementAgainstStandard", StudentScoreJudgementAgainstStandardCollectionType.class, "StudentScoreJudgementAgainstStandards");
        studentScoreJudgementAgainstStandardTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<StudentScoreJudgementAgainstStandardType, StudentScoreJudgementAgainstStandardCollectionType> getTester() {
        return studentScoreJudgementAgainstStandardTester;
    }

    @Override
    public StudentScoreJudgementAgainstStandardTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(StudentScoreJudgementAgainstStandardType object) {
        return object.getRefId();
    }

    @Override
    public int getCollectionSize(StudentScoreJudgementAgainstStandardCollectionType collection) {
        return Optional.ofNullable(collection).map(StudentScoreJudgementAgainstStandardCollectionType::getStudentScoreJudgementAgainstStandard).map(List::size).orElse(-1);
    }

    @Override
    public List<StudentScoreJudgementAgainstStandardType> getCollectionList(StudentScoreJudgementAgainstStandardCollectionType collection) {
        return Optional.ofNullable(collection).map(StudentScoreJudgementAgainstStandardCollectionType::getStudentScoreJudgementAgainstStandard).orElse(new ArrayList<>());
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
