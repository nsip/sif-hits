package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "AddressCR_Student_Address" )
public class AddressCollectionReportingStudentAddress extends BaseAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private AddressCollectionReportingStudent student;
    private List<AddressCollectionReportingStudentAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressCR_Student_Id", referencedColumnName = "Id")
    public AddressCollectionReportingStudent getStudent() {
        return student;
    }

    public void setStudent(AddressCollectionReportingStudent student) {
        this.student = student;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<AddressCollectionReportingStudentAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<AddressCollectionReportingStudentAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }

}
