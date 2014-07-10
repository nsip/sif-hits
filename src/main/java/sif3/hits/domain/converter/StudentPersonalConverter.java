package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.StudentPersonalType.MostRecent;
import sif3.hits.domain.model.StudentPersonal;

@Component
public class StudentPersonalConverter extends HitsConverter<StudentPersonalType, StudentPersonal> {

  public StudentPersonalConverter() {
    super(StudentPersonalType.class, StudentPersonal.class);
  }

  @Autowired
  private PersonInfoConverter personInfoConverter;

  @Override
  public void toSifModel(StudentPersonal source, StudentPersonalType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setPersonInfo(personInfoConverter.toSifModel(source));
      
      MostRecent mostRecent = getJAXBValue(target.getMostRecent());
      if (mostRecent == null) {
        mostRecent = new MostRecent();
      }
      YearLevelType yearLevel = getJAXBValue(mostRecent.getYearLevel());
      if (yearLevel == null) {
        yearLevel = new YearLevelType();
      }
      yearLevel.setCode(source.getMostRecentYearLevel());
      mostRecent.setYearLevel(objectFactory.createYearLevel(yearLevel));
      
      target.setMostRecent(objectFactory.createStudentPersonalTypeMostRecent(mostRecent));
    }
  }

  @Override
  public void toHitsModel(StudentPersonalType source, StudentPersonal target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      personInfoConverter.toHitsModel(source.getPersonInfo(), target);

    
    
    }
  }
}
