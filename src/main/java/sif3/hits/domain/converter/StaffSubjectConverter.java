package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.StaffSubjectType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffSubject;

@Component
public class StaffSubjectConverter extends HitsConverter<StaffSubjectType, StaffSubject> {

    public StaffSubjectConverter() {
        super(StaffSubjectType.class, StaffSubject.class);
    }

    @Override
    public void toSifModel(StaffSubject source, StaffSubjectType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setPreferenceNumber(getLongValue(source.getPreferenceNumber()));
            target.setSubjectLocalId(objectFactory.createStaffSubjectTypeSubjectLocalId(source.getSubjectLocalId()));
            target.setTimeTableSubjectRefId(objectFactory.createStaffSubjectTypeTimeTableSubjectRefId(source.getTimeTableSubjectRefId()));
        }
    }

    @Override
    public void toHitsModel(StaffSubjectType source, StaffSubject target) {
        if (source != null && target != null) {
            target.setPreferenceNumber(getLongValue(source.getPreferenceNumber()));
            target.setSubjectLocalId(getJAXBValue(source.getSubjectLocalId()));
            target.setTimeTableSubjectRefId(getJAXBValue(source.getTimeTableSubjectRefId()));
        }
    }
}
