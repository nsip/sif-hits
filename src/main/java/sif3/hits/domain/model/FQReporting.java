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
import javax.persistence.Transient;

@Entity
public class FQReporting {
	private Long id;
	private FinancialQuestionnaireCollection fqCollection;
	private String entityLevel;
	private String schoolInfoRefId;
	private String localId;
	private String stateProvinceId;
	private String commonwealthId;
	private String acaraId;
	private String entityName;
	private List<FQReportingEntityContact> entityContacts;
	private List<FQReportingFQContextualQuestion> contextualQuestionList;
	private List<FQItem> fqItemList;
	private List<FQReportingAGRule> agRuleList;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "FQCollection_RefId")
	public FinancialQuestionnaireCollection getFqCollection() {
		return fqCollection;
	}

	public void setFqCollection(FinancialQuestionnaireCollection fqCollection) {
		this.fqCollection = fqCollection;
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
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
	public List<FQReportingEntityContact> getEntityContacts() {
		return entityContacts;
	}

	public void setEntityContacts(List<FQReportingEntityContact> entityContacts) {
		this.entityContacts = entityContacts;
	}

	@Transient
	public FQReportingEntityContact getEntityContact() {
		FQReportingEntityContact result = null;
		if (entityContacts != null && !entityContacts.isEmpty()) {
			result = entityContacts.get(0);
		}
		return result;
	}

	@Transient
	public void setEntityContact(FQReportingEntityContact entityContact) {
		if (entityContacts == null) {
			entityContacts = new ArrayList<>();
		}
		entityContacts.clear();
		if (entityContact != null) {
			entityContacts.add(entityContact);
			entityContact.setFqReporting(this);
		}
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
	public List<FQReportingFQContextualQuestion> getContextualQuestionList() {
		return contextualQuestionList;
	}

	public void setContextualQuestionList(List<FQReportingFQContextualQuestion> contextualQuestionList) {
		this.contextualQuestionList = contextualQuestionList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
	public List<FQItem> getFqItemList() {
		return fqItemList;
	}

	public void setFqItemList(List<FQItem> fqItemList) {
		this.fqItemList = fqItemList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
	public List<FQReportingAGRule> getAgRuleList() {
		return agRuleList;
	}

	public void setAgRuleList(List<FQReportingAGRule> agRuleList) {
		this.agRuleList = agRuleList;
	}

}
