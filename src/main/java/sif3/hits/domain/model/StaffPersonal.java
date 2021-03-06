package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class StaffPersonal extends HitsEntity implements StaffPerson {
  private static final long serialVersionUID = -1366329722095506132L;

  private String refId;
  private String localId;
  private String familyName;
  private String givenName;
  private String middleName;
  private String preferredFamilyName;
  private String preferredGivenName;
  private String fullName;
  private String stateProvinceId;
  private String sex;
  private String employmentStatus;
  private String email;
  private String phoneNumber;
  private String salutation;
  private String birthDate;
  private String mostRecentSchoolAcaraId;
  private String mostRecentSchoolLocalId;
  private String mostRecentLocalCampusId;
  private String interpreterRequired;
  private Set<StaffPersonalOtherId> otherIds;
  private Set<Language> languages;

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

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getPreferredFamilyName() {
    return preferredFamilyName;
  }

  public void setPreferredFamilyName(String preferredFamilyName) {
    this.preferredFamilyName = preferredFamilyName;
  }

  public String getPreferredGivenName() {
    return preferredGivenName;
  }

  public void setPreferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getStateProvinceId() {
    return stateProvinceId;
  }

  public void setStateProvinceId(String stateProvinceId) {
    this.stateProvinceId = stateProvinceId;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEmploymentStatus() {
    return employmentStatus;
  }

  public void setEmploymentStatus(String employmentStatus) {
    this.employmentStatus = employmentStatus;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String getInterpreterRequired() {
    return interpreterRequired;
  }

  @Override
  public void setInterpreterRequired(String interpreterRequired) {
    this.interpreterRequired = interpreterRequired;
  }

  @Column(name = "MostRecent_SchoolACARAId")
  public String getMostRecentSchoolAcaraId() {
    return mostRecentSchoolAcaraId;
  }

  public void setMostRecentSchoolAcaraId(String mostRecentSchoolAcaraId) {
    this.mostRecentSchoolAcaraId = mostRecentSchoolAcaraId;
  }

  @Column(name = "MostRecent_SchoolLocalId")
  public String getMostRecentSchoolLocalId() {
    return mostRecentSchoolLocalId;
  }

  public void setMostRecentSchoolLocalId(String mostRecentSchoolLocalId) {
    this.mostRecentSchoolLocalId = mostRecentSchoolLocalId;
  }

  @Column(name = "MostRecent_LocalCampusId")
  public String getMostRecentLocalCampusId() {
    return mostRecentLocalCampusId;
  }

  public void setMostRecentLocalCampusId(String mostRecentLocalCampusId) {
    this.mostRecentLocalCampusId = mostRecentLocalCampusId;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "staffPersonalOtherIdId.staffPersonal")
  public Set<StaffPersonalOtherId> getOtherIds() {
    return otherIds;
  }

  public void setOtherIds(Set<StaffPersonalOtherId> otherIds) {
    this.otherIds = otherIds;
  }

  @Override
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "Person_RefId")
  public Set<Language> getLanguages() {
    return this.languages;
  }

  @Override
  public void setLanguages(Set<Language> languages) {
    this.languages = languages;
  }

  @Transient
  public String getTitle() {
    return null;
  }

  public void setTitle(String title) {

  }

}
