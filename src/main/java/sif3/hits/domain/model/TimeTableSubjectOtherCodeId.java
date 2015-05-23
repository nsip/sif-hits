package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TimeTableSubjectOtherCodeId implements Serializable {
  private static final long serialVersionUID = -9003670611749759137L;

  @ManyToOne(optional = false)
  @JoinColumn(name = "TimeTableSubject_RefId", referencedColumnName = "RefId")
  private TimeTableSubject timeTableSubject;

  private String otherCode;

  @Column(name = "OtherCode_CodeSet")
  private String codeSet;

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

  public String getCodeSet() {
    return codeSet;
  }

  public void setCodeSet(String codeSet) {
    this.codeSet = codeSet;
  }
}