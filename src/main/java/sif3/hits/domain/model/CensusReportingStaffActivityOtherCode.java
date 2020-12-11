package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CensusReporting_Staff_ActivityOtherCode")
public class CensusReportingStaffActivityOtherCode extends BaseOtherCode {
	private static final long serialVersionUID = -5002883328219154209L;

	private CensusReportingStaff censusReportingStaff;

	@ManyToOne
	@JoinColumn(name = "CensusReporting_Staff_Id")
	public CensusReportingStaff getCensusReportingStaff() {
		return censusReportingStaff;
	}

	public void setCensusReportingStaff(CensusReportingStaff censusReportingStaff) {
		this.censusReportingStaff = censusReportingStaff;
	}
}
