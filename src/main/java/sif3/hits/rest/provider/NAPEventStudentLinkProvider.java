package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif3.hits.domain.model.NAPEventStudentLink;
import sif3.hits.service.NAPEventStudentLinkService;

public class NAPEventStudentLinkProvider extends HitsBaseProvider<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType, NAPEventStudentLink, NAPEventStudentLinkService> {

  protected static final Logger L = LoggerFactory.getLogger(NAPEventStudentLinkProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public NAPEventStudentLinkProvider() {
    super(NAPEventStudentLinkType.class, "NAPEventStudentLink", NAPEventStudentLinkCollectionType.class, "NAPEventStudentLinks", NAPEventStudentLinkService.class);
  }

}
