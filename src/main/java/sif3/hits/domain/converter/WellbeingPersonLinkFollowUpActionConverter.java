package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FollowUpActionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingPersonLinkFollowUpAction;

@Component
public class WellbeingPersonLinkFollowUpActionConverter extends HitsConverter<FollowUpActionType, WellbeingPersonLinkFollowUpAction> {
    public WellbeingPersonLinkFollowUpActionConverter() {
        super(FollowUpActionType.class, WellbeingPersonLinkFollowUpAction.class);
    }

    @Override
    public void toSifModel(WellbeingPersonLinkFollowUpAction source, FollowUpActionType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails(source.getFollowUpDetails()));
            target.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory(source.getFollowUpActionCategory()));
            target.setWellbeingResponseRefId(objectFactory.createFollowUpActionTypeWellbeingResponseRefId(source.getWellbeingResponseRefId()));
        }
    }

    @Override
    public void toHitsModel(FollowUpActionType source, WellbeingPersonLinkFollowUpAction target) {
        if (source != null && target != null) {
            target.setFollowUpDetails(getJAXBValue(source.getFollowUpDetails()));
            target.setFollowUpActionCategory(getJAXBValue(source.getFollowUpActionCategory()));
            target.setWellbeingResponseRefId(getJAXBValue(source.getWellbeingResponseRefId()));
        }
    }
}
