package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "AGAddressCR_Student_Address" )
public class AGAddressCollectionReportingStudentAddress extends FQBaseEntityContactAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private AGAddressCollectionReportingStudent student;
    private List<AGAddressCollectionReportingStudentAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCR_Student_Id", referencedColumnName = "Id")
    public AGAddressCollectionReportingStudent getStudent() {
        return student;
    }

    public void setStudent(AGAddressCollectionReportingStudent student) {
        this.student = student;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<AGAddressCollectionReportingStudentAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<AGAddressCollectionReportingStudentAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }

}
