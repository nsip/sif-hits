package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_EntityContact_Address_StatisticalArea")
public class FQEntityContactAddressStatisticalArea extends FQBaseEntityContactAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private FQEntityContactAddress address;

    @ManyToOne
    @JoinColumn(name = "FQReporting_EntityContact_Address_Id", referencedColumnName = "Id")
    public FQEntityContactAddress getAddress() {
        return address;
    }

    public void setAddress(FQEntityContactAddress address) {
        this.address = address;
    }

}
