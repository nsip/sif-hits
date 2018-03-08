package sif3.hits.domain.converter;

import sif.dd.au30.model.WellbeingDocumentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingDocument;
import sif3.hits.utils.UsesConstants;

public class WellbeingDocumentConverter<T extends WellbeingDocument> extends HitsConverter<WellbeingDocumentType, T> implements UsesConstants {

    public WellbeingDocumentConverter(Class<T> clazz) {
        super(WellbeingDocumentType.class, clazz);
    }

    @Override
    public void toSifModel(T source, WellbeingDocumentType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setLocation(source.getLocation());
            target.setSensitivity(objectFactory.createWellbeingDocumentTypeSensitivity(source.getSensitivity()));
            target.setLocation(source.getLocation());
            target.setURL(objectFactory.createWellbeingDocumentTypeURL(source.getURL()));
            target.setDocumentType(objectFactory.createWellbeingDocumentTypeDocumentType(source.getDocumentType()));
            target.setDocumentReviewDate(objectFactory.createWellbeingDocumentTypeDocumentReviewDate(getDateValue(source.getDocumentReviewDate())));
            target.setDocumentDescription(objectFactory.createWellbeingDocumentTypeDocumentDescription(source.getDocumentDescription()));
        }
    }

    @Override
    public void toHitsModel(WellbeingDocumentType source, T target) {
        if (source != null && target != null) {
            target.setLocation(source.getLocation());
            target.setSensitivity(getJAXBValue(source.getSensitivity()));
            target.setLocation(source.getLocation());
            target.setURL(getJAXBValue(source.getURL()));
            target.setDocumentType(getJAXBValue(source.getDocumentType()));
            target.setDocumentReviewDate(getDateValue(getJAXBValue(source.getDocumentReviewDate())));
            target.setDocumentDescription(getJAXBValue(source.getDocumentDescription()));
        }
    }
}
