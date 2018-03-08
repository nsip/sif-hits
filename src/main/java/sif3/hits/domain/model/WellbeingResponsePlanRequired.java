package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingResponse_PlanRequiredContainer_PlanRequired")
public class WellbeingResponsePlanRequired extends HitsEntity {
    private static final long serialVersionUID = -3803542778368590981L;

    private Long id;
    private WellbeingResponse wellbeingResponse;
    private String planNotes;
    private String personalisedPlanRefId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "WellbeingResponse_RefId")
    public WellbeingResponse getWellbeingResponse() {
        return wellbeingResponse;
    }

    public void setWellbeingResponse(WellbeingResponse wellbeingResponse) {
        this.wellbeingResponse = wellbeingResponse;
    }

    public String getPlanNotes() {
        return planNotes;
    }
    
    public void setPlanNotes(String planNotes) {
        this.planNotes = planNotes;
    }

    @Column(name = "PersonalisedPlan_RefId")
    public String getPersonalisedPlanRefId() {
        return personalisedPlanRefId;
    }

    public void setPersonalisedPlanRefId(String personalisedPlanRefId) {
        this.personalisedPlanRefId = personalisedPlanRefId;
    }

}
