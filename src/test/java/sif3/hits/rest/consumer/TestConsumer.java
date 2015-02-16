package sif3.hits.rest.consumer;

import sif.dd.au30.conversion.DataModelMarshalFactory;
import sif.dd.au30.conversion.DataModelUnmarshalFactory;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.conversion.UnmarshalFactory;
import sif3.infra.rest.consumer.AbstractConsumer;

public class TestConsumer<S, M> extends AbstractConsumer {

  private final Class<S> SINGLE_CLASS;
  private final Class<M> MULTI_CLASS;
  private final String SINGLE_NAME;
  private final String MULTI_NAME;
  
  private MarshalFactory MARSHALLER;
  private UnmarshalFactory UNMARSHALLER;

  /**
   * @param consumerID
   * @param marshaller
   * @param unmarshaller
   */
  public TestConsumer(Class<S> singleClass, String singleName, Class<M> multiClass, String multiName) {
    this.SINGLE_CLASS = singleClass;
    this.SINGLE_NAME = singleName;
    this.MULTI_CLASS = multiClass;
    this.MULTI_NAME = multiName;
    this.MARSHALLER = new DataModelMarshalFactory();
    this.UNMARSHALLER = new DataModelUnmarshalFactory();
  }

  @Override
  public ModelObjectInfo getSingleObjectClassInfo() {
    return new ModelObjectInfo(SINGLE_NAME, SINGLE_CLASS);
  }

  @Override
  public ModelObjectInfo getMultiObjectClassInfo() {
    return new ModelObjectInfo(MULTI_NAME, MULTI_CLASS);
  }
  
  @Override
  public MarshalFactory getMarshaller() {
    if (MARSHALLER == null) {
      MARSHALLER = new DataModelMarshalFactory();
    }
    return MARSHALLER;
  }
  
  @Override
  public UnmarshalFactory getUnmarshaller() {
    if (UNMARSHALLER == null) {
      UNMARSHALLER = new DataModelUnmarshalFactory();
    }

    return UNMARSHALLER;
  }
  
  @Override
  public void shutdown() {
    // Nothing to do at this stage
  }
}
