package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsTeacherCoverCreditType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverSupervisionType;
import sif.dd.au30.model.TeacherCoverType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTableCellTeacherCover;

@Component
public class TimeTableCellTeacherCoverConverter extends HitsConverter<TeacherCoverType, TimeTableCellTeacherCover> {

    protected TimeTableCellTeacherCoverConverter() {
        super(TeacherCoverType.class, TimeTableCellTeacherCover.class);
    }

    @Override
    public void toSifModel(TimeTableCellTeacherCover source, TeacherCoverType target) {
        IObjectFactory objectFactory = getObjectFactory();
        target.setStaffPersonalRefId(source.getStaffPersonalRefId());
        target.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(source.getStaffLocalId()));
        target.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getTimeValue(source.getStartTime())));
        target.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getTimeValue(source.getFinishTime())));
        target.setCredit(objectFactory.createTeacherCoverTypeCredit(getEnumValue(source.getCredit(), AUCodeSetsTeacherCoverCreditType.class)));
        target.setSupervision(objectFactory.createTeacherCoverTypeSupervision(getEnumValue(source.getSupervision(), AUCodeSetsTeacherCoverSupervisionType.class)));
        target.setWeighting(objectFactory.createTeacherCoverTypeWeighting(getBigDecimalValue(source.getWeighting())));
    }

    @Override
    public void toHitsModel(TeacherCoverType source, TimeTableCellTeacherCover target) {
        target.setStaffPersonalRefId(source.getStaffPersonalRefId());
        target.setStaffLocalId(getJAXBValue(source.getStaffLocalId()));
        target.setStartTime(getTimeValue(getJAXBValue(source.getStartTime())));
        target.setFinishTime(getTimeValue(getJAXBValue(source.getFinishTime())));
        target.setCredit(getJAXBEnumValue(source.getCredit()));
        target.setSupervision(getJAXBEnumValue(source.getSupervision()));
        target.setWeighting(getBigDecimalValue(getJAXBValue(source.getWeighting())));
    }

}
