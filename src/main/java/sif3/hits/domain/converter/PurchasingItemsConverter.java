package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.ExpenseAccountType;
import sif.dd.au30.model.ExpenseAccountsType;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.PurchasingItemType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PurchasingItem;
import sif3.hits.utils.UsesConstants;

@Component
public class PurchasingItemsConverter extends HitsConverter<PurchasingItemType, PurchasingItem> implements UsesConstants {

    @Autowired
    private ExpenseAccountConverter expenseAccountConverter;

    public PurchasingItemsConverter() {
        super(PurchasingItemType.class, PurchasingItem.class);
    }

    @Override
    public void toSifModel(PurchasingItem source, PurchasingItemType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            if (source.getExpenseAccount() != null) {
                ExpenseAccountsType expenseAccounts = objectFactory.createExpenseAccountsType();
                ExpenseAccountType expenseAccount = expenseAccountConverter.toSifModel(source.getExpenseAccount());
                expenseAccounts.getExpenseAccount().add(expenseAccount);
                target.setExpenseAccounts(objectFactory.createPurchasingItemTypeExpenseAccounts(expenseAccounts));
            }

            target.setItemDescription(source.getItemDescription());
            target.setItemNumber(objectFactory.createPurchasingItemTypeItemNumber(source.getItemNumber()));
            target.setQuantity(objectFactory.createPurchasingItemTypeQuantity(source.getQuantity()));
            target.setQuantityDelivered(objectFactory.createPurchasingItemTypeQuantityDelivered(source.getQuantityDelivered()));

            if (StringUtils.isNotBlank(source.getUnitCost())) {
                MonetaryAmountType monetaryAmountType = objectFactory.createMonetaryAmountType();
                monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
                monetaryAmountType.setValue(source.getUnitCost());
                target.setUnitCost(objectFactory.createPurchasingItemTypeUnitCost(monetaryAmountType));
            }
        }
    }

    @Override
    public void toHitsModel(PurchasingItemType source, PurchasingItem target) {
        if (source != null && target != null) {
            ExpenseAccountsType expenseAccounts = getJAXBValue(source.getExpenseAccounts());
            ExpenseAccountType expenseAccount = null;
            if (expenseAccounts != null && !expenseAccounts.getExpenseAccount().isEmpty()) {
                expenseAccount = expenseAccounts.getExpenseAccount().get(0);
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
