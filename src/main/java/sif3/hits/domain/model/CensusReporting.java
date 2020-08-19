package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class CensusReporting {
	private Long id;
	private CensusCollection censusCollection;

	private String entityLevel;
	private String commonwealthId;
	private String entityName;
	private List<CensusReportingEntityContact> entityContacts;
	private List<CensusReportingStaff> censusStaffList;
	private List<CensusReportingStudent> censusStudentList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "CensusCollection_RefId")
	public CensusCollection getCensusCollection() {
		return censusCollection;
	}

	public void setCensusCollection(CensusCollection censusCollection) {
		this.censusCollection = censusCollection;
	}

	public String getEntityLevel() {
		return entityLevel;
	}

	public void setEntityLevel(String entityLevel) {
		this.entityLevel = entityLevel;
	}

	public String getCommonwealthId() {
		return commonwealthId;
	}

	public void setCommonwealthId(String commonwealthId) {
		this.commonwealthId = commonwealthId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	// Actually OneToOne but easier to manager in hibernate this way.
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "censusReporting")
	public List<CensusReportingEntityContact> getEntityContacts() {
		return entityContacts;
	}

	public void setEntityContacts(List<CensusReportingEntityContact> entityContacts) {
		this.entityContacts = entityContacts;
	}

	@Transient
	public CensusReportingEntityContact getEntityContact() {
		CensusReportingEntityContact result = null;
		if (entityContacts != null && !entityContacts.isEmpty()) {
			result = entityContacts.get(0);
		}
		return result;
	}
	
	@Transient
	public void setEntityContact(CensusReportingEntityContact entityContact) {
		if (entityContacts == null) {
			entityContacts = new ArrayList<>();
		}
		entityContacts.clear();
		if (entityContact != null) {
			entityContacts.add(entityContact);
		}
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "censusReporting")
	public List<CensusReportingStaff> getCensusStaffList() {
		return censusStaffList;
	}

	public void setCensusStaffList(List<CensusReportingStaff> censusStaffList) {
		this.censusStaffList = censusStaffList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "censusReporting")
	public List<CensusReportingStudent> getCensusStudentList() {
		return censusStudentList;
	}

	public void setCensusStudentList(List<CensusReportingStudent> censusStudentList) {
		this.censusStudentList = censusStudentList;
	}

}
