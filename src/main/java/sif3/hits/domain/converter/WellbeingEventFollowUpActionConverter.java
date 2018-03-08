package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FollowUpActionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingEventFollowUpAction;

@Component
public class WellbeingEventFollowUpActionConverter extends HitsConverter<FollowUpActionType, WellbeingEventFollowUpAction> {
    public WellbeingEventFollowUpActionConverter() {
        super(FollowUpActionType.class, WellbeingEventFollowUpAction.class);
    }

    @Override
    public void toSifModel(WellbeingEventFollowUpAction source, FollowUpActionType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails(source.getFollowUpDetails()));
            target.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory(source.getFollowUpActionCategory()));
            target.setWellbeingResponseRefId(objectFactory.createFollowUpActionTypeWellbeingResponseRefId(source.getWellbeingResponseRefId()));
        }
    }

    @Override
    public void toHitsModel(FollowUpActionType source, WellbeingEventFollowUpAction target) {
        if (source != null && target != null) {
            target.setFollowUpDetails(getJAXBValue(source.getFollowUpDetails()));
            target.setFollowUpActionCategory(getJAXBValue(source.getFollowUpActionCategory()));
            target.setWellbeingResponseRefId(getJAXBValue(source.getWellbeingResponseRefId()));
        }
    }
}
