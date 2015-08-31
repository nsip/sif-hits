package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address extends HitsEntity {
  private static final long serialVersionUID = 780079260208146238L;

  private Integer recordNumber;
  private String personRefId;
  private String addressType;
  private String addressRole;
  private String lineOne;
  private String lineTwo;
  private String city;
  private String stateProvince;
  private String postalCode;
  private String longitude;
  private String latitude;

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

  public String getAddressType() {
    return addressType;
  }

  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }

  public String getAddressRole() {
    return addressRole;
  }

  public void setAddressRole(String addressRole) {
    this.addressRole = addressRole;
  }

  @Column(name = "Line1")
  public String getLineOne() {
    return lineOne;
  }

  public void setLineOne(String lineOne) {
    this.lineOne = lineOne;
  }

  @Column(name = "Line2")
  public String getLineTwo() {
    return lineTwo;
  }

  public void setLineTwo(String lineTwo) {
    this.lineTwo = lineTwo;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public void setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
}