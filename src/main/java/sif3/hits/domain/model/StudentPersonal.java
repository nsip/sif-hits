package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class StudentPersonal extends HitsEntity implements StudentPerson, AddressPerson {
  private static final long serialVersionUID = 3449687758651953543L;

  private String refId;
  private String localId;
  private String familyName;
  private String givenName;
  private String middleName;
  private String fullName;
  private String preferredFamilyName;
  private String preferredGivenName;
  private String stateProvinceId;
  private String sex;
  private String birthDate;
  private String indigenousStatus;
  private String countryOfBirth;
  private String phoneNumber;
  private String email;
  private String mostRecentYearLevel;
  private String mostRecentParent1Language;
  private String mostRecentParent2Language;
  private String mostRecentParent1SchoolEducation;
  private String mostRecentParent2SchoolEducation;
  private String mostRecentParent1NonSchoolEducation;
  private String mostRecentParent2NonSchoolEducation;
  private String mostRecentParent1EmploymentType;
  private String mostRecentParent2EmploymentType;
  private String yearLevel;
  private String religion;
  private Set<StudentPersonalOtherId> otherIds;
  private Set<Address> addresses;

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

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
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

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getIndigenousStatus() {
    return indigenousStatus;
  }

  public void setIndigenousStatus(String indigenousStatus) {
    this.indigenousStatus = indigenousStatus;
  }

  @Column(name = "CountryofBirth")
  public String getCountryOfBirth() {
    return countryOfBirth;
  }

  public void setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
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

  @Column(name = "MostRecent_YearLevel")
  public String getMostRecentYearLevel() {
    return mostRecentYearLevel;
  }

  public void setMostRecentYearLevel(String mostRecentYearLevel) {
    this.mostRecentYearLevel = mostRecentYearLevel;
  }

  @Column(name = "MostRecent_Parent1Language")
  public String getMostRecentParent1Language() {
    return mostRecentParent1Language;
  }

  public void setMostRecentParent1Language(String mostRecentParent1Language) {
    this.mostRecentParent1Language = mostRecentParent1Language;
  }

  @Column(name = "MostRecent_Parent2Language")
  public String getMostRecentParent2Language() {
    return mostRecentParent2Language;
  }

  public void setMostRecentParent2Language(String mostRecentParent2Language) {
    this.mostRecentParent2Language = mostRecentParent2Language;
  }

  @Column(name = "MostRecent_Parent1SchoolEducation")
  public String getMostRecentParent1SchoolEducation() {
    return mostRecentParent1SchoolEducation;
  }

  public void setMostRecentParent1SchoolEducation(String mostRecentParent1SchoolEducation) {
    this.mostRecentParent1SchoolEducation = mostRecentParent1SchoolEducation;
  }

  @Column(name = "MostRecent_Parent2SchoolEducation")
  public String getMostRecentParent2SchoolEducation() {
    return mostRecentParent2SchoolEducation;
  }

  public void setMostRecentParent2SchoolEducation(String mostRecentParent2SchoolEducation) {
    this.mostRecentParent2SchoolEducation = mostRecentParent2SchoolEducation;
  }

  @Column(name = "MostRecent_Parent1NonSchoolEducation")
  public String getMostRecentParent1NonSchoolEducation() {
    return mostRecentParent1NonSchoolEducation;
  }

  public void setMostRecentParent1NonSchoolEducation(String mostRecentParent1NonSchoolEducation) {
    this.mostRecentParent1NonSchoolEducation = mostRecentParent1NonSchoolEducation;
  }

  @Column(name = "MostRecent_Parent2NonSchoolEducation")
  public String getMostRecentParent2NonSchoolEducation() {
    return mostRecentParent2NonSchoolEducation;
  }

  public void setMostRecentParent2NonSchoolEducation(String mostRecentParent2NonSchoolEducation) {
    this.mostRecentParent2NonSchoolEducation = mostRecentParent2NonSchoolEducation;
  }

  @Column(name = "MostRecent_Parent1EmploymentType")
  public String getMostRecentParent1EmploymentType() {
    return mostRecentParent1EmploymentType;
  }

  public void setMostRecentParent1EmploymentType(String mostRecentParent1EmploymentType) {
    this.mostRecentParent1EmploymentType = mostRecentParent1EmploymentType;
  }

  @Column(name = "MostRecent_Parent2EmploymentType")
  public String getMostRecentParent2EmploymentType() {
    return mostRecentParent2EmploymentType;
  }

  public void setMostRecentParent2EmploymentType(String mostRecentParent2EmploymentType) {
    this.mostRecentParent2EmploymentType = mostRecentParent2EmploymentType;
  }

  public String getYearLevel() {
    return yearLevel;
  }

  public void setYearLevel(String yearLevel) {
    this.yearLevel = yearLevel;
  }

  public String getReligion() {
    return religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "studentPersonalOtherIdId.studentPersonal")
  public Set<StudentPersonalOtherId> getOtherIds() {
    return otherIds;
  }

  public void setOtherIds(Set<StudentPersonalOtherId> otherIds) {
    this.otherIds = otherIds;
  }
  
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "Person_RefId")
  public Set<Address> getAddresses() {
    return addresses;
  }
  
  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }

  @Transient
  public String getTitle() {
    return null;
  }

  public void setTitle(String title) {
    
  }
}
