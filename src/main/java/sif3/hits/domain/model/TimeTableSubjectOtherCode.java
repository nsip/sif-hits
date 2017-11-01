package sif3.hits.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TimeTableSubject_OtherCodeList")
public class TimeTableSubjectOtherCode extends HitsEntity {
  private static final long serialVersionUID = 1161008894259012408L;

  private TimeTableSubjectOtherCodeId timeTableSubjectOtherCodeId;

  @EmbeddedId
  public TimeTableSubjectOtherCodeId getTimeTableSubjectOtherCodeId() {
    return timeTableSubjectOtherCodeId;
  }

  public void setTimeTableSubjectOtherCodeId(TimeTableSubjectOtherCodeId timeTableSubjectOtherCodeId) {
    this.timeTableSubjectOtherCodeId = timeTableSubjectOtherCodeId;
  }

  @Transient
  public TimeTableSubject getTimeTableSubject() {
    TimeTableSubject result = null;
    if (timeTableSubjectOtherCodeId != null) {
      result = timeTableSubjectOtherCodeId.getTimeTableSubject();
    }
    return result;
  }

  @Transient
  public void setTimeTableSubject(TimeTableSubject timeTableSubject) {
    if (timeTableSubjectOtherCodeId == null) {
      timeTableSubjectOtherCodeId = new TimeTableSubjectOtherCodeId();
    }
    this.timeTableSubjectOtherCodeId.setTimeTableSubject(timeTableSubject);
  }

  @Transient
  public String getOtherCode() {
    String result = null;
    if (timeTableSubjectOtherCodeId != null) {
      result = timeTableSubjectOtherCodeId.getOtherCode();
    }
    return result;
  }

  @Transient
  public void setOtherCode(String otherCode) {
    if (timeTableSubjectOtherCodeId == null) {
      timeTableSubjectOtherCodeId = new TimeTableSubjectOtherCodeId();
    }
    this.timeTableSubjectOtherCodeId.setOtherCode(otherCode);
  }

  @Transient
  public String getCodeSet() {
    String result = null;
    if (timeTableSubjectOtherCodeId != null) {
      result = timeTableSubjectOtherCodeId.getCodeSet();
    }
    return result;
  }

  @Transient
  public void setCodeSet(String codeSet) {
    if (timeTableSubjectOtherCodeId == null) {
      timeTableSubjectOtherCodeId = new TimeTableSubjectOtherCodeId();
    }
    this.timeTableSubjectOtherCodeId.setCodeSet(codeSet);
  }

}
