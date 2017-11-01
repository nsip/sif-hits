package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder extends HitsEntity {
  private static final long serialVersionUID = -5805105881955500974L;

  private String refId;
  private String formNumber;
  private String vendorInfoRefId;
  private String locationInfoRefId;
  private String employeePersonalRefId;
  private String creationDate;
  private String taxRate;
  private String taxAmount;
  private String amountDelivered;
  private String updateDate;
  private String fullyDelivered;
  private Set<PurchasingItem> purchasingItems;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getFormNumber() {
    return formNumber;
  }

  public void setFormNumber(String formNumber) {
    this.formNumber = formNumber;
  }

  @Column(name = "VendorInfo_RefId")
  public String getVendorInfoRefId() {
    return vendorInfoRefId;
  }

  public void setVendorInfoRefId(String vendorInfoRefId) {
    this.vendorInfoRefId = vendorInfoRefId;
  }

  @Column(name = "LocationInfo_RefId")
  public String getLocationInfoRefId() {
    return locationInfoRefId;
  }

  public void setLocationInfoRefId(String locationInfoRefId) {
    this.locationInfoRefId = locationInfoRefId;
  }

  @Column(name = "EmployeePersonal_RefId")
  public String getEmployeePersonalRefId() {
    return employeePersonalRefId;
  }

  public void setEmployeePersonalRefId(String employeePersonalRefId) {
    this.employeePersonalRefId = employeePersonalRefId;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(String taxRate) {
    this.taxRate = taxRate;
  }

  public String getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(String taxAmount) {
    this.taxAmount = taxAmount;
  }

  public String getAmountDelivered() {
    return amountDelivered;
  }

  public void setAmountDelivered(String amountDelivered) {
    this.amountDelivered = amountDelivered;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

  public String getFullyDelivered() {
    return fullyDelivered;
  }

  public void setFullyDelivered(String fullyDelivered) {
    this.fullyDelivered = fullyDelivered;
  }

  @OneToMany(mappedBy = "purchaseOrder", orphanRemoval = true, cascade = CascadeType.ALL)
  public Set<PurchasingItem> getPurchasingItems() {
    return purchasingItems;
  }

  public void setPurchasingItems(Set<PurchasingItem> purchasingItems) {
    this.purchasingItems = purchasingItems;
  }
}
