package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentSchoolEnrollmentCollectionType;
import sif.dd.au30.model.StudentSchoolEnrollmentType;
import sif3.hits.domain.model.StudentSchoolEnrollment;
import sif3.hits.service.StudentSchoolEnrollmentService;

public class StudentSchoolEnrollmentProvider extends
    HitsBaseProvider<StudentSchoolEnrollmentType, StudentSchoolEnrollmentCollectionType, StudentSchoolEnrollment, StudentSchoolEnrollmentService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentSchoolEnrollmentProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentSchoolEnrollmentProvider() {
    super(StudentSchoolEnrollmentType.class, "StudentSchoolEnrollment", StudentSchoolEnrollmentCollectionType.class, "StudentSchoolEnrollments",
        StudentSchoolEnrollmentService.class);
  }

  @Override
  protected List<StudentSchoolEnrollmentType> getSifList(StudentSchoolEnrollmentCollectionType sifCollection) {
    List<StudentSchoolEnrollmentType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getStudentSchoolEnrollment();
    }
    return result;
  }
}
