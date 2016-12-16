package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTablePeriodType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTablePeriod;

@Component
public class TimeTablePeriodConverter extends HitsConverter<TimeTablePeriodType, TimeTablePeriod> {

  public TimeTablePeriodConverter() {
    super(TimeTablePeriodType.class, TimeTablePeriod.class);
  }

  @Override
  public void toSifModel(TimeTablePeriod source, TimeTablePeriodType target) {

    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setPeriodId(source.getPeriodId());
      target.setBellPeriod(objectFactory.createTimeTablePeriodTypeBellPeriod(source.getBellPeriod()));
      target.setPeriodTitle(source.getPeriodTitle());
      target.setStartTime(objectFactory.createTimeTablePeriodTypeStartTime(getTimeValue(source.getStartTime())));
      target.setEndTime(objectFactory.createTimeTablePeriodTypeEndTime(getTimeValue(source.getEndTime())));
    }
  }

  @Override
  public void toHitsModel(TimeTablePeriodType source, TimeTablePeriod target) {

    if (source != null && target != null) {
      target.setPeriodId(source.getPeriodId());
      target.setBellPeriod(getJAXBValue(source.getBellPeriod()));
      target.setPeriodTitle(source.getPeriodTitle());
      target.setStartTime(getDateValue(getJAXBValue(source.getStartTime())));
      target.setEndTime(getDateValue(getJAXBValue(source.getEndTime())));
    }
  }

}
