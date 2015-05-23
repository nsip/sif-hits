package sif3.hits.domain.converter;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList;
import sif3.hits.domain.model.TimeTableDay;
import sif3.hits.domain.model.TimeTablePeriod;

@Component
public class TimeTableDayConverter extends
    HitsConverter<sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay, TimeTableDay> {

  @Autowired
  private TimeTablePeriodConverter timeTablePeriodConverter;

  public TimeTableDayConverter() {
    super(sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.class, TimeTableDay.class);
  }

  @Override
  public void toSifModel(TimeTableDay source, sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay target) {
    if (source != null && target != null) {
      target.setDayId(source.getDayId());
      target.setDayTitle(source.getDayTitle());
      
      if (source.getPeriods() != null && !source.getPeriods().isEmpty()) {
        TimeTablePeriodList timeTablePeriodList = new TimeTablePeriodList();
        timeTablePeriodList.getTimeTablePeriod().addAll(timeTablePeriodConverter.toSifModelList(source.getPeriods()));
        target.setTimeTablePeriodList(timeTablePeriodList);
      }
    }
  }

  @Override
  public void toHitsModel(sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay source, TimeTableDay target) {
    if (source != null && target != null) {
      target.setDayId(source.getDayId());
      target.setDayTitle(source.getDayTitle());
      target.setPeriods(new HashSet<TimeTablePeriod>());
      if (source.getTimeTablePeriodList() != null) {
        target.getPeriods().addAll(
            timeTablePeriodConverter.toHitsModelList(source.getTimeTablePeriodList().getTimeTablePeriod()));
      }
    }
  }
}
