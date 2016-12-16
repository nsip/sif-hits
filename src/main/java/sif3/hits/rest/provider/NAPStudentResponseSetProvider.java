package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif3.hits.domain.model.NAPStudentResponseSet;
import sif3.hits.service.NAPStudentResponseSetService;

public class NAPStudentResponseSetProvider extends HitsBaseProvider<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType, NAPStudentResponseSet, NAPStudentResponseSetService> {

  protected static final Logger L = LoggerFactory.getLogger(NAPStudentResponseSetProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public NAPStudentResponseSetProvider() {
    super(NAPStudentResponseSetType.class, "NAPStudentResponseSet", NAPStudentResponseSetCollectionType.class, "NAPStudentResponseSets", NAPStudentResponseSetService.class);
  }

}
