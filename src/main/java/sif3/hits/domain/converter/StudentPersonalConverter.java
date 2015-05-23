package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.StudentPersonalType.MostRecent;
import sif.dd.au30.model.StudentPersonalType.OtherIdList;
import sif.dd.au30.model.StudentPersonalType.OtherIdList.OtherId;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.StudentPersonalOtherId;

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
      target.setStateProvinceId(objectFactory.createStudentPersonalTypeStateProvinceId(source.getStateProvinceId()));

      MostRecent mostRecent = new MostRecent();
      YearLevelType yearLevel = new YearLevelType();
      yearLevel.setCode(source.getMostRecentYearLevel());
      mostRecent.setYearLevel(objectFactory.createStudentPersonalTypeMostRecentYearLevel(yearLevel));
      mostRecent.setParent1Language(objectFactory.createStudentPersonalTypeMostRecentParent1Language(source
          .getMostRecentParent1Language()));
      mostRecent.setParent2Language(objectFactory.createStudentPersonalTypeMostRecentParent2Language(source
          .getMostRecentParent2Language()));
      mostRecent
          .setParent1SchoolEducationLevel(objectFactory
              .createStudentPersonalTypeMostRecentParent1SchoolEducationLevel(source
                  .getMostRecentParent1SchoolEducation()));
      mostRecent
          .setParent2SchoolEducationLevel(objectFactory
              .createStudentPersonalTypeMostRecentParent2SchoolEducationLevel(source
                  .getMostRecentParent2SchoolEducation()));
      mostRecent
          .setParent1NonSchoolEducation(objectFactory
              .createStudentPersonalTypeMostRecentParent1NonSchoolEducation(source
                  .getMostRecentParent1NonSchoolEducation()));
      mostRecent
          .setParent2NonSchoolEducation(objectFactory
              .createStudentPersonalTypeMostRecentParent2NonSchoolEducation(source
                  .getMostRecentParent2NonSchoolEducation()));
      mostRecent.setParent1EmploymentType(objectFactory.createStudentPersonalTypeMostRecentParent1EmploymentType(source
          .getMostRecentParent1EmploymentType()));
      mostRecent.setParent2EmploymentType(objectFactory.createStudentPersonalTypeMostRecentParent2EmploymentType(source
          .getMostRecentParent2EmploymentType()));

      target.setMostRecent(objectFactory.createStudentPersonalTypeMostRecent(mostRecent));
      
      ArrayList<OtherId> otherIds = new ArrayList<OtherId>();
      if (source.getOtherIds() != null) {
        for (StudentPersonalOtherId studentPersonalOtherId : source.getOtherIds()) {
          OtherId otherId = new OtherId();
          otherId.setType(studentPersonalOtherId.getOtherIdType());
          otherId.setValue(studentPersonalOtherId.getOtherId());
          otherIds.add(otherId);
        }
      }
      OtherIdList otherIdList = new OtherIdList();
      otherIdList.getOtherId().addAll(otherIds);
      target.setOtherIdList(objectFactory.createStudentPersonalTypeOtherIdList(otherIdList));   
    }
  }

  @Override
  public void toHitsModel(StudentPersonalType source, StudentPersonal target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
      personInfoConverter.toHitsModel(source.getPersonInfo(), target);

      MostRecent mostRecent = getJAXBValue(source.getMostRecent());
      if (mostRecent != null) {
        YearLevelType yearLevel = getJAXBValue(mostRecent.getYearLevel());
        if (yearLevel != null) {
          target.setYearLevel(yearLevel.getCode());
          target.setMostRecentYearLevel(yearLevel.getCode());
          target.setMostRecentParent1Language(getJAXBValue(mostRecent.getParent1Language()));
          target.setMostRecentParent2Language(getJAXBValue(mostRecent.getParent2Language()));
          target.setMostRecentParent1SchoolEducation(getJAXBValue(mostRecent.getParent1SchoolEducationLevel()));
          target.setMostRecentParent2SchoolEducation(getJAXBValue(mostRecent.getParent2SchoolEducationLevel()));
          target.setMostRecentParent1NonSchoolEducation(getJAXBValue(mostRecent.getParent1NonSchoolEducation()));
          target.setMostRecentParent2NonSchoolEducation(getJAXBValue(mostRecent.getParent2NonSchoolEducation()));
          target.setMostRecentParent1EmploymentType(getJAXBValue(mostRecent.getParent1EmploymentType()));
          target.setMostRecentParent2EmploymentType(getJAXBValue(mostRecent.getParent2EmploymentType()));
        }
      }
      
      Set<StudentPersonalOtherId> otherIds = new HashSet<StudentPersonalOtherId>();
      OtherIdList otherIdList = getJAXBValue(source.getOtherIdList());
      if (otherIdList != null && otherIdList.getOtherId() != null) {
        for (OtherId otherId : otherIdList.getOtherId()) {
          StudentPersonalOtherId studentPersonalOtherId = new StudentPersonalOtherId();
          studentPersonalOtherId.setOtherId(otherId.getValue());
          studentPersonalOtherId.setOtherIdType(otherId.getType());
          otherIds.add(studentPersonalOtherId);
        }
      }
      target.setOtherIds(otherIds);
    }
  }
}
