package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsEnrollmentTimeFrameType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.model.StudentSchoolEnrollment;

@Component
public class StudentSchoolEnrollmentConverter extends
    HitsConverter<StudentSchoolEnrollmentType, StudentSchoolEnrollment> {

  public StudentSchoolEnrollmentConverter() {
    super(StudentSchoolEnrollmentType.class, StudentSchoolEnrollment.class);
  }

  @Override
  public void toSifModel(StudentSchoolEnrollment source, StudentSchoolEnrollmentType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setMembershipType(source.getMembershipType());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));

      AUCodeSetsEnrollmentTimeFrameType timeFrame = getEnumValue(source.getTimeFrame(),
          AUCodeSetsEnrollmentTimeFrameType.class);
      target.setTimeFrame(timeFrame);

      YearLevelType yearLevel = new YearLevelType();
      yearLevel.setCode(source.getYearLevel());
      target.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yearLevel));

      target.setFTE(objectFactory.createStudentSchoolEnrollmentTypeFTE(getBigDecimalValue(source.getFte())));
      target.setEntryDate(getDateValue(source.getEntryDate()));
    }
  }

  @Override
  public void toHitsModel(StudentSchoolEnrollmentType source, StudentSchoolEnrollment target) {
    target.setRefId(source.getRefId());
    target.setSchoolInfoRefId(source.getSchoolInfoRefId());
    target.setStudentPersonalRefId(source.getStudentPersonalRefId());
    target.setMembershipType(source.getMembershipType());
    target.setSchoolYear(getYearValue(source.getSchoolYear()));
    target.setTimeFrame(getEnumValue(source.getTimeFrame()));

    YearLevelType yearLevel = getJAXBValue(source.getYearLevel());
    if (yearLevel != null) {
      target.setYearLevel(yearLevel.getCode());
    }

    target.setFte(getBigDecimalValue(getJAXBValue(source.getFTE())));
    target.setEntryDate(getDateValue(source.getEntryDate()));
  }
}
