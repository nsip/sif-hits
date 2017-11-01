package sif3.hits.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TimeTable_Day")
public class TimeTableDay implements Serializable {
  private static final long serialVersionUID = -6305870667354354202L;

  private Long id;
  private TimeTable timeTable;
  private String dayId;
  private String dayTitle;
  private Set<TimeTablePeriod> periods;

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "TimeTable_RefId")
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

  public String getDayTitle() {
    return dayTitle;
  }

  public void setDayTitle(String dayTitle) {
    this.dayTitle = dayTitle;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "timeTableDay")
  public Set<TimeTablePeriod> getPeriods() {
    return periods;
  }

  public void setPeriods(Set<TimeTablePeriod> periods) {
    this.periods = periods;
  }
}
