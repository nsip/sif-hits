package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentAttendanceSummary extends HitsEntity {
  private static final long serialVersionUID = 3200576651380455536L;
  private String refId = null;
  private String studentPersonalRefId = null;
  private String schoolInfoRefId = null;
  private String schoolYear = null;
  private String startDate = null;
  private String endDate = null;
  private String startDay = null;
  private String endDay = null;
  private String fte = null;
  private String daysAttended = null;
  private String excusedAbsences = null;
  private String unexcusedAbsences = null;
  private String daysTardy = null;
  private String daysInMembership = null;

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

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getStartDay() {
    return startDay;
  }

  public void setStartDay(String startDay) {
    this.startDay = startDay;
  }

  public String getEndDay() {
    return endDay;
  }

  public void setEndDay(String endDay) {
    this.endDay = endDay;
  }

  public String getFte() {
    return fte;
  }

  public void setFte(String fte) {
    this.fte = fte;
  }

  public String getDaysAttended() {
    return daysAttended;
  }

  public void setDaysAttended(String daysAttended) {
    this.daysAttended = daysAttended;
  }

  public String getExcusedAbsences() {
    return excusedAbsences;
  }

  public void setExcusedAbsences(String excusedAbsences) {
    this.excusedAbsences = excusedAbsences;
  }

  public String getUnexcusedAbsences() {
    return unexcusedAbsences;
  }

  public void setUnexcusedAbsences(String unexcusedAbsences) {
    this.unexcusedAbsences = unexcusedAbsences;
  }

  public String getDaysTardy() {
    return daysTardy;
  }

  public void setDaysTardy(String daysTardy) {
    this.daysTardy = daysTardy;
  }

  public String getDaysInMembership() {
    return daysInMembership;
  }

  public void setDaysInMembership(String daysInMembership) {
    this.daysInMembership = daysInMembership;
  }
}
