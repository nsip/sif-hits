package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.JournalType;
import sif.dd.au30.model.JournalType.OriginatingTransactionRefId;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Journal;
import sif3.hits.utils.UsesConstants;

@Component
public class JournalConverter extends HitsConverter<JournalType, Journal>implements UsesConstants {

  public JournalConverter() {
    super(JournalType.class, Journal.class);
  }

  @Override
  public void toSifModel(Journal source, JournalType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());

      if (StringUtils.isNotBlank(source.getAmount())) {
        MonetaryAmountType monetaryAmount = objectFactory.createMonetaryAmountType();
        monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
        monetaryAmount.setValue(source.getAmount());
        target.setAmount(monetaryAmount);
      }
      target.setApprovedBy(objectFactory.createJournalTypeApprovedBy(source.getApprovedBy()));
      target.setApprovedDate(objectFactory.createJournalTypeApprovedDate(getDateValue(source.getApprovedDate())));
      target.setCreatedBy(objectFactory.createJournalTypeCreatedBy(source.getCreatedBy()));
      target.setCreatedDate(objectFactory.createJournalTypeCreatedDate(getDateValue(source.getCreatedDate())));
      target.setCreditFinancialAccountRefId(source.getCreditFinancialAccountRefId());
      target.setDebitFinancialAccountRefId(source.getDebitFinancialAccountRefId());
      target.setGSTCodeOriginal(objectFactory.createJournalTypeGSTCodeOriginal(source.getGSTCodeOriginal()));
      target.setGSTCodeReplacement(objectFactory.createJournalTypeGSTCodeReplacement(source.getGSTCodeReplacement()));
      target.setNote(objectFactory.createJournalTypeNote(source.getNote()));

      if (StringUtils.isNotBlank(source.getOriginatingTransactionRefId()) || StringUtils.isNotBlank(source.getOriginationTransactionSIFRefObject())) {
        OriginatingTransactionRefId originatingTransactionRefId = objectFactory.createJournalTypeOriginatingTransactionRefId();
        originatingTransactionRefId.setValue(source.getOriginatingTransactionRefId());
        originatingTransactionRefId.setSIFRefObject(source.getOriginationTransactionSIFRefObject());
        target.setOriginatingTransactionRefId(objectFactory.createJournalTypeOriginatingTransactionRefId(originatingTransactionRefId));
      }
    }
  }

  @Override
  public void toHitsModel(JournalType source, Journal target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());

      if (source.getAmount() != null) {
        target.setAmount(source.getAmount().getValue());
      }
      target.setApprovedBy(getJAXBValue(source.getApprovedBy()));
      target.setApprovedDate(getDateValue(getJAXBValue(source.getApprovedDate())));
      target.setCreatedBy(getJAXBValue(source.getCreatedBy()));
      target.setCreatedDate(getDateValue(getJAXBValue(source.getCreatedDate())));
      target.setCreditFinancialAccountRefId(source.getCreditFinancialAccountRefId());
      target.setDebitFinancialAccountRefId(source.getDebitFinancialAccountRefId());
      target.setGSTCodeOriginal(getJAXBValue(source.getGSTCodeOriginal()));
      target.setGSTCodeReplacement(getJAXBValue(source.getGSTCodeReplacement()));
      target.setNote(getJAXBValue(source.getNote()));

      OriginatingTransactionRefId originatingTransactionRefId = getJAXBValue(source.getOriginatingTransactionRefId());
      if (originatingTransactionRefId != null) {
        target.setOriginatingTransactionRefId(originatingTransactionRefId.getValue());
        target.setOriginationTransactionSIFRefObject(originatingTransactionRefId.getSIFRefObject());
      }
    }
  }

}
