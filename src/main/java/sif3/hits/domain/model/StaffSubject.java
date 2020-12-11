package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StaffAssignment_StaffSubject")
public class StaffSubject {
    private Long id;
    private StaffAssignment staffAssignment;
    private String preferenceNumber;
    private String subjectLocalId;
    private String timeTableSubjectRefId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "StaffAssignment_RefId", referencedColumnName = "RefId")
    public StaffAssignment getStaffAssignment() {
        return staffAssignment;
    }

    public void setStaffAssignment(StaffAssignment staffAssignment) {
        this.staffAssignment = staffAssignment;
    }

    public String getPreferenceNumber() {
        return preferenceNumber;
    }

    public void setPreferenceNumber(String preferenceNumber) {
        this.preferenceNumber = preferenceNumber;
    }

    public String getSubjectLocalId() {
        return subjectLocalId;
    }

    public void setSubjectLocalId(String subjectLocalId) {
        this.subjectLocalId = subjectLocalId;
    }

    @Column(name = "TimeTableSubject_RefId")
    public String getTimeTableSubjectRefId() {
        return timeTableSubjectRefId;
    }

    public void setTimeTableSubjectRefId(String timeTableSubjectRefId) {
        this.timeTableSubjectRefId = timeTableSubjectRefId;
    }
}
