package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.PurchaseOrderCollectionType;
import sif.dd.au30.model.PurchaseOrderType;
import sif3.hits.domain.model.PurchaseOrder;
import sif3.hits.service.PurchaseOrderService;

public class PurchaseOrderProvider extends HitsBaseProvider<PurchaseOrderType, PurchaseOrderCollectionType, PurchaseOrder, PurchaseOrderService> {

  protected static final Logger L = LoggerFactory.getLogger(PurchaseOrderProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public PurchaseOrderProvider() {
    super(PurchaseOrderType.class, "PurchaseOrder", PurchaseOrderCollectionType.class, "PurchaseOrders", PurchaseOrderService.class);
  }
}
