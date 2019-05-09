package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_EntityContact_Name")
public class FQEntityContactName extends FQBaseEntityContactName {
    private FQEntityContact entityContact;

    @OneToOne
    @JoinColumn(name = "FQReporting_EntityContact_Id", referencedColumnName = "Id")
    public FQEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(FQEntityContact entityContact) {
        this.entityContact = entityContact;
    }

}
