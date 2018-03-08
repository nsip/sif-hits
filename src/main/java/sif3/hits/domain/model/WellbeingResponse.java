package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WellbeingResponse extends HitsEntity {
    private static final long serialVersionUID = 6356711970474556930L;

    private String refId;
    private String studentPersonalRefId;
    private String schoolInfoRefId;
    private String date;
    private String startDate;
    private String endDate;
    private String category;
    private String notes;
    private String suspensionCategory;
    private String suspensionDuration;
    private String suspensionAdvisementDate;
    private String suspensionResolutionMeetingTime;
    private String suspensionResolutionNotes;
    private String suspensionEarlyReturnDate;
    private String suspensionStatus;
    private String detentionCategory;
    private String detentionDate;
    private String detentionLocation;
    private String detentionNotes;
    private String detentionStatus;
    private String planRequiredStatus;
    private String awardDate;
    private String awardType;
    private String awardDescription;
    private String awardNotes;
    private String awardStatus;
    private String otherResponseDate;
    private String otherResponseType;
    private String otherResponseDescription;
    private String otherResponseNotes;
    private String otherStatus;

    private List<WellbeingResponseSuspensionWithdrawalTime> suspensionWithdawalTimes;
    private List<WellbeingResponsePlanRequired> plansRequired;
    private List<WellbeingResponsePersonInvolvement> personInvolvements;
    private List<WellbeingResponseDocument> documents;

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

    @Column(name = "SchoolInfo_RefId")
    public String getSchoolInfoRefId() {
        return schoolInfoRefId;
    }

    public void setSchoolInfoRefId(String schoolInfoRefId) {
        this.schoolInfoRefId = schoolInfoRefId;
    }

    @Column(name = "Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "WellbeingResponseStartDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Column(name = "WellbeingResponseEndDate")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Column(name = "WellbeingResponseCategory")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "WellbeingResponseNotes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "SuspensionContainer_SuspensionCategory")
    public String getSuspensionCategory() {
        return suspensionCategory;
    }

    public void setSuspensionCategory(String suspensionCategory) {
        this.suspensionCategory = suspensionCategory;
    }

    @Column(name = "SuspensionContainer_Duration")
    public String getSuspensionDuration() {
        return suspensionDuration;
    }

    public void setSuspensionDuration(String suspensionDuration) {
        this.suspensionDuration = suspensionDuration;
    }

    @Column(name = "SuspensionContainer_AdvisementDate")
    public String getSuspensionAdvisementDate() {
        return suspensionAdvisementDate;
    }

    public void setSuspensionAdvisementDate(String suspensionAdvisementDate) {
        this.suspensionAdvisementDate = suspensionAdvisementDate;
    }

    @Column(name = "SuspensionContainer_ResolutionMeetingTime")
    public String getSuspensionResolutionMeetingTime() {
        return suspensionResolutionMeetingTime;
    }

    public void setSuspensionResolutionMeetingTime(String suspensionResolutionMeetingTime) {
        this.suspensionResolutionMeetingTime = suspensionResolutionMeetingTime;
    }

    @Column(name = "SuspensionContainer_ResolutionNotes")
    public String getSuspensionResolutionNotes() {
        return suspensionResolutionNotes;
    }

    public void setSuspensionResolutionNotes(String suspensionResolutionNotes) {
        this.suspensionResolutionNotes = suspensionResolutionNotes;
    }

    @Column(name = "SuspensionContainer_EarlyReturnDate")
    public String getSuspensionEarlyReturnDate() {
        return suspensionEarlyReturnDate;
    }

    public void setSuspensionEarlyReturnDate(String suspensionEarlyReturnDate) {
        this.suspensionEarlyReturnDate = suspensionEarlyReturnDate;
    }

    @Column(name = "SuspensionContainer_Status")
    public String getSuspensionStatus() {
        return suspensionStatus;
    }

    public void setSuspensionStatus(String suspensionStatus) {
        this.suspensionStatus = suspensionStatus;
    }

    @Column(name = "DetentionContainer_DetentionCategory")
    public String getDetentionCategory() {
        return detentionCategory;
    }

    public void setDetentionCategory(String detentionCategory) {
        this.detentionCategory = detentionCategory;
    }

    @Column(name = "DetentionContainer_DetentionDate")
    public String getDetentionDate() {
        return detentionDate;
    }

    public void setDetentionDate(String detentionDate) {
        this.detentionDate = detentionDate;
    }

    @Column(name = "DetentionContainer_DetentionLocation")
    public String getDetentionLocation() {
        return detentionLocation;
    }

    public void setDetentionLocation(String detentionLocation) {
        this.detentionLocation = detentionLocation;
    }

    @Column(name = "DetentionContainer_DetentionNotes")
    public String getDetentionNotes() {
        return detentionNotes;
    }

    public void setDetentionNotes(String detentionNotes) {
        this.detentionNotes = detentionNotes;
    }

    @Column(name = "DetentionContainer_Status")
    public String getDetentionStatus() {
        return detentionStatus;
    }

    public void setDetentionStatus(String detentionStatus) {
        this.detentionStatus = detentionStatus;
    }

    @Column(name = "PlanRequiredContainer_Status")
    public String getPlanRequiredStatus() {
        return planRequiredStatus;
    }

    public void setPlanRequiredStatus(String planRequiredStatus) {
        this.planRequiredStatus = planRequiredStatus;
    }

    @Column(name = "AwardContainer_AwardDate")
    public String getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(String awardDate) {
        this.awardDate = awardDate;
    }

    @Column(name = "AwardContainer_AwardType")
    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    @Column(name = "AwardContainer_AwardDescription")
    public String getAwardDescription() {
        return awardDescription;
    }

    public void setAwardDescription(String awardDescription) {
        this.awardDescription = awardDescription;
    }

    @Column(name = "AwardContainer_AwardNotes")
    public String getAwardNotes() {
        return awardNotes;
    }

    public void setAwardNotes(String awardNotes) {
        this.awardNotes = awardNotes;
    }

    @Column(name = "AwardContainer_Status")
    public String getAwardStatus() {
        return awardStatus;
    }

    public void setAwardStatus(String awardStatus) {
        this.awardStatus = awardStatus;
    }

    @Column(name = "OtherWellbeingResponseContainer_OtherResponseDate")
    public String getOtherResponseDate() {
        return otherResponseDate;
    }

    public void setOtherResponseDate(String otherResponseDate) {
        this.otherResponseDate = otherResponseDate;
    }

    @Column(name = "OtherWellbeingResponseContainer_OtherResponseType")
    public String getOtherResponseType() {
        return otherResponseType;
    }

    public void setOtherResponseType(String otherResponseType) {
        this.otherResponseType = otherResponseType;
    }

    @Column(name = "OtherWellbeingResponseContainer_OtherResponseDescription")
    public String getOtherResponseDescription() {
        return otherResponseDescription;
    }

    public void setOtherResponseDescription(String otherResponseDescription) {
        this.otherResponseDescription = otherResponseDescription;
    }

    @Column(name = "OtherWellbeingResponseContainer_OtherResponseNotes")
    public String getOtherResponseNotes() {
        return otherResponseNotes;
    }

    public void setOtherResponseNotes(String otherResponseNotes) {
        this.otherResponseNotes = otherResponseNotes;
    }

    @Column(name = "OtherWellbeingResponseContainer_Status")
    public String getOtherStatus() {
        return otherStatus;
    }

    public void setOtherStatus(String otherStatus) {
        this.otherStatus = otherStatus;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingResponse")
    public List<WellbeingResponseSuspensionWithdrawalTime> getSuspensionWithdawalTimes() {
        return suspensionWithdawalTimes;
    }

    public void setSuspensionWithdawalTimes(List<WellbeingResponseSuspensionWithdrawalTime> suspensionWithdawalTimes) {
        this.suspensionWithdawalTimes = suspensionWithdawalTimes;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingResponse")
    public List<WellbeingResponsePlanRequired> getPlansRequired() {
        return plansRequired;
    }

    public void setPlansRequired(List<WellbeingResponsePlanRequired> plansRequired) {
        this.plansRequired = plansRequired;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingResponse")
    public List<WellbeingResponsePersonInvolvement> getPersonInvolvements() {
        return personInvolvements;
    }

    public void setPersonInvolvements(List<WellbeingResponsePersonInvolvement> personInvolvements) {
        this.personInvolvements = personInvolvements;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingResponse")
    public List<WellbeingResponseDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<WellbeingResponseDocument> documents) {
        this.documents = documents;
    }
}
