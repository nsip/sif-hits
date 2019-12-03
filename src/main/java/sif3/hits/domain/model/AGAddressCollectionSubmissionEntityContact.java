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
@Table(name = "AGAddressCS_EntityContact" )
public class AGAddressCollectionSubmissionEntityContact extends FQBaseEntityContact {
	private static final long serialVersionUID = 569893542121731132L;

	private AGAddressCollectionSubmission agAddressCollectionSubmission;
	private List<AGAddressCollectionSubmissionEntityContactName> names;
	private List<AGAddressCollectionSubmissionEntityContactAddress> addresses;

	@ManyToOne
	@JoinColumn(name = "AGAddressCS_RefId")
	public AGAddressCollectionSubmission getAgAddressCollectionSubmission() {
		return agAddressCollectionSubmission;
	}

	public void setAgAddressCollectionSubmission(AGAddressCollectionSubmission agAddressCollectionSubmission) {
		this.agAddressCollectionSubmission = agAddressCollectionSubmission;
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<AGAddressCollectionSubmissionEntityContactName> getNames() {
		return names;
	}

	public void setNames(List<AGAddressCollectionSubmissionEntityContactName> names) {
		this.names = names;
	}

	@Transient
	public AGAddressCollectionSubmissionEntityContactName getName() {
		AGAddressCollectionSubmissionEntityContactName result = null;
		if (names != null && !names.isEmpty()) {
			result = names.get(0);
		}
		return result;
	}

	@Transient
	public void setName(AGAddressCollectionSubmissionEntityContactName name) {
		if (names == null) {
			names = new ArrayList<AGAddressCollectionSubmissionEntityContactName>();
		}
		names.clear();
		if (name != null) {
			names.add(name);
		}
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
	public List<AGAddressCollectionSubmissionEntityContactAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AGAddressCollectionSubmissionEntityContactAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public AGAddressCollectionSubmissionEntityContactAddress getAddress() {
		AGAddressCollectionSubmissionEntityContactAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(AGAddressCollectionSubmissionEntityContactAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<AGAddressCollectionSubmissionEntityContactAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
		}
	}
}
