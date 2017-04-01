package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.TeachingGroupTeacherType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.TeachingGroupTeacher;

@Component
public class TeachingGroupTeacherConverter extends HitsConverter<TeachingGroupTeacherType, TeachingGroupTeacher> {

  public TeachingGroupTeacherConverter() {
    super(TeachingGroupTeacherType.class, TeachingGroupTeacher.class);
  }

  @Autowired
  private NameOfRecordConverter nameOfRecordConverter;

  @Override
  public void toSifModel(TeachingGroupTeacher source, TeachingGroupTeacherType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      if (source.getStaffPersonal() != null) {
        target.setStaffPersonalRefId(objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(source.getStaffPersonal().getRefId()));
        target.setStaffLocalId(objectFactory.createTeachingGroupTeacherTypeStaffLocalId(source.getStaffPersonal().getLocalId()));
        NameOfRecordType name = getJAXBValue(target.getName());
        if (name == null) {
          name = objectFactory.createNameOfRecordType();
        }
        nameOfRecordConverter.toSifModel(source.getStaffPersonal(), name);
        target.setName(objectFactory.createTeachingGroupTeacherTypeName(name));
      }
      target.setAssociation(source.getTeacherAssociation());
    }
  }

  @Override
  public void toHitsModel(TeachingGroupTeacherType source, TeachingGroupTeacher target) {
    if (source != null && target != null) {
      StaffPersonal staffPersonal = new StaffPersonal();
      staffPersonal.setRefId(getJAXBValue(source.getStaffPersonalRefId()));
      target.setStaffPersonal(staffPersonal);
      target.setTeacherAssociation(source.getAssociation());
    }
  }

}
