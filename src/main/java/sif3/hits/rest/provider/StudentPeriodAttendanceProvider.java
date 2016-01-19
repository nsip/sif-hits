package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentPeriodAttendanceCollectionType;
import sif.dd.au30.model.StudentPeriodAttendanceType;
import sif3.hits.domain.model.StudentPeriodAttendance;
import sif3.hits.service.StudentPeriodAttendanceService;

public class StudentPeriodAttendanceProvider extends HitsBaseProvider<StudentPeriodAttendanceType, StudentPeriodAttendanceCollectionType, StudentPeriodAttendance, StudentPeriodAttendanceService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentPeriodAttendanceProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentPeriodAttendanceProvider() {
    super(StudentPeriodAttendanceType.class, "StudentPeriodAttendance", StudentPeriodAttendanceCollectionType.class, "StudentPeriodAttendances", StudentPeriodAttendanceService.class);
  }
}
