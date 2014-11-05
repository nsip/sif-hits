package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif3.hits.domain.converter.factory.ObjectFactory;
import sif.dd.au30.model.TimeTableType;
import sif.dd.au30.model.TimeTableType.TimeTableDayList;
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
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(objectFactory.createTimeTableTypeLocalId(source.getLocalId()));
      target.setTitle(source.getTitle());
      target.setDaysPerCycle(getLongValue(source.getDaysPerCycle()));
      target.setPeriodsPerDay(getLongValue(source.getPeriodsPerCycle()));
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setTimeTableDayList(new TimeTableDayList());
      target.getTimeTableDayList().getTimeTableDay()
          .addAll(timeTableDayConverter.toSifModelList(source.getTimeTableDays()));
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
      if (source.getTimeTableDayList() != null) {
        List<TimeTableDay> days = timeTableDayConverter.toHitsModelList(source.getTimeTableDayList().getTimeTableDay());
        target.setTimeTableDays(new HashSet<TimeTableDay>(days));
      }
    }
  }

}
