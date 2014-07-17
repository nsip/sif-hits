package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.model.TimeTable;

@Component
public class TimeTableCellTimeTableConverter extends HitsConverter<TimeTableCellType, TimeTable> {

  @Autowired
  private TimeTableCellSchoolInfoConverter timeTableCellSchoolInfoConverter;
  
  public TimeTableCellTimeTableConverter() {
    super(null, TimeTable.class);
  }

  @Override
  public void toSifModel(TimeTable source, TimeTableCellType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setTimeTableRefId(source.getRefId());
      target.setTimeTableLocalId(objectFactory.createTimeTableCellTypeTimeTableLocalId(source.getLocalId()));
      timeTableCellSchoolInfoConverter.toSifModel(source.getSchoolInfo(), target);
    }
  }

  @Override
  public void toHitsModel(TimeTableCellType source, TimeTable target) {
    if (source != null && target != null) {
      target.setRefId(source.getTimeTableRefId());
      target.setLocalId(getJAXBValue(source.getTimeTableLocalId()));
      target.setSchoolInfo(timeTableCellSchoolInfoConverter.toHitsModel(source));
    }
  }
}
