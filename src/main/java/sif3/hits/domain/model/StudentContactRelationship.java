package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

@Entity
public class StudentContactRelationship extends HitsEntity {
  private static final long serialVersionUID = -7247189296680028045L;

  private String refId;
  private String studentPersonalRefId;
  private String studentContactPersonalRefId;
  private String relationship;
  private String parentLegalGuardian;
  private String pickupRights;
  private String livesWith;
  private String accessToRecords;
  private String emergencyContact;
  private String hasCustody;
  private String disciplinaryContact;
  private String primaryCareProvider;
  private String feesBilling;
  private String familyMail;
  private String interventionOrder;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "StudentPersonal_RefId")
  public String getStudentPersonalRefId() {
    return studentPersonalRefId;
  }

  public void setStudentPersonalRefId(String studentPersonalRefId) {
    this.studentPersonalRefId = studentPersonalRefId;
  }

  @Column(name = "StudentContactPersonal_RefId")
  public String getStudentContactPersonalRefId() {
    return studentContactPersonalRefId;
  }

  public void setStudentContactPersonalRefId(String studentContactPersonalRefId) {
    this.studentContactPersonalRefId = studentContactPersonalRefId;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

  public String getParentLegalGuardian() {
    return parentLegalGuardian;
  }

  public void setParentLegalGuardian(String parentLegalGuardian) {
    this.parentLegalGuardian = parentLegalGuardian;
  }

  public String getPickupRights() {
    return pickupRights;
  }

  public void setPickupRights(String pickupRights) {
    this.pickupRights = pickupRights;
  }

  public String getLivesWith() {
    return livesWith;
  }

  public void setLivesWith(String livesWith) {
    this.livesWith = livesWith;
  }

  public String getAccessToRecords() {
    return accessToRecords;
  }

  public void setAccessToRecords(String accessToRecords) {
    this.accessToRecords = accessToRecords;
  }

  public String getEmergencyContact() {
    return emergencyContact;
  }

  public void setEmergencyContact(String emergencyContact) {
    this.emergencyContact = emergencyContact;
  }

  public String getHasCustody() {
    return hasCustody;
  }

  public void setHasCustody(String hasCustody) {
    this.hasCustody = hasCustody;
  }

  public String getDisciplinaryContact() {
    return disciplinaryContact;
  }

  public void setDisciplinaryContact(String disciplinaryContact) {
    this.disciplinaryContact = disciplinaryContact;
  }

  public String getPrimaryCareProvider() {
    return primaryCareProvider;
  }

  public void setPrimaryCareProvider(String primaryCareProvider) {
    this.primaryCareProvider = primaryCareProvider;
  }

  public String getFeesBilling() {
    return feesBilling;
  }

  public void setFeesBilling(String feesBilling) {
    this.feesBilling = feesBilling;
  }

  public String getFamilyMail() {
    return familyMail;
  }

  public void setFamilyMail(String familyMail) {
    this.familyMail = familyMail;
  }

  public String getInterventionOrder() {
    return interventionOrder;
  }

  public void setInterventionOrder(String interventionOrder) {
    this.interventionOrder = interventionOrder;
  }

  @Transient
  public boolean hasRelationship() {
    return relationship != null;
  }

  @Transient
  public boolean hasContactFlags() {
    return StringUtils.isNotBlank(parentLegalGuardian) || StringUtils.isNotBlank(pickupRights) || StringUtils.isNotBlank(livesWith) || StringUtils.isNotBlank(accessToRecords) || StringUtils.isNotBlank(emergencyContact)
        || StringUtils.isNotBlank(hasCustody) || StringUtils.isNotBlank(disciplinaryContact) || StringUtils.isNotBlank(primaryCareProvider) || StringUtils.isNotBlank(feesBilling) || StringUtils.isNotBlank(familyMail)
        || StringUtils.isNotBlank(interventionOrder);
  }

}
