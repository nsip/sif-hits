package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentSchoolEnrollment_StudentSubjectChoice")
public class StudentSubjectChoice {
    private Long id;
    private StudentSchoolEnrollment studentSchoolEnrollment;
    private String preferenceNumber;
    private String subjectLocalId;
    private String studyDescription;
    private String otherSchoolLocalId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "StudentSchoolEnrollment_RefId", referencedColumnName = "RefId")
    public StudentSchoolEnrollment getStudentSchoolEnrollment() {
        return studentSchoolEnrollment;
    }

    public void setStudentSchoolEnrollment(StudentSchoolEnrollment studentSchoolEnrollment) {
        this.studentSchoolEnrollment = studentSchoolEnrollment;
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

    public String getStudyDescription() {
        return studyDescription;
    }

    public void setStudyDescription(String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public String getOtherSchoolLocalId() {
        return otherSchoolLocalId;
    }

    public void setOtherSchoolLocalId(String otherSchoolLocalId) {
        this.otherSchoolLocalId = otherSchoolLocalId;
    }
}
