package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WellbeingAlert extends HitsEntity {
    private static final long serialVersionUID = -7835880528959856058L;

    private String refId;
    private String studentPersonalRefId;
    private String schoolInfoRefId;
    private String alertDate;
    private String startDate;
    private String endDate;
    private String category;
    private String description;
    private String enrolmentRestricted;
    private String alertAudience;
    private String alertSeverity;
    private String alertKeyContact;

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

    @Column(name = "date")
    public String getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(String alertDate) {
        this.alertDate = alertDate;
    }

    @Column(name = "wellbeingAlertStartDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Column(name = "wellbeingAlertEndDate")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Column(name = "wellbeingAlertCategory")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "wellbeingAlertDescription")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnrolmentRestricted() {
        return enrolmentRestricted;
    }

    public void setEnrolmentRestricted(String enrolmentRestricted) {
        this.enrolmentRestricted = enrolmentRestricted;
    }

    public String getAlertAudience() {
        return alertAudience;
    }

    public void setAlertAudience(String alertAudience) {
        this.alertAudience = alertAudience;
    }

    public String getAlertSeverity() {
        return alertSeverity;
    }

    public void setAlertSeverity(String alertSeverity) {
        this.alertSeverity = alertSeverity;
    }

    public String getAlertKeyContact() {
        return alertKeyContact;
    }

    public void setAlertKeyContact(String alertKeyContact) {
        this.alertKeyContact = alertKeyContact;
    }

}