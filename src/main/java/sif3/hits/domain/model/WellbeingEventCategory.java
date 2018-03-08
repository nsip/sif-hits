package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "WellbeingEvent_Category")
public class WellbeingEventCategory {

    private Long id;
    private WellbeingEvent wellbeingEvent;
    private String eventCategory;
    private List<WellbeingEventSubcategory> subcategories;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "WellbeingEvent_RefId")
    public WellbeingEvent getWellbeingEvent() {
        return wellbeingEvent;
    }

    public void setWellbeingEvent(WellbeingEvent wellbeingEvent) {
        this.wellbeingEvent = wellbeingEvent;
    }

    @Transient
    public void updateWellbeingEvent(WellbeingEvent wellbeingEvent) {
        this.wellbeingEvent = wellbeingEvent;
        if (subcategories != null && wellbeingEvent != null) {
            for (WellbeingEventSubcategory subcategory : subcategories) {
                subcategory.setWellbeingEventRefId(wellbeingEvent.getRefId());
            }
        }
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingEventCategory")
    public List<WellbeingEventSubcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<WellbeingEventSubcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
