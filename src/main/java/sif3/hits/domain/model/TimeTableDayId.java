package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dayId == null) ? 0 : dayId.hashCode());
    result = prime * result + ((timeTable == null || timeTable.getRefId() == null) ? 0 : timeTable.getRefId().hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TimeTableDayId that = (TimeTableDayId) obj;
    
    String thisTimeTableRef = this.getTimeTable() == null ? null : this.getTimeTable().getRefId();
    String thatTimeTableRef = that.getTimeTable() == null ? null : that.getTimeTable().getRefId();
    String thisDayId = this.getDayId();
    String thatDayId = that.getDayId();
    
    return new EqualsBuilder().append(thisTimeTableRef, thatTimeTableRef).append(thisDayId, thatDayId).isEquals();
  }
}
