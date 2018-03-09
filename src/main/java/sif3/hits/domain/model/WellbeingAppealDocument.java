package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingAppeal_Document")
public class WellbeingAppealDocument extends WellbeingDocument {
    private static final long serialVersionUID = 4660697952431926140L;

    private WellbeingAppeal wellbeingAppeal;

    @ManyToOne
    @JoinColumn(name = "WellbeingAppeal_RefId")
    public WellbeingAppeal getWellbeingAppeal() {
        return wellbeingAppeal;
    }

    public void setWellbeingAppeal(WellbeingAppeal wellbeingAppeal) {
        this.wellbeingAppeal = wellbeingAppeal;
    }

}
