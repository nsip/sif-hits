package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PersonalisedPlan_Document")
public class PersonalisedPlanDocument extends HitsEntity {
    private static final long serialVersionUID = 8586395795788280796L;

    private Long id;
    private PersonalisedPlan personalisedPlan;
    private String location;
    private String sensitivity;
    private String url;
    private String documentType;
    private String documentReviewDate;
    private String documentDescription;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "PersonalisedPlan_RefId")
    public PersonalisedPlan getPersonalisedPlan() {
        return personalisedPlan;
    }

    public void setPersonalisedPlan(PersonalisedPlan personalisedPlan) {
        this.personalisedPlan = personalisedPlan;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentReviewDate() {
        return documentReviewDate;
    }

    public void setDocumentReviewDate(String documentReviewDate) {
        this.documentReviewDate = documentReviewDate;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

}
