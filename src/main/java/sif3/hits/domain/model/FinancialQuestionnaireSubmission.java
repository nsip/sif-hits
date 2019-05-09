package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FinancialQuestionnaireSubmission extends HitsEntity {
    private String refId;
    private String fqYear;
    private String reportingAuthority;
    private String reportingAuthoritySystem;
    private String reportingAuthorityCommonwealthId;
    private String systemSubmission;

    // softwareVendorInfo
    private String softwareProduct;
    private String softwareVersion;

    private String fqReportComments;
    private List<FQSubmissionEntityContact> entityContacts;
    private List<FQReporting> fqReportingList;

    @Id
    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getFqYear() {
        return fqYear;
    }

    public void setFqYear(String fqYear) {
        this.fqYear = fqYear;
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

    public String getFqReportComments() {
        return fqReportComments;
    }

    public void setFqReportComments(String fqReportComments) {
        this.fqReportComments = fqReportComments;
    }

    // Actually One To One but easier to manage through hibernate this way.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqSubmission")
    public List<FQSubmissionEntityContact> getEntityContacts() {
        return entityContacts;
    }

    public void setEntityContacts(List<FQSubmissionEntityContact> entityContacts) {
        this.entityContacts = entityContacts;
    }

    @Transient
    public FQSubmissionEntityContact getSubmissionContact() {
        FQSubmissionEntityContact result = null;
        if (entityContacts != null && !entityContacts.isEmpty()) {
            result = entityContacts.get(0);
        }
        return result;
    }

    @Transient
    public void setSubmissionContact(FQSubmissionEntityContact entityContact) {
        if (entityContacts == null) {
            entityContacts = new ArrayList<>();
        }
        entityContacts.clear();
        if (entityContact != null) {
            entityContacts.add(entityContact);
        }
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqSubmission")
    public List<FQReporting> getFqReportingList() {
        return fqReportingList;
    }

    public void setFqReportingList(List<FQReporting> fqReportingList) {
        this.fqReportingList = fqReportingList;
    }
}
