package sif3.hits.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "StudentAttendanceTimeList_AttendanceTime_OtherCode")
public class StudentAttendanceTimeOtherCode {

  private Long id;
  private StudentAttendanceTime studentAttendanceTime;
  private String otherCode;
  private String codeSet;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "StudentAttendanceTimeList_AttendanceTime_Id", referencedColumnName = "Id")
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
