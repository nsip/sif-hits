package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CheckoutInfoType;
import sif.dd.au30.model.FineInfoListType;
import sif.dd.au30.model.FineInfoType;
import sif.dd.au30.model.HoldInfoListType;
import sif.dd.au30.model.HoldInfoType;
import sif.dd.au30.model.LibraryItemInfoType;
import sif.dd.au30.model.LibraryTransactionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LibraryPatronTransaction;
import sif3.hits.domain.model.LibraryTransactionCheckout;
import sif3.hits.domain.model.LibraryTransactionFine;
import sif3.hits.domain.model.LibraryTransactionHold;
import sif3.hits.domain.model.LibraryTransactionItem;

@Component
public class LibraryPatronTransactionConverter extends HitsConverter<LibraryTransactionType, LibraryPatronTransaction> {

	@Autowired
	HitsConverter<LibraryItemInfoType, LibraryTransactionItem> itemConverter;

	@Autowired
	HitsConverter<CheckoutInfoType, LibraryTransactionCheckout> checkoutConverter;

	@Autowired
	HitsConverter<HoldInfoType, LibraryTransactionHold> holdConverter;

	@Autowired
	HitsConverter<FineInfoType, LibraryTransactionFine> fineConverter;

	public LibraryPatronTransactionConverter() {
		super(LibraryTransactionType.class, LibraryPatronTransaction.class);
	}

	@Override
	public void toSifModel(LibraryPatronTransaction source, LibraryTransactionType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setItemInfo(objectFactory
					.createLibraryTransactionTypeItemInfo(itemConverter.toSifModel(source.getTransactionItem())));
			target.setCheckoutInfo(objectFactory
					.createLibraryTransactionTypeCheckoutInfo(checkoutConverter.toSifModel(source.getCheckout())));

			List<HoldInfoType> holdInfoTypes = holdConverter.toSifModelList(source.getHoldList());
			HoldInfoListType holdInfoListType = null;
			if (!holdInfoTypes.isEmpty()) {
				holdInfoListType = objectFactory.createHoldInfoListType();
				holdInfoListType.getHoldInfo().addAll(holdInfoTypes);
			}
			target.setHoldInfoList(objectFactory.createLibraryTransactionTypeHoldInfoList(holdInfoListType));

			List<FineInfoType> fineInfoTypes = fineConverter.toSifModelList(source.getFineList());
			FineInfoListType fineInfoListType = null;
			if (!fineInfoTypes.isEmpty()) {
				fineInfoListType = objectFactory.createFineInfoListType();
				fineInfoListType.getFineInfo().addAll(fineInfoTypes);
			}
			target.setFineInfoList(objectFactory.createLibraryTransactionTypeFineInfoList(fineInfoListType));
		}
	}

	@Override
	public void toHitsModel(LibraryTransactionType source, LibraryPatronTransaction target) {
		if (source != null && target != null) {
			target.setTransactionItem(itemConverter.toHitsModel(getJAXBValue(source.getItemInfo())));
			target.setCheckout(checkoutConverter.toHitsModel(getJAXBValue(source.getCheckoutInfo())));

			if (target.getFineList() == null) {
				target.setFineList(new ArrayList<>());
			}
			target.getFineList().clear();
			FineInfoListType fineInfoListType = getJAXBValue(source.getFineInfoList());
			if (fineInfoListType != null) {
				List<LibraryTransactionFine> libraryTransactionFines = fineConverter
						.toHitsModelList(fineInfoListType.getFineInfo());
				for (LibraryTransactionFine libraryTransactionFine : libraryTransactionFines) {
					target.getFineList().add(libraryTransactionFine);
					libraryTransactionFine.setTransaction(target);
				}
			}

			if (target.getHoldList() == null) {
				target.setHoldList(new ArrayList<>());
			}
			target.getHoldList().clear();
			HoldInfoListType holdInfoListType = getJAXBValue(source.getHoldInfoList());
			if (holdInfoListType != null) {
				List<LibraryTransactionHold> libraryTransactionHolds = holdConverter
						.toHitsModelList(holdInfoListType.getHoldInfo());
				for (LibraryTransactionHold libraryTransactionHold : libraryTransactionHolds) {
					target.getHoldList().add(libraryTransactionHold);
					libraryTransactionHold.setTransaction(target);
				}
			}
		}
	}

}
