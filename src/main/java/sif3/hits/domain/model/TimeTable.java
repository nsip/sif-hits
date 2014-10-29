package sif3.hits.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class TimeTable implements Serializable, ZoneFilterable {

  private static final long serialVersionUID = -9048887544127232601L;

  private String refId;
  private SchoolInfo schoolInfo;
  private String schoolYear;
  private String localId;
  private String title;
  private String daysPerCycle;
  private String periodsPerCycle;
  private Set<TimeTableDay> timeTableDays;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @ManyToOne
  @JoinColumn(name = "SchoolInfo_RefId", referencedColumnName = "RefId")
  public SchoolInfo getSchoolInfo() {
    return schoolInfo;
  }

  public void setSchoolInfo(SchoolInfo schoolInfo) {
    this.schoolInfo = schoolInfo;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDaysPerCycle() {
    return daysPerCycle;
  }

  public void setDaysPerCycle(String daysPerCycle) {
    this.daysPerCycle = daysPerCycle;
  }

  public String getPeriodsPerCycle() {
    return periodsPerCycle;
  }

  public void setPeriodsPerCycle(String periodsPerCycle) {
    this.periodsPerCycle = periodsPerCycle;
  }
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "timeTableDayId.timeTable")
  public Set<TimeTableDay> getTimeTableDays() {
    return timeTableDays;
  }
  
  public void setTimeTableDays(Set<TimeTableDay> timeTableDays) {
    this.timeTableDays = timeTableDays;
  }

  @Override
  @Transient
  public String getSchoolInfoRefId() {
    String result = null;
    if (schoolInfo != null) {
      result = schoolInfo.getRefId();
    }
    return result;
  }
}
