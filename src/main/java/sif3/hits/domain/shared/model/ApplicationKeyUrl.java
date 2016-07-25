package sif3.hits.domain.shared.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPKEY_DB_URL_MAPPER")
public class ApplicationKeyUrl {
  private Long id;
  private String applicationKey;
  private String url;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getApplicationKey() {
    return applicationKey;
  }

  public void setApplicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
