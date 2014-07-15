package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TimeTableDayId implements Serializable {
  private static final long serialVersionUID = -2935610636132357322L;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "TimeTable_RefId", referencedColumnName = "RefId")
  private TimeTable timeTable;
  private String dayId;

  public TimeTable getTimeTable() {
    return timeTable;
  }

  public void setTimeTable(TimeTable timeTable) {
    this.timeTable = timeTable;
  }

  public String getDayId() {
    return dayId;
  }

  public void setDayId(String dayId) {
    this.dayId = dayId;
  }
}
