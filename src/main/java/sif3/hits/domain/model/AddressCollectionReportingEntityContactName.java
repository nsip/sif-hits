package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_EntityContact_Name")
public class AddressCollectionReportingEntityContactName extends BaseNameType {
	private static final long serialVersionUID = 954576208095522486L;

	private AddressCollectionReportingEntityContact entityContact;

	@ManyToOne(optional = false)
	@JoinColumn(name = "AddressCR_EntityContact_Id", referencedColumnName = "Id")
	public AddressCollectionReportingEntityContact getEntityContact() {
		return entityContact;
	}

	public void setEntityContact(AddressCollectionReportingEntityContact entityContact) {
		this.entityContact = entityContact;
	}

}
