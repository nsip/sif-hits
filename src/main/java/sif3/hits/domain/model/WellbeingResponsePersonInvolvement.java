package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingResponse_PersonInvolvement")
public class WellbeingResponsePersonInvolvement extends WellbeingPersonInvolvement {
    private static final long serialVersionUID = 7508062042466641423L;

    private WellbeingResponse wellbeingResponse;

    @ManyToOne
    @JoinColumn(name = "WellbeingResponse_RefId")
    public WellbeingResponse getWellbeingResponse() {
        return wellbeingResponse;
    }

    public void setWellbeingResponse(WellbeingResponse wellbeingResponse) {
        this.wellbeingResponse = wellbeingResponse;
    }

}
