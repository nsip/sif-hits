package sif3.hits.domain.converter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableDayType;
import sif.dd.au30.model.TimeTableType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.domain.model.TimeTableDay;

@Component
public class TimeTableConverter extends HitsConverter<TimeTableType, TimeTable> {

  @Autowired
  private TimeTableDayConverter timeTableDayConverter;

  @Autowired
  private TimeTableSchoolInfoConverter timeTableSchoolInfoConverter;

  public TimeTableConverter() {
    super(TimeTableType.class, TimeTable.class);
  }

  @Override
  public void toSifModel(TimeTable source, TimeTableType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(objectFactory.createTimeTableTypeLocalId(source.getLocalId()));
      target.setTitle(source.getTitle());
      target.setDaysPerCycle(getLongValue(source.getDaysPerCycle()));
      target.setPeriodsPerDay(getLongValue(source.getPeriodsPerCycle()));
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setTimeTableCreationDate(objectFactory.createTimeTableTypeTimeTableCreationDate(getDateValue(source.getTimeTableCreationDate())));
      target.setStartDate(objectFactory.createTimeTableTypeStartDate(getDateValue(source.getStartDate())));
      target.setEndDate(objectFactory.createTimeTableTypeEndDate(getDateValue(source.getEndDate())));
      target.setTimeTableDayList(objectFactory.createTimeTableDayListType());
      if (source.getTimeTableDays() != null && !source.getTimeTableDays().isEmpty()) {
        target.getTimeTableDayList().getTimeTableDay().addAll(timeTableDayConverter.toSifModelList(source.getTimeTableDays()));
      }
      timeTableSchoolInfoConverter.toSifModel(source.getSchoolInfo(), target);
    }
  }

  @Override
  public void toHitsModel(TimeTableType source, TimeTable target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setLocalId(getJAXBValue(source.getLocalId()));
      target.setTitle(source.getTitle());
      target.setDaysPerCycle(getLongValue(source.getDaysPerCycle()));
      target.setPeriodsPerCycle(getLongValue(source.getPeriodsPerDay()));
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setSchoolInfo(timeTableSchoolInfoConverter.toHitsModel(source));
      target.setTimeTableCreationDate(getDateValue(getJAXBValue(source.getTimeTableCreationDate())));
      target.setStartDate(getDateValue(getJAXBValue(source.getStartDate())));
      target.setEndDate(getDateValue(getJAXBValue(source.getEndDate())));

      if (target.getTimeTableDays() == null) {
        Set<TimeTableDay> timeTableDays = new HashSet<TimeTableDay>();
        if (source.getTimeTableDayList() != null && source.getTimeTableDayList().getTimeTableDay() != null) {
          timeTableDays.addAll(timeTableDayConverter.toHitsModelList(source.getTimeTableDayList().getTimeTableDay()));
        }
        for (TimeTableDay timeTableDay : timeTableDays) {
          timeTableDay.setTimeTable(target);
        }
        target.setTimeTableDays(timeTableDays);
      } else {
        mergeTimeTableDays(source, target);
      }
    }
  }

  /**
   * If we could remove the composite key, this would not be neccessary.
   * 
   * @param source
   * @param target
   */
  private void mergeTimeTableDays(TimeTableType source, TimeTable target) {
    HashMap<String, TimeTableDay> currentDays = new HashMap<String, TimeTableDay>();
    for (TimeTableDay timeTableDay : target.getTimeTableDays()) {
      currentDays.put(timeTableDay.getDayId(), timeTableDay);
    }
    target.getTimeTableDays().clear();
    if (source.getTimeTableDayList() != null && source.getTimeTableDayList().getTimeTableDay() != null) {
      for (TimeTableDayType sourceTimeTableDay : source.getTimeTableDayList().getTimeTableDay()) {
        TimeTableDay targetTimeTableDay = currentDays.get(sourceTimeTableDay.getDayId());
        if (targetTimeTableDay == null) {
          targetTimeTableDay = new TimeTableDay();
        }
        timeTableDayConverter.toHitsModel(sourceTimeTableDay, targetTimeTableDay);
        target.getTimeTableDays().add(targetTimeTableDay);
      }
    }
  }
}
