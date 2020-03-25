package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.JournalAdjustmentListType;
import sif.dd.au30.model.JournalAdjustmentType;
import sif.dd.au30.model.JournalType;
import sif.dd.au30.model.JournalType.OriginatingTransactionRefId;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Journal;
import sif3.hits.domain.model.JournalAdjustment;
import sif3.hits.utils.UsesConstants;

@Component
public class JournalConverter extends HitsConverter<JournalType, Journal> implements UsesConstants {

	@Autowired
	JournalAdjustmentConverter journalAdjustmentConverter;

	public JournalConverter() {
		super(JournalType.class, Journal.class);
	}

	@Override
	public void toSifModel(Journal source, JournalType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setLocalId(objectFactory.createJournalTypeLocalId(source.getLocalId()));

			if (StringUtils.isNotBlank(source.getAmount())) {
				MonetaryAmountType monetaryAmount = objectFactory.createMonetaryAmountType();
				monetaryAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
				monetaryAmount.setValue(getBigDecimalValue(source.getAmount()));
				target.setAmount(monetaryAmount);
			}
			target.setApprovedBy(objectFactory.createJournalTypeApprovedBy(source.getApprovedBy()));
			target.setApprovedDate(objectFactory.createJournalTypeApprovedDate(getDateValue(source.getApprovedDate())));
			target.setCreatedBy(objectFactory.createJournalTypeCreatedBy(source.getCreatedBy()));
			target.setCreatedDate(objectFactory.createJournalTypeCreatedDate(getDateValue(source.getCreatedDate())));
			target.setCreditFinancialAccountRefId(objectFactory
					.createJournalTypeCreditFinancialAccountRefId(source.getCreditFinancialAccountRefId()));
			target.setCreditAccountCode(
					objectFactory.createJournalTypeCreditAccountCode(source.getCreditAccountCode()));

			target.setDebitFinancialAccountRefId(
					objectFactory.createJournalTypeDebitFinancialAccountRefId(source.getDebitFinancialAccountRefId()));
			target.setDebitAccountCode(objectFactory.createJournalTypeDebitAccountCode(source.getDebitAccountCode()));
			target.setGSTCodeOriginal(objectFactory.createJournalTypeGSTCodeOriginal(source.getGSTCodeOriginal()));
			target.setGSTCodeReplacement(
					objectFactory.createJournalTypeGSTCodeReplacement(source.getGSTCodeReplacement()));
			target.setNote(objectFactory.createJournalTypeNote(source.getNote()));

			if (StringUtils.isNotBlank(source.getOriginatingTransactionRefId())
					|| StringUtils.isNotBlank(source.getOriginationTransactionSIFRefObject())) {
				OriginatingTransactionRefId originatingTransactionRefId = objectFactory
						.createJournalTypeOriginatingTransactionRefId();
				originatingTransactionRefId.setValue(source.getOriginatingTransactionRefId());
				originatingTransactionRefId.setSIFRefObject(source.getOriginationTransactionSIFRefObject());
				target.setOriginatingTransactionRefId(
						objectFactory.createJournalTypeOriginatingTransactionRefId(originatingTransactionRefId));
			}

			List<JournalAdjustmentType> journalAdjustments = journalAdjustmentConverter
					.toSifModelList(source.getJournalAdjustments());
			if (journalAdjustments != null && !journalAdjustments.isEmpty()) {
				JournalAdjustmentListType journalAdjustmentList = objectFactory.createJournalAdjustmentListType();
				journalAdjustmentList.getJournalAdjustment().addAll(journalAdjustments);
				target.setJournalAdjustmentList(
						objectFactory.createJournalTypeJournalAdjustmentList(journalAdjustmentList));
			} else {
				target.setJournalAdjustmentList(null);
			}
		}
	}

	@Override
	public void toHitsModel(JournalType source, Journal target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setLocalId(getJAXBValue(source.getLocalId()));
			if (source.getAmount() != null) {
				target.setAmount(getBigDecimalValue(source.getAmount().getValue()));
			}
			target.setApprovedBy(getJAXBValue(source.getApprovedBy()));
			target.setApprovedDate(getDateValue(getJAXBValue(source.getApprovedDate())));
			target.setCreatedBy(getJAXBValue(source.getCreatedBy()));
			target.setCreatedDate(getDateValue(getJAXBValue(source.getCreatedDate())));
			target.setCreditFinancialAccountRefId(getJAXBValue(source.getCreditFinancialAccountRefId()));
			target.setCreditAccountCode(getJAXBValue(source.getCreditAccountCode()));
			target.setDebitFinancialAccountRefId(getJAXBValue(source.getDebitFinancialAccountRefId()));
			target.setDebitAccountCode(getJAXBValue(source.getDebitAccountCode()));
			target.setGSTCodeOriginal(getJAXBValue(source.getGSTCodeOriginal()));
			target.setGSTCodeReplacement(getJAXBValue(source.getGSTCodeReplacement()));
			target.setNote(getJAXBValue(source.getNote()));

			OriginatingTransactionRefId originatingTransactionRefId = getJAXBValue(
					source.getOriginatingTransactionRefId());
			if (originatingTransactionRefId != null) {
				target.setOriginatingTransactionRefId(originatingTransactionRefId.getValue());
				target.setOriginationTransactionSIFRefObject(originatingTransactionRefId.getSIFRefObject());
			}

			if (target.getJournalAdjustments() == null) {
				target.setJournalAdjustments(new ArrayList<>());
			}
			target.getJournalAdjustments().clear();
			JournalAdjustmentListType journalAdjustmentList = getJAXBValue(source.getJournalAdjustmentList());
			if (journalAdjustmentList != null) {
				List<JournalAdjustment> journalAdjustments = journalAdjustmentConverter
						.toHitsModelList(journalAdjustmentList.getJournalAdjustment());
				for (JournalAdjustment journalAdjustment : journalAdjustments) {
					journalAdjustment.setJournal(target);
					target.getJournalAdjustments().add(journalAdjustment);
				}

			}
		}
	}

}
