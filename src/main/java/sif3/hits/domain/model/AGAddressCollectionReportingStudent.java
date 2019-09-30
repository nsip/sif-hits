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
@Table(name = "AGAddressCR_Student")
public class AGAddressCollectionReportingStudent extends HitsEntity {
	private static final long serialVersionUID = 6022228211929759205L;

	private Long id;
	private AGAddressCollectionReporting agAddressCollectionReporting;
	private String localId;
	private String educationLevel;
	private String boardingStatus;
	private List<AGAddressCollectionReportingStudentAddress> addresses;
	private List<AGAddressCollectionReportingParent> parents;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "AGAddressCR_Id")
	public AGAddressCollectionReporting getAgAddressCollectionReporting() {
		return agAddressCollectionReporting;
	}

	public void setAgAddressCollectionReporting(AGAddressCollectionReporting agAddressCollectionReporting) {
		this.agAddressCollectionReporting = agAddressCollectionReporting;
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

	// Actually One to One but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "student")
	public List<AGAddressCollectionReportingStudentAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AGAddressCollectionReportingStudentAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public AGAddressCollectionReportingStudentAddress getAddress() {
		AGAddressCollectionReportingStudentAddress result = null;
		if (addresses != null && !addresses.isEmpty()) {
			result = addresses.get(0);
		}
		return result;
	}

	@Transient
	public void setAddress(AGAddressCollectionReportingStudentAddress address) {
		if (addresses == null) {
			addresses = new ArrayList<AGAddressCollectionReportingStudentAddress>();
		}
		addresses.clear();
		if (address != null) {
			addresses.add(address);
		}
	}

	// Actually One to Two but easier to manage with hibernate this way
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "student")
	public List<AGAddressCollectionReportingParent> getParents() {
		return parents;
	}

	public void setParentes(List<AGAddressCollectionReportingParent> parents) {
		this.parents = parents;
	}

	@Transient
	public AGAddressCollectionReportingParent getParent1() {
		AGAddressCollectionReportingParent result = null;
		if (parents != null) {
			for (AGAddressCollectionReportingParent parent : parents) {
				if (parent.getParentNumber() == 1) {
					result = parent;
				}
			}
		}
		return result;
	}

	@Transient
	public void setParent1(AGAddressCollectionReportingParent parent1) {
		if (parents == null) {
			parents = new ArrayList<AGAddressCollectionReportingParent>();
		}
		AGAddressCollectionReportingParent remove = null;
		for (AGAddressCollectionReportingParent parent : parents) {
			if (parent.getParentNumber() == 1) {
				remove = parent;
			}
		}
		if (remove != null) {
			parents.remove(remove);
		}
		if (parent1 != null) {
			parent1.setParentNumber(1);
			parents.add(parent1);
		}
	}

	@Transient
	public AGAddressCollectionReportingParent getParent2() {
		AGAddressCollectionReportingParent result = null;
		if (parents != null) {
			for (AGAddressCollectionReportingParent parent : parents) {
				if (parent.getParentNumber() == 2) {
					result = parent;
				}
			}
		}
		return result;
	}

	@Transient
	public void setParent2(AGAddressCollectionReportingParent parent2) {
		if (parents == null) {
			parents = new ArrayList<AGAddressCollectionReportingParent>();
		}
		AGAddressCollectionReportingParent remove = null;
		for (AGAddressCollectionReportingParent parent : parents) {
			if (parent.getParentNumber() == 2) {
				remove = parent;
			}
		}
		if (remove != null) {
			parents.remove(remove);
		}
		if (parent2 != null) {
			parent2.setParentNumber(2);
			parents.add(parent2);
		}
	}

}
