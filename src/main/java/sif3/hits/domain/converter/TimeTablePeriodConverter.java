package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.TimeTablePeriod;

@Component
public class TimeTablePeriodConverter
    extends
    HitsConverter<sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod, TimeTablePeriod> {

  public TimeTablePeriodConverter() {
    super(sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod.class,
        TimeTablePeriod.class);
  }

  @Override
  public void toSifModel(TimeTablePeriod source,
      sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod target) {

    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setPeriodId(source.getPeriodId());
      target.setBellPeriod(objectFactory
          .createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod(source
              .getBellPeriod()));
      target.setPeriodTitle(source.getPeriodTitle());
      target
          .setStartTime(objectFactory
              .createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(getTimeValue(source
                  .getStartTime())));
      target.setEndTime(objectFactory
          .createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(getTimeValue(source
              .getEndTime())));
    }
  }

  @Override
  public void toHitsModel(
      sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod source,
      TimeTablePeriod target) {

    if (source != null && target != null) {
      target.setPeriodId(source.getPeriodId());
      target.setBellPeriod(getJAXBValue(source.getBellPeriod()));
      target.setPeriodTitle(source.getPeriodTitle());
      target.setStartTime(getDateValue(getJAXBValue(source.getStartTime())));
      target.setEndTime(getDateValue(getJAXBValue(source.getEndTime())));
    }
  }

}
