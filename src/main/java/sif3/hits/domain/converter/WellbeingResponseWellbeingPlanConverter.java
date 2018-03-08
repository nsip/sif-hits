package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.WellbeingPlanType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingResponsePlanRequired;

@Component
public class WellbeingResponseWellbeingPlanConverter extends HitsConverter<WellbeingPlanType, WellbeingResponsePlanRequired> {
    public WellbeingResponseWellbeingPlanConverter() {
        super(WellbeingPlanType.class, WellbeingResponsePlanRequired.class);
    }

    @Override
    public void toSifModel(WellbeingResponsePlanRequired source, WellbeingPlanType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setPersonalisedPlanRefId(objectFactory.createWellbeingPlanTypePersonalisedPlanRefId(source.getPersonalisedPlanRefId()));
            target.setPlanNotes(objectFactory.createPersonalisedPlanTypePersonalisedPlanNotes(source.getPlanNotes()));
        }
    }

    @Override
    public void toHitsModel(WellbeingPlanType source, WellbeingResponsePlanRequired target) {
        if (source != null && target != null) {
            target.setPersonalisedPlanRefId(getJAXBValue(source.getPersonalisedPlanRefId()));
            target.setPlanNotes(getJAXBValue(source.getPlanNotes()));
        }
    }
}
