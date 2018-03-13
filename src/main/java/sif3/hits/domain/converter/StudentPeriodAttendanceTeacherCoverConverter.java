package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsTeacherCoverCreditType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverSupervisionType;
import sif.dd.au30.model.TeacherCoverType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PeriodAttendanceTeacher;

@Component
public class StudentPeriodAttendanceTeacherCoverConverter extends HitsConverter<TeacherCoverType, PeriodAttendanceTeacher> {

    public StudentPeriodAttendanceTeacherCoverConverter() {
        super(TeacherCoverType.class, PeriodAttendanceTeacher.class);
    }

    @Override
    public void toSifModel(PeriodAttendanceTeacher source, TeacherCoverType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setStaffPersonalRefId(source.getStaffPersonalRefId());
            target.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(source.getStaffLocalId()));
            target.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getDateValue(source.getStartTime())));
            target.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getDateValue(source.getFinishTime())));
            target.setCredit(objectFactory.createTeacherCoverTypeCredit(getEnumValue(source.getCredit(), AUCodeSetsTeacherCoverCreditType.class)));
            target.setSupervision(objectFactory.createTeacherCoverTypeSupervision(getEnumValue(source.getSupervision(), AUCodeSetsTeacherCoverSupervisionType.class)));
            target.setWeighting(objectFactory.createTeacherCoverTypeWeighting(getBigDecimalValue(source.getWeighting())));
        }
    }

    @Override
    public void toHitsModel(TeacherCoverType source, PeriodAttendanceTeacher target) {
        if (source != null && target != null) {
            target.setStaffPersonalRefId(source.getStaffPersonalRefId());
            target.setStaffLocalId(getJAXBValue(source.getStaffLocalId()));
            target.setStartTime(getDateValue(getJAXBValue(source.getStartTime())));
            target.setFinishTime(getDateValue(getJAXBValue(source.getFinishTime())));
            target.setCredit(getJAXBEnumValue(source.getCredit()));
            target.setSupervision(getJAXBEnumValue(source.getSupervision()));
            target.setWeighting(getBigDecimalValue(getJAXBValue(source.getWeighting())));
        }
    }
}
