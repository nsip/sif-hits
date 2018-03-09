package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsWellbeingAlertCategoryType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.WellbeingAlertType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingAlert;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingAlertConverter extends HitsConverter<WellbeingAlertType, WellbeingAlert> implements UsesConstants {

    public WellbeingAlertConverter() {
        super(WellbeingAlertType.class, WellbeingAlert.class);
    }

    @Override
    public void toSifModel(WellbeingAlert source, WellbeingAlertType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(source.getStudentPersonalRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setDate(getDateValue(source.getAlertDate()));
            target.setWellbeingAlertStartDate(getDateValue(source.getStartDate()));
            target.setWellbeingAlertEndDate(objectFactory.createWellbeingAlertTypeWellbeingAlertEndDate(getDateValue(source.getEndDate())));
            target.setWellbeingAlertCategory(
                    objectFactory.createWellbeingAlertTypeWellbeingAlertCategory(getEnumValue(source.getCategory(), AUCodeSetsWellbeingAlertCategoryType.class)));
            target.setWellbeingAlertDescription(objectFactory.createWellbeingAlertTypeWellbeingAlertDescription(source.getDescription()));
            target.setEnrolmentRestricted(
                    objectFactory.createWellbeingAlertTypeEnrolmentRestricted(getEnumValue(source.getEnrolmentRestricted(), AUCodeSetsYesOrNoCategoryType.class)));
            target.setAlertAudience(objectFactory.createWellbeingAlertTypeAlertAudience(source.getAlertAudience()));
            target.setAlertSeverity(objectFactory.createWellbeingAlertTypeAlertSeverity(source.getAlertSeverity()));
            target.setAlertKeyContact(objectFactory.createWellbeingAlertTypeAlertKeyContact(source.getAlertKeyContact()));
        }
    }

    @Override
    public void toHitsModel(WellbeingAlertType source, WellbeingAlert target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(source.getStudentPersonalRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setAlertDate(getDateValue(source.getDate()));
            target.setStartDate(getDateValue(source.getWellbeingAlertStartDate()));
            target.setEndDate(getDateValue(getJAXBValue(source.getWellbeingAlertEndDate())));
            target.setCategory(getJAXBEnumValue(source.getWellbeingAlertCategory()));
            target.setDescription(getJAXBValue(source.getWellbeingAlertDescription()));
            target.setEnrolmentRestricted(getJAXBEnumValue(source.getEnrolmentRestricted()));
            target.setAlertAudience(getJAXBValue(source.getAlertAudience()));
            target.setAlertSeverity(getJAXBValue(source.getAlertSeverity()));
            target.setAlertKeyContact(getJAXBValue(source.getAlertKeyContact()));
        }
    }
}
