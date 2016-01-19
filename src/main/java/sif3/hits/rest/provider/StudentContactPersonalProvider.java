package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentContactCollectionType;
import sif.dd.au30.model.StudentContactPersonalType;
import sif3.hits.domain.model.StudentContactPersonal;
import sif3.hits.service.StudentContactPersonalService;

public class StudentContactPersonalProvider extends HitsBaseProvider<StudentContactPersonalType, StudentContactCollectionType, StudentContactPersonal, StudentContactPersonalService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentContactPersonalProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentContactPersonalProvider() {
    super(StudentContactPersonalType.class, "StudentContactPersonal", StudentContactCollectionType.class, "StudentContactPersonals", StudentContactPersonalService.class);
  }
}
