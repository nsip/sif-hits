package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "HITS_SCHEMA_MAP")
public class SchemaMap implements Serializable {
  private static final long serialVersionUID = 1353507158086603487L;

  private Long id;
  private String zoneId;
  private String contextId;
  private String databaseUrl;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  public String getContextId() {
    return contextId;
  }

  public void setContextId(String contextId) {
    this.contextId = contextId;
  }

  public String getDatabaseUrl() {
    return databaseUrl;
  }

  public void setDatabaseUrl(String databaseUrl) {
    this.databaseUrl = databaseUrl;
  }
}
