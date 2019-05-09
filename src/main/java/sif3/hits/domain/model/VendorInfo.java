package sif3.hits.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

@Entity
public class VendorInfo extends HitsEntity {
  private static final long serialVersionUID = 2585999574152766722L;

  private String refId;
  private String name;
  private String contactInfoFamilyName;
  private String contactInfoGivenName;
  private String contactInfoMiddleName;
  private String contactInfoPositionTitle;
  private String contactInfoRole;
  private String contactInfoEmail;
  private String contactInfoPhoneNumber;
  private String contactInfoRegistrationDetails;
  private String contactInfoQualifications;
  private String customerId;
  private String abn;
  private String registeredForGST;
  private String paymentTerms;
  private String bpay;
  private String bsb;
  private String accountNumber;
  private String accountName;
  private Set<Address> addresses;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "ContactInfo_FamilyName")
  public String getContactInfoFamilyName() {
    return contactInfoFamilyName;
  }

  public void setContactInfoFamilyName(String contactInfoFamilyName) {
    this.contactInfoFamilyName = contactInfoFamilyName;
  }

  @Column(name = "ContactInfo_GivenName")
  public String getContactInfoGivenName() {
    return contactInfoGivenName;
  }

  public void setContactInfoGivenName(String contactInfoGivenName) {
    this.contactInfoGivenName = contactInfoGivenName;
  }

  @Column(name = "ContactInfo_MiddleName")
  public String getContactInfoMiddleName() {
    return contactInfoMiddleName;
  }

  public void setContactInfoMiddleName(String contactInfoMiddleName) {
    this.contactInfoMiddleName = contactInfoMiddleName;
  }

  @Column(name = "ContactInfo_PositionTitle")
  public String getContactInfoPositionTitle() {
    return contactInfoPositionTitle;
  }

  public void setContactInfoPositionTitle(String contactInfoPositionTitle) {
    this.contactInfoPositionTitle = contactInfoPositionTitle;
  }

  @Column(name = "ContactInfo_Role")
  public String getContactInfoRole() {
    return contactInfoRole;
  }

  public void setContactInfoRole(String contactInfoRole) {
    this.contactInfoRole = contactInfoRole;
  }

  @Column(name = "ContactInfo_Email")
  public String getContactInfoEmail() {
    return contactInfoEmail;
  }

  public void setContactInfoEmail(String contactInfoEmail) {
    this.contactInfoEmail = contactInfoEmail;
  }

  @Column(name = "ContactInfo_PhoneNumber")
  public String getContactInfoPhoneNumber() {
    return contactInfoPhoneNumber;
  }

  public void setContactInfoPhoneNumber(String contactInfoPhoneNumber) {
    this.contactInfoPhoneNumber = contactInfoPhoneNumber;
  }

  @Column(name = "ContactInfo_RegistrationDetails")
  public String getContactInfoRegistrationDetails() {
    return contactInfoRegistrationDetails;
  }

  public void setContactInfoRegistrationDetails(String contactInfoRegistrationDetails) {
    this.contactInfoRegistrationDetails = contactInfoRegistrationDetails;
  }

  @Column(name = "ContactInfo_Qualifications")
  public String getContactInfoQualifications() {
    return contactInfoQualifications;
  }

  public void setContactInfoQualifications(String contactInfoQualifications) {
    this.contactInfoQualifications = contactInfoQualifications;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getABN() {
    return abn;
  }

  public void setABN(String abn) {
    this.abn = abn;
  }

  public String getRegisteredForGST() {
    return registeredForGST;
  }

  public void setRegisteredForGST(String registeredForGST) {
    this.registeredForGST = registeredForGST;
  }

  public String getPaymentTerms() {
    return paymentTerms;
  }

  public void setPaymentTerms(String paymentTerms) {
    this.paymentTerms = paymentTerms;
  }

  public String getBPay() {
    return bpay;
  }

  public void setBPay(String bpay) {
    this.bpay = bpay;
  }

  public String getBSB() {
    return bsb;
  }

  public void setBSB(String bsb) {
    this.bsb = bsb;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "Person_RefId")
  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }

  @Transient
  public Address getAddress() {
    Address result = null;
    if (addresses != null && !addresses.isEmpty()) {
      result = addresses.iterator().next();
    }
    return result;
  }

  @Transient
  public void setAddress(Address address) {
    if (addresses == null) {
      addresses = new HashSet<Address>();
    } else {
      addresses.clear();
    }
    if (address != null) {
      this.addresses.add(address);
    }
  }

  @Transient
  public boolean hasContactInfo() {
    return StringUtils.isNotBlank(contactInfoEmail) || hasNameInfo() || StringUtils.isNotBlank(contactInfoPhoneNumber) || StringUtils.isNotBlank(contactInfoPositionTitle)
        || StringUtils.isNotBlank(contactInfoRole) || getAddress() != null;
  }

  public boolean hasNameInfo() {
    return StringUtils.isNotBlank(contactInfoFamilyName) || StringUtils.isNotBlank(contactInfoGivenName) || StringUtils.isNotBlank(contactInfoMiddleName);

  }
}
