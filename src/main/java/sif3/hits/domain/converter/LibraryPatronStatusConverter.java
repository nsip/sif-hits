package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.ElectronicIdListType;
import sif.dd.au30.model.ElectronicIdType;
import sif.dd.au30.model.LibraryMessageListType;
import sif.dd.au30.model.LibraryMessageType;
import sif.dd.au30.model.LibraryPatronStatusType;
import sif.dd.au30.model.LibraryTransactionListType;
import sif.dd.au30.model.LibraryTransactionType;
import sif.dd.au30.model.LocalCodeListType;
import sif.dd.au30.model.LocalCodeType;
import sif.dd.au30.model.MonetaryAmountType;
import sif.dd.au30.model.NameOfRecordType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LibraryPatronElectronicId;
import sif3.hits.domain.model.LibraryPatronLocalCode;
import sif3.hits.domain.model.LibraryPatronMessage;
import sif3.hits.domain.model.LibraryPatronName;
import sif3.hits.domain.model.LibraryPatronStatus;
import sif3.hits.domain.model.LibraryPatronTransaction;

@Component
public class LibraryPatronStatusConverter extends HitsConverter<LibraryPatronStatusType, LibraryPatronStatus> {

	@Autowired
	HitsConverter<NameOfRecordType, LibraryPatronName> patronNameConverter;

	@Autowired
	HitsConverter<ElectronicIdType, LibraryPatronElectronicId> electronicIdConverter;

	@Autowired
	HitsConverter<LibraryTransactionType, LibraryPatronTransaction> transactionConverter;

	@Autowired
	HitsConverter<LibraryMessageType, LibraryPatronMessage> messageConverter;

	@Autowired
	HitsConverter<LocalCodeType, LibraryPatronLocalCode> localCodeConverter;

	public LibraryPatronStatusConverter() {
		super(LibraryPatronStatusType.class, LibraryPatronStatus.class);
	}

	@Override
	public void toSifModel(LibraryPatronStatus source, LibraryPatronStatusType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setLibraryType(source.getLibraryType());
			target.setPatronRefId(objectFactory.createLibraryPatronStatusTypePatronRefId(source.getPatronRefId()));
			target.setPatronLocalId(
					objectFactory.createLibraryPatronStatusTypePatronLocalId(source.getPatronLocalId()));
			target.setPatronRefObject(source.getPatronRefObject());
			target.setNumberOfCheckouts(getLongValue(source.getNumberOfCheckouts()));
			target.setNumberOfHoldItems(objectFactory
					.createLibraryPatronStatusTypeNumberOfHoldItems(getLongValue(source.getNumberOfHoldItems())));
			target.setNumberOfOverdues(objectFactory
					.createLibraryPatronStatusTypeNumberOfOverdues(getLongValue(source.getNumberOfOverdues())));
			target.setNumberOfFines(
					objectFactory.createLibraryPatronStatusTypeNumberOfFines(getLongValue(source.getNumberOfFines())));
			target.setFineAmount(objectFactory.createLibraryPatronStatusTypeFineAmount(
					getMonetaryAmount(source.getFineAmount(), source.getFineCurrency())));
			target.setNumberOfRefunds(objectFactory
					.createLibraryPatronStatusTypeNumberOfRefunds(getLongValue(source.getNumberOfRefunds())));
			target.setRefundAmount(objectFactory.createLibraryPatronStatusTypeRefundAmount(
					getMonetaryAmount(source.getRefundAmount(), source.getRefundCurrency())));

			target.setPatronName(objectFactory
					.createLibraryPatronStatusTypePatronName(patronNameConverter.toSifModel(source.getPatronName())));

			List<ElectronicIdType> electronicIdTypes = electronicIdConverter
					.toSifModelList(source.getElectronicIdList());
			ElectronicIdListType electronicIdListType = null;
			if (!electronicIdTypes.isEmpty()) {
				electronicIdListType = objectFactory.createElectronicIdListType();
				electronicIdListType.getElectronicId().addAll(electronicIdTypes);
			}
			target.setElectronicIdList(
					objectFactory.createLibraryPatronStatusTypeElectronicIdList(electronicIdListType));

			List<LibraryTransactionType> libraryTransactionTypes = transactionConverter
					.toSifModelList(source.getTransactionList());
			LibraryTransactionListType libraryTransactionListType = null;
			if (!libraryTransactionTypes.isEmpty()) {
				libraryTransactionListType = objectFactory.createLibraryTransactionListType();
				libraryTransactionListType.getTransaction().addAll(libraryTransactionTypes);
			}
			target.setTransactionList(
					objectFactory.createLibraryPatronStatusTypeTransactionList(libraryTransactionListType));

			List<LibraryMessageType> libraryMessageTypes = messageConverter.toSifModelList(source.getMessageList());
			LibraryMessageListType libraryMessageListType = null;
			if (!libraryMessageTypes.isEmpty()) {
				libraryMessageListType = objectFactory.createLibraryMessageListType();
				libraryMessageListType.getMessage().addAll(libraryMessageTypes);
			}
			target.setMessageList(objectFactory.createLibraryPatronStatusTypeMessageList(libraryMessageListType));

			List<LocalCodeType> localCodeTypes = localCodeConverter.toSifModelList(source.getLocalCodeList());
			LocalCodeListType localCodeListType = null;
			if (!localCodeTypes.isEmpty()) {
				localCodeListType = objectFactory.createLocalCodeListType();
				localCodeListType.getLocalCode().addAll(localCodeTypes);
			}
			target.setLocalCodeList(objectFactory.createLibraryPatronStatusTypeLocalCodeList(localCodeListType));
		}
	}

	@Override
	public void toHitsModel(LibraryPatronStatusType source, LibraryPatronStatus target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setLibraryType(source.getLibraryType());
			target.setPatronRefId(getJAXBValue(source.getPatronRefId()));
			target.setPatronLocalId(getJAXBValue(source.getPatronLocalId()));
			target.setPatronRefObject(source.getPatronRefObject());
			target.setNumberOfCheckouts(getLongValue(source.getNumberOfCheckouts()));
			target.setNumberOfHoldItems(getLongValue(getJAXBValue(source.getNumberOfHoldItems())));
			target.setNumberOfOverdues(getLongValue(getJAXBValue(source.getNumberOfOverdues())));
			target.setNumberOfFines(getLongValue(getJAXBValue(source.getNumberOfFines())));

			MonetaryAmountType fineAmount = getMonetaryAmount(source.getFineAmount());
			target.setFineAmount(getBigDecimalValue(fineAmount.getValue()));
			target.setFineCurrency(getEnumValue(fineAmount.getCurrency()));

			target.setNumberOfRefunds(getLongValue(getJAXBValue(source.getNumberOfRefunds())));

			MonetaryAmountType refundAmount = getMonetaryAmount(source.getRefundAmount());
			target.setRefundAmount(getBigDecimalValue(refundAmount.getValue()));
			target.setRefundCurrency(getEnumValue(refundAmount.getCurrency()));

			target.setPatronName(patronNameConverter.toHitsModel(getJAXBValue(source.getPatronName())));

			if (target.getElectronicIdList() == null) {
				target.setElectronicIdList(new ArrayList<>());
			}
			target.getElectronicIdList().clear();
			ElectronicIdListType electronicIdListType = getJAXBValue(source.getElectronicIdList());
			if (electronicIdListType != null) {
				List<LibraryPatronElectronicId> libraryPatronElectronicIds = electronicIdConverter
						.toHitsModelList(electronicIdListType.getElectronicId());
				for (LibraryPatronElectronicId libraryPatronElectronicId : libraryPatronElectronicIds) {
					target.getElectronicIdList().add(libraryPatronElectronicId);
					libraryPatronElectronicId.setLibraryPatronStatus(target);
				}
			}

			if (target.getTransactionList() == null) {
				target.setTransactionList(new ArrayList<>());
			}
			target.getTransactionList().clear();
			LibraryTransactionListType libraryTransactionListType = getJAXBValue(source.getTransactionList());
			if (libraryTransactionListType != null) {
				List<LibraryPatronTransaction> libraryPatronTransactions = transactionConverter
						.toHitsModelList(libraryTransactionListType.getTransaction());
				for (LibraryPatronTransaction libraryPatronTransaction : libraryPatronTransactions) {
					target.getTransactionList().add(libraryPatronTransaction);
					libraryPatronTransaction.setLibraryPatronStatus(target);
				}
			}

			if (target.getMessageList() == null) {
				target.setMessageList(new ArrayList<>());
			}
			target.getMessageList().clear();
			LibraryMessageListType libraryMessageListType = getJAXBValue(source.getMessageList());
			if (libraryMessageListType != null) {
				List<LibraryPatronMessage> libraryPatronMessages = messageConverter
						.toHitsModelList(libraryMessageListType.getMessage());
				for (LibraryPatronMessage libraryPatronMessage : libraryPatronMessages) {
					target.getMessageList().add(libraryPatronMessage);
					libraryPatronMessage.setLibraryPatronStatus(target);
				}
			}

			if (target.getLocalCodeList() == null) {
				target.setLocalCodeList(new ArrayList<>());
			}
			target.getLocalCodeList().clear();
			LocalCodeListType localCodeListType = getJAXBValue(source.getLocalCodeList());
			if (localCodeListType != null) {
				List<LibraryPatronLocalCode> libraryPatronLocalCodes = localCodeConverter
						.toHitsModelList(localCodeListType.getLocalCode());
				for (LibraryPatronLocalCode libraryPatronLocalCode : libraryPatronLocalCodes) {
					target.getLocalCodeList().add(libraryPatronLocalCode);
					libraryPatronLocalCode.setLibraryPatronStatus(target);
				}
			}

		}
	}

}
