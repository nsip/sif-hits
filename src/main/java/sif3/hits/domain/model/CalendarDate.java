package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class CalendarDate extends HitsEntity {
  private static final long serialVersionUID = -8738735661622663019L;

  private String refId;
  private CalendarSummary calendarSummary;
  private String calendarDate;
  private SchoolInfo schoolInfo;
  
  private String schoolYear;
  private String localId;
  private String daysInSession;
  private String startDate;
  private String endDate;
  
  private Set<CalendarDate> calendarDates;
  
  
}
