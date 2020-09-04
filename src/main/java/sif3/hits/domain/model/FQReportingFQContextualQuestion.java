package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_ContextualQuestion")
public class FQReportingFQContextualQuestion extends BaseAGContextualQuestion {
	private static final long serialVersionUID = 3017232971573605200L;

	private FQReporting fqReporting;

	@ManyToOne
	@JoinColumn(name = "FQReporting_Id")
	public FQReporting getFqReporting() {
		return fqReporting;
	}

	public void setFqReporting(FQReporting fqReporting) {
		this.fqReporting = fqReporting;
	}

}
