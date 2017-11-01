package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.TeachingGroupPeriodType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTableCell;

@Component
public class TeachingGroupPeriodTimeTableCellConverter extends HitsConverter<TeachingGroupPeriodType, TimeTableCell> {

  @Autowired
  private TeachingGroupPeriodRoomInfoConverter teachingGroupPeriodRoomInfoConverter;

  @Autowired
  private TeachingGroupPeriodStaffPersonalConverter teachingGroupPeriodStaffPersonalConverter;

  protected TeachingGroupPeriodTimeTableCellConverter() {
    super(TeachingGroupPeriodType.class, TimeTableCell.class);
  }

  @Override
  public void toSifModel(TimeTableCell source, TeachingGroupPeriodType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setCellType(objectFactory.createTeachingGroupPeriodTypeCellType(source.getCellType()));
      target.setDayId(source.getDayId());
      target.setPeriodId(objectFactory.createTeachingGroupPeriodTypePeriodId(source.getPeriodId()));
      teachingGroupPeriodRoomInfoConverter.toSifModel(source.getRoomInfo(), target);
      teachingGroupPeriodStaffPersonalConverter.toSifModel(source.getStaffPersonal(), target);
      target.setTimeTableCellRefId(objectFactory.createTeachingGroupPeriodTypeTimeTableCellRefId(source.getRefId()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupPeriodType source, TimeTableCell target) {
    if (source != null && target != null) {
      target.setCellType(getJAXBValue(source.getCellType()));
      target.setDayId(source.getDayId());
      target.setPeriodId(getJAXBValue(source.getPeriodId()));
      target.setRefId(getJAXBValue(source.getTimeTableCellRefId()));
    }
  }
}
