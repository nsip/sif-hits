package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_ContextualQuestion")
public class AddressAGContextualQuestion extends BaseAGContextualQuestion {
	private AddressCollectionReporting addressCollectionReporting;

	@ManyToOne
	@JoinColumn(name = "AddressCollectionReporting_Id")
	public AddressCollectionReporting getAddressCollectionReporting() {
		return addressCollectionReporting;
	}

	public void setAddressCollectionReporting(AddressCollectionReporting addressCollectionReporting) {
		this.addressCollectionReporting = addressCollectionReporting;
	}

}
