package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CollectionStatus_AGROResponse_AGRule")
public class CollectionStatusReponseAGRule extends BaseAGRule {
	private static final long serialVersionUID = -678701689167608160L;

	private AGReportingObjectResponse agReportingObjectResponse;

	@ManyToOne(optional = false)
	@JoinColumn(name = "AGReportingObjectResponse_Id")
	public AGReportingObjectResponse getAgReportingObjectResponse() {
		return agReportingObjectResponse;
	}

	public void setAgReportingObjectResponse(AGReportingObjectResponse agReportingObjectResponse) {
		this.agReportingObjectResponse = agReportingObjectResponse;
	}

}
