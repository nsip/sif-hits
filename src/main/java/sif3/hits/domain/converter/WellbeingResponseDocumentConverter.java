package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.WellbeingResponseDocument;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingResponseDocumentConverter extends WellbeingDocumentConverter<WellbeingResponseDocument> implements UsesConstants {

    public WellbeingResponseDocumentConverter() {
        super(WellbeingResponseDocument.class);
    }

}
