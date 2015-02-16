package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CalendarSummaryYearLevelId implements Serializable {
  private static final long serialVersionUID = -5707699608603105422L;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "CalendarSummary_RefId", referencedColumnName = "RefId")
  private CalendarSummary calendarSummary;
  private String yearLevel;

  public CalendarSummary getCalendarSummary() {
    return calendarSummary;
  }

  public void setCalendarSummary(CalendarSummary calendarSummary) {
    this.calendarSummary = calendarSummary;
  }

  public String getYearLevel() {
    return yearLevel;
  }

  public void setYearLevel(String yearLevel) {
    this.yearLevel = yearLevel;
  }
}
