package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsEnrollmentTimeFrameType;
import sif.dd.au30.model.AUCodeSetsSchoolEnrollmentTypeType;
import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Component
public class StudentSchoolEnrollmentConverter extends HitsConverter<StudentSchoolEnrollmentType, StudentSchoolEnrollment> {

  public StudentSchoolEnrollmentConverter() {
    super(StudentSchoolEnrollmentType.class, StudentSchoolEnrollment.class);
  }

  @Override
  public void toSifModel(StudentSchoolEnrollment source, StudentSchoolEnrollmentType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setMembershipType(getEnumValue(source.getMembershipType(), AUCodeSetsSchoolEnrollmentTypeType.class));
      target.setSchoolYear(getYearValue(source.getSchoolYear()));

      AUCodeSetsEnrollmentTimeFrameType timeFrame = getEnumValue(source.getTimeFrame(), AUCodeSetsEnrollmentTimeFrameType.class);
      target.setTimeFrame(timeFrame);

      YearLevelType yearLevel = new YearLevelType();
      yearLevel.setCode(getEnumValue(source.getYearLevel(), AUCodeSetsYearLevelCodeType.class));
      target.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yearLevel));

      target.setFTE(objectFactory.createStudentSchoolEnrollmentTypeFTE(getBigDecimalValue(source.getFte())));
      target.setEntryDate(getDateValue(source.getEntryDate()));
      target.setExitDate(objectFactory.createStudentSchoolEnrollmentTypeExitDate(getDateValue(source.getExitDate())));

      target.setClassCode(objectFactory.createStudentSchoolEnrollmentTypeClassCode(source.getClassCode()));
      target.setReportingSchool(objectFactory.createStudentSchoolEnrollmentTypeReportingSchool(getEnumValue(source.getReportingSchool(), AUCodeSetsYesOrNoCategoryType.class)));

    }
  }

  @Override
  public void toHitsModel(StudentSchoolEnrollmentType source, StudentSchoolEnrollment target) {
    target.setRefId(source.getRefId());
    target.setSchoolInfoRefId(source.getSchoolInfoRefId());
    target.setStudentPersonalRefId(source.getStudentPersonalRefId());
    target.setMembershipType(getEnumValue(source.getMembershipType()));
    target.setSchoolYear(getYearValue(source.getSchoolYear()));
    target.setTimeFrame(getEnumValue(source.getTimeFrame()));

    YearLevelType yearLevel = getJAXBValue(source.getYearLevel());
    if (yearLevel != null) {
      target.setYearLevel(getEnumValue(yearLevel.getCode()));
    }

    target.setFte(getBigDecimalValue(getJAXBValue(source.getFTE())));
    target.setEntryDate(getDateValue(source.getEntryDate()));
    target.setExitDate(getDateValue(getJAXBValue(source.getExitDate())));

    target.setClassCode(getJAXBValue(source.getClassCode()));
    target.setReportingSchool(getJAXBEnumValue(source.getReportingSchool()));
  }
}
