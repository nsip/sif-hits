package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.WellbeingAppealCollectionType;
import sif.dd.au30.model.WellbeingAppealType;
import sif3.hits.domain.model.WellbeingAppeal;
import sif3.hits.service.WellbeingAppealService;

public class WellbeingAppealProvider extends HitsBaseProvider<WellbeingAppealType, WellbeingAppealCollectionType, WellbeingAppeal, WellbeingAppealService> {

    protected static final Logger L = LoggerFactory.getLogger(WellbeingAppealProvider.class);

    /**
     * @param providerID
     *            The ID of the provider.
     * @param serviceProperties
     *            values of provider property file.
     */
    public WellbeingAppealProvider() {
        super(WellbeingAppealType.class, "WellbeingAppeal", WellbeingAppealCollectionType.class, "WellbeingAppeals", WellbeingAppealService.class);
    }
}
