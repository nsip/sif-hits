package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.PersonInvolvementType;
import sif.dd.au30.model.PersonInvolvementType.PersonRefId;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingResponsePersonInvolvement;

@Component
public class WellbeingResponsePersonInvolvementConverter extends HitsConverter<PersonInvolvementType, WellbeingResponsePersonInvolvement> {
    public WellbeingResponsePersonInvolvementConverter() {
        super(PersonInvolvementType.class, WellbeingResponsePersonInvolvement.class);
    }

    @Override
    public void toSifModel(WellbeingResponsePersonInvolvement source, PersonInvolvementType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            if (StringUtils.isNotBlank(source.getPersonRefId()) || StringUtils.isNotBlank(source.getSifRefObject())) {
                PersonRefId personRefId = new PersonRefId();
                personRefId.setValue(source.getPersonRefId());
                personRefId.setSIFRefObject(source.getSifRefObject());
                target.setPersonRefId(objectFactory.createPersonInvolvementTypePersonRefId(personRefId));
            }
            target.setShortName(objectFactory.createPersonInvolvementTypeShortName(source.getShortName()));
            target.setHowInvolved(objectFactory.createPersonInvolvementTypeHowInvolved(source.getHowInvolved()));
        }
    }

    @Override
    public void toHitsModel(PersonInvolvementType source, WellbeingResponsePersonInvolvement target) {
        if (source != null && target != null) {
            target.setShortName(getJAXBValue(source.getShortName()));
            target.setHowInvolved(getJAXBValue(source.getHowInvolved()));
            PersonRefId personRefId = getJAXBValue(source.getPersonRefId());
            if (personRefId != null) {
                target.setPersonRefId(personRefId.getValue());
                target.setSifRefObject(personRefId.getSIFRefObject());
            } else {
                target.setPersonRefId(null);
                target.setSifRefObject(null);
            }
        }
    }
}
