package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDailyAttendance extends HitsEntity {
  private static final long serialVersionUID = 374308979483724306L;

  private String refId;
  private String studentPersonalRefId;
  private String schoolInfoRefId;
  private String calendarDate;
  private String schoolYear;
  private String dayValue;
  private String attendanceCode;
  private String attendanceStatus;
  private String timeIn;
  private String timeOut;
  private String absenceValue;
  private String attendanceNote;

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

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getDayValue() {
    return dayValue;
  }

  public void setDayValue(String dayValue) {
    this.dayValue = dayValue;
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

  public String getAbsenceValue() {
    return absenceValue;
  }

  public void setAbsenceValue(String absenceValue) {
    this.absenceValue = absenceValue;
  }

  public String getAttendanceNote() {
    return attendanceNote;
  }

  public void setAttendanceNote(String attendanceNote) {
    this.attendanceNote = attendanceNote;
  }
}
