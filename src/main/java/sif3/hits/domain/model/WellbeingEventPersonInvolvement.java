package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingEvent_PersonInvolvement")
public class WellbeingEventPersonInvolvement extends WellbeingPersonInvolvement {
    private static final long serialVersionUID = -3995719462110356215L;

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
