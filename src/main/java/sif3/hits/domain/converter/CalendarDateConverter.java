package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CalendarDate.CalendarDateType;
import sif.dd.au30.model.CalendarDate.StudentAttendance;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.CalendarDate;
import sif3.hits.domain.model.CalendarDateTypeOtherCode;

@Component
public class CalendarDateConverter extends HitsConverter<sif.dd.au30.model.CalendarDate, CalendarDate> {

  @Autowired
  private CalendarDateTypeOtherCodeConverter calendarDateTypeOtherCodeConverter;

  public CalendarDateConverter() {
    super(sif.dd.au30.model.CalendarDate.class, CalendarDate.class);
  }

  @Override
  public void toSifModel(CalendarDate source, sif.dd.au30.model.CalendarDate target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setCalendarSummaryRefId(source.getCalendarSummaryRefId());
      target.setDate(getDateValue(source.getCalendarDate()));
      target.setCalendarDateRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));

      CalendarDateType calendarDateType = objectFactory.createCalendarDateCalendarDateType();
      calendarDateType.setCode(source.getTypeCode());

      OtherCodeListType otherCodeListType = objectFactory.createOtherCodeListType();
      List<OtherCode> otherCodes = calendarDateTypeOtherCodeConverter.toSifModelList(source.getCalendarDateTypeOtherCodes());
      otherCodeListType.getOtherCode().addAll(otherCodes);
      calendarDateType.setOtherCodeList(objectFactory.createCalendarDateCalendarDateTypeOtherCodeList(otherCodeListType));

      target.setCalendarDateType(calendarDateType);
      target.setCalendarDateNumber(objectFactory.createCalendarDateCalendarDateNumber(getLongValue(source.getNumber())));

      StudentAttendance studentAttendance = null;
      if (source.getStudentAttendanceAttendanceValue() != null && source.getStudentAttendanceCountsTowardsAttendance() != null) {
        studentAttendance = new StudentAttendance();
        studentAttendance.setAttendanceValue(getBigDecimalValue(source.getStudentAttendanceAttendanceValue()));
        studentAttendance.setCountsTowardAttendance(source.getStudentAttendanceCountsTowardsAttendance());
        target.setStudentAttendance(objectFactory.createCalendarDateStudentAttendance(studentAttendance));
      }
    }
  }

  @Override
  public void toHitsModel(sif.dd.au30.model.CalendarDate source, CalendarDate target) {
    if (source != null && target != null) {
      target.setCalendarSummaryRefId(source.getCalendarSummaryRefId());
      target.setCalendarDate(getDateValue(source.getDate()));
      target.setRefId(source.getCalendarDateRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));

      CalendarDateType calendarDateType = source.getCalendarDateType();
      if (calendarDateType != null) {
        target.setTypeCode(calendarDateType.getCode());

        OtherCodeListType otherCodeList = getJAXBValue(calendarDateType.getOtherCodeList());
        if (otherCodeList != null) {
          List<CalendarDateTypeOtherCode> otherCodes = calendarDateTypeOtherCodeConverter.toHitsModelList(otherCodeList.getOtherCode());
          target.setCalendarDateTypeOtherCodes(new HashSet<CalendarDateTypeOtherCode>(otherCodes));
        }
      }
      target.setNumber(getLongValue(getJAXBValue(source.getCalendarDateNumber())));
      StudentAttendance studentAttendance = getJAXBValue(source.getStudentAttendance());
      if (studentAttendance != null) {
        target.setStudentAttendanceAttendanceValue(getBigDecimalValue(studentAttendance.getAttendanceValue()));
        target.setStudentAttendanceCountsTowardsAttendance(studentAttendance.getCountsTowardAttendance());
      }
    }
  }
}
