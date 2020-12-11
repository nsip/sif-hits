package sif3.hits.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseAddressStatisticalArea extends HitsEntity {
    private static final long serialVersionUID = 5495475119299160335L;

    private Long id;
    private String spatialUnitType;
    private String statisticalArea;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpatialUnitType() {
        return spatialUnitType;
    }

    public void setSpatialUnitType(String spatialUnitType) {
        this.spatialUnitType = spatialUnitType;
    }

    public String getStatisticalArea() {
        return statisticalArea;
    }

    public void setStatisticalArea(String statisticalArea) {
        this.statisticalArea = statisticalArea;
    }
}
