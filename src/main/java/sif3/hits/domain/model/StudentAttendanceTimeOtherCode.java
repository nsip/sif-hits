package sif3.hits.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StudentAttendanceTimeList_AttendanceTime_OtherCode")
public class StudentAttendanceTimeOtherCode {

  private StudentAttendanceTimeOtherCodeId studentAttendanceTimeOtherCodeId;
  private StudentAttendanceTime studentAttendanceTime;

  @EmbeddedId
  public StudentAttendanceTimeOtherCodeId getStudentAttendanceTimeOtherCodeId() {
    return studentAttendanceTimeOtherCodeId;
  }

  public void setStudentAttendanceTimeOtherCodeId(StudentAttendanceTimeOtherCodeId studentAttendanceTimeOtherCodeId) {
    this.studentAttendanceTimeOtherCodeId = studentAttendanceTimeOtherCodeId;
  }

  @ManyToOne(optional = false)
  @MapsId("data")
  @JoinColumn(name = "StudentAttendanceTimeList_AttendanceTime_id", referencedColumnName = "data")
  public StudentAttendanceTime getStudentAttendanceTime() {
    return studentAttendanceTime;
  }

  public void setStudentAttendanceTime(StudentAttendanceTime studentAttendanceTime) {
    this.studentAttendanceTime = studentAttendanceTime;
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
