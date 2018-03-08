package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.WellbeingResponsePersonInvolvement;

@Component
public class WellbeingResponsePersonInvolvementConverter extends WellbeingPersonInvolvementConverter<WellbeingResponsePersonInvolvement> {
    public WellbeingResponsePersonInvolvementConverter() {
        super(WellbeingResponsePersonInvolvement.class);
    }
}
