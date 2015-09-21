package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts;
import sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.PurchasingItem;
import sif3.hits.utils.UsesConstants;

@Component
public class PurchasingItemsConverter extends HitsConverter<sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem, PurchasingItem> implements UsesConstants{

  @Autowired
  private ExpenseAccountConverter expenseAccountConverter;
  
  public PurchasingItemsConverter() {
    super(sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem.class, PurchasingItem.class);
  }

  @Override
  public void toSifModel(PurchasingItem source, sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
    
      if (source.getExpenseAccount() != null) {
        ExpenseAccounts expenseAccounts = new ExpenseAccounts();
        ExpenseAccount expenseAccount = expenseAccountConverter.toSifModel(source.getExpenseAccount());
        expenseAccounts.setExpenseAccount(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccountsExpenseAccount(expenseAccount));
        target.setExpenseAccounts(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccounts(expenseAccounts));
      }
      
      target.setItemDescription(source.getItemDescription());
      target.setItemNumber(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemItemNumber(source.getItemNumber()));
      target.setQuantity(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemQuantity(source.getQuantity()));
      target.setQuantityDelivered(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemQuantityDelivered(source.getQuantityDelivered()));

      if (StringUtils.isNotBlank(source.getUnitCost())) {
        MonetaryAmountType monetaryAmountType = new MonetaryAmountType();
        monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmountType.setValue(source.getUnitCost());
        target.setUnitCost(objectFactory.createPurchaseOrderTypePurchasingItemsPurchasingItemUnitCost(monetaryAmountType));
      }
    }
  }

  @Override
  public void toHitsModel(sif.dd.au30.model.PurchaseOrderType.PurchasingItems.PurchasingItem source, PurchasingItem target) {
    if (source != null && target != null) {
      ExpenseAccounts expenseAccounts = getJAXBValue(source.getExpenseAccounts());
      ExpenseAccount expenseAccount = null;
      if (expenseAccounts != null) {
        expenseAccount = getJAXBValue(expenseAccounts.getExpenseAccount());
      }
      target.setExpenseAccount(expenseAccountConverter.toHitsModel(expenseAccount));
      if (target.getExpenseAccount() != null) {
        target.getExpenseAccount().setPurchasingItem(target);
      }
      target.setItemDescription(source.getItemDescription());
      target.setItemNumber(getJAXBValue(source.getItemNumber()));
      target.setQuantity(getJAXBValue(source.getQuantity()));
      target.setQuantityDelivered(getJAXBValue(source.getQuantityDelivered()));

      MonetaryAmountType monetaryAmountType = getJAXBValue(source.getUnitCost());
      if (monetaryAmountType != null) {
        target.setUnitCost(monetaryAmountType.getValue());
      }
    }
  }

}
