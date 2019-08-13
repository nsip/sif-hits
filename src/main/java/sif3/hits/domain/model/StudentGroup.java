package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentSchoolEnrollment_StudentGroup")
public class StudentGroup {
    private Long id;
    private StudentSchoolEnrollment studentSchoolEnrollment;
    private String groupCategory;
    private String groupLocalId;
    private String groupDescription;

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

    public String getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getGroupLocalId() {
        return groupLocalId;
    }

    public void setGroupLocalId(String groupLocalId) {
        this.groupLocalId = groupLocalId;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

}
