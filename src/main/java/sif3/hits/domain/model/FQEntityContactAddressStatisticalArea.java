package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQReporting_EntityContact_Address_StatisticalArea")
public class FQEntityContactAddressStatisticalArea extends HitsEntity {
    private static final long serialVersionUID = 5495475119299160335L;

    private Long id;
    private FQEntityContactAddress address;
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

    @ManyToOne
    @JoinColumn(name = "FQReporting_EntityContact_Address_Id", referencedColumnName = "Id")
    public FQEntityContactAddress getAddress() {
        return address;
    }

    public void setAddress(FQEntityContactAddress address) {
        this.address = address;
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
