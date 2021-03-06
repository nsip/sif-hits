package sif3.hits.domain.converter;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.AccountCodeListType;
import sif.dd.au30.model.DebitOrCreditAmountType;
import sif.dd.au30.model.FinancialAccountRefIdListType;
import sif.dd.au30.model.InvoiceType;
import sif.dd.au30.model.InvoiceType.InvoicedEntity;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Invoice;
import sif3.hits.utils.UsesConstants;

@Component
public class InvoiceConverter extends HitsConverter<InvoiceType, Invoice> implements UsesConstants {

	public InvoiceConverter() {
		super(InvoiceType.class, Invoice.class);
	}

	@Override
	public void toSifModel(Invoice source, InvoiceType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			if (StringUtils.isNotBlank(source.getInvoicedEntity())
					|| StringUtils.isNotBlank(source.getInvoicedEntitySIFRefObject())) {
				InvoicedEntity invoicedEntity = objectFactory.createInvoiceTypeInvoicedEntity();
				invoicedEntity.setValue(source.getInvoicedEntity());
				invoicedEntity.setSIFRefObject(source.getInvoicedEntitySIFRefObject());
				target.setInvoicedEntity(invoicedEntity);
			}

			target.setLocalId(objectFactory.createInvoiceTypeLocalId(source.getLocalId()));

			target.setBillingDate(getDateValue(source.getBillingDate()));
			target.setTransactionDescription(source.getTransactionDescription());

			if (StringUtils.isNotBlank(source.getBilledAmount())
					|| StringUtils.isNotBlank(source.getBilledAmountType())) {
				DebitOrCreditAmountType billedAmount = objectFactory.createDebitOrCreditAmountType();
				billedAmount.setValue(getBigDecimalValue(source.getBilledAmount()));
				billedAmount.setType(source.getBilledAmountType());
				billedAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
				target.setBilledAmount(billedAmount);
			}

			target.setLedger(source.getLedger());
			target.setChargedLocationInfoRefId(
					objectFactory.createInvoiceTypeChargedLocationInfoRefId(source.getLocationInfoRefId()));

			target.setTaxRate(objectFactory.createInvoiceTypeTaxRate(getBigDecimalValue(source.getTaxRate())));
			target.setTaxType(objectFactory.createInvoiceTypeTaxType(source.getTaxType()));

			if (StringUtils.isNotBlank(source.getTaxAmount())) {
				MonetaryAmountType monetaryAmountType = objectFactory.createMonetaryAmountType();
				monetaryAmountType.setValue(getBigDecimalValue(source.getTaxAmount()));
				monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
				target.setTaxAmount(objectFactory.createInvoiceTypeTaxAmount(monetaryAmountType));
			}

			target.setCreatedBy(objectFactory.createInvoiceTypeCreatedBy(source.getCreatedBy()));
			target.setApprovedBy(objectFactory.createInvoiceTypeApprovedBy(source.getApprovedBy()));
			target.setItemDetail(objectFactory.createInvoiceTypeItemDetail(source.getItemDetail()));
			target.setDueDate(objectFactory.createInvoiceTypeDueDate(getDateValue(source.getDueDate())));
			target.setAccountingPeriod(objectFactory.createInvoiceTypeAccountingPeriod(source.getAccountingPeriod()));
			target.setRelatedPurchaseOrderRefId(
					objectFactory.createInvoiceTypeRelatedPurchaseOrderRefId(source.getRelatedPurchaseOrderRefId()));
			target.setVoluntary(objectFactory.createInvoiceTypeVoluntary(
					getEnumValue(source.getVoluntary(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setFormNumber(objectFactory.createInvoiceTypeFormNumber(source.getFormNumber()));

			if (source.getFinancialAccountRefIds() != null && !source.getFinancialAccountRefIds().isEmpty()) {
				FinancialAccountRefIdListType financialAccountRefIdList = objectFactory
						.createFinancialAccountRefIdListType();
				financialAccountRefIdList.getFinancialAccountRefId().addAll(source.getFinancialAccountRefIds());
				target.setFinancialAccountRefIdList(
						objectFactory.createInvoiceTypeFinancialAccountRefIdList(financialAccountRefIdList));
			}

			if (source.getAccountCodes() != null && !source.getAccountCodes().isEmpty()) {
				AccountCodeListType accountCodeListType = objectFactory.createAccountCodeListType();
				accountCodeListType.getAccountCode().addAll(source.getAccountCodes());
				target.setAccountCodeList(objectFactory.createInvoiceTypeAccountCodeList(accountCodeListType));
			}
		}
	}

	@Override
	public void toHitsModel(InvoiceType source, Invoice target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			if (source.getInvoicedEntity() != null) {
				target.setInvoicedEntity(source.getInvoicedEntity().getValue());
				target.setInvoicedEntitySIFRefObject(source.getInvoicedEntity().getSIFRefObject());
			} else {
				target.setInvoicedEntity(null);
				target.setInvoicedEntitySIFRefObject(null);
			}
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setBillingDate(getDateValue(source.getBillingDate()));
			target.setTransactionDescription(source.getTransactionDescription());

			if (source.getBilledAmount() != null) {
				target.setBilledAmount(getBigDecimalValue(source.getBilledAmount().getValue()));
				target.setBilledAmountType(source.getBilledAmount().getType());
			} else {
				target.setBilledAmount(null);
				target.setBilledAmountType(null);
			}

			target.setLedger(source.getLedger());
			target.setLocationInfoRefId(getJAXBValue(source.getChargedLocationInfoRefId()));
			target.setTaxRate(getBigDecimalValue(getJAXBValue(source.getTaxRate())));
			target.setTaxType(getJAXBValue(source.getTaxType()));

			MonetaryAmountType taxAmount = getJAXBValue(source.getTaxAmount());
			if (taxAmount != null) {
				target.setTaxAmount(getBigDecimalValue(taxAmount.getValue()));
			} else {
				target.setTaxAmount(null);
			}

			target.setCreatedBy(getJAXBValue(source.getCreatedBy()));
			target.setApprovedBy(getJAXBValue(source.getApprovedBy()));
			target.setItemDetail(getJAXBValue(source.getItemDetail()));
			target.setDueDate(getDateValue(getJAXBValue(source.getDueDate())));
			target.setAccountingPeriod(getJAXBValue(source.getAccountingPeriod()));
			target.setRelatedPurchaseOrderRefId(getJAXBValue(source.getRelatedPurchaseOrderRefId()));
			target.setVoluntary(getJAXBEnumValue(source.getVoluntary()));
			target.setFormNumber(getJAXBValue(source.getFormNumber()));

			if (target.getFinancialAccountRefIds() == null) {
				target.setFinancialAccountRefIds(new ArrayList<>());
			}
			target.getFinancialAccountRefIds().clear();
			FinancialAccountRefIdListType financialAccountRefIdList = getJAXBValue(
					source.getFinancialAccountRefIdList());
			if (financialAccountRefIdList != null) {
				target.getFinancialAccountRefIds().addAll(financialAccountRefIdList.getFinancialAccountRefId());
			}

			if (target.getAccountCodes() == null) {
				target.setAccountCodes(new ArrayList<>());
			}
			target.getAccountCodes().clear();
			AccountCodeListType accountCodeList = getJAXBValue(source.getAccountCodeList());
			if (accountCodeList != null) {
				target.getAccountCodes().addAll(accountCodeList.getAccountCode());
			}
		}
	}

}
