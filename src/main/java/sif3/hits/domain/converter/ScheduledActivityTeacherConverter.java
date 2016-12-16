package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsTeacherCoverCreditType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverSupervisionType;
import sif.dd.au30.model.TeacherCoverType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.ScheduledActivityTeacher;

@Component
public class ScheduledActivityTeacherConverter extends HitsConverter<TeacherCoverType, ScheduledActivityTeacher> {

  public ScheduledActivityTeacherConverter() {
    super(TeacherCoverType.class, ScheduledActivityTeacher.class);
  }

  @Override
  public void toSifModel(ScheduledActivityTeacher source, TeacherCoverType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setStaffPersonalRefId(source.getStaffPersonalRefId());
      target.setStaffLocalId(objectFactory.createTeacherCoverTypeStaffLocalId(source.getTeacherLocalId()));
      target.setStartTime(objectFactory.createTeacherCoverTypeStartTime(getTimeValue(source.getStartTime())));
      target.setFinishTime(objectFactory.createTeacherCoverTypeFinishTime(getTimeValue(source.getFinishTime())));
      target.setCredit(objectFactory.createTeacherCoverTypeCredit(getEnumValue(source.getCredit(), AUCodeSetsTeacherCoverCreditType.class)));
      target.setSupervision(objectFactory.createTeacherCoverTypeSupervision(getEnumValue(source.getSupervision(), AUCodeSetsTeacherCoverSupervisionType.class)));
      target.setWeighting(objectFactory.createTeacherCoverTypeWeighting(getBigDecimalValue(source.getWeighting())));
    }
  }

  @Override
  public void toHitsModel(TeacherCoverType source, ScheduledActivityTeacher target) {
    if (source != null && target != null) {
      target.setStaffPersonalRefId(source.getStaffPersonalRefId());
      target.setTeacherLocalId(getJAXBValue(source.getStaffLocalId()));
      target.setStartTime(getTimeValue(getJAXBValue(source.getStartTime())));
      target.setFinishTime(getTimeValue(getJAXBValue(source.getFinishTime())));
      target.setCredit(getJAXBEnumValue(source.getCredit()));
      target.setSupervision(getJAXBEnumValue(source.getSupervision()));
      target.setWeighting(getBigDecimalValue(getJAXBValue(source.getWeighting())));
    }
  }
}
