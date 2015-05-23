package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.RoomInfo;

@Component
public class TeachingGroupPeriodRoomInfoConverter extends HitsConverter<TeachingGroupPeriod, RoomInfo> {
  public TeachingGroupPeriodRoomInfoConverter() {
    super(TeachingGroupPeriod.class, RoomInfo.class);
  }

  @Override
  public void toSifModel(RoomInfo source, TeachingGroupPeriod target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRoomNumber(objectFactory
          .createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(source.getRoomNumber()));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupPeriod source, RoomInfo target) {
    if (source != null && target != null) {
      target.setRoomNumber(getJAXBValue(source.getRoomNumber()));
    }
  }
}
