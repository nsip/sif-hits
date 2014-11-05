package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.converter.factory.ObjectFactory;
import sif.dd.au30.model.TimeTableType;
import sif3.hits.domain.model.SchoolInfo;

@Component
public class TimeTableSchoolInfoConverter extends HitsConverter<TimeTableType, SchoolInfo> {

  public TimeTableSchoolInfoConverter() {
    super(null, SchoolInfo.class);
  }

  @Override
  public void toSifModel(SchoolInfo source, TimeTableType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setSchoolInfoRefId(objectFactory.createTimeTableTypeSchoolInfoRefId(source.getRefId()));
      target.setSchoolLocalId(objectFactory.createTimeTableTypeSchoolLocalId(source.getLocalId()));
      target.setSchoolName(objectFactory.createTimeTableTypeSchoolName(source.getSchoolName()));
    }
  }

  @Override
  public void toHitsModel(TimeTableType source, SchoolInfo target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getSchoolInfoRefId()));
      target.setLocalId(getJAXBValue(source.getSchoolLocalId()));
      target.setSchoolName(getJAXBValue(source.getSchoolName()));
    }
  }
}
