package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GradingAssignment extends HitsEntity {
  private static final long serialVersionUID = -7781721434979201900L;

  private String refId;
  private TeachingGroup teachingGroup;
  private String gradingCategory;
  private String description;
  private String pointsPossible;
  private String createDate;
  private String dueDate;
  private String weight;
  private String maxAttemptsAllowed;
  private String detailedDescriptionURL;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @ManyToOne
  @JoinColumn(name = "TeachingGroup_RefId")
  public TeachingGroup getTeachingGroup() {
    return teachingGroup;
  }

  public void setTeachingGroup(TeachingGroup teachingGroup) {
    this.teachingGroup = teachingGroup;
  }

  public String getGradingCategory() {
    return gradingCategory;
  }

  public void setGradingCategory(String gradingCategory) {
    this.gradingCategory = gradingCategory;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPointsPossible() {
    return pointsPossible;
  }

  public void setPointsPossible(String pointsPossible) {
    this.pointsPossible = pointsPossible;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getMaxAttemptsAllowed() {
    return maxAttemptsAllowed;
  }

  public void setMaxAttemptsAllowed(String maxAttemptsAllowed) {
    this.maxAttemptsAllowed = maxAttemptsAllowed;
  }

  public String getDetailedDescriptionURL() {
    return detailedDescriptionURL;
  }

  public void setDetailedDescriptionURL(String detailedDescriptionURL) {
    this.detailedDescriptionURL = detailedDescriptionURL;
  }
}
