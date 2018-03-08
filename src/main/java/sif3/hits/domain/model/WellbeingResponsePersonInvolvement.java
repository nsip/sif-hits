package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingResponse_PersonInvolvement")
public class WellbeingResponsePersonInvolvement extends HitsEntity {
    private static final long serialVersionUID = -3803542778368590981L;

    private Long id;
    private WellbeingResponse wellbeingResponse;
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

    @ManyToOne
    @JoinColumn(name = "WellbeingResponse_RefId")
    public WellbeingResponse getWellbeingResponse() {
        return wellbeingResponse;
    }

    public void setWellbeingResponse(WellbeingResponse wellbeingResponse) {
        this.wellbeingResponse = wellbeingResponse;
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
