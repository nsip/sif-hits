package sif3.hits.rest.consumer;

import static sif3.hits.rest.consumer.data.StudentPersonalTestData.XML_REF_ID_1;
import static sif3.hits.rest.consumer.data.StudentPersonalTestData.XML_REF_ID_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.OtherIdType;
import sif.dd.au30.model.StudentPersonalCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.StudentPersonalTestData;
import sif3.hits.service.PersonalStudentIdService;
import sif3.infra.rest.consumer.ConsumerLoader;

public class StudentPersonalConsumerTest extends BaseTest<StudentPersonalType, StudentPersonalCollectionType> {
	private ConsumerTest<StudentPersonalType, StudentPersonalCollectionType> studentPersonalTester = null;
	private StudentPersonalTestData testData = new StudentPersonalTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		studentPersonalTester = new ConsumerTest<>(StudentPersonalType.class, "StudentPersonal",
				StudentPersonalCollectionType.class, "StudentPersonals");
		studentPersonalTester.testDeleteMany(XML_REF_ID_RA);
	}

	@Override
	public ConsumerTest<StudentPersonalType, StudentPersonalCollectionType> getTester() {
		return studentPersonalTester;
	}

	@Override
	public StudentPersonalTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(StudentPersonalType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(StudentPersonalType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<StudentPersonalType> getCollectionList(StudentPersonalCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentPersonalCollectionType::getStudentPersonal)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(StudentPersonalCollectionType collection) {
		return Optional.ofNullable(collection).map(StudentPersonalCollectionType::getStudentPersonal).map(List::size)
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
		super.testFullUpdate(false);
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

	@Test
	@Category(IntegrationTest.class)
	public void testCreatePSIWithNullList() {
		StudentPersonalType initialObject = getSingleObjectFromXML(
				studentPersonalTester.getFileContents(testData.getSingleObjectXMLFilename()));
		initialObject.setOtherIdList(null);
		List<Response> createResponses = studentPersonalTester.doCreateOne(initialObject);
		StudentPersonalType createdObject = getSingleObject(createResponses);
		Assert.assertEquals("RefId Incorrect", XML_REF_ID_1, createdObject.getRefId());
		Assert.assertFalse("Initial Obejct has PSI id", PersonalStudentIdService.hasIdentifier(initialObject));
		Assert.assertTrue("Created Object does not have PSI id", PersonalStudentIdService.hasIdentifier(createdObject));
		Assert.assertEquals("Created object does not have an other id", 1,
				createdObject.getOtherIdList().getValue().getOtherId().size());
	}

	@Test
	@Category(IntegrationTest.class)
	public void testCreatePSI() {
		StudentPersonalType initialObject = getSingleObjectFromXML(
				studentPersonalTester.getFileContents(testData.getSingleObjectXMLFilename()));
		initialObject.getOtherIdList().getValue().getOtherId().clear();
		List<Response> createResponses = studentPersonalTester.doCreateOne(initialObject);
		StudentPersonalType createdObject = getSingleObject(createResponses);
		Assert.assertEquals("RefId Incorrect", XML_REF_ID_1, createdObject.getRefId());
		Assert.assertFalse("Initial Obejct has PSI id", PersonalStudentIdService.hasIdentifier(initialObject));
		Assert.assertTrue("Created Object does not have PSI id", PersonalStudentIdService.hasIdentifier(createdObject));
		Assert.assertEquals("Created object does not have an other id", 1,
				createdObject.getOtherIdList().getValue().getOtherId().size());
	}

	@Test
	@Category(IntegrationTest.class)
	public void testNoCreatePSI() {
		StudentPersonalType initialObject = getSingleObjectFromXML(
				studentPersonalTester.getFileContents(testData.getSingleObjectXMLFilename()));
		initialObject.getOtherIdList().getValue().getOtherId().clear();
		OtherIdType psi = new OtherIdType();
		psi.setType(PersonalStudentIdService.PERSONAL_STUDENT_IDENTIFIER_TYPE);
		psi.setValue(PersonalStudentIdService.getIdentifier(6));
		initialObject.getOtherIdList().getValue().getOtherId().clear();
		initialObject.getOtherIdList().getValue().getOtherId().add(psi);
		List<Response> createResponses = studentPersonalTester.doCreateOne(initialObject);
		StudentPersonalType createdObject = getSingleObject(createResponses);
		Assert.assertEquals("RefId Incorrect", XML_REF_ID_1, createdObject.getRefId());
		Assert.assertTrue("Initial Object does not have PSI id", PersonalStudentIdService.hasIdentifier(initialObject));
		Assert.assertTrue("Created Object does not have PSI id", PersonalStudentIdService.hasIdentifier(createdObject));
		Assert.assertEquals("Created object does not have an other id",
				initialObject.getOtherIdList().getValue().getOtherId().size(),
				createdObject.getOtherIdList().getValue().getOtherId().size());
		for (OtherIdType otherId : createdObject.getOtherIdList().getValue().getOtherId()) {
			if (PersonalStudentIdService.PERSONAL_STUDENT_IDENTIFIER_TYPE.equals(otherId.getType())) {
				Assert.assertEquals(psi.getValue(), otherId.getValue());
			}
		}
	}
}
