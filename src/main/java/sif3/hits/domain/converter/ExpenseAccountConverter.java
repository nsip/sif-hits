package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.ExpenseAccountType;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.ExpenseAccount;
import sif3.hits.utils.UsesConstants;

@Component
public class ExpenseAccountConverter extends HitsConverter<ExpenseAccountType, ExpenseAccount> implements UsesConstants {

  public ExpenseAccountConverter() {
    super(ExpenseAccountType.class, ExpenseAccount.class);
  }

  @Override
  public void toSifModel(ExpenseAccount source, ExpenseAccountType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setAccountCode(source.getAccountCode());
      target.setAccountingPeriod(objectFactory.createExpenseAccountTypeAccountingPeriod(source.getAccountingPeriod()));

      if (StringUtils.isNotBlank(source.getAmount())) {
        MonetaryAmountType monetaryAmount = objectFactory.createMonetaryAmountType();
        monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmount.setValue(getBigDecimalValue(source.getAmount()));
        target.setAmount(monetaryAmount);
      }
      target.setFinancialAccountRefId(objectFactory.createExpenseAccountTypeFinancialAccountRefId(source.getFinancialAccountRefId()));
    }
  }

  @Override
  public void toHitsModel(ExpenseAccountType source, ExpenseAccount target) {
    if (source != null && target != null) {
      target.setAccountCode(source.getAccountCode());
      target.setAccountingPeriod(getJAXBValue(source.getAccountingPeriod()));

      if (source.getAmount() != null) {
          MonetaryAmountType monetaryAmount = source.getAmount();
          if (monetaryAmount != null) {
              target.setAmount(getBigDecimalValue(monetaryAmount.getValue()));
          }
      }
      target.setFinancialAccountRefId(getJAXBValue(source.getFinancialAccountRefId()));
    }
  }

}
