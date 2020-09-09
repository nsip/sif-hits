package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.HoldInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LibraryTransactionHold;

@Component
public class LibraryTransactionHoldConverter extends HitsConverter<HoldInfoType, LibraryTransactionHold> {

	public LibraryTransactionHoldConverter() {
		super(HoldInfoType.class, LibraryTransactionHold.class);
	}

	@Override
	public void toSifModel(LibraryTransactionHold source, HoldInfoType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setDatePlaced(getDateValue(source.getDatePlaced()));
			target.setDateNeeded(objectFactory.createHoldInfoTypeDateNeeded(getDateValue(source.getDateNeeded())));
			target.setReservationExpiry(
					objectFactory.createHoldInfoTypeReservationExpiry(getDateValue(source.getReservationExpiry())));
			target.setMadeAvailable(
					objectFactory.createHoldInfoTypeMadeAvailable(getDateValue(source.getMadeAvailable())));
			target.setExpires(objectFactory.createHoldInfoTypeExpires(getDateValue(source.getExpires())));
			target.setType(source.getType());
		}
	}

	@Override
	public void toHitsModel(HoldInfoType source, LibraryTransactionHold target) {
		if (source != null && target != null) {
			target.setDatePlaced(getDateValue(source.getDatePlaced()));
			target.setDateNeeded(getDateValue(getJAXBValue(source.getDateNeeded())));
			target.setReservationExpiry(getDateValue(getJAXBValue(source.getReservationExpiry())));
			target.setMadeAvailable(getDateValue(getJAXBValue(source.getMadeAvailable())));
			target.setExpires(getDateValue(getJAXBValue(source.getExpires())));
			target.setType(source.getType());
		}
	}

}
