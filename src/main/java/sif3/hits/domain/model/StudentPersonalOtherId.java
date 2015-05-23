package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "StudentPersonal_OtherId")
public class StudentPersonalOtherId implements Serializable {
  private static final long serialVersionUID = 603884775630519212L;

  @EmbeddedId
  private StudentPersonalOtherIdId studentPersonalOtherIdId;

  public StudentPersonalOtherIdId getStudentPersonalOtherIdId() {
    return studentPersonalOtherIdId;
  }

  public void setStudentPersonalOtherIdId(StudentPersonalOtherIdId studentPersonalOtherIdId) {
    this.studentPersonalOtherIdId = studentPersonalOtherIdId;
  }

  @Transient
  public StudentPersonal getStudentPersonal() {
    StudentPersonal result = null;
    if (studentPersonalOtherIdId != null) {
      result = studentPersonalOtherIdId.getStudentPersonal();
    }
    return result;
  }

  @Transient
  public void setStudentPersonal(StudentPersonal studentPersonal) {
    if (studentPersonalOtherIdId == null) {
      studentPersonalOtherIdId = new StudentPersonalOtherIdId();
    }
    this.studentPersonalOtherIdId.setStudentPersonal(studentPersonal);
  }

  @Transient
  public String getOtherId() {
    String result = null;
    if (studentPersonalOtherIdId != null) {
      result = studentPersonalOtherIdId.getOtherId();
    }
    return result;
  }

  @Transient
  public void setOtherId(String otherId) {
    if (studentPersonalOtherIdId == null) {
      studentPersonalOtherIdId = new StudentPersonalOtherIdId();
    }
    this.studentPersonalOtherIdId.setOtherId(otherId);
  }

  @Transient
  public String getOtherIdType() {
    String result = null;
    if (studentPersonalOtherIdId != null) {
      result = studentPersonalOtherIdId.getOtherIdType();
    }
    return result;
  }

  @Transient
  public void setOtherIdType(String otherIdType) {
    if (studentPersonalOtherIdId == null) {
      studentPersonalOtherIdId = new StudentPersonalOtherIdId();
    }
    this.studentPersonalOtherIdId.setOtherIdType(otherIdType);
  }

}
