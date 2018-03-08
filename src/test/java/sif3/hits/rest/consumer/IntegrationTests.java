package sif3.hits.rest.consumer;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import sif3.hits.rest.consumer.category.IntegrationTest;
//@formatter:off
@RunWith(Categories.class)
@IncludeCategory(IntegrationTest.class)
@SuiteClasses({
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
  LocationInfoConsumerTest.class,
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
  NAPTestletConsumerTest.class,
  NAPTestItemConsumerTest.class,
  NAPStudentResponseSetConsumerTest.class,
  NAPCodeFrameConsumerTest.class,
  PersonalisedPlanConsumerTest.class,
  WellbeingResponseConsumerTest.class
})
public class IntegrationTests {

}
