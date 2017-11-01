package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentPersonalOtherIdId implements Serializable {
  private static final long serialVersionUID = 8116304826135644138L;

  @ManyToOne(optional = false)
  @JoinColumn(name = "StudentPersonal_RefId", referencedColumnName = "RefId")
  private StudentPersonal studentPersonal;
  private String otherId;
  private String otherIdType;

  public StudentPersonal getStudentPersonal() {
    return studentPersonal;
  }

  public void setStudentPersonal(StudentPersonal studentPersonal) {
    this.studentPersonal = studentPersonal;
  }

  public String getOtherId() {
    return otherId;
  }

  public void setOtherId(String otherId) {
    this.otherId = otherId;
  }

  public String getOtherIdType() {
    return otherIdType;
  }

  public void setOtherIdType(String otherIdType) {
    this.otherIdType = otherIdType;
  }
}
