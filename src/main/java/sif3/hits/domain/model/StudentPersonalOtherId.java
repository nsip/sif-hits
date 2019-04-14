package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "StudentPersonal_OtherId")
public class StudentPersonalOtherId implements Serializable {
  private static final long serialVersionUID = 603884775630519212L;

  private Long id;
  private StudentPersonal studentPersonal;
  private String otherId;
  private String otherIdType;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "StudentPersonal_RefId", referencedColumnName = "RefId")
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
