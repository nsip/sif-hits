package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class TimeTablePeriodId implements Serializable {
  private static final long serialVersionUID = 176713052615789947L;

  @ManyToOne(optional = false)
  @JoinColumns({ @JoinColumn(name = "TimeTable_RefId", referencedColumnName = "TimeTable_RefId"),
      @JoinColumn(name = "DayId", referencedColumnName = "DayId") })
  private TimeTableDay timeTableDay;
  private String periodId;

  public TimeTableDay getTimeTableDay() {
    return timeTableDay;
  }

  public void setTimeTableDay(TimeTableDay timeTableDay) {
    this.timeTableDay = timeTableDay;
  }

  public String getPeriodId() {
    return periodId;
  }

  public void setPeriodId(String periodId) {
    this.periodId = periodId;
  }
}
