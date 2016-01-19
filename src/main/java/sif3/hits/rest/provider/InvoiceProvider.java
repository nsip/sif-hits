package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.InvoiceCollectionType;
import sif.dd.au30.model.InvoiceType;
import sif3.hits.domain.model.Invoice;
import sif3.hits.service.InvoiceService;

public class InvoiceProvider extends HitsBaseProvider<InvoiceType, InvoiceCollectionType, Invoice, InvoiceService> {

  protected static final Logger L = LoggerFactory.getLogger(InvoiceProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public InvoiceProvider() {
    super(InvoiceType.class, "Invoice", InvoiceCollectionType.class, "Invoices", InvoiceService.class);
  }
}
