package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CalendarDate extends HitsEntity implements ZoneFilterable {
  private static final long serialVersionUID = -8738735661622663019L;

  private String refId;
  private String calendarDate;
  private String calendarSummaryRefId;
  private String schoolInfoRefId;
  private String schoolYear;
  private String typeCode;
  private String number;
  private String studentAttendanceCountsTowardsAttendance;
  private String studentAttendanceAttendanceValue;
  private Set<CalendarDateTypeOtherCode> calendarDateTypeOtherCodes;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getCalendarDate() {
    return calendarDate;
  }

  public void setCalendarDate(String calendarDate) {
    this.calendarDate = calendarDate;
  }

  @Column(name = "CalendarSummary_RefId")
  public String getCalendarSummaryRefId() {
    return calendarSummaryRefId;
  }

  public void setCalendarSummaryRefId(String calendarSummaryRefId) {
    this.calendarSummaryRefId = calendarSummaryRefId;
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

  @Column(name = "CalendarDateType_Code")
  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  @Column(name = "CalendarDateNumber")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  @Column(name = "StudentAttendance_CountsTowardsAttendance")
  public String getStudentAttendanceCountsTowardsAttendance() {
    return studentAttendanceCountsTowardsAttendance;
  }

  public void setStudentAttendanceCountsTowardsAttendance(String studentAttendanceCountsTowardsAttendance) {
    this.studentAttendanceCountsTowardsAttendance = studentAttendanceCountsTowardsAttendance;
  }

  @Column(name = "StudentAttendance_AttendanceValue")
  public String getStudentAttendanceAttendanceValue() {
    return studentAttendanceAttendanceValue;
  }

  public void setStudentAttendanceAttendanceValue(String studentAttendanceAttendanceValue) {
    this.studentAttendanceAttendanceValue = studentAttendanceAttendanceValue;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "calendarDateTypeOtherCodeId.calendarDate")
  public Set<CalendarDateTypeOtherCode> getCalendarDateTypeOtherCodes() {
    return calendarDateTypeOtherCodes;
  }

  public void setCalendarDateTypeOtherCodes(Set<CalendarDateTypeOtherCode> calendarDateTypeOtherCodes) {
    this.calendarDateTypeOtherCodes = calendarDateTypeOtherCodes;
  }
}
