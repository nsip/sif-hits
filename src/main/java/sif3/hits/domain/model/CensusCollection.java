package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CensusCollection extends HitsEntity {
	private static final long serialVersionUID = -8192215451821191710L;

	private String refId;
	private String censusYear;
	private String roundCode;
	private String reportingAuthorityCommonwealthId;
	private String softwareProduct;
	private String softwareVersion;
	private List<CensusReporting> censusReportingList;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(String censusYear) {
		this.censusYear = censusYear;
	}

	public String getRoundCode() {
		return roundCode;
	}

	public void setRoundCode(String roundCode) {
		this.roundCode = roundCode;
	}

	public String getReportingAuthorityCommonwealthId() {
		return reportingAuthorityCommonwealthId;
	}

	public void setReportingAuthorityCommonwealthId(String reportingAuthorityCommonwealthId) {
		this.reportingAuthorityCommonwealthId = reportingAuthorityCommonwealthId;
	}

	@Column(name = "SoftwareVendorInfo_SoftwareProduct")
	public String getSoftwareProduct() {
		return softwareProduct;
	}

	public void setSoftwareProduct(String softwareProduct) {
		this.softwareProduct = softwareProduct;
	}

	@Column(name = "SoftwareVendorInfo_SoftwareVersion")
	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "censusCollection")
	public List<CensusReporting> getCensusReportingList() {
		return censusReportingList;
	}

	public void setCensusReportingList(List<CensusReporting> censusReportingList) {
		this.censusReportingList = censusReportingList;
	}

}
