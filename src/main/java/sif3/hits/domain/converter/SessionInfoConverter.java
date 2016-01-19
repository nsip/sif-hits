package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.SessionInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.SessionInfo;

@Component
public class SessionInfoConverter extends HitsConverter<SessionInfoType, SessionInfo> {

  public SessionInfoConverter() {
    super(SessionInfoType.class, SessionInfo.class);
  }

  @Override
  public void toSifModel(SessionInfo source, SessionInfoType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setTimeTableCellRefId(source.getTimeTableCellRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setLocalId(source.getLocalId());
      target.setTimeTableSubjectLocalId(source.getTimeTableSubjectLocalId());
      target.setTeachingGroupLocalId(source.getTeachingGroupLocalId());
      target.setSchoolLocalId(objectFactory.createSessionInfoTypeSchoolLocalId(source.getSchoolLocalId()));
      target.setStaffPersonalLocalId(objectFactory.createSessionInfoTypeStaffPersonalLocalId(source.getStaffPersonalLocalId()));
      target.setRoomNumber(objectFactory.createSessionInfoTypeRoomNumber(source.getRoomNumber()));
      target.setDayId(source.getDayId());
      target.setPeriodId(source.getPeriodId());
      target.setSessionDate(getDateValue(source.getSessionDate()));
      target.setStartTime(objectFactory.createSessionInfoTypeStartTime(getTimeValue(source.getStartTime())));
      target.setFinishTime(objectFactory.createSessionInfoTypeFinishTime(getTimeValue(source.getFinishTime())));
      target.setRollMarked(objectFactory.createSessionInfoTypeRollMarked(getEnumValue(source.getRollMarked(), AUCodeSetsYesOrNoCategoryType.class)));
    }
  }

  @Override
  public void toHitsModel(SessionInfoType source, SessionInfo target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setTimeTableCellRefId(source.getTimeTableCellRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setLocalId(source.getLocalId());
      target.setTimeTableSubjectLocalId(source.getTimeTableSubjectLocalId());
      target.setTeachingGroupLocalId(source.getTeachingGroupLocalId());
      target.setSchoolLocalId(getJAXBValue(source.getSchoolLocalId()));
      target.setStaffPersonalLocalId(getJAXBValue(source.getStaffPersonalLocalId()));
      target.setRoomNumber(getJAXBValue(source.getRoomNumber()));
      target.setDayId(source.getDayId());
      target.setPeriodId(source.getPeriodId());
      target.setSessionDate(getDateValue(source.getSessionDate()));
      target.setStartTime(getTimeValue(getJAXBValue(source.getStartTime())));
      target.setFinishTime(getTimeValue(getJAXBValue(source.getFinishTime())));
      target.setRollMarked(getJAXBEnumValue(source.getRollMarked()));
    }
  }
}
