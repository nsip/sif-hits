package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_FQRule")
public class FQRule extends HitsEntity {
    private static final long serialVersionUID = -3404658572157565366L;

    private Long id;
    private FQReporting fqReporting;
    private String fqRuleCode;
    private String fqRuleComment;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "FQReporting_RefId", referencedColumnName = "RefId")
    public FQReporting getFqReporting() {
        return fqReporting;
    }

    public void setFqReporting(FQReporting fqReporting) {
        this.fqReporting = fqReporting;
    }

    public String getFqRuleCode() {
        return fqRuleCode;
    }

    public void setFqRuleCode(String fqRuleCode) {
        this.fqRuleCode = fqRuleCode;
    }

    public String getFqRuleComment() {
        return fqRuleComment;
    }

    public void setFqRuleComment(String fqRuleComment) {
        this.fqRuleComment = fqRuleComment;
    }

}
