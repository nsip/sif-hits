package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.ExpenseAccount;
import sif3.hits.utils.UsesConstants;

@Component
public class ExpenseAccountConverter extends HitsConverter<sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount, ExpenseAccount>implements UsesConstants {

  public ExpenseAccountConverter() {
    super(sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount.class, ExpenseAccount.class);
  }

  @Override
  public void toSifModel(ExpenseAccount source, sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setAccountCode(source.getAccountCode());
      target.setAccountingPeriod(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccountsExpenseAccountAccountingPeriod(source.getAccountingPeriod()));

      if (StringUtils.isNotBlank(source.getAmount())) {
        MonetaryAmountType monetaryAmount = objectFactory.createMonetaryAmountType();
        monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmount.setValue(source.getAmount());
        target.setAmount(monetaryAmount);
      }

      target.setFinancialAccountRefId(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccountsExpenseAccountFinancialAccountRefId(source.getFinancialAccountRefId()));
    }
  }

  @Override
  public void toHitsModel(sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount source, ExpenseAccount target) {
    if (source != null && target != null) {
      target.setAccountCode(source.getAccountCode());
      target.setAccountingPeriod(getJAXBValue(source.getAccountingPeriod()));

      if (source.getAmount() != null) {
        target.setAmount(source.getAmount().getValue());
      }
      target.setFinancialAccountRefId(getJAXBValue(source.getFinancialAccountRefId()));
    }
  }

}
