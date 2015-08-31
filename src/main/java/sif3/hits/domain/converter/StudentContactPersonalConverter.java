package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.StudentContactPersonalType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.StudentContactPersonal;

@Component
public class StudentContactPersonalConverter extends HitsConverter<StudentContactPersonalType, StudentContactPersonal> {

  @Autowired
  private PersonInfoConverter personInfoConverter;
  
  public StudentContactPersonalConverter() {
    super(StudentContactPersonalType.class, StudentContactPersonal.class);
  }

  @Override
  public void toSifModel(StudentContactPersonal source, StudentContactPersonalType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setEmploymentType(objectFactory.createStudentContactPersonalTypeEmploymentType(source.getEmploymentType()));
      target.setLocalId(objectFactory.createStudentContactPersonalTypeLocalId(source.getLocalId()));
      target.setNonSchoolEducation(objectFactory.createStudentContactPersonalTypeNonSchoolEducation(source.getNonSchoolEducation()));
      target.setRefId(source.getRefId());
      target.setSchoolEducationalLevel(objectFactory.createStudentContactPersonalTypeSchoolEducationalLevel(source.getSchoolEducationLevel()));
      
      PersonInfoType personInfoType = personInfoConverter.toSifModel(source);
      target.setPersonInfo(personInfoType);
    }
  }

  @Override
  public void toHitsModel(StudentContactPersonalType source, StudentContactPersonal target) {
    if (source != null && target != null) {
      target.setEmploymentType(getJAXBValue(source.getEmploymentType()));
      target.setLocalId(getJAXBValue(source.getLocalId()));
      target.setNonSchoolEducation(getJAXBValue(source.getNonSchoolEducation()));
      target.setRefId(source.getRefId());
      target.setSchoolEducationLevel(getJAXBValue(source.getSchoolEducationalLevel()));
      
      personInfoConverter.toHitsModel(source.getPersonInfo(), target);
    }
  }
  
}
