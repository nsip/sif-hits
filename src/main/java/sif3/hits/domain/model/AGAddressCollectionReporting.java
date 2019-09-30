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
@Table(name = "AGAddressCS_AGAddressCollectionReporting")
public class AGAddressCollectionReporting extends HitsEntity {
	private static final long serialVersionUID = 648207816228898154L;

	private Long id;
	private AGAddressCollectionSubmission agAddressCollectionSubmission;
	private String addressCollectionRefId;
	private String entityLevel;
	private String schoolInfoRefId;
	private String localId;
	private String stateProvinceId;
	private String commonwealthId;
	private String acaraId;
	private String entityName;
	private List<AGAddressCollectionReportingEntityContact> entityContacts;
	private List<AGAddressCollectionReportingStudent> addressCollectionStudentList;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	@ManyToOne
	@JoinColumn(name = "AGAddressCollectionSubmission_RefId")
	public AGAddressCollectionSubmission getAgAddressCollectionSubmission() {
		return agAddressCollectionSubmission;
	}

	public void setAgAddressCollectionSubmission(AGAddressCollectionSubmission agAddressCollectionSubmission) {
		this.agAddressCollectionSubmission = agAddressCollectionSubmission;
	}

	public String getAddressCollectionRefId() {
		return addressCollectionRefId;
	}

	public void setAddressCollectionRefId(String addressCollectionRefId) {
		this.addressCollectionRefId = addressCollectionRefId;
	}

	public String getEntityLevel() {
		return entityLevel;
	}

	public void setEntityLevel(String entityLevel) {
		this.entityLevel = entityLevel;
	}

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agAddressCollectionReporting")
    public List<AGAddressCollectionReportingEntityContact> getEntityContacts() {
        return entityContacts;
    }

    public void setEntityContacts(List<AGAddressCollectionReportingEntityContact> entityContacts) {
        this.entityContacts = entityContacts;
    }

    @Transient
    public AGAddressCollectionReportingEntityContact getEntityContact() {
    	AGAddressCollectionReportingEntityContact result = null;
        if (entityContacts != null && !entityContacts.isEmpty()) {
            result = entityContacts.get(0);
        }
        return result;
    }

    @Transient
    public void setEntityContact(AGAddressCollectionReportingEntityContact entityContact) {
        if (entityContacts == null) {
            entityContacts = new ArrayList<AGAddressCollectionReportingEntityContact>();
        }
        entityContacts.clear();
        if (entityContact != null) {
            entityContacts.add(entityContact);
        }
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agAddressCollectionReporting")
	public List<AGAddressCollectionReportingStudent> getAddressCollectionStudentList() {
		return addressCollectionStudentList;
	}

	public void setAddressCollectionStudentList(
			List<AGAddressCollectionReportingStudent> addressCollectionStudentList) {
		this.addressCollectionStudentList = addressCollectionStudentList;
	}

}
