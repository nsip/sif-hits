package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TimeTableSubject extends HitsEntity {
  private static final long serialVersionUID = 2582961677925949934L;

  private String refId;
  private String subjectLocalId;
  private String academicYear;
  private String faculty;
  private String subjectShortName;
  private String subjectLongName;
  private String subjectType;
  private SchoolInfo schoolInfo;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
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

  @ManyToOne
  @JoinColumn(name = "SchoolInfo_RefId", referencedColumnName = "RefId")
  public SchoolInfo getSchoolInfo() {
    return schoolInfo;
  }

  public void setSchoolInfo(SchoolInfo schoolInfo) {
    this.schoolInfo = schoolInfo;
  }
}
