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
@Table(name = "AddressCR_Student")
public class AddressCollectionReportingStudent extends HitsEntity {
	private static final long serialVersionUID = 6022228211929759205L;

	private Long id;
	private AddressCollectionReporting addressCollectionReporting;
	private String localId;
	private String educationLevel;
	private String boardingStatus;
	private String reportingParent2;
	private List<AddressCollectionReportingStudentAddress> addresses;
	private List<AddressCollectionReportingParent> parents;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "AddressCollectionReporting_Id")
	public AddressCollectionReporting getAddressCollectionReporting() {
		return addressCollectionReporting;
	}

	public void setAddressCollectionReporting(AddressCollectionReporting addressCollectionReporting) {
		this.addressCollectionReporting = addressCollectionReporting;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getBoardingStatus() {
		return boardingStatus;
	}

	public void setBoardingStatus(String boardingStatus) {
		this.boardingStatus = boardingStatus;
	}

	public String getReportingParent2() {
		return reportingParent2;
	}

	public void setReportingParent2(String reportingParent2) {
		this.reportingParent2 = reportingParent2;
	}

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "student")
	public List<AddressCollectionReportingStudentAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressCollectionReportingStudentAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public AddressCollectionReportingStudentAddress getStudentAddress() {
		AddressCollectionReportingStudentAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setStudentAddress(AddressCollectionReportingStudentAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<AddressCollectionReportingStudentAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
			address.setStudent(this);
		}
	}

	// Actually One to Two but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "student")
	public List<AddressCollectionReportingParent> getParents() {
		return parents;
	}

	public void setParents(List<AddressCollectionReportingParent> parents) {
		this.parents = parents;
	}

	@Transient
	public AddressCollectionReportingParent getParent1() {
		AddressCollectionReportingParent result = null;
		if (parents != null) {
			for (AddressCollectionReportingParent parent : parents) {
				if (parent.getParentNumber() == 1) {
					result = parent;
				}
			}
		}
		return result;
	}

	@Transient
	public void setParent1(AddressCollectionReportingParent parent1) {
		if (parents == null) {
			parents = new ArrayList<AddressCollectionReportingParent>();
		}
		AddressCollectionReportingParent remove = getParent1();
		if (remove != null) {
			parents.remove(remove);
		}
		if (parent1 != null) {
			parent1.setParentNumber(1);
			parents.add(parent1);
			parent1.setStudent(this);
		}
	}

	@Transient
	public AddressCollectionReportingParent getParent2() {
		AddressCollectionReportingParent result = null;
		if (parents != null) {
			for (AddressCollectionReportingParent parent : parents) {
				if (parent.getParentNumber() == 2) {
					result = parent;
				}
			}
		}
		return result;
	}

	@Transient
	public void setParent2(AddressCollectionReportingParent parent2) {
		if (parents == null) {
			parents = new ArrayList<AddressCollectionReportingParent>();
		}
		AddressCollectionReportingParent remove = getParent2();
		if (remove != null) {
			parents.remove(remove);
		}
		if (parent2 != null) {
			parent2.setParentNumber(2);
			parents.add(parent2);
			parent2.setStudent(this);
		}
	}

}
