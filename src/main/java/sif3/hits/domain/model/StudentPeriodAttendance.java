package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentPeriodAttendance extends HitsEntity implements ZoneFilterable {
  private static final long serialVersionUID = 659742366558871114L;

  private String refId;
  private String studentPersonalRefId;
  private String schoolInfoRefId;
  private String calendarDate;
  private String sessionInfoRefId;
  private String timetablePeriod;
  private String timeIn;
  private String timeOut;
  private String attendanceCode;
  private String attendanceStatus;
  private String schoolYear;
  private String creationUserType;
  private String auditInfoCreationUserUserId;
  private String auditInfoCreationDateTime;
  private String attendanceComment;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "StudentPersonal_RefId")
  public String getStudentPersonalRefId() {
    return studentPersonalRefId;
  }

  public void setStudentPersonalRefId(String studentPersonalRefId) {
    this.studentPersonalRefId = studentPersonalRefId;
  }

  @Column(name = "SchoolInfo_RefId")
  public String getSchoolInfoRefId() {
    return schoolInfoRefId;
  }

  public void setSchoolInfoRefId(String schoolInfoRefId) {
    this.schoolInfoRefId = schoolInfoRefId;
  }

  public String getCalendarDate() {
    return calendarDate;
  }

  public void setCalendarDate(String calendarDate) {
    this.calendarDate = calendarDate;
  }

  @Column(name = "SessionInfo_RefId")
  public String getSessionInfoRefId() {
    return sessionInfoRefId;
  }

  public void setSessionInfoRefId(String sessionInfoRefId) {
    this.sessionInfoRefId = sessionInfoRefId;
  }

  public String getTimetablePeriod() {
    return timetablePeriod;
  }

  public void setTimetablePeriod(String timetablePeriod) {
    this.timetablePeriod = timetablePeriod;
  }

  public String getTimeIn() {
    return timeIn;
  }

  public void setTimeIn(String timeIn) {
    this.timeIn = timeIn;
  }

  public String getTimeOut() {
    return timeOut;
  }

  public void setTimeOut(String timeOut) {
    this.timeOut = timeOut;
  }

  public String getAttendanceCode() {
    return attendanceCode;
  }

  public void setAttendanceCode(String attendanceCode) {
    this.attendanceCode = attendanceCode;
  }

  public String getAttendanceStatus() {
    return attendanceStatus;
  }

  public void setAttendanceStatus(String attendanceStatus) {
    this.attendanceStatus = attendanceStatus;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  @Column(name = "CreationUser_Type")
  public String getCreationUserType() {
    return creationUserType;
  }

  public void setCreationUserType(String creationUserType) {
    this.creationUserType = creationUserType;
  }

  @Column(name = "AuditInfo_CreationUser_UserId")
  public String getAuditInfoCreationUserUserId() {
    return auditInfoCreationUserUserId;
  }

  public void setAuditInfoCreationUserUserId(String auditInfoCreationUserUserId) {
    this.auditInfoCreationUserUserId = auditInfoCreationUserUserId;
  }

  @Column(name = "AuditInfo_CreationDateTime")
  public String getAuditInfoCreationDateTime() {
    return auditInfoCreationDateTime;
  }

  public void setAuditInfoCreationDateTime(String auditInfoCreationDateTime) {
    this.auditInfoCreationDateTime = auditInfoCreationDateTime;
  }

  public String getAttendanceComment() {
    return attendanceComment;
  }

  public void setAttendanceComment(String attendanceComment) {
    this.attendanceComment = attendanceComment;
  }
}
