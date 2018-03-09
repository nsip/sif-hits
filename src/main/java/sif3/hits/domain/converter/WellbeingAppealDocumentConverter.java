package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.WellbeingAppealDocument;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingAppealDocumentConverter extends WellbeingDocumentConverter<WellbeingAppealDocument> implements UsesConstants {

    public WellbeingAppealDocumentConverter() {
        super(WellbeingAppealDocument.class);
    }

}
