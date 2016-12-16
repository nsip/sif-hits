package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.hits.domain.model.NAPCodeFrame;
import sif3.hits.service.NAPCodeFrameService;

public class NAPCodeFrameProvider extends HitsBaseProvider<NAPCodeFrameType, NAPCodeFrameCollectionType, NAPCodeFrame, NAPCodeFrameService> {
  protected static final Logger L = LoggerFactory.getLogger(NAPCodeFrameProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public NAPCodeFrameProvider() {
    super(NAPCodeFrameType.class, "NAPCodeFrame", NAPCodeFrameCollectionType.class, "NAPCodeFrames", NAPCodeFrameService.class);
  }
}
