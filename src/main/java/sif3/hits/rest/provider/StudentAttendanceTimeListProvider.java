package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentAttendanceTimeListCollectionType;
import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif3.hits.domain.model.StudentAttendanceTimeList;
import sif3.hits.service.StudentAttendanceTimeListService;

public class StudentAttendanceTimeListProvider extends HitsBaseProvider<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType, StudentAttendanceTimeList, StudentAttendanceTimeListService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentAttendanceTimeListProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentAttendanceTimeListProvider() {
    super(StudentAttendanceTimeListType.class, "StudentAttendanceTimeList", StudentAttendanceTimeListCollectionType.class, "StudentAttendanceTimeLists", StudentAttendanceTimeListService.class);
  }
}
