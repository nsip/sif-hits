package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingEvent_Subcategory")
public class WellbeingEventSubcategory extends HitsEntity {
    private static final long serialVersionUID = 4222165917807866148L;

    private Long id;
    private WellbeingEventCategory wellbeingEventCategory;
    private String wellbeingEventRefId;
    private String eventCategory;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "WellbeingEvent_CategoryId")
    public WellbeingEventCategory getWellbeingEventCategory() {
        return wellbeingEventCategory;
    }

    public void setWellbeingEventCategory(WellbeingEventCategory wellbeingEventCategory) {
        this.wellbeingEventCategory = wellbeingEventCategory;
    }

    @Column(name = "WellbeingEvent_RefId")
    public String getWellbeingEventRefId() {
        return wellbeingEventRefId;
    }

    public void setWellbeingEventRefId(String wellbeingEventRefId) {
        this.wellbeingEventRefId = wellbeingEventRefId;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }
}
