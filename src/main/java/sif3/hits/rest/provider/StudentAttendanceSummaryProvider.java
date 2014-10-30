package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentAttendanceSummaryCollectionType;
import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.hits.domain.model.StudentAttendanceSummary;
import sif3.hits.service.StudentAttendanceSummaryService;

public class StudentAttendanceSummaryProvider extends
    HitsBaseProvider<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType, StudentAttendanceSummary, StudentAttendanceSummaryService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentAttendanceSummaryProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentAttendanceSummaryProvider() {
    super(StudentAttendanceSummaryType.class, "StudentAttendanceSummary", StudentAttendanceSummaryCollectionType.class, "StudentAttendanceSummarys",
        StudentAttendanceSummaryService.class);
  }

  @Override
  protected List<StudentAttendanceSummaryType> getSifList(StudentAttendanceSummaryCollectionType sifCollection) {
    List<StudentAttendanceSummaryType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getStudentAttendanceSummary();
    }
    return result;
  }
}