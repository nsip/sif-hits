package sif3.hits.rest.consumer.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sif.dd.au30.conversion.DataModelMarshalFactory;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.hits.rest.consumer.data.AddressCollectionTestData;
import sif3.hits.rest.consumer.data.CalendarDateTestData;
import sif3.hits.rest.consumer.data.CalendarSummaryTestData;
import sif3.hits.rest.consumer.data.CensusCollectionTestData;
import sif3.hits.rest.consumer.data.ChargedLocationInfoTestData;
import sif3.hits.rest.consumer.data.CollectionRoundTestData;
import sif3.hits.rest.consumer.data.CollectionStatusTestData;
import sif3.hits.rest.consumer.data.DebtorTestData;
import sif3.hits.rest.consumer.data.FinancialAccountTestData;
import sif3.hits.rest.consumer.data.FinancialQuestionnaireCollectionTestData;
import sif3.hits.rest.consumer.data.GradingAssignmentScoreTestData;
import sif3.hits.rest.consumer.data.GradingAssignmentTestData;
import sif3.hits.rest.consumer.data.InvoiceTestData;
import sif3.hits.rest.consumer.data.JournalTestData;
import sif3.hits.rest.consumer.data.LibraryPatronStatusTestData;
import sif3.hits.rest.consumer.data.NAPEventStudentLinkTestData;
import sif3.hits.rest.consumer.data.NAPStudentResponseSetTestData;
import sif3.hits.rest.consumer.data.NAPTestItemTestData;
import sif3.hits.rest.consumer.data.NAPTestScoreSummaryTestData;
import sif3.hits.rest.consumer.data.NAPTestTestData;
import sif3.hits.rest.consumer.data.NAPTestletTestData;
import sif3.hits.rest.consumer.data.PaymentReceiptTestData;
import sif3.hits.rest.consumer.data.PersonPictureTestData;
import sif3.hits.rest.consumer.data.PersonalisedPlanTestData;
import sif3.hits.rest.consumer.data.PurchaseOrderTestData;
import sif3.hits.rest.consumer.data.RoomInfoTestData;
import sif3.hits.rest.consumer.data.ScheduledActivityTestData;
import sif3.hits.rest.consumer.data.SchoolCourseInfoTestData;
import sif3.hits.rest.consumer.data.SchoolInfoTestData;
import sif3.hits.rest.consumer.data.SessionInfoTestData;
import sif3.hits.rest.consumer.data.StaffAssignmentTestData;
import sif3.hits.rest.consumer.data.StaffPersonalTestData;
import sif3.hits.rest.consumer.data.StudentAttendanceCollectionTestData;
import sif3.hits.rest.consumer.data.StudentAttendanceSummaryTestData;
import sif3.hits.rest.consumer.data.StudentAttendanceTimeListTestData;
import sif3.hits.rest.consumer.data.StudentContactPersonalTestData;
import sif3.hits.rest.consumer.data.StudentContactRelationshipTestData;
import sif3.hits.rest.consumer.data.StudentDailyAttendanceTestData;
import sif3.hits.rest.consumer.data.StudentPeriodAttendanceTestData;
import sif3.hits.rest.consumer.data.StudentPersonalTestData;
import sif3.hits.rest.consumer.data.StudentSchoolEnrollmentTestData;
import sif3.hits.rest.consumer.data.StudentScoreJudgementAgainstStandardTestData;
import sif3.hits.rest.consumer.data.TeachingGroupTestData;
import sif3.hits.rest.consumer.data.TermInfoTestData;
import sif3.hits.rest.consumer.data.TestData;
import sif3.hits.rest.consumer.data.TimeTableCellTestData;
import sif3.hits.rest.consumer.data.TimeTableSubjectTestData;
import sif3.hits.rest.consumer.data.TimeTableTestData;
import sif3.hits.rest.consumer.data.VendorInfoTestData;
import sif3.hits.rest.consumer.data.WellbeingAlertTestData;
import sif3.hits.rest.consumer.data.WellbeingAppealTestData;
import sif3.hits.rest.consumer.data.WellbeingCharacteristicTestData;
import sif3.hits.rest.consumer.data.WellbeingEventTestData;
import sif3.hits.rest.consumer.data.WellbeingPersonLinkTestData;
import sif3.hits.rest.consumer.data.WellbeingResponseTestData;

public class XMLGenerator {
	private static final String PROJECT_PATH = "/Users/ben/Development/nsip/sif-hits";
	private static final String XML_PATH = PROJECT_PATH + "/src/test/resources/xml";
	private static final String CONFIG_PATH = PROJECT_PATH + "/config";
	private static final String PROVIDER_PATH = PROJECT_PATH + "/src/main/java/sif3/hits/rest/provider";

	public static void main(String[] args) throws MarshalException, UnsupportedMediaTypeExcpetion {
		updateProviderClasses(PROVIDER_PATH, CONFIG_PATH);
		updateStaticXML(XML_PATH);
	}

	public static void updateProviderClasses(String providerPath, String configPath) {
		List<String> ignoredProviders = Arrays.asList("HitsBaseProvider.java", "AUDataModelProvider.java");
		Pattern providerPattern = Pattern.compile("^([a-zA-Z]*)\\.java$");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(configPath + "/provider.classes", false))) {
			String prefix = "provider.classes=";
			File path = new File(providerPath);
			List<String> providers = Arrays.asList(path.list());
			Collections.sort(providers);
			for (String provider : providers) {
				Matcher matcher = providerPattern.matcher(provider);
				if (!ignoredProviders.contains(provider) && matcher.matches()) {
					String providerName = matcher.group(1);
					writer.write(prefix + providerName);
					prefix = ",";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateStaticXML(String path) throws MarshalException, UnsupportedMediaTypeExcpetion {
		generateTestXML(path, new CalendarDateTestData(), CalendarDateTestData.XML_REF_ID_1,
				CalendarDateTestData.XML_REF_ID_2);
		generateTestXML(path, new CalendarSummaryTestData(), CalendarSummaryTestData.XML_REF_ID_1,
				CalendarSummaryTestData.XML_REF_ID_2);
		generateTestXML(path, new ChargedLocationInfoTestData(), ChargedLocationInfoTestData.XML_REF_ID_1,
				ChargedLocationInfoTestData.XML_REF_ID_2);
		generateTestXML(path, new DebtorTestData(), DebtorTestData.XML_REF_ID_1, DebtorTestData.XML_REF_ID_2);
		generateTestXML(path, new FinancialAccountTestData(), FinancialAccountTestData.XML_REF_ID_1,
				FinancialAccountTestData.XML_REF_ID_2);
		generateTestXML(path, new GradingAssignmentTestData(), GradingAssignmentTestData.XML_REF_ID_1,
				GradingAssignmentTestData.XML_REF_ID_2);
		generateTestXML(path, new GradingAssignmentScoreTestData(), GradingAssignmentScoreTestData.XML_REF_ID_1,
				GradingAssignmentScoreTestData.XML_REF_ID_2);
		generateTestXML(path, new InvoiceTestData(), InvoiceTestData.XML_REF_ID_1, InvoiceTestData.XML_REF_ID_2);
		generateTestXML(path, new JournalTestData(), JournalTestData.XML_REF_ID_1, JournalTestData.XML_REF_ID_2);
		generateTestXML(path, new NAPEventStudentLinkTestData(), NAPEventStudentLinkTestData.XML_REF_ID_1,
				NAPEventStudentLinkTestData.XML_REF_ID_2);
		generateTestXML(path, new NAPStudentResponseSetTestData(), NAPStudentResponseSetTestData.XML_REF_ID_1,
				NAPStudentResponseSetTestData.XML_REF_ID_2);
		generateTestXML(path, new NAPTestTestData(), NAPTestTestData.XML_REF_ID_1, NAPTestTestData.XML_REF_ID_2);
		generateTestXML(path, new NAPTestItemTestData(), NAPTestItemTestData.XML_REF_ID_1,
				NAPTestItemTestData.XML_REF_ID_2);
		generateTestXML(path, new NAPTestletTestData(), NAPTestletTestData.XML_REF_ID_1,
				NAPTestletTestData.XML_REF_ID_2);
		generateTestXML(path, new NAPTestScoreSummaryTestData(), NAPTestScoreSummaryTestData.XML_REF_ID_1,
				NAPTestScoreSummaryTestData.XML_REF_ID_2);
		generateTestXML(path, new PaymentReceiptTestData(), PaymentReceiptTestData.XML_REF_ID_1,
				PaymentReceiptTestData.XML_REF_ID_2);
		generateTestXML(path, new PersonalisedPlanTestData(), PersonalisedPlanTestData.XML_REF_ID_1,
				PersonalisedPlanTestData.XML_REF_ID_2);
		generateTestXML(path, new PersonPictureTestData(), PersonPictureTestData.XML_REF_ID_1,
				PersonPictureTestData.XML_REF_ID_2);
		generateTestXML(path, new PurchaseOrderTestData(), PurchaseOrderTestData.XML_REF_ID_1,
				PurchaseOrderTestData.XML_REF_ID_2);
		generateTestXML(path, new RoomInfoTestData(), RoomInfoTestData.XML_REF_ID_1, RoomInfoTestData.XML_REF_ID_2);
		generateTestXML(path, new ScheduledActivityTestData(), ScheduledActivityTestData.XML_REF_ID_1,
				ScheduledActivityTestData.XML_REF_ID_2);
		generateTestXML(path, new SchoolInfoTestData(), SchoolInfoTestData.XML_REF_ID_1,
				SchoolInfoTestData.XML_REF_ID_2);
		generateTestXML(path, new SessionInfoTestData(), SessionInfoTestData.XML_REF_ID_1,
				SessionInfoTestData.XML_REF_ID_2);
		generateTestXML(path, new StaffAssignmentTestData(), StaffAssignmentTestData.XML_REF_ID_1,
				StaffAssignmentTestData.XML_REF_ID_2);
		generateTestXML(path, new StaffPersonalTestData(), StaffPersonalTestData.XML_REF_ID_1,
				StaffPersonalTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentAttendanceSummaryTestData(), StudentAttendanceSummaryTestData.XML_REF_ID_1,
				StudentAttendanceSummaryTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentAttendanceTimeListTestData(), StudentAttendanceTimeListTestData.XML_REF_ID_1,
				StudentAttendanceTimeListTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentContactPersonalTestData(), StudentContactPersonalTestData.XML_REF_ID_1,
				StudentContactPersonalTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentContactRelationshipTestData(), StudentContactRelationshipTestData.XML_REF_ID_1,
				StudentContactRelationshipTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentDailyAttendanceTestData(), StudentDailyAttendanceTestData.XML_REF_ID_1,
				StudentDailyAttendanceTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentPeriodAttendanceTestData(), StudentPeriodAttendanceTestData.XML_REF_ID_1,
				StudentPeriodAttendanceTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentPersonalTestData(), StudentPersonalTestData.XML_REF_ID_1,
				StudentPersonalTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentSchoolEnrollmentTestData(), StudentSchoolEnrollmentTestData.XML_REF_ID_1,
				StudentSchoolEnrollmentTestData.XML_REF_ID_2);
		generateTestXML(path, new TeachingGroupTestData(), TeachingGroupTestData.XML_REF_ID_1,
				TeachingGroupTestData.XML_REF_ID_2);
		generateTestXML(path, new TimeTableCellTestData(), TimeTableCellTestData.XML_REF_ID_1,
				TimeTableCellTestData.XML_REF_ID_2);
		generateTestXML(path, new TimeTableSubjectTestData(), TimeTableSubjectTestData.XML_REF_ID_1,
				TimeTableSubjectTestData.XML_REF_ID_2);
		generateTestXML(path, new TimeTableTestData(), TimeTableTestData.XML_REF_ID_1, TimeTableTestData.XML_REF_ID_2);
		generateTestXML(path, new VendorInfoTestData(), VendorInfoTestData.XML_REF_ID_1,
				VendorInfoTestData.XML_REF_ID_2);
		generateTestXML(path, new WellbeingAlertTestData(), WellbeingAlertTestData.XML_REF_ID_1,
				WellbeingAlertTestData.XML_REF_ID_2);
		generateTestXML(path, new WellbeingAppealTestData(), WellbeingAppealTestData.XML_REF_ID_1,
				WellbeingAppealTestData.XML_REF_ID_2);
		generateTestXML(path, new WellbeingCharacteristicTestData(), WellbeingCharacteristicTestData.XML_REF_ID_1,
				WellbeingCharacteristicTestData.XML_REF_ID_2);
		generateTestXML(path, new WellbeingEventTestData(), WellbeingEventTestData.XML_REF_ID_1,
				WellbeingEventTestData.XML_REF_ID_2);
		generateTestXML(path, new WellbeingPersonLinkTestData(), WellbeingPersonLinkTestData.XML_REF_ID_1,
				WellbeingPersonLinkTestData.XML_REF_ID_2);
		generateTestXML(path, new WellbeingResponseTestData(), WellbeingResponseTestData.XML_REF_ID_1,
				WellbeingResponseTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentScoreJudgementAgainstStandardTestData(),
				StudentScoreJudgementAgainstStandardTestData.XML_REF_ID_1,
				StudentScoreJudgementAgainstStandardTestData.XML_REF_ID_2);
		generateTestXML(path, new TermInfoTestData(), TermInfoTestData.XML_REF_ID_1, TermInfoTestData.XML_REF_ID_2);
		generateTestXML(path, new SchoolCourseInfoTestData(), SchoolCourseInfoTestData.XML_REF_ID_1,
				SchoolCourseInfoTestData.XML_REF_ID_2);
		generateTestXML(path, new AddressCollectionTestData(), AddressCollectionTestData.XML_REF_ID_1,
				AddressCollectionTestData.XML_REF_ID_2);
		generateTestXML(path, new CensusCollectionTestData(), CensusCollectionTestData.XML_REF_ID_1,
				CensusCollectionTestData.XML_REF_ID_2);
		generateTestXML(path, new CollectionRoundTestData(), CollectionRoundTestData.XML_REF_ID_1,
				CollectionRoundTestData.XML_REF_ID_2);
		generateTestXML(path, new CollectionStatusTestData(), CollectionStatusTestData.XML_REF_ID_1,
				CollectionStatusTestData.XML_REF_ID_2);
		generateTestXML(path, new FinancialQuestionnaireCollectionTestData(), FinancialQuestionnaireCollectionTestData.XML_REF_ID_1,
				FinancialQuestionnaireCollectionTestData.XML_REF_ID_2);
		generateTestXML(path, new StudentAttendanceCollectionTestData(), StudentAttendanceCollectionTestData.XML_REF_ID_1,
				StudentAttendanceCollectionTestData.XML_REF_ID_2);
		generateTestXML(path, new LibraryPatronStatusTestData(), LibraryPatronStatusTestData.XML_REF_ID_1,
				LibraryPatronStatusTestData.XML_REF_ID_2);
	}

	public static <T, C> void generateTestXML(String path, TestData<T, C> testData, String refId1, String refId2)
			throws MarshalException, UnsupportedMediaTypeExcpetion {
		T single = testData.getTestObject(refId1);
		C collection = testData.getTestCollection(refId1, refId2);
		DataModelMarshalFactory marshaller = new DataModelMarshalFactory();
		String xmlOne = marshaller.marshalToXML(single);
		String xmlTwo = marshaller.marshalToXML(collection);
		try (java.io.BufferedWriter writer = new java.io.BufferedWriter(
				new java.io.FileWriter(path + "/" + testData.getSingleObjectXMLFilename()))) {
			writer.write(xmlOne);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (java.io.BufferedWriter writer = new java.io.BufferedWriter(
				new java.io.FileWriter(path + "/" + testData.getMultiObjectXMLFilename()))) {
			writer.write(xmlTwo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
