package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.StaffPersonal;

@Component
public class TeachingGroupPeriodStaffPersonalConverter extends HitsConverter<TeachingGroupPeriod, StaffPersonal> {

  public TeachingGroupPeriodStaffPersonalConverter() {
    super(TeachingGroupPeriod.class, StaffPersonal.class);
  }

  @Override
  public void toSifModel(StaffPersonal source, TeachingGroupPeriod target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setStaffLocalId(objectFactory
          .createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(source.getLocalId()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupPeriod source, StaffPersonal target) {
    if (source != null && target != null) {
      target.setLocalId(getJAXBValue(source.getStaffLocalId()));
    }
  }

}
