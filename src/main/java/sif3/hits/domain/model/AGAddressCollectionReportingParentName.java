package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCR_Parent_Name")
public class AGAddressCollectionReportingParentName extends FQBaseEntityContactName {
    private AGAddressCollectionReportingParent entityContact;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCR_Parent_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingParent getParent() {
        return entityContact;
    }

    public void setParent(AGAddressCollectionReportingParent entityContact) {
        this.entityContact = entityContact;
    }

}
