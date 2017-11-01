package sif3.hits.test.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.OtherIdListType;
import sif.dd.au30.model.OtherIdType;

public class OtherIdTestDataFactory extends HitsTestDataFactory<OtherIdType, OtherIdListType> {

  private final List<String> METHODS_TO_HANDLE = Arrays.asList("setType", "setValue");
  private final List<String> METHODS_TO_REJECT = Arrays.asList("getType", "getValue");

  public OtherIdTestDataFactory(String singleName) {
    super(OtherIdType.class, OtherIdListType.class, singleName);
  }

  @Override
  public String[] getRefIds() {
    return null;
  }
  
  @Override
  protected Boolean handleMethod(String name) {
    Boolean result = super.handleMethod(name);
    if (result == null) result = handleMethod(name, METHODS_TO_HANDLE, METHODS_TO_REJECT);
    return result;
  }
  
  public void setType(OtherIdType object, int index) {
    object.setType("" + index);
  }

  public void setValue(OtherIdType object, int index) {
    object.setValue("" + index);
  }

  
}
