package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingCharacteristic_Document")
public class WellbeingCharacteristicDocument extends WellbeingDocument {
    private static final long serialVersionUID = 4660697952431926140L;

    private WellbeingCharacteristic wellbeingCharacteristic;

    @ManyToOne
    @JoinColumn(name = "WellbeingCharacteristic_RefId")
    public WellbeingCharacteristic getWellbeingCharacteristic() {
        return wellbeingCharacteristic;
    }

    public void setWellbeingCharacteristic(WellbeingCharacteristic wellbeingCharacteristic) {
        this.wellbeingCharacteristic = wellbeingCharacteristic;
    }

}
