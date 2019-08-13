package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FQSubmission_EntityContact_Address")
public class FQSubmissionEntityContactAddress extends FQBaseEntityContactAddress {
    private static final long serialVersionUID = -2625854444459437022L;

    private FQSubmissionEntityContact entityContact;
    private List<FQSubmissionEntityContactAddressStatisticalArea> statisticalAreas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FQSubmission_EntityContact_Id", referencedColumnName = "Id")
    public FQSubmissionEntityContact getEntityContact() {
        return entityContact;
    }

    public void setEntityContact(FQSubmissionEntityContact entityContact) {
        this.entityContact = entityContact;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address")
    public List<FQSubmissionEntityContactAddressStatisticalArea> getStatisticalAreas() {
        return statisticalAreas;
    }

    public void setStatisticalAreas(List<FQSubmissionEntityContactAddressStatisticalArea> statisticalAreas) {
        this.statisticalAreas = statisticalAreas;
    }
}
