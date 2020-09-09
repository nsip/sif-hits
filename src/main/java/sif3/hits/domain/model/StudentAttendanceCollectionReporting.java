package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class StudentAttendanceCollectionReporting extends HitsEntity {
	private static final long serialVersionUID = -2177387558463474093L;

	private Long id;
	private StudentAttendanceCollection studentAttendanceCollection;
	private String entityLevel;
	private String schoolInfoRefId;
	private String localId;
	private String stateProvinceId;
	private String commonwealthId;
	private String acaraId;
	private String entityName;
	private List<StudentAttendanceCollectionReportingEntityContact> entityContacts;
	private List<StatsCohortYearLevel> statsCohortYearLevelList;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "StudentAttendanceCollection_RefId")
	public StudentAttendanceCollection getStudentAttendanceCollection() {
		return studentAttendanceCollection;
	}

	public void setStudentAttendanceCollection(StudentAttendanceCollection studentAttendanceCollection) {
		this.studentAttendanceCollection = studentAttendanceCollection;
	}

	public String getEntityLevel() {
		return entityLevel;
	}

	public void setEntityLevel(String entityLevel) {
		this.entityLevel = entityLevel;
	}

	@Column(name = "SchoolInfo_RefId")
	public String getSchoolInfoRefId() {
		return schoolInfoRefId;
	}

	public void setSchoolInfoRefId(String schoolInfoRefId) {
		this.schoolInfoRefId = schoolInfoRefId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getStateProvinceId() {
		return stateProvinceId;
	}

	public void setStateProvinceId(String stateProvinceId) {
		this.stateProvinceId = stateProvinceId;
	}

	public String getCommonwealthId() {
		return commonwealthId;
	}

	public void setCommonwealthId(String commonwealthId) {
		this.commonwealthId = commonwealthId;
	}

	public String getAcaraId() {
		return acaraId;
	}

	public void setAcaraId(String acaraId) {
		this.acaraId = acaraId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	// Actually One To One but easier to manage through hibernate this way.
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentAttendanceCollectionReporting")
	public List<StudentAttendanceCollectionReportingEntityContact> getEntityContacts() {
		return entityContacts;
	}

	public void setEntityContacts(List<StudentAttendanceCollectionReportingEntityContact> entityContacts) {
		this.entityContacts = entityContacts;
	}

	@Transient
	public StudentAttendanceCollectionReportingEntityContact getEntityContact() {
		StudentAttendanceCollectionReportingEntityContact result = null;
		if (entityContacts != null && !entityContacts.isEmpty()) {
			result = entityContacts.get(0);
		}
		return result;
	}

	@Transient
	public void setEntityContact(StudentAttendanceCollectionReportingEntityContact entityContact) {
		if (entityContacts == null) {
			entityContacts = new ArrayList<>();
		}
		entityContacts.clear();
		if (entityContact != null) {
			entityContacts.add(entityContact);
			entityContact.setStudentAttendanceCollectionReporting(this);
		}
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentAttendanceCollectionReporting")
	public List<StatsCohortYearLevel> getStatsCohortYearLevelList() {
		return statsCohortYearLevelList;
	}

	public void setStatsCohortYearLevelList(List<StatsCohortYearLevel> statsCohortYearLevelList) {
		this.statsCohortYearLevelList = statsCohortYearLevelList;
	}

}
