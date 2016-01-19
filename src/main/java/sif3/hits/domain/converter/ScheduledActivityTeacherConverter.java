package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsTeacherCoverCreditType;
import sif.dd.au30.model.AUCodeSetsTeacherCoverSupervisionType;
import sif.dd.au30.model.ScheduledActivityType.TeacherList.TeacherCover;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.ScheduledActivityTeacher;

@Component
public class ScheduledActivityTeacherConverter extends HitsConverter<TeacherCover, ScheduledActivityTeacher> {

  public ScheduledActivityTeacherConverter() {
    super(TeacherCover.class, ScheduledActivityTeacher.class);
  }

  @Override
  public void toSifModel(ScheduledActivityTeacher source, TeacherCover target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setStaffPersonalRefId(source.getStaffPersonalRefId());
      target.setStaffLocalId(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(source.getTeacherLocalId()));
      target.setStartTime(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverStartTime(getTimeValue(source.getStartTime())));
      target.setFinishTime(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverFinishTime(getTimeValue(source.getFinishTime())));
      target.setCredit(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverCredit(getEnumValue(source.getCredit(), AUCodeSetsTeacherCoverCreditType.class)));
      target.setSupervision(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverSupervision(getEnumValue(source.getSupervision(), AUCodeSetsTeacherCoverSupervisionType.class)));
      target.setWeighting(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverWeighting(getBigDecimalValue(source.getWeighting())));
    }
  }

  @Override
  public void toHitsModel(TeacherCover source, ScheduledActivityTeacher target) {
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
