package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StudentAttendanceTimeList_AttendanceTime")
public class StudentAttendanceTime {
  
  private StudentAttendanceTimeId studentAttendanceTimeId;

  private String code;
  private String attendanceStatus;
  private String endTime;
  private String absenceValue;
  private String attendanceNote;
  
  private Set<StudentAttendanceTimeOtherCode> otherCodes;

  @EmbeddedId
  public StudentAttendanceTimeId getStudentAttendanceTimeId() {
    return studentAttendanceTimeId;
  }

  public void setStudentAttendanceTimeId(StudentAttendanceTimeId studentAttendanceTimeId) {
    this.studentAttendanceTimeId = studentAttendanceTimeId;
  }

  @Transient
  public StudentAttendanceTimeList getStudentAttendanceTimeList() {
    StudentAttendanceTimeList result = null;
    if (studentAttendanceTimeId != null) {
      result = studentAttendanceTimeId.getStudentAttendanceTimeList();
    }
    return result;
  }

  @Transient
  public void setStudentAttendanceTimeList(StudentAttendanceTimeList studentAttendanceTimeList) {
    if (studentAttendanceTimeId == null) {
      studentAttendanceTimeId = new StudentAttendanceTimeId();
    }
    this.studentAttendanceTimeId.setStudentAttendanceTimeList(studentAttendanceTimeList);
  }

  @Transient
  public String getStartTime() {
    String result = null;
    if (studentAttendanceTimeId != null) {
      result = studentAttendanceTimeId.getStartTime();
    }
    return result;
  }

  @Transient
  public void setStartTime(String startTime) {
    if (studentAttendanceTimeId == null) {
      studentAttendanceTimeId = new StudentAttendanceTimeId();
    }
    this.studentAttendanceTimeId.setStartTime(startTime);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getAttendanceStatus() {
    return attendanceStatus;
  }

  public void setAttendanceStatus(String attendanceStatus) {
    this.attendanceStatus = attendanceStatus;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
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
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentAttendanceTimeOtherCodeId.studentAttendanceTime")
  public Set<StudentAttendanceTimeOtherCode> getOtherCodes() {
    return otherCodes;
  }
  
  public void setOtherCodes(Set<StudentAttendanceTimeOtherCode> otherCodes) {
    this.otherCodes = otherCodes;
  }
}
