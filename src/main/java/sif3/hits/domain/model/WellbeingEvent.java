package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WellbeingEvent extends HitsEntity {
    private static final long serialVersionUID = 5693245628526263891L;

    private String refId;
    private String studentPersonalRefId;
    private String schoolInfoRefId;
    private String eventId;
    private String wellbeingEventNotes;
    private String wellbeingEventCategoryClass;
    private String reportingStaffRefId;
    private String wellbeingEventCreationTimeStamp;
    private String wellbeingEventDate;
    private String wellbeingEventTime;
    private String wellbeingEventDescription;
    private String wellbeingEventTimePeriod;
    private String wellbeingEventLocationDetailsEventLocation;
    private String wellbeingEventLocationDetailsClass;
    private String wellbeingEventLocationDetailsFurtherLocationNotes;
    private String confidentialFlag;
    private String status;

    private List<WellbeingEventDocument> documents;
    private List<WellbeingEventCategory> categories;
    private List<WellbeingEventPersonInvolvement> personInvolvements;
    private List<WellbeingEventFollowUpAction> followUpActions;
    
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getWellbeingEventNotes() {
        return wellbeingEventNotes;
    }

    public void setWellbeingEventNotes(String wellbeingEventNotes) {
        this.wellbeingEventNotes = wellbeingEventNotes;
    }

    public String getWellbeingEventCategoryClass() {
        return wellbeingEventCategoryClass;
    }

    public void setWellbeingEventCategoryClass(String wellbeingEventCategoryClass) {
        this.wellbeingEventCategoryClass = wellbeingEventCategoryClass;
    }

    public String getReportingStaffRefId() {
        return reportingStaffRefId;
    }

    public void setReportingStaffRefId(String reportingStaffRefId) {
        this.reportingStaffRefId = reportingStaffRefId;
    }

    public String getWellbeingEventCreationTimeStamp() {
        return wellbeingEventCreationTimeStamp;
    }

    public void setWellbeingEventCreationTimeStamp(String wellbeingEventCreationTimeStamp) {
        this.wellbeingEventCreationTimeStamp = wellbeingEventCreationTimeStamp;
    }

    public String getWellbeingEventDate() {
        return wellbeingEventDate;
    }

    public void setWellbeingEventDate(String wellbeingEventDate) {
        this.wellbeingEventDate = wellbeingEventDate;
    }

    public String getWellbeingEventTime() {
        return wellbeingEventTime;
    }

    public void setWellbeingEventTime(String wellbeingEventTime) {
        this.wellbeingEventTime = wellbeingEventTime;
    }

    public String getWellbeingEventDescription() {
        return wellbeingEventDescription;
    }

    public void setWellbeingEventDescription(String wellbeingEventDescription) {
        this.wellbeingEventDescription = wellbeingEventDescription;
    }

    public String getWellbeingEventTimePeriod() {
        return wellbeingEventTimePeriod;
    }

    public void setWellbeingEventTimePeriod(String wellbeingEventTimePeriod) {
        this.wellbeingEventTimePeriod = wellbeingEventTimePeriod;
    }

    @Column(name = "wellbeingEventLocationDetails_EventLocation")
    public String getWellbeingEventLocationDetailsEventLocation() {
        return wellbeingEventLocationDetailsEventLocation;
    }

    public void setWellbeingEventLocationDetailsEventLocation(String wellbeingEventLocationDetailsEventLocation) {
        this.wellbeingEventLocationDetailsEventLocation = wellbeingEventLocationDetailsEventLocation;
    }

    @Column(name = "wellbeingEventLocationDetails_Class")
    public String getWellbeingEventLocationDetailsClass() {
        return wellbeingEventLocationDetailsClass;
    }

    public void setWellbeingEventLocationDetailsClass(String wellbeingEventLocationDetailsClass) {
        this.wellbeingEventLocationDetailsClass = wellbeingEventLocationDetailsClass;
    }

    @Column(name = "wellbeingEventLocationDetails_FurtherLocationNotes")
    public String getWellbeingEventLocationDetailsFurtherLocationNotes() {
        return wellbeingEventLocationDetailsFurtherLocationNotes;
    }

    public void setWellbeingEventLocationDetailsFurtherLocationNotes(String wellbeingEventLocationDetailsFurtherLocationNotes) {
        this.wellbeingEventLocationDetailsFurtherLocationNotes = wellbeingEventLocationDetailsFurtherLocationNotes;
    }

    public String getConfidentialFlag() {
        return confidentialFlag;
    }

    public void setConfidentialFlag(String confidentialFlag) {
        this.confidentialFlag = confidentialFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingEvent")
    public List<WellbeingEventDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<WellbeingEventDocument> documents) {
        this.documents = documents;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingEvent")
    public List<WellbeingEventCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<WellbeingEventCategory> categories) {
        this.categories = categories;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingEvent")
    public List<WellbeingEventPersonInvolvement> getPersonInvolvements() {
        return personInvolvements;
    }

    public void setPersonInvolvements(List<WellbeingEventPersonInvolvement> personInvolvements) {
        this.personInvolvements = personInvolvements;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingEvent")
    public List<WellbeingEventFollowUpAction> getFollowUpActions() {
        return followUpActions;
    }

    public void setFollowUpActions(List<WellbeingEventFollowUpAction> followUpActions) {
        this.followUpActions = followUpActions;
    }
}
