package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.WellbeingPersonLinkCollectionType;
import sif.dd.au30.model.WellbeingPersonLinkType;
import sif3.hits.domain.model.WellbeingPersonLink;
import sif3.hits.service.WellbeingPersonLinkService;

public class WellbeingPersonLinkProvider extends HitsBaseProvider<WellbeingPersonLinkType, WellbeingPersonLinkCollectionType, WellbeingPersonLink, WellbeingPersonLinkService> {

    protected static final Logger L = LoggerFactory.getLogger(WellbeingPersonLinkProvider.class);

    /**
     * @param providerID
     *            The ID of the provider.
     * @param serviceProperties
     *            values of provider property file.
     */
    public WellbeingPersonLinkProvider() {
        super(WellbeingPersonLinkType.class, "WellbeingPersonLink", WellbeingPersonLinkCollectionType.class, "WellbeingPersonLinks", WellbeingPersonLinkService.class);
    }
}
