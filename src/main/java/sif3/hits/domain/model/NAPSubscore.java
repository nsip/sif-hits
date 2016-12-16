package sif3.hits.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NAPStudentResponseSet_Testlet_TestItem_Subscore")
public class NAPSubscore {
  private Integer id;
  private TestItemResponse testItemResponse;
  private String subscoreType;
  private String subscoreValue;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "ResponseTestItem_Id")
  public TestItemResponse getTestItemResponse() {
    return testItemResponse;
  }

  public void setTestItemResponse(TestItemResponse testItemResponse) {
    this.testItemResponse = testItemResponse;
  }

  public String getSubscoreType() {
    return subscoreType;
  }

  public void setSubscoreType(String subscoreType) {
    this.subscoreType = subscoreType;
  }

  public String getSubscoreValue() {
    return subscoreValue;
  }

  public void setSubscoreValue(String subscoreValue) {
    this.subscoreValue = subscoreValue;
  }

}
