package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTableSubject;

@Component
public class TimeTableCellTimeTableSubjectConverter extends HitsConverter<TimeTableCellType, TimeTableSubject> {

  public TimeTableCellTimeTableSubjectConverter() {
    super(null, TimeTableSubject.class);
  }

  @Override
  public void toSifModel(TimeTableSubject source, TimeTableCellType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setTimeTableSubjectRefId(source.getRefId());
      target.setSubjectLocalId(objectFactory.createTimeTableCellTypeSubjectLocalId(source.getSubjectLocalId()));
    }
  }

  @Override
  public void toHitsModel(TimeTableCellType source, TimeTableSubject target) {
    if (source != null && target != null) {
      target.setRefId(source.getTimeTableSubjectRefId());
      target.setSubjectLocalId(getJAXBValue(source.getSubjectLocalId()));
    }
  }
}
