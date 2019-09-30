package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCS_EntityContact_Name")
public class AGAddressCollectionSubmissionEntityContactName extends FQBaseEntityContactName {
    private AGAddressCollectionSubmissionEntityContact entityContact;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCS_EntityContact_Id", referencedColumnName = "Id")
    public AGAddressCollectionSubmissionEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(AGAddressCollectionSubmissionEntityContact entityContact) {
        this.entityContact = entityContact;
    }

}
