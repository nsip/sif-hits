package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NAPTestItem_Stimulus")
public class Stimulus extends HitsEntity {
  private static final long serialVersionUID = -2682443119027651114L;

  private Integer id;
  private NAPTestItem testItem;
  private String content;
  private String descriptor;
  private String domain;
  private String localId;
  private String stimulusType;
  private String textGenre;
  private String textType;
  private String wordCount;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  @ManyToOne(optional = false)
  @JoinColumn(name = "NAPTestItem_RefId")
  public NAPTestItem getTestItem() {
    return testItem;
  }
  
  public void setTestItem(NAPTestItem testItem) {
    this.testItem = testItem;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDescriptor() {
    return descriptor;
  }

  public void setDescriptor(String descriptor) {
    this.descriptor = descriptor;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getStimulusType() {
    return stimulusType;
  }

  public void setStimulusType(String stiumulusType) {
    this.stimulusType = stiumulusType;
  }

  public String getTextGenre() {
    return textGenre;
  }

  public void setTextGenre(String textGenre) {
    this.textGenre = textGenre;
  }

  public String getTextType() {
    return textType;
  }

  public void setTextType(String textType) {
    this.textType = textType;
  }

  public String getWordCount() {
    return wordCount;
  }

  public void setWordCount(String wordCount) {
    this.wordCount = wordCount;
  }
}
