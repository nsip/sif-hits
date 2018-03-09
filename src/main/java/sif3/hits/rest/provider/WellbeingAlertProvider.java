package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.WellbeingAlertCollectionType;
import sif.dd.au30.model.WellbeingAlertType;
import sif3.hits.domain.model.WellbeingAlert;
import sif3.hits.service.WellbeingAlertService;

public class WellbeingAlertProvider extends HitsBaseProvider<WellbeingAlertType, WellbeingAlertCollectionType, WellbeingAlert, WellbeingAlertService> {

    protected static final Logger L = LoggerFactory.getLogger(WellbeingAlertProvider.class);

    /**
     * @param providerID
     *            The ID of the provider.
     * @param serviceProperties
     *            values of provider property file.
     */
    public WellbeingAlertProvider() {
        super(WellbeingAlertType.class, "WellbeingAlert", WellbeingAlertCollectionType.class, "WellbeingAlerts", WellbeingAlertService.class);
    }
}
