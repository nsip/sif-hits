package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NAPTestlet extends HitsEntity {
  private static final long serialVersionUID = -7786504144016316410L;

  private String refId;
  private String localId;
  private String testletName;
  private String testletMaximumScore;
  private String node;
  private String locationInStage;

  private NAPTest napTest;
  private Set<NAPTestletTestItem> testItems;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getTestletName() {
    return testletName;
  }

  public void setTestletName(String testletName) {
    this.testletName = testletName;
  }

  public String getTestletMaximumScore() {
    return testletMaximumScore;
  }

  public void setTestletMaximumScore(String testletMaximumScore) {
    this.testletMaximumScore = testletMaximumScore;
  }

  public String getNode() {
    return node;
  }

  public void setNode(String node) {
    this.node = node;
  }

  public String getLocationInStage() {
    return locationInStage;
  }

  public void setLocationInStage(String locationInStage) {
    this.locationInStage = locationInStage;
  }

  @ManyToOne
  @JoinColumn(name = "NAPTest_RefId")
  public NAPTest getNapTest() {
    return napTest;
  }

  public void setNapTest(NAPTest napTest) {
    this.napTest = napTest;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "napTestlet")
  public Set<NAPTestletTestItem> getTestItems() {
    return testItems;
  }

  public void setTestItems(Set<NAPTestletTestItem> testItems) {
    this.testItems = testItems;
  }
}