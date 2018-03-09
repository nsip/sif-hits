package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.MedicationType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingCharacteristicMedication;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingCharacteristicMedicationConverter extends HitsConverter<MedicationType, WellbeingCharacteristicMedication> implements UsesConstants {

    public WellbeingCharacteristicMedicationConverter() {
        super(MedicationType.class, WellbeingCharacteristicMedication.class);
    }

    @Override
    public void toSifModel(WellbeingCharacteristicMedication source, MedicationType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setDosage(objectFactory.createMedicationTypeDosage(source.getDosage()));
            target.setFrequency(objectFactory.createMedicationTypeFrequency(source.getFrequency()));
            target.setAdministrationInformation(objectFactory.createMedicationTypeAdministrationInformation(source.getAdministrationInformation()));
            target.setMethod(objectFactory.createMedicationTypeMethod(source.getMethod()));
            target.setMedicationName(objectFactory.createMedicationTypeMedicationName(source.getMedicationName()));
        }
    }

    @Override
    public void toHitsModel(MedicationType source, WellbeingCharacteristicMedication target) {
        if (source != null && target != null) {
            target.setDosage(getJAXBValue(source.getDosage()));
            target.setFrequency(getJAXBValue(source.getFrequency()));
            target.setAdministrationInformation(getJAXBValue(source.getAdministrationInformation()));
            target.setMethod(getJAXBValue(source.getMethod()));
            target.setMedicationName(getJAXBValue(source.getMedicationName()));
        }
    }

}
