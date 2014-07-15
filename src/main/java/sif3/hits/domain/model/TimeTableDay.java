package sif3.hits.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TimeTable_Day")
public class TimeTableDay implements Serializable {
  private static final long serialVersionUID = -6305870667354354202L;
  
  @EmbeddedId
  private TimeTableDayId timeTableDayId;
  private String dayTitle;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "timeTablePeriodId.timeTableDay")
  private Set<TimeTablePeriod> periods;

  public TimeTableDayId getTimeTableDayId() {
    return timeTableDayId;
  }

  public void setTimeTableDayId(TimeTableDayId timeTableDayId) {
    this.timeTableDayId = timeTableDayId;
  }

  @Transient
  public TimeTable getTimeTable() {
    TimeTable result = null;
    if (timeTableDayId != null) {
      result = timeTableDayId.getTimeTable();
    }
    return result;
  }

  @Transient
  public void setTimeTable(TimeTable timeTable) {
    if (timeTableDayId == null) {
      timeTableDayId = new TimeTableDayId();
    }
    this.timeTableDayId.setTimeTable(timeTable);
  }

  @Transient
  public String getDayId() {
    String result = null;
    if (timeTableDayId != null) {
      result = timeTableDayId.getDayId();
    }
    return result;
  }

  @Transient
  public void setDayId(String dayId) {
    if (timeTableDayId == null) {
      timeTableDayId = new TimeTableDayId();
    }
    this.timeTableDayId.setDayId(dayId);
  }

  public String getDayTitle() {
    return dayTitle;
  }

  public void setDayTitle(String dayTitle) {
    this.dayTitle = dayTitle;
  }
  
  public Set<TimeTablePeriod> getPeriods() {
    return periods;
  }
  
  public void setPeriods(Set<TimeTablePeriod> periods) {
    this.periods = periods;
  }
}
