package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQSubmission_EntityContact_Name")
public class FQSubmissionEntityContactName extends FQBaseEntityContactName {
    private FQSubmissionEntityContact entityContact;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FQSubmission_EntityContact_Id", referencedColumnName = "Id")
    public FQSubmissionEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(FQSubmissionEntityContact entityContact) {
        this.entityContact = entityContact;
    }

}
