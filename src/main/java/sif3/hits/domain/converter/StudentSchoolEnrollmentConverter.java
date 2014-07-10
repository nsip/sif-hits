package sif3.hits.domain.converter;

import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif3.hits.domain.model.StudentSchoolEnrollment;

public class StudentSchoolEnrollmentConverter extends
    HitsConverter<StudentSchoolEnrollmentType, StudentSchoolEnrollment> {

  // TODO: Implementation

  public StudentSchoolEnrollmentConverter() {
    super(StudentSchoolEnrollmentType.class, StudentSchoolEnrollment.class);
  }

  @Override
  public void toSifModel(StudentSchoolEnrollment source, StudentSchoolEnrollmentType target) {
    // private String refId;
    // private String schoolInfoRefId;
    // private String membershipType;
    // private String schoolYear;
    // private String timeFrame;
    // private String yearLevel;
    // private BigDecimal fte;
    // private Date entryDate;
  }

  @Override
  public void toHitsModel(StudentSchoolEnrollmentType source, StudentSchoolEnrollment target) {
    // private String refId;
    // private String schoolInfoRefId;
    // private String membershipType;
    // private String schoolYear;
    // private String timeFrame;
    // private String yearLevel;
    // private BigDecimal fte;
    // private Date entryDate;
  }
}
