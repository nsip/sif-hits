package sif3.hits.domain.converter;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.DebitOrCreditAmountType;
import sif.dd.au30.model.FinancialAccountRefIdListType;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.PaymentReceiptType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PaymentReceipt;
import sif3.hits.utils.UsesConstants;

@Component
public class PaymentReceiptConverter extends HitsConverter<PaymentReceiptType, PaymentReceipt> implements UsesConstants {

  public PaymentReceiptConverter() {
    super(PaymentReceiptType.class, PaymentReceipt.class);
  }

  @Override
  public void toSifModel(PaymentReceipt source, PaymentReceiptType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      target.setAccountingPeriod(objectFactory.createPaymentReceiptTypeAccountingPeriod(source.getAccountingPeriod()));
      target.setChargedLocationInfoRefId(objectFactory.createPaymentReceiptTypeChargedLocationInfoRefId(source.getLocationInfoRefId()));
      target.setChequeNumber(objectFactory.createPaymentReceiptTypeChequeNumber(source.getChequeNumber()));
      target.setDebtorRefId(objectFactory.createPaymentReceiptTypeDebtorRefId(source.getDebtorRefId()));

      if (source.getFinancialAccountRefIds() != null && !source.getFinancialAccountRefIds().isEmpty()) {
        FinancialAccountRefIdListType financialAccountRefIdList = objectFactory.createFinancialAccountRefIdListType();
        financialAccountRefIdList.getFinancialAccountRefId().addAll(source.getFinancialAccountRefIds());
        target.setFinancialAccountRefIdList(objectFactory.createPaymentReceiptTypeFinancialAccountRefIdList(financialAccountRefIdList));
      }

      target.setInvoiceRefId(objectFactory.createPaymentReceiptTypeInvoiceRefId(source.getInvoiceRefId()));

      if (StringUtils.isNotBlank(source.getReceivedAmount()) || StringUtils.isNotBlank(source.getReceivedAmountType())) {
        DebitOrCreditAmountType receivedAmount = objectFactory.createDebitOrCreditAmountType();
        receivedAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
        receivedAmount.setValue(source.getReceivedAmount());
        receivedAmount.setType(source.getReceivedAmountType());
        target.setTransactionAmount(receivedAmount);
      }

      target.setReceivedTransactionId(source.getReceivedTransactionId());

      if (StringUtils.isNotBlank(source.getTaxAmount())) {
        MonetaryAmountType monetaryAmountType = objectFactory.createMonetaryAmountType();
        monetaryAmountType.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmountType.setValue(source.getTaxAmount());
        target.setTaxAmount(objectFactory.createPaymentReceiptTypeTaxAmount(monetaryAmountType));
      }

      target.setTaxRate(objectFactory.createPaymentReceiptTypeTaxRate(getBigDecimalValue(source.getTaxRate())));
      target.setTransactionDate(getDateValue(source.getTransactionDate()));
      target.setTransactionDescription(objectFactory.createPaymentReceiptTypeTransactionDescription(source.getTransactionDescription()));
      target.setTransactionMethod(objectFactory.createPaymentReceiptTypeTransactionMethod(source.getTransactionMethod()));
      target.setTransactionNote(objectFactory.createPaymentReceiptTypeTransactionNote(source.getTransactionNote()));
      target.setTransactionType(source.getTransactionType());
      target.setVendorInfoRefId(objectFactory.createPaymentReceiptTypeVendorInfoRefId(source.getVendorInfoRefId()));
    }
  }

  @Override
  public void toHitsModel(PaymentReceiptType source, PaymentReceipt target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setAccountingPeriod(getJAXBValue(source.getAccountingPeriod()));
      target.setLocationInfoRefId(getJAXBValue(source.getChargedLocationInfoRefId()));
      target.setChequeNumber(getJAXBValue(source.getChequeNumber()));
      target.setDebtorRefId(getJAXBValue(source.getDebtorRefId()));

      if (target.getFinancialAccountRefIds() != null) {
        target.getFinancialAccountRefIds().clear();
      } else {
        target.setFinancialAccountRefIds(new HashSet<String>());
      }

      FinancialAccountRefIdListType financialAccountRefIdList = getJAXBValue(source.getFinancialAccountRefIdList());
      if (financialAccountRefIdList != null && financialAccountRefIdList.getFinancialAccountRefId() != null
          && !financialAccountRefIdList.getFinancialAccountRefId().isEmpty()) {
        target.getFinancialAccountRefIds().addAll(financialAccountRefIdList.getFinancialAccountRefId());
      }

      target.setInvoiceRefId(getJAXBValue(source.getInvoiceRefId()));

      DebitOrCreditAmountType receivedAmount = source.getTransactionAmount();
      if (receivedAmount != null) {
        target.setReceivedAmount(receivedAmount.getValue());
        target.setReceivedAmountType(receivedAmount.getType());
      }

      target.setReceivedTransactionId(source.getReceivedTransactionId());

      MonetaryAmountType monetaryAmountType = getJAXBValue(source.getTaxAmount());
      if (monetaryAmountType != null) {
        target.setTaxAmount(monetaryAmountType.getValue());
      }

      target.setTaxRate(getBigDecimalValue(getJAXBValue(source.getTaxRate())));
      target.setTransactionDate(getDateValue(source.getTransactionDate()));
      target.setTransactionDescription(getJAXBValue(source.getTransactionDescription()));
      target.setTransactionMethod(getJAXBValue(source.getTransactionMethod()));
      target.setTransactionNote(getJAXBValue(source.getTransactionNote()));
      target.setTransactionType(source.getTransactionType());
      target.setVendorInfoRefId(getJAXBValue(source.getVendorInfoRefId()));
    }
  }
}
