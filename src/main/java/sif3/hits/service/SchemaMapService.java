package sif3.hits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sif3.hits.domain.dao.SchemaMapDAO;
import sif3.hits.domain.model.SchemaMap;

@Service
public class SchemaMapService {
  
  @Autowired
  private SchemaMapDAO schemaMapDAO;
  
  public String getDatabaseUrl(String zoneId, String contextId) {
    String result = null;
    SchemaMap schemaMap = schemaMapDAO.findOneWithZoneIdAndContextId(zoneId, contextId);
    if (schemaMap == null && contextId != null) {
      schemaMap = schemaMapDAO.findDefaultForZone(zoneId);
    }
    if (schemaMap == null) {
      schemaMap = schemaMapDAO.findDefault();
    }
    if (schemaMap != null) {
      result = schemaMap.getDatabaseUrl();
    }
    return result;
  }
  
}
