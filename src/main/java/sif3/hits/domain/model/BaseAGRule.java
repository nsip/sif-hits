package sif3.hits.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseAGRule extends HitsEntity {
	private static final long serialVersionUID = -7092820753430253047L;

	private Long id;
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
