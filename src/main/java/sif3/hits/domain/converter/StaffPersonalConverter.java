package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsStaffStatusType;
import sif.dd.au30.model.StaffPersonalType;
import sif.dd.au30.model.StaffPersonalType.MostRecent;
import sif.dd.au30.model.StaffPersonalType.OtherIdList;
import sif.dd.au30.model.StaffPersonalType.OtherIdList.OtherId;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StaffPersonalOtherId;

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
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setStateProvinceId(objectFactory.createStaffPersonalTypeStateProvinceId(source.getStateProvinceId()));
      AUCodeSetsStaffStatusType employmentStatus = getEnumValue(source.getEmploymentStatus(), AUCodeSetsStaffStatusType.class);
      target.setEmploymentStatus(objectFactory.createStaffPersonalTypeEmploymentStatus(employmentStatus));
      target.setPersonInfo(personInfoConverter.toSifModel(source));

      if (StringUtils.isNotBlank(source.getMostRecentSchoolAcaraId()) || StringUtils.isNotBlank(source.getMostRecentSchoolLocalId()) || StringUtils.isNotBlank(source.getMostRecentLocalCampusId())) {
        MostRecent mostRecent = new MostRecent();
        mostRecent.setSchoolACARAId(objectFactory.createStaffPersonalTypeMostRecentSchoolACARAId(source.getMostRecentSchoolAcaraId()));
        mostRecent.setSchoolLocalId(objectFactory.createStaffPersonalTypeMostRecentSchoolLocalId(source.getMostRecentSchoolLocalId()));
        mostRecent.setLocalCampusId(objectFactory.createStaffPersonalTypeMostRecentLocalCampusId(source.getMostRecentLocalCampusId()));
      }

      ArrayList<OtherId> otherIds = new ArrayList<OtherId>();
      if (source.getOtherIds() != null) {
        for (StaffPersonalOtherId staffPersonalOtherId : source.getOtherIds()) {
          OtherId otherId = new OtherId();
          otherId.setType(staffPersonalOtherId.getOtherIdType());
          otherId.setValue(staffPersonalOtherId.getOtherId());
          otherIds.add(otherId);
        }
      }
      OtherIdList otherIdList = new OtherIdList();
      otherIdList.getOtherId().addAll(otherIds);
      target.setOtherIdList(objectFactory.createStaffPersonalTypeOtherIdList(otherIdList));
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

      MostRecent mostRecent = getJAXBValue(source.getMostRecent());
      if (mostRecent != null) {
        target.setMostRecentSchoolAcaraId(getJAXBValue(mostRecent.getSchoolACARAId()));
        target.setMostRecentSchoolLocalId(getJAXBValue(mostRecent.getSchoolLocalId()));
        target.setMostRecentLocalCampusId(getJAXBValue(mostRecent.getLocalCampusId()));
      }

      Set<StaffPersonalOtherId> otherIds = new HashSet<StaffPersonalOtherId>();
      OtherIdList otherIdList = getJAXBValue(source.getOtherIdList());
      if (otherIdList != null && otherIdList.getOtherId() != null) {
        for (OtherId otherId : otherIdList.getOtherId()) {
          StaffPersonalOtherId staffPersonalOtherId = new StaffPersonalOtherId();
          staffPersonalOtherId.setOtherId(otherId.getValue());
          staffPersonalOtherId.setOtherIdType(otherId.getType());
          otherIds.add(staffPersonalOtherId);
        }
      }
      target.setOtherIds(otherIds);
    }
  }
}
