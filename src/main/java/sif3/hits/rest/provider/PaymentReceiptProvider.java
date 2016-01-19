package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.PaymentReceiptCollectionType;
import sif.dd.au30.model.PaymentReceiptType;
import sif3.hits.domain.model.PaymentReceipt;
import sif3.hits.service.PaymentReceiptService;

public class PaymentReceiptProvider extends HitsBaseProvider<PaymentReceiptType, PaymentReceiptCollectionType, PaymentReceipt, PaymentReceiptService> {

  protected static final Logger L = LoggerFactory.getLogger(PaymentReceiptProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public PaymentReceiptProvider() {
    super(PaymentReceiptType.class, "PaymentReceipt", PaymentReceiptCollectionType.class, "PaymentReceipts", PaymentReceiptService.class);
  }
}
