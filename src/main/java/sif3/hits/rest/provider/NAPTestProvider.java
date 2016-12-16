package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.NAPTestCollectionType;
import sif.dd.au30.model.NAPTestType;
import sif3.hits.domain.model.NAPTest;
import sif3.hits.service.NAPTestService;

public class NAPTestProvider extends HitsBaseProvider<NAPTestType, NAPTestCollectionType, NAPTest, NAPTestService> {

  protected static final Logger L = LoggerFactory.getLogger(NAPTestProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public NAPTestProvider() {
    super(NAPTestType.class, "NAPTest", NAPTestCollectionType.class, "NAPTests", NAPTestService.class);
  }

}
