package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CalendarSummary extends HitsEntity {
  private static final long serialVersionUID = -5955654294617490213L;

  private String refId;
  private String schoolInfoRefId;
  private String schoolYear;
  private String localId;
  private String daysInSession;
  private String startDate;
  private String endDate;
  private String firstInstructionDate;
  private String lastInstructionDate;
  private String instructionalMinutes;
  private String minutesPerDay;
  private Set<CalendarSummaryYearLevel> calendarSummaryYearLevels;

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

  public String getFirstInstructionDate() {
    return firstInstructionDate;
  }

  public void setFirstInstructionDate(String firstInstructionDate) {
    this.firstInstructionDate = firstInstructionDate;
  }

  public String getLastInstructionDate() {
    return lastInstructionDate;
  }

  public void setLastInstructionDate(String lastInstructionDate) {
    this.lastInstructionDate = lastInstructionDate;
  }

  public String getInstructionalMinutes() {
    return instructionalMinutes;
  }

  public void setInstructionalMinutes(String instructionalMinutes) {
    this.instructionalMinutes = instructionalMinutes;
  }

  public String getMinutesPerDay() {
    return minutesPerDay;
  }

  public void setMinutesPerDay(String minutesPerDay) {
    this.minutesPerDay = minutesPerDay;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "calendarSummaryYearLevelId.calendarSummary")
  public Set<CalendarSummaryYearLevel> getCalendarSummaryYearLevels() {
    return calendarSummaryYearLevels;
  }

  public void setCalendarSummaryYearLevels(Set<CalendarSummaryYearLevel> calendarSummaryYearLevels) {
    this.calendarSummaryYearLevels = calendarSummaryYearLevels;
  }
}
