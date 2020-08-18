package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AddressCollection extends HitsEntity {
	private static final long serialVersionUID = -4234234991938219L;

	private String refId;
	private String addressCollectionYear;
	private String roundCode;
    private String reportingAuthorityCommonwealthId;
    private String softwareProduct;
    private String softwareVersion;
    private List<AddressCollectionReporting> addressCollectionReportingList;
    private List<AddressCollectionLocalCode> addressCollectionLocalCodeList;
    
	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getAddressCollectionYear() {
		return addressCollectionYear;
	}

	public void setAddressCollectionYear(String addressCollectionYear) {
		this.addressCollectionYear = addressCollectionYear;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "addressCollection")
	public List<AddressCollectionReporting> getAddressCollectionReportingList() {
		return addressCollectionReportingList;
	}

	public void setAddressCollectionReportingList(List<AddressCollectionReporting> addressCollectionReportingList) {
		this.addressCollectionReportingList = addressCollectionReportingList;
	}
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "addressCollection")
	public List<AddressCollectionLocalCode> getAddressCollectionLocalCodeList() {
		return addressCollectionLocalCodeList;
	}

	public void setAddressCollectionLocalCodeList(List<AddressCollectionLocalCode> addressCollectionLocalCodeList) {
		this.addressCollectionLocalCodeList = addressCollectionLocalCodeList;
	}
}
