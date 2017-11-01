package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsCalendarEventType;
import sif.dd.au30.model.AttendanceInfoType;
import sif.dd.au30.model.CalendarDateInfoType;
import sif.dd.au30.model.CalendarDateType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.CalendarDate;
import sif3.hits.domain.model.CalendarDateTypeOtherCode;

@Component
public class CalendarDateConverter extends HitsConverter<CalendarDateType, CalendarDate> {

  @Autowired
  private CalendarDateTypeOtherCodeConverter calendarDateTypeOtherCodeConverter;

  public CalendarDateConverter() {
    super(CalendarDateType.class, CalendarDate.class);
  }

  @Override
  public void toSifModel(CalendarDate source, CalendarDateType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setCalendarSummaryRefId(source.getCalendarSummaryRefId());
      target.setDate(getDateValue(source.getCalendarDate()));
      target.setCalendarDateRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));

      CalendarDateInfoType calendarDateType = objectFactory.createCalendarDateInfoType();
      calendarDateType.setCode(getEnumValue(source.getTypeCode(), AUCodeSetsCalendarEventType.class));

      OtherCodeListType otherCodeListType = objectFactory.createOtherCodeListType();
      List<OtherCode> otherCodes = calendarDateTypeOtherCodeConverter.toSifModelList(source.getCalendarDateTypeOtherCodes());
      otherCodeListType.getOtherCode().addAll(otherCodes);
      if (otherCodes != null && !otherCodes.isEmpty()) {
        calendarDateType.setOtherCodeList(objectFactory.createCalendarDateInfoTypeOtherCodeList(otherCodeListType));
      }

      target.setCalendarDateType(calendarDateType);
      target.setCalendarDateNumber(objectFactory.createCalendarDateTypeCalendarDateNumber(getLongValue(source.getNumber())));

      if (source.getStudentAttendanceAttendanceValue() != null && source.getStudentAttendanceCountsTowardsAttendance() != null) {
        AttendanceInfoType studentAttendance = objectFactory.createAttendanceInfoType();
        studentAttendance.setAttendanceValue(getBigDecimalValue(source.getStudentAttendanceAttendanceValue()));
        studentAttendance.setCountsTowardAttendance(source.getStudentAttendanceCountsTowardsAttendance());
        target.setStudentAttendance(objectFactory.createCalendarDateTypeStudentAttendance(studentAttendance));
      }
    }
  }

  @Override
  public void toHitsModel(CalendarDateType source, CalendarDate target) {
    if (source != null && target != null) {
      target.setCalendarSummaryRefId(source.getCalendarSummaryRefId());
      target.setCalendarDate(getDateValue(source.getDate()));
      target.setRefId(source.getCalendarDateRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));

      CalendarDateInfoType calendarDateType = source.getCalendarDateType();
      if (calendarDateType != null) {
        target.setTypeCode(getEnumValue(calendarDateType.getCode()));
        if (target.getCalendarDateTypeOtherCodes() == null) {
          target.setCalendarDateTypeOtherCodes(new HashSet<CalendarDateTypeOtherCode>());
        } else {
          target.getCalendarDateTypeOtherCodes().clear();
        }
        
        OtherCodeListType otherCodeList = getJAXBValue(calendarDateType.getOtherCodeList());
        if (otherCodeList != null) {
          List<CalendarDateTypeOtherCode> otherCodes = calendarDateTypeOtherCodeConverter.toHitsModelList(otherCodeList.getOtherCode());
          for (CalendarDateTypeOtherCode otherCode : otherCodes) {
            otherCode.setCalendarDate(target);
          }
          target.getCalendarDateTypeOtherCodes().addAll(otherCodes);
        }
      }
      target.setNumber(getLongValue(getJAXBValue(source.getCalendarDateNumber())));
      AttendanceInfoType studentAttendance = getJAXBValue(source.getStudentAttendance());
      if (studentAttendance != null) {
        target.setStudentAttendanceAttendanceValue(getBigDecimalValue(studentAttendance.getAttendanceValue()));
        target.setStudentAttendanceCountsTowardsAttendance(studentAttendance.getCountsTowardAttendance());
      }
    }
  }
}
