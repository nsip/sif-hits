package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.Set;

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
  private Set<Language> languages;

  private boolean temporary = false;

  // naplan
  private String lbote;
  private String mostRecentSchoolLocalId;
  private String mostRecentSchoolAcaraId;
  private String mostRecentSchoolCampusId;
  private String mostRecentHomeroomLocalId;
  private String mostRecentFTE;
  private String mostRecentHomegroup;
  private String mostRecentClassCode;
  private String mostRecentMembershipType;
  private String mostRecentOtherEnrollmentSchoolAcaraId;
  private String mostRecentFFPOS;
  private String mostRecentReportingSchool;
  private String mostRecentTestLevel;
  private String offlineDelivery;
  private String educationSupport;
  private String homeSchooledStudent;
  private String sensitive;
  private String esl;

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

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentPersonal")
  public Set<StudentPersonalOtherId> getOtherIds() {
    return otherIds;
  }

  public void setOtherIds(Set<StudentPersonalOtherId> otherIds) {
    this.otherIds = otherIds;
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
  public String getTitle() {
    return null;
  }

  public void setTitle(String title) {

  }

  public String getLbote() {
    return lbote;
  }

  public void setLbote(String lbote) {
    this.lbote = lbote;
  }

  @Column(name = "MostRecent_SchoolLocalId")
  public String getMostRecentSchoolLocalId() {
    return mostRecentSchoolLocalId;
  }

  public void setMostRecentSchoolLocalId(String mostRecentSchoolLocalId) {
    this.mostRecentSchoolLocalId = mostRecentSchoolLocalId;
  }

  @Column(name = "MostRecent_SchoolACARAId")
  public String getMostRecentSchoolAcaraId() {
    return mostRecentSchoolAcaraId;
  }

  public void setMostRecentSchoolAcaraId(String mostRecentSchoolAcaraId) {
    this.mostRecentSchoolAcaraId = mostRecentSchoolAcaraId;
  }

  @Column(name = "MostRecent_SchoolCampusId")
  public String getMostRecentSchoolCampusId() {
    return mostRecentSchoolCampusId;
  }

  public void setMostRecentSchoolCampusId(String mostRecentSchoolCampusId) {
    this.mostRecentSchoolCampusId = mostRecentSchoolCampusId;
  }

  @Column(name = "MostRecent_HomeroomLocalId")
  public String getMostRecentHomeroomLocalId() {
    return mostRecentHomeroomLocalId;
  }

  public void setMostRecentHomeroomLocalId(String mostRecentHomeroomLocalId) {
    this.mostRecentHomeroomLocalId = mostRecentHomeroomLocalId;
  }

  @Column(name = "MostRecent_FTE")
  public String getMostRecentFTE() {
    return mostRecentFTE;
  }

  public void setMostRecentFTE(String mostRecentFTE) {
    this.mostRecentFTE = mostRecentFTE;
  }

  @Column(name = "MostRecent_Homegroup")
  public String getMostRecentHomegroup() {
    return mostRecentHomegroup;
  }

  public void setMostRecentHomegroup(String mostRecentHomegroup) {
    this.mostRecentHomegroup = mostRecentHomegroup;
  }

  @Column(name = "MostRecent_ClassCode")
  public String getMostRecentClassCode() {
    return mostRecentClassCode;
  }

  public void setMostRecentClassCode(String mostRecentClassCode) {
    this.mostRecentClassCode = mostRecentClassCode;
  }

  @Column(name = "MostRecent_MembershipType")
  public String getMostRecentMembershipType() {
    return mostRecentMembershipType;
  }

  public void setMostRecentMembershipType(String mostRecentMembershipType) {
    this.mostRecentMembershipType = mostRecentMembershipType;
  }

  @Column(name = "MostRecent_OtherEnrollmentSchoolAcaraId")
  public String getMostRecentOtherEnrollmentSchoolAcaraId() {
    return mostRecentOtherEnrollmentSchoolAcaraId;
  }

  public void setMostRecentOtherEnrollmentSchoolAcaraId(String mostRecentOtherEnrollmentSchoolAcaraId) {
    this.mostRecentOtherEnrollmentSchoolAcaraId = mostRecentOtherEnrollmentSchoolAcaraId;
  }

  @Column(name = "MostRecent_FFPOS")
  public String getMostRecentFFPOS() {
    return mostRecentFFPOS;
  }

  public void setMostRecentFFPOS(String mostRecentFFPOS) {
    this.mostRecentFFPOS = mostRecentFFPOS;
  }

  @Column(name = "MostRecent_ReportingSchool")
  public String getMostRecentReportingSchool() {
    return mostRecentReportingSchool;
  }

  public void setMostRecentReportingSchool(String mostRecentReportingSchool) {
    this.mostRecentReportingSchool = mostRecentReportingSchool;
  }

  @Column(name = "MostRecent_TestLevel")
  public String getMostRecentTestLevel() {
    return mostRecentTestLevel;
  }

  public void setMostRecentTestLevel(String mostRecentTestLevel) {
    this.mostRecentTestLevel = mostRecentTestLevel;
  }

  public String getOfflineDelivery() {
    return offlineDelivery;
  }

  public void setOfflineDelivery(String offlineDelivery) {
    this.offlineDelivery = offlineDelivery;
  }

  public String getEducationSupport() {
    return educationSupport;
  }

  public void setEducationSupport(String educationSupport) {
    this.educationSupport = educationSupport;
  }

  public String getHomeSchooledStudent() {
    return homeSchooledStudent;
  }

  public void setHomeSchooledStudent(String homeSchooledStudent) {
    this.homeSchooledStudent = homeSchooledStudent;
  }

  @Column(name = "SensitiveData")
  public String getSensitive() {
    return sensitive;
  }

  public void setSensitive(String sensitive) {
    this.sensitive = sensitive;
  }

  public String getEsl() {
    return esl;
  }

  public void setEsl(String esl) {
    this.esl = esl;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name="Person_RefId")
  public Set<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(Set<Language> languages) {
    this.languages = languages;
  }

  @Transient
  public boolean isTemporary() {
    return temporary;
  }

  @Transient
  public void setTemporary(boolean temporary) {
    this.temporary = temporary;
  }
}
