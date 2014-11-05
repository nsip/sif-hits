package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif.dd.au30.model.TeachingGroupType.TeacherList.TeachingGroupTeacher;
import sif3.hits.domain.model.StaffPersonal;

@Component
public class TeachingGroupTeacherConverter extends HitsConverter<TeachingGroupTeacher, StaffPersonal> {

  public TeachingGroupTeacherConverter() {
    super(TeachingGroupTeacher.class, StaffPersonal.class);
  }

  @Autowired
  private NameOfRecordConverter nameOfRecordConverter;

  @Override
  public void toSifModel(StaffPersonal source, TeachingGroupTeacher target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setStaffPersonalRefId(objectFactory
          .createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(source.getRefId()));
      target.setStaffLocalId(source.getLocalId());
      NameOfRecordType name = target.getName();
      if (name == null) {
        name = new NameOfRecordType();
      }
      nameOfRecordConverter.toSifModel(source, name);
      target.setName(name);
    }
  }

  @Override
  public void toHitsModel(TeachingGroupTeacher source, StaffPersonal target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getStaffPersonalRefId()));
      target.setLocalId(source.getStaffLocalId());
      nameOfRecordConverter.toHitsModel(source.getName(), target);
    }
  }

}
