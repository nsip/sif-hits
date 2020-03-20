package sif3.hits.domain.converter;

import sif.dd.au30.model.DebitOrCreditAmountType;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.PaymentReceiptLineType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PaymentReceiptLine;
import sif3.hits.utils.UsesConstants;

public class PaymentReceiptLineConverter extends HitsConverter<PaymentReceiptLineType, PaymentReceiptLine>
		implements UsesConstants {

	public PaymentReceiptLineConverter() {
		super(PaymentReceiptLineType.class, PaymentReceiptLine.class);
	}

	@Override
	public void toSifModel(PaymentReceiptLine source, PaymentReceiptLineType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setInvoiceRefId(objectFactory.createPaymentReceiptLineTypeInvoiceRefId(source.getInvoiceRefId()));
			target.setLocalId(objectFactory.createPaymentReceiptLineTypeLocalId(source.getLocalId()));
			target.setLocalPaymentReceiptLineId(objectFactory
					.createPaymentReceiptLineTypeLocalPaymentReceiptLineId(source.getLocalPaymentReceiptLineId()));
			DebitOrCreditAmountType transactionAmount = objectFactory.createDebitOrCreditAmountType();
			transactionAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
			transactionAmount.setType(source.getTransactionAmountType());
			transactionAmount.setValue(getBigDecimalValue(source.getTransactionAmount()));
			target.setTransactionAmount(transactionAmount);
			target.setFinancialAccountRefId(
					objectFactory.createPaymentReceiptLineTypeFinancialAccountRefId(source.getFinancialAccountRefId()));
			target.setAccountCode(objectFactory.createPaymentReceiptLineTypeAccountCode(source.getAccountCode()));
			target.setTransactionDescription(objectFactory
					.createPaymentReceiptLineTypeTransactionDescription(source.getTransactionDescription()));
			target.setTaxRate(
					objectFactory.createPaymentReceiptLineTypeTaxRate(getBigDecimalValue(source.getTaxRate())));
			if (source.getTaxAmount() != null) {
				MonetaryAmountType taxAmount = objectFactory.createMonetaryAmountType();
				taxAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
				taxAmount.setValue(getBigDecimalValue(source.getTaxAmount()));
				target.setTaxAmount(objectFactory.createPaymentReceiptLineTypeTaxAmount(taxAmount));
			}
		}
	}

	@Override
	public void toHitsModel(PaymentReceiptLineType source, PaymentReceiptLine target) {
		if (source != null && target != null) {
			target.setInvoiceRefId(getJAXBValue(source.getInvoiceRefId()));
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setLocalPaymentReceiptLineId(getJAXBValue(source.getLocalPaymentReceiptLineId()));
			DebitOrCreditAmountType transactionAmount = source.getTransactionAmount();
			target.setTransactionAmount(getBigDecimalValue(transactionAmount.getValue()));
			target.setTransactionAmountType(transactionAmount.getType());
			target.setFinancialAccountRefId(getJAXBValue(source.getFinancialAccountRefId()));
			target.setAccountCode(getJAXBValue(source.getAccountCode()));
			target.setTransactionDescription(getJAXBValue(source.getTransactionDescription()));
			target.setTaxRate(getBigDecimalValue(getJAXBValue(source.getTaxRate())));
			MonetaryAmountType taxAmount = getJAXBValue(source.getTaxAmount());
			if (taxAmount != null) {
				target.setTaxAmount(getBigDecimalValue(taxAmount.getValue()));
			}
		}
	}

}
