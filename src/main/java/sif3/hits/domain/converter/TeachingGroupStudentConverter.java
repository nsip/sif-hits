package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.TeachingGroupStudentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentPersonal;

@Component
public class TeachingGroupStudentConverter extends HitsConverter<TeachingGroupStudentType, StudentPersonal> {

  public TeachingGroupStudentConverter() {
    super(TeachingGroupStudentType.class, StudentPersonal.class);
  }

  @Autowired
  private NameOfRecordConverter nameOfRecordConverter;

  @Override
  public void toSifModel(StudentPersonal source, TeachingGroupStudentType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setStudentPersonalRefId(objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(source.getRefId()));
      target.setStudentLocalId(objectFactory.createTeachingGroupStudentTypeStudentLocalId(source.getLocalId()));

      NameOfRecordType name = getJAXBValue(target.getName());
      if (name == null) {
        name = objectFactory.createNameOfRecordType();
      }
      nameOfRecordConverter.toSifModel(source, name);
      target.setName(objectFactory.createTeachingGroupStudentTypeName(name));
    }
  }

  @Override
  public void toHitsModel(TeachingGroupStudentType source, StudentPersonal target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getStudentPersonalRefId()));
      target.setLocalId(getJAXBValue(source.getStudentLocalId()));
      nameOfRecordConverter.toHitsModel(getJAXBValue(source.getName()), target);
    }
  }
}
