package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.converter.factory.ObjectFactory;
import sif.dd.au30.model.ScheduledActivityType.TeacherList.TeacherCover;
import sif3.hits.domain.model.ScheduledActivityTeacher;

@Component
public class ScheduledActivityTeacherConverter extends HitsConverter<TeacherCover, ScheduledActivityTeacher> {

  public ScheduledActivityTeacherConverter() {
    super(TeacherCover.class, ScheduledActivityTeacher.class);
  }

  @Override
  public void toSifModel(ScheduledActivityTeacher source, TeacherCover target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setStaffPersonalRefId(source.getStaffPersonalRefId());
      target.setStaffLocalId(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(source
          .getTeacherLocalId()));
      target.setStartTime(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverStartTime(getTimeValue(source
          .getStartTime())));
      target.setFinishTime(objectFactory
          .createScheduledActivityTypeTeacherListTeacherCoverFinishTime(getTimeValue(source.getFinishTime())));
      target.setCredit(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverCredit(source.getCredit()));
      target.setSupervision(objectFactory.createScheduledActivityTypeTeacherListTeacherCoverSupervision(source
          .getSupervision()));
      target.setWeighting(objectFactory
          .createScheduledActivityTypeTeacherListTeacherCoverWeighting(getBigDecimalValue(source.getWeighting())));
    }
  }

  @Override
  public void toHitsModel(TeacherCover source, ScheduledActivityTeacher target) {
    if (source != null && target != null) {
      target.setStaffPersonalRefId(source.getStaffPersonalRefId());
      target.setTeacherLocalId(getJAXBValue(source.getStaffLocalId()));
      target.setStartTime(getTimeValue(getJAXBValue(source.getStartTime())));
      target.setFinishTime(getTimeValue(getJAXBValue(source.getFinishTime())));
      target.setCredit(getJAXBValue(source.getCredit()));
      target.setSupervision(getJAXBValue(source.getSupervision()));
      target.setWeighting(getBigDecimalValue(getJAXBValue(source.getWeighting())));
    }
  }
}
