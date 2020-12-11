package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsStaffActivityType;
import sif.dd.au30.model.CensusCollectionCollectionType;
import sif.dd.au30.model.CensusCollectionType;
import sif.dd.au30.model.CensusReportingListType;
import sif.dd.au30.model.CensusReportingType;
import sif.dd.au30.model.CensusStaffListType;
import sif.dd.au30.model.CensusStaffType;
import sif.dd.au30.model.CensusStudentListType;
import sif.dd.au30.model.CensusStudentType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.StaffActivityExtensionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class CensusCollectionTestData extends TestData<CensusCollectionType, CensusCollectionCollectionType> {

	public static final String REF_ID_1 = "10cb49e5-7b4b-4c18-957d-cce314581abd";
	public static final String REF_ID_2 = "4d8b4aa6-5510-444e-9149-ea46d287aaa4";
	public static final String REF_ID_3 = "0283cf47-9f69-4452-b0ff-99ea9d979d06";
	public static final String REF_ID_4 = "8415f139-df4d-4710-bb09-467e90281911";
	public static final String REF_ID_5 = "f28249a0-2075-483e-a861-fe12d054b6b9";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "c1d64890-c1b2-4d84-863a-db72a7eda67e";
	public static final String XML_REF_ID_2 = "129d9b09-683a-431f-9012-25506cb96c7e";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public CensusCollectionType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();

		CensusCollectionType censusCollection = new CensusCollectionType();
		censusCollection.setRefId(refId);
		censusCollection.setCensusYear(getDate("2020"));
		censusCollection.setRoundCode("RoundCode");
		censusCollection.setReportingAuthorityCommonwealthId(
				objectFactory.createAddressCollectionTypeReportingAuthorityCommonwealthId("RACWID"));

		censusCollection.setSoftwareVendorInfo(objectFactory
				.createCensusCollectionTypeSoftwareVendorInfo(getSoftwareVendorInfo("SoftwareProduct", "1.0.0")));

		CensusReportingListType censusReportingListType = objectFactory.createCensusReportingListType();
		for (int i = 1; i < 6; i++) {
			censusReportingListType.getCensusReporting().add(getCensusReporting(i));
		}
		censusCollection.setCensusReportingList(
				objectFactory.createCensusCollectionTypeCensusReportingList(censusReportingListType));

		return censusCollection;
	}

	private CensusReportingType getCensusReporting(int i) {
		IObjectFactory objectFactory = getObjectFactory();
		CensusReportingType censusReportingType = objectFactory.createCensusReportingType();

		censusReportingType.setEntityLevel(objectFactory.createCensusReportingTypeEntityLevel("System"));
		censusReportingType.setCommonwealthId("CWID-" + i);
		censusReportingType
				.setEntityName(objectFactory.createCensusReportingTypeEntityName(SchoolInfoTestData.SCHOOL_NAME));
		censusReportingType.setEntityContact(getEntityContact());

		CensusStaffListType censusStaffListType = objectFactory.createCensusStaffListType();
		for (int j = 1; j < 6; j++) {
			censusStaffListType.getCensusStaff().add(getCensusStaff(i, j));
		}
		censusReportingType
				.setCensusStaffList(objectFactory.createCensusReportingTypeCensusStaffList(censusStaffListType));

		CensusStudentListType censusStudentListType = objectFactory.createCensusStudentListType();
		for (int j = 1; j < 6; j++) {
			censusStudentListType.getCensusStudent().add(getCensusStudent(i, j));
		}
		censusReportingType
				.setCensusStudentList(objectFactory.createCensusReportingTypeCensusStudentList(censusStudentListType));
		return censusReportingType;
	}

	private CensusStudentType getCensusStudent(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		CensusStudentType censusStudentType = objectFactory.createCensusStudentType();
		censusStudentType.setStudentCohortId("X-" + i + "-" + j);
		censusStudentType.setYearLevel(getYearLevel(1 + j));
		censusStudentType.setCensusAge(new BigInteger("" + (10 + i + j)));
		censusStudentType.setCohortGender(getCohortGender(1 + i + j));
		censusStudentType.setCohortIndigenousType(getCohortIndigenous(2 + j));
		censusStudentType.setEducationMode("D");
		censusStudentType.setStudentOnVisa("N");
		censusStudentType.setOverseasStudent("N");
		censusStudentType.setDisabilityLevelOfAdjustment("None");
		censusStudentType.setDisabilityCategory("None");
		censusStudentType.setFTE(new BigDecimal(1.0));
		return censusStudentType;
	}

	private String getCohortGender(int x) {
		String[] gender = { "M", "F", "X" };
		return gender[x % 3];
	}

	private String getCohortIndigenous(int x) {
		String[] indStatus = { "I", "N", "NS" };
		return indStatus[x % 3];
	}

	private CensusStaffType getCensusStaff(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		CensusStaffType censusStaffType = objectFactory.createCensusStaffType();
		censusStaffType.setStaffCohortId("StaffCohort-" + i + "-" + j);
		censusStaffType.setCohortGender(getCohortGender(1 + i + j));
		censusStaffType.setCohortIndigenousType(getCohortIndigenous(2 + j));
		censusStaffType.setPrimaryFTE(objectFactory.createCensusStaffTypePrimaryFTE(new BigDecimal(1.0)));
		censusStaffType.setSecondaryFTE(objectFactory.createCensusStaffTypeSecondaryFTE(new BigDecimal(1.0)));
		censusStaffType.setJobFTE(objectFactory.createCensusStaffTypeJobFTE(new BigDecimal("" + i + j)));
		censusStaffType.setHeadcount(new BigInteger("2" + i + j));

		StaffActivityExtensionType staffActivity = objectFactory.createStaffActivityExtensionType();
		staffActivity.setCode(AUCodeSetsStaffActivityType.fromValue("2215"));

		OtherCodeListType otherCodeListType = objectFactory.createOtherCodeListType();
		otherCodeListType.getOtherCode().add(getOtherCode("" + i + j + 1));
		otherCodeListType.getOtherCode().add(getOtherCode("" + i + j + 2));
		staffActivity.setOtherCodeList(objectFactory.createStaffActivityExtensionTypeOtherCodeList(otherCodeListType));

		censusStaffType.setStaffActivity(staffActivity);
		return censusStaffType;
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

	public CensusCollectionCollectionType getTestCollection(String... refIds) {
		CensusCollectionCollectionType result = new CensusCollectionCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getCensusCollection().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "CensusCollection.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "CensusCollections.xml";
	}

}
