package sif3.hits.domain.converter;

import sif.dd.au30.model.TimeTableSubjectType;
import sif3.hits.domain.model.TimeTableSubject;

public class TimeTableSubjectConverter extends HitsConverter<TimeTableSubjectType, TimeTableSubject> {

  // TODO: Implementation

  public TimeTableSubjectConverter() {
    super(TimeTableSubjectType.class, TimeTableSubject.class);
  }

  @Override
  public void toSifModel(TimeTableSubject source, TimeTableSubjectType target) {

  }

  @Override
  public void toHitsModel(TimeTableSubjectType source, TimeTableSubject target) {

  }
}
