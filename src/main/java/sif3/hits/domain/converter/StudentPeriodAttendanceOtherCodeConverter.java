package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif3.hits.domain.model.PeriodAttendanceOtherCode;

@Component
public class StudentPeriodAttendanceOtherCodeConverter extends HitsConverter<OtherCode, PeriodAttendanceOtherCode> {

    public StudentPeriodAttendanceOtherCodeConverter() {
        super(OtherCode.class, PeriodAttendanceOtherCode.class);
    }

    @Override
    public void toSifModel(PeriodAttendanceOtherCode source, OtherCode target) {
        if (source != null && target != null) {
            target.setValue(source.getOtherCode());
            target.setCodeset(source.getCodeset());
        }
    }

    @Override
    public void toHitsModel(OtherCode source, PeriodAttendanceOtherCode target) {
        if (source != null && target != null) {
            target.setOtherCode(source.getValue());
            target.setCodeset(source.getCodeset());
        }
    }
}
