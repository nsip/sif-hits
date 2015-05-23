package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentAttendanceTimeId implements Serializable {
  private static final long serialVersionUID = -7792520852219637268L;

  private StudentAttendanceTimeList studentAttendanceTimeList;
  private String startTime;

  @ManyToOne(optional = false)
  @JoinColumn(name = "StudentAttendanceTimeList_RefId", referencedColumnName = "RefId")
  public StudentAttendanceTimeList getStudentAttendanceTimeList() {
    return studentAttendanceTimeList;
  }
  
  public void setStudentAttendanceTimeList(StudentAttendanceTimeList studentAttendanceTimeList) {
    this.studentAttendanceTimeList = studentAttendanceTimeList;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

}
