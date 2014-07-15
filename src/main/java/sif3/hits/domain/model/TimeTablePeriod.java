package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TimeTable_Period")
public class TimeTablePeriod implements Serializable {
  private static final long serialVersionUID = -6732324236116970159L;

  @EmbeddedId
  private TimeTablePeriodId timeTablePeriodId;
  private String periodTitle;
  private String bellPeriod;
  private String startTime;
  private String endTime;

  public TimeTablePeriodId getTimeTablePeriodId() {
    return timeTablePeriodId;
  }

  public void setTimeTablePeriodId(TimeTablePeriodId timeTablePeriodId) {
    this.timeTablePeriodId = timeTablePeriodId;
  }

  @Transient
  public TimeTableDay getTimeTableDay() {
    TimeTableDay result = null;
    if (timeTablePeriodId != null) {
      result = timeTablePeriodId.getTimeTableDay();
    }
    return result;
  }

  @Transient
  public void setTimeTableDay(TimeTableDay timeTableDay) {
    if (timeTablePeriodId == null) {
      timeTablePeriodId = new TimeTablePeriodId();
    }
    this.timeTablePeriodId.setTimeTableDay(timeTableDay);
  }

  @Transient
  public String getPeriodId() {
    String result = null;
    if (timeTablePeriodId != null) {
      result = timeTablePeriodId.getPeriodId();
    }
    return result;
  }

  @Transient
  public void setPeriodId(String dayId) {
    if (timeTablePeriodId == null) {
      timeTablePeriodId = new TimeTablePeriodId();
    }
    this.timeTablePeriodId.setPeriodId(dayId);
  }

  public String getPeriodTitle() {
    return periodTitle;
  }

  public void setPeriodTitle(String dayTitle) {
    this.periodTitle = dayTitle;
  }

  public String getBellPeriod() {
    return bellPeriod;
  }

  public void setBellPeriod(String bellPeriod) {
    this.bellPeriod = bellPeriod;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
}
