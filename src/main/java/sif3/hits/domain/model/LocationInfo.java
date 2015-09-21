package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class LocationInfo extends HitsEntity {
  private static final long serialVersionUID = -2078043952914157560L;

  private String refId;
  private String locationType;
  private String siteCategory;
  private String name;
  private String description;
  private String localId;
  private String stateProvinceId;
  private String parentLocationInfoRefId;
  private String schoolInfoRefId;
  private String phoneNumber;
  private Set<Address> addresses;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getLocationType() {
    return locationType;
  }

  public void setLocationType(String locationType) {
    this.locationType = locationType;
  }

  public String getSiteCategory() {
    return siteCategory;
  }

  public void setSiteCategory(String siteCategory) {
    this.siteCategory = siteCategory;
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

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getStateProvinceId() {
    return stateProvinceId;
  }

  public void setStateProvinceId(String stateProvinceId) {
    this.stateProvinceId = stateProvinceId;
  }

  @Column(name = "Parent_LocationInfo_RefId")
  public String getParentLocationInfoRefId() {
    return parentLocationInfoRefId;
  }

  public void setParentLocationInfoRefId(String parentLocationInfoRefId) {
    this.parentLocationInfoRefId = parentLocationInfoRefId;
  }

  @Column(name = "SchoolInfo_RefId")
  public String getSchoolInfoRefId() {
    return schoolInfoRefId;
  }

  public void setSchoolInfoRefId(String schoolInfoRefId) {
    this.schoolInfoRefId = schoolInfoRefId;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "Person_RefId")
  public Set<Address> getAddresses() {
    return addresses;
  }
  
  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }
}
