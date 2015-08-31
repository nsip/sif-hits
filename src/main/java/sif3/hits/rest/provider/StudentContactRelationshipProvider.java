package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentContactRelationshipCollectionType;
import sif.dd.au30.model.StudentContactRelationshipType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.model.StudentContactRelationship;
import sif3.hits.service.StudentContactRelationshipService;

public class StudentContactRelationshipProvider extends
    HitsBaseProvider<StudentContactRelationshipType, StudentContactRelationshipCollectionType, StudentContactRelationship, StudentContactRelationshipService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentContactRelationshipProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentContactRelationshipProvider() {
    super(StudentContactRelationshipType.class, "StudentContactRelationship", StudentContactRelationshipCollectionType.class, "StudentContactRelationships",
        StudentContactRelationshipService.class);
  }
  
  @Override
  protected String getRefId(StudentContactRelationshipType sifObject, Class<StudentContactRelationshipType> sifClass)
      throws PersistenceException {
    String result = null;
    if (sifObject != null && sifObject.getStudentContactRelationshipRefId() != null) {
      result = sifObject.getStudentContactRelationshipRefId().getValue();
    }
    return result;

  }
}
