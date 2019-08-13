package sif3.hits.rest.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sif.dd.au30.model.PersonPictureCollectionType;
import sif.dd.au30.model.PersonPictureType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.PersonPictureTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static sif3.hits.rest.consumer.data.PersonPictureTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.PersonPictureTestData.XML_REF_ID_RA;

public class PersonPictureConsumerTest extends BaseTest<PersonPictureType, PersonPictureCollectionType> {
    private ConsumerTest<PersonPictureType, PersonPictureCollectionType> personPictureTester = null;
    private PersonPictureTestData testData = new PersonPictureTestData();

    @Before
    public void setup() {
        ConsumerLoader.initialise(CONSUMER);
        personPictureTester = new ConsumerTest<>(PersonPictureType.class, "PersonPicture", PersonPictureCollectionType.class, "PersonPictures");
        personPictureTester.testDeleteMany(XML_REF_ID_RA);
    }

    @Override
    public ConsumerTest<PersonPictureType, PersonPictureCollectionType> getTester() {
        return personPictureTester;
    }

    @Override
    public PersonPictureTestData getTestData() {
        return testData;
    }

    @Override
    public String getRefId(PersonPictureType object) {
        return object.getRefId();
    }

    @Override
    public List<PersonPictureType> getCollectionList(PersonPictureCollectionType collection) {
        return Optional.ofNullable(collection).map(PersonPictureCollectionType::getPersonPicture).orElse(new ArrayList<>());
    }

    @Override
    public int getCollectionSize(PersonPictureCollectionType collection) {
        return Optional.ofNullable(collection).map(PersonPictureCollectionType::getPersonPicture).map(List::size).orElse(-1);
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
