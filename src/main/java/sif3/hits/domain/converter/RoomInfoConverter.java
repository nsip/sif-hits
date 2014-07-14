package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.RoomInfoType;
import sif3.hits.domain.model.RoomInfo;

@Component
public class RoomInfoConverter extends HitsConverter<RoomInfoType, RoomInfo> {

  public RoomInfoConverter() {
    super(RoomInfoType.class, RoomInfo.class);
  }

  @Override
  public void toSifModel(RoomInfo source, RoomInfoType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setRoomNumber(source.getRoomNumber());
      target.setDescription(objectFactory.createRoomInfoTypeDescription(source.getDescription()));
      target.setCapacity(objectFactory.createRoomInfoTypeCapacity(getLongValue(source.getCapacity())));
      target.setSize(objectFactory.createRoomInfoTypeSize(getBigDecimalValue(source.getRoomSize())));
      target.setRoomType(objectFactory.createRoomInfoTypeRoomType(source.getRoomType()));
    }
  }

  @Override
  public void toHitsModel(RoomInfoType source, RoomInfo target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setRoomNumber(source.getRoomNumber());
      target.setDescription(getJAXBValue(source.getDescription()));
      target.setCapacity(getLongValue(getJAXBValue(source.getCapacity())));
      target.setRoomSize(getBigDecimalValue(getJAXBValue(source.getSize())));
      target.setRoomType(getJAXBValue(source.getRoomType()));
    }
  }
}
