package sif3.hits.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NAPTestlet_TestItem")
public class NAPTestletTestItem {

  private Integer id;
  private NAPTestlet napTestlet;
  private NAPTestItem napTestItem;
  private Integer testletTestItemSequence;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "NAPTestlet_RefId")
  public NAPTestlet getNapTestlet() {
    return napTestlet;
  }

  public void setNapTestlet(NAPTestlet napTestlet) {
    this.napTestlet = napTestlet;
  }

  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "NAPTestItem_RefId")
  public NAPTestItem getNapTestItem() {
    return napTestItem;
  }

  public void setNapTestItem(NAPTestItem napTestItem) {
    this.napTestItem = napTestItem;
  }

  @Column(name = "NAPTestlet_NAPTestItem_Sequence")
  public Integer getTestletTestItemSequence() {
    return testletTestItemSequence;
  }

  public void setTestletTestItemSequence(Integer testletTestItemSequence) {
    this.testletTestItemSequence = testletTestItemSequence;
  }
}
