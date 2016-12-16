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
@Table(name = "NAPTestItem_NAPWritingRubric_Score")
public class Score extends HitsEntity {
  private static final long serialVersionUID = -8858520090601059014L;

  private Integer id;
  private NAPWritingRubric napWritingRubric;
  private String maxScoreValue;
  private Set<ScoreDescription> scoreDescriptionList;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "NAPWritingRubric_Id")
  public NAPWritingRubric getNapWritingRubric() {
    return napWritingRubric;
  }

  public void setNapWritingRubric(NAPWritingRubric napWritingRubric) {
    this.napWritingRubric = napWritingRubric;
  }

  public String getMaxScoreValue() {
    return maxScoreValue;
  }

  public void setMaxScoreValue(String maxScoreValue) {
    this.maxScoreValue = maxScoreValue;
  }

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "score", orphanRemoval = true)
  public Set<ScoreDescription> getScoreDescriptionList() {
    return scoreDescriptionList;
  }

  public void setScoreDescriptionList(Set<ScoreDescription> scoreDescriptionList) {
    this.scoreDescriptionList = scoreDescriptionList;
  }

}
