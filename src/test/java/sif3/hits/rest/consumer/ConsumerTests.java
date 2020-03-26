package sif3.hits.rest.consumer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// @formatter:off
@RunWith(Suite.class)
@SuiteClasses({
        InitialiseDataTests.class,
        IntegrationTests.class
})
public class ConsumerTests {
    public static Class<?>[] CONSUMER_CLASSES = new Class<?>[]{
            SchoolInfoConsumerTest.class,
            RoomInfoConsumerTest.class,
            StudentPersonalConsumerTest.class,
            StudentSchoolEnrollmentConsumerTest.class,
            StaffPersonalConsumerTest.class,
            StaffAssignmentConsumerTest.class,
            CalendarSummaryConsumerTest.class,
            CalendarDateConsumerTest.class,
            StudentDailyAttendanceConsumerTest.class,
            StudentAttendanceSummaryConsumerTest.class,
            TimeTableConsumerTest.class,
            TimeTableSubjectConsumerTest.class,
            TeachingGroupConsumerTest.class,
            TimeTableCellConsumerTest.class,
            ScheduledActivityConsumerTest.class,
            SessionInfoConsumerTest.class,
            StudentPeriodAttendanceConsumerTest.class,
            StudentAttendanceTimeListConsumerTest.class,
            StudentContactPersonalConsumerTest.class,
            StudentContactRelationshipConsumerTest.class,
            GradingAssignmentConsumerTest.class,
            GradingAssignmentScoreConsumerTest.class,
            ChargedLocationInfoConsumerTest.class,
            FinancialAccountConsumerTest.class,
            VendorInfoConsumerTest.class,
            DebtorConsumerTest.class,
            JournalConsumerTest.class,
            PurchaseOrderConsumerTest.class,
            InvoiceConsumerTest.class,
            PaymentReceiptConsumerTest.class,
            PersonPictureConsumerTest.class,
            NAPTestConsumerTest.class,
            NAPEventStudentLinkConsumerTest.class,
            NAPTestScoreSummaryConsumerTest.class,
            NAPTestItemConsumerTest.class,
            NAPTestletConsumerTest.class,
            NAPStudentResponseSetConsumerTest.class,
            NAPCodeFrameConsumerTest.class,
            PersonalisedPlanConsumerTest.class,
            WellbeingResponseConsumerTest.class,
            WellbeingEventConsumerTest.class,
            WellbeingCharacteristicConsumerTest.class,
            WellbeingAppealConsumerTest.class,
            WellbeingAlertConsumerTest.class,
//            AGStatusReportConsumerTest.class,
//            FinancialQuestionnaireSubmissionConsumerTest.class,
            WellbeingPersonLinkConsumerTest.class,
//            AGAddressCollectionSubmissionConsumerTest.class,
            StudentScoreJudgementAgainstStandardTest.class
    };
    
    
/* 
 * <pre>
delete from hits_sif3_infra.SIF3_SESSION;

delete from WellbeingAlert;
delete from WellbeingAppeal_Document;
delete from WellbeingAppeal;
delete from WellbeingCharacteristic_Medication;
delete from WellbeingCharacteristic_Document;
delete from WellbeingCharacteristic;
delete from WellbeingEvent_Subcategory;
delete from WellbeingEvent_Category;
delete from WellbeingEvent_FollowupAction;
delete from WellbeingEvent_Document;
delete from WellbeingEvent_PersonInvolvement;
delete from WellbeingEvent;
delete from WellbeingResponse_SuspensionContainer_WithdrawalTime;
delete from WellbeingResponse_PlanRequiredContainer_PlanRequired;
delete from WellbeingResponse_PersonInvolvement;
delete from WellbeingResponse_Document;
delete from WellbeingResponse;
delete from PersonalisedPlan_Document;
delete from PersonalisedPlan;
delete from NAPCodeFrame;
delete from NAPStudentResponseSet_Testlet_TestItem_Subscore;
delete from NAPStudentResponseSet_Testlet_TestItem;
delete from NAPStudentResponseSet_Testlet;
delete from NAPStudentResponseSet_DomainScore;
delete from NAPStudentResponseSet;
delete from NAPTestlet_TestItem;
delete from NAPTestItem_NAPWritingRubric_Score_ScoreDescription;
delete from NAPTestItem_NAPWritingRubric_Score;
delete from NAPTestItem_NAPWritingRubric;
delete from ItemSubstitutedFor_PNPCode;
delete from NAPTestItem_SubstituteItem;
delete from NAPTestItem_Stimulus;
delete from NAPTestItem_ContentDescription;
delete from NAPTestItem;
delete from NAPTestlet;
delete from NAPTestScoreSummary;
delete from NAPEventStudentLink_Adjustment_PNPCode;
delete from NAPEventStudentLink_Adjustment;
delete from NAPEventStudentLink_TestDisruption;
delete from NAPEventStudentLink;
delete from NAPTest;
delete from PersonPicture;
delete from Journal;
delete from Invoice_FinancialAccount;
delete from PaymentReceipt_FinancialAccount;
delete from PurchaseOrder_PurchasingItem_ExpenseAccount;
delete from PurchaseOrder_PurchasingItems;
update FinancialAccount set SubAccount_RefId = null;
delete from FinancialAccount;
update LocationInfo set Parent_LocationInfo_RefId = null;
delete from FinancialClass;
delete from PaymentReceipt;
delete from Invoice;
delete from PurchaseOrder;
delete from LocationInfo;
delete from VendorInfo;
delete from Debtor;
delete from GradingAssignmentScore;
delete from GradingAssignment;
delete from Address;
delete from StudentAttendanceTimeList_PeriodAttendance_OtherCode;
delete from StudentAttendanceTimeList_PeriodAttendance_TeacherCover;
delete from StudentAttendanceTimeList_PeriodAttendance_RoomInfo;
delete from StudentAttendanceTimeList_PeriodAttendance;
delete from StudentAttendanceTimeList_AttendanceTime_OtherCode;
delete from StudentAttendanceTimeList_AttendanceTime;
delete from StudentAttendanceTimeList;
delete from StudentPeriodAttendance;
delete from SessionInfo;
delete from ScheduledActivity_Room;
delete from ScheduledActivity_Student;
delete from ScheduledActivity_Teacher;
delete from ScheduledActivity_TeachingGroup;
delete from ScheduledActivity;
delete from StudentAttendanceSummary;
delete from StudentDailyAttendance;
delete from TeachingGroup_Student;
delete from TeachingGroup_Teacher;
delete from TimeTableCell;
delete from TimeTableSubject_OtherCodeList;
delete from TimeTable_Period;
delete from TimeTable_Day;
delete from TimeTableSubject;
delete from TimeTable;
delete from TeachingGroup;
delete from CalendarDateType_OtherCodeList;
delete from CalendarDate;
delete from CalendarSummary_YearLevel;
delete from CalendarSummary;
delete from StudentContactRelationship;
delete from StudentContactPersonal;
delete from StudentSchoolEnrollment;
delete from StudentPersonal_OtherId;
delete from StudentPersonal;
delete from StaffAssignment;
delete from StaffPersonal_OtherId;
delete from StaffPersonal;
delete from RoomInfo;
delete from SchoolInfo; 

</pre>
 */
}
//@formatter:on