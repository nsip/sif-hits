package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCollection_LocalCode")
public class AddressCollectionLocalCode extends BaseLocalCode {
	private static final long serialVersionUID = -8820189309679619943L;

	private AddressCollection addressCollection;

	@ManyToOne(optional = false)
	@JoinColumn(name = "AddressCollection_RefId", referencedColumnName = "RefId")
	public AddressCollection getAddressCollection() {
		return addressCollection;
	}

	public void setAddressCollection(AddressCollection addressCollection) {
		this.addressCollection = addressCollection;
	}
}
