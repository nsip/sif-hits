package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.WellbeingResponseCollectionType;
import sif.dd.au30.model.WellbeingResponseType;
import sif3.hits.domain.model.WellbeingResponse;
import sif3.hits.service.WellbeingResponseService;

public class WellbeingResponseProvider extends HitsBaseProvider<WellbeingResponseType, WellbeingResponseCollectionType, WellbeingResponse, WellbeingResponseService> {

    protected static final Logger L = LoggerFactory.getLogger(WellbeingResponseProvider.class);

    /**
     * @param providerID
     *            The ID of the provider.
     * @param serviceProperties
     *            values of provider property file.
     */
    public WellbeingResponseProvider() {
        super(WellbeingResponseType.class, "WellbeingResponse", WellbeingResponseCollectionType.class, "WellbeingResponses", WellbeingResponseService.class);
    }
}
