package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentDailyAttendanceCollectionType;
import sif.dd.au30.model.StudentDailyAttendanceType;
import sif3.hits.domain.model.StudentDailyAttendance;
import sif3.hits.service.StudentDailyAttendanceService;

public class StudentDailyAttendanceProvider extends HitsBaseProvider<StudentDailyAttendanceType, StudentDailyAttendanceCollectionType, StudentDailyAttendance, StudentDailyAttendanceService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentDailyAttendanceProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentDailyAttendanceProvider() {
    super(StudentDailyAttendanceType.class, "StudentDailyAttendance", StudentDailyAttendanceCollectionType.class, "StudentDailyAttendances", StudentDailyAttendanceService.class);
  }
}
