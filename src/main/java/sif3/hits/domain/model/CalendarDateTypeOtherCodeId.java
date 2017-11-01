package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CalendarDateTypeOtherCodeId implements Serializable {
  private static final long serialVersionUID = -5707699608603105422L;

  private CalendarDate calendarDate;
  private String otherCode;
  private String codeSet;

  @ManyToOne(optional = false)
  @JoinColumn(name = "CalendarDate_RefId", referencedColumnName = "RefId")
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
    result = prime * result + ((calendarDate == null) ? 0 : calendarDate.hashCode());
    result = prime * result + ((codeSet == null) ? 0 : codeSet.hashCode());
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
    if (codeSet == null) {
      if (other.codeSet != null) return false;
    } else if (!codeSet.equals(other.codeSet)) return false;
    if (otherCode == null) {
      if (other.otherCode != null) return false;
    } else if (!otherCode.equals(other.otherCode)) return false;
    return true;
  }

}
