package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.SessionInfoCollectionType;
import sif.dd.au30.model.SessionInfoType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.SessionInfoTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.SessionInfoTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.SessionInfoTestData.XML_REF_ID_RA;

public class SessionInfoConsumerTest extends BaseTest<SessionInfoType, SessionInfoCollectionType> {
    private ConsumerTest<SessionInfoType, SessionInfoCollectionType> sessionInfoTester = null;
    private SessionInfoTestData testData = new SessionInfoTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        sessionInfoTester = new ConsumerTest<>(SessionInfoType.class, "SessionInfo", SessionInfoCollectionType.class, "SessionInfos");
        sessionInfoTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<SessionInfoType, SessionInfoCollectionType> getTester() {
        return sessionInfoTester;
    }

    @Override
    public SessionInfoTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(SessionInfoType object) {
        return object.getRefId();
    }

    @Override
    public List<SessionInfoType> getCollectionList(SessionInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(SessionInfoCollectionType::getSessionInfo).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(SessionInfoCollectionType collection) {
        return Optional.ofNullable(collection).map(SessionInfoCollectionType::getSessionInfo).map(List::size).orElse(-1);
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
