package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.domain.model.TimeTableDay;
import sif3.hits.domain.model.TimeTablePeriod;

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

      Set<TimeTableDay> timeTableDays = new HashSet<TimeTableDay>();
      if (target.getTimeTableDays() != null) {
        timeTableDays = target.getTimeTableDays();
        timeTableDays.clear();
      }
      if (source.getTimeTableDayList() != null && source.getTimeTableDayList().getTimeTableDay() != null) {
        timeTableDays.addAll(timeTableDayConverter.toHitsModelList(source.getTimeTableDayList().getTimeTableDay()));
      }
      for (TimeTableDay timeTableDay : timeTableDays) {
        timeTableDay.setTimeTable(target);
        for (TimeTablePeriod period : timeTableDay.getPeriods()) {
          period.setTimeTable_RefId(target.getRefId());
          period.setDayId(timeTableDay.getDayId());
          period.setTimeTableDay(timeTableDay);
        }
      }
      target.setTimeTableDays(timeTableDays);
    }
  }
}
