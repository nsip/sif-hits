package sif3.hits.service;

import static sif3.hits.service.e.OperationStatus.CREATE_ERR_EXISTS;
import static sif3.hits.service.e.OperationStatus.CREATE_ERR_NO_ADVISORY;
import static sif3.hits.service.e.OperationStatus.CREATE_OK;
import static sif3.hits.service.e.OperationStatus.DELETE_ERR_NO_OBJECT;
import static sif3.hits.service.e.OperationStatus.DELETE_OK;
import static sif3.hits.service.e.OperationStatus.UPDATE_ERR_NO_OBJECT;
import static sif3.hits.service.e.OperationStatus.UPDATE_OK;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sif3.common.exception.PersistenceException;
import sif3.common.model.PagingInfo;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.helper.HitsDatabaseContext;
import sif3.hits.domain.shared.model.Zone;
import sif3.hits.rest.dto.RequestDTO;
import sif3.hits.rest.dto.ResponseDTO;
import sif3.hits.rest.exception.NotYetImplementedException;
import au.com.systemic.framework.utils.StringUtils;

@Transactional(value = "transactionManager")
public abstract class BaseService<S, SC, H> {

  private static final Logger L = LoggerFactory.getLogger(BaseService.class);

  public abstract JpaRepository<H, String> getDAO();

  public abstract ZoneFilterableRepository<H> getZoneFilterableDAO();

  public abstract HitsConverter<S, H> getConverter();

  @Autowired
  private ZoneService zoneService;
  
  private final ThreadLocal<Zone> currentZone = new ThreadLocal<Zone>();

  public void setDatabaseContext(String zoneId, String contextId) {
    HitsDatabaseContext.clearDatabase();
    Zone zone = zoneService.getZone(zoneId, contextId);
    currentZone.set(zone);
    L.info("Setting current database : " + zone.getDatabaseUrl());
    HitsDatabaseContext.setDatabase(zone.getDatabaseUrl());
  }

  // Create
  public ResponseDTO<S> createSingle(RequestDTO<S> dto, String zoneId) throws PersistenceException {
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

  // Read
  public S get(String refId, String zoneId) {
    S result = null;
    if (!StringUtils.isEmpty(refId)) {
      H hitsObject = getFiltered(refId, zoneId);
      result = getConverter().toSifModel(hitsObject);
    }
    return result;
  }

  // Read All
  public SC findAll(PagingInfo pagingInfo, String zoneId) {
    SC result = getCollection(new ArrayList<S>());
    if (pagingInfo != null) {
      PageRequest pageRequest = new PageRequest(pagingInfo.getCurrentPageNo(), pagingInfo.getPageSize());
      Page<H> results = findAll(getSchoolRefIds(zoneId), pageRequest);
      if (results != null) {
        List<S> sifResultObjects = getConverter().toSifModelList(results.getContent());
        result = getCollection(sifResultObjects);
      }
    }
    return result;
  }
  
  // Read All
  public SC findWithServicePath(String parentName, String parentKey, PagingInfo pagingInfo, String zoneId) throws NotYetImplementedException {
    SC result = getCollection(new ArrayList<S>());
    if (pagingInfo != null) {
      PageRequest pageRequest = new PageRequest(pagingInfo.getCurrentPageNo(), pagingInfo.getPageSize());
      Page<H> results = findWithServicePath(parentName, parentKey, getSchoolRefIds(zoneId), pageRequest);
      if (results != null) {
        List<S> sifResultObjects = getConverter().toSifModelList(results.getContent());
        result = getCollection(sifResultObjects);
      }
    }
    return result;
  }
  
  /**
   * Find with Service path
   * Override this in service layer to provide service path filtering.
   * @param parentName
   * @param parentKey
   * @param schoolRefIds
   * @param pageRequest
   * @return
   * @throws NotYetImplementedException 
   */
  protected Page<H> findWithServicePath(String parentName, String parentKey, List<String> schoolRefIds, PageRequest pageRequest) throws NotYetImplementedException {
    throw new NotYetImplementedException();
  }

  // Update
  public ResponseDTO<S> updateSingle(RequestDTO<S> dto, String zoneId) throws PersistenceException {
    ResponseDTO<S> result = null;
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
    return result;
  }

  // Delete
  public ResponseDTO<S> deleteSingle(RequestDTO<S> dto, String zoneId) {
    ResponseDTO<S> result = null;
    if (!StringUtils.isEmpty(dto.getRefId())) {
      H hitsObject = getDAO().findOne(dto.getRefId());
      if (hitsObject != null) {
        delete(hitsObject, dto);
        result = new ResponseDTO<S>(dto, null, DELETE_OK);
      } else {
        result = new ResponseDTO<S>(dto, null, DELETE_ERR_NO_OBJECT);
      }
    } else {
      result = new ResponseDTO<S>(dto, null, DELETE_ERR_NO_OBJECT);
    }
    return result;
  }

  private Page<H> findAll(List<String> schoolRefIds, PageRequest pageRequest) {
    Page<H> result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = getZoneFilterableDAO().findAllWithFilter(schoolRefIds, pageRequest);
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
  protected H save(H hitsObject, RequestDTO<S> dto, String zoneId, boolean create) throws PersistenceException {
    return getDAO().save(hitsObject);
  }

  /**
   * Override this in services that need child objects managed.
   * 
   * @param hitsObject
   * @param dto
   */
  protected void delete(H hitsObject, RequestDTO<S> dto) {
    getDAO().delete(hitsObject);
  }

  protected abstract SC getCollection(List<S> items);

  protected abstract H getFiltered(String refId, List<String> schoolRefIds);

  protected H getFiltered(String refId, String zoneId) {
    List<String> schoolRefIds = getSchoolRefIds(zoneId);
    return getFiltered(refId, schoolRefIds);
  }

  protected List<String> getSchoolRefIds(String zoneId) {
    List<String> result = new ArrayList<String>();
    if (currentZone.get() != null && currentZone.get().getSchoolRefIds() != null && currentZone.get().getSchoolRefIds().size() > 0) {
      result = currentZone.get().getSchoolRefIds();
    } else {
//      result.add(zoneId);
    }
    return result;
  }
}
