package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsEmploymentTypeType;
import sif.dd.au30.model.AUCodeSetsNonSchoolEducationType;
import sif.dd.au30.model.AUCodeSetsSchoolEducationLevelTypeType;
import sif.dd.au30.model.PersonInfoType;
import sif.dd.au30.model.StudentContactPersonalType;
import sif3.hits.domain.converter.factory.IObjectFactory;
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
      IObjectFactory objectFactory = getObjectFactory();
      target.setEmploymentType(objectFactory.createStudentContactPersonalTypeEmploymentType(getEnumValue(source.getEmploymentType(), AUCodeSetsEmploymentTypeType.class)));
      target.setLocalId(objectFactory.createStudentContactPersonalTypeLocalId(source.getLocalId()));
      target.setNonSchoolEducation(objectFactory.createStudentContactPersonalTypeNonSchoolEducation(getEnumValue(source.getNonSchoolEducation(), AUCodeSetsNonSchoolEducationType.class)));
      target.setRefId(source.getRefId());
      target.setSchoolEducationalLevel(objectFactory.createStudentContactPersonalTypeSchoolEducationalLevel(getEnumValue(source.getSchoolEducationLevel(),AUCodeSetsSchoolEducationLevelTypeType.class)));

      PersonInfoType personInfoType = personInfoConverter.toSifModel(source);
      target.setPersonInfo(personInfoType);
    }
  }

  @Override
  public void toHitsModel(StudentContactPersonalType source, StudentContactPersonal target) {
    if (source != null && target != null) {
      target.setEmploymentType(getJAXBEnumValue(source.getEmploymentType()));
      target.setLocalId(getJAXBValue(source.getLocalId()));
      target.setNonSchoolEducation(getJAXBEnumValue(source.getNonSchoolEducation()));
      target.setRefId(source.getRefId());
      target.setSchoolEducationLevel(getJAXBEnumValue(source.getSchoolEducationalLevel()));

      personInfoConverter.toHitsModel(source.getPersonInfo(), target);
    }
  }

}
