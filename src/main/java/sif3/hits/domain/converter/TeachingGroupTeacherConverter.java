package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.TeachingGroupType.TeacherList.TeachingGroupTeacher;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffPersonal;

@Component
public class TeachingGroupTeacherConverter extends HitsConverter<TeachingGroupTeacher, sif3.hits.domain.model.TeachingGroupTeacher> {

  public TeachingGroupTeacherConverter() {
    super(TeachingGroupTeacher.class, sif3.hits.domain.model.TeachingGroupTeacher.class);
  }

  @Autowired
  private NameOfRecordConverter nameOfRecordConverter;

  @Override
  public void toSifModel(sif3.hits.domain.model.TeachingGroupTeacher source, TeachingGroupTeacher target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      if (source.getStaffPersonal() != null) {
        target.setStaffPersonalRefId(objectFactory.createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(source.getStaffPersonal().getRefId()));
        target.setStaffLocalId(source.getStaffPersonal().getLocalId());
        NameOfRecordType name = target.getName();
        if (name == null) {
          name = new NameOfRecordType();
        }
        nameOfRecordConverter.toSifModel(source.getStaffPersonal(), name);
        target.setName(name);
      }
      target.setAssociation(source.getTeacherAssociation());
    }
  }

  @Override
  public void toHitsModel(TeachingGroupTeacher source, sif3.hits.domain.model.TeachingGroupTeacher target) {
    if (source != null && target != null) {
      StaffPersonal staffPersonal = new StaffPersonal();
      staffPersonal.setRefId(getJAXBValue(source.getStaffPersonalRefId()));
      target.setStaffPersonal(staffPersonal);
      target.setTeacherAssociation(source.getAssociation());
    }
  }

}
