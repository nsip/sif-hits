package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_ContextualQuestion")
public class FQContextualQuestion extends HitsEntity {
    private static final long serialVersionUID = 1745573949351458369L;

    private Long id;
    private FQReporting fqReporting;
    private String context;
    private String answer;

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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
