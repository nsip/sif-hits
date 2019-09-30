package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCR_EntityContact_Name")
public class AGAddressCollectionReportingEntityContactName extends FQBaseEntityContactName {
    private AGAddressCollectionReportingEntityContact entityContact;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCR_EntityContact_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(AGAddressCollectionReportingEntityContact entityContact) {
        this.entityContact = entityContact;
    }

}
