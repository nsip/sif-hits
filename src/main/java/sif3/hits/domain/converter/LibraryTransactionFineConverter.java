package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FineInfoType;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LibraryTransactionFine;

@Component
public class LibraryTransactionFineConverter extends HitsConverter<FineInfoType, LibraryTransactionFine> {

	public LibraryTransactionFineConverter() {
		super(FineInfoType.class, LibraryTransactionFine.class);
	}

	@Override
	public void toSifModel(LibraryTransactionFine source, FineInfoType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setAssessed(getCalendarValue(source.getAssessed()));
			target.setDescription(objectFactory.createFineInfoTypeDescription(source.getDescription()));
			target.setAmount(getMonetaryAmount(source.getAmount(), source.getCurrency()));
			target.setReference(objectFactory.createFineInfoTypeReference(source.getReference()));
			target.setType(source.getType());
		}
	}

	@Override
	public void toHitsModel(FineInfoType source, LibraryTransactionFine target) {
		if (source != null && target != null) {
			target.setAssessed(getCalendarValue(source.getAssessed()));
			target.setDescription(getJAXBValue(source.getDescription()));
			MonetaryAmountType monetaryAmountType = getMonetaryAmount(source.getAmount());
			target.setAmount(getBigDecimalValue(monetaryAmountType.getValue()));
			target.setCurrency(getEnumValue(monetaryAmountType.getCurrency()));
			target.setReference(getJAXBValue(source.getReference()));
			target.setType(source.getType());
		}
	}

}
