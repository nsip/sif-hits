package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TimeTable_Period")
public class TimeTablePeriod implements Serializable {
  private static final long serialVersionUID = -6732324236116970159L;

  private Long id;
  private TimeTableDay timeTableDay;
  private String TimeTable_RefId;
  private String dayId;
  private String periodId;
  private String periodTitle;
  private String bellPeriod;
  private String startTime;
  private String endTime;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "TimeTable_Day_Id")
  public TimeTableDay getTimeTableDay() {
    return timeTableDay;
  }

  public void setTimeTableDay(TimeTableDay timeTableDay) {
    this.timeTableDay = timeTableDay;
  }

  public String getTimeTable_RefId() {
    return TimeTable_RefId;
  }

  public void setTimeTable_RefId(String timeTable_RefId) {
    TimeTable_RefId = timeTable_RefId;
  }

  public String getDayId() {
    return dayId;
  }

  public void setDayId(String dayId) {
    this.dayId = dayId;
  }

  public String getPeriodId() {
    return periodId;
  }

  public void setPeriodId(String periodId) {
    this.periodId = periodId;
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
