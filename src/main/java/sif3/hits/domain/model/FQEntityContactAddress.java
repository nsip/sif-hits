package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FQReporting_EntityContact_Address")
public class FQEntityContactAddress extends FQBaseEntityContactAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private FQEntityContact entityContact;
    private List<FQEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne
    @JoinColumn(name = "FQReporting_EntityContact_Id", referencedColumnName = "Id")
    public FQEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(FQEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<FQEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<FQEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }

}
