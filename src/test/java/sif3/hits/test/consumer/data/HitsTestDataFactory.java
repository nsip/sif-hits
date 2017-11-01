package sif3.hits.test.consumer.data;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.ObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public abstract class HitsTestDataFactory<S, M> {

  private static final Logger L = LoggerFactory.getLogger(HitsTestDataFactory.class);

  private static final int TEMP_REF_ID_IDX = 5;
  private static final int TEMP_REF_ID_COUNT = 2;
  private static final int HARD_REF_ID_IDX = 0;
  private static final int HARD_REF_ID_COUNT = 5;

  private final Class<S> SINGLE_CLASS;
  private final Class<M> MULTI_CLASS;
  private final String SINGLE_NAME;
  private final Random RANDOM;
  private final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
  private final List<String> METHODS_TO_HANDLE = Arrays.asList();
  private final List<String> METHODS_TO_REJECT = Arrays.asList("getSIFMetadata", "setSIFMetadata", "setSIFExtendedElements", "getSIFExtendedElements", "equals", "getClass", "hashCode", "notify",
      "notifyAll", "toString", "wait");

  public HitsTestDataFactory(Class<S> singleClass, Class<M> multiClass, String singleName) {
    this.SINGLE_CLASS = singleClass;
    this.MULTI_CLASS = multiClass;
    this.SINGLE_NAME = singleName;
    long l = 0;
    for (int i = 0; i < singleName.length(); i++) {
      l += singleName.getBytes()[i];
    }
    RANDOM = new Random(l);
  }

  protected Boolean handleMethod(String name) {
    return handleMethod(name, METHODS_TO_HANDLE, METHODS_TO_REJECT);
  }

  protected Boolean handleMethod(String name, List<String> handleMethods, List<String> rejectMethods) {
    Boolean result = null;
    if (result == null && handleMethods.contains(name)) {
      result = Boolean.TRUE;
    } else if (result == null && rejectMethods.contains(name)) {
      result = Boolean.FALSE;
    }
    return result;
  }

  protected Random getRandom() {
    return RANDOM;
  }

  protected ObjectFactory getObjectFactory() {
    return OBJECT_FACTORY;
  }

  public S getTestData(int index) throws Exception {
    S result = SINGLE_CLASS.newInstance();
    Method[] methods = SINGLE_CLASS.getMethods();
    List<String> methodsToCall = new ArrayList<String>();
    List<String> unknown = new ArrayList<String>();
    for (Method method : methods) {
      Boolean handle = handleMethod(method.getName());
      if (Boolean.TRUE.equals(handle)) {
        methodsToCall.add(method.getName());
      } else if (handle == null) {
        unknown.add(method.getName());
      }
    }
    Collections.sort(unknown);
    for (String methodName : unknown) {
      System.out.println(methodName);
    }
    System.out.println("----");
    for (String methodName : methodsToCall) {
      this.getClass().getMethod(methodName, new Class[] { SINGLE_CLASS, int.class }).invoke(this, new Object[] { result, index });
    }
    return result;
  }

  @SuppressWarnings("rawtypes")
  protected <E extends Enum> E randomEnum(Class<E> e) {
    E[] values = e.getEnumConstants();
    return values[getRandom().nextInt(values.length)];
  }

  public S getTestData() throws Exception {
    return getTestData(-1);
  }

  public abstract String[] getRefIds();

  public String getRefId(S object) {
    String result = null;
    try {
      Method m = SINGLE_CLASS.getMethod("getRefId", new Class[] {});
      result = (String) m.invoke(object, new Object[] {});
    } catch (Exception ex) {
      L.error("Error getting ref id", ex);
    }
    return result;
  }

  public void setRefId(S object, String refId) {
    try {
      Method m = SINGLE_CLASS.getMethod("setRefId", new Class[] { String.class });
      m.invoke(object, new Object[] { refId });
    } catch (Exception ex) {
      L.error("Error setting ref id", ex);
    }
  }

  @SuppressWarnings("unchecked")
  public List<S> getListFromMulti(M object) {
    List<S> result = null;
    try {
      Method m = MULTI_CLASS.getMethod("get" + SINGLE_NAME, new Class[] {});
      result = (List<S>) m.invoke(object, new Object[] {});
    } catch (Exception ex) {
      L.error("Error getting multi list.", ex);
    }
    return result;
  }

  public String getRefId(int index) {
    String result = null;
    String[] refIds = getRefIds();
    if (refIds != null && index >= 0 && index < refIds.length) {
      result = refIds[index];
    } else {
      result = RefIdGenerator.getRefId();
    }
    return result;
  }

  public String[] getTemporaryRefIds() {
    List<String> result = new ArrayList<String>();
    for (int i = TEMP_REF_ID_IDX; result.size() < TEMP_REF_ID_COUNT; i++) {
      result.add(getRefId(i));
    }
    return result.toArray(new String[] {});
  }

  public String[] getHardRefIds() {
    List<String> result = new ArrayList<String>();
    for (int i = HARD_REF_ID_IDX; result.size() < HARD_REF_ID_COUNT; i++) {
      result.add(getRefId(i));
    }
    return result.toArray(new String[] {});
  }

  public List<S> getHardData() throws Exception {
    List<S> items = new ArrayList<S>();
    for (int i = HARD_REF_ID_IDX; items.size() < HARD_REF_ID_COUNT; i++) {
      items.add(getTestData(i));
    }
    return items;
  }

  public M getMultiObjectFromList(List<S> items) {
    M result = null;
    try {
      result = MULTI_CLASS.newInstance();
      getListFromMulti(result).addAll(items);
    } catch (Exception ex) {
      L.error("Error creating multi object.", ex);
    }
    return result;
  }

  public S getTestData(String refId) throws Exception {
    S result = null;
    String[] refIds = getRefIds();
    for (int i = 0; result == null && i < refIds.length; i++) {
      if (refId.equals(refIds[i])) {
        result = getTestData(i);
      }
    }
    if (result == null) result = getTestData(-1);
    setRefId(result, refId);
    return result;
  }

}
