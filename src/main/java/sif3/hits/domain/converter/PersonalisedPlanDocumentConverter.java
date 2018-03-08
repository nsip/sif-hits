package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.PersonalisedPlanDocument;
import sif3.hits.utils.UsesConstants;

@Component
public class PersonalisedPlanDocumentConverter extends WellbeingDocumentConverter<PersonalisedPlanDocument> implements UsesConstants {

    public PersonalisedPlanDocumentConverter() {
        super(PersonalisedPlanDocument.class);
    }

}
