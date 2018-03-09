package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingCharacteristic_Medication")
public class WellbeingCharacteristicMedication extends HitsEntity {
    private static final long serialVersionUID = -4331454900725376324L;

    private Long id;
    private WellbeingCharacteristic wellbeingCharacteristic;
    private String medicationName;
    private String dosage;
    private String frequency;
    private String administrationInformation;
    private String method;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "WellbeingCharacteristic_RefId")
    public WellbeingCharacteristic getWellbeingCharacteristic() {
        return wellbeingCharacteristic;
    }

    public void setWellbeingCharacteristic(WellbeingCharacteristic wellbeingCharacteristic) {
        this.wellbeingCharacteristic = wellbeingCharacteristic;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAdministrationInformation() {
        return administrationInformation;
    }

    public void setAdministrationInformation(String administrationInformation) {
        this.administrationInformation = administrationInformation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
