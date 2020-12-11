package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.ElectronicIdType;
import sif.dd.au30.model.LibraryItemInfoType;
import sif.dd.au30.model.MonetaryAmountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LibraryTransactionItem;

@Component
public class LibraryTransactionItemConverter extends HitsConverter<LibraryItemInfoType, LibraryTransactionItem> {

	public LibraryTransactionItemConverter() {
		super(LibraryItemInfoType.class, LibraryTransactionItem.class);
	}

	@Override
	public void toSifModel(LibraryTransactionItem source, LibraryItemInfoType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			
			target.setTitle(source.getTitle());
			target.setAuthor(objectFactory.createLibraryItemInfoTypeAuthor(source.getAuthor()));
			target.setElectronicId(objectFactory.createLibraryItemInfoTypeElectronicId(getElectronicId(source.getElectronicId(), source.getElectronicIdType())));
			target.setCallNumber(objectFactory.createLibraryItemInfoTypeCallNumber(source.getCallNumber()));
			target.setISBN(objectFactory.createLibraryItemInfoTypeISBN(source.getIsbn()));
			target.setCost(objectFactory.createLibraryItemInfoTypeCost(getMonetaryAmount(source.getCost(), source.getCostCurrency())));
			target.setReplacementCost(objectFactory.createLibraryItemInfoTypeReplacementCost(getMonetaryAmount(source.getReplacementCost(), source.getReplacementCostCurrency())));
			target.setType(source.getType());
		}
	}

	@Override
	public void toHitsModel(LibraryItemInfoType source, LibraryTransactionItem target) {
		if (source != null && target != null) {
			target.setTitle(source.getTitle());
			target.setAuthor(getJAXBValue(source.getAuthor()));
			
			ElectronicIdType electronicIdType = getElectronicId(source.getElectronicId());
			target.setElectronicId(electronicIdType.getValue());
			target.setElectronicIdType(getEnumValue(electronicIdType.getType()));
			
			target.setCallNumber(getJAXBValue(source.getCallNumber()));
			target.setIsbn(getJAXBValue(source.getISBN()));
			
			MonetaryAmountType cost = getMonetaryAmount(source.getCost());
			target.setCost(getBigDecimalValue(cost.getValue()));
			target.setCostCurrency(getEnumValue(cost.getCurrency()));
			
			MonetaryAmountType replacementCost = getMonetaryAmount(source.getReplacementCost());
			target.setReplacementCost(getBigDecimalValue(replacementCost.getValue()));
			target.setReplacementCostCurrency(getEnumValue(replacementCost.getCurrency()));
			
			target.setType(source.getType());
		}
	}

}
