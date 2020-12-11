package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_Parent_Name")
public class AddressCollectionReportingParentName extends BaseNameOfRecord {
	private static final long serialVersionUID = 1456782001605185121L;

	private AddressCollectionReportingParent parent;

	@ManyToOne(optional = false)
	@JoinColumn(name = "AddressCR_Parent_Id", referencedColumnName = "Id")
	public AddressCollectionReportingParent getParent() {
		return parent;
	}

	public void setParent(AddressCollectionReportingParent parent) {
		this.parent = parent;
	}

}
