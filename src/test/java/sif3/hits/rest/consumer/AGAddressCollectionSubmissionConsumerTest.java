//package sif3.hits.rest.consumer;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.experimental.categories.Category;
//import sif.dd.au30.model.AGAddressCollectionSubmissionCollectionType;
//import sif.dd.au30.model.AGAddressCollectionSubmissionType;
//import sif3.hits.rest.consumer.category.InitialiseData;
//import sif3.hits.rest.consumer.category.IntegrationTest;
//import sif3.hits.rest.consumer.data.AGAddressCollectionSubmissionTestData;
//import sif3.infra.rest.consumer.ConsumerLoader;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static sif3.hits.rest.consumer.data.AGAddressCollectionSubmissionTestData.XML_REF_ID_1;
//import static sif3.hits.rest.consumer.data.AGAddressCollectionSubmissionTestData.XML_REF_ID_RA;
//
//public class AGAddressCollectionSubmissionConsumerTest extends BaseTest<AGAddressCollectionSubmissionType, AGAddressCollectionSubmissionCollectionType> {
//    private ConsumerTest<AGAddressCollectionSubmissionType, AGAddressCollectionSubmissionCollectionType> agAddressCollectionSubmissionTester = null;
//    private AGAddressCollectionSubmissionTestData testData = new AGAddressCollectionSubmissionTestData();
//
//    @Before
//    public void setup() {
//        ConsumerLoader.initialise(CONSUMER);
//        agAddressCollectionSubmissionTester = new ConsumerTest<>(AGAddressCollectionSubmissionType.class, "AGAddressCollectionSubmission", AGAddressCollectionSubmissionCollectionType.class, "AGAddressCollectionSubmissions");
//        agAddressCollectionSubmissionTester.testDeleteMany(XML_REF_ID_RA);
//    }
//
//    @Override
//    public ConsumerTest<AGAddressCollectionSubmissionType, AGAddressCollectionSubmissionCollectionType> getTester() {
//        return agAddressCollectionSubmissionTester;
//    }
//
//    @Override
//    public AGAddressCollectionSubmissionTestData getTestData() {
//        return testData;
//    }
//
//    @Override
//    public String getRefId(AGAddressCollectionSubmissionType object) {
//        return object.getRefId();
//    }
//
//    @Override
//    public int getCollectionSize(AGAddressCollectionSubmissionCollectionType collection) {
//        return Optional.ofNullable(collection).map(AGAddressCollectionSubmissionCollectionType::getAGAddressCollectionSubmission).map(List::size).orElse(-1);
//    }
//
//    @Override
//    public List<AGAddressCollectionSubmissionType> getCollectionList(AGAddressCollectionSubmissionCollectionType collection) {
//        return Optional.ofNullable(collection).map(AGAddressCollectionSubmissionCollectionType::getAGAddressCollectionSubmission).orElse(new ArrayList<>());
//    }
//
//    @Test
//    @Category({IntegrationTest.class, InitialiseData.class})
//    public void initialiseData() {
//        super.initialiseData();
//    }
//
//    @Test
//    @Category(IntegrationTest.class)
//    public void testUpdateSingle() {
//        super.testUpdateSingle();
//    }
//
//    @Test
//    @Category(IntegrationTest.class)
//    public void testGetSingle() {
//        super.testGetSingle();
//    }
//
//    @Test
//    @Category(IntegrationTest.class)
//    public void testGetMany() {
//        super.testGetMany();
//    }
//
//    @Test
//    @Category(IntegrationTest.class)
//    public void testCreateDelete() {
//        super.testCreateDelete(XML_REF_ID_1);
//    }
//    
//    @Test
//    @Category(IntegrationTest.class)
//    public void testCreateDeleteMany() {
//        super.testCreateDeleteMany(XML_REF_ID_RA);
//    }
//
//    @Test
//    @Category(IntegrationTest.class)
//    public void testQBES() {
//        super.testQBES();
//    }
//
//    @Test
//    @Category(IntegrationTest.class)
//    public void testServicePaths() {
//        super.testServicePaths();
//    }
//
//}
