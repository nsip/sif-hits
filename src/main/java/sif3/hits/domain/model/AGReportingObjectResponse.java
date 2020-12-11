package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CollectionStatus_AGReportingObjectResponse")
public class AGReportingObjectResponse extends HitsEntity {
	private static final long serialVersionUID = -8660963213427174360L;

	private Long id;
	private CollectionStatus collectionStatus;
	private String submittedRefId;
	private String sifRefId;
	private String httpStatusCode;
	private String errorText;
	private String commonwealthId;
	private String entityName;
	private String agSubmissionStatusCode;
	private List<CollectionStatusReponseAGRule> agRuleList;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "CollectionStatus_RefId")
	public CollectionStatus getCollectionStatus() {
		return collectionStatus;
	}

	public void setCollectionStatus(CollectionStatus collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

	public String getSubmittedRefId() {
		return submittedRefId;
	}

	public void setSubmittedRefId(String submittedRefId) {
		this.submittedRefId = submittedRefId;
	}

	public String getSifRefId() {
		return sifRefId;
	}

	public void setSifRefId(String sifRefId) {
		this.sifRefId = sifRefId;
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
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

	public String getAgSubmissionStatusCode() {
		return agSubmissionStatusCode;
	}

	public void setAgSubmissionStatusCode(String agSubmissionStatusCode) {
		this.agSubmissionStatusCode = agSubmissionStatusCode;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agReportingObjectResponse")
	public List<CollectionStatusReponseAGRule> getAgRuleList() {
		return agRuleList;
	}

	public void setAgRuleList(List<CollectionStatusReponseAGRule> agRuleList) {
		this.agRuleList = agRuleList;
	}

}
