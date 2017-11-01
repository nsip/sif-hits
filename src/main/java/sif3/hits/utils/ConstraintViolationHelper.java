package sif3.hits.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import sif3.hits.rest.dto.RequestDTO;
import sif3.hits.rest.dto.ResponseDTO;
import sif3.hits.service.e.OperationStatus;

public class ConstraintViolationHelper {

  private static final Pattern OBJECT_NAME_PATTERN = Pattern.compile("CONSTRAINT `([^`]*)`");
  
  public static final int DELETE = 1;
  public static final int CREATE = 2;
  public static final int UPDATE = 4;
  
  private static final Map<String, String> constraintMap = new HashMap<String, String>();
  static {
    constraintMap.put("CalendarDate_ibfk_1","CalendarDate to CalendarSummary");
    constraintMap.put("CalendarDate_ibfk_2","CalendarDate to SchoolInfo");
    constraintMap.put("CalendarDateType_OtherCodeList_ibfk_1","CalendarDateType_OtherCodeList to CalendarDate");
    constraintMap.put("CalendarSummary_ibfk_1","CalendarSummary to SchoolInfo");
    constraintMap.put("CalendarSummary_YearLevel_ibfk_1","CalendarSummary_YearLevel to CalendarSummary");
    constraintMap.put("FinancialAccount_ibfk_1","FinancialAccount to LocationInfo");
    constraintMap.put("FinancialAccount_ibfk_2","FinancialAccount to FinancialAccount");
    constraintMap.put("FinancialAccount_ibfk_3","FinancialAccount to FinancialClass");
    constraintMap.put("GradingAssignment_ibfk_1","GradingAssignment to TeachingGroup");
    constraintMap.put("GradingAssignmentScore_ibfk_1","GradingAssignmentScore to StudentPersonal");
    constraintMap.put("GradingAssignmentScore_ibfk_2","GradingAssignmentScore to TeachingGroup");
    constraintMap.put("GradingAssignmentScore_ibfk_3","GradingAssignmentScore to GradingAssignment");
    constraintMap.put("Invoice_ibfk_1","Invoice to LocationInfo");
    constraintMap.put("Invoice_ibfk_2","Invoice to PurchaseOrder");
    constraintMap.put("Invoice_FinancialAccount_ibfk_1","Invoice_FinancialAccount to Invoice");
    constraintMap.put("Invoice_FinancialAccount_ibfk_2","Invoice_FinancialAccount to FinancialAccount");
    constraintMap.put("ItemSubstitutedFor_FK","ItemSubstitutedFor_PNPCode to NAPTestItem_SubstituteItem");
    constraintMap.put("Journal_ibfk_1","Journal to FinancialAccount");
    constraintMap.put("Journal_ibfk_2","Journal to FinancialAccount");
    constraintMap.put("LocationInfo_ibfk_1","LocationInfo to LocationInfo");
    constraintMap.put("LocationInfo_ibfk_2","LocationInfo to SchoolInfo");
    constraintMap.put("NAPCodeFrame_NAPTest_FK","NAPCodeFrame to NAPTest");
    constraintMap.put("NAPEventStudentLink_NAPTest_FK","NAPEventStudentLink to NAPTest");
    constraintMap.put("NAPEventStudentLink_Adjustment_FK","NAPEventStudentLink_Adjustment to NAPEventStudentLink");
    constraintMap.put("Adjustment_PNPCode_FK","NAPEventStudentLink_Adjustment_PNPCode to NAPEventStudentLink_Adjustment");
    constraintMap.put("NAPEventStudentLink_TestDisruption_FK","NAPEventStudentLink_TestDisruption to NAPEventStudentLink");
    constraintMap.put("NAPStudentResponseSet_NAPTest_FK","NAPStudentResponseSet to NAPTest");
    constraintMap.put("DomainScore_NAPStudentResponseSet_FK","NAPStudentResponseSet_DomainScore to NAPStudentResponseSet");
    constraintMap.put("TestletResponse_NAPStudentResponseSet_FK","NAPStudentResponseSet_Testlet to NAPStudentResponseSet");
    constraintMap.put("TestletResponse_NAPTestlet_FK","NAPStudentResponseSet_Testlet to NAPTestlet");
    constraintMap.put("ResponseTestItem_NAPTestItem_FK","NAPStudentResponseSet_Testlet_TestItem to NAPTestItem");
    constraintMap.put("ResponseTestItem_ResponseTestlet_FK","NAPStudentResponseSet_Testlet_TestItem to NAPStudentResponseSet_Testlet");
    constraintMap.put("Subscore_ResponseTestItem_FK","NAPStudentResponseSet_Testlet_TestItem_Subscore to NAPStudentResponseSet_Testlet_TestItem");
    constraintMap.put("ContentDescription_TestItem_FK","NAPTestItem_ContentDescription to NAPTestItem");
    constraintMap.put("WritingRubric_TestItem_FK","NAPTestItem_NAPWritingRubric to NAPTestItem");
    constraintMap.put("Score_WritingRubric_FK","NAPTestItem_NAPWritingRubric_Score to NAPTestItem_NAPWritingRubric");
    constraintMap.put("ScoreDescription_Score_FK","NAPTestItem_NAPWritingRubric_Score_ScoreDescription to NAPTestItem_NAPWritingRubric_Score");
    constraintMap.put("Stimulus_TestItem_FK","NAPTestItem_Stimulus to NAPTestItem");
    constraintMap.put("SubstituteItem_FK","NAPTestItem_SubstituteItem to NAPTestItem");
    constraintMap.put("TestItem_FK","NAPTestItem_SubstituteItem to NAPTestItem");
    constraintMap.put("TestScoreSummary_Test_FK","NAPTestScoreSummary to NAPTest");
    constraintMap.put("NAPTestlet_NAPTest_FK","NAPTestlet to NAPTest");
    constraintMap.put("TestletTestItem_TestItem_FK","NAPTestlet_TestItem to NAPTestItem");
    constraintMap.put("TestletTestItem_Testlet_FK","NAPTestlet_TestItem to NAPTestlet");
    constraintMap.put("PaymentReceipt_ibfk_1","PaymentReceipt to Invoice");
    constraintMap.put("PaymentReceipt_ibfk_2","PaymentReceipt to VendorInfo");
    constraintMap.put("PaymentReceipt_ibfk_3","PaymentReceipt to Debtor");
    constraintMap.put("PaymentReceipt_FinancialAccount_ibfk_1","PaymentReceipt_FinancialAccount to PaymentReceipt");
    constraintMap.put("PaymentReceipt_FinancialAccount_ibfk_2","PaymentReceipt_FinancialAccount to FinancialAccount");
    constraintMap.put("PurchaseOrder_ibfk_1","PurchaseOrder to StaffPersonal");
    constraintMap.put("PurchaseOrder_ibfk_2","PurchaseOrder to LocationInfo");
    constraintMap.put("PurchaseOrder_PurchasingItem_ExpenseAccount_ibfk_1","PurchaseOrder_PurchasingItem_ExpenseAccount to FinancialAccount");
    constraintMap.put("PurchaseOrder_PurchasingItems_ibfk_1","PurchaseOrder_PurchasingItems to PurchaseOrder");
    constraintMap.put("RoomInfo_ibfk_1","RoomInfo to SchoolInfo");
    constraintMap.put("ScheduledActivity_ibfk_1","ScheduledActivity to SchoolInfo");
    constraintMap.put("ScheduledActivity_ibfk_2","ScheduledActivity to TimeTableCell");
    constraintMap.put("ScheduledActivity_ibfk_3","ScheduledActivity to TimeTable");
    constraintMap.put("ScheduledActivity_ibfk_4","ScheduledActivity to TimeTableSubject");
    constraintMap.put("ScheduledActivity_Room_ibfk_1","ScheduledActivity_Room to ScheduledActivity");
    constraintMap.put("ScheduledActivity_Room_ibfk_2","ScheduledActivity_Room to RoomInfo");
    constraintMap.put("ScheduledActivity_Student_ibfk_1","ScheduledActivity_Student to ScheduledActivity");
    constraintMap.put("ScheduledActivity_Student_ibfk_2","ScheduledActivity_Student to StudentPersonal");
    constraintMap.put("ScheduledActivity_Teacher_ibfk_1","ScheduledActivity_Teacher to ScheduledActivity");
    constraintMap.put("ScheduledActivity_Teacher_ibfk_2","ScheduledActivity_Teacher to StaffPersonal");
    constraintMap.put("ScheduledActivity_TeachingGroup_ibfk_1","ScheduledActivity_TeachingGroup to ScheduledActivity");
    constraintMap.put("ScheduledActivity_TeachingGroup_ibfk_2","ScheduledActivity_TeachingGroup to TeachingGroup");
    constraintMap.put("SessionInfo_ibfk_1","SessionInfo to SchoolInfo");
    constraintMap.put("SessionInfo_ibfk_2","SessionInfo to TimeTableCell");
    constraintMap.put("StaffAssignment_ibfk_1","StaffAssignment to SchoolInfo");
    constraintMap.put("StaffAssignment_ibfk_2","StaffAssignment to StaffPersonal");
    constraintMap.put("StaffPersonal_ibfk_1","StaffPersonal to SchoolInfo");
    constraintMap.put("StaffPersonal_OtherId_ibfk_1","StaffPersonal_OtherId to StaffPersonal");
    constraintMap.put("StudentAttendanceSummary_ibfk_1","StudentAttendanceSummary to StudentPersonal");
    constraintMap.put("StudentAttendanceSummary_ibfk_2","StudentAttendanceSummary to SchoolInfo");
    constraintMap.put("StudentAttendanceTimeList_ibfk_1","StudentAttendanceTimeList to StudentPersonal");
    constraintMap.put("StudentAttendanceTimeList_ibfk_2","StudentAttendanceTimeList to SchoolInfo");
    constraintMap.put("StudentAttendanceTimeList_AttendanceTime_ibfk_1","StudentAttendanceTimeList_AttendanceTime to StudentAttendanceTimeList");
    constraintMap.put("StudentAttendanceTimeList_AttendanceTime_OtherCode_ibfk_1","StudentAttendanceTimeList_AttendanceTime_OtherCode to StudentAttendanceTimeList_AttendanceTime");
    constraintMap.put("StudentContactRelationship_ibfk_1","StudentContactRelationship to StudentPersonal");
    constraintMap.put("StudentContactRelationship_ibfk_2","StudentContactRelationship to StudentContactPersonal");
    constraintMap.put("StudentDailyAttendance_ibfk_1","StudentDailyAttendance to StudentPersonal");
    constraintMap.put("StudentDailyAttendance_ibfk_2","StudentDailyAttendance to SchoolInfo");
    constraintMap.put("StudentPeriodAttendance_ibfk_1","StudentPeriodAttendance to SchoolInfo");
    constraintMap.put("StudentPeriodAttendance_ibfk_2","StudentPeriodAttendance to StudentPersonal");
    constraintMap.put("StudentPeriodAttendance_ibfk_3","StudentPeriodAttendance to SessionInfo");
    constraintMap.put("StudentPersonal_ibfk_1","StudentPersonal to SchoolInfo");
    constraintMap.put("StudentPersonal_OtherId_ibfk_1","StudentPersonal_OtherId to StudentPersonal");
    constraintMap.put("StudentSchoolEnrollment_ibfk_1","StudentSchoolEnrollment to SchoolInfo");
    constraintMap.put("StudentSchoolEnrollment_ibfk_2","StudentSchoolEnrollment to StudentPersonal");
    constraintMap.put("TeachingGroup_ibfk_1","TeachingGroup to SchoolInfo");
    constraintMap.put("TeachingGroup_Student_ibfk_1","TeachingGroup_Student to TeachingGroup");
    constraintMap.put("TeachingGroup_Student_ibfk_2","TeachingGroup_Student to StudentPersonal");
    constraintMap.put("TeachingGroup_Teacher_ibfk_1","TeachingGroup_Teacher to TeachingGroup");
    constraintMap.put("TeachingGroup_Teacher_ibfk_2","TeachingGroup_Teacher to StaffPersonal");
    constraintMap.put("TimeTable_ibfk_1","TimeTable to SchoolInfo");
    constraintMap.put("TimeTableCell_ibfk_1","TimeTableCell to TimeTable");
    constraintMap.put("TimeTableCell_ibfk_2","TimeTableCell to TimeTableSubject");
    constraintMap.put("TimeTableCell_ibfk_3","TimeTableCell to TeachingGroup");
    constraintMap.put("TimeTableCell_ibfk_4","TimeTableCell to RoomInfo");
    constraintMap.put("TimeTableCell_ibfk_5","TimeTableCell to StaffPersonal");
    constraintMap.put("TimeTableSubject_ibfk_1","TimeTableSubject to SchoolInfo");
    constraintMap.put("TimeTableSubject_OtherCodeList_ibfk_1","TimeTableSubject_OtherCodeList to TimeTableSubject");
    constraintMap.put("TimeTable_Day_ibfk_1","TimeTable_Day to TimeTable");
  }

  public static <S> ResponseDTO<S> handleConstraintViolation(RequestDTO<S> dto, Exception ex, int context) {
    ResponseDTO<S> response = null;
    if (ex instanceof DataIntegrityViolationException) {
      Throwable cause = ex.getCause();
      if (cause != null && cause instanceof ConstraintViolationException) {
        cause = cause.getCause();
        if (cause != null) {
          response = new ResponseDTO<S>(dto, null, getOperationStatus(context), getConstraintMessage(cause.getMessage(), context));
        }
      }
    }
    return response;
  }
  
  private static OperationStatus getOperationStatus(int context) {
    if ((context & DELETE) == DELETE) {
      return OperationStatus.DELETE_ERR_CONSTRAINT;
    } else if ((context & UPDATE) == UPDATE) {
      return OperationStatus.UPDATE_ERR_CONSTRAINT;
    } else {
      return OperationStatus.CREATE_ERR_CONSTRAINT;
    }
  }

  private static String getConstraintMessage(String message, int context) {
    String result = "";
    if ((context & DELETE) == DELETE) {
      result = "Cannot delete object because it has child objects";
    } else if ((context & UPDATE) == UPDATE) {
      result = "Cannot update object because we are unable to find referenced child objects";
    } else {
      result = "Cannot create object because we are unable to find referenced child objects";
    }
    String constraintName = getContraintName(message);
    if (StringUtils.isBlank(constraintName)) {
      constraintName = ".";
    } else {
      constraintName = " (" + constraintName + ")";
    }
    return result + constraintName;
  }

  private static String getContraintName(String message) {
    String result = null;
    Matcher matcher = OBJECT_NAME_PATTERN.matcher(message);
    if (matcher.find()) {
      result = matcher.group(1);
      result = constraintMap.get(result);
    }
    return result;
  }
}
