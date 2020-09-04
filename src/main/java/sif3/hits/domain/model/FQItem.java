package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sif3.hits.domain.model.HitsEntity;

@Entity
@Table(name = "FQReporting_FQItem")
public class FQItem extends HitsEntity {
    private static final long serialVersionUID = -4956683640037768551L;

    private Long id;
    private FQReporting fqReporting;
    private String fqItemCode;
    private String tuitionAmount;
    private String boardingAmount;
    private String systemAmount;
    private String dioceseAmount;
    private String fqComments;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "FQReporting_Id")
    public FQReporting getFqReporting() {
        return fqReporting;
    }

    public void setFqReporting(FQReporting fqReporting) {
        this.fqReporting = fqReporting;
    }

    public String getFqItemCode() {
        return fqItemCode;
    }

    public void setFqItemCode(String fqItemCode) {
        this.fqItemCode = fqItemCode;
    }

    public String getTuitionAmount() {
        return tuitionAmount;
    }

    public void setTuitionAmount(String tuitionAmount) {
        this.tuitionAmount = tuitionAmount;
    }

    public String getBoardingAmount() {
        return boardingAmount;
    }

    public void setBoardingAmount(String boardingAmount) {
        this.boardingAmount = boardingAmount;
    }

    public String getSystemAmount() {
        return systemAmount;
    }

    public void setSystemAmount(String systemAmount) {
        this.systemAmount = systemAmount;
    }

    public String getDioceseAmount() {
        return dioceseAmount;
    }

    public void setDioceseAmount(String dioceseAmount) {
        this.dioceseAmount = dioceseAmount;
    }

    public String getFqComments() {
        return fqComments;
    }

    public void setFqComments(String fqComments) {
        this.fqComments = fqComments;
    }

}
