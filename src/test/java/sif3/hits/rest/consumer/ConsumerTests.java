package sif3.hits.rest.consumer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  SchoolInfoConsumerTest.class,
  RoomInfoConsumerTest.class,
  StudentPersonalConsumerTest.class,
  StudentSchoolEnrollmentConsumerTest.class,
  StaffPersonalConsumerTest.class,
  StaffAssignmentConsumerTest.class,
  CalendarSummaryConsumerTest.class,
  CalendarDateConsumerTest.class,
  StudentDailyAttendanceTest.class,
  StudentAttendanceSummaryTest.class,
  TimeTableConsumerTest.class,
  TimeTableSubjectConsumerTest.class,
  TeachingGroupConsumerTest.class,
  TimeTableCellConsumerTest.class,
  ScheduledActivityTest.class,
  SessionInfoConsumerTest.class,
  StudentPeriodAttendanceTest.class
})
public class ConsumerTests {
/*
 * On an empty database you will see 35 failures on first run.
 * This first run will create all necessary data.
 * Subsequent executions should see 0 failures.
 * 
 * <pre>
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
delete from TimeTable_Day;
delete from TimeTable_Period;
delete from TimeTableSubject;
delete from TimeTable;
delete from TeachingGroup;
delete from CalendarDateType_OtherCodeList;
delete from CalendarDate;
delete from CalendarSummary_YearLevel;
delete from CalendarSummary;
delete from StudentSchoolEnrollment;
delete from StudentPersonal_OtherId;
delete from StudentPersonal;
delete from StaffAssignment;
delete from StaffPersonal_OtherId;
delete from StaffPersonal;
delete from RoomInfo;
delete from SchoolInfo;
 * </pre>
 */
}
