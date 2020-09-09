package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.CheckoutInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LibraryTransactionCheckout;

@Component
public class LibraryTransactionCheckoutConverter extends HitsConverter<CheckoutInfoType, LibraryTransactionCheckout> {

	public LibraryTransactionCheckoutConverter() {
		super(CheckoutInfoType.class, LibraryTransactionCheckout.class);
	}

	@Override
	public void toSifModel(LibraryTransactionCheckout source, CheckoutInfoType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setCheckedOutOn(getCalendarValue(source.getCheckedOutOn()));
			target.setReturnBy(getCalendarValue(source.getReturnBy()));
			target.setRenewalCount(
					objectFactory.createCheckoutInfoTypeRenewalCount(getLongValue(source.getRenewalCount())));
		}
	}

	@Override
	public void toHitsModel(CheckoutInfoType source, LibraryTransactionCheckout target) {
		if (source != null && target != null) {
			target.setCheckedOutOn(getCalendarValue(source.getCheckedOutOn()));
			target.setReturnBy(getCalendarValue(source.getReturnBy()));
			target.setRenewalCount(getLongValue(getJAXBValue(source.getRenewalCount())));
		}
	}
}
