package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TeachingGroup extends HitsEntity {
  private static final long serialVersionUID = -9118445084485647016L;

  private String refId;
  private String shortName;
  private String longName;
  private String localId;
  private String schoolYear;
  private String kla;
  private SchoolInfo schoolInfo;
  private Set<StudentPersonal> studentPersonals;
  private Set<TeachingGroupTeacher> teachingGroupTeachers;
  private Set<TimeTableCell> timeTablePeriods;
  private TimeTableSubject timeTableSubject;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getLongName() {
    return longName;
  }

  public void setLongName(String longName) {
    this.longName = longName;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  @Column(name = "KLA")
  public String getKla() {
    return kla;
  }

  public void setKla(String kla) {
    this.kla = kla;
  }

  @ManyToOne
  @JoinColumn(name = "SchoolInfo_RefId")
  public SchoolInfo getSchoolInfo() {
    return schoolInfo;
  }

  public void setSchoolInfo(SchoolInfo schoolInfo) {
    this.schoolInfo = schoolInfo;
  }

  @ManyToMany
  @JoinTable(name = "TeachingGroup_Student", joinColumns = { @JoinColumn(name = "TeachingGroup_RefId", referencedColumnName = "RefId") }, inverseJoinColumns = {
      @JoinColumn(name = "StudentPersonal_RefId", referencedColumnName = "RefId") })
  public Set<StudentPersonal> getStudentPersonals() {
    return studentPersonals;
  }

  public void setStudentPersonals(Set<StudentPersonal> studentPersonals) {
    this.studentPersonals = studentPersonals;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "teachingGroupTeacherId.teachingGroup")
  public Set<TeachingGroupTeacher> getTeachingGroupTeachers() {
    return teachingGroupTeachers;
  }

  public void setTeachingGroupTeachers(Set<TeachingGroupTeacher> teachingGroupTeachers) {
    this.teachingGroupTeachers = teachingGroupTeachers;
  }

  @OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, mappedBy = "teachingGroup")
  public Set<TimeTableCell> getTimeTablePeriods() {
    return timeTablePeriods;
  }

  public void setTimeTablePeriods(Set<TimeTableCell> timeTablePeriods) {
    this.timeTablePeriods = timeTablePeriods;
  }

  @ManyToOne
  @JoinColumn(name = "TimeTableSubject_RefId", referencedColumnName = "RefId")
  public TimeTableSubject getTimeTableSubject() {
    return timeTableSubject;
  }

  public void setTimeTableSubject(TimeTableSubject timeTableSubject) {
    this.timeTableSubject = timeTableSubject;
  }
}
