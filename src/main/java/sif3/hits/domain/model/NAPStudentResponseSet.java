package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NAPStudentResponseSet extends HitsEntity {
  private static final long serialVersionUID = 8441204090580999795L;

  private String refId;
  private NAPTest napTest;
  private StudentPersonal studentPersonal;
  private Set<DomainScore> domainScores;
  private Set<TestletResponse> testletList;
  private String calibrationSampleFlag;
  private String equatingSampleFlag;
  private String pathTakenForDomain;
  private String reportExclusionFlag;
  private String parallelTest;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "NAPTest_RefId")
  public NAPTest getNapTest() {
    return napTest;
  }

  public void setNapTest(NAPTest napTest) {
    this.napTest = napTest;
  }

  @ManyToOne
  @JoinColumn(name = "StudentPersonal_RefId")
  public StudentPersonal getStudentPersonal() {
    return studentPersonal;
  }

  public void setStudentPersonal(StudentPersonal studentPersonal) {
    this.studentPersonal = studentPersonal;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "napStudentResponseSet")
  public Set<DomainScore> getDomainScores() {
    return domainScores;
  }

  public void setDomainScores(Set<DomainScore> domainScores) {
    this.domainScores = domainScores;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "napStudentResponseSet")
  public Set<TestletResponse> getTestletList() {
    return testletList;
  }

  public void setTestletList(Set<TestletResponse> testletList) {
    this.testletList = testletList;
  }

  public String getCalibrationSampleFlag() {
    return calibrationSampleFlag;
  }

  public void setCalibrationSampleFlag(String calibrationSampleFlag) {
    this.calibrationSampleFlag = calibrationSampleFlag;
  }

  public String getEquatingSampleFlag() {
    return equatingSampleFlag;
  }

  public void setEquatingSampleFlag(String equatingSampleFlag) {
    this.equatingSampleFlag = equatingSampleFlag;
  }

  public String getPathTakenForDomain() {
    return pathTakenForDomain;
  }

  public void setPathTakenForDomain(String pathTakenForDomain) {
    this.pathTakenForDomain = pathTakenForDomain;
  }

  public String getReportExclusionFlag() {
    return reportExclusionFlag;
  }

  public void setReportExclusionFlag(String reportExclusionFlag) {
    this.reportExclusionFlag = reportExclusionFlag;
  }

  public String getParallelTest() {
    return parallelTest;
  }

  public void setParallelTest(String parallelTest) {
    this.parallelTest = parallelTest;
  }
}