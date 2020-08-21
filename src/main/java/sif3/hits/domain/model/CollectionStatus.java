package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CollectionStatus extends HitsEntity {
	private static final long serialVersionUID = 1467667377929396096L;

	private String refId;
	private String reportingAuthority;
	private String reportingAuthoritySystem;
	private String reportingAuthorityCommonwealthId;
	private String submittedBy;
	private String submissionTimestamp;
	private String agCollection;
	private String collectionYear;
	private String roundCode;
	private List<AGReportingObjectResponse> agReportingObjectResponseList;
	private List<CollectionStatusLocalCode> localCodeList;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getReportingAuthority() {
		return reportingAuthority;
	}

	public void setReportingAuthority(String reportingAuthority) {
		this.reportingAuthority = reportingAuthority;
	}

	public String getReportingAuthoritySystem() {
		return reportingAuthoritySystem;
	}

	public void setReportingAuthoritySystem(String reportingAuthoritySystem) {
		this.reportingAuthoritySystem = reportingAuthoritySystem;
	}

	public String getReportingAuthorityCommonwealthId() {
		return reportingAuthorityCommonwealthId;
	}

	public void setReportingAuthorityCommonwealthId(String reportingAuthorityCommonwealthId) {
		this.reportingAuthorityCommonwealthId = reportingAuthorityCommonwealthId;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSubmissionTimestamp() {
		return submissionTimestamp;
	}

	public void setSubmissionTimestamp(String submissionTimestamp) {
		this.submissionTimestamp = submissionTimestamp;
	}

	public String getAgCollection() {
		return agCollection;
	}

	public void setAgCollection(String agCollection) {
		this.agCollection = agCollection;
	}

	public String getCollectionYear() {
		return collectionYear;
	}

	public void setCollectionYear(String collectionYear) {
		this.collectionYear = collectionYear;
	}

	public String getRoundCode() {
		return roundCode;
	}

	public void setRoundCode(String roundCode) {
		this.roundCode = roundCode;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "collectionStatus")
	public List<AGReportingObjectResponse> getAgReportingObjectResponseList() {
		return agReportingObjectResponseList;
	}

	public void setAgReportingObjectResponseList(List<AGReportingObjectResponse> agReportingObjectResponseList) {
		this.agReportingObjectResponseList = agReportingObjectResponseList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "collectionStatus")
	public List<CollectionStatusLocalCode> getLocalCodeList() {
		return localCodeList;
	}

	public void setLocalCodeList(List<CollectionStatusLocalCode> localCodeList) {
		this.localCodeList = localCodeList;
	}
}
