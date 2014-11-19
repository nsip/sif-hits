package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CalendarDateType_OtherCodeList")
public class CalendarDateTypeOtherCode implements Serializable {
  private static final long serialVersionUID = -6305870667354354202L;

  @EmbeddedId
  private CalendarDateTypeOtherCodeId calendarDateTypeOtherCodeId;
  @Column(name = "OtherCode_CodeSet")
  private String codeSet;

  public CalendarDateTypeOtherCodeId getCalendarDateTypeOtherCodeId() {
    return calendarDateTypeOtherCodeId;
  }

  public void setCalendarDateTypeOtherCodeId(CalendarDateTypeOtherCodeId calendarDateTypeOtherCodeId) {
    this.calendarDateTypeOtherCodeId = calendarDateTypeOtherCodeId;
  }

  @Transient
  public CalendarDate getCalendarDate() {
    CalendarDate result = null;
    if (calendarDateTypeOtherCodeId != null) {
      result = calendarDateTypeOtherCodeId.getCalendarDate();
    }
    return result;
  }

  @Transient
  public void setCalendarDate(CalendarDate calendarDate) {
    if (calendarDateTypeOtherCodeId == null) {
      calendarDateTypeOtherCodeId = new CalendarDateTypeOtherCodeId();
    }
    this.calendarDateTypeOtherCodeId.setCalendarDate(calendarDate);
  }

  @Transient
  public String getOtherCode() {
    String result = null;
    if (calendarDateTypeOtherCodeId != null) {
      result = calendarDateTypeOtherCodeId.getOtherCode();
    }
    return result;
  }

  @Transient
  public void setOtherCode(String otherCode) {
    if (calendarDateTypeOtherCodeId == null) {
      calendarDateTypeOtherCodeId = new CalendarDateTypeOtherCodeId();
    }
    this.calendarDateTypeOtherCodeId.setOtherCode(otherCode);
  }

  public String getCodeSet() {
    return codeSet;
  }

  public void setCodeSet(String codeSet) {
    this.codeSet = codeSet;
  }
}
