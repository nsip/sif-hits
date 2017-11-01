package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NAPStudentResponseSet_DomainScore")
public class DomainScore {

  @Id
  @GeneratedValue
  private Integer id;
  private NAPStudentResponseSet napStudentResponseSet;

  private String rawScore;
  private String scaledScoreStandardError;
  private String scaledScoreValue;
  private String studentDomainBand;
  private String studentProficiency;

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

  public String getRawScore() {
    return rawScore;
  }

  public void setRawScore(String rawScore) {
    this.rawScore = rawScore;
  }

  public String getScaledScoreStandardError() {
    return scaledScoreStandardError;
  }

  public void setScaledScoreStandardError(String scaledScoreStandardError) {
    this.scaledScoreStandardError = scaledScoreStandardError;
  }

  public String getScaledScoreValue() {
    return scaledScoreValue;
  }

  public void setScaledScoreValue(String scaledScoreValue) {
    this.scaledScoreValue = scaledScoreValue;
  }

  public String getStudentDomainBand() {
    return studentDomainBand;
  }

  public void setStudentDomainBand(String studentDomainBand) {
    this.studentDomainBand = studentDomainBand;
  }

  public String getStudentProficiency() {
    return studentProficiency;
  }

  public void setStudentProficiency(String studentProficiency) {
    this.studentProficiency = studentProficiency;
  }
}
