package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentAttendanceTimeOtherCodeId implements Serializable {
  private static final long serialVersionUID = -9003670611749759137L;

  private StudentAttendanceTime studentAttendanceTime;
  private String otherCode;
  private String codeSet;

  @ManyToOne(optional = false)
  @JoinColumns({
      @JoinColumn(name = "StudentAttendanceTimeList_RefId", referencedColumnName = "StudentAttendanceTimeList_RefId"),
      @JoinColumn(name = "code", referencedColumnName = "startTime")
  })
  public StudentAttendanceTime getStudentAttendanceTime() {
    return studentAttendanceTime;
  }

  public void setStudentAttendanceTime(StudentAttendanceTime studentAttendanceTime) {
    this.studentAttendanceTime = studentAttendanceTime;
  }

  public String getOtherCode() {
    return otherCode;
  }

  public void setOtherCode(String otherCode) {
    this.otherCode = otherCode;
  }

  @Column(name = "OtherCode_CodeSet")
  public String getCodeSet() {
    return codeSet;
  }

  public void setCodeSet(String codeSet) {
    this.codeSet = codeSet;
  }
}