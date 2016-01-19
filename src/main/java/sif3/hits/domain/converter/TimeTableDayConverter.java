package sif3.hits.domain.converter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList;
import sif3.hits.domain.model.TimeTableDay;
import sif3.hits.domain.model.TimeTablePeriod;

@Component
public class TimeTableDayConverter extends HitsConverter<sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay, TimeTableDay> {

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
      if (target.getPeriods() == null) {
        Set<TimeTablePeriod> timeTablePeriods = new HashSet<TimeTablePeriod>();
        if (source.getTimeTablePeriodList() != null && source.getTimeTablePeriodList().getTimeTablePeriod() != null) {
          timeTablePeriods.addAll(timeTablePeriodConverter.toHitsModelList(source.getTimeTablePeriodList().getTimeTablePeriod()));
        }
        for (TimeTablePeriod timeTablePeriod : timeTablePeriods) {
          timeTablePeriod.setTimeTableDay(target);
        }
        target.setPeriods(timeTablePeriods);
      } else {
        mergeTimeTablePeriods(source, target);
      }
    }
  }

  private void mergeTimeTablePeriods(sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay source, TimeTableDay target) {
    HashMap<String, TimeTablePeriod> currentPeriods = new HashMap<String, TimeTablePeriod>();
    for (TimeTablePeriod timeTablePeriod : target.getPeriods()) {
      currentPeriods.put(timeTablePeriod.getPeriodId(), timeTablePeriod);
    }
    target.getPeriods().clear();
    if (source.getTimeTablePeriodList() != null && source.getTimeTablePeriodList().getTimeTablePeriod() != null) {
      for (sif.dd.au30.model.TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod sourceTimeTablePeriod : source.getTimeTablePeriodList().getTimeTablePeriod()) {
        TimeTablePeriod targetTimeTablePeriod = currentPeriods.get(sourceTimeTablePeriod.getPeriodId());
        if (targetTimeTablePeriod == null) {
          targetTimeTablePeriod = new TimeTablePeriod();
        }
        timeTablePeriodConverter.toHitsModel(sourceTimeTablePeriod, targetTimeTablePeriod);
        target.getPeriods().add(targetTimeTablePeriod);
      }
    }    
  }
  
  
}
