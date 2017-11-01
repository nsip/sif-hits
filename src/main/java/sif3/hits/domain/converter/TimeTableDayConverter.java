package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableDayType;
import sif.dd.au30.model.TimeTablePeriodListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTableDay;
import sif3.hits.domain.model.TimeTablePeriod;

@Component
public class TimeTableDayConverter extends HitsConverter<TimeTableDayType, TimeTableDay> {

  @Autowired
  private TimeTablePeriodConverter timeTablePeriodConverter;

  public TimeTableDayConverter() {
    super(TimeTableDayType.class, TimeTableDay.class);
  }

  @Override
  public void toSifModel(TimeTableDay source, TimeTableDayType target) {
    IObjectFactory objectFactory = getObjectFactory();

    if (source != null && target != null) {
      target.setDayId(source.getDayId());
      target.setDayTitle(source.getDayTitle());

      if (source.getPeriods() != null && !source.getPeriods().isEmpty()) {
        TimeTablePeriodListType timeTablePeriodList = objectFactory.createTimeTablePeriodListType();
        timeTablePeriodList.getTimeTablePeriod().addAll(timeTablePeriodConverter.toSifModelList(source.getPeriods()));
        target.setTimeTablePeriodList(timeTablePeriodList);
      }
    }
  }

  @Override
  public void toHitsModel(TimeTableDayType source, TimeTableDay target) {
    if (source != null && target != null) {
      target.setDayId(source.getDayId());
      target.setDayTitle(source.getDayTitle());
      Set<TimeTablePeriod> timeTablePeriods = new HashSet<TimeTablePeriod>();
      if (target.getPeriods() != null) {
        timeTablePeriods = target.getPeriods();
        timeTablePeriods.clear();
      } 
      if (source.getTimeTablePeriodList() != null && source.getTimeTablePeriodList().getTimeTablePeriod() != null) {
        timeTablePeriods.addAll(timeTablePeriodConverter.toHitsModelList(source.getTimeTablePeriodList().getTimeTablePeriod()));
      }
      target.setPeriods(timeTablePeriods);
    }
  }
}
