package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SchoolInfo extends HitsEntity {
  private static final long serialVersionUID = -4248855637746217708L;

  private String refId;
  private String localId;
  private String schoolName;
  private String stateProvinceId;
  private String commonwealthId;
  private String schoolSector;
  private String operationalStatus;
  private String independentSchool;
  private String schoolType;
  private String addressStateProvince;
  private String addressCity;
  private String addressPostalCode;
  private String addressStreetNumber;
  private String addressStreetName;
  private String addressLongitude;
  private String addressLatitude;
  private String addressGeographicLocation;
  private String addressARIA;
  private String entityOpen;
  private String entityClose;
  private String zoneId;
  private String campusId;
  private String campusAdminStatus;
  private String campusType;
  private String campusParentSchoolId;

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

  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public String getStateProvinceId() {
    return stateProvinceId;
  }

  public void setStateProvinceId(String stateProvinceId) {
    this.stateProvinceId = stateProvinceId;
  }

  public String getCommonwealthId() {
    return commonwealthId;
  }

  public void setCommonwealthId(String commonwealthId) {
    this.commonwealthId = commonwealthId;
  }

  public String getSchoolSector() {
    return schoolSector;
  }

  public void setSchoolSector(String schoolSector) {
    this.schoolSector = schoolSector;
  }

  public String getOperationalStatus() {
    return operationalStatus;
  }

  public void setOperationalStatus(String operationalStatus) {
    this.operationalStatus = operationalStatus;
  }

  public String getIndependentSchool() {
    return independentSchool;
  }

  public void setIndependentSchool(String independentSchool) {
    this.independentSchool = independentSchool;
  }

  public String getSchoolType() {
    return schoolType;
  }

  public void setSchoolType(String schoolType) {
    this.schoolType = schoolType;
  }

  @Column(name = "Address_StateProvince")
  public String getAddressStateProvince() {
    return addressStateProvince;
  }

  public void setAddressStateProvince(String addressStateProvince) {
    this.addressStateProvince = addressStateProvince;
  }

  @Column(name = "Address_City")
  public String getAddressCity() {
    return addressCity;
  }

  public void setAddressCity(String addressCity) {
    this.addressCity = addressCity;
  }

  @Column(name = "Address_PostalCode")
  public String getAddressPostalCode() {
    return addressPostalCode;
  }

  public void setAddressPostalCode(String addressPostalCode) {
    this.addressPostalCode = addressPostalCode;
  }

  @Column(name = "Address_Street_StreetNumber")
  public String getAddressStreetNumber() {
    return addressStreetNumber;
  }

  public void setAddressStreetNumber(String addressStreetNumber) {
    this.addressStreetNumber = addressStreetNumber;
  }

  @Column(name = "Address_Street_StreetName")
  public String getAddressStreetName() {
    return addressStreetName;
  }

  public void setAddressStreetName(String addressStreetName) {
    this.addressStreetName = addressStreetName;
  }

  @Column(name = "Address_GridLocation_Longitude")
  public String getAddressLongitude() {
    return addressLongitude;
  }

  public void setAddressLongitude(String addressLongitude) {
    this.addressLongitude = addressLongitude;
  }

  @Column(name = "Address_GridLocation_Latitude")
  public String getAddressLatitude() {
    return addressLatitude;
  }

  public void setAddressLatitude(String addressLatitude) {
    this.addressLatitude = addressLatitude;
  }

  @Column(name = "Address_SchoolGeographicLocation")
  public String getAddressGeographicLocation() {
    return addressGeographicLocation;
  }

  public void setAddressGeographicLocation(String addressGeographicLocation) {
    this.addressGeographicLocation = addressGeographicLocation;
  }

  @Column(name = "Address_ARIA")
  public String getAddressARIA() {
    return addressARIA;
  }

  public void setAddressARIA(String addressARIA) {
    this.addressARIA = addressARIA;
  }

  @Column(name = "Entity_Open")
  public String getEntityOpen() {
    return entityOpen;
  }

  public void setEntityOpen(String entityOpen) {
    this.entityOpen = entityOpen;
  }

  @Column(name = "Entity_Close")
  public String getEntityClose() {
    return entityClose;
  }

  public void setEntityClose(String entityClose) {
    this.entityClose = entityClose;
  }

  @Column(name = "ZoneId")
  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  @Column(name = "CampusSchoolCampusId")
  public String getCampusId() {
    return campusId;
  }

  public void setCampusId(String campusId) {
    this.campusId = campusId;
  }

  public String getCampusAdminStatus() {
    return campusAdminStatus;
  }

  public void setCampusAdminStatus(String campusAdminStatus) {
    this.campusAdminStatus = campusAdminStatus;
  }

  @Column(name = "CampusCampusType")
  public String getCampusType() {
    return campusType;
  }

  public void setCampusType(String campusType) {
    this.campusType = campusType;
  }

  public String getCampusParentSchoolId() {
    return campusParentSchoolId;
  }

  public void setCampusParentSchoolId(String campusParentSchoolId) {
    this.campusParentSchoolId = campusParentSchoolId;
  }
}
