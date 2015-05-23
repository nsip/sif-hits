package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TimeTableSubject extends HitsEntity {
  private static final long serialVersionUID = 2582961677925949934L;

  private String refId;
  private SchoolInfo schoolInfo;
  private String subjectLocalId;
  private String academicYear;
  private String faculty;
  private String subjectShortName;
  private String subjectLongName;
  private String subjectType;
  private String proposedMinClassSize;
  private String proposedMaxClassSize;
  private String semester;
  private String schoolYear;
  private Set<TimeTableSubjectOtherCode> otherCodes;

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

  public String getSubjectLocalId() {
    return subjectLocalId;
  }

  public void setSubjectLocalId(String subjectLocalId) {
    this.subjectLocalId = subjectLocalId;
  }

  public String getAcademicYear() {
    return academicYear;
  }

  public void setAcademicYear(String academicYear) {
    this.academicYear = academicYear;
  }

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public String getSubjectShortName() {
    return subjectShortName;
  }

  public void setSubjectShortName(String subjectShortName) {
    this.subjectShortName = subjectShortName;
  }

  public String getSubjectLongName() {
    return subjectLongName;
  }

  public void setSubjectLongName(String subjectLongName) {
    this.subjectLongName = subjectLongName;
  }

  public String getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "timeTableSubjectOtherCodeId.timeTableSubject")
  public Set<TimeTableSubjectOtherCode> getOtherCodes() {
    return otherCodes;
  }

  public void setOtherCodes(Set<TimeTableSubjectOtherCode> otherCodes) {
    this.otherCodes = otherCodes;
  }

  public String getProposedMinClassSize() {
    return proposedMinClassSize;
  }

  public void setProposedMinClassSize(String proposedMinClassSize) {
    this.proposedMinClassSize = proposedMinClassSize;
  }

  public String getProposedMaxClassSize() {
    return proposedMaxClassSize;
  }

  public void setProposedMaxClassSize(String proposedMaxClassSize) {
    this.proposedMaxClassSize = proposedMaxClassSize;
  }

  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }
}
