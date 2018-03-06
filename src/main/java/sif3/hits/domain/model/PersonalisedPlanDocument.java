package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PersonalisedPlan_Document")
public class PersonalisedPlanDocument extends WellbeingDocument {
    private static final long serialVersionUID = 8586395795788280796L;

    private PersonalisedPlan personalisedPlan;

    @ManyToOne
    @JoinColumn(name = "PersonalisedPlan_RefId")
    public PersonalisedPlan getPersonalisedPlan() {
        return personalisedPlan;
    }

    public void setPersonalisedPlan(PersonalisedPlan personalisedPlan) {
        this.personalisedPlan = personalisedPlan;
    }
}
