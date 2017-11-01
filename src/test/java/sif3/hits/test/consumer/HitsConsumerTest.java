package sif3.hits.test.consumer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.test.consumer.data.HitsTestDataFactory;
import sif3.infra.rest.consumer.ConsumerLoader;

public abstract class HitsConsumerTest<S, M> extends BaseConsumerTest {

  private static final Logger L = LoggerFactory.getLogger(HitsConsumerTest.class);

  public HitsTestConsumer<S, M> consumer = null;
  public HitsTestDataFactory<S, M> dataFactory = null;
  private final Class<S> SINGLE_CLASS;
  private final Class<M> MULTI_CLASS;

  public HitsConsumerTest(Class<S> entityClass, Class<M> collectionClass, String name, HitsTestDataFactory<S, M> dataFactory) {
    ConsumerLoader.initialise("TestConsumer");
    L.info("HitsConsumerTest initialised");
    this.consumer = new HitsTestConsumer<S, M>(entityClass, collectionClass, name);
    this.SINGLE_CLASS = entityClass;
    this.MULTI_CLASS = collectionClass;
    this.dataFactory = dataFactory;
  }

  @Before
  public void setup() {
    consumer.deleteMany(dataFactory.getTemporaryRefIds());
  }

  @Test
  public void initialiseData() throws Exception {
    List<S> items = dataFactory.getHardData();
    M collection = dataFactory.getMultiObjectFromList(items);
    consumer.createMany(collection);
    if (isUpdateAvailable()) {
      consumer.updateMany(collection);
    }
    for (int i = 0; i < items.size(); i++) {
      objectsEquals(items.get(i), getItem(getValidResponse(consumer.getSingle(dataFactory.getRefId(i))).getDataObject()));
    }
  }

  @Test
  public void testCreateDeleteUpdateOne() throws Exception {
    String[] tempRefIds = dataFactory.getTemporaryRefIds();
    Assert.assertNotNull(tempRefIds);
    Assert.assertTrue(tempRefIds.length > 0);
    String refId = tempRefIds[0];
    getInvalidResponse(consumer.getSingle(refId));
    S item = dataFactory.getTestData(refId);
    getValidResponse(consumer.createOne(item));
    objectsEquals(item, getItem(getValidResponse(consumer.getSingle(refId)).getDataObject()));
    S updatedItem = dataFactory.getTestData();
    dataFactory.setRefId(updatedItem, refId);
    getValidResponse(consumer.updateOne(updatedItem, refId));
    objectsEquals(updatedItem, getItem(getValidResponse(consumer.getSingle(refId)).getDataObject()));
    consumer.deleteOne(refId);
    getInvalidResponse(consumer.getSingle(refId));
  }

  @Test
  public void testGetOne() {
    String[] hardRefIds = dataFactory.getHardRefIds();
    Assert.assertNotNull(hardRefIds);
    Assert.assertTrue(hardRefIds.length > 0);
    String refId = hardRefIds[0];
    Response response = getValidResponse(consumer.getSingle(hardRefIds[0]));
    Assert.assertEquals(refId, dataFactory.getRefId(getItem(response.getDataObject())));
  }

  @Test
  public void testCreateDeleteUpdateMany() throws Exception {
    String[] tempRefIds = dataFactory.getTemporaryRefIds();
    Assert.assertNotNull(tempRefIds);
    Assert.assertTrue(tempRefIds.length > 0);
    List<S> items = new ArrayList<S>();
    for (int i = 0; i < tempRefIds.length; i++) {
      items.add(dataFactory.getTestData(tempRefIds[i]));
      getInvalidResponse(consumer.getSingle(tempRefIds[i]));
    }
    M collection = dataFactory.getMultiObjectFromList(items);
    getValidCollectionResponses(consumer.createMany(collection), items.size());
    for (S item : items) {
      objectsEquals(item, getItem(getValidResponse(consumer.getSingle(dataFactory.getRefId(item))).getDataObject()));  
    }
    List<S> updatedItems = new ArrayList<S>();
    for (int i = 0; i < tempRefIds.length; i++) {
      S updatedItem = dataFactory.getTestData();
      dataFactory.setRefId(updatedItem, tempRefIds[i]);
      updatedItems.add(updatedItem);
    }
    for (S item : updatedItems) {
      objectsEquals(item, getItem(getValidResponse(consumer.getSingle(dataFactory.getRefId(item))).getDataObject()));  
    }
    consumer.deleteMany(tempRefIds);
    for (int i = 0; i < tempRefIds.length; i++) {
      getInvalidResponse(consumer.getSingle(tempRefIds[i]));
    }
  }

  @Test
  public void testGetMany() {
    String[] hardRefIds = dataFactory.getHardRefIds();
    Assert.assertNotNull(hardRefIds);
    Assert.assertTrue(hardRefIds.length > 0);
    Response response = getValidResponse(consumer.getMany(hardRefIds.length, 1));
    M collection = getCollection(response.getDataObject());
    List<S> items = dataFactory.getListFromMulti(collection);
    Assert.assertTrue(items.size() == hardRefIds.length);
  }

  /**
   * Override if update not available.
   * 
   * @return
   */
  protected boolean isUpdateAvailable() {
    return true;
  }

  private S getItem(Object item) {
    return SINGLE_CLASS.cast(item);
  }

  private Response getResponse(List<Response> responses) {
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    return responses.get(0);
  }

  private Response getValidResponse(List<Response> responses) {
    Response result = getResponse(responses);
    Assert.assertNotNull(result.getDataObject());
    return result;
  }

  private Response getInvalidResponse(List<Response> responses) {
    Response result = getResponse(responses);
    Assert.assertNull(result.getDataObject());
    return result;
  }

  private M getCollection(Object collection) {
    return MULTI_CLASS.cast(collection);
  }

  private <OS extends OperationStatus> List<OS> getCollectionResponse(List<BulkOperationResponse<OS>> responses) {
    Assert.assertNotNull(responses);
    Assert.assertEquals(1, responses.size());
    BulkOperationResponse<OS> bulkOperationResponse = responses.get(0);
    return bulkOperationResponse.getOperationStatuses();
  }

  private <OS extends OperationStatus> List<OS> getValidCollectionResponses(List<BulkOperationResponse<OS>> responses, int size) {
    List<OS> result = getCollectionResponse(responses);
    Assert.assertNotNull(result);
    Assert.assertFalse(result.isEmpty());
    Assert.assertEquals(size, result.size());
    return result;
  }
  
  private void objectsEquals(S left, S right) {
    String xmlExpectedFrom = consumer.getXMLFromObject(left);
    String xmlExpectedTo = consumer.getXMLFromObject(right);
    if (!semiEquals(xmlExpectedFrom, xmlExpectedTo)) {
      Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
    }
  }

}
