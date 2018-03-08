package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.WellbeingEventCollectionType;
import sif.dd.au30.model.WellbeingEventType;
import sif3.hits.domain.model.WellbeingEvent;
import sif3.hits.service.WellbeingEventService;

public class WellbeingEventProvider extends HitsBaseProvider<WellbeingEventType, WellbeingEventCollectionType, WellbeingEvent, WellbeingEventService> {

    protected static final Logger L = LoggerFactory.getLogger(WellbeingEventProvider.class);

    /**
     * @param providerID
     *            The ID of the provider.
     * @param serviceProperties
     *            values of provider property file.
     */
    public WellbeingEventProvider() {
        super(WellbeingEventType.class, "WellbeingEvent", WellbeingEventCollectionType.class, "WellbeingEvents", WellbeingEventService.class);
    }
}
