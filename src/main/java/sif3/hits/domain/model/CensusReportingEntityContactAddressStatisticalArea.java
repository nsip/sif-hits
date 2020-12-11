package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CensusReporting_EntityContact_Address_StatisticalArea")
public class CensusReportingEntityContactAddressStatisticalArea extends BaseAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private CensusReportingEntityContactAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CensusReporting_EntityContact_Address_Id", referencedColumnName = "Id")
    public CensusReportingEntityContactAddress getAddress() {
        return address;
    }

    public void setAddress(CensusReportingEntityContactAddress address) {
        this.address = address;
    }

}
