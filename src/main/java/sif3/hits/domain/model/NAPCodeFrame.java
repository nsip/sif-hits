package sif3.hits.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NAPCodeFrame extends HitsEntity {
  private static final long serialVersionUID = -9141348770659036388L;

  private String refId;
  private NAPTest napTest;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "NAPTest_RefId")
  public NAPTest getNapTest() {
    return napTest;
  }

  public void setNapTest(NAPTest napTest) {
    this.napTest = napTest;
  }
}
