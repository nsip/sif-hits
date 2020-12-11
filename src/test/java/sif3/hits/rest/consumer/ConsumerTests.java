package sif3.hits.rest.consumer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// @formatter:off
@RunWith(Suite.class)
@SuiteClasses({ InitialiseDataTests.class, IntegrationTests.class })
public class ConsumerTests {
	public static Class<?>[] CONSUMER_CLASSES = new Class<?>[] { SchoolInfoConsumerTest.class,
			RoomInfoConsumerTest.class, StudentPersonalConsumerTest.class, StudentSchoolEnrollmentConsumerTest.class,
			StaffPersonalConsumerTest.class, StaffAssignmentConsumerTest.class, CalendarSummaryConsumerTest.class,
			CalendarDateConsumerTest.class, StudentDailyAttendanceConsumerTest.class,
			StudentAttendanceSummaryConsumerTest.class, TimeTableConsumerTest.class, TimeTableSubjectConsumerTest.class,
			TeachingGroupConsumerTest.class, TimeTableCellConsumerTest.class, ScheduledActivityConsumerTest.class,
			SessionInfoConsumerTest.class, StudentPeriodAttendanceConsumerTest.class,
			StudentAttendanceTimeListConsumerTest.class, StudentContactPersonalConsumerTest.class,
			StudentContactRelationshipConsumerTest.class, GradingAssignmentConsumerTest.class,
			GradingAssignmentScoreConsumerTest.class, ChargedLocationInfoConsumerTest.class,
			FinancialAccountConsumerTest.class, VendorInfoConsumerTest.class, DebtorConsumerTest.class,
			JournalConsumerTest.class, PurchaseOrderConsumerTest.class, InvoiceConsumerTest.class,
			PaymentReceiptConsumerTest.class, PersonPictureConsumerTest.class, NAPTestConsumerTest.class,
			NAPEventStudentLinkConsumerTest.class, NAPTestScoreSummaryConsumerTest.class, NAPTestItemConsumerTest.class,
			NAPTestletConsumerTest.class, NAPStudentResponseSetConsumerTest.class, NAPCodeFrameConsumerTest.class,
			PersonalisedPlanConsumerTest.class, WellbeingResponseConsumerTest.class, WellbeingEventConsumerTest.class,
			WellbeingCharacteristicConsumerTest.class, WellbeingAppealConsumerTest.class,
			WellbeingAlertConsumerTest.class, WellbeingPersonLinkConsumerTest.class,
			StudentScoreJudgementAgainstStandardConsumerTest.class, TermInfoConsumerTest.class,
			SchoolCourseInfoConsumerTest.class, AddressCollectionConsumerTest.class, CensusCollectionConsumerTest.class,
			CollectionRoundConsumerTest.class, CollectionStatusConsumerTest.class,
			FinancialQuestionnaireCollectionConsumerTest.class, StudentAttendanceCollectionConsumerTest.class,
			LibraryPatronStatusConsumerTest.class };

	/*
	 * <pre> delete from hits_sif3_infra.SIF3_SESSION;
	 * 
	 * delete from LibraryPatronStatus_LocalCode; delete from
	 * LibraryPatronStatus_Message; delete from
	 * LibraryPatronStatus_Transaction_FineInfo; delete from
	 * LibraryPatronStatus_Transaction_HoldInfo; delete from
	 * LibraryPatronStatus_Transaction_Checkout; delete from
	 * LibraryPatronStatus_Transaction_Item; delete from
	 * LibraryPatronStatus_Transaction; delete from
	 * LibraryPatronStatus_ElectronicId; delete from LibraryPatronStatus_PatronName;
	 * delete from LibraryPatronStatus; delete from
	 * StudentAttendanceCR_YearLevel_StatsCohort; delete from
	 * StudentAttendanceCR_StatsCohortYearLevel; delete from
	 * StudentAttendanceCR_EntityContact_Address_StatisticalArea; delete from
	 * StudentAttendanceCR_EntityContact_Address; delete from
	 * StudentAttendanceCR_EntityContact_Name; delete from
	 * StudentAttendanceCR_EntityContact; delete from
	 * StudentAttendanceCollectionReporting; delete from
	 * StudentAttendanceCollection_LocalCode; delete from
	 * StudentAttendanceCollection; delete from FQReporting_AGRule; delete from
	 * FQReporting_FQItem; delete from FQReporting_ContextualQuestion; delete from
	 * FQReporting_EntityContact_Address_StatisticalArea; delete from
	 * FQReporting_EntityContact_Address; delete from
	 * FQReporting_EntityContact_Name; delete from FQReporting_EntityContact; delete
	 * from FQReporting; delete from FQCollection_LocalCode; delete from
	 * FinancialQuestionnaireCollection; delete from
	 * CollectionStatus_AGROResponse_AGRule; delete from
	 * CollectionStatus_AGReportingObjectResponse; delete from
	 * CollectionStatus_LocalCode; delete from CollectionStatus; delete from
	 * AGRound; delete from CollectionRound_LocalCode; delete from CollectionRound;
	 * delete from CensusReporting_Student; delete from
	 * CensusReporting_Staff_ActivityOtherCode; delete from CensusReporting_Staff;
	 * delete from CensusReporting_EntityContact_Address_StatisticalArea; delete
	 * from CensusReporting_EntityContact_Address; delete from
	 * CensusReporting_EntityContact_Name; delete from
	 * CensusReporting_EntityContact; delete from CensusReporting; delete from
	 * CensusCollection; delete from AddressCR_Parent_Address_StatisticalArea;
	 * delete from AddressCR_Parent_Address; delete from AddressCR_Parent_Name;
	 * delete from AddressCR_Parent; delete from
	 * AddressCR_Student_Address_StatisticalArea; delete from
	 * AddressCR_Student_Address; delete from AddressCR_Student; delete from
	 * AddressCR_EntityContact_Address_StatisticalArea; delete from
	 * AddressCR_EntityContact_Address; delete from AddressCR_EntityContact_Name;
	 * delete from AddressCR_EntityContact; delete from
	 * AddressCR_ContextualQuestion; delete from AddressCollectionReporting; delete
	 * from AddressCollection_LocalCode; delete from AddressCollection; delete from
	 * SchoolCourseInfo_SubjectArea_Code; delete from SchoolCourseInfo_SubjectArea;
	 * delete from SchoolCourseInfo; delete from TermInfo; delete from
	 * StudentScoreJAS_LearningStandard; delete from
	 * StudentScoreJudgementAgainstStandard; delete from
	 * WellbeingPersonLink_FollowupAction; delete from WellbeingPersonLink; delete
	 * from TimeTableCell_TeacherCover; delete from
	 * StudentAttendanceTimeList_PeriodAttendance_OtherCode; delete from
	 * StudentAttendanceTimeList_PeriodAttendance_TeacherCover; delete from
	 * StudentAttendanceTimeList_PeriodAttendance_RoomInfo; delete from
	 * StudentAttendanceTimeList_PeriodAttendance; delete from WellbeingAlert;
	 * delete from WellbeingAppeal_Document; delete from WellbeingAppeal; delete
	 * from WellbeingCharacteristic_Symptom; delete from
	 * WellbeingCharacteristic_Medication; delete from
	 * WellbeingCharacteristic_Document; delete from WellbeingCharacteristic; delete
	 * from WellbeingEvent_FollowupAction; delete from
	 * WellbeingEvent_PersonInvolvement; delete from WellbeingEvent_Subcategory;
	 * delete from WellbeingEvent_Category; delete from WellbeingEvent_Document;
	 * delete from WellbeingEvent; delete from WellbeingResponse_Document; delete
	 * from WellbeingResponse_PersonInvolvement; delete from
	 * WellbeingResponse_PlanRequiredContainer_PlanRequired; delete from
	 * WellbeingResponse_SuspensionContainer_WithdrawalTime; delete from
	 * WellbeingResponse; delete from PersonalisedPlan_Document; delete from
	 * PersonalisedPlan; delete from NAPCodeFrame; delete from
	 * NAPStudentResponseSet_Testlet_TestItem_Subscore; delete from
	 * NAPStudentResponseSet_Testlet_TestItem; delete from
	 * NAPStudentResponseSet_Testlet; delete from NAPStudentResponseSet_DomainScore;
	 * delete from NAPStudentResponseSet; delete from NAPTestlet_TestItem; delete
	 * from NAPTestItem_NAPWritingRubric_Score_ScoreDescription; delete from
	 * NAPTestItem_NAPWritingRubric_Score; delete from NAPTestItem_NAPWritingRubric;
	 * delete from ItemSubstitutedFor_PNPCode; delete from
	 * NAPTestItem_SubstituteItem; delete from NAPTestItem_Stimulus; delete from
	 * NAPTestItem_ContentDescription; delete from NAPTestItem; delete from
	 * NAPTestlet; delete from NAPTestScoreSummary; delete from
	 * NAPEventStudentLink_Adjustment_PNPCode; delete from
	 * NAPEventStudentLink_Adjustment; delete from
	 * NAPEventStudentLink_TestDisruption; delete from NAPEventStudentLink; delete
	 * from NAPTest; delete from PersonPicture_PublishingPermission; delete from
	 * PersonPicture; delete from GradingAssignmentScore; delete from
	 * GradingAssignment; delete from Journal_JournalAdjustment; delete from
	 * Journal; delete from PurchaseOrder_PurchasingItem_ExpenseAccount; delete from
	 * PurchaseOrder_PurchasingItems; delete from PaymentReceipt_PaymentReceiptLine;
	 * delete from PaymentReceipt_AccountCode; delete from
	 * PaymentReceipt_FinancialAccount; delete from PaymentReceipt; delete from
	 * VendorInfo; delete from Debtor; delete from Invoice_FinancialAccount; update
	 * FinancialAccount set SubAccount_RefId = null; delete from FinancialAccount;
	 * delete from FinancialClass; delete from Invoice_AccountCode; delete from
	 * Invoice; delete from PurchaseOrder; update LocationInfo set
	 * Parent_LocationInfo_RefId = null; delete from LocationInfo; delete from
	 * StudentAttendanceTimeList_AttendanceTime_OtherCode; delete from
	 * StudentAttendanceTimeList_AttendanceTime; delete from
	 * StudentAttendanceTimeList; delete from StudentPeriodAttendance; delete from
	 * SessionInfo; delete from StudentAttendanceSummary; delete from
	 * StudentDailyAttendance; delete from CalendarSummary_YearLevel; delete from
	 * CalendarDateType_OtherCodeList; delete from CalendarDate; delete from
	 * CalendarSummary; delete from ScheduledActivity_TeachingGroup; delete from
	 * ScheduledActivity_Room; delete from ScheduledActivity_Teacher; delete from
	 * ScheduledActivity_Student; delete from ScheduledActivity; delete from
	 * Identity; delete from TimeTableCell; delete from TimeTable_Period; delete
	 * from TimeTable_Day; delete from TimeTable; delete from TeachingGroup_Teacher;
	 * delete from TeachingGroup_Student; delete from TeachingGroup; delete from
	 * TimeTableSubject_OtherCodeList; delete from TimeTableSubject; delete from
	 * RoomInfo; delete from StudentContactRelationship; delete from
	 * StudentContactPersonal; delete from StaffAssignment_StaffSubject; delete from
	 * StaffAssignment_CalendarSummary; delete from StaffAssignment_YearLevel;
	 * delete from StaffAssignment; delete from Address; delete from
	 * StaffPersonal_OtherId; delete from StaffPersonal; delete from
	 * StudentSchoolEnrollment_StudentSubjectChoice; delete from
	 * StudentSchoolEnrollment_StudentGroup; delete from
	 * StudentSchoolEnrollment_PublishingPermission; delete from
	 * StudentSchoolEnrollment; delete from Language; delete from
	 * StudentPersonal_OtherId; delete from StudentPersonal; delete from SchoolInfo;
	 * delete from CodeSet; </pre>
	 */
}
//@formatter:on