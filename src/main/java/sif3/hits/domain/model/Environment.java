package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "environment")
public class Environment extends HitsEntity {
  private static final long serialVersionUID = -5641755250754752337L;

  private String id;
  private Consumer consumer;
  private String sessionToken;
  private String zoneId;

  @Id
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "consumer_key", referencedColumnName = "consumer_key")
  public Consumer getConsumer() {
    return consumer;
  }

  public void setConsumer(Consumer consumer) {
    this.consumer = consumer;
  }

  public String getSessionToken() {
    return sessionToken;
  }

  public void setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
  }

  @Column(name = "zone_id")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }
}
