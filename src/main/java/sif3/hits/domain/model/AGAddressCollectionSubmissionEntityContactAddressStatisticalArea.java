package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCS_EntityContact_Address_StatisticalArea")
public class AGAddressCollectionSubmissionEntityContactAddressStatisticalArea extends FQBaseEntityContactAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private AGAddressCollectionSubmissionEntityContactAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCS_EntityContact_Address_Id", referencedColumnName = "Id")
    public AGAddressCollectionSubmissionEntityContactAddress getAddress() {
        return address;
    }

    public void setAddress(AGAddressCollectionSubmissionEntityContactAddress address) {
        this.address = address;
    }

}
