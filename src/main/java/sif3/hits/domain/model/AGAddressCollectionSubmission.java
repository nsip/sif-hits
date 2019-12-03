package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class AGAddressCollectionSubmission extends HitsEntity {
	private static final long serialVersionUID = -4234234991938219L;

	private String refId;
	private String addressCollectionYear;
	private String reportingAuthority;
	private String reportingAuthoritySystem;
    private String reportingAuthorityCommonwealthId;
    private String systemSubmission;
    private String softwareProduct;
    private String softwareVersion;
    private String addressCollectionComments;
    
    private List<AGAddressCollectionSubmissionEntityContact> entityContacts;
    private List<AGAddressCollectionReporting> addressCollectionReportingList;
    
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

	public String getReportingAuthority() {
		return reportingAuthority;
	}

	public void setReportingAuthority(String reportingAuthority) {
		this.reportingAuthority = reportingAuthority;
	}

	public String getReportingAuthoritySystem() {
		return reportingAuthoritySystem;
	}

	public void setReportingAuthoritySystem(String reportingAuthoritySystem) {
		this.reportingAuthoritySystem = reportingAuthoritySystem;
	}

	public String getReportingAuthorityCommonwealthId() {
		return reportingAuthorityCommonwealthId;
	}

	public void setReportingAuthorityCommonwealthId(String reportingAuthorityCommonwealthId) {
		this.reportingAuthorityCommonwealthId = reportingAuthorityCommonwealthId;
	}

	public String getSystemSubmission() {
		return systemSubmission;
	}

	public void setSystemSubmission(String systemSubmission) {
		this.systemSubmission = systemSubmission;
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

	public String getAddressCollectionComments() {
		return addressCollectionComments;
	}

	public void setAddressCollectionComments(String addressCollectionComments) {
		this.addressCollectionComments = addressCollectionComments;
	}

    // Actually One To One but easier to manage through hibernate this way.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agAddressCollectionSubmission")
    public List<AGAddressCollectionSubmissionEntityContact> getEntityContacts() {
        return entityContacts;
    }

    public void setEntityContacts(List<AGAddressCollectionSubmissionEntityContact> entityContacts) {
        this.entityContacts = entityContacts;
    }

    @Transient
    public AGAddressCollectionSubmissionEntityContact getEntityContact() {
    	AGAddressCollectionSubmissionEntityContact result = null;
        if (entityContacts != null && !entityContacts.isEmpty()) {
            result = entityContacts.get(0);
        }
        return result;
    }

    @Transient
    public void setEntityContact(AGAddressCollectionSubmissionEntityContact entityContact) {
        if (entityContacts == null) {
            entityContacts = new ArrayList<AGAddressCollectionSubmissionEntityContact>();
        }
        entityContacts.clear();
        if (entityContact != null) {
            entityContacts.add(entityContact);
        }
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agAddressCollectionSubmission")
	public List<AGAddressCollectionReporting> getAddressCollectionReportingList() {
		return addressCollectionReportingList;
	}

	public void setAddressCollectionReportingList(List<AGAddressCollectionReporting> addressCollectionReportingList) {
		this.addressCollectionReportingList = addressCollectionReportingList;
	}
	
	

}
