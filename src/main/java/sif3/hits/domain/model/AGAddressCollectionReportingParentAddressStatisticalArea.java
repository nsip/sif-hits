package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCR_Parent_Address_StatisticalArea")
public class AGAddressCollectionReportingParentAddressStatisticalArea extends FQBaseEntityContactAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private AGAddressCollectionReportingParentAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCS_Parent_Address_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingParentAddress getAddress() {
        return address;
    }

    public void setAddress(AGAddressCollectionReportingParentAddress address) {
        this.address = address;
    }

}
