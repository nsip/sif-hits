package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PersonalisedPlan extends HitsEntity {
    private static final long serialVersionUID = 3263887960265363721L;

    private String refId;
    private String studentPersonalRefId;
    private String schoolInfoRefId;
    private String personalisedPlanCategory;
    private String personalisedPlanStartDate;
    private String personalisedPlanEndDate;
    private String personalisedPlanReviewDate;
    private String personalisedPlanNotes;
    private String associatedAttachment;
    private List<PersonalisedPlanDocument> documents;

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

    public String getPersonalisedPlanCategory() {
        return personalisedPlanCategory;
    }

    public void setPersonalisedPlanCategory(String personalisedPlanCategory) {
        this.personalisedPlanCategory = personalisedPlanCategory;
    }

    public String getPersonalisedPlanStartDate() {
        return personalisedPlanStartDate;
    }

    public void setPersonalisedPlanStartDate(String personalisedPlanStartDate) {
        this.personalisedPlanStartDate = personalisedPlanStartDate;
    }

    public String getPersonalisedPlanEndDate() {
        return personalisedPlanEndDate;
    }

    public void setPersonalisedPlanEndDate(String personalisedPlanEndDate) {
        this.personalisedPlanEndDate = personalisedPlanEndDate;
    }

    public String getPersonalisedPlanReviewDate() {
        return personalisedPlanReviewDate;
    }

    public void setPersonalisedPlanReviewDate(String personalisedPlanReviewDate) {
        this.personalisedPlanReviewDate = personalisedPlanReviewDate;
    }

    public String getPersonalisedPlanNotes() {
        return personalisedPlanNotes;
    }

    public void setPersonalisedPlanNotes(String personalisedPlanNotes) {
        this.personalisedPlanNotes = personalisedPlanNotes;
    }

    public String getAssociatedAttachment() {
        return associatedAttachment;
    }

    public void setAssociatedAttachment(String associatedAttachment) {
        this.associatedAttachment = associatedAttachment;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "personalisedPlan")
    public List<PersonalisedPlanDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<PersonalisedPlanDocument> documents) {
        this.documents = documents;
    }
}
