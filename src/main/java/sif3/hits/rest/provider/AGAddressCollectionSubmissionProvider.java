package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sif.dd.au30.model.AGAddressCollectionSubmissionCollectionType;
import sif.dd.au30.model.AGAddressCollectionSubmissionType;
import sif3.hits.domain.model.AGAddressCollectionSubmission;
import sif3.hits.service.AGAddressCollectionSubmissionService;

public class AGAddressCollectionSubmissionProvider extends HitsBaseProvider<AGAddressCollectionSubmissionType, AGAddressCollectionSubmissionCollectionType, AGAddressCollectionSubmission, AGAddressCollectionSubmissionService> {

  protected static final Logger L = LoggerFactory.getLogger(AGAddressCollectionSubmissionProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public AGAddressCollectionSubmissionProvider() {
    super(AGAddressCollectionSubmissionType.class, "AGAddressCollectionSubmission", AGAddressCollectionSubmissionCollectionType.class, "AGAddressCollectionSubmissions", AGAddressCollectionSubmissionService.class);
  }
}
