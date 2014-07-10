package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumer")
public class Consumer extends HitsEntity {
  private static final long serialVersionUID = -4073993922304395900L;

  private String consumerKey;
  private String consumerSecret;

  @Id
  @Column(name = "consumer_key")
  public String getConsumerKey() {
    return consumerKey;
  }

  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
  }

  @Column(name = "consumer_secret")
  public String getConsumerSecret() {
    return consumerSecret;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }
}
