package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_Parent_Address")
public class AddressCollectionReportingParentAddress extends BaseAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private AddressCollectionReportingParent parent;
    private List<AddressCollectionReportingParentAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressCR_Parent_Id", referencedColumnName = "Id")
    public AddressCollectionReportingParent getParent() {
        return parent;
    }

    public void setParent(AddressCollectionReportingParent parent) {
        this.parent = parent;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<AddressCollectionReportingParentAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<AddressCollectionReportingParentAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }

}
