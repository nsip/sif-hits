package sif3.hits.service;

import static sif3.hits.service.e.OperationStatus.CREATE_ERR_EXISTS;
import static sif3.hits.service.e.OperationStatus.CREATE_ERR_NO_ADVISORY;
import static sif3.hits.service.e.OperationStatus.CREATE_ERR_ZONE;
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
import sif3.hits.domain.dao.ZoneDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.helper.HitsDatabaseContext;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.ZoneFilterable;
import sif3.hits.rest.dto.RequestDTO;
import sif3.hits.rest.dto.ResponseDTO;
import au.com.systemic.framework.utils.StringUtils;

@Transactional(value = "transactionManager")
public abstract class BaseService<S, SC, H> {

  @Autowired
  private ZoneDAO zoneDAO;

  private static final Logger L = LoggerFactory.getLogger(BaseService.class);

  public abstract JpaRepository<H, String> getDAO();

  public abstract ZoneFilterableRepository<H> getZoneFilterableDAO();

  public abstract HitsConverter<S, H> getConverter();

  @Autowired
  private SchemaMapService schemaMapService;

  public void setDatabaseContext(String zoneId, String contextId) {
    HitsDatabaseContext.clearDatabase();
    String database = schemaMapService.getDatabaseUrl(zoneId, contextId);
    L.info("Setting current database : " + database);
    HitsDatabaseContext.setDatabase(database);
  }

  // Create
  public ResponseDTO<S> createSingle(RequestDTO<S> dto, String zoneId) throws PersistenceException {
    ResponseDTO<S> result = null;
    if (!StringUtils.isEmpty(dto.getRefId())) {
      H checkExists = getDAO().findOne(dto.getRefId());
      if (checkExists == null) {
        H hitsObject = getConverter().toHitsModel(dto.getSifObject());
        boolean zone = assignZoneId(hitsObject, zoneId);
        if (zone) {
          H savedHitsObject = save(hitsObject, dto, zoneId, true);
          S resultObject = getConverter().toSifModel(savedHitsObject);
          result = new ResponseDTO<S>(dto, resultObject, CREATE_OK);
        } else {
          result = new ResponseDTO<S>(dto, null, CREATE_ERR_ZONE);
        }
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
   * Override this to manage different zone id linkage.
   * 
   * @param hitsObject
   * @param zoneId
   * @return
   */
  protected boolean assignZoneId(H hitsObject, String zoneId) {
    boolean result = false;
    if (hitsObject instanceof ZoneFilterable) {
      ZoneFilterable zoneFilterableObject = (ZoneFilterable) hitsObject;
      List<String> schoolRefIds = getSchoolRefIds(zoneId);
      if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
        // TODO: Derive this somehow? Currently assuming zone:school is 1:1
        zoneFilterableObject.setSchoolInfoRefId(schoolRefIds.get(0));
        result = true;
      }
    }
    return result;
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
    List<SchoolInfo> schools = zoneDAO.findByZoneId(zoneId);
    List<String> result = new ArrayList<String>();
    if (schools != null) {
      for (SchoolInfo school : schools) {
        result.add(school.getRefId());
      }
    }
    return result;
  }
}
