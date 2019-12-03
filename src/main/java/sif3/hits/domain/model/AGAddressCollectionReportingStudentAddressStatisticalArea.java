package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AGAddressCR_Student_Address_StatisticalArea")
public class AGAddressCollectionReportingStudentAddressStatisticalArea extends FQBaseEntityContactAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private AGAddressCollectionReportingStudentAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCR_Student_Address_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingStudentAddress getAddress() {
        return address;
    }

    public void setAddress(AGAddressCollectionReportingStudentAddress address) {
        this.address = address;
    }

}
