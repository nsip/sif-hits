package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TeachingGroupPeriodType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffPersonal;

@Component
public class TeachingGroupPeriodStaffPersonalConverter extends HitsConverter<TeachingGroupPeriodType, StaffPersonal> {

  public TeachingGroupPeriodStaffPersonalConverter() {
    super(TeachingGroupPeriodType.class, StaffPersonal.class);
  }

  @Override
  public void toSifModel(StaffPersonal source, TeachingGroupPeriodType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setStaffLocalId(objectFactory.createTeachingGroupPeriodTypeStaffLocalId(source.getLocalId()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupPeriodType source, StaffPersonal target) {
    if (source != null && target != null) {
      target.setLocalId(getJAXBValue(source.getStaffLocalId()));
    }
  }

}
