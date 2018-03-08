package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.WithdrawalType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingResponseSuspensionWithdrawalTime;

@Component
public class WellbeingResponseSuspensionWithdrawalTimeConverter extends HitsConverter<WithdrawalType, WellbeingResponseSuspensionWithdrawalTime> {
    public WellbeingResponseSuspensionWithdrawalTimeConverter() {
        super(WithdrawalType.class, WellbeingResponseSuspensionWithdrawalTime.class);
    }

    @Override
    public void toSifModel(WellbeingResponseSuspensionWithdrawalTime source, WithdrawalType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setWithdrawalDate(getDateValue(source.getWithdrawalDate()));
            target.setWithdrawalStartTime(objectFactory.createWithdrawalTypeWithdrawalStartTime(getTimeValue(source.getWithdrawalStartTime())));
            target.setWithdrawalEndTime(objectFactory.createWithdrawalTypeWithdrawalEndTime(getTimeValue(source.getWithdrawalEndTime())));
            target.setTimeTableSubjectRefId(objectFactory.createWithdrawalTypeTimeTableSubjectRefId(source.getTimeTableSubjectRefId()));
            target.setTimeTableCellRefId(objectFactory.createWithdrawalTypeTimeTableCellRefId(source.getTimeTableCellRefId()));
            target.setScheduledActivityRefId(objectFactory.createWithdrawalTypeScheduledActivityRefId(source.getScheduledActivityRefId()));
        }
    }

    @Override
    public void toHitsModel(WithdrawalType source, WellbeingResponseSuspensionWithdrawalTime target) {
        if (source != null && target != null) {
            target.setWithdrawalDate(getDateValue(source.getWithdrawalDate()));
            target.setWithdrawalStartTime(getTimeValue(getJAXBValue(source.getWithdrawalStartTime())));
            target.setWithdrawalEndTime(getTimeValue(getJAXBValue(source.getWithdrawalEndTime())));
            target.setTimeTableSubjectRefId(getJAXBValue(source.getTimeTableSubjectRefId()));
            target.setTimeTableCellRefId(getJAXBValue(source.getTimeTableCellRefId()));
            target.setScheduledActivityRefId(getJAXBValue(source.getScheduledActivityRefId()));
        }
    }
}
