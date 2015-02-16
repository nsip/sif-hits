package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CalendarSummary_YearLevel")
public class CalendarSummaryYearLevel implements Serializable {
  private static final long serialVersionUID = -6305870667354354202L;

  @EmbeddedId
  private CalendarSummaryYearLevelId calendarSummaryYearLevelId;

  public CalendarSummaryYearLevelId getCalendarDateTypeOtherCodeId() {
    return calendarSummaryYearLevelId;
  }

  public void setCalendarDateTypeOtherCodeId(CalendarSummaryYearLevelId calendarSummaryYearLevelId) {
    this.calendarSummaryYearLevelId = calendarSummaryYearLevelId;
  }

  @Transient
  public CalendarSummary getCalendarSummary() {
    CalendarSummary result = null;
    if (calendarSummaryYearLevelId != null) {
      result = calendarSummaryYearLevelId.getCalendarSummary();
    }
    return result;
  }

  @Transient
  public void setCalendarSummary(CalendarSummary calendarSummary) {
    if (calendarSummaryYearLevelId == null) {
      calendarSummaryYearLevelId = new CalendarSummaryYearLevelId();
    }
    this.calendarSummaryYearLevelId.setCalendarSummary(calendarSummary);
  }

  @Transient
  public String getYearLevel() {
    String result = null;
    if (calendarSummaryYearLevelId != null) {
      result = calendarSummaryYearLevelId.getYearLevel();
    }
    return result;
  }

  @Transient
  public void setYearLevel(String yearLevel) {
    if (calendarSummaryYearLevelId == null) {
      calendarSummaryYearLevelId = new CalendarSummaryYearLevelId();
    }
    this.calendarSummaryYearLevelId.setYearLevel(yearLevel);
  }
}
