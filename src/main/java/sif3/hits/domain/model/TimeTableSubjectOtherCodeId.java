package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TimeTableSubjectOtherCodeId implements Serializable {
  private static final long serialVersionUID = -9003670611749759137L;

  private TimeTableSubject timeTableSubject;
  private String otherCode;
  private String codeSet;

  @ManyToOne(optional = false)
  @JoinColumn(name = "TimeTableSubject_RefId", referencedColumnName = "RefId")
  public TimeTableSubject getTimeTableSubject() {
    return timeTableSubject;
  }

  public void setTimeTableSubject(TimeTableSubject timeTableSubject) {
    this.timeTableSubject = timeTableSubject;
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
    result = prime * result + ((timeTableSubject == null) ? 0 : timeTableSubject.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TimeTableSubjectOtherCodeId other = (TimeTableSubjectOtherCodeId) obj;
    if (codeSet == null) {
      if (other.codeSet != null) return false;
    } else if (!codeSet.equals(other.codeSet)) return false;
    if (otherCode == null) {
      if (other.otherCode != null) return false;
    } else if (!otherCode.equals(other.otherCode)) return false;
    if (timeTableSubject == null) {
      if (other.timeTableSubject != null) return false;
    } else if (!timeTableSubject.equals(other.timeTableSubject)) return false;
    return true;
  }

}