package sif3.hits.rest.dto;

import java.io.Serializable;

public class RequestDTO<S> implements Serializable {
  private static final long serialVersionUID = -8643504363564519303L;

  private String advisoryId;
  private String refId;
  private S sifObject;
  private Boolean useAdvisory;

  public RequestDTO(String advisoryId, String refId, Boolean useAdvisory, S sifObject) {
    this.advisoryId = advisoryId;
    this.refId = refId;
    this.sifObject = sifObject;
    this.useAdvisory = useAdvisory;
  }

  public String getAdvisoryId() {
    return advisoryId;
  }

  public void setAdvisoryId(String advisoryId) {
    this.advisoryId = advisoryId;
  }

  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public S getSifObject() {
    return sifObject;
  }

  public void setSifObject(S sifObject) {
    this.sifObject = sifObject;
  }

  public Boolean getUseAdvisory() {
    return useAdvisory;
  }

  public void setUseAdvisory(Boolean useAdvisory) {
    this.useAdvisory = useAdvisory;
  }
}
