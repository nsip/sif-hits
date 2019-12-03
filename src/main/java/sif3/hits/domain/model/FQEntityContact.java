package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FQReporting_EntityContact")
public class FQEntityContact extends FQBaseEntityContact {
    private static final long serialVersionUID = -3136757794908905396L;

    private FQReporting fqReporting;
    private List<FQEntityContactName> names;
    private List<FQEntityContactAddress> addresses;

    @ManyToOne
    @JoinColumn(name = "FQReporting_Id")
    public FQReporting getFqReporting() {
        return fqReporting;
    }

    public void setFqReporting(FQReporting fqReporting) {
        this.fqReporting = fqReporting;
    }

    // Actually One to One but easier to manage with hibernate this way
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
    public List<FQEntityContactName> getNames() {
        return names;
    }

    public void setNames(List<FQEntityContactName> names) {
        this.names = names;
    }
    
    @Transient
    public FQEntityContactName getName() {
        FQEntityContactName result = null;
        if (names != null && !names.isEmpty()) {
            result = names.get(0);
        }
        return result;
    }
    
    @Transient
    public void setName(FQEntityContactName name) {
        if (names == null) {
            names = new ArrayList<FQEntityContactName>();
        }
        names.clear();
        if (name != null) {
            names.add(name);
        }
    }

    // Actually One to One but easier to manage with hibernate this way
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
    public List<FQEntityContactAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<FQEntityContactAddress> addresses) {
        this.addresses = addresses;
    }
    
    @Transient
    public FQEntityContactAddress getAddress() {
        FQEntityContactAddress result = null;
        if (addresses != null && !addresses.isEmpty()) {
            result = addresses.get(0);
        }
        return result;
    }
    
    @Transient
    public void setAddress(FQEntityContactAddress address) {
        if (addresses == null) {
            addresses = new ArrayList<FQEntityContactAddress>();
        }
        addresses.clear();
        if (address != null) {
            addresses.add(address);
        }
    }
}
