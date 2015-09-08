package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.FinancialAccountCollectionType;
import sif.dd.au30.model.FinancialAccountType;
import sif3.hits.domain.model.FinancialAccount;
import sif3.hits.service.FinancialAccountService;

public class FinancialAccountProvider extends
    HitsBaseProvider<FinancialAccountType, FinancialAccountCollectionType, FinancialAccount, FinancialAccountService> {

  protected static final Logger L = LoggerFactory.getLogger(FinancialAccountProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public FinancialAccountProvider() {
    super(FinancialAccountType.class, "FinancialAccount", FinancialAccountCollectionType.class, "FinancialAccounts",
        FinancialAccountService.class);
  }
}
