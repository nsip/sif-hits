package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.DebtorCollectionType;
import sif.dd.au30.model.DebtorType;
import sif3.hits.domain.model.Debtor;
import sif3.hits.service.DebtorService;

public class DebtorProvider extends
    HitsBaseProvider<DebtorType, DebtorCollectionType, Debtor, DebtorService> {

  protected static final Logger L = LoggerFactory.getLogger(DebtorProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public DebtorProvider() {
    super(DebtorType.class, "Debtor", DebtorCollectionType.class, "Debtors",
        DebtorService.class);
  }
}
