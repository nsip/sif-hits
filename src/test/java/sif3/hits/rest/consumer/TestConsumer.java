package sif3.hits.rest.consumer;

import sif.dd.au30.conversion.DataModelMarshalFactory;
import sif.dd.au30.conversion.DataModelUnmarshalFactory;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.conversion.UnmarshalFactory;
import sif3.common.header.HeaderValues;
import sif3.common.model.EventMetadata;
import sif3.common.model.PagingInfo;
import sif3.common.model.QueryCriteria;
import sif3.common.model.SIFEvent;
import sif3.common.model.delayed.DelayedResponseReceipt;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.ErrorDetails;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.model.MultiOperationStatusList;
import sif3.infra.rest.consumer.AbstractEventConsumer;

public class TestConsumer<S, M> extends AbstractEventConsumer<S> {

    private final Class<S> SINGLE_CLASS;
    private final Class<M> MULTI_CLASS;
    private final String SINGLE_NAME;
    private final String MULTI_NAME;

    private MarshalFactory MARSHALLER;
    private UnmarshalFactory UNMARSHALLER;

    @Override
    public SIFEvent<S> createEventObject(Object sifObjectList, HeaderValues.EventAction eventAction, HeaderValues.UpdateType updateType) {
        return null;
    }

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

    @Override
    public void processDelayedCreateMany(MultiOperationStatusList<CreateOperationStatus> arg0, DelayedResponseReceipt arg1) {

    }

    @Override
    public void processDelayedDeleteMany(MultiOperationStatusList<OperationStatus> arg0, DelayedResponseReceipt arg1) {

    }

    @Override
    public void processDelayedError(ErrorDetails arg0, DelayedResponseReceipt arg1) {

    }

    @Override
    public void processDelayedQuery(Object arg0, PagingInfo arg1, DelayedResponseReceipt arg2) {

    }

    @Override
    public void processDelayedServicePath(Object arg0, QueryCriteria arg1, PagingInfo arg2, DelayedResponseReceipt arg3) {

    }

    @Override
    public void processDelayedUpdateMany(MultiOperationStatusList<OperationStatus> arg0, DelayedResponseReceipt arg1) {

    }

    @Override
    public void processEvent(SIFEvent<S> sifEvent, EventMetadata metadata, String msgReadID, String consumerID) {

    }
}
