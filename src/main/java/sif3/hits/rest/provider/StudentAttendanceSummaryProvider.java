package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.StudentAttendanceSummaryCollectionType;
import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.model.StudentAttendanceSummary;
import sif3.hits.service.StudentAttendanceSummaryService;

public class StudentAttendanceSummaryProvider
    extends
    HitsBaseProvider<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType, StudentAttendanceSummary, StudentAttendanceSummaryService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentAttendanceSummaryProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentAttendanceSummaryProvider() {
    super(StudentAttendanceSummaryType.class, "StudentAttendanceSummary", StudentAttendanceSummaryCollectionType.class,
        "StudentAttendanceSummarys", StudentAttendanceSummaryService.class);
  }
  
  @Override
  protected void setRefId(StudentAttendanceSummaryType sifObject, Class<StudentAttendanceSummaryType> sifClass,
      String refId) throws PersistenceException {
    ObjectFactory objectFactory = new ObjectFactory();
    sifObject.setStudentAttendanceSummaryRefId(objectFactory.createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId(refId));
  }

  @Override
  protected String getRefId(StudentAttendanceSummaryType sifObject, Class<StudentAttendanceSummaryType> sifClass)
      throws PersistenceException {
    String result = null;
    if (sifObject != null && sifObject.getStudentAttendanceSummaryRefId() != null) {
      result = sifObject.getStudentAttendanceSummaryRefId().getValue();
    }
    return result;
  }
}
