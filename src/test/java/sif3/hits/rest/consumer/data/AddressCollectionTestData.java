package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AGContextualQuestionListType;
import sif.dd.au30.model.AGContextualQuestionType;
import sif.dd.au30.model.AGParentType;
import sif.dd.au30.model.AUCodeSetsAGContextQuestionType;
import sif.dd.au30.model.AUCodeSetsBoardingType;
import sif.dd.au30.model.AUCodeSetsEducationLevelType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.AddressCollectionCollectionType;
import sif.dd.au30.model.AddressCollectionReportingListType;
import sif.dd.au30.model.AddressCollectionReportingType;
import sif.dd.au30.model.AddressCollectionStudentListType;
import sif.dd.au30.model.AddressCollectionStudentType;
import sif.dd.au30.model.AddressCollectionType;
import sif.dd.au30.model.LocalCodeListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class AddressCollectionTestData extends TestData<AddressCollectionType, AddressCollectionCollectionType> {

	public static final String REF_ID_1 = "abcde421-8fd0-4f4c-baac-7edb1fb3b324";
	public static final String REF_ID_2 = "440cc7b5-6fa6-4f72-823d-49ed189d7ae3";
	public static final String REF_ID_3 = "1ec7bd63-ddb0-42ce-b049-061dc7666571";
	public static final String REF_ID_4 = "c4808c07-1b72-490e-9a70-2056deeba7cd";
	public static final String REF_ID_5 = "9e7b31de-fc05-4b62-8566-7ad5005e3756";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "2939f015-4bd7-4762-b332-3456debebf0c";
	public static final String XML_REF_ID_2 = "034c4655-4645-43b9-a493-65cc341c7032";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public AddressCollectionType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();

		AddressCollectionType addressCollection = new AddressCollectionType();
		addressCollection.setRefId(refId);
		addressCollection.setAddressCollectionYear(getDate("2020"));
		addressCollection.setRoundCode("RoundCode");
		addressCollection.setReportingAuthorityCommonwealthId(
				objectFactory.createAddressCollectionTypeReportingAuthorityCommonwealthId("RACW-Id"));
		addressCollection.setSoftwareVendorInfo(objectFactory
				.createAddressCollectionTypeSoftwareVendorInfo(getSoftwareVendorInfo("SW-Product", "SW-Version")));

		AddressCollectionReportingListType addressCollectionReportingListType = objectFactory
				.createAddressCollectionReportingListType();
		addressCollectionReportingListType.getAddressCollectionReporting().add(getAddressCollectionReporting(1));
		addressCollectionReportingListType.getAddressCollectionReporting().add(getAddressCollectionReporting(2));
		addressCollectionReportingListType.getAddressCollectionReporting().add(getAddressCollectionReporting(3));
		addressCollectionReportingListType.getAddressCollectionReporting().add(getAddressCollectionReporting(4));
		addressCollection.setAddressCollectionReportingList(objectFactory
				.createAddressCollectionTypeAddressCollectionReportingList(addressCollectionReportingListType));

		LocalCodeListType addressCollectionLocalCodeListType = objectFactory.createLocalCodeListType();
		addressCollectionLocalCodeListType.getLocalCode().add(getLocalCode(1));
		addressCollectionLocalCodeListType.getLocalCode().add(getLocalCode(2));
		return addressCollection;
	}

	private AddressCollectionReportingType getAddressCollectionReporting(int index) {
		IObjectFactory objectFactory = getObjectFactory();
		AddressCollectionReportingType addressCollectionReportingType = objectFactory
				.createAddressCollectionReportingType();
		addressCollectionReportingType
				.setEntityLevel(objectFactory.createAddressCollectionReportingTypeEntityLevel("EL-" + index));
		addressCollectionReportingType.setSchoolInfoRefId(
				objectFactory.createAddressCollectionReportingTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
		addressCollectionReportingType
				.setLocalId(objectFactory.createAddressCollectionReportingTypeLocalId("LocalId" + index));
		addressCollectionReportingType.setStateProvinceId(
				objectFactory.createAddressCollectionReportingTypeStateProvinceId("StateId" + index));
		addressCollectionReportingType.setCommonwealthId("CWID-" + index);
		addressCollectionReportingType
				.setACARAId(objectFactory.createAddressCollectionReportingTypeACARAId(SchoolInfoTestData.ACARA_ID));
		addressCollectionReportingType.setEntityName(
				objectFactory.createAddressCollectionReportingTypeEntityName(SchoolInfoTestData.SCHOOL_NAME));

		addressCollectionReportingType.setEntityContact(getEntityContact());

		AGContextualQuestionListType agContextualQuestionListType = objectFactory.createAGContextualQuestionListType();
		for (int i = 1; i < 6; i++) {
			agContextualQuestionListType.getAGContextualQuestion().add(getAGContextualQuestion(index, i));
		}
		addressCollectionReportingType.setAGContextualQuestionList(objectFactory
				.createAddressCollectionReportingTypeAGContextualQuestionList(agContextualQuestionListType));

		AddressCollectionStudentListType addressCollectionStudentListType = objectFactory
				.createAddressCollectionStudentListType();
		for (int i = 1; i < 6; i++) {
			addressCollectionStudentListType.getAddressCollectionStudent().add(getAddressCollectionStudent(index, i));
		}
		addressCollectionReportingType.setAddressCollectionStudentList(objectFactory
				.createAddressCollectionReportingTypeAddressCollectionStudentList(addressCollectionStudentListType));
		return addressCollectionReportingType;
	}

	private AddressCollectionStudentType getAddressCollectionStudent(int index, int i) {
		IObjectFactory objectFactory = getObjectFactory();
		AddressCollectionStudentType addressCollectionStudentType = objectFactory.createAddressCollectionStudentType();
		
		addressCollectionStudentType.setLocalId("S2020" + index + i);
		addressCollectionStudentType.setEducationLevel(AUCodeSetsEducationLevelType.fromValue("Secondary"));
		addressCollectionStudentType.setBoardingStatus(objectFactory.createAddressCollectionStudentTypeBoardingStatus(AUCodeSetsBoardingType.fromValue("D")));
		addressCollectionStudentType.setReportingParent2("N");
		
		addressCollectionStudentType.setStudentAddress(getAddress("" + index + i + " Student Address Street", null));
		addressCollectionStudentType.setParent1(getAGParent(index, i, 1));
		addressCollectionStudentType.setParent2(objectFactory.createAddressCollectionStudentTypeParent2(getAGParent(index, i, 2)));
		
		return addressCollectionStudentType;
	}

	private AGParentType getAGParent(int index, int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		AGParentType agParentType = objectFactory.createAGParentType();
		agParentType.setAddressSameAsStudent(AUCodeSetsYesOrNoCategoryType.fromValue("Y"));
		agParentType.setParentName(getNameOfRecord("Mr", "Parent", "" + index + i + j, "Parent"));
		agParentType.setParentAddress(getAddress("" + index + i + j + "Parent Address Street", null));
		if (j == 1) {
			addStatAreas(agParentType.getParentAddress(), 2);
		}
		return agParentType;
	}

	private AGContextualQuestionType getAGContextualQuestion(int index, int i) {
		IObjectFactory objectFactory = getObjectFactory();
		AGContextualQuestionType agContextualQuestionType = objectFactory.createAGContextualQuestionType();
		agContextualQuestionType.setAGAnswer("Answer " + index + " " + i);
		agContextualQuestionType.setAGContextCode(AUCodeSetsAGContextQuestionType.fromValue("AC001"));
		return agContextualQuestionType;
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

	public AddressCollectionCollectionType getTestCollection(String... refIds) {
		AddressCollectionCollectionType result = new AddressCollectionCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getAddressCollection().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "AddressCollection.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "AddressCollections.xml";
	}

}
