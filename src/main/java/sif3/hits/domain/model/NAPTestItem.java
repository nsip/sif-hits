package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class NAPTestItem extends HitsEntity {
  private static final long serialVersionUID = -8756483105166456147L;

  private String refId;
  private String localId;
  private String correctAnswer;
  private String exemplarURL;
  private String itemDescriptor;
  private String itemType;
  private String itemDifficulty;
  private String itemDifficultyLogit5;
  private String itemDifficultyLogit5SE;
  private String itemDifficultyLogit62;
  private String itemDifficultyLogit62SE;
  private String itemProficiencyBand;
  private String itemProficiencyLevel;
  private String markingType;
  private String maximumScore;
  private String multipleChoiceOptionCount;
  private String releasedStatus;
  private String subdomain;
  private String writingGenre;

  private Set<Stimulus> stimulusList;
  private Set<String> contentDescriptionList;
  private Set<NAPWritingRubric> writingRubricList;
  private Set<SubstituteItem> itemSubstitutedForList;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public String getExemplarURL() {
    return exemplarURL;
  }

  public void setExemplarURL(String exemplarURL) {
    this.exemplarURL = exemplarURL;
  }

  public String getItemDescriptor() {
    return itemDescriptor;
  }

  public void setItemDescriptor(String itemDescriptor) {
    this.itemDescriptor = itemDescriptor;
  }
  
  public String getItemType() {
    return itemType;
  }
  
  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public String getItemDifficulty() {
    return itemDifficulty;
  }

  public void setItemDifficulty(String itemDifficulty) {
    this.itemDifficulty = itemDifficulty;
  }
  
  public String getItemDifficultyLogit5() {
    return itemDifficultyLogit5;
  }

  public void setItemDifficultyLogit5(String itemDifficultyLogit5) {
    this.itemDifficultyLogit5 = itemDifficultyLogit5;
  }

  public String getItemDifficultyLogit5SE() {
    return itemDifficultyLogit5SE;
  }

  public void setItemDifficultyLogit5SE(String itemDifficultyLogit5SE) {
    this.itemDifficultyLogit5SE = itemDifficultyLogit5SE;
  }

  public String getItemDifficultyLogit62() {
    return itemDifficultyLogit62;
  }

  public void setItemDifficultyLogit62(String itemDifficultyLogit62) {
    this.itemDifficultyLogit62 = itemDifficultyLogit62;
  }

  public String getItemDifficultyLogit62SE() {
    return itemDifficultyLogit62SE;
  }

  public void setItemDifficultyLogit62SE(String itemDifficultyLogit62SE) {
    this.itemDifficultyLogit62SE = itemDifficultyLogit62SE;
  }

  public String getItemProficiencyBand() {
    return itemProficiencyBand;
  }

  public void setItemProficiencyBand(String itemProficiencyBand) {
    this.itemProficiencyBand = itemProficiencyBand;
  }
  
  public String getItemProficiencyLevel() {
    return itemProficiencyLevel;
  }
  
  public void setItemProficiencyLevel(String itemProficiencyLevel) {
    this.itemProficiencyLevel = itemProficiencyLevel;
  }

  public String getMarkingType() {
    return markingType;
  }

  public void setMarkingType(String markingType) {
    this.markingType = markingType;
  }

  public String getMaximumScore() {
    return maximumScore;
  }

  public void setMaximumScore(String maximumScore) {
    this.maximumScore = maximumScore;
  }
  
  public String getMultipleChoiceOptionCount() {
    return multipleChoiceOptionCount;
  }
  
  public void setMultipleChoiceOptionCount(String multipleChoiceOptionCount) {
    this.multipleChoiceOptionCount = multipleChoiceOptionCount;
  }

  public String getReleasedStatus() {
    return releasedStatus;
  }

  public void setReleasedStatus(String releasedStatus) {
    this.releasedStatus = releasedStatus;
  }

  public String getSubdomain() {
    return subdomain;
  }

  public void setSubdomain(String subdomain) {
    this.subdomain = subdomain;
  }

  public String getWritingGenre() {
    return writingGenre;
  }

  public void setWritingGenre(String writingGenre) {
    this.writingGenre = writingGenre;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "testItem" )
  public Set<Stimulus> getStimulusList() {
    return stimulusList;
  }

  public void setStimulusList(Set<Stimulus> stimulusList) {
    this.stimulusList = stimulusList;
  }

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "NAPTestItem_ContentDescription", joinColumns = @JoinColumn(name = "NAPTestItem_RefId"))
  @Column(name = "ContentDescription")
  public Set<String> getContentDescriptionList() {
    return contentDescriptionList;
  }

  public void setContentDescriptionList(Set<String> contentDescriptionList) {
    this.contentDescriptionList = contentDescriptionList;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "napTestItem")
  public Set<NAPWritingRubric> getWritingRubricList() {
    return writingRubricList;
  }

  public void setWritingRubricList(Set<NAPWritingRubric> writingRubricList) {
    this.writingRubricList = writingRubricList;
  }
  
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "napTestItem")
  public Set<SubstituteItem> getItemSubstitutedForList() {
    return itemSubstitutedForList;
  }

  public void setItemSubstitutedForList(Set<SubstituteItem> itemSubstitutedForList) {
    this.itemSubstitutedForList = itemSubstitutedForList;
  }
}