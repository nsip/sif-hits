package sif3.hits.domain.converter;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.PurchaseOrderType;
import sif.dd.au30.model.PurchasingItemsType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PurchaseOrder;
import sif3.hits.domain.model.PurchasingItem;
import sif3.hits.utils.UsesConstants;

@Component
public class PurchaseOrderConverter extends HitsConverter<PurchaseOrderType, PurchaseOrder> implements UsesConstants {

    @Autowired
    private PurchasingItemsConverter purchasingItemsConverter;

    public PurchaseOrderConverter() {
        super(PurchaseOrderType.class, PurchaseOrder.class);
    }

    @Override
    public void toSifModel(PurchaseOrder source, PurchaseOrderType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setRefId(source.getRefId());
            target.setLocalId(objectFactory.createPurchaseOrderTypeLocalId(source.getLocalId()));
            target.setChargedLocationInfoRefId(objectFactory.createPurchaseOrderTypeChargedLocationInfoRefId(source.getLocationInfoRefId()));
            target.setCreationDate(objectFactory.createPurchaseOrderTypeCreationDate(getDateValue(source.getCreationDate())));
            target.setEmployeePersonalRefId(objectFactory.createPurchaseOrderTypeEmployeePersonalRefId(source.getEmployeePersonalRefId()));
            target.setFormNumber(source.getFormNumber());
            target.setFullyDelivered(objectFactory.createPurchaseOrderTypeFullyDelivered(getEnumValue(source.getFullyDelivered(), AUCodeSetsYesOrNoCategoryType.class)));

            if (source.getPurchasingItems() != null && !source.getPurchasingItems().isEmpty()) {
                PurchasingItemsType purchasingItems = objectFactory.createPurchasingItemsType();
                purchasingItems.getPurchasingItem().addAll(purchasingItemsConverter.toSifModelList(source.getPurchasingItems()));
                target.setPurchasingItems(purchasingItems);
            }

            if (StringUtils.isNotBlank(source.getTaxAmount())) {
                MonetaryAmountType monetaryAmountType = objectFactory.createMonetaryAmountType();
                monetaryAmountType.setValue(getBigDecimalValue(source.getTaxAmount()));
                monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
                target.setTaxAmount(objectFactory.createPurchaseOrderTypeTaxAmount(monetaryAmountType));
            }

            target.setTaxRate(objectFactory.createPurchaseOrderTypeTaxRate(getBigDecimalValue(source.getTaxRate())));
            target.setUpdateDate(objectFactory.createPurchaseOrderTypeUpdateDate(getDateValue(source.getUpdateDate())));
            target.setVendorInfoRefId(source.getVendorInfoRefId());
        }
    }

    @Override
    public void toHitsModel(PurchaseOrderType source, PurchaseOrder target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setLocalId(getJAXBValue(source.getLocalId()));
            target.setLocationInfoRefId(getJAXBValue(source.getChargedLocationInfoRefId()));
            target.setCreationDate(getDateValue(getJAXBValue(source.getCreationDate())));
            target.setEmployeePersonalRefId(getJAXBValue(source.getEmployeePersonalRefId()));
            target.setFormNumber(source.getFormNumber());
            target.setFullyDelivered(getJAXBEnumValue(source.getFullyDelivered()));

            if (target.getPurchasingItems() != null) {
                target.getPurchasingItems().clear();
            } else {
                target.setPurchasingItems(new HashSet<PurchasingItem>());
            }

            PurchasingItemsType purchasingItems = source.getPurchasingItems();
            if (purchasingItems != null && purchasingItems.getPurchasingItem() != null && !purchasingItems.getPurchasingItem().isEmpty()) {
                target.getPurchasingItems().addAll(purchasingItemsConverter.toHitsModelList(purchasingItems.getPurchasingItem()));
                for (PurchasingItem purchasingItem : target.getPurchasingItems()) {
                    purchasingItem.setPurchaseOrder(target);
                }
            }

            MonetaryAmountType monetaryAmountType = getJAXBValue(source.getTaxAmount());
            if (monetaryAmountType != null) {
                target.setTaxAmount(getBigDecimalValue(monetaryAmountType.getValue()));
            }

            target.setTaxRate(getBigDecimalValue(getJAXBValue(source.getTaxRate())));
            target.setUpdateDate(getDateValue(getJAXBValue(source.getUpdateDate())));
            target.setVendorInfoRefId(source.getVendorInfoRefId());
        }
    }
}
