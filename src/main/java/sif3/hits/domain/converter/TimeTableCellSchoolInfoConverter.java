package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.SchoolInfo;

@Component
public class TimeTableCellSchoolInfoConverter extends HitsConverter<TimeTableCellType, SchoolInfo> {

  public TimeTableCellSchoolInfoConverter() {
    super(null, SchoolInfo.class);
  }

  @Override
  public void toSifModel(SchoolInfo source, TimeTableCellType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setSchoolInfoRefId(objectFactory.createTimeTableCellTypeSchoolInfoRefId(source.getRefId()));
    }
  }

  @Override
  public void toHitsModel(TimeTableCellType source, SchoolInfo target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getSchoolInfoRefId()));
    }
  }
}
