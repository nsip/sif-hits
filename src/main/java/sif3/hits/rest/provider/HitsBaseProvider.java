package sif3.hits.rest.provider;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif3.common.conversion.ModelObjectInfo;
import sif3.common.exception.PersistenceException;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.ErrorDetails;
import sif3.common.ws.OperationStatus;
import sif3.hits.config.HitsSpringContext;
import sif3.hits.rest.dto.RequestDTO;
import sif3.hits.rest.dto.ResponseDTO;
import sif3.hits.service.BaseService;
import au.com.systemic.framework.utils.StringUtils;

public abstract class HitsBaseProvider<S, SC, H, HS extends BaseService<S, SC, H>> extends AUDataModelProvider {

  private final Class<S> SIF_CLASS;
  private final Class<SC> SIF_COLLECTION_CLASS;
  private final Class<HS> HITS_SERVICE_CLASS;
  private final String SINGLE_NAME;
  private final String COLLECTION_NAME;

  private static final Logger L = LoggerFactory.getLogger(HitsBaseProvider.class);

  private HS service = null;

  public HitsBaseProvider(Class<S> sifClass, String singleName, Class<SC> sifCollectionClass, String collectionName,
      Class<HS> hitsServiceClass) {
    super();
    this.SIF_CLASS = sifClass;
    this.SINGLE_NAME = singleName;
    this.SIF_COLLECTION_CLASS = sifCollectionClass;
    this.COLLECTION_NAME = collectionName;
    this.HITS_SERVICE_CLASS = hitsServiceClass;
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
   * @see sif3.common.interfaces.Provider#retrievByPrimaryKey(java.lang.String, sif3.common.model.SIFZone,
   * sif3.common.model.SIFContext)
   */
  @Override
  public Object retrievByPrimaryKey(String resourceID, SIFZone zone, SIFContext context)
      throws IllegalArgumentException, PersistenceException {

    if (StringUtils.isEmpty(resourceID)) {
      throw new IllegalArgumentException("Resource ID is null or empty. It must be provided to retrieve an entity.");
    }

    L.debug("Retrieve " + SINGLE_NAME + " with Resoucre ID = " + resourceID);

    return getService().getSingle(resourceID, getZoneId(zone));
  }

  /*
   * (non-Javadoc)
   * 
   * @see sif3.common.interfaces.Provider#createSingle(java.lang.Object, sif3.common.model.SIFZone,
   * sif3.common.model.SIFContext)
   */
  @Override
  public Object createSingle(Object data, boolean useAdvisory, SIFZone zone, SIFContext context)
      throws IllegalArgumentException, PersistenceException {

    // Must be of type SIF_CLASS
    if (data != null && SIF_CLASS.isAssignableFrom(data.getClass())) {
      S sifObject = SIF_CLASS.cast(data);
      RequestDTO<S> baseDTO = RequestDTO.getInstance(sifObject, useAdvisory, SIF_CLASS);
      ResponseDTO<S> result = getService().createSingle(baseDTO, getZoneId(zone));
      CreateOperationStatus createOperationStatus = getCreateOperationStatus(result);
      if (result.getOperationStatus().isOk()) {
        return result.getSifObject();
      } else {
        throw new PersistenceException(createOperationStatus.getError().getMessage());
      }
    } else {
      throw new IllegalArgumentException("Expected Object Type = " + SIF_CLASS.getSimpleName()
          + ". Received Object Type = " + data.getClass().getSimpleName());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see sif3.common.interfaces.Provider#updateSingle(java.lang.Object, java.lang.String, sif3.common.model.SIFZone,
   * sif3.common.model.SIFContext)
   */
  @Override
  public boolean updateSingle(Object data, String resourceID, SIFZone zone, SIFContext context)
      throws IllegalArgumentException, PersistenceException {
    if (StringUtils.isEmpty(resourceID)) {
      throw new IllegalArgumentException("Resource ID is null or empty. It must be provided to update an entity.");
    }

    // Must be of type SIF_CLASS
    if (data != null && SIF_CLASS.isAssignableFrom(data.getClass())) {
      L.debug("Update " + SINGLE_NAME + " with Resoucre ID = " + resourceID);
      S sifObject = SIF_CLASS.cast(data);
      RequestDTO<S> dto = RequestDTO.getInstance(sifObject, resourceID, SIF_CLASS);
      ResponseDTO<S> result = getService().updateSingle(dto, getZoneId(zone));
      OperationStatus operationStatus = getOperationStatus(result);
      if (result.getOperationStatus().isOk()) {
        return true;
      } else {
        throw new PersistenceException(operationStatus.getError().getMessage());
      }
    } else {
      throw new IllegalArgumentException("Expected Object Type  = " + SIF_CLASS.getSimpleName()
          + ". Received Object Type = " + data.getClass().getSimpleName());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see sif3.common.interfaces.Provider#deleteSingle(java.lang.String, sif3.common.model.SIFZone,
   * sif3.common.model.SIFContext)
   */
  @Override
  public boolean deleteSingle(String resourceID, SIFZone zone, SIFContext context) throws IllegalArgumentException,
      PersistenceException {
    if (StringUtils.isEmpty(resourceID)) {
      throw new IllegalArgumentException("Resource ID is null or empty. It must be provided to delete an entity.");
    }

    L.debug("Remove " + SINGLE_NAME + " with Resoucre ID = " + resourceID);
    S object = null;
    ResponseDTO<S> result = getService().deleteSingle(RequestDTO.getInstance(object, resourceID, SIF_CLASS),
        getZoneId(zone));
    OperationStatus operationStatus = getOperationStatus(result);
    if (result.getOperationStatus().isOk()) {
      return true;
    } else {
      throw new PersistenceException(operationStatus.getError().getMessage());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see sif3.common.interfaces.Provider#retrive(sif3.common.model.SIFZone, sif3.common.model.SIFContext,
   * sif3.common.model.PagingInfo)
   */
  @Override
  public Object retrieve(SIFZone zone, SIFContext context, PagingInfo pagingInfo) throws PersistenceException,
      UnsupportedQueryException {
    L.debug("Find many " + COLLECTION_NAME + "...");
    return getService().findAll(pagingInfo, getZoneId(zone));
  }

  /*
   * (non-Javadoc)
   * 
   * @see sif3.common.interfaces.Provider#createMany(java.lang.Object, sif3.common.model.SIFZone,
   * sif3.common.model.SIFContext)
   */
  @Override
  public List<CreateOperationStatus> createMany(Object data, boolean useAdvisory, SIFZone zone, SIFContext context)
      throws IllegalArgumentException, PersistenceException {

    // Must be of type SIF_COLLECTION_TYPE
    if (data != null && SIF_COLLECTION_CLASS.isAssignableFrom(data.getClass())) {
      L.debug("Create many " + COLLECTION_NAME + "...");
      SC sifCollection = SIF_COLLECTION_CLASS.cast(data);
      List<RequestDTO<S>> dtoList = getDTOList(sifCollection, useAdvisory);
      List<ResponseDTO<S>> responseList = getService().createMany(dtoList, getZoneId(zone));
      return getCreateOperationStatusList(responseList);
    } else {
      throw new IllegalArgumentException("Expected Object Type  = " + SIF_COLLECTION_CLASS.getSimpleName()
          + ". Received Object Type = " + data.getClass().getSimpleName());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see sif3.common.interfaces.Provider#updateMany(java.lang.Object, sif3.common.model.SIFZone,
   * sif3.common.model.SIFContext)
   */
  @Override
  public List<OperationStatus> updateMany(Object data, SIFZone zone, SIFContext context)
      throws IllegalArgumentException, PersistenceException {
    // Must be of type SchoolCollectionType
    if (data != null && SIF_COLLECTION_CLASS.isAssignableFrom(data.getClass())) {
      L.debug("Update many " + COLLECTION_NAME + "...");
      SC sifCollection = SIF_COLLECTION_CLASS.cast(data);
      List<RequestDTO<S>> dtoList = getDTOList(sifCollection);
      List<ResponseDTO<S>> responseList = getService().updateMany(dtoList, getZoneId(zone));
      return getOperationStatusList(responseList);
    } else {
      throw new IllegalArgumentException("Expected Object Type  = " + SIF_COLLECTION_CLASS.getSimpleName()
          + ". Received Object Type = " + data.getClass().getSimpleName());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see sif3.common.interfaces.Provider#deleteMany(java.lang.Object, sif3.common.model.SIFZone,
   * sif3.common.model.SIFContext)
   */
  @Override
  public List<OperationStatus> deleteMany(List<String> resourceIDs, SIFZone zone, SIFContext context)
      throws IllegalArgumentException, PersistenceException {

    if (resourceIDs != null) {
      L.debug("Delete many " + COLLECTION_NAME + "...");
      List<RequestDTO<S>> dtoList = getDTOList(resourceIDs);
      List<ResponseDTO<S>> responseList = getService().deleteMany(dtoList, getZoneId(zone));
      return getOperationStatusList(responseList);
    } else {
      return new ArrayList<OperationStatus>();
    }
  }

  private List<RequestDTO<S>> getDTOList(SC sifCollection) throws PersistenceException {
    List<S> sifList = getSifList(sifCollection);
    List<RequestDTO<S>> dtoList = new ArrayList<RequestDTO<S>>();
    if (sifList != null) {
      for (S sifObject : sifList) {
        dtoList.add(RequestDTO.getInstance(sifObject, SIF_CLASS));
      }
    }
    return dtoList;
  }

  private List<RequestDTO<S>> getDTOList(List<String> resourceIds) throws PersistenceException {
    List<RequestDTO<S>> dtoList = new ArrayList<RequestDTO<S>>();
    if (resourceIds != null) {
      for (String resourceId : resourceIds) {
        S object = null;
        dtoList.add(RequestDTO.getInstance(object, resourceId, SIF_CLASS));
      }
    }
    return dtoList;
  }

  private List<RequestDTO<S>> getDTOList(SC sifCollection, boolean useAdvisory) throws PersistenceException {
    List<S> sifList = getSifList(sifCollection);
    List<RequestDTO<S>> dtoList = new ArrayList<RequestDTO<S>>();
    if (sifList != null) {
      for (S sifObject : sifList) {
        dtoList.add(RequestDTO.getInstance(sifObject, useAdvisory, SIF_CLASS));
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
      status = new CreateOperationStatus(response.getRequestDTO().getRefId(), response.getRequestDTO().getAdvisoryId(),
          response.getOperationStatus().getHttpStatus());
    } else {
      status = new CreateOperationStatus(response.getRequestDTO().getRefId(), response.getRequestDTO().getAdvisoryId(),
          response.getOperationStatus().getHttpStatus(), new ErrorDetails(
              response.getOperationStatus().getHttpStatus(), SINGLE_NAME + " - "
                  + response.getOperationStatus().getMessage()));
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
      status = new OperationStatus(response.getRequestDTO().getRefId(), response.getOperationStatus().getHttpStatus(),
          new ErrorDetails(response.getOperationStatus().getHttpStatus(), SINGLE_NAME + " - "
              + response.getOperationStatus().getMessage()));
    }
    return status;
  }

  protected abstract List<S> getSifList(SC sifCollection);

  @Override
  public ModelObjectInfo getSingleObjectClassInfo() {
    return new ModelObjectInfo(SINGLE_NAME, SIF_CLASS);
  }

  @Override
  public ModelObjectInfo getMultiObjectClassInfo() {
    return new ModelObjectInfo(COLLECTION_NAME, SIF_COLLECTION_CLASS);
  }

}
