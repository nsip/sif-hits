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
public class FQReportingEntityContact extends BaseEntityContact {
	private static final long serialVersionUID = 569893542121731132L;

	private FQReporting fqReporting;
	private List<FQReportingEntityContactName> names;
	private List<FQReportingEntityContactAddress> addresses;

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
	public List<FQReportingEntityContactName> getNames() {
		return names;
	}

	public void setNames(List<FQReportingEntityContactName> names) {
		this.names = names;
	}

	@Transient
	public FQReportingEntityContactName getName() {
		FQReportingEntityContactName result = null;
		if (names != null && !names.isEmpty()) {
			result = names.get(0);
		}
		return result;
	}

	@Transient
	public void setName(FQReportingEntityContactName name) {
		if (names == null) {
			names = new ArrayList<FQReportingEntityContactName>();
		}
		names.clear();
		if (name != null) {
			names.add(name);
			name.setEntityContact(this);
		}
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<FQReportingEntityContactAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<FQReportingEntityContactAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public FQReportingEntityContactAddress getAddress() {
		FQReportingEntityContactAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(FQReportingEntityContactAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<FQReportingEntityContactAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
			address.setEntityContact(this);
		}
	}
}