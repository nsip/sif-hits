package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AGStatusReport extends HitsEntity {
  private static final long serialVersionUID = -4234234991938219L;

  private String refId;
  private String reportingAuthority;
  private String reportingAuthoritySystem;
  private String reportingAuthorityCommonwealthId;
  private String submittedBy;
  private String submissionTimestamp;
  private String agCollection;
  private String collectionYear;
  private List<AGReportingObjectResponse> agReportingObjectResponseList;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getReportingAuthority() {
    return reportingAuthority;
  }

  public void setReportingAuthority(String reportingAuthority) {
    this.reportingAuthority = reportingAuthority;
  }

  public String getReportingAuthoritySystem() {
    return reportingAuthoritySystem;
  }

  public void setReportingAuthoritySystem(String reportingAuthoritySystem) {
    this.reportingAuthoritySystem = reportingAuthoritySystem;
  }

  public String getReportingAuthorityCommonwealthId() {
    return reportingAuthorityCommonwealthId;
  }

  public void setReportingAuthorityCommonwealthId(String reportingAuthorityCommonwealthId) {
    this.reportingAuthorityCommonwealthId = reportingAuthorityCommonwealthId;
  }

  public String getSubmittedBy() {
    return submittedBy;
  }

  public void setSubmittedBy(String submittedBy) {
    this.submittedBy = submittedBy;
  }

  public String getSubmissionTimestamp() {
    return submissionTimestamp;
  }

  public void setSubmissionTimestamp(String submissionTimestamp) {
    this.submissionTimestamp = submissionTimestamp;
  }

  public String getAgCollection() {
    return agCollection;
  }

  public void setAgCollection(String agCollection) {
    this.agCollection = agCollection;
  }

  public String getCollectionYear() {
    return collectionYear;
  }

  public void setCollectionYear(String collectionYear) {
    this.collectionYear = collectionYear;
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agStatusReport")
  public List<AGReportingObjectResponse> getAgReportingObjectResponseList() {
    return agReportingObjectResponseList;
  }

  public void setAgReportingObjectResponseList(List<AGReportingObjectResponse> agReportingObjectResponseList) {
    this.agReportingObjectResponseList = agReportingObjectResponseList;
  }
}
