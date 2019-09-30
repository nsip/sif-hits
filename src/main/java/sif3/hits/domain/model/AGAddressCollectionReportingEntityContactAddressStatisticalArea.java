package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCR_EntityContact_Address_StatisticalArea")
public class AGAddressCollectionReportingEntityContactAddressStatisticalArea extends FQBaseEntityContactAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private AGAddressCollectionReportingEntityContactAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCS_EntityContact_Address_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingEntityContactAddress getAddress() {
        return address;
    }

    public void setAddress(AGAddressCollectionReportingEntityContactAddress address) {
        this.address = address;
    }

}
