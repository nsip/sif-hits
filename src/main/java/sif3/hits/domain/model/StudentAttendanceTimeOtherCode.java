package sif3.hits.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name= "StudentAttendanceTimeList_AttendanceTime_OtherCode")
public class StudentAttendanceTimeOtherCode {

  private StudentAttendanceTimeOtherCodeId studentAttendanceTimeOtherCodeId;

  @EmbeddedId
  public StudentAttendanceTimeOtherCodeId getStudentAttendanceTimeOtherCodeId() {
    return studentAttendanceTimeOtherCodeId;
  }

  public void setStudentAttendanceTimeOtherCodeId(StudentAttendanceTimeOtherCodeId studentAttendanceTimeOtherCodeId) {
    this.studentAttendanceTimeOtherCodeId = studentAttendanceTimeOtherCodeId;
  }

  @Transient
  public StudentAttendanceTime getStudentAttendanceTime() {
    StudentAttendanceTime result = null;
    if (studentAttendanceTimeOtherCodeId != null) {
      result = studentAttendanceTimeOtherCodeId.getStudentAttendanceTime();
    }
    return result;
  }

  @Transient
  public void setStudentAttendanceTime(StudentAttendanceTime studentAttendanceTime) {
    if (studentAttendanceTimeOtherCodeId == null) {
      studentAttendanceTimeOtherCodeId = new StudentAttendanceTimeOtherCodeId();
    }
    this.studentAttendanceTimeOtherCodeId.setStudentAttendanceTime(studentAttendanceTime);
  }

  @Transient
  public String getOtherCode() {
    String result = null;
    if (studentAttendanceTimeOtherCodeId != null) {
      result = studentAttendanceTimeOtherCodeId.getOtherCode();
    }
    return result;
  }

  @Transient
  public void setOtherCode(String otherCode) {
    if (studentAttendanceTimeOtherCodeId == null) {
      studentAttendanceTimeOtherCodeId = new StudentAttendanceTimeOtherCodeId();
    }
    this.studentAttendanceTimeOtherCodeId.setOtherCode(otherCode);
  }

  @Transient
  public String getCodeSet() {
    String result = null;
    if (studentAttendanceTimeOtherCodeId != null) {
      result = studentAttendanceTimeOtherCodeId.getCodeSet();
    }
    return result;
  }

  @Transient
  public void setCodeSet(String codeSet) {
    if (studentAttendanceTimeOtherCodeId == null) {
      studentAttendanceTimeOtherCodeId = new StudentAttendanceTimeOtherCodeId();
    }
    this.studentAttendanceTimeOtherCodeId.setCodeSet(codeSet);
  }
}
