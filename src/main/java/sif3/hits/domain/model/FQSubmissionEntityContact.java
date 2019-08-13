package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FQSubmission_EntityContact")
public class FQSubmissionEntityContact extends FQBaseEntityContact {
    private static final long serialVersionUID = -3136757794908905396L;

    private FinancialQuestionnaireSubmission fqSubmission;
    private List<FQSubmissionEntityContactName> names;
    private List<FQSubmissionEntityContactAddress> addresses;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FQSubmission_RefId", referencedColumnName = "RefId")
    public FinancialQuestionnaireSubmission getFqSubmission() {
        return fqSubmission;
    }

    public void setFqSubmission(FinancialQuestionnaireSubmission fqSubmission) {
        this.fqSubmission = fqSubmission;
    }

    // Actually One to One but easier to manage with hibernate this way
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
    public List<FQSubmissionEntityContactName> getNames() {
        return names;
    }

    public void setNames(List<FQSubmissionEntityContactName> names) {
        this.names = names;
    }

    @Transient
    public FQSubmissionEntityContactName getName() {
        FQSubmissionEntityContactName result = null;
        if (names != null && !names.isEmpty()) {
            result = names.get(0);
        }
        return result;
    }

    @Transient
    public void setName(FQSubmissionEntityContactName name) {
        if (names == null) {
            names = new ArrayList<FQSubmissionEntityContactName>();
        }
        names.clear();
        if (name != null) {
            names.add(name);
        }
    }

    // Actually One to One but easier to manage with hibernate this way
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
    public List<FQSubmissionEntityContactAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<FQSubmissionEntityContactAddress> addresses) {
        this.addresses = addresses;
    }

    @Transient
    public FQSubmissionEntityContactAddress getAddress() {
        FQSubmissionEntityContactAddress result = null;
        if (addresses != null && !addresses.isEmpty()) {
            result = addresses.get(0);
        }
        return result;
    }

    @Transient
    public void setAddress(FQSubmissionEntityContactAddress address) {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }
        addresses.clear();
        if (address != null) {
            addresses.add(address);
        }
    }
}
