package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SessionInfo extends HitsEntity {
  private static final long serialVersionUID = 2358081905724634269L;

  private String refId;
  private String schoolInfoRefId;
  private String timeTableCellRefId;
  private String schoolYear;
  private String localId;
  private String timeTableSubjectLocalId;
  private String teachingGroupLocalId;
  private String schoolLocalId;
  private String staffPersonalLocalId;
  private String roomNumber;
  private String dayId;
  private String periodId;
  private String sessionDate;
  private String startTime;
  private String finishTime;
  private String rollMarked;

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

  @Column(name = "TimeTableCell_RefId")
  public String getTimeTableCellRefId() {
    return timeTableCellRefId;
  }

  public void setTimeTableCellRefId(String timeTableCellRefId) {
    this.timeTableCellRefId = timeTableCellRefId;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getTimeTableSubjectLocalId() {
    return timeTableSubjectLocalId;
  }

  public void setTimeTableSubjectLocalId(String timeTableSubjectLocalId) {
    this.timeTableSubjectLocalId = timeTableSubjectLocalId;
  }

  public String getTeachingGroupLocalId() {
    return teachingGroupLocalId;
  }

  public void setTeachingGroupLocalId(String teachingGroupLocalId) {
    this.teachingGroupLocalId = teachingGroupLocalId;
  }

  public String getSchoolLocalId() {
    return schoolLocalId;
  }

  public void setSchoolLocalId(String schoolLocalId) {
    this.schoolLocalId = schoolLocalId;
  }

  public String getStaffPersonalLocalId() {
    return staffPersonalLocalId;
  }

  public void setStaffPersonalLocalId(String staffPersonalLocalId) {
    this.staffPersonalLocalId = staffPersonalLocalId;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getDayId() {
    return dayId;
  }

  public void setDayId(String dayId) {
    this.dayId = dayId;
  }

  public String getPeriodId() {
    return periodId;
  }

  public void setPeriodId(String periodId) {
    this.periodId = periodId;
  }

  public String getSessionDate() {
    return sessionDate;
  }

  public void setSessionDate(String sessionDate) {
    this.sessionDate = sessionDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getFinishTime() {
    return finishTime;
  }

  public void setFinishTime(String finishTime) {
    this.finishTime = finishTime;
  }

  public String getRollMarked() {
    return rollMarked;
  }

  public void setRollMarked(String rollMarked) {
    this.rollMarked = rollMarked;
  }
}
