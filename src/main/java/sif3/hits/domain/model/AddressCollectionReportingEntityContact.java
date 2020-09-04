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
@Table(name = "AddressCR_EntityContact" )
public class AddressCollectionReportingEntityContact extends BaseEntityContact {
	private static final long serialVersionUID = 569893542121731132L;

	private AddressCollectionReporting addressCollectionReporting;
	private List<AddressCollectionReportingEntityContactName> names;
	private List<AddressCollectionReportingEntityContactAddress> addresses;

	@ManyToOne
	@JoinColumn(name = "AddressCollectionReporting_Id")
	public AddressCollectionReporting getAddressCollectionReporting() {
		return addressCollectionReporting;
	}

	public void setAddressCollectionReporting(AddressCollectionReporting addressCollectionReporting) {
		this.addressCollectionReporting = addressCollectionReporting;
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<AddressCollectionReportingEntityContactName> getNames() {
		return names;
	}

	public void setNames(List<AddressCollectionReportingEntityContactName> names) {
		this.names = names;
	}

	@Transient
	public AddressCollectionReportingEntityContactName getName() {
		AddressCollectionReportingEntityContactName result = null;
		if (names != null && !names.isEmpty()) {
			result = names.get(0);
		}
		return result;
	}

	@Transient
	public void setName(AddressCollectionReportingEntityContactName name) {
		if (names == null) {
			names = new ArrayList<AddressCollectionReportingEntityContactName>();
		}
		names.clear();
		if (name != null) {
			names.add(name);
			name.setEntityContact(this);
		}
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<AddressCollectionReportingEntityContactAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressCollectionReportingEntityContactAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public AddressCollectionReportingEntityContactAddress getAddress() {
		AddressCollectionReportingEntityContactAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(AddressCollectionReportingEntityContactAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<AddressCollectionReportingEntityContactAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
			address.setEntityContact(this);
		}
	}
}