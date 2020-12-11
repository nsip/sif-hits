package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_Parent_Address_StatisticalArea")
public class AddressCollectionReportingParentAddressStatisticalArea extends BaseAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private AddressCollectionReportingParentAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressCR_Parent_Address_Id", referencedColumnName = "Id")
    public AddressCollectionReportingParentAddress getAddress() {
        return address;
    }

    public void setAddress(AddressCollectionReportingParentAddress address) {
        this.address = address;
    }

}
