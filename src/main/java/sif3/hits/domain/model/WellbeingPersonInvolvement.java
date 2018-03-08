package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class WellbeingPersonInvolvement extends HitsEntity {
    private static final long serialVersionUID = -3803542778368590981L;

    private Long id;
    private String personRefId;
    private String sifRefObject;
    private String shortName;
    private String howInvolved;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonRefId() {
        return personRefId;
    }

    public void setPersonRefId(String personRefId) {
        this.personRefId = personRefId;
    }

    @Column(name = "PersonRefId_SIF_RefObject")
    public String getSifRefObject() {
        return sifRefObject;
    }

    public void setSifRefObject(String sifRefObject) {
        this.sifRefObject = sifRefObject;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getHowInvolved() {
        return howInvolved;
    }

    public void setHowInvolved(String howInvolved) {
        this.howInvolved = howInvolved;
    }

}
