package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentSchoolEnrollment extends HitsEntity {

  private static final long serialVersionUID = 8616854135795820792L;

  private String refId;
  private String schoolInfoRefId;
  private String studentPersonalRefId;
  private String membershipType;
  private String schoolYear;
  private String timeFrame;
  private String yearLevel;
  private String fte;
  private String entryDate;
  private String exitDate;
  private String recordClosureReason;
  private String promotionStatus;

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

  @Column(name = "StudentPersonal_RefId")
  public String getStudentPersonalRefId() {
    return studentPersonalRefId;
  }

  public void setStudentPersonalRefId(String studentPersonalRefId) {
    this.studentPersonalRefId = studentPersonalRefId;
  }

  public String getMembershipType() {
    return membershipType;
  }

  public void setMembershipType(String membershipType) {
    this.membershipType = membershipType;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getTimeFrame() {
    return timeFrame;
  }

  public void setTimeFrame(String timeFrame) {
    this.timeFrame = timeFrame;
  }

  public String getYearLevel() {
    return yearLevel;
  }

  public void setYearLevel(String yearLevel) {
    this.yearLevel = yearLevel;
  }

  public String getFte() {
    return fte;
  }

  public void setFte(String fte) {
    this.fte = fte;
  }

  public String getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(String entryDate) {
    this.entryDate = entryDate;
  }

  public String getExitDate() {
    return exitDate;
  }

  public void setExitDate(String exitDate) {
    this.exitDate = exitDate;
  }

  public String getPromotionStatus() {
    return promotionStatus;
  }

  public void setPromotionStatus(String promotionStatus) {
    this.promotionStatus = promotionStatus;
  }

  public String getRecordClosureReason() {
    return recordClosureReason;
  }

  public void setRecordClosureReason(String recordClosureReason) {
    this.recordClosureReason = recordClosureReason;
  }
}
