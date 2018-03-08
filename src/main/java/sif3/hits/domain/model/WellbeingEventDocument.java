package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingEvent_Document")
public class WellbeingEventDocument extends WellbeingDocument {
    private static final long serialVersionUID = 4660697952431926140L;

    private WellbeingEvent wellbeingEvent;

    @ManyToOne
    @JoinColumn(name = "WellbeingEvent_RefId")
    public WellbeingEvent getWellbeingEvent() {
        return wellbeingEvent;
    }

    public void setWellbeingEvent(WellbeingEvent wellbeingEvent) {
        this.wellbeingEvent = wellbeingEvent;
    }

}
