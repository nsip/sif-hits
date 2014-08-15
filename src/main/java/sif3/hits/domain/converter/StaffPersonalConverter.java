package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsStaffStatusType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StaffPersonalType;
import sif3.hits.domain.model.StaffPersonal;

@Component
public class StaffPersonalConverter extends HitsConverter<StaffPersonalType, StaffPersonal> {

  public StaffPersonalConverter() {
    super(StaffPersonalType.class, StaffPersonal.class);
  }

  @Autowired
  private PersonInfoConverter personInfoConverter;

  @Override
  public void toSifModel(StaffPersonal source, StaffPersonalType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setStateProvinceId(objectFactory.createStaffPersonalTypeStateProvinceId(source.getStateProvinceId()));
      AUCodeSetsStaffStatusType employmentStatus = getEnumValue(source.getEmploymentStatus(), AUCodeSetsStaffStatusType.class);
      target.setEmploymentStatus(objectFactory.createStaffPersonalTypeEmploymentStatus(employmentStatus));
      
      target.setPersonInfo(personInfoConverter.toSifModel(source));
    }
  }

  @Override
  public void toHitsModel(StaffPersonalType source, StaffPersonal target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
      target.setEmploymentStatus(getJAXBEnumValue(source.getEmploymentStatus()));
      personInfoConverter.toHitsModel(source.getPersonInfo(), target);
    }
  }
}
