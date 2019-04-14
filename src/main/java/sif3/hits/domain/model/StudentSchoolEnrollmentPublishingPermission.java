package sif3.hits.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "StudentSchoolEnrollment_PublishingPermission")
public class StudentSchoolEnrollmentPublishingPermission {
    private Long id;
    private StudentSchoolEnrollment studentSchoolEnrollment;
    private String permissionCategory;
    private String permissionValue;

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

    public String getPermissionCategory() {
        return permissionCategory;
    }

    public void setPermissionCategory(String permissionCategory) {
        this.permissionCategory = permissionCategory;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }
}
