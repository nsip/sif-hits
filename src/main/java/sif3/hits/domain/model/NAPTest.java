package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NAPTest extends HitsEntity {
  private static final long serialVersionUID = 7319531994276539584L;

  private String refId;
  private String localId;
  private String testName;
  private String testLevel;
  private String testType;
  private String domain;
  private String testYear;

  private String stagesCount;

  private String level1Lower;
  private String level1Upper;
  private String level2Lower;
  private String level2Upper;
  private String level3Lower;
  private String level3Upper;
  private String level4Lower;
  private String level4Upper;

  private String band1Lower;
  private String band1Upper;
  private String band2Lower;
  private String band2Upper;
  private String band3Lower;
  private String band3Upper;
  private String band4Lower;
  private String band4Upper;
  private String band5Lower;
  private String band5Upper;
  private String band6Lower;
  private String band6Upper;
  private String band7Lower;
  private String band7Upper;
  private String band8Lower;
  private String band8Upper;
  private String band9Lower;
  private String band9Upper;
  private String band10Lower;
  private String band10Upper;
  
  private Set<NAPTestlet> napTestlets;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  public String getTestLevel() {
    return testLevel;
  }

  public void setTestLevel(String testLevel) {
    this.testLevel = testLevel;
  }

  public String getTestType() {
    return testType;
  }

  public void setTestType(String testType) {
    this.testType = testType;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getTestYear() {
    return testYear;
  }

  public void setTestYear(String testYear) {
    this.testYear = testYear;
  }

  public String getStagesCount() {
    return stagesCount;
  }

  public void setStagesCount(String stagesCount) {
    this.stagesCount = stagesCount;
  }

  @Column(name = "BandProficiency_Level1Lower")
  public String getLevel1Lower() {
    return level1Lower;
  }

  public void setLevel1Lower(String level1Lower) {
    this.level1Lower = level1Lower;
  }

  @Column(name = "BandProficiency_Level1Upper")
  public String getLevel1Upper() {
    return level1Upper;
  }

  public void setLevel1Upper(String level1Upper) {
    this.level1Upper = level1Upper;
  }

  @Column(name = "BandProficiency_Level2Lower")
  public String getLevel2Lower() {
    return level2Lower;
  }

  public void setLevel2Lower(String level2Lower) {
    this.level2Lower = level2Lower;
  }

  @Column(name = "BandProficiency_Level2Upper")
  public String getLevel2Upper() {
    return level2Upper;
  }

  public void setLevel2Upper(String level2Upper) {
    this.level2Upper = level2Upper;
  }

  @Column(name = "BandProficiency_Level3Lower")
  public String getLevel3Lower() {
    return level3Lower;
  }

  public void setLevel3Lower(String level3Lower) {
    this.level3Lower = level3Lower;
  }

  @Column(name = "BandProficiency_Level3Upper")
  public String getLevel3Upper() {
    return level3Upper;
  }

  public void setLevel3Upper(String level3Upper) {
    this.level3Upper = level3Upper;
  }

  @Column(name = "BandProficiency_Level4Lower")
  public String getLevel4Lower() {
    return level4Lower;
  }

  public void setLevel4Lower(String level4Lower) {
    this.level4Lower = level4Lower;
  }

  @Column(name = "BandProficiency_Level4Upper")
  public String getLevel4Upper() {
    return level4Upper;
  }

  public void setLevel4Upper(String level4Upper) {
    this.level4Upper = level4Upper;
  }

  @Column(name = "DomainBands_Band1Lower")
  public String getBand1Lower() {
    return band1Lower;
  }

  public void setBand1Lower(String band1Lower) {
    this.band1Lower = band1Lower;
  }

  @Column(name = "DomainBands_Band1Upper")
  public String getBand1Upper() {
    return band1Upper;
  }

  public void setBand1Upper(String band1Upper) {
    this.band1Upper = band1Upper;
  }

  @Column(name = "DomainBands_Band2Lower")
  public String getBand2Lower() {
    return band2Lower;
  }

  public void setBand2Lower(String band2Lower) {
    this.band2Lower = band2Lower;
  }

  @Column(name = "DomainBands_Band2Upper")
  public String getBand2Upper() {
    return band2Upper;
  }

  public void setBand2Upper(String band2Upper) {
    this.band2Upper = band2Upper;
  }

  @Column(name = "DomainBands_Band3Lower")
  public String getBand3Lower() {
    return band3Lower;
  }

  public void setBand3Lower(String band3Lower) {
    this.band3Lower = band3Lower;
  }

  @Column(name = "DomainBands_Band3Upper")
  public String getBand3Upper() {
    return band3Upper;
  }

  public void setBand3Upper(String band3Upper) {
    this.band3Upper = band3Upper;
  }

  @Column(name = "DomainBands_Band4Lower")
  public String getBand4Lower() {
    return band4Lower;
  }

  public void setBand4Lower(String band4Lower) {
    this.band4Lower = band4Lower;
  }

  @Column(name = "DomainBands_Band4Upper")
  public String getBand4Upper() {
    return band4Upper;
  }

  public void setBand4Upper(String band4Upper) {
    this.band4Upper = band4Upper;
  }

  @Column(name = "DomainBands_Band5Lower")
  public String getBand5Lower() {
    return band5Lower;
  }

  public void setBand5Lower(String band5Lower) {
    this.band5Lower = band5Lower;
  }

  @Column(name = "DomainBands_Band5Upper")
  public String getBand5Upper() {
    return band5Upper;
  }

  public void setBand5Upper(String band5Upper) {
    this.band5Upper = band5Upper;
  }

  @Column(name = "DomainBands_Band6Lower")
  public String getBand6Lower() {
    return band6Lower;
  }

  public void setBand6Lower(String band6Lower) {
    this.band6Lower = band6Lower;
  }

  @Column(name = "DomainBands_Band6Upper")
  public String getBand6Upper() {
    return band6Upper;
  }

  public void setBand6Upper(String band6Upper) {
    this.band6Upper = band6Upper;
  }

  @Column(name = "DomainBands_Band7Lower")
  public String getBand7Lower() {
    return band7Lower;
  }

  public void setBand7Lower(String band7Lower) {
    this.band7Lower = band7Lower;
  }

  @Column(name = "DomainBands_Band7Upper")
  public String getBand7Upper() {
    return band7Upper;
  }

  public void setBand7Upper(String band7Upper) {
    this.band7Upper = band7Upper;
  }

  @Column(name = "DomainBands_Band8Lower")
  public String getBand8Lower() {
    return band8Lower;
  }

  public void setBand8Lower(String band8Lower) {
    this.band8Lower = band8Lower;
  }

  @Column(name = "DomainBands_Band8Upper")
  public String getBand8Upper() {
    return band8Upper;
  }

  public void setBand8Upper(String band8Upper) {
    this.band8Upper = band8Upper;
  }

  @Column(name = "DomainBands_Band9Lower")
  public String getBand9Lower() {
    return band9Lower;
  }

  public void setBand9Lower(String band9Lower) {
    this.band9Lower = band9Lower;
  }

  @Column(name = "DomainBands_Band9Upper")
  public String getBand9Upper() {
    return band9Upper;
  }

  public void setBand9Upper(String band9Upper) {
    this.band9Upper = band9Upper;
  }

  @Column(name = "DomainBands_Band10Lower")
  public String getBand10Lower() {
    return band10Lower;
  }

  public void setBand10Lower(String band10Lower) {
    this.band10Lower = band10Lower;
  }

  @Column(name = "DomainBands_Band10Upper")
  public String getBand10Upper() {
    return band10Upper;
  }

  public void setBand10Upper(String band10Upper) {
    this.band10Upper = band10Upper;
  }
  
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "napTest")
  public Set<NAPTestlet> getNapTestlets() {
    return napTestlets;
  }
  
  public void setNapTestlets(Set<NAPTestlet> napTestlets) {
    this.napTestlets = napTestlets;
  }

}
