package sif3.hits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sif3.hits.domain.shared.dao.ZoneDAO;
import sif3.hits.domain.shared.model.Zone;

@Service
public class ZoneService {
  
  @Autowired
  private ZoneDAO zoneDAO;
  
  @Transactional(readOnly = true, value = "sharedTransactionManager")
  public String getDatabaseUrl(String zoneId, String contextId) {
    String result = null;
    Zone schemaMap = zoneDAO.findOneWithZoneIdAndContextId(zoneId, contextId);
    if (schemaMap == null && contextId != null) {
      schemaMap = zoneDAO.findDefaultForZone(zoneId);
    }
    if (schemaMap == null) {
      schemaMap = zoneDAO.findDefault();
    }
    if (schemaMap != null) {
      result = schemaMap.getDatabaseUrl();
    }
    return result;
  }
  
}
