package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AGAddressCS_EntityContact_Address")
public class AGAddressCollectionSubmissionEntityContactAddress extends FQBaseEntityContactAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private AGAddressCollectionSubmissionEntityContact entityContact;
    private List<AGAddressCollectionSubmissionEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCS_EntityContact_Id", referencedColumnName = "Id")
    public AGAddressCollectionSubmissionEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(AGAddressCollectionSubmissionEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<AGAddressCollectionSubmissionEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<AGAddressCollectionSubmissionEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }
}
