package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language extends HitsEntity {
  private static final long serialVersionUID = 561191501376411452L;

  private Integer recordNumber;
  private String personRefId;
  private String languageCode;
  private String languageType;
  private String languageDialect;

  @Id
  @GeneratedValue
  public Integer getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(Integer recordNumber) {
    this.recordNumber = recordNumber;
  }

  @Column(name = "Person_RefId")
  public String getPersonRefId() {
    return personRefId;
  }

  public void setPersonRefId(String personRefId) {
    this.personRefId = personRefId;
  }

  public String getLanguageCode() {
    return languageCode;
  }

  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  public String getLanguageType() {
    return languageType;
  }

  public void setLanguageType(String languageType) {
    this.languageType = languageType;
  }

  public String getLanguageDialect() {
    return languageDialect;
  }

  public void setLanguageDialect(String languageDialect) {
    this.languageDialect = languageDialect;
  }
}
