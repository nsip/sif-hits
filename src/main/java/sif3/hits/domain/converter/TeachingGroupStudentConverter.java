package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.TeachingGroupType.StudentList.TeachingGroupStudent;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.StudentPersonal;

@Component
public class TeachingGroupStudentConverter extends HitsConverter<TeachingGroupStudent, StudentPersonal> {

  public TeachingGroupStudentConverter() {
    super(TeachingGroupStudent.class, StudentPersonal.class);
  }

  @Autowired
  private NameOfRecordConverter nameOfRecordConverter;

  @Override
  public void toSifModel(StudentPersonal source, TeachingGroupStudent target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setStudentPersonalRefId(objectFactory
          .createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(source.getRefId()));
      target.setStudentLocalId(source.getLocalId());

      NameOfRecordType name = target.getName();
      if (name == null) {
        name = new NameOfRecordType();
      }
      nameOfRecordConverter.toSifModel(source, name);
      target.setName(name);
    }
  }

  @Override
  public void toHitsModel(TeachingGroupStudent source, StudentPersonal target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getStudentPersonalRefId()));
      target.setLocalId(source.getStudentLocalId());
      nameOfRecordConverter.toHitsModel(source.getName(), target);
    }
  }
}
