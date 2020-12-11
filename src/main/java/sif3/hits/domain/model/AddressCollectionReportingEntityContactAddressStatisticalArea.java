package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_EntityContact_Address_StatisticalArea")
public class AddressCollectionReportingEntityContactAddressStatisticalArea extends BaseAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private AddressCollectionReportingEntityContactAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressCR_EntityContact_Address_Id", referencedColumnName = "Id")
    public AddressCollectionReportingEntityContactAddress getAddress() {
        return address;
    }

    public void setAddress(AddressCollectionReportingEntityContactAddress address) {
        this.address = address;
    }

}
