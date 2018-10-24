package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FQReporting")
public class FQReporting extends HitsEntity {
    private static final long serialVersionUID = 2255931641297274283L;

    private String refId;
    private String fqYear;
    private String reportingAuthority;
    private String reportingAuthoritySystem;
    private String reportingAuthorityCommonwealthId;
    private String systemSubmission;

    // softwareVendorInfo
    private String softwareProduct;
    private String softwareVersion;

    private String entityLevel;
    private String schoolInfoRefId;
    private String localId;
    private String stateProvinceId;
    private String commonwealthId;
    private String acaraId;
    private String entityName;

    private List<FQEntityContact> entityContacts;
    private List<FQContextualQuestion> fqContextualQuestionList;
    private List<FQItem> fqItemList;
    private List<FQRule> fqRuleList;

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

    public String getEntityLevel() {
        return entityLevel;
    }

    public void setEntityLevel(String entityLevel) {
        this.entityLevel = entityLevel;
    }

    public String getSchoolInfoRefId() {
        return schoolInfoRefId;
    }

    public void setSchoolInfoRefId(String schoolInfoRefId) {
        this.schoolInfoRefId = schoolInfoRefId;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getStateProvinceId() {
        return stateProvinceId;
    }

    public void setStateProvinceId(String stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }

    public String getCommonwealthId() {
        return commonwealthId;
    }

    public void setCommonwealthId(String commonwealthId) {
        this.commonwealthId = commonwealthId;
    }

    public String getAcaraId() {
        return acaraId;
    }

    public void setAcaraId(String acaraId) {
        this.acaraId = acaraId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    // Actually One To One but easier to manage through hibernate this way.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
    public List<FQEntityContact> getEntityContacts() {
        return entityContacts;
    }

    public void setEntityContacts(List<FQEntityContact> entityContacts) {
        this.entityContacts = entityContacts;
    }

    @Transient
    public FQEntityContact getEntityContact() {
        FQEntityContact result = null;
        if (entityContacts != null && !entityContacts.isEmpty()) {
            result = entityContacts.get(0);
        }
        return result;
    }

    @Transient
    public void setEntityContact(FQEntityContact entityContact) {
        if (entityContacts == null) {
            entityContacts = new ArrayList<FQEntityContact>();
        }
        entityContacts.clear();
        if (entityContact != null) {
            entityContacts.add(entityContact);
        }
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
    public List<FQContextualQuestion> getFqContextualQuestionList() {
        return fqContextualQuestionList;
    }

    public void setFqContextualQuestionList(List<FQContextualQuestion> fqContextualQuestionList) {
        this.fqContextualQuestionList = fqContextualQuestionList;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
    public List<FQItem> getFqItemList() {
        return fqItemList;
    }

    public void setFqItemList(List<FQItem> fqItemList) {
        this.fqItemList = fqItemList;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "fqReporting")
    public List<FQRule> getFqRuleList() {
        return fqRuleList;
    }

    public void setFqRuleList(List<FQRule> fqRuleList) {
        this.fqRuleList = fqRuleList;
    }

}
