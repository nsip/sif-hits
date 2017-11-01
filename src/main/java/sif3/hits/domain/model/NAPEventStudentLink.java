package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class NAPEventStudentLink extends HitsEntity {
  private static final long serialVersionUID = -7786504144016316410L;

  private String refId;
  private String exemptionReason;
  private String participationCode;
  private String participationText;

  private String eventDate;
  private String device;
  private String dobRange;
  private String lapsedTimeTest;
  private String napJurisdiction;
  private String personalDetailsChanged;
  private String possibleDuplicate;
  private String psiOtherIdMatch;
  private String startTime;
  private String system;

  private NAPTest napTest;
  private SchoolInfo schoolInfo;
  private StudentPersonal studentPersonal;

  private List<Adjustment> adjustments;
  private List<TestDisruption> testDisruptions;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getExemptionReason() {
    return exemptionReason;
  }

  public void setExemptionReason(String exemptionReason) {
    this.exemptionReason = exemptionReason;
  }

  public String getParticipationCode() {
    return participationCode;
  }

  public void setParticipationCode(String participationCode) {
    this.participationCode = participationCode;
  }

  public String getParticipationText() {
    return participationText;
  }

  public void setParticipationText(String participationText) {
    this.participationText = participationText;
  }

  public String getEventDate() {
    return eventDate;
  }

  public void setEventDate(String eventDate) {
    this.eventDate = eventDate;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getDobRange() {
    return dobRange;
  }

  public void setDobRange(String dobRange) {
    this.dobRange = dobRange;
  }
  
  public String getLapsedTimeTest() {
    return lapsedTimeTest;
  }
  
  public void setLapsedTimeTest(String lapsedTimeTest) {
    this.lapsedTimeTest = lapsedTimeTest;
  }

  public String getNapJurisdiction() {
    return napJurisdiction;
  }

  public void setNapJurisdiction(String napJurisdiction) {
    this.napJurisdiction = napJurisdiction;
  }

  public String getPersonalDetailsChanged() {
    return personalDetailsChanged;
  }

  public void setPersonalDetailsChanged(String personalDetailsChanged) {
    this.personalDetailsChanged = personalDetailsChanged;
  }

  public String getPossibleDuplicate() {
    return possibleDuplicate;
  }

  public void setPossibleDuplicate(String possibleDuplicate) {
    this.possibleDuplicate = possibleDuplicate;
  }

  public String getPsiOtherIdMatch() {
    return psiOtherIdMatch;
  }

  public void setPsiOtherIdMatch(String psiOtherIdMatch) {
    this.psiOtherIdMatch = psiOtherIdMatch;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  @ManyToOne
  @JoinColumn(name = "SchoolInfo_RefId")
  public SchoolInfo getSchoolInfo() {
    return schoolInfo;
  }

  public void setSchoolInfo(SchoolInfo schoolInfo) {
    this.schoolInfo = schoolInfo;
  }

  @ManyToOne
  @JoinColumn(name = "StudentPersonal_RefId")
  public StudentPersonal getStudentPersonal() {
    return studentPersonal;
  }

  public void setStudentPersonal(StudentPersonal studentPersonal) {
    this.studentPersonal = studentPersonal;
  }

  @ManyToOne
  @JoinColumn(name = "NapTest_RefId")
  public NAPTest getNapTest() {
    return napTest;
  }

  public void setNapTest(NAPTest napTest) {
    this.napTest = napTest;
  }
  
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="napEventStudentLink")
  public List<Adjustment> getAdjustments() {
    return adjustments;
  }
  
  public void setAdjustments(List<Adjustment> adjustments) {
    this.adjustments = adjustments;
  }

  @Transient
  public Adjustment getAdjustment() {
    if (this.adjustments == null || this.adjustments.isEmpty()) return null;
    return this.adjustments.get(0);
  }

  @Transient
  public void setAdjustment(Adjustment adjustment) {
    if (this.adjustments == null) this.adjustments = new ArrayList<Adjustment>();
    this.adjustments.clear();
    this.adjustments.add(adjustment);
  }

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "napEventStudentLink")
  public List<TestDisruption> getTestDisruptions() {
    return testDisruptions;
  }

  public void setTestDisruptions(List<TestDisruption> testDisruptions) {
    this.testDisruptions = testDisruptions;
  }
}
