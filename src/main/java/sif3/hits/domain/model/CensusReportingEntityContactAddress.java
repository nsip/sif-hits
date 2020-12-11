package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CensusReporting_EntityContact_Address")
public class CensusReportingEntityContactAddress extends BaseAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private CensusReportingEntityContact entityContact;
    private List<CensusReportingEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CensusReporting_EntityContact_Id", referencedColumnName = "Id")
    public CensusReportingEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(CensusReportingEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<CensusReportingEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<CensusReportingEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }
}
