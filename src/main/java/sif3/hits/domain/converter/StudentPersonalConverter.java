package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.OtherIdListType;
import sif.dd.au30.model.OtherIdType;
import sif.dd.au30.model.StudentMostRecentContainerType;
import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
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
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setLocalId(source.getLocalId());
      target.setPersonInfo(personInfoConverter.toSifModel(source));
      target.setStateProvinceId(objectFactory.createStudentPersonalTypeStateProvinceId(source.getStateProvinceId()));

      StudentMostRecentContainerType mostRecent = objectFactory.createStudentMostRecentContainerType();

      if (StringUtils.isNotBlank(source.getMostRecentYearLevel())) {
        YearLevelType yearLevel = objectFactory.createYearLevelType();
        yearLevel.setCode(source.getMostRecentYearLevel());
        mostRecent.setYearLevel(objectFactory.createStudentMostRecentContainerTypeYearLevel(yearLevel));
      }

      mostRecent.setParent1Language(objectFactory.createStudentMostRecentContainerTypeParent1Language(source.getMostRecentParent1Language()));
      mostRecent.setParent2Language(objectFactory.createStudentMostRecentContainerTypeParent2Language(source.getMostRecentParent2Language()));
      mostRecent.setParent1SchoolEducationLevel(objectFactory.createStudentMostRecentContainerTypeParent1SchoolEducationLevel(source.getMostRecentParent1SchoolEducation()));
      mostRecent.setParent2SchoolEducationLevel(objectFactory.createStudentMostRecentContainerTypeParent2SchoolEducationLevel(source.getMostRecentParent2SchoolEducation()));
      mostRecent.setParent1NonSchoolEducation(objectFactory.createStudentMostRecentContainerTypeParent1NonSchoolEducation(source.getMostRecentParent1NonSchoolEducation()));
      mostRecent.setParent2NonSchoolEducation(objectFactory.createStudentMostRecentContainerTypeParent2NonSchoolEducation(source.getMostRecentParent2NonSchoolEducation()));
      mostRecent.setParent1EmploymentType(objectFactory.createStudentMostRecentContainerTypeParent1EmploymentType(source.getMostRecentParent1EmploymentType()));
      mostRecent.setParent2EmploymentType(objectFactory.createStudentMostRecentContainerTypeParent2EmploymentType(source.getMostRecentParent2EmploymentType()));

      // naplan
      mostRecent.setSchoolLocalId(objectFactory.createStudentMostRecentContainerTypeSchoolLocalId(source.getMostRecentSchoolLocalId()));
      mostRecent.setSchoolACARAId(objectFactory.createStudentMostRecentContainerTypeSchoolACARAId(source.getMostRecentSchoolAcaraId()));
      mostRecent.setLocalCampusId(objectFactory.createStudentMostRecentContainerTypeLocalCampusId(source.getMostRecentSchoolCampusId()));
      mostRecent.setHomeroomLocalId(objectFactory.createStudentMostRecentContainerTypeHomeroomLocalId(source.getMostRecentHomeroomLocalId()));
      mostRecent.setFTE(objectFactory.createStudentMostRecentContainerTypeFTE(getBigDecimalValue(source.getMostRecentFTE())));
      mostRecent.setHomegroup(objectFactory.createStudentMostRecentContainerTypeHomegroup(source.getMostRecentHomegroup()));
      mostRecent.setClassCode(objectFactory.createStudentMostRecentContainerTypeClassCode(source.getMostRecentClassCode()));
      mostRecent.setMembershipType(source.getMostRecentMembershipType());
      mostRecent.setOtherEnrollmentSchoolACARAId(objectFactory.createStudentMostRecentContainerTypeOtherEnrollmentSchoolACARAId(source.getMostRecentOtherEnrollmentSchoolAcaraId()));
      mostRecent.setFFPOS(objectFactory.createStudentMostRecentContainerTypeFFPOS(source.getMostRecentFFPOS()));
      mostRecent.setReportingSchoolId(objectFactory.createStudentMostRecentContainerTypeReportingSchoolId(source.getMostRecentReportingSchool()));

      if (StringUtils.isNotBlank(source.getMostRecentTestLevel())) {
        YearLevelType testLevel = objectFactory.createYearLevelType();
        testLevel.setCode(source.getMostRecentTestLevel());
        mostRecent.setTestLevel(objectFactory.createStudentMostRecentContainerTypeTestLevel(testLevel));
      }

      target.setMostRecent(objectFactory.createStudentPersonalTypeMostRecent(mostRecent));

      target.setOfflineDelivery(objectFactory.createStudentPersonalTypeOfflineDelivery(getEnumValue(source.getOfflineDelivery(), AUCodeSetsYesOrNoCategoryType.class)));
      target.setEducationSupport(objectFactory.createStudentPersonalTypeEducationSupport(getEnumValue(source.getEducationSupport(), AUCodeSetsYesOrNoCategoryType.class)));
      target.setHomeSchooledStudent(objectFactory.createStudentPersonalTypeHomeSchooledStudent(getEnumValue(source.getHomeSchooledStudent(), AUCodeSetsYesOrNoCategoryType.class)));
      target.setESL(objectFactory.createStudentPersonalTypeESL(getEnumValue(source.getEsl(), AUCodeSetsYesOrNoCategoryType.class)));
      target.setSensitive(objectFactory.createStudentPersonalTypeSensitive(getEnumValue(source.getSensitive(), AUCodeSetsYesOrNoCategoryType.class)));

      ArrayList<OtherIdType> otherIds = new ArrayList<OtherIdType>();
      if (source.getOtherIds() != null) {
        for (StudentPersonalOtherId studentPersonalOtherId : source.getOtherIds()) {
          OtherIdType otherId = objectFactory.createOtherIdType();
          otherId.setType(studentPersonalOtherId.getOtherIdType());
          otherId.setValue(studentPersonalOtherId.getOtherId());
          otherIds.add(otherId);
        }
      }
      OtherIdListType otherIdList = objectFactory.createOtherIdListType();
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

      StudentMostRecentContainerType mostRecent = getJAXBValue(source.getMostRecent());
      if (mostRecent != null) {
        YearLevelType yearLevel = getJAXBValue(mostRecent.getYearLevel());
        if (yearLevel != null) {
          target.setYearLevel(yearLevel.getCode());
          target.setMostRecentYearLevel(yearLevel.getCode());
        }
        target.setMostRecentParent1Language(getJAXBValue(mostRecent.getParent1Language()));
        target.setMostRecentParent2Language(getJAXBValue(mostRecent.getParent2Language()));
        target.setMostRecentParent1SchoolEducation(getJAXBValue(mostRecent.getParent1SchoolEducationLevel()));
        target.setMostRecentParent2SchoolEducation(getJAXBValue(mostRecent.getParent2SchoolEducationLevel()));
        target.setMostRecentParent1NonSchoolEducation(getJAXBValue(mostRecent.getParent1NonSchoolEducation()));
        target.setMostRecentParent2NonSchoolEducation(getJAXBValue(mostRecent.getParent2NonSchoolEducation()));
        target.setMostRecentParent1EmploymentType(getJAXBValue(mostRecent.getParent1EmploymentType()));
        target.setMostRecentParent2EmploymentType(getJAXBValue(mostRecent.getParent2EmploymentType()));

        // naplan
        target.setMostRecentSchoolLocalId(getJAXBValue(mostRecent.getSchoolLocalId()));
        target.setMostRecentSchoolAcaraId(getJAXBValue(mostRecent.getSchoolACARAId()));
        target.setMostRecentSchoolCampusId(getJAXBValue(mostRecent.getLocalCampusId()));
        target.setMostRecentHomeroomLocalId(getJAXBValue(mostRecent.getHomeroomLocalId()));
        target.setMostRecentFTE(getBigDecimalValue(getJAXBValue(mostRecent.getFTE())));
        target.setMostRecentHomegroup(getJAXBValue(mostRecent.getHomegroup()));
        target.setMostRecentClassCode(getJAXBValue(mostRecent.getClassCode()));
        target.setMostRecentMembershipType(mostRecent.getMembershipType());
        target.setMostRecentOtherEnrollmentSchoolAcaraId(getJAXBValue(mostRecent.getOtherEnrollmentSchoolACARAId()));
        target.setMostRecentFFPOS(getJAXBValue(mostRecent.getFFPOS()));
        target.setMostRecentReportingSchool(getJAXBValue(mostRecent.getReportingSchoolId()));

        YearLevelType testLevel = getJAXBValue(mostRecent.getTestLevel());
        if (testLevel != null) {
          target.setMostRecentTestLevel(testLevel.getCode());
        }

        target.setOfflineDelivery(getJAXBEnumValue(source.getOfflineDelivery()));
        target.setEducationSupport(getJAXBEnumValue(source.getEducationSupport()));
        target.setHomeSchooledStudent(getJAXBEnumValue(source.getHomeSchooledStudent()));
        target.setEsl(getJAXBEnumValue(source.getESL()));
        target.setSensitive(getJAXBEnumValue(source.getSensitive()));
      }

      if (target.getOtherIds() == null) {
        target.setOtherIds(new HashSet<StudentPersonalOtherId>());
      } else {
        target.getOtherIds().clear();
      }
      OtherIdListType otherIdList = getJAXBValue(source.getOtherIdList());
      if (otherIdList != null && otherIdList.getOtherId() != null) {
        for (OtherIdType otherId : otherIdList.getOtherId()) {
          StudentPersonalOtherId studentPersonalOtherId = new StudentPersonalOtherId();
          studentPersonalOtherId.setOtherId(otherId.getValue());
          studentPersonalOtherId.setOtherIdType(otherId.getType());
          studentPersonalOtherId.setStudentPersonal(target);
          target.getOtherIds().add(studentPersonalOtherId);
        }
      }

    }
  }
}
