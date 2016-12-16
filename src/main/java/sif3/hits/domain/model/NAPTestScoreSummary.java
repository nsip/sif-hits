package sif3.hits.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NAPTestScoreSummary extends HitsEntity {
  private static final long serialVersionUID = -7786504144016316410L;

  private String refId;
  private String domainBottomNational60Percent;
  private String domainJurisdictionAverage;
  private String domainNationalAverage;
  private String domainSchoolAverage;
  private String domainTopNational60Percent;

  private NAPTest napTest;
  private SchoolInfo schoolInfo;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getDomainBottomNational60Percent() {
    return domainBottomNational60Percent;
  }

  public void setDomainBottomNational60Percent(String domainBottomNational60Percent) {
    this.domainBottomNational60Percent = domainBottomNational60Percent;
  }

  public String getDomainJurisdictionAverage() {
    return domainJurisdictionAverage;
  }

  public void setDomainJurisdictionAverage(String domainJurisdictionAverage) {
    this.domainJurisdictionAverage = domainJurisdictionAverage;
  }

  public String getDomainNationalAverage() {
    return domainNationalAverage;
  }

  public void setDomainNationalAverage(String domainNationalAverage) {
    this.domainNationalAverage = domainNationalAverage;
  }

  public String getDomainSchoolAverage() {
    return domainSchoolAverage;
  }

  public void setDomainSchoolAverage(String domainSchoolAverage) {
    this.domainSchoolAverage = domainSchoolAverage;
  }

  public String getDomainTopNational60Percent() {
    return domainTopNational60Percent;
  }

  public void setDomainTopNational60Percent(String domainTopNational60Percent) {
    this.domainTopNational60Percent = domainTopNational60Percent;
  }

  @ManyToOne(cascade = { CascadeType.DETACH })
  @JoinColumn(name="NAPTest_RefId")
  public NAPTest getNapTest() {
    return napTest;
  }

  public void setNapTest(NAPTest napTest) {
    this.napTest = napTest;
  }

  @ManyToOne(cascade = { CascadeType.DETACH })
  @JoinColumn(name="SchoolInfo_RefId")
  public SchoolInfo getSchoolInfo() {
    return schoolInfo;
  }

  public void setSchoolInfo(SchoolInfo schoolInfo) {
    this.schoolInfo = schoolInfo;
  }
}