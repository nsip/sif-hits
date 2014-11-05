package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.converter.factory.ObjectFactory;
import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.model.StaffPersonal;

@Component
public class TimeTableCellStaffPersonalConverter extends HitsConverter<TimeTableCellType, StaffPersonal> {

  public TimeTableCellStaffPersonalConverter() {
    super(null, StaffPersonal.class);
  }

  @Override
  public void toSifModel(StaffPersonal source, TimeTableCellType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setStaffPersonalRefId(objectFactory.createTimeTableCellTypeStaffPersonalRefId(source.getRefId()));
      target.setStaffLocalId(objectFactory.createTimeTableCellTypeStaffLocalId(source.getLocalId()));
    }
  }

  @Override
  public void toHitsModel(TimeTableCellType source, StaffPersonal target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getStaffPersonalRefId()));
      target.setLocalId(getJAXBValue(source.getStaffLocalId()));
    }
  }
}
