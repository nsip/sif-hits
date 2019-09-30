package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AGAddressCR_EntityContact_Address")
public class AGAddressCollectionReportingEntityContactAddress extends FQBaseEntityContactAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private AGAddressCollectionReportingEntityContact entityContact;
    private List<AGAddressCollectionReportingEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCR_EntityContact_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(AGAddressCollectionReportingEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<AGAddressCollectionReportingEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<AGAddressCollectionReportingEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }
}
