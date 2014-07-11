package sif3.hits.domain.model;

import javax.persistence.Entity;

@Entity
public class StudentSchoolEnrollment extends HitsEntity implements ZoneFilterable {

  private static final long serialVersionUID = 8616854135795820792L;

  private String refId;
  private String schoolInfoRefId;
  private String membershipType;
  private String schoolYear;
  private String timeFrame;
  private String yearLevel;
  private String fte;
  private String entryDate;

  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getSchoolInfoRefId() {
    return schoolInfoRefId;
  }

  public void setSchoolInfoRefId(String schoolInfoRefId) {
    this.schoolInfoRefId = schoolInfoRefId;
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
}
