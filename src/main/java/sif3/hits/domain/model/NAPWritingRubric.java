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
@Table(name = "NAPTestItem_NAPWritingRubric")
public class NAPWritingRubric extends HitsEntity {
  private static final long serialVersionUID = 2577085792832019766L;

  private Integer id;
  private NAPTestItem napTestItem;
  private String descriptor;
  private String rubricName;
  private String rubricType;
  private String scoringGuideReference;
  private Set<Score> scoreList;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "NAPTestItem_RefId")
  public NAPTestItem getNapTestItem() {
    return napTestItem;
  }

  public void setNapTestItem(NAPTestItem napTestItem) {
    this.napTestItem = napTestItem;
  }

  public String getDescriptor() {
    return descriptor;
  }

  public void setDescriptor(String descriptor) {
    this.descriptor = descriptor;
  }

  public String getRubricName() {
    return rubricName;
  }

  public void setRubricName(String rubricName) {
    this.rubricName = rubricName;
  }

  public String getRubricType() {
    return rubricType;
  }

  public void setRubricType(String rubricType) {
    this.rubricType = rubricType;
  }

  public String getScoringGuideReference() {
    return scoringGuideReference;
  }

  public void setScoringGuideReference(String scoringGuideReference) {
    this.scoringGuideReference = scoringGuideReference;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "napWritingRubric", orphanRemoval = true)
  public Set<Score> getScoreList() {
    return scoreList;
  }

  public void setScoreList(Set<Score> scoreList) {
    this.scoreList = scoreList;
  }

}
