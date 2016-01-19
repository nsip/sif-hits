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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((calendarDate == null) ? 0 : calendarDate.hashCode());
    result = prime * result + ((otherCode == null) ? 0 : otherCode.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    CalendarDateTypeOtherCodeId other = (CalendarDateTypeOtherCodeId) obj;
    if (calendarDate == null) {
      if (other.calendarDate != null) return false;
    } else if (!calendarDate.equals(other.calendarDate)) return false;
    if (otherCode == null) {
      if (other.otherCode != null) return false;
    } else if (!otherCode.equals(other.otherCode)) return false;
    return true;
  }

}
