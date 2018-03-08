package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.WellbeingEventPersonInvolvement;

@Component
public class WellbeingEventPersonInvolvementConverter extends WellbeingPersonInvolvementConverter<WellbeingEventPersonInvolvement> {
    public WellbeingEventPersonInvolvementConverter() {
        super(WellbeingEventPersonInvolvement.class);
    }
}
