package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.NAPTestletCollectionType;
import sif.dd.au30.model.NAPTestletType;
import sif3.hits.domain.model.NAPTestlet;
import sif3.hits.service.NAPTestletService;

public class NAPTestletProvider extends HitsBaseProvider<NAPTestletType, NAPTestletCollectionType, NAPTestlet, NAPTestletService> {

  protected static final Logger L = LoggerFactory.getLogger(NAPTestletProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public NAPTestletProvider() {
    super(NAPTestletType.class, "NAPTestlet", NAPTestletCollectionType.class, "NAPTestlets", NAPTestletService.class);
  }

}
