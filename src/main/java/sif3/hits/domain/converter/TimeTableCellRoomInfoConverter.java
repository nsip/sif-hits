package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.RoomInfo;

@Component
public class TimeTableCellRoomInfoConverter extends HitsConverter<TimeTableCellType, RoomInfo> {

  public TimeTableCellRoomInfoConverter() {
    super(null, RoomInfo.class);
  }

  @Override
  public void toSifModel(RoomInfo source, TimeTableCellType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRoomInfoRefId(objectFactory.createTimeTableCellTypeRoomInfoRefId(source.getRefId()));
      target.setRoomNumber(objectFactory.createTimeTableCellTypeRoomNumber(source.getRoomNumber()));
    }
  }

  @Override
  public void toHitsModel(TimeTableCellType source, RoomInfo target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getRoomInfoRefId()));
      target.setRoomNumber(getJAXBValue(source.getRoomNumber()));
    }
  }
}
