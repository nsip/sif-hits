package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_AGRule")
public class FQReportingAGRule extends BaseAGRule {
	private static final long serialVersionUID = -678701689167608160L;

	private FQReporting fqReporting;

	@ManyToOne(optional = false)
	@JoinColumn(name = "FQReporting_Id")
	public FQReporting getFqReporting() {
		return fqReporting;
	}

	public void setFqReporting(FQReporting fqReporting) {
		this.fqReporting = fqReporting;
	}

}
