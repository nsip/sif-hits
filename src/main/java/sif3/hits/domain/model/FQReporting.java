package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FQReporting")
public class FQReporting extends HitsEntity {
    private static final long serialVersionUID = 2255931641297274283L;

    private Long id;
    private FinancialQuestionnaireSubmission fqSubmission;
    private String fqRefId;
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
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "FQSubmission_RefId")
    public FinancialQuestionnaireSubmission getFqSubmission() {
        return fqSubmission;
    }

    public void setFqSubmission(FinancialQuestionnaireSubmission fqSubmission) {
        this.fqSubmission = fqSubmission;
    }

    public String getFqRefId() {
        return fqRefId;
    }

    public void setFqRefId(String fqRefId) {
        this.fqRefId = fqRefId;
    }

    public String getEntityLevel() {
        return entityLevel;
    }

    public void setEntityLevel(String entityLevel) {
        this.entityLevel = entityLevel;
    }

    @Column(name = "SchoolInfo_RefId")
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
