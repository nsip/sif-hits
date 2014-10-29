package sif3.hits.rest.provider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StudentCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.service.StudentPersonalService;

public class StudentPersonalProvider extends
    HitsBaseProvider<StudentPersonalType, StudentCollectionType, StudentPersonal, StudentPersonalService> {

  protected static final Logger L = LoggerFactory.getLogger(StudentPersonalProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StudentPersonalProvider() {
    super(StudentPersonalType.class, "StudentPersonal", StudentCollectionType.class, "StudentPersonals",
        StudentPersonalService.class);
  }
  
//  public Object findBySchoolInfos(String referenceId, SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata) throws PersistenceException, UnsupportedQueryException {   
//    return super.retrieve(zone, context, pagingInfo, metadata);
//  }

  @Override
  protected List<StudentPersonalType> getSifList(StudentCollectionType sifCollection) {
    List<StudentPersonalType> result = null;
    if (sifCollection != null) {
      result = sifCollection.getStudentPersonal();
    }
    return result;
  }
}
