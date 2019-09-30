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
@Table(name = "AGAddressCR_EntityContact" )
public class AGAddressCollectionReportingEntityContact extends FQBaseEntityContact {
	private static final long serialVersionUID = 569893542121731132L;

	private AGAddressCollectionReporting agAddressCollectionReporting;
	private List<AGAddressCollectionReportingEntityContactName> names;
	private List<AGAddressCollectionReportingEntityContactAddress> addresses;

	@ManyToOne
	@JoinColumn(name = "AGAddressCR_Id")
	public AGAddressCollectionReporting getAgAddressCollectionReporting() {
		return agAddressCollectionReporting;
	}

	public void setAgAddressCollectionReporting(AGAddressCollectionReporting agAddressCollectionReporting) {
		this.agAddressCollectionReporting = agAddressCollectionReporting;
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<AGAddressCollectionReportingEntityContactName> getNames() {
		return names;
	}

	public void setNames(List<AGAddressCollectionReportingEntityContactName> names) {
		this.names = names;
	}

	@Transient
	public AGAddressCollectionReportingEntityContactName getName() {
		AGAddressCollectionReportingEntityContactName result = null;
		if (names != null && !names.isEmpty()) {
			result = names.get(0);
		}
		return result;
	}

	@Transient
	public void setName(AGAddressCollectionReportingEntityContactName name) {
		if (names == null) {
			names = new ArrayList<AGAddressCollectionReportingEntityContactName>();
		}
		names.clear();
		if (name != null) {
			names.add(name);
		}
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<AGAddressCollectionReportingEntityContactAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AGAddressCollectionReportingEntityContactAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public AGAddressCollectionReportingEntityContactAddress getAddress() {
		AGAddressCollectionReportingEntityContactAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(AGAddressCollectionReportingEntityContactAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<AGAddressCollectionReportingEntityContactAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
		}
	}
}