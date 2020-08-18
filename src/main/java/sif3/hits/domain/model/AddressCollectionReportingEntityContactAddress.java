package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_EntityContact_Address")
public class AddressCollectionReportingEntityContactAddress extends BaseAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private AddressCollectionReportingEntityContact entityContact;
    private List<AddressCollectionReportingEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressCR_EntityContact_Id", referencedColumnName = "Id")
    public AddressCollectionReportingEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(AddressCollectionReportingEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<AddressCollectionReportingEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<AddressCollectionReportingEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }
}
