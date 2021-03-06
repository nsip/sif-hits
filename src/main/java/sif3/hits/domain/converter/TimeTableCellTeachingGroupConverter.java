package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TeachingGroup;

@Component
public class TimeTableCellTeachingGroupConverter extends HitsConverter<TimeTableCellType, TeachingGroup> {

  public TimeTableCellTeachingGroupConverter() {
    super(null, TeachingGroup.class);
  }

  @Override
  public void toSifModel(TeachingGroup source, TimeTableCellType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setTeachingGroupRefId(source.getRefId());
      target.setTeachingGroupLocalId(objectFactory.createTimeTableCellTypeTeachingGroupLocalId(source.getLocalId()));
    }
  }

  @Override
  public void toHitsModel(TimeTableCellType source, TeachingGroup target) {
    if (source != null && target != null) {
      target.setRefId(source.getTeachingGroupRefId());
      target.setLocalId(getJAXBValue(source.getTeachingGroupLocalId()));
    }
  }
}
