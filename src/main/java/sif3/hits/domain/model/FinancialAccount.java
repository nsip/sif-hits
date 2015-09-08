package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinancialAccount extends HitsEntity {
  private static final long serialVersionUID = -3798203576566110357L;

  private String refId;
  private String subAccountRefId;
  private String locationInfoRefId;
  private String accountNumber;
  private String name;
  private String description;
  private String financialClassRefId;
  private String creationDate;
  private String creationTime;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "SubAccount_RefId")
  public String getSubAccountRefId() {
    return subAccountRefId;
  }

  public void setSubAccountRefId(String subAccountRefId) {
    this.subAccountRefId = subAccountRefId;
  }

  @Column(name = "LocationInfo_RefId")
  public String getLocationInfoRefId() {
    return locationInfoRefId;
  }

  public void setLocationInfoRefId(String locationInfoRefId) {
    this.locationInfoRefId = locationInfoRefId;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "FinancialClass_RefId")
  public String getFinancialClassRefId() {
    return financialClassRefId;
  }

  public void setFinancialClassRefId(String financialClassRefId) {
    this.financialClassRefId = financialClassRefId;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(String creationTime) {
    this.creationTime = creationTime;
  }
}
