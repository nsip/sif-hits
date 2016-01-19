package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.StaffAssignmentType;
import sif.dd.au30.model.StaffAssignmentType.StaffActivity;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffAssignment;

@Component
public class StaffAssignmentConverter extends HitsConverter<StaffAssignmentType, StaffAssignment> {

  public StaffAssignmentConverter() {
    super(StaffAssignmentType.class, StaffAssignment.class);
  }

  @Override
  public void toSifModel(StaffAssignment source, StaffAssignmentType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setStaffPersonalRefId(source.getStaffPersonalRefId());
      target.setSchoolYear(objectFactory.createStaffAssignmentTypeSchoolYear(getYearValue(source.getSchoolYear())));
      target.setDescription(objectFactory.createStaffAssignmentTypeDescription(source.getDescription()));

      AUCodeSetsYesOrNoCategoryType primaryAssignment = getEnumValue(source.getPrimaryAssignment(), AUCodeSetsYesOrNoCategoryType.class);
      target.setPrimaryAssignment(primaryAssignment);

      target.setJobStartDate(objectFactory.createStaffAssignmentTypeJobStartDate(getDateValue(source.getJobStartDate())));
      target.setJobEndDate(objectFactory.createStaffAssignmentTypeJobEndDate(getDateValue(source.getJobEndDate())));
      target.setJobFunction(objectFactory.createStaffAssignmentTypeJobFunction(source.getJobFunction()));

      StaffActivity staffActivity = new StaffActivity();
      staffActivity.setCode(source.getStaffActivityCode());
      target.setStaffActivity(objectFactory.createStaffAssignmentTypeStaffActivity(staffActivity));
    }
  }

  @Override
  public void toHitsModel(StaffAssignmentType source, StaffAssignment target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setStaffPersonalRefId(source.getStaffPersonalRefId());
      target.setDescription(getJAXBValue(source.getDescription()));
      target.setSchoolYear(getYearValue(getJAXBValue(source.getSchoolYear())));
      target.setPrimaryAssignment(getEnumValue(source.getPrimaryAssignment()));

      target.setJobStartDate(getDateValue(getJAXBValue(source.getJobStartDate())));
      target.setJobEndDate(getDateValue(getJAXBValue(source.getJobEndDate())));
      target.setJobFunction(getJAXBValue(source.getJobFunction()));

      StaffActivity staffActivity = getJAXBValue(source.getStaffActivity());
      if (staffActivity != null) {
        target.setStaffActivityCode(staffActivity.getCode());
      }
    }
  }
}
