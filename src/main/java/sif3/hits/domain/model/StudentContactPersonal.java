package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class StudentContactPersonal extends HitsEntity implements Person, AddressPerson {
  private static final long serialVersionUID = -535293295147810685L;

  private String refId;
  private String localId;
  private String title;
  private String familyName;
  private String givenName;
  private String preferredGivenName;
  private String preferredFamilyName;
  private String middleName;
  private String sex;
  private String phoneNumberType;
  private String phoneNumber;
  private String email;
  private String emailType;
  private String schoolEducationLevel;
  private String nonSchoolEducation;
  private String employmentType;
  private Set<Address> addresses;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public String getPreferredGivenName() {
    return preferredGivenName;
  }

  public void setPreferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
  }

  public String getPreferredFamilyName() {
    return preferredFamilyName;
  }

  public void setPreferredFamilyName(String preferredFamilyName) {
    this.preferredFamilyName = preferredFamilyName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPhoneNumberType() {
    return phoneNumberType;
  }

  public void setPhoneNumberType(String phoneNumberType) {
    this.phoneNumberType = phoneNumberType;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailType() {
    return emailType;
  }

  public void setEmailType(String emailType) {
    this.emailType = emailType;
  }

  public String getSchoolEducationLevel() {
    return schoolEducationLevel;
  }

  public void setSchoolEducationLevel(String schoolEducationLevel) {
    this.schoolEducationLevel = schoolEducationLevel;
  }

  public String getNonSchoolEducation() {
    return nonSchoolEducation;
  }

  public void setNonSchoolEducation(String nonSchoolEducation) {
    this.nonSchoolEducation = nonSchoolEducation;
  }

  public String getEmploymentType() {
    return employmentType;
  }

  public void setEmploymentType(String employmentType) {
    this.employmentType = employmentType;
  }

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "Person_RefId")
  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
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
  public String getFullName() {
    return null;
  }

  @Override
  public void setFullName(String fullName) {

  }

  @Transient
  public String getBirthDate() {
    return null;
  }

  @Override
  public void setBirthDate(String birthDate) {

  }
}
