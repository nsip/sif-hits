package sif3.hits.rest.provider;

import static sif3.hits.service.e.OperationStatus.CREATE_ERR_OTHER;
import static sif3.hits.service.e.OperationStatus.DELETE_ERR_OTHER;
import static sif3.hits.service.e.OperationStatus.UNKNOWN_ERROR;
import static sif3.hits.service.e.OperationStatus.UPDATE_ERR_OTHER;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import au.com.systemic.framework.utils.StringUtils;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.exception.DataTooLargeException;
import sif3.common.exception.PersistenceException;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.interfaces.QueryProvider;
import sif3.common.model.PagingInfo;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryPredicate;
import sif3.common.model.RequestMetadata;
import sif3.common.model.ResponseParameters;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.ErrorDetails;
import sif3.common.ws.OperationStatus;
import sif3.hits.config.HitsSpringContext;
import sif3.hits.rest.dto.KeyValuePair;
import sif3.hits.rest.dto.RequestDTO;
import sif3.hits.rest.dto.ResponseDTO;
import sif3.hits.service.BaseService;
import sif3.hits.utils.ConstraintViolationHelper;
import sif3.hits.utils.RefIdGenerator;

public abstract class HitsBaseProvider<S, SC, H, HS extends BaseService<S, SC, H>> extends AUDataModelProvider implements QueryProvider {

    private final Class<S> SIF_CLASS;
    private final Class<SC> SIF_COLLECTION_CLASS;
    private final Class<HS> HITS_SERVICE_CLASS;
    private final String SINGLE_NAME;
    private final String COLLECTION_NAME;

    private static final Logger L = LoggerFactory.getLogger(HitsBaseProvider.class);
    private static final Map<Class<?>, Method> GET_COLLECTION_METHODS = new HashMap<Class<?>, Method>();
    private static final int MAXIMUM_PAGE_SIZE = 1000;

    private HS service = null;

    public HitsBaseProvider(Class<S> sifClass, String singleName, Class<SC> sifCollectionClass, String collectionName, Class<HS> hitsServiceClass) {
        super();
        this.SIF_CLASS = sifClass;
        this.SINGLE_NAME = singleName;
        this.SIF_COLLECTION_CLASS = sifCollectionClass;
        this.COLLECTION_NAME = collectionName;
        this.HITS_SERVICE_CLASS = hitsServiceClass;
        initialise(sifCollectionClass, getCollectionMethod());
    }

    /*
     * Can override this if needed.
     */
    public String getCollectionMethod() {
        return this.SINGLE_NAME;
    }

    private HS getService() {
        if (service == null) {
            service = HitsSpringContext.getBean(HITS_SERVICE_CLASS);
        }
        return service;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#retrievByPrimaryKey(java.lang.String, sif3.common.model.SIFZone, sif3.common.model.SIFContext)
     */
    @Override
    public Object retrievByPrimaryKey(String resourceID, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException {

        try {
            setDatabaseContext(zone, context, metadata);

            if (StringUtils.isEmpty(resourceID)) {
                throw new IllegalArgumentException("Resource ID is null or empty. It must be provided to retrieve an entity.");
            }

            L.debug("Retrieve " + SINGLE_NAME + " with Resoucre ID = " + resourceID);

            return getService().get(resourceID, getZoneId(zone));
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    private void setDatabaseContext(SIFZone zone, SIFContext context, RequestMetadata metadata) {
        getService().setDatabaseContext(metadata.getApplicationKey());
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#createSingle(java.lang.Object, sif3.common.model.SIFZone, sif3.common.model.SIFContext)
     */
    @Override
    public Object createSingle(Object data, boolean useAdvisory, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException {

        try {
            setDatabaseContext(zone, context, metadata);

            // Must be of type SIF_CLASS
            if (data != null && SIF_CLASS.isAssignableFrom(data.getClass())) {
                S sifObject = SIF_CLASS.cast(data);
                RequestDTO<S> baseDTO = getRequestDTO(sifObject, useAdvisory, SIF_CLASS);
                ResponseDTO<S> result = createSingle(baseDTO, getZoneId(zone));
                CreateOperationStatus createOperationStatus = getCreateOperationStatus(result);
                if (result.getOperationStatus().isOk()) {
                    return result.getSifObject();
                } else {
                    throw new PersistenceException(createOperationStatus.getError().getMessage());
                }
            } else {
                String receivedType = "invalid";
                if (data != null && data.getClass() != null) {
                    receivedType = data.getClass().getSimpleName();
                }
                throw new IllegalArgumentException("Expected Object Type = " + SIF_CLASS.getSimpleName() + ". Received Object Type = " + receivedType);
            }

        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (PersistenceException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    private ResponseDTO<S> createSingle(RequestDTO<S> dto, String zoneId) {
        try {
            return getService().createSingle(dto, zoneId);
        } catch (Exception ex) {
            ResponseDTO<S> response = ConstraintViolationHelper.handleConstraintViolation(dto, ex, ConstraintViolationHelper.CREATE);
            if (response == null) {
                L.error(CREATE_ERR_OTHER.getMessage(), ex);
                return new ResponseDTO<S>(dto, null, CREATE_ERR_OTHER, ex.getMessage());
            }
            return response;
        }
    }

    private List<ResponseDTO<S>> createMany(List<RequestDTO<S>> dtoList, String zoneId) {
        List<ResponseDTO<S>> result = new ArrayList<ResponseDTO<S>>();
        if (dtoList != null) {
            for (RequestDTO<S> dto : dtoList) {
                ResponseDTO<S> sifResult = createSingle(dto, zoneId);
                result.add(sifResult);
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#updateSingle(java.lang.Object, java.lang.String, sif3.common.model.SIFZone, sif3.common.model.SIFContext)
     */
    @Override
    public boolean updateSingle(Object data, String resourceID, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException {
        try {
            setDatabaseContext(zone, context, metadata);

            if (StringUtils.isEmpty(resourceID)) {
                throw new IllegalArgumentException("Resource ID is null or empty. It must be provided to update an entity.");
            }

            // Must be of type SIF_CLASS
            if (data != null && SIF_CLASS.isAssignableFrom(data.getClass())) {
                L.debug("Update " + SINGLE_NAME + " with Resoucre ID = " + resourceID);
                S sifObject = SIF_CLASS.cast(data);
                RequestDTO<S> dto = getRequestDTO(sifObject, resourceID, SIF_CLASS);
                ResponseDTO<S> result = updateSingle(dto, getZoneId(zone));
                OperationStatus operationStatus = getOperationStatus(result);
                if (result.getOperationStatus().isOk()) {
                    return true;
                } else {
                    throw new PersistenceException(operationStatus.getError().getMessage());
                }
            } else {
                String receivedType = "invalid";
                if (data != null && data.getClass() != null) {
                    receivedType = data.getClass().getSimpleName();
                }
                throw new IllegalArgumentException("Expected Object Type = " + SIF_CLASS.getSimpleName() + ". Received Object Type = " + receivedType);
            }
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (PersistenceException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    private ResponseDTO<S> updateSingle(RequestDTO<S> dto, String zoneId) {
        try {
            return getService().updateSingle(dto, zoneId);
        } catch (Exception ex) {
            ResponseDTO<S> response = ConstraintViolationHelper.handleConstraintViolation(dto, ex, ConstraintViolationHelper.UPDATE);
            if (response == null) {
                L.error(UPDATE_ERR_OTHER.getMessage(), ex);
                return new ResponseDTO<S>(dto, null, UPDATE_ERR_OTHER, ex.getMessage());
            }
            return response;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#deleteSingle(java.lang.String, sif3.common.model.SIFZone, sif3.common.model.SIFContext)
     */
    @Override
    public boolean deleteSingle(String resourceID, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException {
        try {
            setDatabaseContext(zone, context, metadata);

            if (StringUtils.isEmpty(resourceID)) {
                throw new IllegalArgumentException("Resource ID is null or empty. It must be provided to delete an entity.");
            }

            L.debug("Remove " + SINGLE_NAME + " with Resoucre ID = " + resourceID);
            S object = null;
            ResponseDTO<S> result = deleteSingle(getRequestDTO(object, resourceID, SIF_CLASS), getZoneId(zone));
            OperationStatus operationStatus = getOperationStatus(result);
            if (result.getOperationStatus().isOk()) {
                return true;
            } else if (result.getOperationStatus().getHttpStatus() == HttpStatus.NOT_FOUND.value()) {
                return false;
            } else {
                throw new PersistenceException(operationStatus.getError().getMessage());
            }
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (PersistenceException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    private ResponseDTO<S> deleteSingle(RequestDTO<S> dto, String zoneId) {
        try {
            return getService().deleteSingle(dto, zoneId);
        } catch (Exception ex) {
            ResponseDTO<S> response = ConstraintViolationHelper.handleConstraintViolation(dto, ex, ConstraintViolationHelper.DELETE);
            if (response == null) {
                L.error(DELETE_ERR_OTHER.getMessage(), ex);
                response = new ResponseDTO<S>(dto, null, DELETE_ERR_OTHER, ex.getMessage());
            }
            return response;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#retrive(sif3.common.model.SIFZone, sif3.common.model.SIFContext, sif3.common.model.PagingInfo)
     */
    @Override
    public Object retrieve(SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws PersistenceException, UnsupportedQueryException, DataTooLargeException {
        try {
            validatePagingInfo(pagingInfo);
            setDatabaseContext(zone, context, metadata);

            L.debug("Find many " + COLLECTION_NAME + "...");
            return getService().findAll(getZoneId(zone), pagingInfo);
        } catch (DataTooLargeException ex) {
            throw ex;
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    @Override
    public Object retrieveByServicePath(QueryCriteria criteria, SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata,
            ResponseParameters customResponseParams) throws UnsupportedQueryException, PersistenceException, DataTooLargeException {

        try {
            validatePagingInfo(pagingInfo);
            setDatabaseContext(zone, context, metadata);

            L.debug("Find many " + COLLECTION_NAME + " ... ");

            List<KeyValuePair> filters = new ArrayList<KeyValuePair>();
            for (QueryPredicate predicate : criteria.getPredicates()) {
                filters.add(new KeyValuePair(predicate.getSubject(), predicate.getValue()));
            }

            return getService().findByServicePath(filters, pagingInfo, getZoneId(zone));
        } catch (DataTooLargeException ex) {
            throw ex;
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    private void validatePagingInfo(PagingInfo pagingInfo) throws DataTooLargeException {
        if (pagingInfo.getPageSize() > MAXIMUM_PAGE_SIZE) {
            throw new DataTooLargeException(
                    "Page size : " + pagingInfo.getPageSize() + ", is greater than the maximum page size this provider returns (" + MAXIMUM_PAGE_SIZE + ")");
        } else if (pagingInfo.getPageSize() <= 0) {
            throw new IllegalArgumentException("Page size : " + pagingInfo.getPageSize() + ", must be greater than 0.");
        }
        if (pagingInfo.getCurrentPageNo() <= 0) {
            pagingInfo.setCurrentPageNo(1);
        }
    }



    @Override
    public Object retrieveByQBE(Object example, SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws PersistenceException, UnsupportedQueryException, DataTooLargeException {
        
        try {
            validatePagingInfo(pagingInfo);
            setDatabaseContext(zone, context, metadata);

            L.debug("Find many " + COLLECTION_NAME + " ... ");
            if (example == null) {
                throw new UnsupportedQueryException("Query by example object is null");
            } else if (!SIF_CLASS.isAssignableFrom(example.getClass())) {
                throw new UnsupportedQueryException("Query by example object is of incorrect type : " + example.getClass().toString());
            } else {
                S sifExample = SIF_CLASS.cast(example);
                String refId = getRefId(sifExample, SIF_CLASS);
                if (refId != null) {
                    // may need to do something special here.
                }
                return getService().findByExample(SIF_CLASS.cast(example), getZoneId(zone), pagingInfo);
            }
        } catch (DataTooLargeException ex) {
            throw ex;
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#createMany(java.lang.Object, sif3.common.model.SIFZone, sif3.common.model.SIFContext)
     */
    @Override
    public List<CreateOperationStatus> createMany(Object data, boolean useAdvisory, SIFZone zone, SIFContext context, RequestMetadata metadata,
            ResponseParameters customResponseParams) throws IllegalArgumentException, PersistenceException {

        try {
            setDatabaseContext(zone, context, metadata);

            // Must be of type SIF_COLLECTION_TYPE
            if (data != null && SIF_COLLECTION_CLASS.isAssignableFrom(data.getClass())) {
                L.debug("Create many " + COLLECTION_NAME + "...");
                SC sifCollection = SIF_COLLECTION_CLASS.cast(data);
                List<RequestDTO<S>> dtoList = getDTOList(sifCollection, useAdvisory);
                List<ResponseDTO<S>> responseList = createMany(dtoList, getZoneId(zone));
                return getCreateOperationStatusList(responseList);
            } else {
                String receivedType = "invalid";
                if (data != null && data.getClass() != null) {
                    receivedType = data.getClass().getSimpleName();
                }
                throw new IllegalArgumentException("Expected Object Type = " + SIF_COLLECTION_CLASS.getSimpleName() + ". Received Object Type = " + receivedType);
            }
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (PersistenceException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#updateMany(java.lang.Object, sif3.common.model.SIFZone, sif3.common.model.SIFContext)
     */
    @Override
    public List<OperationStatus> updateMany(Object data, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException {
        try {
            setDatabaseContext(zone, context, metadata);

            // Must be of type SchoolInfoCollectionType
            if (data != null && SIF_COLLECTION_CLASS.isAssignableFrom(data.getClass())) {
                L.debug("Update many " + COLLECTION_NAME + "...");
                SC sifCollection = SIF_COLLECTION_CLASS.cast(data);
                List<RequestDTO<S>> dtoList = getDTOList(sifCollection);
                List<ResponseDTO<S>> responseList = updateMany(dtoList, getZoneId(zone));
                return getOperationStatusList(responseList);
            } else {
                String receivedType = "invalid";
                if (data != null && data.getClass() != null) {
                    receivedType = data.getClass().getSimpleName();
                }
                throw new IllegalArgumentException("Expected Object Type = " + SIF_COLLECTION_CLASS.getSimpleName() + ". Received Object Type = " + receivedType);
            }
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (PersistenceException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    private List<ResponseDTO<S>> updateMany(List<RequestDTO<S>> dtoList, String zoneId) {
        List<ResponseDTO<S>> result = new ArrayList<ResponseDTO<S>>();
        if (dtoList != null) {
            for (RequestDTO<S> dto : dtoList) {
                ResponseDTO<S> sifResult = updateSingle(dto, zoneId);
                result.add(sifResult);
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.Provider#deleteMany(java.lang.Object, sif3.common.model.SIFZone, sif3.common.model.SIFContext)
     */
    @Override
    public List<OperationStatus> deleteMany(List<String> resourceIDs, SIFZone zone, SIFContext context, RequestMetadata metadata, ResponseParameters customResponseParams)
            throws IllegalArgumentException, PersistenceException {
        try {
            setDatabaseContext(zone, context, metadata);

            if (resourceIDs != null) {
                L.debug("Delete many " + COLLECTION_NAME + "...");
                List<RequestDTO<S>> dtoList = getDTOList(resourceIDs);
                List<ResponseDTO<S>> responseList = deleteMany(dtoList, getZoneId(zone));
                return getOperationStatusList(responseList);
            } else {
                return new ArrayList<OperationStatus>();
            }
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (PersistenceException ex) {
            throw ex;
        } catch (Exception ex) {
            L.error("Unknown Error:", ex);
            throw new PersistenceException(UNKNOWN_ERROR.getMessage());
        }
    }

    private List<ResponseDTO<S>> deleteMany(List<RequestDTO<S>> dtoList, String zoneId) {
        List<ResponseDTO<S>> result = new ArrayList<ResponseDTO<S>>();
        if (dtoList != null) {
            for (RequestDTO<S> dto : dtoList) {
                ResponseDTO<S> sifResult = deleteSingle(dto, zoneId);
                result.add(sifResult);
            }
        }
        return result;
    }

    private List<RequestDTO<S>> getDTOList(SC sifCollection) throws PersistenceException {
        List<S> sifList = getSifList(sifCollection);
        List<RequestDTO<S>> dtoList = new ArrayList<RequestDTO<S>>();
        if (sifList != null) {
            for (S sifObject : sifList) {
                dtoList.add(getRequestDTO(sifObject, (Boolean) null, SIF_CLASS));
            }
        }
        return dtoList;
    }

    private List<RequestDTO<S>> getDTOList(List<String> resourceIds) throws PersistenceException {
        List<RequestDTO<S>> dtoList = new ArrayList<RequestDTO<S>>();
        if (resourceIds != null) {
            for (String resourceId : resourceIds) {
                S object = null;
                dtoList.add(getRequestDTO(object, resourceId, SIF_CLASS));
            }
        }
        return dtoList;
    }

    private List<RequestDTO<S>> getDTOList(SC sifCollection, boolean useAdvisory) throws PersistenceException {
        List<S> sifList = getSifList(sifCollection);
        List<RequestDTO<S>> dtoList = new ArrayList<RequestDTO<S>>();
        if (sifList != null) {
            for (S sifObject : sifList) {
                dtoList.add(getRequestDTO(sifObject, useAdvisory, SIF_CLASS));
            }
        }
        return dtoList;
    }

    private List<CreateOperationStatus> getCreateOperationStatusList(List<ResponseDTO<S>> responses) {
        List<CreateOperationStatus> result = new ArrayList<CreateOperationStatus>();
        if (responses != null) {
            for (ResponseDTO<S> response : responses) {
                result.add(getCreateOperationStatus(response));
            }
        }
        return result;
    }

    private CreateOperationStatus getCreateOperationStatus(ResponseDTO<S> response) {
        CreateOperationStatus status = null;
        if (response.getOperationStatus().isOk()) {
            status = new CreateOperationStatus(response.getRequestDTO().getRefId(), response.getRequestDTO().getAdvisoryId(), response.getOperationStatus().getHttpStatus());
        } else {
            String message = SINGLE_NAME + " - " + response.getOperationStatus().getMessage();
            if (response.getDetailMessage() != null) {
                message += " - " + response.getDetailMessage();
            }
            status = new CreateOperationStatus(response.getRequestDTO().getRefId(), response.getRequestDTO().getAdvisoryId(), response.getOperationStatus().getHttpStatus(),
                    new ErrorDetails(response.getOperationStatus().getHttpStatus(), message));
        }
        return status;
    }

    private List<OperationStatus> getOperationStatusList(List<ResponseDTO<S>> responses) {
        List<OperationStatus> result = new ArrayList<OperationStatus>();
        if (responses != null) {
            for (ResponseDTO<S> response : responses) {
                result.add(getOperationStatus(response));
            }
        }
        return result;
    }

    private OperationStatus getOperationStatus(ResponseDTO<S> response) {
        OperationStatus status = null;
        if (response.getOperationStatus().isOk()) {
            status = new OperationStatus(response.getRequestDTO().getRefId(), response.getOperationStatus().getHttpStatus());
        } else {
            String message = SINGLE_NAME + " - " + response.getOperationStatus().getMessage();
            if (response.getDetailMessage() != null) {
                message += " - " + response.getDetailMessage();
            }
            status = new OperationStatus(response.getRequestDTO().getRefId(), response.getOperationStatus().getHttpStatus(),
                    new ErrorDetails(response.getOperationStatus().getHttpStatus(), message));
        }
        return status;
    }

    protected RequestDTO<S> getRequestDTO(S sifObject, Boolean useAdvisory, Class<S> sifClass) throws PersistenceException {
        String advisoryId = null;
        String refId = null;
        if (sifObject != null) {
            advisoryId = getRefId(sifObject, sifClass);
            refId = advisoryId;
            if (Boolean.FALSE.equals(useAdvisory)) {
                refId = RefIdGenerator.getRefId();
                setRefId(sifObject, sifClass, refId);
            }
        }
        return new RequestDTO<S>(advisoryId, refId, useAdvisory, sifObject);
    }

    protected RequestDTO<S> getRequestDTO(S sifObject, String resourceId, Class<S> sifClass) throws PersistenceException {
        String advisoryId = resourceId;
        String refId = resourceId;
        if (sifObject != null) {
            advisoryId = getRefId(sifObject, sifClass);
        }
        return new RequestDTO<S>(advisoryId, refId, null, sifObject);
    }

    /**
     * Override this method if the sif object does not have a getRefId Method
     * 
     * @param sifObject
     * @param sifClass
     * @param refId
     * @return
     * @throws PersistenceException
     */
    protected String getRefId(S sifObject, Class<S> sifClass) throws PersistenceException {
        try {
            return (String) sifClass.getMethod("getRefId").invoke(sifObject);
        } catch (Exception ex) {
            L.error("Override this method getRefId not implemented on SifObject - " + SINGLE_NAME, ex);
            throw new PersistenceException(SINGLE_NAME + " - Unable to perform conversion.");
        }
    }

    /**
     * Override this method if the sif object does not have a setRefId Method
     * 
     * @param sifObject
     * @param sifClass
     * @param refId
     * @return
     * @throws PersistenceException
     */
    protected void setRefId(S sifObject, Class<S> sifClass, String refId) throws PersistenceException {
        try {
            sifClass.getMethod("setRefId", new Class<?>[] { String.class }).invoke(sifObject, refId);
        } catch (Exception ex) {
            L.error("Override this method setRefId not implemented on SifObject - " + SINGLE_NAME, ex);
            throw new PersistenceException(SINGLE_NAME + " - Unable to perform conversion.");
        }
    }

    private static void initialise(Class<?> collectionClass, String singleName) {
        if (GET_COLLECTION_METHODS.get(collectionClass) == null) {
            assignCollectionMethod(collectionClass, singleName);
        }
    }

    private synchronized static void assignCollectionMethod(Class<?> collectionClass, String singleName) {
        if (GET_COLLECTION_METHODS.get(collectionClass) == null) {
            try {
                Method method = collectionClass.getMethod("get" + singleName, new Class[] {});
                GET_COLLECTION_METHODS.put(collectionClass, method);
            } catch (Exception e) {
                L.error("Unable to determine get collection method. - get" + singleName, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    protected List<S> getSifList(SC sifCollection) {
        try {
            return (List<S>) GET_COLLECTION_METHODS.get(sifCollection.getClass()).invoke(sifCollection, new Object[] {});
        } catch (Exception e) {
            L.error("Unable to get collection list from collection type. - " + SINGLE_NAME, e);
            // Probably need to override this method if you get this exception.
        }
        return null;
    }

    @Override
    public ModelObjectInfo getSingleObjectClassInfo() {
        return new ModelObjectInfo(SINGLE_NAME, SIF_CLASS);
    }

    @Override
    public ModelObjectInfo getMultiObjectClassInfo() {
        return new ModelObjectInfo(COLLECTION_NAME, SIF_COLLECTION_CLASS);
    }

}
