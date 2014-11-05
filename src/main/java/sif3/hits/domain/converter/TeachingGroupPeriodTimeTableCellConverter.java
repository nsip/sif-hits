package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif3.hits.domain.converter.factory.ObjectFactory;
import sif.dd.au30.model.TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod;
import sif3.hits.domain.model.TimeTableCell;

@Component
public class TeachingGroupPeriodTimeTableCellConverter extends HitsConverter<TeachingGroupPeriod, TimeTableCell> {

  @Autowired
  private TeachingGroupPeriodRoomInfoConverter teachingGroupPeriodRoomInfoConverter;

  @Autowired
  private TeachingGroupPeriodStaffPersonalConverter teachingGroupPeriodStaffPersonalConverter;

  protected TeachingGroupPeriodTimeTableCellConverter() {
    super(TeachingGroupPeriod.class, TimeTableCell.class);
  }

  @Override
  public void toSifModel(TimeTableCell source, TeachingGroupPeriod target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setCellType(objectFactory.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(source
          .getCellType()));
      target.setDayId(source.getDayId());
      target.setPeriodId(objectFactory.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(source
          .getPeriodId()));
      teachingGroupPeriodRoomInfoConverter.toSifModel(source.getRoomInfo(), target);
      teachingGroupPeriodStaffPersonalConverter.toSifModel(source.getStaffPersonal(), target);
      target.setTimeTableCellRefId(objectFactory
          .createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(source.getRefId()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupPeriod source, TimeTableCell target) {
    if (source != null && target != null) {
      target.setCellType(getJAXBValue(source.getCellType()));
      target.setDayId(source.getDayId());
      target.setPeriodId(getJAXBValue(source.getPeriodId()));
      target.setRoomInfo(teachingGroupPeriodRoomInfoConverter.toHitsModel(source));
      target.setStaffPersonal(teachingGroupPeriodStaffPersonalConverter.toHitsModel(source));
      target.setRefId(getJAXBValue(source.getTimeTableCellRefId()));
    }
  }
}
