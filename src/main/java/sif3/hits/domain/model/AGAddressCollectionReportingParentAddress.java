package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCR_Parent_Address")
public class AGAddressCollectionReportingParentAddress extends FQBaseEntityContactAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private AGAddressCollectionReportingParent parent;
    private List<AGAddressCollectionReportingParentAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCR_Parent_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingParent getParent() {
        return parent;
    }

    public void setParent(AGAddressCollectionReportingParent parent) {
        this.parent = parent;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<AGAddressCollectionReportingParentAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<AGAddressCollectionReportingParentAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }

}
