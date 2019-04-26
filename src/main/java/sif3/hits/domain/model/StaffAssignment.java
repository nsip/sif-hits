package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class StaffAssignment extends HitsEntity {
  private static final long serialVersionUID = 8218116792025921548L;

  private String refId;
  private String schoolInfoRefId;
  private String schoolYear;
  private String staffPersonalRefId;
  private String description;
  private String primaryAssignment;
  private String jobStartDate;
  private String jobEndDate;
  private String jobFTE;
  private String jobFunction;
  private String employmentStatus;
  private String staffActivityCode;
  private List<String> yearLevels;
  private List<StaffSubject> subjects;
  private String casualReliefTeacher;
  private String homegroup;
  private String house;
  private List<String> calendarSummaries;
  private String previousSchoolName;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "SchoolInfo_RefId")
  public String getSchoolInfoRefId() {
    return schoolInfoRefId;
  }

  public void setSchoolInfoRefId(String schoolInfoRefId) {
    this.schoolInfoRefId = schoolInfoRefId;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  @Column(name = "StaffPersonal_RefId")
  public String getStaffPersonalRefId() {
    return staffPersonalRefId;
  }

  public void setStaffPersonalRefId(String staffPersonalRefId) {
    this.staffPersonalRefId = staffPersonalRefId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrimaryAssignment() {
    return primaryAssignment;
  }

  public void setPrimaryAssignment(String primaryAssignment) {
    this.primaryAssignment = primaryAssignment;
  }

  public String getJobStartDate() {
    return jobStartDate;
  }

  public void setJobStartDate(String jobStartDate) {
    this.jobStartDate = jobStartDate;
  }

  public String getJobEndDate() {
    return jobEndDate;
  }

  public void setJobEndDate(String jobEndDate) {
    this.jobEndDate = jobEndDate;
  }

  public String getJobFunction() {
    return jobFunction;
  }

  public void setJobFunction(String jobFunction) {
    this.jobFunction = jobFunction;
  }

  @Column(name = "StaffActivity_Code")
  public String getStaffActivityCode() {
    return staffActivityCode;
  }

  public void setStaffActivityCode(String staffActivityCode) {
    this.staffActivityCode = staffActivityCode;
  }

  public String getJobFTE() {
    return jobFTE;
  }

  public void setJobFTE(String jobFTE) {
    this.jobFTE = jobFTE;
  }

  public String getEmploymentStatus() {
    return employmentStatus;
  }

  public void setEmploymentStatus(String employmentStatus) {
    this.employmentStatus = employmentStatus;
  }

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "StaffAssignment_YearLevel", joinColumns = @JoinColumn(name = "StaffAssignment_RefId"))
  @Column(name="YearLevel")
  public List<String> getYearLevels() {
    return yearLevels;
  }

  public void setYearLevels(List<String> yearLevels) {
    this.yearLevels = yearLevels;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "staffAssignment")
  public List<StaffSubject> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<StaffSubject> subjects) {
    this.subjects = subjects;
  }

  public String getCasualReliefTeacher() {
    return casualReliefTeacher;
  }

  public void setCasualReliefTeacher(String casualReliefTeacher) {
    this.casualReliefTeacher = casualReliefTeacher;
  }

  public String getHomegroup() {
    return homegroup;
  }

  public void setHomegroup(String homegroup) {
    this.homegroup = homegroup;
  }

  public String getHouse() {
    return house;
  }

  public void setHouse(String house) {
    this.house = house;
  }

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "StaffAssignment_YearLevel", joinColumns = @JoinColumn(name = "StaffAssignment_RefId"))
  @Column(name="CalendarSummary_RefId")
  public List<String> getCalendarSummaries() {
    return calendarSummaries;
  }

  public void setCalendarSummaries(List<String> calendarSummaries) {
    this.calendarSummaries = calendarSummaries;
  }

  public String getPreviousSchoolName() {
    return previousSchoolName;
  }

  public void setPreviousSchoolName(String previousSchoolName) {
    this.previousSchoolName = previousSchoolName;
  }
}
