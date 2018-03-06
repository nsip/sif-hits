package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTableCell;

@Component
public class TimeTableCellConverter extends HitsConverter<TimeTableCellType, TimeTableCell> {

  @Autowired
  private TimeTableCellRoomInfoConverter timeTableCellRoomInfoConverter;

  @Autowired
  private TimeTableCellStaffPersonalConverter timeTableCellStaffPersonalConverter;

  @Autowired
  private TimeTableCellTimeTableConverter timeTableCellTimeTableConverter;

  @Autowired
  private TimeTableCellTimeTableSubjectConverter timeTableCellTimeTableSubjectConverter;

  @Autowired
  private TimeTableCellTeachingGroupConverter timeTableCellTeachingGroupConverter;

  public TimeTableCellConverter() {
    super(TimeTableCellType.class, TimeTableCell.class);
  }

  @Override
  public void toSifModel(TimeTableCell source, TimeTableCellType target) {
    if (source != null && target != null) {
        IObjectFactory objectFactory = getObjectFactory();
      target.setCellType(source.getCellType());
      target.setDayId(source.getDayId());
      target.setPeriodId(source.getPeriodId());
      target.setRefId(source.getRefId());
      target.setSchoolLocalId(objectFactory.createTimeTableCellTypeSchoolLocalId(source.getSchoolInfoLocalId()));
      timeTableCellStaffPersonalConverter.toSifModel(source.getStaffPersonal(), target);
      timeTableCellTimeTableConverter.toSifModel(source.getTimeTable(), target);
      timeTableCellRoomInfoConverter.toSifModel(source.getRoomInfo(), target);
      timeTableCellTimeTableSubjectConverter.toSifModel(source.getTimeTableSubject(), target);
      timeTableCellTeachingGroupConverter.toSifModel(source.getTeachingGroup(), target);
    }
  }

  @Override
  public void toHitsModel(TimeTableCellType source, TimeTableCell target) {
    if (source != null && target != null) {
      target.setCellType(source.getCellType());
      target.setDayId(source.getDayId());
      target.setPeriodId(source.getPeriodId());
      target.setRefId(source.getRefId());
      target.setSchoolInfoLocalId(getJAXBValue(source.getSchoolLocalId()));
      target.setStaffPersonal(timeTableCellStaffPersonalConverter.toHitsModel(source));
      target.setTimeTable(timeTableCellTimeTableConverter.toHitsModel(source));
      target.setRoomInfo(timeTableCellRoomInfoConverter.toHitsModel(source));
      target.setTimeTableSubject(timeTableCellTimeTableSubjectConverter.toHitsModel(source));
      target.setTeachingGroup(timeTableCellTeachingGroupConverter.toHitsModel(source));
    }
  }
}
