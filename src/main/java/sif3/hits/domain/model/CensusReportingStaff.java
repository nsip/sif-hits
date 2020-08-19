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
@Table(name = "CensusReporting_Staff")
public class CensusReportingStaff extends HitsEntity {
	private static final long serialVersionUID = -5446370786245013088L;

	private Long id;
	private CensusReporting censusReporting;
	private String staffCohortId;
	private String staffActivity;
	private String cohortGender;
	private String cohortIndigenousType;
	private String primaryFTE;
	private String secondaryFTE;
	private String jobFTE;
	private String headCount;
	private List<CensusReportingStaffActivityOtherCode> censusReportingStaffActivityOtherCodeList;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "CensusReporting_Id")
	public CensusReporting getCensusReporting() {
		return censusReporting;
	}

	public void setCensusReporting(CensusReporting censusReporting) {
		this.censusReporting = censusReporting;
	}

	public String getStaffCohortId() {
		return staffCohortId;
	}

	public void setStaffCohortId(String staffCohortId) {
		this.staffCohortId = staffCohortId;
	}

	public String getStaffActivity() {
		return staffActivity;
	}

	public void setStaffActivity(String staffActivity) {
		this.staffActivity = staffActivity;
	}

	public String getCohortGender() {
		return cohortGender;
	}

	public void setCohortGender(String cohortGender) {
		this.cohortGender = cohortGender;
	}

	public String getCohortIndigenousType() {
		return cohortIndigenousType;
	}

	public void setCohortIndigenousType(String cohortIndigenousType) {
		this.cohortIndigenousType = cohortIndigenousType;
	}

	public String getPrimaryFTE() {
		return primaryFTE;
	}

	public void setPrimaryFTE(String primaryFTE) {
		this.primaryFTE = primaryFTE;
	}

	public String getSecondaryFTE() {
		return secondaryFTE;
	}

	public void setSecondaryFTE(String secondaryFTE) {
		this.secondaryFTE = secondaryFTE;
	}

	public String getJobFTE() {
		return jobFTE;
	}

	public void setJobFTE(String jobFTE) {
		this.jobFTE = jobFTE;
	}

	public String getHeadCount() {
		return headCount;
	}

	public void setHeadCount(String headCount) {
		this.headCount = headCount;
	}

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "censusReportingStaff")
	public List<CensusReportingStaffActivityOtherCode> getCensusReportingStaffActivityOtherCodeList() {
		return censusReportingStaffActivityOtherCodeList;
	}

	public void setCensusReportingStaffActivityOtherCodeList(
			List<CensusReportingStaffActivityOtherCode> censusReportingStaffActivityOtherCodeList) {
		this.censusReportingStaffActivityOtherCodeList = censusReportingStaffActivityOtherCodeList;
	}
}
