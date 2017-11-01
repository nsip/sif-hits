package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class StudentAttendanceTimeOtherCodeId implements Serializable {
  private static final long serialVersionUID = -9003670611749759137L;

  private Long id;
  private String otherCode;
  private String codeSet;

  @Column(name = "StudentAttendanceTimeList_AttendanceTime_id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codeSet == null) ? 0 : codeSet.hashCode());
    result = prime * result + ((otherCode == null) ? 0 : otherCode.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    StudentAttendanceTimeOtherCodeId other = (StudentAttendanceTimeOtherCodeId) obj;
    if (codeSet == null) {
      if (other.codeSet != null) return false;
    } else if (!codeSet.equals(other.codeSet)) return false;
    if (otherCode == null) {
      if (other.otherCode != null) return false;
    } else if (!otherCode.equals(other.otherCode)) return false;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }

}