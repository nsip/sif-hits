package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.JournalAdjustmentType;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.JournalAdjustment;
import sif3.hits.utils.UsesConstants;

@Component
public class JournalAdjustmentConverter extends HitsConverter<JournalAdjustmentType, JournalAdjustment>
		implements UsesConstants {

	public JournalAdjustmentConverter() {
		super(JournalAdjustmentType.class, JournalAdjustment.class);
	}

	@Override
	public void toSifModel(JournalAdjustment source, JournalAdjustmentType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setDebitFinancialAccountRefId(objectFactory
					.createJournalAdjustmentTypeDebitFinancialAccountRefId(source.getDebitFinancialAccountRefId()));
			target.setCreditFinancialAccountRefId(objectFactory
					.createJournalAdjustmentTypeCreditFinancialAccountRefId(source.getCreditFinancialAccountRefId()));
			target.setDebitAccountCode(
					objectFactory.createJournalAdjustmentTypeDebitAccountCode(source.getDebitAccountCode()));
			target.setCreditAccountCode(
					objectFactory.createJournalAdjustmentTypeCreditAccountCode(source.getCreditAccountCode()));
			target.setGSTCodeOriginal(
					objectFactory.createJournalAdjustmentTypeGSTCodeOriginal(source.getGstCodeOriginal()));
			target.setGSTCodeReplacement(
					objectFactory.createJournalAdjustmentTypeGSTCodeReplacement(source.getGstCodeReplacement()));

			MonetaryAmountType lineAdjustmentAmount = null;
			if (source.getLineAdjustmentAmount() != null) {
				lineAdjustmentAmount = objectFactory.createMonetaryAmountType();
				lineAdjustmentAmount.setCurrency(DEFAULT_CURRENCY_ENUM);
				lineAdjustmentAmount.setValue(getBigDecimalValue(source.getLineAdjustmentAmount()));
			}
			target.setLineAdjustmentAmount(lineAdjustmentAmount);
		}
	}

	@Override
	public void toHitsModel(JournalAdjustmentType source, JournalAdjustment target) {
		if (source != null && target != null) {
			target.setDebitFinancialAccountRefId(getJAXBValue(source.getDebitFinancialAccountRefId()));
			target.setCreditFinancialAccountRefId(getJAXBValue(source.getCreditFinancialAccountRefId()));
			target.setDebitAccountCode(getJAXBValue(source.getDebitAccountCode()));
			target.setCreditAccountCode(getJAXBValue(source.getCreditAccountCode()));
			target.setGstCodeOriginal(getJAXBValue(source.getGSTCodeOriginal()));
			target.setGstCodeReplacement(getJAXBValue(source.getGSTCodeReplacement()));
			target.setLineAdjustmentAmount(null);
			MonetaryAmountType lineAdjustmentAmount = source.getLineAdjustmentAmount();
			if (lineAdjustmentAmount != null) {
				target.setLineAdjustmentAmount(getBigDecimalValue(lineAdjustmentAmount.getValue()));
			}
		}
	}

}
