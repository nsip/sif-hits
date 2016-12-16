package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.NAPTestItemCollectionType;
import sif.dd.au30.model.NAPTestItemType;
import sif3.hits.domain.model.NAPTestItem;
import sif3.hits.service.NAPTestItemService;

public class NAPTestItemProvider extends HitsBaseProvider<NAPTestItemType, NAPTestItemCollectionType, NAPTestItem, NAPTestItemService> {

  protected static final Logger L = LoggerFactory.getLogger(NAPTestItemProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public NAPTestItemProvider() {
    super(NAPTestItemType.class, "NAPTestItem", NAPTestItemCollectionType.class, "NAPTestItems", NAPTestItemService.class);
  }

}
