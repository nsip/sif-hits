package sif3.hits.rest.consumer.util;

import sif.dd.au30.conversion.DataModelMarshalFactory;
import sif3.common.exception.MarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.hits.rest.consumer.data.*;

import java.io.IOException;

public class XMLGenerator {
    public static void main(String[] args) throws MarshalException, UnsupportedMediaTypeExcpetion {
        String path = "/Users/ben/Development/nsip/sif-hits/src/test/resources/xml";
        generateTestXML(path, new CalendarDateTestData(), CalendarDateTestData.XML_REF_ID_1, CalendarDateTestData.XML_REF_ID_2);
        generateTestXML(path, new CalendarSummaryTestData(), CalendarSummaryTestData.XML_REF_ID_1, CalendarSummaryTestData.XML_REF_ID_2);
        generateTestXML(path, new ChargedLocationInfoTestData(), ChargedLocationInfoTestData.XML_REF_ID_1, ChargedLocationInfoTestData.XML_REF_ID_2);
        generateTestXML(path, new DebtorTestData(), DebtorTestData.XML_REF_ID_1, DebtorTestData.XML_REF_ID_2);
        generateTestXML(path, new FinancialAccountTestData(), FinancialAccountTestData.XML_REF_ID_1, FinancialAccountTestData.XML_REF_ID_2);
        generateTestXML(path, new GradingAssignmentTestData(), GradingAssignmentTestData.XML_REF_ID_1, GradingAssignmentTestData.XML_REF_ID_2);
        generateTestXML(path, new GradingAssignmentScoreTestData(), GradingAssignmentScoreTestData.XML_REF_ID_1, GradingAssignmentScoreTestData.XML_REF_ID_2);
        generateTestXML(path, new InvoiceTestData(), InvoiceTestData.XML_REF_ID_1, InvoiceTestData.XML_REF_ID_2);
        generateTestXML(path, new JournalTestData(), JournalTestData.XML_REF_ID_1, JournalTestData.XML_REF_ID_2);
        generateTestXML(path, new NAPEventStudentLinkTestData(), NAPEventStudentLinkTestData.XML_REF_ID_1, NAPEventStudentLinkTestData.XML_REF_ID_2);
        generateTestXML(path, new NAPStudentResponseSetTestData(), NAPStudentResponseSetTestData.XML_REF_ID_1, NAPStudentResponseSetTestData.XML_REF_ID_2);
        generateTestXML(path, new NAPTestTestData(), NAPTestTestData.XML_REF_ID_1, NAPTestTestData.XML_REF_ID_2);
        generateTestXML(path, new NAPTestItemTestData(), NAPTestItemTestData.XML_REF_ID_1, NAPTestItemTestData.XML_REF_ID_2);
        generateTestXML(path, new NAPTestletTestData(), NAPTestletTestData.XML_REF_ID_1, NAPTestletTestData.XML_REF_ID_2);
        generateTestXML(path, new NAPTestScoreSummaryTestData(), NAPTestScoreSummaryTestData.XML_REF_ID_1, NAPTestScoreSummaryTestData.XML_REF_ID_2);
        generateTestXML(path, new PaymentReceiptTestData(), PaymentReceiptTestData.XML_REF_ID_1, PaymentReceiptTestData.XML_REF_ID_2);
        generateTestXML(path, new PersonalisedPlanTestData(), PersonalisedPlanTestData.XML_REF_ID_1, PersonalisedPlanTestData.XML_REF_ID_2);
        generateTestXML(path, new PersonPictureTestData(), PersonPictureTestData.XML_REF_ID_1, PersonPictureTestData.XML_REF_ID_2);
        generateTestXML(path, new PurchaseOrderTestData(), PurchaseOrderTestData.XML_REF_ID_1, PurchaseOrderTestData.XML_REF_ID_2);
        generateTestXML(path, new RoomInfoTestData(), RoomInfoTestData.XML_REF_ID_1, RoomInfoTestData.XML_REF_ID_2);
        generateTestXML(path, new ScheduledActivityTestData(), ScheduledActivityTestData.XML_REF_ID_1, ScheduledActivityTestData.XML_REF_ID_2);
        generateTestXML(path, new SchoolInfoTestData(), SchoolInfoTestData.XML_REF_ID_1, SchoolInfoTestData.XML_REF_ID_2);
        generateTestXML(path, new SessionInfoTestData(), SessionInfoTestData.XML_REF_ID_1, SessionInfoTestData.XML_REF_ID_2);
        generateTestXML(path, new StaffAssignmentTestData(), StaffAssignmentTestData.XML_REF_ID_1, StaffAssignmentTestData.XML_REF_ID_2);
        generateTestXML(path, new StaffPersonalTestData(), StaffPersonalTestData.XML_REF_ID_1, StaffPersonalTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentAttendanceSummaryTestData(), StudentAttendanceSummaryTestData.XML_REF_ID_1, StudentAttendanceSummaryTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentAttendanceTimeListTestData(), StudentAttendanceTimeListTestData.XML_REF_ID_1, StudentAttendanceTimeListTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentContactPersonalTestData(), StudentContactPersonalTestData.XML_REF_ID_1, StudentContactPersonalTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentContactRelationshipTestData(), StudentContactRelationshipTestData.XML_REF_ID_1, StudentContactRelationshipTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentDailyAttendanceTestData(), StudentDailyAttendanceTestData.XML_REF_ID_1, StudentDailyAttendanceTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentPeriodAttendanceTestData(), StudentPeriodAttendanceTestData.XML_REF_ID_1, StudentPeriodAttendanceTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentPersonalTestData(), StudentPersonalTestData.XML_REF_ID_1, StudentPersonalTestData.XML_REF_ID_2);
        generateTestXML(path, new StudentSchoolEnrollmentTestData(), StudentSchoolEnrollmentTestData.XML_REF_ID_1, StudentSchoolEnrollmentTestData.XML_REF_ID_2);
        generateTestXML(path, new TeachingGroupTestData(), TeachingGroupTestData.XML_REF_ID_1, TeachingGroupTestData.XML_REF_ID_2);
        generateTestXML(path, new TimeTableCellTestData(), TimeTableCellTestData.XML_REF_ID_1, TimeTableCellTestData.XML_REF_ID_2);
        generateTestXML(path, new TimeTableSubjectTestData(), TimeTableSubjectTestData.XML_REF_ID_1, TimeTableSubjectTestData.XML_REF_ID_2);
        generateTestXML(path, new TimeTableTestData(), TimeTableTestData.XML_REF_ID_1, TimeTableTestData.XML_REF_ID_2);
        generateTestXML(path, new VendorInfoTestData(), VendorInfoTestData.XML_REF_ID_1, VendorInfoTestData.XML_REF_ID_2);
        generateTestXML(path, new WellbeingAlertTestData(), WellbeingAlertTestData.XML_REF_ID_1, WellbeingAlertTestData.XML_REF_ID_2);
        generateTestXML(path, new WellbeingAppealTestData(), WellbeingAppealTestData.XML_REF_ID_1, WellbeingAppealTestData.XML_REF_ID_2);
        generateTestXML(path, new WellbeingCharacteristicTestData(), WellbeingCharacteristicTestData.XML_REF_ID_1, WellbeingCharacteristicTestData.XML_REF_ID_2);
        generateTestXML(path, new WellbeingEventTestData(), WellbeingEventTestData.XML_REF_ID_1, WellbeingEventTestData.XML_REF_ID_2);
        generateTestXML(path, new WellbeingPersonLinkTestData(), WellbeingPersonLinkTestData.XML_REF_ID_1, WellbeingPersonLinkTestData.XML_REF_ID_2);
        generateTestXML(path, new WellbeingResponseTestData(), WellbeingResponseTestData.XML_REF_ID_1, WellbeingResponseTestData.XML_REF_ID_2);
//        generateTestXML(path, new AGStatusReportTestData(), AGStatusReportTestData.XML_REF_ID_1, AGStatusReportTestData.XML_REF_ID_2);
//        generateTestXML(path, new AGAddressCollectionSubmissionTestData(), AGAddressCollectionSubmissionTestData.XML_REF_ID_1, AGAddressCollectionSubmissionTestData.XML_REF_ID_2);
//        generateTestXML(path, new FinancialQuestionnaireSubmissionTestData(), FinancialQuestionnaireSubmissionTestData.XML_REF_ID_1, FinancialQuestionnaireSubmissionTestData.XML_REF_ID_2);
    }

    public static <T,C> void generateTestXML(String path, TestData<T,C> testData, String refId1, String refId2) throws MarshalException, UnsupportedMediaTypeExcpetion {
        T single = testData.getTestObject(refId1);
        C collection = testData.getTestCollection(refId1, refId2);
        DataModelMarshalFactory marshaller = new DataModelMarshalFactory();
        String xmlOne = marshaller.marshalToXML(single);
        String xmlTwo = marshaller.marshalToXML(collection);
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(path + "/" + testData.getSingleObjectXMLFilename()))) {
            writer.write(xmlOne);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(path + "/" + testData.getMultiObjectXMLFilename()))) {
            writer.write(xmlTwo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
