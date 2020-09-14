package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import sif.dd.au30.model.CheckoutInfoType;
import sif.dd.au30.model.ElectronicIdListType;
import sif.dd.au30.model.FineInfoListType;
import sif.dd.au30.model.FineInfoType;
import sif.dd.au30.model.HoldInfoListType;
import sif.dd.au30.model.HoldInfoType;
import sif.dd.au30.model.LibraryItemInfoType;
import sif.dd.au30.model.LibraryMessageListType;
import sif.dd.au30.model.LibraryMessageType;
import sif.dd.au30.model.LibraryPatronStatusCollectionType;
import sif.dd.au30.model.LibraryPatronStatusType;
import sif.dd.au30.model.LibraryTransactionListType;
import sif.dd.au30.model.LibraryTransactionType;
import sif.dd.au30.model.LocalCodeListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class LibraryPatronStatusTestData extends TestData<LibraryPatronStatusType, LibraryPatronStatusCollectionType> {

	public static final String REF_ID_1 = "c6491c2f-07c1-4e90-b786-0ea770153eed";
	public static final String REF_ID_2 = "0377edcb-962e-49a6-bd76-8e160d3884f4";
	public static final String REF_ID_3 = "a28225e4-b022-45c8-982e-32543bd42286";
	public static final String REF_ID_4 = "f113ad7b-b6f2-4fe0-9259-eaa91d08f07e";
	public static final String REF_ID_5 = "6fb23c5e-a314-4009-83d9-36f51d19e8ea";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "40b1fe54-2587-4556-9222-91579eca1584";
	public static final String XML_REF_ID_2 = "09fa1978-0cb8-48a5-afc1-1151eda2df21";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public LibraryPatronStatusType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		LibraryPatronStatusType libraryPatronStatus = new LibraryPatronStatusType();
		libraryPatronStatus.setRefId(refId);
		libraryPatronStatus.setLibraryType("Academic");
		libraryPatronStatus.setPatronRefId(
				objectFactory.createLibraryPatronStatusTypePatronRefId(StudentPersonalTestData.REF_ID_1));
		libraryPatronStatus.setPatronLocalId(
				objectFactory.createLibraryPatronStatusTypePatronLocalId(StudentPersonalTestData.LOCAL_ID));
		libraryPatronStatus.setPatronRefObject("StudentPersonal");
		libraryPatronStatus.setNumberOfCheckouts(23L);
		libraryPatronStatus.setNumberOfHoldItems(objectFactory.createLibraryPatronStatusTypeNumberOfHoldItems(1L));
		libraryPatronStatus.setNumberOfOverdues(objectFactory.createLibraryPatronStatusTypeNumberOfOverdues(0L));
		libraryPatronStatus.setNumberOfFines(objectFactory.createLibraryPatronStatusTypeNumberOfFines(1L));
		libraryPatronStatus
				.setFineAmount(objectFactory.createLibraryPatronStatusTypeFineAmount(getMonetaryAmount("23.00")));
		libraryPatronStatus.setNumberOfRefunds(objectFactory.createLibraryPatronStatusTypeNumberOfRefunds(1L));
		libraryPatronStatus
				.setRefundAmount(objectFactory.createLibraryPatronStatusTypeRefundAmount(getMonetaryAmount("12.00")));
		libraryPatronStatus.setPatronName(objectFactory
				.createLibraryPatronStatusTypePatronName(getNameOfRecord(null, "Patron", "", "Library")));

		ElectronicIdListType electronicIdListType = objectFactory.createElectronicIdListType();
		for (int i = 1; i < 5; i++) {
			electronicIdListType.getElectronicId().add(getElectronicId("213E" + i));
		}
		libraryPatronStatus
				.setElectronicIdList(objectFactory.createLibraryPatronStatusTypeElectronicIdList(electronicIdListType));

		LibraryTransactionListType libraryTransactionListType = objectFactory.createLibraryTransactionListType();
		for (int i = 1; i < 5; i++) {
			libraryTransactionListType.getTransaction().add(getLibraryTransaction(i));
		}
		libraryPatronStatus.setTransactionList(
				objectFactory.createLibraryPatronStatusTypeTransactionList(libraryTransactionListType));

		LibraryMessageListType libraryMessageListType = objectFactory.createLibraryMessageListType();
		for (int i = 1; i < 5; i++) {
			libraryMessageListType.getMessage().add(getLibraryMessage(i));
		}
		libraryPatronStatus
				.setMessageList(objectFactory.createLibraryPatronStatusTypeMessageList(libraryMessageListType));

		LocalCodeListType localCodeListType = objectFactory.createLocalCodeListType();
		for (int i = 1; i < 5; i++) {
			localCodeListType.getLocalCode().add(getLocalCode(i));
		}
		libraryPatronStatus
				.setLocalCodeList(objectFactory.createLibraryPatronStatusTypeLocalCodeList(localCodeListType));
		return libraryPatronStatus;
	}

	private LibraryMessageType getLibraryMessage(int i) {
		IObjectFactory objectFactory = getObjectFactory();
		LibraryMessageType libraryMessageType = objectFactory.createLibraryMessageType();
		libraryMessageType.setSent(objectFactory.createLibraryMessageTypeSent(getCalendar("2020-04-22")));
		libraryMessageType.setText("Message Content : " + i);
		libraryMessageType.setPriority("P" + i);
		libraryMessageType.setPriorityCodeset("Local");
		return libraryMessageType;
	}

	private LibraryItemInfoType getLibraryItemInfo(int i) {
		IObjectFactory objectFactory = getObjectFactory();
		LibraryItemInfoType libraryItemInfoType = objectFactory.createLibraryItemInfoType();
		
		libraryItemInfoType.setTitle("Title " + i);
		libraryItemInfoType.setAuthor(objectFactory.createLibraryItemInfoTypeAuthor("Author " + i));
		libraryItemInfoType.setElectronicId(objectFactory.createLibraryItemInfoTypeElectronicId(getElectronicId("1234" + i)));
		libraryItemInfoType.setCallNumber(objectFactory.createLibraryItemInfoTypeCallNumber("Call" + i));
		libraryItemInfoType.setISBN(objectFactory.createLibraryItemInfoTypeISBN("ISBN" + i));
		libraryItemInfoType.setCost(objectFactory.createLibraryItemInfoTypeCost(getMonetaryAmount("12.3" + i)));
		libraryItemInfoType.setReplacementCost(objectFactory.createLibraryItemInfoTypeReplacementCost(getMonetaryAmount("33.3" + i)));
		libraryItemInfoType.setType("Book");

		return libraryItemInfoType;
	}

	private FineInfoType getFineInfo(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		FineInfoType fineInfoType = objectFactory.createFineInfoType();
		
		fineInfoType.setAssessed(getCalendar("2020-04-05"));
		fineInfoType.setDescription(objectFactory.createFineInfoTypeDescription("Fine #" + i + j));
		fineInfoType.setAmount(getMonetaryAmount("1." + i + j));
		fineInfoType.setReference(objectFactory.createFineInfoTypeReference("Ref" + i + "." + j));
		fineInfoType.setType("Overdue");
		
		return fineInfoType;
	}

	private HoldInfoType getHoldInfo(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		HoldInfoType holdInfoType = objectFactory.createHoldInfoType();
		
		XMLGregorianCalendar baseCalendar = getDate("2020-06-01");
		Duration duration = getDurationDays(i+j);
		
		holdInfoType.setDatePlaced(getDate(baseCalendar.toXMLFormat()));
		baseCalendar.add(duration);
		holdInfoType.setDateNeeded(objectFactory.createHoldInfoTypeDateNeeded(getDate(baseCalendar.toXMLFormat())));
		baseCalendar.add(duration);
		holdInfoType.setReservationExpiry(objectFactory.createHoldInfoTypeReservationExpiry(getDate(baseCalendar.toXMLFormat())));
		baseCalendar.add(duration);
		holdInfoType.setMadeAvailable(objectFactory.createHoldInfoTypeMadeAvailable(getDate(baseCalendar.toXMLFormat())));
		baseCalendar.add(duration);
		holdInfoType.setExpires(objectFactory.createHoldInfoTypeExpires(getDate(baseCalendar.toXMLFormat())));
		baseCalendar.add(duration);
		holdInfoType.setType("Book");
		
		return holdInfoType;
	}

	private CheckoutInfoType getCheckoutInfo(int i) {
		IObjectFactory objectFactory = getObjectFactory();
		CheckoutInfoType checkoutInfoType = objectFactory.createCheckoutInfoType();

		checkoutInfoType.setCheckedOutOn(getCalendar("2020-04-05"));
		checkoutInfoType.setReturnBy(getCalendar("2020-05-05"));
		checkoutInfoType.setRenewalCount(objectFactory.createCheckoutInfoTypeRenewalCount(2L + i));

		return checkoutInfoType;
	}

	private LibraryTransactionType getLibraryTransaction(int i) {
		IObjectFactory objectFactory = getObjectFactory();
		LibraryTransactionType libraryTransactionType = objectFactory.createLibraryTransactionType();

		LibraryItemInfoType libraryItemInfo = getLibraryItemInfo(i);
		libraryTransactionType.setItemInfo(objectFactory.createLibraryTransactionTypeItemInfo(libraryItemInfo));

		CheckoutInfoType checkoutInfoType = getCheckoutInfo(i);
		libraryTransactionType
				.setCheckoutInfo(objectFactory.createLibraryTransactionTypeCheckoutInfo(checkoutInfoType));

		HoldInfoListType holdInfoListType = objectFactory.createHoldInfoListType();
		for (int j = 1; j < 6; j++) {
			holdInfoListType.getHoldInfo().add(getHoldInfo(i, j));
		}
		libraryTransactionType
				.setHoldInfoList(objectFactory.createLibraryTransactionTypeHoldInfoList(holdInfoListType));

		FineInfoListType fineInfoListType = objectFactory.createFineInfoListType();
		for (int j = 1; j < 6; j++) {
			fineInfoListType.getFineInfo().add(getFineInfo(i, j));
		}
		libraryTransactionType
				.setFineInfoList(objectFactory.createLibraryTransactionTypeFineInfoList(fineInfoListType));

		return libraryTransactionType;
	}

	public String getRefId(int index) {
		String result = null;
		if (index >= 0 && index < REF_ID_RA.length) {
			result = REF_ID_RA[index];
		} else {
			result = RefIdGenerator.getRefId();
		}
		return result;
	}

	public LibraryPatronStatusCollectionType getTestCollection(String... refIds) {
		LibraryPatronStatusCollectionType result = new LibraryPatronStatusCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getLibraryPatronStatus().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "LibraryPatronStatus.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "LibraryPatronStatuss.xml";
	}

}
