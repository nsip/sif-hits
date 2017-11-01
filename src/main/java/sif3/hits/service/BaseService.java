package sif3.hits.service;

import static sif3.hits.service.e.OperationStatus.CREATE_ERR_EXISTS;
import static sif3.hits.service.e.OperationStatus.CREATE_ERR_NO_ADVISORY;
import static sif3.hits.service.e.OperationStatus.CREATE_OK;
import static sif3.hits.service.e.OperationStatus.DELETE_ERR_INVALID;
import static sif3.hits.service.e.OperationStatus.DELETE_ERR_NO_OBJECT;
import static sif3.hits.service.e.OperationStatus.DELETE_OK;
import static sif3.hits.service.e.OperationStatus.UPDATE_ERR_NO_OBJECT;
import static sif3.hits.service.e.OperationStatus.UPDATE_ERR_REFID_MISMATCH;
import static sif3.hits.service.e.OperationStatus.UPDATE_OK;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sif3.common.CommonConstants;
import sif3.common.exception.PersistenceException;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.model.PagingInfo;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.helper.HitsDatabaseContext;
import sif3.hits.domain.shared.model.ApplicationKeyUrl;
import sif3.hits.rest.dto.KeyValuePair;
import sif3.hits.rest.dto.RequestDTO;
import sif3.hits.rest.dto.ResponseDTO;

@Transactional(value = "transactionManager", rollbackForClassName = { "RuntimeException", "PersistenceException", "UnsupportedQueryException" })
public abstract class BaseService<S, SC, H> {

  private static final Logger L = LoggerFactory.getLogger(BaseService.class);

  private final ThreadLocal<ApplicationKeyUrl> currentApplicationKeyUrl = new ThreadLocal<ApplicationKeyUrl>();

  protected abstract SC getCollection(List<S> items);

  protected abstract HitsConverter<S, H> getConverter();

  protected abstract JpaRepository<H, String> getDAO();

  protected abstract FilterableRepository<H> getFilterableDAO();

  @Autowired
  private ApplicationKeyUrlService applicationKeyUrlService;

  // Create
  public ResponseDTO<S> createSingle(RequestDTO<S> dto, String zoneId) {
    ResponseDTO<S> result = null;
    if (!StringUtils.isEmpty(dto.getRefId())) {
      H checkExists = getDAO().findOne(dto.getRefId());
      if (checkExists == null) {
        H hitsObject = getConverter().toHitsModel(dto.getSifObject());
        H savedHitsObject = save(hitsObject, dto, zoneId, true);
        S resultObject = getConverter().toSifModel(savedHitsObject);
        result = new ResponseDTO<S>(dto, resultObject, CREATE_OK);
      } else {
        result = new ResponseDTO<S>(dto, null, CREATE_ERR_EXISTS);
      }
    } else {
      result = new ResponseDTO<S>(dto, null, CREATE_ERR_NO_ADVISORY);
    }
    return result;
  }

  private void delete(H hitsObject, RequestDTO<S> dto) {
    deleteChildObjects(hitsObject);
    try {
      getDAO().delete(hitsObject);
    } catch (Exception ex) {
      System.out.println(ex);
      throw ex;
    }
  }

  /**
   * Override this in services that need child objects managed
   * 
   * @param hitsObject
   */
  protected void deleteChildObjects(H hitsObject) {
    // do nothing
  }

  // Delete
  public ResponseDTO<S> deleteSingle(RequestDTO<S> dto, String zoneId) {
    ResponseDTO<S> result = null;
    try {
      if (!StringUtils.isEmpty(dto.getRefId())) {
        H hitsObject = getDAO().findOne(dto.getRefId());
        if (hitsObject != null) {
          delete(hitsObject, dto);
          result = new ResponseDTO<S>(dto, null, DELETE_OK);
        } else {
          result = new ResponseDTO<S>(dto, null, DELETE_ERR_NO_OBJECT);
        }
      } else {
        result = new ResponseDTO<S>(dto, null, DELETE_ERR_INVALID);
      }
    } catch (Exception ex) {
      System.out.println(ex);
      throw ex;
    }
    return result;
  }

  /**
   * Read All
   * 
   * @param zoneId
   * @param pagingInfo
   * @return
   */
  public SC findAll(String zoneId, PagingInfo pagingInfo) {
    SC result = null;
    if (pagingInfo != null) {
      PageRequest pageRequest = getPageRequest(pagingInfo);
      Page<H> results = findAll(zoneId, pageRequest);
      if (results != null) {
        List<S> sifResultObjects = getConverter().toSifModelList(results.getContent());
        result = getCollectionResult(sifResultObjects);
      }
    }
    return result;
  }

  private Page<H> findAll(String zoneId, PageRequest pageRequest) {
    Page<H> result = null;
    if (StringUtils.isNotBlank(zoneId)) {
      result = getFilterableDAO().findAllWithZone(zoneId, pageRequest);
    }
    return result;
  }

  /**
   * Query by Example
   * 
   * @param example
   * @param zoneId
   * @param pagingInfo
   * @return
   * @throws UnsupportedQueryException
   */
  public SC findByExample(S example, String zoneId, PagingInfo pagingInfo) throws UnsupportedQueryException {
    SC result = null;
    if (pagingInfo != null) {
      PageRequest pageRequest = getPageRequest(pagingInfo);
      Page<H> results = findByExample(example, zoneId, pageRequest);
      if (results != null) {
        List<S> sifResultObjects = getConverter().toSifModelList(results.getContent());
        result = getCollectionResult(sifResultObjects);
      }
    }
    return result;
  }

  protected Page<H> findByExample(S example, String zoneId, PageRequest pageRequest) throws UnsupportedQueryException {
    FilterableRepository<H> filterableRepository = getFilterableDAO();
    if (filterableRepository != null) {
      H exampleModel = getConverter().toHitsModel(example);
      if (StringUtils.isNotBlank(zoneId)) {
        return filterableRepository.findAllWithExample(exampleModel, zoneId, pageRequest);
      }
    }
    throw new UnsupportedQueryException("Query by example not supported for this object.");
  }

  /**
   * Service Path Query
   * 
   * @param filters
   * @param pagingInfo
   * @param zoneId
   * @return
   * @throws UnsupportedQueryException
   */
  public SC findByServicePath(List<KeyValuePair> filters, PagingInfo pagingInfo, String zoneId) throws UnsupportedQueryException {
    SC result = null;
    if (pagingInfo != null) {
      PageRequest pageRequest = getPageRequest(pagingInfo);
      if (StringUtils.isNotBlank(zoneId)) {
        Page<H> results = findByServicePath(filters, zoneId, pageRequest);
        if (results != null) {
          List<S> sifResultObjects = getConverter().toSifModelList(results.getContent());
          result = getCollectionResult(sifResultObjects);
        }
      }
    }
    return result;
  }

  protected Page<H> findByServicePath(List<KeyValuePair> filters, String zoneId, PageRequest pageRequest) throws UnsupportedQueryException {
    FilterableRepository<H> filterableRepository = getFilterableDAO();
    if (filterableRepository != null) {
      if (StringUtils.isNotBlank(zoneId)) {
        return filterableRepository.findAllWithServicePaths(filters, zoneId, pageRequest);
      }
    }
    throw new UnsupportedQueryException("Service path filter not supported for this service path.");
  }

  // Read
  public S get(String refId, String zoneId) {
    L.error(refId + " : " + zoneId);
    S result = null;

    if (!StringUtils.isEmpty(refId)) {
      H hitsObject = getFilterableDAO().findOneWithZone(refId, zoneId);
      result = getConverter().toSifModel(hitsObject);
    }
    return result;
  }

  /**
   * Override this in objects that need child objects populated!
   * 
   * @param hitsObject
   * @param dto
   * @param zoneId
   * @throws PersistenceException
   */
  public H save(H hitsObject, RequestDTO<S> dto, String zoneId, boolean create) {
    H result = preSave(hitsObject, dto, zoneId, create);
    if (!create) {
      deleteChildObjects(hitsObject);
    }
    if (hasChildObjects(hitsObject)) {
      result = saveWithChildObjects(hitsObject, dto, zoneId, create);
    } else {
      result = getDAO().save(hitsObject);
    }
    return result;
  }

  /**
   * Override this to implement pre-save actions.
   * 
   * @param hitsObject
   */
  protected H preSave(H hitsObject, RequestDTO<S> dto, String zoneId, boolean create) {
    return null;
  }

  /**
   * Override this for objects that need child objects managed
   * 
   * @param hitsObject
   * @return
   */
  protected boolean hasChildObjects(H hitsObject) {
    return false;
  }

  /**
   * Override this for objects that need child objects managed
   * 
   * @param hitsObject
   * @param dto
   * @param zoneId
   * @param create
   * @return
   */
  protected H saveWithChildObjects(H hitsObject, RequestDTO<S> dto, String zoneId, boolean create) {
    return getDAO().save(hitsObject);
  }

  public void setDatabaseContext(String applicationKey) {
    HitsDatabaseContext.clearDatabase();
    ApplicationKeyUrl applicationKeyUrl = applicationKeyUrlService.getApplicationKeyUrl(applicationKey);
    currentApplicationKeyUrl.set(applicationKeyUrl);
    L.info("Setting current database : " + applicationKeyUrl.getDatabaseUrl());
    HitsDatabaseContext.setDatabase(applicationKeyUrl.getDatabaseUrl());
  }

  // Update
  public ResponseDTO<S> updateSingle(RequestDTO<S> dto, String zoneId) {
    ResponseDTO<S> result = null;
    if (StringUtils.isEmpty(dto.getAdvisoryId()) || StringUtils.equals(dto.getAdvisoryId(), dto.getRefId())) {
      if (!StringUtils.isEmpty(dto.getRefId())) {
        H hitsObject = getDAO().findOne(dto.getRefId());
        if (hitsObject != null) {
          getConverter().toHitsModel(dto.getSifObject(), hitsObject);
          H savedHitsObject = save(hitsObject, dto, zoneId, false);
          S resultObject = getConverter().toSifModel(savedHitsObject);
          result = new ResponseDTO<S>(dto, resultObject, UPDATE_OK);
        } else {
          result = new ResponseDTO<S>(dto, null, UPDATE_ERR_NO_OBJECT);
        }
      } else {
        result = new ResponseDTO<S>(dto, null, UPDATE_ERR_NO_OBJECT);
      }
    } else {
      result = new ResponseDTO<S>(dto, null, UPDATE_ERR_REFID_MISMATCH);
    }
    return result;
  }

  private PageRequest getPageRequest(PagingInfo pagingInfo) {
    return new PageRequest(pagingInfo.getCurrentPageNo() - CommonConstants.FIRST_PAGE, pagingInfo.getPageSize());
  }

  private SC getCollectionResult(List<S> items) {
    if (items == null || items.isEmpty()) {
      return null;
    } else {
      return getCollection(items);
    }
  }
}
