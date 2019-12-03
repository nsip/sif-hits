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
@Table(name = "AGAddressCR_Parent")
public class AGAddressCollectionReportingParent extends HitsEntity {
	private static final long serialVersionUID = -5885672220749833387L;

	private Long id;
	private AGAddressCollectionReportingStudent student;
	private Integer parentNumber;
	private String addressSameAsStudent;

	private List<AGAddressCollectionReportingParentName> names;
	private List<AGAddressCollectionReportingParentAddress> addresses;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    @ManyToOne(optional = false)
    @JoinColumn(name = "AGAddressCR_Student_Id", referencedColumnName = "Id")
	public AGAddressCollectionReportingStudent getStudent() {
		return student;
	}
	
	public void setStudent(AGAddressCollectionReportingStudent student) {
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
	public List<AGAddressCollectionReportingParentName> getNames() {
		return names;
	}

	public void setNames(List<AGAddressCollectionReportingParentName> names) {
		this.names = names;
	}

	@Transient
	public AGAddressCollectionReportingParentName getName() {
		AGAddressCollectionReportingParentName result = null;
		if (names != null && !names.isEmpty()) {
			result = names.get(0);
		}
		return result;
	}

	@Transient
	public void setName(AGAddressCollectionReportingParentName name) {
		if (names == null) {
			names = new ArrayList<AGAddressCollectionReportingParentName>();
		}
		names.clear();
		if (name != null) {
			names.add(name);
		}
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "parent")
	public List<AGAddressCollectionReportingParentAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AGAddressCollectionReportingParentAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public AGAddressCollectionReportingParentAddress getAddress() {
		AGAddressCollectionReportingParentAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(AGAddressCollectionReportingParentAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<AGAddressCollectionReportingParentAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
		}
	}

}
