package sif3.hits.domain.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.StudentPersonalType.OtherIdList;
import sif.dd.au30.model.StudentPersonalType.OtherIdList.OtherId;
import sif3.hits.domain.converter.factory.IObjectFactory;

@Component
public class StudentPersonalOtherIdConverter extends HitsConverter<StudentPersonalType, OtherId> {

  public StudentPersonalOtherIdConverter() {
    super(StudentPersonalType.class, OtherId.class);
  }

  @Override
  public void toSifModel(OtherId source, StudentPersonalType target) {
    if (target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      ArrayList<OtherId> otherIds = new ArrayList<OtherId>();
      if (target.getOtherIdList() != null && target.getOtherIdList().getValue() != null && target.getOtherIdList().getValue().getOtherId() != null) {
        otherIds.addAll(target.getOtherIdList().getValue().getOtherId());
      }
      if (source != null) {
        otherIds.add(source);
      }
      OtherIdList otherIdList = new OtherIdList();
      otherIdList.getOtherId().addAll(otherIds);
      target.setOtherIdList(objectFactory.createStudentPersonalTypeOtherIdList(otherIdList));
    }
  }

  @Override
  public void toHitsModel(StudentPersonalType source, OtherId target) {
    if (source != null && target != null) {

    }
  }
}
