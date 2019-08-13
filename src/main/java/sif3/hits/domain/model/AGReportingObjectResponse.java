package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AGStatusReport_ReportingObjectResponse")
public class AGReportingObjectResponse {
    private Long id;
    private AGStatusReport agStatusReport;
    private String submittedRefId;
    private String sifRefId;
    private String httpStatusCode;
    private String errorText;
    private String commonwealthId;
    private String entityName;
    private String agSubmissionStatusCode;
    private List<AGRule> agRuleList;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional =  false)
    @JoinColumn(name = "AGStatusReport_RefId")
    public AGStatusReport getAgStatusReport() {
        return agStatusReport;
    }

    public void setAgStatusReport(AGStatusReport agStatusReport) {
        this.agStatusReport = agStatusReport;
    }

    public String getSubmittedRefId() {
        return submittedRefId;
    }

    public void setSubmittedRefId(String submittedRefId) {
        this.submittedRefId = submittedRefId;
    }

    public String getSifRefId() {
        return sifRefId;
    }

    public void setSifRefId(String sifRefId) {
        this.sifRefId = sifRefId;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getCommonwealthId() {
        return commonwealthId;
    }

    public void setCommonwealthId(String commonwealthId) {
        this.commonwealthId = commonwealthId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getAgSubmissionStatusCode() {
        return agSubmissionStatusCode;
    }

    public void setAgSubmissionStatusCode(String agSubmissionStatusCode) {
        this.agSubmissionStatusCode = agSubmissionStatusCode;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "agReportingObjectResponse")
    public List<AGRule> getAgRuleList() {
        return agRuleList;
    }

    public void setAgRuleList(List<AGRule> agRuleList) {
        this.agRuleList = agRuleList;
    }
}
