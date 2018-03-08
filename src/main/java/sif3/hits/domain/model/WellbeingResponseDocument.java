package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingResponse_Document")
public class WellbeingResponseDocument extends WellbeingDocument {
    private static final long serialVersionUID = -3803542778368590981L;

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
