package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.WellbeingEventDocument;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingEventDocumentConverter extends WellbeingDocumentConverter<WellbeingEventDocument> implements UsesConstants {

    public WellbeingEventDocumentConverter() {
        super(WellbeingEventDocument.class);
    }

}
