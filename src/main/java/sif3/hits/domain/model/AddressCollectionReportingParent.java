package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AddressCR_Parent")
public class AddressCollectionReportingParent extends HitsEntity {
	private static final long serialVersionUID = -5885672220749833387L;

	private Long id;
	private AddressCollectionReportingStudent student;
	private Integer parentNumber;
	private String addressSameAsStudent;

	private List<AddressCollectionReportingParentName> names;
	private List<AddressCollectionReportingParentAddress> addresses;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    @ManyToOne(optional = false)
    @JoinColumn(name = "AddressCR_Student_Id", referencedColumnName = "Id")
	public AddressCollectionReportingStudent getStudent() {
		return student;
	}
	
	public void setStudent(AddressCollectionReportingStudent student) {
		this.student = student;
	}

	public Integer getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(Integer parentNumber) {
		this.parentNumber = parentNumber;
	}

	public String getAddressSameAsStudent() {
		return addressSameAsStudent;
	}

	public void setAddressSameAsStudent(String addressSameAsStudent) {
		this.addressSameAsStudent = addressSameAsStudent;
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "parent")
	public List<AddressCollectionReportingParentName> getNames() {
		return names;
	}

	public void setNames(List<AddressCollectionReportingParentName> names) {
		this.names = names;
	}

	@Transient
	public AddressCollectionReportingParentName getParentName() {
		AddressCollectionReportingParentName result = null;
		if (names != null && !names.isEmpty()) {
			result = names.get(0);
		}
		return result;
	}

	@Transient
	public void setParentName(AddressCollectionReportingParentName name) {
		if (names == null) {
			names = new ArrayList<AddressCollectionReportingParentName>();
		}
		names.clear();
		if (name != null) {
			names.add(name);
		}
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "parent")
	public List<AddressCollectionReportingParentAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressCollectionReportingParentAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public AddressCollectionReportingParentAddress getParentAddress() {
		AddressCollectionReportingParentAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setParentAddress(AddressCollectionReportingParentAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<AddressCollectionReportingParentAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
		}
	}

}
