package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.WellbeingCharacteristicDocument;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingCharacteristicDocumentConverter extends WellbeingDocumentConverter<WellbeingCharacteristicDocument> implements UsesConstants {

    public WellbeingCharacteristicDocumentConverter() {
        super(WellbeingCharacteristicDocument.class);
    }

}
