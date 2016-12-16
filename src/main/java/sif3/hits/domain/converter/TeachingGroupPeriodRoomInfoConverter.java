package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TeachingGroupPeriodType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.RoomInfo;

@Component
public class TeachingGroupPeriodRoomInfoConverter extends HitsConverter<TeachingGroupPeriodType, RoomInfo> {
  public TeachingGroupPeriodRoomInfoConverter() {
    super(TeachingGroupPeriodType.class, RoomInfo.class);
  }

  @Override
  public void toSifModel(RoomInfo source, TeachingGroupPeriodType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRoomNumber(objectFactory.createTeachingGroupPeriodTypeRoomNumber(source.getRoomNumber()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupPeriodType source, RoomInfo target) {
    if (source != null && target != null) {
      target.setRoomNumber(getJAXBValue(source.getRoomNumber()));
    }
  }
}
