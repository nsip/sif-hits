package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CalendarSummary extends HitsEntity implements ZoneFilterable {
  private static final long serialVersionUID = -5955654294617490213L;

  private String refId;
  private String schoolInfoRefId;
  private String schoolYear;
  private String localId;
  private String daysInSession;
  private String startDate;
  private String endDate;

  private Set<CalendarDate> calendarDates;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "SchoolInfo_RefId")
  public String getSchoolInfoRefId() {
    return schoolInfoRefId;
  }

  public void setSchoolInfoRefId(String schoolInfoRefId) {
    this.schoolInfoRefId = schoolInfoRefId;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  @Column(name = "CalendarSummary_LocalId")
  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getDaysInSession() {
    return daysInSession;
  }

  public void setDaysInSession(String daysInSession) {
    this.daysInSession = daysInSession;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "calendarSummary")
  public Set<CalendarDate> getCalendarDates() {
    return calendarDates;
  }

  public void setCalendarDates(Set<CalendarDate> calendarDates) {
    this.calendarDates = calendarDates;
  }
}
