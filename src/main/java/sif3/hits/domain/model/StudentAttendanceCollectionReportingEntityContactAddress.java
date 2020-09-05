package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceCR_EntityContact_Address")
public class StudentAttendanceCollectionReportingEntityContactAddress extends BaseAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private StudentAttendanceCollectionReportingEntityContact entityContact;
    private List<StudentAttendanceCollectionReportingEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "StudentAttendanceCR_EntityContact_Id", referencedColumnName = "Id")
    public StudentAttendanceCollectionReportingEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(StudentAttendanceCollectionReportingEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<StudentAttendanceCollectionReportingEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<StudentAttendanceCollectionReportingEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }
}
