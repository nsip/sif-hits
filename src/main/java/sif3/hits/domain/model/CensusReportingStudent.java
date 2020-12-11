package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CensusReporting_Student")
public class CensusReportingStudent extends HitsEntity {
	private static final long serialVersionUID = 7302409522289697246L;

	private Long id;
	private CensusReporting censusReporting;
	private String studentCohortId;
	private String yearLevel;
	private String censusAge;
	private String cohortGender;
	private String cohortIndigenousType;
	private String educationMode;
	private String studentOnVisa;
	private String overseasStudent;
	private String disabilityLevelOfAdjustment;
	private String disabilityCategory;
	private String fte;
	private String headcount;

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

	public String getStudentCohortId() {
		return studentCohortId;
	}

	public void setStudentCohortId(String studentCohortId) {
		this.studentCohortId = studentCohortId;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}

	public String getCensusAge() {
		return censusAge;
	}

	public void setCensusAge(String censusAge) {
		this.censusAge = censusAge;
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

	public String getEducationMode() {
		return educationMode;
	}

	public void setEducationMode(String educationMode) {
		this.educationMode = educationMode;
	}

	public String getStudentOnVisa() {
		return studentOnVisa;
	}

	public void setStudentOnVisa(String studentOnVisa) {
		this.studentOnVisa = studentOnVisa;
	}

	public String getOverseasStudent() {
		return overseasStudent;
	}

	public void setOverseasStudent(String overseasStudent) {
		this.overseasStudent = overseasStudent;
	}

	public String getDisabilityLevelOfAdjustment() {
		return disabilityLevelOfAdjustment;
	}

	public void setDisabilityLevelOfAdjustment(String disabilityLevelOfAdjustment) {
		this.disabilityLevelOfAdjustment = disabilityLevelOfAdjustment;
	}

	public String getDisabilityCategory() {
		return disabilityCategory;
	}

	public void setDisabilityCategory(String disabilityCategory) {
		this.disabilityCategory = disabilityCategory;
	}

	public String getFte() {
		return fte;
	}

	public void setFte(String fte) {
		this.fte = fte;
	}

	public String getHeadcount() {
		return headcount;
	}

	public void setHeadcount(String headcount) {
		this.headcount = headcount;
	}

}
