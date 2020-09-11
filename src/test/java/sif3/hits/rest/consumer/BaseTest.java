package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import sif3.common.exception.MarshalException;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.model.QueryCriteria;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.data.TestData;

public abstract class BaseTest<T, C> {
	private static final Logger L = LoggerFactory.getLogger(BaseTest.class);

	public static final String CONSUMER = "TestConsumer";
	private static final int OBJECT_COUNT = 5;
	private static final int TEST_INDEX = 0;

	private Pattern TAG_PATTERN = Pattern.compile("^[^\\<]*(<[^\\>]*>).*$");
	private List<String> TIMESTAMPS = Arrays.asList("CreationDateTime", "WellbeingEventCreationTimeStamp",
			"ResolutionMeetingTime", "SubmissionTimestamp");

	public abstract TestData<T, C> getTestData();

	public abstract ConsumerTest<T, C> getTester();

	public void doSimpleUpdate(T object) {
		// Do nothing by default
	}

	public abstract String getRefId(T object);

	public abstract void setRefId(T object, String refId);

	public abstract List<T> getCollectionList(C collection);

	public abstract int getCollectionSize(C collection);

	public void initialiseData() {
		TestData<T, C> testData = getTestData();
		ConsumerTest<T, C> tester = getTester();
		for (int i = 0; i < OBJECT_COUNT; i++) {
			T singleObject = testData.getTestObject(i);
			tester.doCreateOne(singleObject);
			tester.doUpdateOne(singleObject, getRefId(singleObject));
			if (i == TEST_INDEX || testData.verifyAllInitialObjects()) {
				String xmlExpectedFrom = getXML(singleObject);
				T getResult = tester.doGetOne(getRefId(singleObject));
				String xmlExpectedTo = getXML(getResult);
				sameObject(xmlExpectedFrom, xmlExpectedTo);
			}
		}
	}

	protected void testUpdateSingle() {
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();
		String testRefId = testData.getRefId(TEST_INDEX);

		List<Response> responses = tester.testGetSingle(testRefId);
		T singleObject = getSingleObject(responses);
		doSimpleUpdate(singleObject);
		Assert.assertEquals("RefId mismatch", testRefId, getRefId(singleObject));
		String xmlExpectedFrom = getXML(singleObject);

		List<Response> updateResponses = tester.doUpdateOne(singleObject, testRefId);
		checkNoContent(updateResponses);

		List<Response> getResponses = tester.testGetSingle(testRefId);
		T newObject = getSingleObject(getResponses);
		Assert.assertEquals("RefId mismatch", testRefId, getRefId(newObject));
		String xmlExpectedTo = getXML(newObject);
		sameObject(xmlExpectedFrom, xmlExpectedTo);
	}

	protected void testFullUpdate() {
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();
		String refId = testData.getRefId(Integer.MAX_VALUE);

		T testObject = tester.getEmptyObject();
		setRefId(testObject, refId);
		tester.doCreateOne(testObject);

		testObject = testData.getTestObject(1);
		setRefId(testObject, refId);
		tester.doUpdateOne(testObject, refId);

		String xmlExpectedFrom = getXML(testObject);

		List<Response> getResponses = tester.testGetSingle(refId);
		T newObject = getSingleObject(getResponses);

		tester.testDeleteOne(refId);

		Assert.assertEquals("RefId mismatch", refId, getRefId(newObject));
		String xmlExpectedTo = getXML(newObject);
		sameObject(xmlExpectedFrom, xmlExpectedTo);
	}

	protected void testCreateUpdateDeleteSingle(T initialObject, T updatedObject) {
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();

		List<Response> createResponse = tester.doCreateOne(initialObject);
		String testRefId = getRefId(initialObject);
		List<Response> getResponses = tester.testGetSingle(testRefId);
		T createdObject = getSingleObject(getResponses);
		sameObject(initialObject, createdObject);

		tester.doUpdateOne(updatedObject, testRefId);
		List<Response> updateResponse = tester.testGetSingle(testRefId);
		T newObject = getSingleObject(updateResponse);
		sameObject(updatedObject, newObject);

		List<Response> finalResponses = tester.testGetSingle(testRefId);
		T finalObject = getSingleObject(finalResponses);
		sameObject(updatedObject, finalObject);

		List<Response> deleteResponses = tester.testDeleteOne(testRefId);
		checkNoContent(deleteResponses);
	}

	protected void testGetSingle() {
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();
		String testRefId = testData.getRefId(TEST_INDEX);

		List<Response> responses = tester.testGetSingle(testRefId);
		T singleObject = getSingleObject(responses);
		Assert.assertEquals("RefId mismatch", testRefId, getRefId(singleObject));
	}

	protected void testGetMany() {
		int expectedRecords = 5;
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();

		List<Response> responses = tester.testGetMany(expectedRecords, 1);
		C collectionObject = getCollectionObject(responses);
		Assert.assertEquals("Collection size incorrect", expectedRecords, getCollectionSize(collectionObject));
	}

	protected void testCreateDelete(String xmlRefId) {
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();

		List<Response> createResponses = tester.testCreateOne(testData.getSingleObjectXMLFilename());
		T singleObject = getSingleObject(createResponses);
		Assert.assertEquals("RefId mismatch", xmlRefId, getRefId(singleObject));

		List<Response> deleteResponses = tester.testDeleteOne(xmlRefId);
		checkNoContent(deleteResponses);
	}

	protected void testCreateDeleteMany(String[] xmlRefIdRa) {
		List<String> xmlRefIdList = Arrays.asList(xmlRefIdRa);
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();

		List<BulkOperationResponse<CreateOperationStatus>> createResponses = tester
				.testCreateMany(testData.getMultiObjectXMLFilename());
		Assert.assertNotNull("Responses null", createResponses);
		Assert.assertEquals("Response size not 1", 1, createResponses.size());
		BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
		Assert.assertNotNull("Response object null", createResponse.getOperationStatuses());
		Assert.assertEquals("Response count incorrect", xmlRefIdRa.length,
				createResponse.getOperationStatuses().size());
		for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
			Assert.assertTrue("RefId not expected", xmlRefIdList.contains(operationStatus.getAdvisoryID()));
			Assert.assertEquals("HttpStatus not CREATED", HttpStatus.CREATED.value(), operationStatus.getStatus());
		}

		List<BulkOperationResponse<OperationStatus>> deleteResponses = tester.testDeleteMany(xmlRefIdRa);
		Assert.assertNotNull("Responses null", deleteResponses);
		Assert.assertEquals("Responses size not 1", 1, deleteResponses.size());
		BulkOperationResponse<OperationStatus> deleteResponse = deleteResponses.get(0);
		Assert.assertNotNull("Response object null", deleteResponse.getOperationStatuses());
		Assert.assertEquals("Response count incorrect", xmlRefIdRa.length,
				deleteResponse.getOperationStatuses().size());
		for (OperationStatus operationStatus : deleteResponse.getOperationStatuses()) {
			Assert.assertTrue("RefId not expected", xmlRefIdList.contains(operationStatus.getResourceID()));
			Assert.assertEquals("HttpStatus not OK", HttpStatus.OK.value(), operationStatus.getStatus());
		}
	}

	protected void testQBES() {
		TestData<T, C> testData = getTestData();

		List<T> examples = testData.getExamplesForQuery();
		for (int i = 0; i < examples.size(); i++) {
			testQBE(examples.get(i), i);
		}
	}

	protected void testQBE(T example, int index) {
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();

		List<Response> responses = tester.testQBE(example, 1000, 0);
		C collection = getCollectionObject(responses);
		List<T> list = getCollectionList(collection);
		Assert.assertNotNull("List null", list);
		Assert.assertFalse("Collection empty", list.isEmpty());
		for (T object : list) {
			Assert.assertTrue("Object does not match example", testData.isExampleObject(object, index));
		}
	}

	protected void testServicePaths() {
		TestData<T, C> testData = getTestData();

		List<QueryCriteria> servicePaths = testData.getServicePathQueries();
		for (int i = 0; i < servicePaths.size(); i++) {
			testServicePath(servicePaths.get(i), i);
		}
	}

	protected void testServicePath(QueryCriteria servicePath, int index) {
		ConsumerTest<T, C> tester = getTester();
		TestData<T, C> testData = getTestData();

		List<Response> responses = tester.testServicePath(servicePath, 1000, 0);
		C collection = getCollectionObject(responses);
		List<T> list = getCollectionList(collection);
		Assert.assertNotNull("List null", list);
		Assert.assertFalse("Collection empty", list.isEmpty());
		for (T object : list) {
			Assert.assertTrue("Object does not match service path", testData.isServicePathObject(object, index));
		}
	}

	protected T getSingleObject(List<Response> responses) {
		Assert.assertNotNull("Responses null", responses);
		Assert.assertEquals("Response size not 1", 1, responses.size());
		Response response = responses.get(0);
		Assert.assertNotNull("Response object null", response.getDataObject());
		T singleObject = (T) response.getDataObject();
		return singleObject;
	}

	protected C getCollectionObject(List<Response> responses) {
		Assert.assertNotNull("Responses null", responses);
		Assert.assertEquals("Response size not 1", 1, responses.size());
		Response response = responses.get(0);
		Assert.assertNotNull("Response object null", response.getDataObject());
		C collectionObject = (C) response.getDataObject();
		return collectionObject;
	}

	protected void checkNoContent(List<Response> responses) {
		Assert.assertNotNull("Responses null", responses);
		Assert.assertEquals("Response size not 1", 1, responses.size());
		Assert.assertEquals("Response status not NO_CONTENT", HttpStatus.NO_CONTENT.value(),
				responses.get(0).getStatus());
	}

	protected void sameObject(T leftObject, T rightObject) {
		String xmlExpectedFrom = getXML(leftObject);
		String xmlExpectedTo = getXML(rightObject);
		sameObject(xmlExpectedFrom, xmlExpectedTo);
	}

	protected void sameObject(String left, String right) {
		boolean semiEquals = semiEquals(left, right);
		if (!semiEquals) {
			L.debug("From:\n" + left);
			L.debug("\nTo:\n" + right);
			Assert.assertEquals("XML Differs", left, right);
		}
	}

	protected String getXML(Object object) {
		String xml = null;
		try {
			ConsumerTest<T, C> tester = getTester();
			xml = tester.getXML(object);
		} catch (UnsupportedMediaTypeExcpetion unsupportedMediaTypeExcpetion) {
			Assert.assertNull("Exception occurred", unsupportedMediaTypeExcpetion);
		} catch (MarshalException e) {
			Assert.assertNull("Exception occurred", e);
		} catch (Exception e) {
			Assert.assertNull("Exception occurred", e);
		}
		Assert.assertNotNull("Unable to convert to XML", xml);
		return xml;
	}

	protected T getSingleObjectFromXML(String xml) {
		T result = null;
		try {
			ConsumerTest<T, C> tester = getTester();
			result = tester.fromXML(xml);
		} catch (UnsupportedMediaTypeExcpetion unsupportedMediaTypeExcpetion) {
			Assert.assertNull("Exception occurred", unsupportedMediaTypeExcpetion);
		} catch (UnmarshalException e) {
			Assert.assertNull("Exception occurred", e);
		} catch (Exception e) {
			Assert.assertNull("Exception occurred", e);
		}
		Assert.assertNotNull("Unable to convert from XML", result);
		return result;
	}

	protected C getCollectionObjectFromXML(String xml) {
		C result = null;
		try {
			ConsumerTest<T, C> tester = getTester();
			result = tester.collectionFromXML(xml);
		} catch (UnsupportedMediaTypeExcpetion unsupportedMediaTypeExcpetion) {
			Assert.assertNull("Exception occurred", unsupportedMediaTypeExcpetion);
		} catch (UnmarshalException e) {
			Assert.assertNull("Exception occurred", e);
		} catch (Exception e) {
			Assert.assertNull("Exception occurred", e);
		}
		Assert.assertNotNull("Unable to convert from XML", result);
		return result;
	}

	protected boolean semiEquals(String xmlFrom, String xmlTo) {
		String[] fromStrings = xmlFrom.split("\n");
		List<String> fromElements = Arrays.asList(fromStrings);
		String[] toStrings = xmlTo.split("\n");
		List<String> toElements = Arrays.asList(toStrings);
		boolean allSame = fromElements.size() == toElements.size();
		for (int i = 0; i < fromElements.size(); i++) {
			String element = fromElements.get(i);
			boolean same = true;
			if (isTimestamp(element)) {
				same = simpleFrequency(fromElements, element) == simpleFrequency(toElements, element);
			} else {
				same = Collections.frequency(fromElements, element) == Collections.frequency(toElements, element);
			}
			if (!same) {
				L.debug("Error:" + element);
			}
			allSame &= same;
		}
		for (int i = 0; i < toElements.size(); i++) {
			String element = toElements.get(i);
			boolean same = true;
			if (isTimestamp(element)) {
				same = simpleFrequency(fromElements, element) == simpleFrequency(toElements, element);
			} else {
				same = Collections.frequency(fromElements, element) == Collections.frequency(toElements, element);
			}
			if (!same) {
				L.debug("Error:" + element);
			}
			allSame &= same;
		}
		return allSame;
	}

	private int simpleFrequency(List<String> elements, String search) {
		int result = 0;
		String tag = getTag(search);
		for (String s : elements) {
			if (tag.equals(getTag(s))) {
				result++;
			}
		}
		return result;
	}

	private String getTag(String element) {
		Matcher m = TAG_PATTERN.matcher(element);
		if (m.matches()) {
			return m.group(1);
		}
		return element;
	}

	private boolean isTimestamp(String element) {
		boolean result = false;
		for (int i = 0; !result && i < TIMESTAMPS.size(); i++) {
			result |= element.contains("<" + TIMESTAMPS.get(i) + ">");
		}
		return result;
	}

}
