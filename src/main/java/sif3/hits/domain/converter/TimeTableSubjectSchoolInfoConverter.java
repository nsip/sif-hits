package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableSubjectType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.SchoolInfo;

@Component
public class TimeTableSubjectSchoolInfoConverter extends HitsConverter<TimeTableSubjectType, SchoolInfo> {

  public TimeTableSubjectSchoolInfoConverter() {
    super(null, SchoolInfo.class);
  }

  @Override
  public void toSifModel(SchoolInfo source, TimeTableSubjectType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setSchoolInfoRefId(objectFactory.createTeachingGroupTypeSchoolInfoRefId(source.getRefId()));
      target.setSchoolLocalId(objectFactory.createTeachingGroupTypeSchoolLocalId(source.getLocalId()));
    }
  }

  @Override
  public void toHitsModel(TimeTableSubjectType source, SchoolInfo target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getSchoolInfoRefId()));
      target.setLocalId(getJAXBValue(source.getSchoolLocalId()));
    }
  }
}
