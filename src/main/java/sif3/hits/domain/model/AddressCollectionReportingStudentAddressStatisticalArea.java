package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_Student_Address_StatisticalArea")
public class AddressCollectionReportingStudentAddressStatisticalArea extends BaseAddressStatisticalArea {
    private static final long serialVersionUID = 5495475119299160335L;

    private AddressCollectionReportingStudentAddress address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressCR_Student_Address_Id", referencedColumnName = "Id")
    public AddressCollectionReportingStudentAddress getAddress() {
        return address;
    }

    public void setAddress(AddressCollectionReportingStudentAddress address) {
        this.address = address;
    }

}
