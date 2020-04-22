package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Debtor extends HitsEntity {
	private static final long serialVersionUID = 2696182984778247619L;

	private String refId;
	private String localId;
	private String billedEntity;
	private String billedEntitySIFRefObject;
	private String billingName;
	private String billingNote;
	private String discount;
	private Set<Address> addresses;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getBilledEntity() {
		return billedEntity;
	}

	public void setBilledEntity(String billedEntity) {
		this.billedEntity = billedEntity;
	}

	@Column(name = "BilledEntity_SIFRefObject")
	public String getBilledEntitySIFRefObject() {
		return billedEntitySIFRefObject;
	}

	public void setBilledEntitySIFRefObject(String billedEntitySIFRefObject) {
		this.billedEntitySIFRefObject = billedEntitySIFRefObject;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getBillingNote() {
		return billingNote;
	}

	public void setBillingNote(String billingNote) {
		this.billingNote = billingNote;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "Person_RefId")
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
