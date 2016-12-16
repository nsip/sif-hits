package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NAPStudentResponseSet_Testlet_TestItem")
public class TestItemResponse {
  private Integer id;
  private TestletResponse testletResponse;
  private NAPTestItem testItem;
  private Set<NAPSubscore> subscoreList;

  private String itemWeight;
  private String response;
  private String responseCorrectness;
  private String score;
  private String lapsedTimeItem;
  private Integer sequenceNumber;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "ResponseTestlet_Id")
  public TestletResponse getTestletResponse() {
    return testletResponse;
  }

  public void setTestletResponse(TestletResponse testletResponse) {
    this.testletResponse = testletResponse;
  }

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "NAPTestItem_RefId")
  public NAPTestItem getTestItem() {
    return testItem;
  }

  public void setTestItem(NAPTestItem testItem) {
    this.testItem = testItem;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "testItemResponse", orphanRemoval = true)
  public Set<NAPSubscore> getSubscoreList() {
    return subscoreList;
  }

  public void setSubscoreList(Set<NAPSubscore> subscoreList) {
    this.subscoreList = subscoreList;
  }

  public String getItemWeight() {
    return itemWeight;
  }

  public void setItemWeight(String itemWeight) {
    this.itemWeight = itemWeight;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getResponseCorrectness() {
    return responseCorrectness;
  }

  public void setResponseCorrectness(String responseCorrectness) {
    this.responseCorrectness = responseCorrectness;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public String getLapsedTimeItem() {
    return lapsedTimeItem;
  }
  
  public void setLapsedTimeItem(String lapsedTimeItem) {
    this.lapsedTimeItem = lapsedTimeItem;
  }

  public Integer getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }
}
