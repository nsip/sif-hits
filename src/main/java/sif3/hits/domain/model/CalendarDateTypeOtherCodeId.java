package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CalendarDateTypeOtherCodeId implements Serializable {
  private static final long serialVersionUID = -5707699608603105422L;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "CalendarDate_RefId", referencedColumnName = "RefId")
  private CalendarDate calendarDate;
  private String otherCode;

  public CalendarDate getCalendarDate() {
    return calendarDate;
  }

  public void setCalendarDate(CalendarDate calendarDate) {
    this.calendarDate = calendarDate;
  }

  public String getOtherCode() {
    return otherCode;
  }

  public void setOtherCode(String otherCode) {
    this.otherCode = otherCode;
  }
}
