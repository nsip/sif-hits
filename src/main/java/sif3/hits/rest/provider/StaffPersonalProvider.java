package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.StaffPersonalCollectionType;
import sif.dd.au30.model.StaffPersonalType;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.service.StaffPersonalService;

public class StaffPersonalProvider extends HitsBaseProvider<StaffPersonalType, StaffPersonalCollectionType, StaffPersonal, StaffPersonalService> {

  protected static final Logger L = LoggerFactory.getLogger(StaffPersonalProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public StaffPersonalProvider() {
    super(StaffPersonalType.class, "StaffPersonal", StaffPersonalCollectionType.class, "StaffPersonals", StaffPersonalService.class);
  }
}
