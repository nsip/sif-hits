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
  public Zone getZone(String zoneId, String contextId) {
    Zone result = null;
    Zone zone = zoneDAO.findOneWithZoneIdAndContextId(zoneId, contextId);
    if (zone == null && contextId != null) {
      zone = zoneDAO.findDefaultForZone(zoneId);
    }
    if (zone == null) {
      zone = zoneDAO.findDefault();
    }
    if (zone != null) {
      result = zone;
    }
    return result;
  }
}
