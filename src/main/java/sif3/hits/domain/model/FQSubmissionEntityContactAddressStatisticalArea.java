package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQSubmission_EntityContact_Address_StatisticalArea")
public class FQSubmissionEntityContactAddressStatisticalArea extends FQBaseEntityContactAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private FQSubmissionEntityContactAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FQSubmission_EntityContact_Address_Id", referencedColumnName = "Id")
    public FQSubmissionEntityContactAddress getAddress() {
        return address;
    }

    public void setAddress(FQSubmissionEntityContactAddress address) {
        this.address = address;
    }

}
