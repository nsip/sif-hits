package sif3.hits.domain.shared.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Zone implements Serializable {
  private static final long serialVersionUID = 1353507158086603487L;

  private Long id;
  private String zoneId;
  private String contextId;
  private String databaseUrl;
  private List<String> schoolRefIds;

  @Id
  @GeneratedValue
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
  
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "Zone_School", joinColumns = { @JoinColumn(name="zone_id") } )
  @Column(name = "SchoolInfo_RefId")
  public List<String> getSchoolRefIds() {
    return schoolRefIds;
  }
  
  public void setSchoolRefIds(List<String> schoolRefIds) {
    this.schoolRefIds = schoolRefIds;
  }
}
