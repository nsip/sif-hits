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
@Table(name = "NAPTestItem_NAPWritingRubric_Score_ScoreDescription")
public class ScoreDescription {
  private Integer id;
  private Score score;
  private String descriptor;
  private String scoreCommentCode;
  private String scoreValue;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "Score_Id")
  public Score getScore() {
    return score;
  }

  public void setScore(Score score) {
    this.score = score;
  }

  public String getDescriptor() {
    return descriptor;
  }

  public void setDescriptor(String descriptor) {
    this.descriptor = descriptor;
  }

  public String getScoreCommentCode() {
    return scoreCommentCode;
  }

  public void setScoreCommentCode(String scoreCommentCode) {
    this.scoreCommentCode = scoreCommentCode;
  }

  public String getScoreValue() {
    return scoreValue;
  }

  public void setScoreValue(String scoreValue) {
    this.scoreValue = scoreValue;
  }
}
