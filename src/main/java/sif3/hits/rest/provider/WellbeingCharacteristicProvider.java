package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.WellbeingCharacteristicCollectionType;
import sif.dd.au30.model.WellbeingCharacteristicType;
import sif3.hits.domain.model.WellbeingCharacteristic;
import sif3.hits.service.WellbeingCharacteristicService;

public class WellbeingCharacteristicProvider extends HitsBaseProvider<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType, WellbeingCharacteristic, WellbeingCharacteristicService> {

    protected static final Logger L = LoggerFactory.getLogger(WellbeingCharacteristicProvider.class);

    /**
     * @param providerID
     *            The ID of the provider.
     * @param serviceProperties
     *            values of provider property file.
     */
    public WellbeingCharacteristicProvider() {
        super(WellbeingCharacteristicType.class, "WellbeingCharacteristic", WellbeingCharacteristicCollectionType.class, "WellbeingCharacteristics", WellbeingCharacteristicService.class);
    }
}
