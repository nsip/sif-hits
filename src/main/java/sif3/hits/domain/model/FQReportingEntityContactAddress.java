package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_EntityContact_Address")
public class FQReportingEntityContactAddress extends BaseAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private FQReportingEntityContact entityContact;
    private List<FQReportingEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FQReporting_EntityContact_Id", referencedColumnName = "Id")
    public FQReportingEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(FQReportingEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<FQReportingEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<FQReportingEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }
}
