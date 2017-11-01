package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTableSubject;

@Component
public class TeachingGroupTimeTableSubjectConveter extends HitsConverter<TeachingGroupType, TimeTableSubject> {

  public TeachingGroupTimeTableSubjectConveter() {
    super(null, TimeTableSubject.class);
  }

  @Override
  public void toSifModel(TimeTableSubject source, TeachingGroupType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setTimeTableSubjectRefId(objectFactory.createTeachingGroupTypeTimeTableSubjectRefId(source.getRefId()));
      target.setTimeTableSubjectLocalId(objectFactory.createTeachingGroupTypeTimeTableSubjectLocalId(source.getSubjectLocalId()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupType source, TimeTableSubject target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getTimeTableSubjectRefId()));
      target.setSubjectLocalId(getJAXBValue(source.getTimeTableSubjectLocalId()));
    }
  }
}
