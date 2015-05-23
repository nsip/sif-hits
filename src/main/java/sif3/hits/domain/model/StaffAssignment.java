package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
  private String jobFunction;
  private String staffActivityCode;

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
}
