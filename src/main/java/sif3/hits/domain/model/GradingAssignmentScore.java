package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GradingAssignmentScore extends HitsEntity {
  private static final long serialVersionUID = -3213907137521577365L;

  private String refId;
  private StudentPersonal studentPersonal;
  private TeachingGroup teachingGroup;
  private String gradingAssignmentRefId;
  private String scorePoints;
  private String scorePercent;
  private String scoreLetter;
  private String scoreDescription;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @ManyToOne
  @JoinColumn(name = "StudentPersonal_RefId")
  public StudentPersonal getStudentPersonal() {
    return studentPersonal;
  }
  
  public void setStudentPersonal(StudentPersonal studentPersonal) {
    this.studentPersonal = studentPersonal;
  }

  @ManyToOne
  @JoinColumn(name = "TeachingGroup_RefId")
  public TeachingGroup getTeachingGroup() {
    return teachingGroup;
  }

  public void setTeachingGroup(TeachingGroup teachingGroup) {
    this.teachingGroup = teachingGroup;
  }

  @Column(name = "GradingAssignment_RefId")
  public String getGradingAssignmentRefId() {
    return gradingAssignmentRefId;
  }

  public void setGradingAssignmentRefId(String gradingAssignmentRefId) {
    this.gradingAssignmentRefId = gradingAssignmentRefId;
  }

  public String getScorePoints() {
    return scorePoints;
  }

  public void setScorePoints(String scorePoints) {
    this.scorePoints = scorePoints;
  }

  public String getScorePercent() {
    return scorePercent;
  }

  public void setScorePercent(String scorePercent) {
    this.scorePercent = scorePercent;
  }

  public String getScoreLetter() {
    return scoreLetter;
  }

  public void setScoreLetter(String scoreLetter) {
    this.scoreLetter = scoreLetter;
  }

  public String getScoreDescription() {
    return scoreDescription;
  }

  public void setScoreDescription(String scoreDescription) {
    this.scoreDescription = scoreDescription;
  }
}