package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NAPStudentResponseSet_Testlet")
public class TestletResponse extends HitsEntity {
  private static final long serialVersionUID = 8443601175565321986L;

  private Integer id;
  private NAPStudentResponseSet napStudentResponseSet;
  private NAPTestlet testlet;
  private String testletScore;
  private Set<TestItemResponse> itemList;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "NAPStudentResponseSet_RefId")
  public NAPStudentResponseSet getNapStudentResponseSet() {
    return napStudentResponseSet;
  }

  public void setNapStudentResponseSet(NAPStudentResponseSet napStudentResponseSet) {
    this.napStudentResponseSet = napStudentResponseSet;
  }

  @ManyToOne
  @JoinColumn(name = "NAPTestlet_RefId")
  public NAPTestlet getTestlet() {
    return testlet;
  }

  public void setTestlet(NAPTestlet testlet) {
    this.testlet = testlet;
  }

  public String getTestletScore() {
    return testletScore;
  }

  public void setTestletScore(String testletScore) {
    this.testletScore = testletScore;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "testletResponse")
  public Set<TestItemResponse> getItemList() {
    return itemList;
  }

  public void setItemList(Set<TestItemResponse> itemList) {
    this.itemList = itemList;
  }

}
