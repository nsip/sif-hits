package sif3.hits.domain.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.OtherIdListType;
import sif.dd.au30.model.OtherIdType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.hits.domain.converter.factory.IObjectFactory;

@Component
public class StudentPersonalOtherIdConverter extends HitsConverter<StudentPersonalType, OtherIdType> {

  public StudentPersonalOtherIdConverter() {
    super(StudentPersonalType.class, OtherIdType.class);
  }

  @Override
  public void toSifModel(OtherIdType source, StudentPersonalType target) {
    if (target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      ArrayList<OtherIdType> otherIds = new ArrayList<OtherIdType>();
      if (target.getOtherIdList() != null && target.getOtherIdList().getValue() != null && target.getOtherIdList().getValue().getOtherId() != null) {
        otherIds.addAll(target.getOtherIdList().getValue().getOtherId());
      }
      if (source != null) {
        otherIds.add(source);
      }
      OtherIdListType otherIdList = objectFactory.createOtherIdListType();
      otherIdList.getOtherId().addAll(otherIds);
      target.setOtherIdList(objectFactory.createStudentPersonalTypeOtherIdList(otherIdList));
    }
  }

  @Override
  public void toHitsModel(StudentPersonalType source, OtherIdType target) {
    if (source != null && target != null) {

    }
  }
}
