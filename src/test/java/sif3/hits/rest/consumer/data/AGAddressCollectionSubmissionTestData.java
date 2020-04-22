//package sif3.hits.rest.consumer.data;
//
//import sif.dd.au30.model.*;
//import sif3.hits.domain.converter.factory.IObjectFactory;
//import sif3.hits.utils.RefIdGenerator;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//
//public class AGAddressCollectionSubmissionTestData
//		extends TestData<AGAddressCollectionSubmissionType, AGAddressCollectionSubmissionCollectionType> {
//
//	public static final String REF_ID_1 = "403a02cb-2acb-4d74-98d0-c739c198ad7e";
//	public static final String REF_ID_2 = "1816b652-5260-414f-91f3-eaf4d24c3cf7";
//	public static final String REF_ID_3 = "0b49ce8e-b35b-416c-bd38-5a95e6dc7b5c";
//	public static final String REF_ID_4 = "7a356dd9-b79f-4598-a0dc-5bc1fc80e1cc";
//	public static final String REF_ID_5 = "939d8cbe-8cd7-4973-b2f1-568e86a0b611";
//
//	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
//	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);
//
//	public static final String XML_REF_ID_1 = "a43e5136-1acd-4f7a-88c5-d5f85ec7d07d";
//	public static final String XML_REF_ID_2 = "1c79b99a-88cd-412b-9d69-757f926e9ba9";
//
//	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
//	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);
//
//	public AGAddressCollectionSubmissionType getTestObject(String refId) {
//		IObjectFactory objectFactory = getObjectFactory();
//		AGAddressCollectionSubmissionType agAddressCollectionSubmission = objectFactory
//				.createAGAddressCollectionSubmissionType();
//		agAddressCollectionSubmission.setRefId(refId);
//
//		agAddressCollectionSubmission.setAddressCollectionYear(getDate("2019"));
//		agAddressCollectionSubmission.setReportingAuthority(
//				objectFactory.createAGAddressCollectionSubmissionTypeReportingAuthority("ReportingAuthority"));
//		agAddressCollectionSubmission.setReportingAuthoritySystem(
//				objectFactory.createAGAddressCollectionSubmissionTypeReportingAuthoritySystem("ReportingSystem"));
//		agAddressCollectionSubmission.setReportingAuthorityCommonwealthId("CommonwealthId");
//		agAddressCollectionSubmission.setSystemSubmission(objectFactory
//				.createAGAddressCollectionSubmissionTypeSystemSubmission(AUCodeSetsYesOrNoCategoryType.fromValue("Y")));
//
//		SoftwareVendorInfoContainerType softwareVendorInfoContainerType = objectFactory
//				.createSoftwareVendorInfoContainerType();
//		softwareVendorInfoContainerType.setSoftwareProduct("HITS");
//		softwareVendorInfoContainerType.setSoftwareVersion("v2.9.0");
//		agAddressCollectionSubmission.setSoftwareVendorInfo(softwareVendorInfoContainerType);
//
//		agAddressCollectionSubmission.setSubmissionContact(
//				FinancialQuestionnaireSubmissionTestData.getEntityContact("Mr", "Address", "Collection", "Submission"));
//		agAddressCollectionSubmission.setAddressCollectionComments(objectFactory
//				.createAGAddressCollectionSubmissionTypeAddressCollectionComments("Address Collection Comments"));
//
//		AddressCollectionReportingListType addressCollectionReportingListType = objectFactory
//				.createAddressCollectionReportingListType();
//		for (int i = 0; i < 2; i++) {
//			addressCollectionReportingListType.getAddressCollectionReporting()
//					.add(getAddressCollectionReporting(i, refId));
//		}
//		agAddressCollectionSubmission.setAddressCollectionReportingList(
//				objectFactory.createAGAddressCollectionSubmissionTypeAddressCollectionReportingList(
//						addressCollectionReportingListType));
//
//		return agAddressCollectionSubmission;
//	}
//
//	private AddressCollectionReportingType getAddressCollectionReporting(int index, String refId) {
//		IObjectFactory objectFactory = getObjectFactory();
//
//		// do some lazy string replacing so we can still have a unique refId, but keep
//		// it repeatable between tests.
//		int refIdIndex = ((5 + index) % 10);
//		String localRefId = StringUtils.replace(refId, "-4", "-" + refIdIndex);
//
//		AddressCollectionReportingType addressCollectionReportingType = objectFactory
//				.createAddressCollectionReportingType();
//		addressCollectionReportingType.setAddressCollectionRefId(
//				objectFactory.createAddressCollectionReportingTypeAddressCollectionRefId(localRefId));
//		addressCollectionReportingType.setEntityLevel("Entity Level " + index);
//		addressCollectionReportingType.setSchoolInfoRefId(
//				objectFactory.createAddressCollectionReportingTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
//		addressCollectionReportingType
//				.setLocalId(objectFactory.createAddressCollectionReportingTypeLocalId("Local Id " + index));
//		addressCollectionReportingType.setStateProvinceId(
//				objectFactory.createAddressCollectionReportingTypeStateProvinceId("State Id " + index));
//		addressCollectionReportingType.setCommonwealthId("Commonwealth Id " + index);
//		addressCollectionReportingType
//				.setACARAId(objectFactory.createAddressCollectionReportingTypeACARAId("ACARA Id " + index));
//		addressCollectionReportingType
//				.setEntityName(objectFactory.createAddressCollectionReportingTypeEntityName("Entity Name " + index));
//
//		addressCollectionReportingType.setEntityContact(FinancialQuestionnaireSubmissionTestData.getEntityContact("Ms",
//				"Address", "Collection " + index, "Reporting"));
//
//		AddressCollectionStudentListType addressCollectionStudentListType = objectFactory
//				.createAddressCollectionStudentListType();
//		for (int i = 0; i < 2; i++) {
//			addressCollectionStudentListType.getAddressCollectionStudent().add(getAddressCollectionStudent(index, i));
//		}
//		addressCollectionReportingType.setAddressCollectionStudentList(objectFactory
//				.createAddressCollectionReportingTypeAddressCollectionStudentList(addressCollectionStudentListType));
//		return addressCollectionReportingType;
//	}
//
//	private AddressCollectionStudentType getAddressCollectionStudent(int index, int i) {
//		IObjectFactory objectFactory = getObjectFactory();
//		AddressCollectionStudentType addressCollectionStudentType = objectFactory.createAddressCollectionStudentType();
//
//		addressCollectionStudentType.setLocalId("Local Id - " + index + " - " + i);
//		addressCollectionStudentType.setEducationLevel(AUCodeSetsEducationLevelType.fromValue("Primary"));
//		addressCollectionStudentType.setBoardingStatus(
//				objectFactory.createAddressCollectionStudentTypeBoardingStatus(AUCodeSetsBoardingType.fromValue("D")));
//		addressCollectionStudentType.setStudentAddress(getAddress("1" + index + "" + i + " Some St", "Some Suburb"));
//		addressCollectionStudentType.setParent1(getParent(index, i, 1));
//		if (index % 2 == 0 || i % 2 == 0) {
//			addressCollectionStudentType
//					.setParent2(objectFactory.createAddressCollectionStudentTypeParent2(getParent(index, i, 2)));
//		}
//		return addressCollectionStudentType;
//	}
//
//	private AGParentType getParent(int index, int i, int parentNumber) {
//		IObjectFactory objectFactory = getObjectFactory();
//		AGParentType parent = objectFactory.createAGParentType();
//
//		parent.setAddressSameAsStudent(AUCodeSetsYesOrNoCategoryType.fromValue("N"));
//		parent.setParentName(getNameOfRecord(parentNumber == 1 ? "Ms" : "Mr", "Parent",
//				"Number " + index + "" + i + "" + parentNumber, "Smith"));
//		parent.setParentAddress(getAddress("1" + index + "" + i + "" + parentNumber + " Some St", "Some Suburb"));
//		return parent;
//	}
//
//	public String getRefId(int index) {
//		String result = null;
//		if (index >= 0 && index < REF_ID_RA.length) {
//			result = REF_ID_RA[index];
//		} else {
//			result = RefIdGenerator.getRefId();
//		}
//		return result;
//	}
//
//	public AGAddressCollectionSubmissionCollectionType getTestCollection(String... refIds) {
//		AGAddressCollectionSubmissionCollectionType result = new AGAddressCollectionSubmissionCollectionType();
//		for (int i = 0; refIds != null && i < refIds.length; i++) {
//			result.getAGAddressCollectionSubmission().add(getTestObject(refIds[i]));
//		}
//		return result;
//	}
//
//	public String getSingleObjectXMLFilename() {
//		return "AGAddressCollectionSubmission.xml";
//	}
//
//	public String getMultiObjectXMLFilename() {
//		return "AGAddressCollectionSubmissions.xml";
//	}
//
//}
