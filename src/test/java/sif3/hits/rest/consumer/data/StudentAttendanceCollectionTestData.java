package sif3.hits.rest.consumer.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import sif.dd.au30.model.LocalCodeListType;
import sif.dd.au30.model.StatsCohortListType;
import sif.dd.au30.model.StatsCohortType;
import sif.dd.au30.model.StatsCohortYearLevelListType;
import sif.dd.au30.model.StatsCohortYearLevelType;
import sif.dd.au30.model.StudentAttendanceCollectionCollectionType;
import sif.dd.au30.model.StudentAttendanceCollectionReportingListType;
import sif.dd.au30.model.StudentAttendanceCollectionReportingType;
import sif.dd.au30.model.StudentAttendanceCollectionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class StudentAttendanceCollectionTestData
		extends TestData<StudentAttendanceCollectionType, StudentAttendanceCollectionCollectionType> {

	public static final String REF_ID_1 = "7bb07851-dcb8-4d59-845c-daeb0779147a";
	public static final String REF_ID_2 = "ea246c6a-2c68-43da-a7e7-f8990abc3da9";
	public static final String REF_ID_3 = "45baa993-f6da-44d7-837b-ab792dccc854";
	public static final String REF_ID_4 = "1f756698-39b0-4fab-b2ac-3355f12b4ca9";
	public static final String REF_ID_5 = "460b4709-eab4-45ae-b2ec-5908fa1fbb7e";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "d7ac3be9-1f5d-4e75-9965-aca18822fae1";
	public static final String XML_REF_ID_2 = "69430a65-22fb-4a38-a9f1-a23600790e38";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public StudentAttendanceCollectionType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		StudentAttendanceCollectionType studentAttendanceCollection = new StudentAttendanceCollectionType();
		studentAttendanceCollection.setRefId(refId);

		studentAttendanceCollection.setStudentAttendanceCollectionYear(getDate("2020"));
		studentAttendanceCollection.setRoundCode("RC-123");
		studentAttendanceCollection.setReportingAuthorityCommonwealthId(
				objectFactory.createStudentAttendanceCollectionTypeReportingAuthorityCommonwealthId("RACID"));
		studentAttendanceCollection.setSoftwareVendorInfo(objectFactory
				.createStudentAttendanceCollectionTypeSoftwareVendorInfo(getSoftwareVendorInfo("Software", "v11")));

		LocalCodeListType localCodeListType = objectFactory.createLocalCodeListType();
		for (int i = 0; i < 2; i++) {
			localCodeListType.getLocalCode().add(getLocalCode(i));
		}
		studentAttendanceCollection
				.setLocalCodeList(objectFactory.createStudentActivityInfoTypeLocalCodeList(localCodeListType));

		StudentAttendanceCollectionReportingListType studentAttendanceCollectionReportingListType = objectFactory
				.createStudentAttendanceCollectionReportingListType();
		for (int i = 1; i < 4; i++) {
			studentAttendanceCollectionReportingListType.getStudentAttendanceCollectionReporting()
					.add(getSACReporting(i));
		}
		studentAttendanceCollection.setStudentAttendanceCollectionReportingList(
				objectFactory.createStudentAttendanceCollectionTypeStudentAttendanceCollectionReportingList(
						studentAttendanceCollectionReportingListType));
		return studentAttendanceCollection;
	}

	private StudentAttendanceCollectionReportingType getSACReporting(int i) {
		IObjectFactory objectFactory = getObjectFactory();
		StudentAttendanceCollectionReportingType studentAttendanceCollectionReportingType = objectFactory
				.createStudentAttendanceCollectionReportingType();

		studentAttendanceCollectionReportingType
				.setEntityLevel(objectFactory.createStudentAttendanceCollectionReportingTypeEntityLevel("System"));
		studentAttendanceCollectionReportingType.setSchoolInfoRefId(objectFactory
				.createStudentAttendanceCollectionReportingTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
		studentAttendanceCollectionReportingType.setLocalId(
				objectFactory.createStudentAttendanceCollectionReportingTypeLocalId(SchoolInfoTestData.LOCAL_ID));
		studentAttendanceCollectionReportingType.setStateProvinceId(objectFactory
				.createStudentAttendanceCollectionReportingTypeStateProvinceId(SchoolInfoTestData.LOCAL_ID));
		studentAttendanceCollectionReportingType.setCommonwealthId("CWId");
		studentAttendanceCollectionReportingType.setACARAId(
				objectFactory.createStudentAttendanceCollectionReportingTypeACARAId(SchoolInfoTestData.ACARA_ID));
		studentAttendanceCollectionReportingType.setEntityName(
				objectFactory.createStudentAttendanceCollectionReportingTypeEntityName(SchoolInfoTestData.SCHOOL_NAME));

		studentAttendanceCollectionReportingType.setEntityContact(getEntityContact());

		StatsCohortYearLevelListType statsCohortYearLevelListType = objectFactory.createStatsCohortYearLevelListType();
		for (int j = 1; j < 6; j++) {
			statsCohortYearLevelListType.getStatsCohortYearLevel().add(getCohort(i, j));
		}
		studentAttendanceCollectionReportingType.setStatsCohortYearLevelList(objectFactory
				.createStudentAttendanceCollectionReportingTypeStatsCohortYearLevelList(statsCohortYearLevelListType));

		return studentAttendanceCollectionReportingType;
	}

	private StatsCohortYearLevelType getCohort(int i, int j) {
		IObjectFactory objectFactory = getObjectFactory();
		StatsCohortYearLevelType statsCohortYearLevelType = objectFactory.createStatsCohortYearLevelType();
		statsCohortYearLevelType.setCohortYearLevel(getYearLevel(j));
		StatsCohortListType statsCohortListType = objectFactory.createStatsCohortListType();
		for (int k = 1; k < 6; k++) {
			statsCohortListType.getStatsCohort().add(getCohort(i, j, k));
		}
		statsCohortYearLevelType.setStatsCohortList(statsCohortListType);
		return statsCohortYearLevelType;
	}

	private String getCohortIndigenous(int i) {
		String[] is = new String[] { "I", "T", null };
		return is[i % 3];

	}

	private String getCohortGender(int i) {
		String[] g = new String[] { "M", "F", "X" };
		return g[i % 3];
	}

	private StatsCohortType getCohort(int i, int j, int k) {
		IObjectFactory objectFactory = getObjectFactory();
		StatsCohortType statsCohortType = objectFactory.createStatsCohortType();
		statsCohortType.setStatsCohortId("SC" + i + j + k);
		statsCohortType.setStatsIndigenousStudentType(getCohortIndigenous(i + j + k));
		statsCohortType.setCohortGender(getCohortGender(i + j + k));
		statsCohortType.setDaysInReferencePeriod(new BigInteger("1" + i + j + k));
		statsCohortType.setPossibleSchoolDays(new BigInteger("" + i + j + k));
		statsCohortType.setAttendanceDays(new BigDecimal("" + i + j + k));
		statsCohortType.setAttendanceLess90Percent(new BigInteger("" + j + i + k));
		statsCohortType.setAttendanceGTE90Percent(new BigInteger("" + k + i + j));
		statsCohortType.setPossibleSchoolDaysGT90PercentAttendance(new BigInteger("" + k + j + i));
		return statsCohortType;
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

	public StudentAttendanceCollectionCollectionType getTestCollection(String... refIds) {
		StudentAttendanceCollectionCollectionType result = new StudentAttendanceCollectionCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getStudentAttendanceCollection().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "StudentAttendanceCollection.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "StudentAttendanceCollections.xml";
	}

}
