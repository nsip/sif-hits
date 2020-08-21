package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CollectionStatus_AGROResponse_AGRule")
public class AGRule {
	private Long id;
	private AGReportingObjectResponse agReportingObjectResponse;
	private String agRuleCode;
	private String agRuleComment;
	private String agRuleResponse;
	private String agRuleStatus;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "AGReportingObjectResponse_Id")
	public AGReportingObjectResponse getAgReportingObjectResponse() {
		return agReportingObjectResponse;
	}

	public void setAgReportingObjectResponse(AGReportingObjectResponse agReportingObjectResponse) {
		this.agReportingObjectResponse = agReportingObjectResponse;
	}

	public String getAgRuleCode() {
		return agRuleCode;
	}

	public void setAgRuleCode(String agRuleCode) {
		this.agRuleCode = agRuleCode;
	}

	public String getAgRuleComment() {
		return agRuleComment;
	}

	public void setAgRuleComment(String agRuleComment) {
		this.agRuleComment = agRuleComment;
	}

	public String getAgRuleResponse() {
		return agRuleResponse;
	}

	public void setAgRuleResponse(String agRuleResponse) {
		this.agRuleResponse = agRuleResponse;
	}

	public String getAgRuleStatus() {
		return agRuleStatus;
	}

	public void setAgRuleStatus(String agRuleStatus) {
		this.agRuleStatus = agRuleStatus;
	}
}
